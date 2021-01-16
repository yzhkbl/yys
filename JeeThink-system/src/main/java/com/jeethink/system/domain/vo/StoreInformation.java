package com.jeethink.system.domain.vo;

import com.jeethink.common.annotation.Excel;
import lombok.Data;

@Data
public class StoreInformation {
    /** 所属区域 */
    private String area;
    private String status;
    private String id;
    /** 所属城市 */
    private String city;
    private String createBy;
    /** 所属市场 */
    private String bazaar;

    /** 第一个门店类型 */
    private String shopType;
    private String type;

    /** 第二个门店类型 */
    private String businessType;

    /** 车位数 */
    private String stall;

    /** 经营性质 */
    private String businessNature;

    /** 乘用车 */
    private String passengerCar;

    private String dealerName;
    /** 月交易量 */
    private String monthDeal;

    /** 月分期量 */
    private String monthInstallment;

    /** 竟对单量 */
    private String matchAmount;

    /** 详细地址 */
    private String detailAddress;

    /** 门店照片 */
    private String pic;



}
