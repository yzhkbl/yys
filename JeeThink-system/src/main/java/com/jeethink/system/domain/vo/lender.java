package com.jeethink.system.domain.vo;

import java.util.List;
import java.util.Map;

import lombok.Data;
@Data
/**
 * 主借款人信息
 * @author Hello
 *
 */
public class lender {
	/**
	 * 住宅地址
	 */
	private String familyAddress;
	/**
	 * 证件有限期截止日期
	 */
	private String endDate;
	/**
	 * 银行卡号
	 */
	private String bankCardNo;
	/**
	 * 主借人身份证号码
	 */
	private String idCard;
	/**
	 * 主借款人手机号码
	 */
	private String phoneNum;
	/**
	 * 签约方式
	 */
	private Integer signMode;
	/**
	 * 身份证签发机关
	 */
	private String issueAuthority;
	/**
	 * 主借款人姓名
	 */
	private String userName;
	/**
	 * 材料项（数组）
	 */
	private List<Pics> pics;
	/**
	 * 证件有限期截止日期
	 */
	private String startDate;

}
