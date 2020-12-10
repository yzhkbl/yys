package com.jeethink.system.domain.vo;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class req {
	/**
	 * 意向价格
	 */
	private BigDecimal intentionPrice;//意向车辆价格，可以理解为买车预算，建议填写所买车辆的价格  
	/**
	 * 主借款人信息
	 */
	private lender lender;
	/**
	 * 业务品种
	 */
	private Integer carType;//业务品种为婚庆时，必须传入一个关联人 
	/**
	 * 材料下载方式
	 */
	private Integer downloadMode;
	/**
	 * 关联人信息数组
	 */
	private List<spouse> spouse;
	/**
	 * 业务模式
	 */
	private Integer businessModel;

}