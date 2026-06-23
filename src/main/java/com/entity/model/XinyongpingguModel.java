package com.entity.model;

import com.entity.XinyongpingguEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 信用评估
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
public class XinyongpingguModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 头像
	 */
	
	private String touxiang;
		
	/**
	 * 评估等级
	 */
	
	private String pinggudengji;
		
	/**
	 * 评估依据
	 */
	
	private String pingguyiju;
		
	/**
	 * 评估结果
	 */
	
	private String pinggujieguo;
		
	/**
	 * 评估时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date pinggushijian;
		
	/**
	 * 专员账号
	 */
	
	private String zhuanyuanzhanghao;
		
	/**
	 * 专员姓名
	 */
	
	private String zhuanyuanxingming;
		
	/**
	 * 跨表用户id
	 */
	
	private Long crossuserid;
		
	/**
	 * 跨表主键id
	 */
	
	private Long crossrefid;
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：头像
	 */
	 
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
				
	
	/**
	 * 设置：评估等级
	 */
	 
	public void setPinggudengji(String pinggudengji) {
		this.pinggudengji = pinggudengji;
	}
	
	/**
	 * 获取：评估等级
	 */
	public String getPinggudengji() {
		return pinggudengji;
	}
				
	
	/**
	 * 设置：评估依据
	 */
	 
	public void setPingguyiju(String pingguyiju) {
		this.pingguyiju = pingguyiju;
	}
	
	/**
	 * 获取：评估依据
	 */
	public String getPingguyiju() {
		return pingguyiju;
	}
				
	
	/**
	 * 设置：评估结果
	 */
	 
	public void setPinggujieguo(String pinggujieguo) {
		this.pinggujieguo = pinggujieguo;
	}
	
	/**
	 * 获取：评估结果
	 */
	public String getPinggujieguo() {
		return pinggujieguo;
	}
				
	
	/**
	 * 设置：评估时间
	 */
	 
	public void setPinggushijian(Date pinggushijian) {
		this.pinggushijian = pinggushijian;
	}
	
	/**
	 * 获取：评估时间
	 */
	public Date getPinggushijian() {
		return pinggushijian;
	}
				
	
	/**
	 * 设置：专员账号
	 */
	 
	public void setZhuanyuanzhanghao(String zhuanyuanzhanghao) {
		this.zhuanyuanzhanghao = zhuanyuanzhanghao;
	}
	
	/**
	 * 获取：专员账号
	 */
	public String getZhuanyuanzhanghao() {
		return zhuanyuanzhanghao;
	}
				
	
	/**
	 * 设置：专员姓名
	 */
	 
	public void setZhuanyuanxingming(String zhuanyuanxingming) {
		this.zhuanyuanxingming = zhuanyuanxingming;
	}
	
	/**
	 * 获取：专员姓名
	 */
	public String getZhuanyuanxingming() {
		return zhuanyuanxingming;
	}
				
	
	/**
	 * 设置：跨表用户id
	 */
	 
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
				
	
	/**
	 * 设置：跨表主键id
	 */
	 
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
	}
			
}
