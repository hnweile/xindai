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
 * 贷款申请
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-03-11 11:25:57
 */
@TableName("daikuanshenqing")
public class DaikuanshenqingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DaikuanshenqingEntity() {
		
	}
	
	public DaikuanshenqingEntity(T t) {
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
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 身份证
	 */
					
	private String shenfenzheng;
	
	/**
	 * 贷款名称
	 */
					
	private String daikuanmingcheng;
	
	/**
	 * 贷款种类
	 */
					
	private String daikuanzhonglei;
	
	/**
	 * 金额
	 */
					
	private Double jine;
	
	/**
	 * 保证人
	 */
					
	private String baozhengren;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 抵押资产
	 */
					
	private Double diyazichan;
	
	/**
	 * 资产材料
	 */
					
	private String zichancailiao;
	
	/**
	 * 申请时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shenqingshijian;
	
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
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：身份证
	 */
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	/**
	 * 获取：身份证
	 */
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	/**
	 * 设置：贷款名称
	 */
	public void setDaikuanmingcheng(String daikuanmingcheng) {
		this.daikuanmingcheng = daikuanmingcheng;
	}
	/**
	 * 获取：贷款名称
	 */
	public String getDaikuanmingcheng() {
		return daikuanmingcheng;
	}
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
	 * 设置：金额
	 */
	public void setJine(Double jine) {
		this.jine = jine;
	}
	/**
	 * 获取：金额
	 */
	public Double getJine() {
		return jine;
	}
	/**
	 * 设置：保证人
	 */
	public void setBaozhengren(String baozhengren) {
		this.baozhengren = baozhengren;
	}
	/**
	 * 获取：保证人
	 */
	public String getBaozhengren() {
		return baozhengren;
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
	 * 设置：抵押资产
	 */
	public void setDiyazichan(Double diyazichan) {
		this.diyazichan = diyazichan;
	}
	/**
	 * 获取：抵押资产
	 */
	public Double getDiyazichan() {
		return diyazichan;
	}
	/**
	 * 设置：资产材料
	 */
	public void setZichancailiao(String zichancailiao) {
		this.zichancailiao = zichancailiao;
	}
	/**
	 * 获取：资产材料
	 */
	public String getZichancailiao() {
		return zichancailiao;
	}
	/**
	 * 设置：申请时间
	 */
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
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
