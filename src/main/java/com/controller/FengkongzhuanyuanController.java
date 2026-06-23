package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.entity.TokenEntity;
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

import com.entity.FengkongzhuanyuanEntity;
import com.entity.view.FengkongzhuanyuanView;

import com.service.FengkongzhuanyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 风控专员
 * 后端接口
 * @author 
 * @email 
 * @date 2025-03-11 11:25:57
 */
@RestController
@RequestMapping("/fengkongzhuanyuan")
public class FengkongzhuanyuanController {
    @Autowired
    private FengkongzhuanyuanService fengkongzhuanyuanService;






    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        FengkongzhuanyuanEntity u = fengkongzhuanyuanService.selectOne(new EntityWrapper<FengkongzhuanyuanEntity>().eq("zhuanyuanzhanghao", username));
        // 当用户不存在或验证密码不通过时
		if(u==null || !u.getMima().equals(password)) {
            //账号或密码不正确提示
			return R.error("账号或密码不正确");
		}
		
        // 获取登录token
		String token = tokenService.generateToken(u.getId(), username,"fengkongzhuanyuan",  "风控专员" );
        //返回token
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody FengkongzhuanyuanEntity fengkongzhuanyuan){
    	//ValidatorUtils.validateEntity(fengkongzhuanyuan);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	FengkongzhuanyuanEntity u = fengkongzhuanyuanService.selectOne(new EntityWrapper<FengkongzhuanyuanEntity>().eq("zhuanyuanzhanghao", fengkongzhuanyuan.getZhuanyuanzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同专员账号，否则返回错误信息
        if(fengkongzhuanyuanService.selectCount(new EntityWrapper<FengkongzhuanyuanEntity>().eq("zhuanyuanzhanghao", fengkongzhuanyuan.getZhuanyuanzhanghao()))>0) {
            return R.error("专员账号已存在");
        }
		Long uId = new Date().getTime();
		fengkongzhuanyuan.setId(uId);
        //保存用户
        fengkongzhuanyuanService.insert(fengkongzhuanyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        FengkongzhuanyuanEntity u = fengkongzhuanyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        FengkongzhuanyuanEntity u = fengkongzhuanyuanService.selectOne(new EntityWrapper<FengkongzhuanyuanEntity>().eq("zhuanyuanzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456
        u.setMima("123456");
        fengkongzhuanyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FengkongzhuanyuanEntity fengkongzhuanyuan,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<FengkongzhuanyuanEntity> ew = new EntityWrapper<FengkongzhuanyuanEntity>();


        //查询结果
		PageUtils page = fengkongzhuanyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fengkongzhuanyuan), params), params));
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
    public R list(@RequestParam Map<String, Object> params,FengkongzhuanyuanEntity fengkongzhuanyuan, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<FengkongzhuanyuanEntity> ew = new EntityWrapper<FengkongzhuanyuanEntity>();

        //查询结果
		PageUtils page = fengkongzhuanyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fengkongzhuanyuan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FengkongzhuanyuanEntity fengkongzhuanyuan){
       	EntityWrapper<FengkongzhuanyuanEntity> ew = new EntityWrapper<FengkongzhuanyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fengkongzhuanyuan, "fengkongzhuanyuan")); 
        return R.ok().put("data", fengkongzhuanyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FengkongzhuanyuanEntity fengkongzhuanyuan){
        EntityWrapper< FengkongzhuanyuanEntity> ew = new EntityWrapper< FengkongzhuanyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fengkongzhuanyuan, "fengkongzhuanyuan")); 
		FengkongzhuanyuanView fengkongzhuanyuanView =  fengkongzhuanyuanService.selectView(ew);
		return R.ok("查询风控专员成功").put("data", fengkongzhuanyuanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FengkongzhuanyuanEntity fengkongzhuanyuan = fengkongzhuanyuanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fengkongzhuanyuan,deSens);
        return R.ok().put("data", fengkongzhuanyuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FengkongzhuanyuanEntity fengkongzhuanyuan = fengkongzhuanyuanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(fengkongzhuanyuan,deSens);
        return R.ok().put("data", fengkongzhuanyuan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FengkongzhuanyuanEntity fengkongzhuanyuan, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(fengkongzhuanyuanService.selectCount(new EntityWrapper<FengkongzhuanyuanEntity>().eq("zhuanyuanzhanghao", fengkongzhuanyuan.getZhuanyuanzhanghao()))>0) {
            return R.error("专员账号已存在");
        }
        //ValidatorUtils.validateEntity(fengkongzhuanyuan);
        //验证账号唯一性，否则返回错误信息
        FengkongzhuanyuanEntity u = fengkongzhuanyuanService.selectOne(new EntityWrapper<FengkongzhuanyuanEntity>().eq("zhuanyuanzhanghao", fengkongzhuanyuan.getZhuanyuanzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	fengkongzhuanyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		fengkongzhuanyuan.setId(new Date().getTime());
        fengkongzhuanyuanService.insert(fengkongzhuanyuan);
        return R.ok().put("data",fengkongzhuanyuan.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FengkongzhuanyuanEntity fengkongzhuanyuan, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(fengkongzhuanyuanService.selectCount(new EntityWrapper<FengkongzhuanyuanEntity>().eq("zhuanyuanzhanghao", fengkongzhuanyuan.getZhuanyuanzhanghao()))>0) {
            return R.error("专员账号已存在");
        }
        //ValidatorUtils.validateEntity(fengkongzhuanyuan);
        //验证账号唯一性，否则返回错误信息
        FengkongzhuanyuanEntity u = fengkongzhuanyuanService.selectOne(new EntityWrapper<FengkongzhuanyuanEntity>().eq("zhuanyuanzhanghao", fengkongzhuanyuan.getZhuanyuanzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	fengkongzhuanyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		fengkongzhuanyuan.setId(new Date().getTime());
        fengkongzhuanyuanService.insert(fengkongzhuanyuan);
        return R.ok().put("data",fengkongzhuanyuan.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FengkongzhuanyuanEntity fengkongzhuanyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fengkongzhuanyuan);
        //验证字段唯一性，否则返回错误信息
        if(fengkongzhuanyuanService.selectCount(new EntityWrapper<FengkongzhuanyuanEntity>().ne("id", fengkongzhuanyuan.getId()).eq("zhuanyuanzhanghao", fengkongzhuanyuan.getZhuanyuanzhanghao()))>0) {
            return R.error("专员账号已存在");
        }
        //全部更新
        fengkongzhuanyuanService.updateById(fengkongzhuanyuan);
        if(null!=fengkongzhuanyuan.getZhuanyuanzhanghao())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(fengkongzhuanyuan.getZhuanyuanzhanghao());
            tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", fengkongzhuanyuan.getId()));
        }
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fengkongzhuanyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
