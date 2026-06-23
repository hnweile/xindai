package com.entity.model;

import com.entity.DaikuanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 贷款信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-03-11 11:25:57
 */
public class DaikuanxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 贷款种类
	 */
	
	private String daikuanzhonglei;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 简介
	 */
	
	private String jianjie;
		
	/**
	 * 金额
	 */
	
	private Integer jine;
		
	/**
	 * 贷款条件
	 */
	
	private String daikuantiaojian;
		
	/**
	 * 还款期限
	 */
	
	private String haikuanqixian;
		
	/**
	 * 详细介绍
	 */
	
	private String xiangxijieshao;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：贷款种类
	 */
	 
	public void setDaikuanzhonglei(String daikuanzhonglei) {
		this.daikuanzhonglei = daikuanzhonglei;
	}
	
	/**
	 * 获取：贷款种类
	 */
	public String getDaikuanzhonglei() {
		return daikuanzhonglei;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：简介
	 */
	 
	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}
	
	/**
	 * 获取：简介
	 */
	public String getJianjie() {
		return jianjie;
	}
				
	
	/**
	 * 设置：金额
	 */
	 
	public void setJine(Integer jine) {
		this.jine = jine;
	}
	
	/**
	 * 获取：金额
	 */
	public Integer getJine() {
		return jine;
	}
				
	
	/**
	 * 设置：贷款条件
	 */
	 
	public void setDaikuantiaojian(String daikuantiaojian) {
		this.daikuantiaojian = daikuantiaojian;
	}
	
	/**
	 * 获取：贷款条件
	 */
	public String getDaikuantiaojian() {
		return daikuantiaojian;
	}
				
	
	/**
	 * 设置：还款期限
	 */
	 
	public void setHaikuanqixian(String haikuanqixian) {
		this.haikuanqixian = haikuanqixian;
	}
	
	/**
	 * 获取：还款期限
	 */
	public String getHaikuanqixian() {
		return haikuanqixian;
	}
				
	
	/**
	 * 设置：详细介绍
	 */
	 
	public void setXiangxijieshao(String xiangxijieshao) {
		this.xiangxijieshao = xiangxijieshao;
	}
	
	/**
	 * 获取：详细介绍
	 */
	public String getXiangxijieshao() {
		return xiangxijieshao;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
