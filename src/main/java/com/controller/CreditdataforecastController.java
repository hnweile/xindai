package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.CreditdataforecastEntity;
import com.entity.view.CreditdataforecastView;

import com.service.CreditdataforecastService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.service.CreditdataService;
import com.entity.CreditdataEntity;
import java.text.DecimalFormat;
import weka.core.*;
import java.util.*;
import java.util.stream.Stream;
import weka.classifiers.trees.RandomForest;

/**
 * 信贷数据
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
@RestController
@RequestMapping("/creditdataforecast")
public class CreditdataforecastController {
    @Autowired
    private CreditdataforecastService creditdataforecastService;
    @Autowired
    private CreditdataService creditdataService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CreditdataforecastEntity creditdataforecast,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CreditdataforecastEntity> ew = new EntityWrapper<CreditdataforecastEntity>();


        //查询结果
		PageUtils page = creditdataforecastService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, creditdataforecast), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CreditdataforecastEntity creditdataforecast, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CreditdataforecastEntity> ew = new EntityWrapper<CreditdataforecastEntity>();

        //查询结果
		PageUtils page = creditdataforecastService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, creditdataforecast), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CreditdataforecastEntity creditdataforecast){
       	EntityWrapper<CreditdataforecastEntity> ew = new EntityWrapper<CreditdataforecastEntity>();
      	ew.allEq(MPUtil.allEQMapPre( creditdataforecast, "creditdataforecast")); 
        return R.ok().put("data", creditdataforecastService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CreditdataforecastEntity creditdataforecast){
        EntityWrapper< CreditdataforecastEntity> ew = new EntityWrapper< CreditdataforecastEntity>();
 		ew.allEq(MPUtil.allEQMapPre( creditdataforecast, "creditdataforecast")); 
		CreditdataforecastView creditdataforecastView =  creditdataforecastService.selectView(ew);
		return R.ok("查询信贷数据成功").put("data", creditdataforecastView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CreditdataforecastEntity creditdataforecast = creditdataforecastService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(creditdataforecast,deSens);
        return R.ok().put("data", creditdataforecast);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CreditdataforecastEntity creditdataforecast = creditdataforecastService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(creditdataforecast,deSens);
        return R.ok().put("data", creditdataforecast);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CreditdataforecastEntity creditdataforecast, HttpServletRequest request){
        //ValidatorUtils.validateEntity(creditdataforecast);
        creditdataforecastService.insert(creditdataforecast);
        return R.ok().put("data",creditdataforecast.getId());
    }
    
    /**
     * 前台保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody CreditdataforecastEntity creditdataforecast, HttpServletRequest request){
        //ValidatorUtils.validateEntity(creditdataforecast);
        creditdataforecastService.insert(creditdataforecast);
        return R.ok().put("data",creditdataforecast.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CreditdataforecastEntity creditdataforecast, HttpServletRequest request){
        //ValidatorUtils.validateEntity(creditdataforecast);
        //全部更新
        creditdataforecastService.updateById(creditdataforecast);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        creditdataforecastService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    





    /**
    * 文件导入
    */
    @RequestMapping("/importExcel")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rowTotal=sheet.getPhysicalNumberOfRows();
            if(rowTotal > 1) {
                //获取单元格
                for (int i = 1; i < rowTotal; i++) {
                    Row row = sheet.getRow(i);
                    CreditdataforecastEntity creditdataforecastEntity =new CreditdataforecastEntity();
                    creditdataforecastEntity.setId(new Date().getTime());
                    String number = CommonUtil.getCellValue(row.getCell(0));
                    creditdataforecastEntity.setNumber(number);
                    String age = CommonUtil.getCellValue(row.getCell(1));
                    creditdataforecastEntity.setAge(Integer.parseInt(age));
                    String annualincome = CommonUtil.getCellValue(row.getCell(2));
                    creditdataforecastEntity.setAnnualincome(Integer.parseInt(annualincome));
                    String totalassets = CommonUtil.getCellValue(row.getCell(3));
                    creditdataforecastEntity.setTotalassets(Double.parseDouble(totalassets));
                    String totalliabilities = CommonUtil.getCellValue(row.getCell(4));
                    creditdataforecastEntity.setTotalliabilities(Double.parseDouble(totalliabilities));
                    String creditlimit = CommonUtil.getCellValue(row.getCell(5));
                    creditdataforecastEntity.setCreditlimit(Double.parseDouble(creditlimit));
                    String loanamount = CommonUtil.getCellValue(row.getCell(6));
                    creditdataforecastEntity.setLoanamount(Double.parseDouble(loanamount));
                    //向数据库中添加新对象
                    creditdataforecastService.insert(creditdataforecastEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }



    /**
    * 预测算法
    */
    @RequestMapping("/forecast")
    public R forecast(@RequestBody Map<String, Object> params) throws Exception {
        // 特征值
        String[] eigenValueArr = "number,age,annualincome,totalassets,creditscore,totalliabilities,creditlimit".split(",");
        // 目标值
        String[] targetValueArr = "loanamount".split(",");
        String[] sqlSelectArr = Stream.of(eigenValueArr, targetValueArr).flatMap(Arrays::stream).toArray(String[]::new);
        // 模型训练
        Wrapper<CreditdataEntity> wrapper = new EntityWrapper<>();
        wrapper.setSqlSelect(sqlSelectArr);
        for (String arr : sqlSelectArr) {
            wrapper.isNotNull(arr).ne(arr, "");
        }
        // 从数据库获取需要元数据
        List<Map<String,Object>> list =creditdataService.selectMaps(wrapper);
        // 模型训练
        Instances instances = createInstances(list, sqlSelectArr);

        // 创建一个map来存储预测结果
        Map<String, Object> forecastRes = forecastRes(instances, params, eigenValueArr, targetValueArr);

        // 更新数据库或其他操作
        EntityWrapper<CreditdataforecastEntity> ew = new EntityWrapper<>();
        ew.eq("id", params.get("id"));
        for (Map.Entry<String, Object> entry : forecastRes.entrySet()) {
            String updateSet = entry.getKey() + "='" + entry.getValue().toString() + "'";
            creditdataforecastService.updateForSet(updateSet, ew);
        }
        params.putAll(forecastRes);
        return R.ok(params);
    }

    /**
     * 预测结果
     * @param instances
     * @param params
     * @param eigenValueArr
     * @param targetValueArr
     * @return
     * @throws Exception
     */
    private Map<String, Object> forecastRes(Instances instances, Map<String, Object> params, String[] eigenValueArr, String[] targetValueArr) throws Exception {
        Map<String, Object> forecastRes = new HashMap<>();
        // 预测结果
        // 创建一个与训练数据集结构相同的 Instance
        double[] instanceValue = new double[instances.numAttributes()];
        int x = 0;
        for (String attr : eigenValueArr) {
            if (instances.attribute(attr).isNominal()) {
                // 对于名义属性，使用indexOfValue
                double res = instances.attribute(attr).indexOfValue(params.get(attr).toString());
                instanceValue[x++] = res == -1 ? instances.attribute(attr).indexOfValue("unknown") : res; // 如果值不存在，使用Double.NaN
            } else {
                // 对于数值属性，直接使用数值
                instanceValue[x++] = Double.parseDouble(params.get(attr).toString());
            }
        }
        for (String attr : targetValueArr) {
            instanceValue[x++] = Double.NaN;
        }

        Instance instance = new DenseInstance(1.0, instanceValue);
        instance.setDataset(instances);

        for (int i = 0; i < targetValueArr.length; i++) {
            // 设置类属性索引为当前目标属性
            instances.setClassIndex(instances.numAttributes() - targetValueArr.length + i);

            // 创建并训练随机森林模型
            RandomForest randomForest = new RandomForest();
            randomForest.buildClassifier(instances);

            // 为预测创建一个新的实例
            double[] instanceValueForPrediction = Arrays.copyOf(instanceValue, instanceValue.length);
            instanceValueForPrediction[instances.numAttributes() - targetValueArr.length + i] = Double.NaN; // 设置目标属性为缺失值

            Instance instanceForPrediction = new DenseInstance(1.0, instanceValueForPrediction);
            instanceForPrediction.setDataset(instances);

            // 进行预测
            double predictedValue = randomForest.classifyInstance(instanceForPrediction);
            if (instances.classAttribute().isNominal()) {
                // 如果是名义属性，获取预测的类别名称
                String predictedClassName = instances.classAttribute().value((int) predictedValue);
                forecastRes.put(targetValueArr[i], predictedClassName);
            } else {
                // 如果是数值属性，直接使用预测值
                DecimalFormat df = new DecimalFormat("#.00");
                double formattedPredictedValue = Double.parseDouble(df.format(predictedValue));
                forecastRes.put(targetValueArr[i], formattedPredictedValue);
            }
        }
        return forecastRes;
    }

    /**
    * 训练模型
    */
    private Instances createInstances(List<Map<String, Object>> dataList, String[] attrs) throws Exception {
        // 遍历数据集以确定每个属性的类型
        Map<String, Set<Object>> uniqueValuesPerAttribute = new HashMap<>();
        for (Map<String, Object> data : dataList) {
            for (String attr : attrs) {
                uniqueValuesPerAttribute.computeIfAbsent(attr, k -> new HashSet<>()).add(data.get(attr));
            }
        }
        FastVector attributes = new FastVector();
        for (String attr : attrs) {
            Set<Object> uniqueValues = uniqueValuesPerAttribute.get(attr);
            if (isNominal(uniqueValues)) {
                // 如果是分类属性，创建分类属性
                FastVector nominalValues = new FastVector();
                uniqueValues.forEach(value -> nominalValues.addElement(value));
                nominalValues.add("unknown");
                attributes.addElement(new Attribute(attr, nominalValues));
            } else {
                attributes.addElement(new Attribute(attr));
            }
        }

        // 创建 Instances 对象
        Instances dataset = new Instances("dataset-name", attributes, dataList.size());
        dataset.setClassIndex(dataset.numAttributes() - 1); // 设置类属性索引
        // 填充数据
        for (Map<String, Object> data : dataList) {
            double[] instanceValue = new double[dataset.numAttributes()];
            int i = 0;
            for (String attr : attrs) {
                Attribute attribute = dataset.attribute(attr);
                if (attribute.isNominal()) {
                    instanceValue[i++] = attribute.indexOfValue(data.get(attr).toString());
                } else {
                    instanceValue[i++] = Double.parseDouble(data.get(attr).toString());
                }
            }
            Instance instance = new DenseInstance(1.0, instanceValue);
            dataset.add(instance);
        }
        return dataset;
    }

    /**
    * 检测数据类型是否为字符串
    */
    private boolean isNominal(Set<Object> values) {
        // 检查是否所有的值都是字符串，并且数量是否超过某个阈值（例如，如果超过50%的值是唯一的，则可能是分类属性）
        return values.stream().allMatch(v -> v instanceof String);
    }
    /**
     * 数据清洗
     *
     * @return
     */
    @RequestMapping("/cleanse")
    public R cleanse() throws NoSuchFieldException {
        // 获取数据集合
        List<CreditdataforecastEntity> list = creditdataforecastService.selectList(new EntityWrapper<CreditdataforecastEntity>());
        // 过滤掉Number的记录，删除重复的，并且只保留每个Number的一条记录
        Map<String, CreditdataforecastEntity> uniqueEntity = list.stream().collect(Collectors.toMap(CreditdataforecastEntity::getNumber,n -> n, (existing, replacement) -> existing));
        list = new ArrayList<>(uniqueEntity.values());
        // 当Age是空时，将从list中获取非空的Age随机获取一个放到空值中
        for (CreditdataforecastEntity entity : list) {
            if (org.springframework.util.StringUtils.isEmpty(entity.getAge())) {
                List<CreditdataforecastEntity> nonNullList = list.stream().filter(n -> !org.springframework.util.StringUtils.isEmpty(n.getAge())).collect(Collectors.toList());
                if (!nonNullList.isEmpty()) {
                    // 创建一个随机数生成器
                    Random random = new Random();
                    entity.setAge(nonNullList.get(random.nextInt(nonNullList.size())).getAge());
                }
            }
        }
        // 当Annualincome是空时，将从list中获取非空的Annualincome随机获取一个放到空值中
        for (CreditdataforecastEntity entity : list) {
            if (org.springframework.util.StringUtils.isEmpty(entity.getAnnualincome())) {
                List<CreditdataforecastEntity> nonNullList = list.stream().filter(n -> !org.springframework.util.StringUtils.isEmpty(n.getAnnualincome())).collect(Collectors.toList());
                if (!nonNullList.isEmpty()) {
                    // 创建一个随机数生成器
                    Random random = new Random();
                    entity.setAnnualincome(nonNullList.get(random.nextInt(nonNullList.size())).getAnnualincome());
                }
            }
        }
        // 删除全部数据
        creditdataforecastService.delete(new EntityWrapper<>());
        // 如果清洗后还存在数据，则批量增加回去
        if (!list.isEmpty() && list.size() > 0) {
            creditdataforecastService.insertBatch(list);
        }
        return R.ok();
    }
}
