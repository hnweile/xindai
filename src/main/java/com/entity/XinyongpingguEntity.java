package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 信用评估
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
@TableName("xinyongpinggu")
public class XinyongpingguEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XinyongpingguEntity() {
		
	}
	
	public XinyongpingguEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 账号
	 */
					
	private String zhanghao;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
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
