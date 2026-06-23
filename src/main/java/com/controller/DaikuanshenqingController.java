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

import com.entity.DaikuanshenqingEntity;
import com.entity.view.DaikuanshenqingView;

import com.service.DaikuanshenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 贷款申请
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-11 11:25:57
 */
@RestController
@RequestMapping("/daikuanshenqing")
public class DaikuanshenqingController {
    @Autowired
    private DaikuanshenqingService daikuanshenqingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DaikuanshenqingEntity daikuanshenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			daikuanshenqing.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<DaikuanshenqingEntity> ew = new EntityWrapper<DaikuanshenqingEntity>();


        //查询结果
		PageUtils page = daikuanshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daikuanshenqing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DaikuanshenqingEntity daikuanshenqing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DaikuanshenqingEntity> ew = new EntityWrapper<DaikuanshenqingEntity>();

        //查询结果
		PageUtils page = daikuanshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daikuanshenqing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DaikuanshenqingEntity daikuanshenqing){
       	EntityWrapper<DaikuanshenqingEntity> ew = new EntityWrapper<DaikuanshenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( daikuanshenqing, "daikuanshenqing")); 
        return R.ok().put("data", daikuanshenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DaikuanshenqingEntity daikuanshenqing){
        EntityWrapper< DaikuanshenqingEntity> ew = new EntityWrapper< DaikuanshenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( daikuanshenqing, "daikuanshenqing")); 
		DaikuanshenqingView daikuanshenqingView =  daikuanshenqingService.selectView(ew);
		return R.ok("查询贷款申请成功").put("data", daikuanshenqingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DaikuanshenqingEntity daikuanshenqing = daikuanshenqingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(daikuanshenqing,deSens);
        return R.ok().put("data", daikuanshenqing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DaikuanshenqingEntity daikuanshenqing = daikuanshenqingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(daikuanshenqing,deSens);
        return R.ok().put("data", daikuanshenqing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DaikuanshenqingEntity daikuanshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daikuanshenqing);
        daikuanshenqingService.insert(daikuanshenqing);
        return R.ok().put("data",daikuanshenqing.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DaikuanshenqingEntity daikuanshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daikuanshenqing);
        daikuanshenqingService.insert(daikuanshenqing);
        return R.ok().put("data",daikuanshenqing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DaikuanshenqingEntity daikuanshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daikuanshenqing);
        //全部更新
        daikuanshenqingService.updateById(daikuanshenqing);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        daikuanshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
