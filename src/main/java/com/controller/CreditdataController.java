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

import com.entity.CreditdataEntity;
import com.entity.view.CreditdataView;

import com.service.CreditdataService;
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

/**
 * 信贷数据
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
@RestController
@RequestMapping("/creditdata")
public class CreditdataController {
    @Autowired
    private CreditdataService creditdataService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CreditdataEntity creditdata,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CreditdataEntity> ew = new EntityWrapper<CreditdataEntity>();


        //查询结果
		PageUtils page = creditdataService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, creditdata), params), params));
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
    public R list(@RequestParam Map<String, Object> params,CreditdataEntity creditdata, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<CreditdataEntity> ew = new EntityWrapper<CreditdataEntity>();

        //查询结果
		PageUtils page = creditdataService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, creditdata), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CreditdataEntity creditdata){
       	EntityWrapper<CreditdataEntity> ew = new EntityWrapper<CreditdataEntity>();
      	ew.allEq(MPUtil.allEQMapPre( creditdata, "creditdata")); 
        return R.ok().put("data", creditdataService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CreditdataEntity creditdata){
        EntityWrapper< CreditdataEntity> ew = new EntityWrapper< CreditdataEntity>();
 		ew.allEq(MPUtil.allEQMapPre( creditdata, "creditdata")); 
		CreditdataView creditdataView =  creditdataService.selectView(ew);
		return R.ok("查询信贷数据成功").put("data", creditdataView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CreditdataEntity creditdata = creditdataService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(creditdata,deSens);
        return R.ok().put("data", creditdata);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CreditdataEntity creditdata = creditdataService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(creditdata,deSens);
        return R.ok().put("data", creditdata);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CreditdataEntity creditdata, HttpServletRequest request){
        //ValidatorUtils.validateEntity(creditdata);
        creditdataService.insert(creditdata);
        return R.ok().put("data",creditdata.getId());
    }
    
    /**
     * 前台保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody CreditdataEntity creditdata, HttpServletRequest request){
        //ValidatorUtils.validateEntity(creditdata);
        creditdataService.insert(creditdata);
        return R.ok().put("data",creditdata.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody CreditdataEntity creditdata, HttpServletRequest request){
        //ValidatorUtils.validateEntity(creditdata);
        //全部更新
        creditdataService.updateById(creditdata);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        creditdataService.deleteBatchIds(Arrays.asList(ids));
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
                    CreditdataEntity creditdataEntity =new CreditdataEntity();
                    creditdataEntity.setId(new Date().getTime());
                    String number = CommonUtil.getCellValue(row.getCell(0));
                    creditdataEntity.setNumber(number);
                    String gender = CommonUtil.getCellValue(row.getCell(1));
                    creditdataEntity.setGender(gender);
                    String age = CommonUtil.getCellValue(row.getCell(2));
                    creditdataEntity.setAge(Integer.parseInt(age));
                    String area = CommonUtil.getCellValue(row.getCell(3));
                    creditdataEntity.setArea(area);
                    String educationlevel = CommonUtil.getCellValue(row.getCell(4));
                    creditdataEntity.setEducationlevel(educationlevel);
                    String maritalstatus = CommonUtil.getCellValue(row.getCell(5));
                    creditdataEntity.setMaritalstatus(maritalstatus);
                    String householdsize = CommonUtil.getCellValue(row.getCell(6));
                    creditdataEntity.setHouseholdsize(Integer.parseInt(householdsize));
                    String annualincome = CommonUtil.getCellValue(row.getCell(7));
                    creditdataEntity.setAnnualincome(Integer.parseInt(annualincome));
                    String monthlyincome = CommonUtil.getCellValue(row.getCell(8));
                    creditdataEntity.setMonthlyincome(Integer.parseInt(monthlyincome));
                    String career = CommonUtil.getCellValue(row.getCell(9));
                    creditdataEntity.setCareer(career);
                    String yearsofservice = CommonUtil.getCellValue(row.getCell(10));
                    creditdataEntity.setYearsofservice(Integer.parseInt(yearsofservice));
                    String totalassets = CommonUtil.getCellValue(row.getCell(11));
                    creditdataEntity.setTotalassets(Double.parseDouble(totalassets));
                    String totalliabilities = CommonUtil.getCellValue(row.getCell(12));
                    creditdataEntity.setTotalliabilities(Double.parseDouble(totalliabilities));
                    String debtratio = CommonUtil.getCellValue(row.getCell(13));
                    creditdataEntity.setDebtratio(debtratio);
                    String creditlimit = CommonUtil.getCellValue(row.getCell(14));
                    creditdataEntity.setCreditlimit(Double.parseDouble(creditlimit));
                    String creditcardusagerate = CommonUtil.getCellValue(row.getCell(15));
                    creditdataEntity.setCreditcardusagerate(creditcardusagerate);
                    String creditscore = CommonUtil.getCellValue(row.getCell(16));
                    creditdataEntity.setCreditscore(Integer.parseInt(creditscore));
                    String credithistorylength = CommonUtil.getCellValue(row.getCell(17));
                    creditdataEntity.setCredithistorylength(credithistorylength);
                    String numberofoverduetimes = CommonUtil.getCellValue(row.getCell(18));
                    creditdataEntity.setNumberofoverduetimes(Integer.parseInt(numberofoverduetimes));
                    String seriousoverduetimes = CommonUtil.getCellValue(row.getCell(19));
                    creditdataEntity.setSeriousoverduetimes(Integer.parseInt(seriousoverduetimes));
                    String overdueamount = CommonUtil.getCellValue(row.getCell(20));
                    creditdataEntity.setOverdueamount(Double.parseDouble(overdueamount));
                    String overduedays = CommonUtil.getCellValue(row.getCell(21));
                    creditdataEntity.setOverduedays(Integer.parseInt(overduedays));
                    String creditinquiryfrequency = CommonUtil.getCellValue(row.getCell(22));
                    creditdataEntity.setCreditinquiryfrequency(Integer.parseInt(creditinquiryfrequency));
                    String loanamount = CommonUtil.getCellValue(row.getCell(23));
                    creditdataEntity.setLoanamount(Double.parseDouble(loanamount));
                    String loanterm = CommonUtil.getCellValue(row.getCell(24));
                    creditdataEntity.setLoanterm(loanterm);
                    String lendingrate = CommonUtil.getCellValue(row.getCell(25));
                    creditdataEntity.setLendingrate(lendingrate);
                    String repaymentmethod = CommonUtil.getCellValue(row.getCell(26));
                    creditdataEntity.setRepaymentmethod(repaymentmethod);
                    String loanpurpose = CommonUtil.getCellValue(row.getCell(27));
                    creditdataEntity.setLoanpurpose(loanpurpose);
                    String remainingloanterm = CommonUtil.getCellValue(row.getCell(28));
                    creditdataEntity.setRemainingloanterm(remainingloanterm);
                    //向数据库中添加新对象
                    creditdataService.insert(creditdataEntity);//方法
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
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_creditdata_" + xColumnName + "_" + yColumnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        //构建查询统计条件
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<CreditdataEntity> ew = new EntityWrapper<CreditdataEntity>();
            //获取结果
        List<Map<String, Object>> result = creditdataService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        Collections.sort(result, (map1, map2) -> {
            // 假设 total 总是存在并且是数值类型
            Number total1 = (Number) map1.get("total");
            Number total2 = (Number) map2.get("total");
            if(total1==null)
            {
                total1 = 0;
            }
            if(total2==null)
            {
                total2 = 0;
            }
            return Double.compare(total2.doubleValue(), total1.doubleValue());
        });
        return R.ok().put("data", result);
    }
    
    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul,HttpServletRequest request)  throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_creditdata_" + xColumnName + "_" + yColumnNameMul + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //构建查询统计条件
        EntityWrapper<CreditdataEntity> ew = new EntityWrapper<CreditdataEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = creditdataService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
    
    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_creditdata_" + xColumnName + "_" + yColumnName + "_"+timeStatType+".json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        //构建查询统计条件
        EntityWrapper<CreditdataEntity> ew = new EntityWrapper<CreditdataEntity>();
        List<Map<String, Object>> result = creditdataService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }
    
    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) throws IOException
    {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_creditdata_" + xColumnName + "_" + yColumnNameMul + "_" + timeStatType + ".json");
        if (java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //构建查询统计条件
        EntityWrapper<CreditdataEntity> ew = new EntityWrapper<CreditdataEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = creditdataService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
    
    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("group_creditdata_" + columnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)){
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        //构建查询统计条件
        EntityWrapper<CreditdataEntity> ew = new EntityWrapper<CreditdataEntity>();
        List<Map<String, Object>> result = creditdataService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }    

    /**
     * 分段统计
     */
    @RequestMapping("/sectionStat/age")
    @IgnoreAuth
    public R ageSectionStat(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        EntityWrapper<CreditdataEntity> ew = new EntityWrapper<CreditdataEntity>();
        List<Map<String, Object>> result = creditdataService.ageSectionStat(params, ew);
        return R.ok().put("data", result);
    }



    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,CreditdataEntity creditdata, HttpServletRequest request){
        EntityWrapper<CreditdataEntity> ew = new EntityWrapper<CreditdataEntity>();
        int count = creditdataService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, creditdata), params), params));
        return R.ok().put("data", count);
    }

    /**
     * 数据清洗
     *
     * @return
     */
    @RequestMapping("/cleanse")
    public R cleanse() throws NoSuchFieldException {
        // 获取数据集合
        List<CreditdataEntity> list = creditdataService.selectList(new EntityWrapper<CreditdataEntity>());
        // 过滤掉Number的记录，删除重复的，并且只保留每个Number的一条记录
        Map<String, CreditdataEntity> uniqueEntity = list.stream().collect(Collectors.toMap(CreditdataEntity::getNumber,n -> n, (existing, replacement) -> existing));
        list = new ArrayList<>(uniqueEntity.values());
        // 当Gender是空时，将从list中获取非空的Gender随机获取一个放到空值中
        for (CreditdataEntity entity : list) {
            if (org.springframework.util.StringUtils.isEmpty(entity.getGender())) {
                List<CreditdataEntity> nonNullList = list.stream().filter(n -> !org.springframework.util.StringUtils.isEmpty(n.getGender())).collect(Collectors.toList());
                if (!nonNullList.isEmpty()) {
                    // 创建一个随机数生成器
                    Random random = new Random();
                    entity.setGender(nonNullList.get(random.nextInt(nonNullList.size())).getGender());
                }
            }
        }
        // 当Age是空时，将从list中获取非空的Age随机获取一个放到空值中
        for (CreditdataEntity entity : list) {
            if (org.springframework.util.StringUtils.isEmpty(entity.getAge())) {
                List<CreditdataEntity> nonNullList = list.stream().filter(n -> !org.springframework.util.StringUtils.isEmpty(n.getAge())).collect(Collectors.toList());
                if (!nonNullList.isEmpty()) {
                    // 创建一个随机数生成器
                    Random random = new Random();
                    entity.setAge(nonNullList.get(random.nextInt(nonNullList.size())).getAge());
                }
            }
        }
        // 当Area是空时，将从list中获取非空的Area随机获取一个放到空值中
        for (CreditdataEntity entity : list) {
            if (org.springframework.util.StringUtils.isEmpty(entity.getArea())) {
                List<CreditdataEntity> nonNullList = list.stream().filter(n -> !org.springframework.util.StringUtils.isEmpty(n.getArea())).collect(Collectors.toList());
                if (!nonNullList.isEmpty()) {
                    // 创建一个随机数生成器
                    Random random = new Random();
                    entity.setArea(nonNullList.get(random.nextInt(nonNullList.size())).getArea());
                }
            }
        }
        // 当Educationlevel是空时，将从list中获取非空的Educationlevel随机获取一个放到空值中
        for (CreditdataEntity entity : list) {
            if (org.springframework.util.StringUtils.isEmpty(entity.getEducationlevel())) {
                List<CreditdataEntity> nonNullList = list.stream().filter(n -> !org.springframework.util.StringUtils.isEmpty(n.getEducationlevel())).collect(Collectors.toList());
                if (!nonNullList.isEmpty()) {
                    // 创建一个随机数生成器
                    Random random = new Random();
                    entity.setEducationlevel(nonNullList.get(random.nextInt(nonNullList.size())).getEducationlevel());
                }
            }
        }
        // 当Maritalstatus是空时，将从list中获取非空的Maritalstatus随机获取一个放到空值中
        for (CreditdataEntity entity : list) {
            if (org.springframework.util.StringUtils.isEmpty(entity.getMaritalstatus())) {
                List<CreditdataEntity> nonNullList = list.stream().filter(n -> !org.springframework.util.StringUtils.isEmpty(n.getMaritalstatus())).collect(Collectors.toList());
                if (!nonNullList.isEmpty()) {
                    // 创建一个随机数生成器
                    Random random = new Random();
                    entity.setMaritalstatus(nonNullList.get(random.nextInt(nonNullList.size())).getMaritalstatus());
                }
            }
        }
        // 当Householdsize是空时，将从list中获取非空的Householdsize随机获取一个放到空值中
        for (CreditdataEntity entity : list) {
            if (org.springframework.util.StringUtils.isEmpty(entity.getHouseholdsize())) {
                List<CreditdataEntity> nonNullList = list.stream().filter(n -> !org.springframework.util.StringUtils.isEmpty(n.getHouseholdsize())).collect(Collectors.toList());
                if (!nonNullList.isEmpty()) {
                    // 创建一个随机数生成器
                    Random random = new Random();
                    entity.setHouseholdsize(nonNullList.get(random.nextInt(nonNullList.size())).getHouseholdsize());
                }
            }
        }
        // 当Annualincome是空时，将从list中获取非空的Annualincome随机获取一个放到空值中
        for (CreditdataEntity entity : list) {
            if (org.springframework.util.StringUtils.isEmpty(entity.getAnnualincome())) {
                List<CreditdataEntity> nonNullList = list.stream().filter(n -> !org.springframework.util.StringUtils.isEmpty(n.getAnnualincome())).collect(Collectors.toList());
                if (!nonNullList.isEmpty()) {
                    // 创建一个随机数生成器
                    Random random = new Random();
                    entity.setAnnualincome(nonNullList.get(random.nextInt(nonNullList.size())).getAnnualincome());
                }
            }
        }
        // 当Monthlyincome是空时，将从list中获取非空的Monthlyincome随机获取一个放到空值中
        for (CreditdataEntity entity : list) {
            if (org.springframework.util.StringUtils.isEmpty(entity.getMonthlyincome())) {
                List<CreditdataEntity> nonNullList = list.stream().filter(n -> !org.springframework.util.StringUtils.isEmpty(n.getMonthlyincome())).collect(Collectors.toList());
                if (!nonNullList.isEmpty()) {
                    // 创建一个随机数生成器
                    Random random = new Random();
                    entity.setMonthlyincome(nonNullList.get(random.nextInt(nonNullList.size())).getMonthlyincome());
                }
            }
        }
        // 删除全部数据
        creditdataService.delete(new EntityWrapper<>());
        // 如果清洗后还存在数据，则批量增加回去
        if (!list.isEmpty() && list.size() > 0) {
            creditdataService.insertBatch(list);
        }
        return R.ok();
    }
}
