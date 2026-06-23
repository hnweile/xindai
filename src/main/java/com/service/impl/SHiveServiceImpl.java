package com.service.impl;

import com.service.SHiveService;
import org.apache.commons.lang.StringUtils;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

@Service("sHiveService")
public class SHiveServiceImpl implements SHiveService {

    private static final String HIVE_DRIVER = "org.apache.hive.jdbc.HiveDriver";
    private static final String HIVE_URL = "jdbc:hive2://localhost:10000/default";
    private static final String HIVE_USER = System.getProperty("user.name");
    private static final String HIVE_PASSWORD = "123456";
    private static Statement stmt = null;
    private static final Set<String> ignoreFields = new HashSet<>();

    @Resource
    private JavaSparkContext javaSparkContext;

    static {
        ignoreFields.add("serialVersionUID");
        if (null == stmt) {
            try {
                Connection conn = DriverManager.getConnection(HIVE_URL, HIVE_USER, HIVE_PASSWORD);
                stmt = conn.createStatement();
            } catch (Exception e) {
                System.out.println("Hive 连接失败！" + e);
            }

        }
    }

    @Override
    public <T> void init(String dbName, String tableName, List<T> dataList) throws Exception {
        createTableFromList(dbName, tableName, dataList);
        insertDataFromList(dbName, tableName, clean(dataList));
    }

    @Override
    public void value(String dbName, String tableName, String xColumnName, String timeType, String where, String... yColumnNames) throws Exception {
        List<List<Map<String, Object>>> list = new LinkedList<>();
        for (String yColumnName : yColumnNames) {
            if (StringUtils.isBlank(yColumnName)) {
                continue;
            }
            String formattedXColumn = xColumnName;
            String groupBy = " GROUP BY " + xColumnName;
            if (StringUtils.isNotBlank(timeType)) {
                switch (timeType) {
                    case "年":
                        formattedXColumn = "DATE_FORMAT(" + xColumnName + ", 'yyyy')" ;
                        groupBy = " GROUP BY " + formattedXColumn;
                        break;
                    case "月":
                        formattedXColumn = "DATE_FORMAT(" + xColumnName + ", 'yyyy-MM')" ;
                        groupBy = " GROUP BY " + formattedXColumn;
                        break;
                    case "日":
                        formattedXColumn = "DATE_FORMAT(" + xColumnName + ", 'yyyy-MM-dd')" ;
                        groupBy = " GROUP BY " + formattedXColumn;
                        break;
                }
            }
            String sql = "SELECT " + formattedXColumn + " AS `" + xColumnName + "`, ROUND(SUM(" + yColumnName + "), 2) AS `total` FROM " + tableName;
            sql += (StringUtils.isNotBlank(where) ? " WHERE " + where : "") + groupBy;
            list.add(batchQuery(dbName, sql));
        }
        write("/value_" + tableName + "_" + xColumnName + "_" + String.join(",", yColumnNames) + "_" + timeType + ".json", list);
    }


    @Override
    public void group(String dbName, String tableName, String columnName, String where) throws Exception {
        String sql = "select " + columnName + ", count(1) AS total from " + tableName + " GROUP BY  " + columnName;
        //String where = " ";
        sql += where;
        write("/group_" + tableName + "_" + columnName + "_timeType" + ".json", batchQuery(dbName, sql));
    }

    private void write(String path, List list) throws Exception {
        if (!CollectionUtils.isEmpty(list)) {
            // 使用ObjectMapper将数据列表转换为JSON格式
            ObjectMapper mapper1 = new ObjectMapper();
            mapper1.enable(SerializationFeature.INDENT_OUTPUT); // 可选，用于格式化输出
            String localJsonFilePath = System.getProperty("user.dir") + path;
            try {
                Files.delete(Paths.get(localJsonFilePath));
            } catch (IOException e) {

            }
            // 将JSON字符串写入本地文件
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(localJsonFilePath), StandardCharsets.UTF_8))) {
                String jsonContent = mapper1.writeValueAsString(list.size() > 1 ? list : list.get(0));
                writer.write(jsonContent);
            }
        }
    }

    @Override
    public void createDatabase(String dbName) throws Exception {
        stmt.execute("DROP DATABASE IF EXISTS " + dbName + " CASCADE");
        stmt.execute("CREATE DATABASE " + dbName);
    }

    public List<Map<String, Object>> batchQuery(String dbName, String query) throws Exception {
        List<Map<String, Object>> results = new ArrayList<>();
        stmt.execute("USE " + dbName);
        try (ResultSet rs = stmt.executeQuery(query)) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                Map<String, Object> row = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    row.put(columnName.substring(columnName.lastIndexOf('.') + 1), rs.getObject(i));
                }
                results.add(row);
            }

        }
        return results;
    }

    public <T> void createTableFromList(String dbName, String tableName, List<T> dataList) throws Exception {
        if (dataList.isEmpty()) {
            throw new IllegalArgumentException("Data list cannot be empty.");
        }
        T firstItem = dataList.get(0);
        Field[] fields = firstItem.getClass().getDeclaredFields();

        StringBuilder createTableSQL = new StringBuilder("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (");

        for (Field field : fields) {
            field.setAccessible(true); // 设置私有属性可访问
            String fieldName = field.getName();
            String fieldType = field.getType().getSimpleName().toUpperCase();
            if (!ignoreFields.contains(fieldName)) {
                createTableSQL.append(fieldName).append(" ").append(mapFieldType(fieldType)).append(", ");
            }

        }
        createTableSQL.setLength(createTableSQL.length() - 2); // 移除最后一个逗号
        createTableSQL.append(")");

        stmt.execute("USE " + dbName);
        stmt.execute("DROP TABLE IF EXISTS " + tableName);
        stmt.execute(createTableSQL.toString());
    }

    private String mapFieldType(String fieldType) {
        switch (fieldType) {
            case "LONG":
                return "BIGINT";
            case "INT":
                return "INT";
            case "STRING":
                return "STRING";
            case "BOOLEAN":
                return "BOOLEAN";
            case "FLOAT":
                return "FLOAT";
            case "DOUBLE":
                return "DOUBLE";
            // 添加其他类型映射
            default:
                return "STRING";
        }
    }

    public <T> void insertDataFromList(String dbName, String tableName, List<T> dataList) throws Exception {
        if (dataList.isEmpty()) {
            throw new IllegalArgumentException("Data list cannot be empty.");
        }
        T firstItem = dataList.get(0);
        Field[] fields = firstItem.getClass().getDeclaredFields();

        StringBuilder insertSQL = new StringBuilder("INSERT INTO ").append(tableName).append(" (");
        StringBuilder valueSQL = new StringBuilder("VALUES ");

        for (Field field : fields) {
            field.setAccessible(true); // 设置私有属性可访问
            String fieldName = field.getName();
            // 跳过忽略的字段
            if (!ignoreFields.contains(fieldName)) {
                insertSQL.append(fieldName).append(", ");
            }
        }
        insertSQL.setLength(insertSQL.length() - 2); // 移除最后一个逗号
        insertSQL.append(") ");

        for (T item : dataList) {
            valueSQL.append("(");
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                // 跳过忽略的字段
                if (!ignoreFields.contains(fieldName)) {
                    Object value = field.get(item);
                    if (value instanceof String) {
                        valueSQL.append("'").append(value).append("', ");
                    } else if (value instanceof Date) {
                        // 将Date转换为Hive可以理解的TIMESTAMP类型
                        valueSQL.append("TIMESTAMP '").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value)).append("', ");
                    } else {
                        valueSQL.append(value).append(", ");
                    }
                }
            }
            valueSQL.setLength(valueSQL.length() - 2); // 移除最后一个逗号
            valueSQL.append("), ");
        }
        valueSQL.setLength(valueSQL.length() - 2); // 移除最后一个逗号
        stmt.execute("USE " + dbName);
        stmt.execute(insertSQL.toString() + valueSQL.toString());

    }

    /**
 * 数据清洗
 *
 * @param dataList
 * @param <T>
 */
    public <T> List<T>  clean(List<T> dataList) {
        // 将Java List转换为Java RDD
        JavaRDD<T> dataRDD = javaSparkContext.parallelize(dataList);
        // 过滤掉为null的数据项
        JavaRDD<T> cleanedRDD = dataRDD.filter(rdd -> rdd != null);
        return cleanedRDD.collect();
    }
}
