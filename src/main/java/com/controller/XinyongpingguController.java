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

import com.entity.XinyongpingguEntity;
import com.entity.view.XinyongpingguView;

import com.service.XinyongpingguService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 信用评估
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
@RestController
@RequestMapping("/xinyongpinggu")
public class XinyongpingguController {
    @Autowired
    private XinyongpingguService xinyongpingguService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinyongpingguEntity xinyongpinggu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xinyongpinggu.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("fengkongzhuanyuan")) {
			xinyongpinggu.setZhuanyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<XinyongpingguEntity> ew = new EntityWrapper<XinyongpingguEntity>();


        //查询结果
		PageUtils page = xinyongpingguService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinyongpinggu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,XinyongpingguEntity xinyongpinggu, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<XinyongpingguEntity> ew = new EntityWrapper<XinyongpingguEntity>();

        //查询结果
		PageUtils page = xinyongpingguService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinyongpinggu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinyongpingguEntity xinyongpinggu){
       	EntityWrapper<XinyongpingguEntity> ew = new EntityWrapper<XinyongpingguEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinyongpinggu, "xinyongpinggu")); 
        return R.ok().put("data", xinyongpingguService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinyongpingguEntity xinyongpinggu){
        EntityWrapper< XinyongpingguEntity> ew = new EntityWrapper< XinyongpingguEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinyongpinggu, "xinyongpinggu")); 
		XinyongpingguView xinyongpingguView =  xinyongpingguService.selectView(ew);
		return R.ok("查询信用评估成功").put("data", xinyongpingguView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinyongpingguEntity xinyongpinggu = xinyongpingguService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(xinyongpinggu,deSens);
        return R.ok().put("data", xinyongpinggu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinyongpingguEntity xinyongpinggu = xinyongpingguService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(xinyongpinggu,deSens);
        return R.ok().put("data", xinyongpinggu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinyongpingguEntity xinyongpinggu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinyongpinggu);
        xinyongpingguService.insert(xinyongpinggu);
        return R.ok().put("data",xinyongpinggu.getId());
    }
    
    /**
     * 前台保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody XinyongpingguEntity xinyongpinggu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinyongpinggu);
        xinyongpingguService.insert(xinyongpinggu);
        return R.ok().put("data",xinyongpinggu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XinyongpingguEntity xinyongpinggu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinyongpinggu);
        //全部更新
        xinyongpingguService.updateById(xinyongpinggu);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinyongpingguService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
