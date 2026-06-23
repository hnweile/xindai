package com.entity.vo;

import com.entity.CreditdataforecastEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 信贷数据
 * @author 
 * @email 
 * @date 2025-03-11 11:25:58
 */
public class CreditdataforecastVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
