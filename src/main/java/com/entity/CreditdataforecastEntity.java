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
 * 信贷数据
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
@TableName("creditdataforecast")
public class CreditdataforecastEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CreditdataforecastEntity() {
		
	}
	
	public CreditdataforecastEntity(T t) {
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
	 * 编号
	 */
					
	private String number;
	
	/**
	 * 年龄
	 */
					
	private Integer age;
	
	/**
	 * 年收入
	 */
					
	private Integer annualincome;
	
	/**
	 * 资产总额
	 */
					
	private Double totalassets;
	
	/**
	 * 信用评分
	 */
					
	private Integer creditscore;
	
	/**
	 * 负债总额
	 */
					
	private Double totalliabilities;
	
	/**
	 * 信用卡额度
	 */
					
	private Double creditlimit;
	
	/**
	 * 贷款金额
	 */
					
	private Double loanamount;
	
	
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
	 * 设置：编号
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 获取：编号
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * 设置：年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：年收入
	 */
	public void setAnnualincome(Integer annualincome) {
		this.annualincome = annualincome;
	}
	/**
	 * 获取：年收入
	 */
	public Integer getAnnualincome() {
		return annualincome;
	}
	/**
	 * 设置：资产总额
	 */
	public void setTotalassets(Double totalassets) {
		this.totalassets = totalassets;
	}
	/**
	 * 获取：资产总额
	 */
	public Double getTotalassets() {
		return totalassets;
	}
	/**
	 * 设置：信用评分
	 */
	public void setCreditscore(Integer creditscore) {
		this.creditscore = creditscore;
	}
	/**
	 * 获取：信用评分
	 */
	public Integer getCreditscore() {
		return creditscore;
	}
	/**
	 * 设置：负债总额
	 */
	public void setTotalliabilities(Double totalliabilities) {
		this.totalliabilities = totalliabilities;
	}
	/**
	 * 获取：负债总额
	 */
	public Double getTotalliabilities() {
		return totalliabilities;
	}
	/**
	 * 设置：信用卡额度
	 */
	public void setCreditlimit(Double creditlimit) {
		this.creditlimit = creditlimit;
	}
	/**
	 * 获取：信用卡额度
	 */
	public Double getCreditlimit() {
		return creditlimit;
	}
	/**
	 * 设置：贷款金额
	 */
	public void setLoanamount(Double loanamount) {
		this.loanamount = loanamount;
	}
	/**
	 * 获取：贷款金额
	 */
	public Double getLoanamount() {
		return loanamount;
	}

}
