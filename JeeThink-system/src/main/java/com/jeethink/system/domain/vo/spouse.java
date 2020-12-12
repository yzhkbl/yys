package com.jeethink.system.domain.vo;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class spouse {
	/**
	 * 
	 */
	private String idCard;
	private String issueAuthority;
	private String phoneNum;
	private String bankCardNo;
	private String userName;
	private String startDate;
	/**
	 * 是否查征信
	 */
	private Integer isQueryCredit;
	private Integer userRelationship;
	private String company;
	private String companyAddress;
	private BigDecimal yearIncome;
	/**
	 * 证件有效期截止日期
	 */
	private String endDate;
	/**
	 * 住宅地址
	 */
	private String familyAddress;
	private List<Pics> pics;

}