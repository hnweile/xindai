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
@TableName("creditdata")
public class CreditdataEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public CreditdataEntity() {
		
	}
	
	public CreditdataEntity(T t) {
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
	 * 性别
	 */
					
	private String gender;
	
	/**
	 * 年龄
	 */
					
	private Integer age;
	
	/**
	 * 地区
	 */
					
	private String area;
	
	/**
	 * 教育程度
	 */
					
	private String educationlevel;
	
	/**
	 * 婚姻状况
	 */
					
	private String maritalstatus;
	
	/**
	 * 家庭人数
	 */
					
	private Integer householdsize;
	
	/**
	 * 年收入
	 */
					
	private Integer annualincome;
	
	/**
	 * 月收入
	 */
					
	private Integer monthlyincome;
	
	/**
	 * 职业
	 */
					
	private String career;
	
	/**
	 * 工作年限
	 */
					
	private Integer yearsofservice;
	
	/**
	 * 资产总额
	 */
					
	private Double totalassets;
	
	/**
	 * 负债总额
	 */
					
	private Double totalliabilities;
	
	/**
	 * 负债率
	 */
					
	private String debtratio;
	
	/**
	 * 信用卡额度
	 */
					
	private Double creditlimit;
	
	/**
	 * 信用卡使用率
	 */
					
	private String creditcardusagerate;
	
	/**
	 * 信用评分
	 */
					
	private Integer creditscore;
	
	/**
	 * 信用历史长度
	 */
					
	private String credithistorylength;
	
	/**
	 * 逾期次数
	 */
					
	private Integer numberofoverduetimes;
	
	/**
	 * 严重逾期次数
	 */
					
	private Integer seriousoverduetimes;
	
	/**
	 * 逾期金额
	 */
					
	private Double overdueamount;
	
	/**
	 * 逾期天数
	 */
					
	private Integer overduedays;
	
	/**
	 * 信用查询次数
	 */
					
	private Integer creditinquiryfrequency;
	
	/**
	 * 贷款金额
	 */
					
	private Double loanamount;
	
	/**
	 * 贷款期限
	 */
					
	private String loanterm;
	
	/**
	 * 贷款利率
	 */
					
	private String lendingrate;
	
	/**
	 * 还款方式
	 */
					
	private String repaymentmethod;
	
	/**
	 * 贷款用途
	 */
					
	private String loanpurpose;
	
	/**
	 * 剩余贷款期限
	 */
					
	private String remainingloanterm;
	
	
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
	 * 设置：性别
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 获取：性别
	 */
	public String getGender() {
		return gender;
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
	 * 设置：地区
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：地区
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：教育程度
	 */
	public void setEducationlevel(String educationlevel) {
		this.educationlevel = educationlevel;
	}
	/**
	 * 获取：教育程度
	 */
	public String getEducationlevel() {
		return educationlevel;
	}
	/**
	 * 设置：婚姻状况
	 */
	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	/**
	 * 获取：婚姻状况
	 */
	public String getMaritalstatus() {
		return maritalstatus;
	}
	/**
	 * 设置：家庭人数
	 */
	public void setHouseholdsize(Integer householdsize) {
		this.householdsize = householdsize;
	}
	/**
	 * 获取：家庭人数
	 */
	public Integer getHouseholdsize() {
		return householdsize;
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
	 * 设置：月收入
	 */
	public void setMonthlyincome(Integer monthlyincome) {
		this.monthlyincome = monthlyincome;
	}
	/**
	 * 获取：月收入
	 */
	public Integer getMonthlyincome() {
		return monthlyincome;
	}
	/**
	 * 设置：职业
	 */
	public void setCareer(String career) {
		this.career = career;
	}
	/**
	 * 获取：职业
	 */
	public String getCareer() {
		return career;
	}
	/**
	 * 设置：工作年限
	 */
	public void setYearsofservice(Integer yearsofservice) {
		this.yearsofservice = yearsofservice;
	}
	/**
	 * 获取：工作年限
	 */
	public Integer getYearsofservice() {
		return yearsofservice;
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
	 * 设置：负债率
	 */
	public void setDebtratio(String debtratio) {
		this.debtratio = debtratio;
	}
	/**
	 * 获取：负债率
	 */
	public String getDebtratio() {
		return debtratio;
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
	 * 设置：信用卡使用率
	 */
	public void setCreditcardusagerate(String creditcardusagerate) {
		this.creditcardusagerate = creditcardusagerate;
	}
	/**
	 * 获取：信用卡使用率
	 */
	public String getCreditcardusagerate() {
		return creditcardusagerate;
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
	 * 设置：信用历史长度
	 */
	public void setCredithistorylength(String credithistorylength) {
		this.credithistorylength = credithistorylength;
	}
	/**
	 * 获取：信用历史长度
	 */
	public String getCredithistorylength() {
		return credithistorylength;
	}
	/**
	 * 设置：逾期次数
	 */
	public void setNumberofoverduetimes(Integer numberofoverduetimes) {
		this.numberofoverduetimes = numberofoverduetimes;
	}
	/**
	 * 获取：逾期次数
	 */
	public Integer getNumberofoverduetimes() {
		return numberofoverduetimes;
	}
	/**
	 * 设置：严重逾期次数
	 */
	public void setSeriousoverduetimes(Integer seriousoverduetimes) {
		this.seriousoverduetimes = seriousoverduetimes;
	}
	/**
	 * 获取：严重逾期次数
	 */
	public Integer getSeriousoverduetimes() {
		return seriousoverduetimes;
	}
	/**
	 * 设置：逾期金额
	 */
	public void setOverdueamount(Double overdueamount) {
		this.overdueamount = overdueamount;
	}
	/**
	 * 获取：逾期金额
	 */
	public Double getOverdueamount() {
		return overdueamount;
	}
	/**
	 * 设置：逾期天数
	 */
	public void setOverduedays(Integer overduedays) {
		this.overduedays = overduedays;
	}
	/**
	 * 获取：逾期天数
	 */
	public Integer getOverduedays() {
		return overduedays;
	}
	/**
	 * 设置：信用查询次数
	 */
	public void setCreditinquiryfrequency(Integer creditinquiryfrequency) {
		this.creditinquiryfrequency = creditinquiryfrequency;
	}
	/**
	 * 获取：信用查询次数
	 */
	public Integer getCreditinquiryfrequency() {
		return creditinquiryfrequency;
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
	/**
	 * 设置：贷款期限
	 */
	public void setLoanterm(String loanterm) {
		this.loanterm = loanterm;
	}
	/**
	 * 获取：贷款期限
	 */
	public String getLoanterm() {
		return loanterm;
	}
	/**
	 * 设置：贷款利率
	 */
	public void setLendingrate(String lendingrate) {
		this.lendingrate = lendingrate;
	}
	/**
	 * 获取：贷款利率
	 */
	public String getLendingrate() {
		return lendingrate;
	}
	/**
	 * 设置：还款方式
	 */
	public void setRepaymentmethod(String repaymentmethod) {
		this.repaymentmethod = repaymentmethod;
	}
	/**
	 * 获取：还款方式
	 */
	public String getRepaymentmethod() {
		return repaymentmethod;
	}
	/**
	 * 设置：贷款用途
	 */
	public void setLoanpurpose(String loanpurpose) {
		this.loanpurpose = loanpurpose;
	}
	/**
	 * 获取：贷款用途
	 */
	public String getLoanpurpose() {
		return loanpurpose;
	}
	/**
	 * 设置：剩余贷款期限
	 */
	public void setRemainingloanterm(String remainingloanterm) {
		this.remainingloanterm = remainingloanterm;
	}
	/**
	 * 获取：剩余贷款期限
	 */
	public String getRemainingloanterm() {
		return remainingloanterm;
	}

}
