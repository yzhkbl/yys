package com.jeethink.system.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BorrowerVo {
    private String phoneNumber; //主贷人电话
    private String liveAddress; //居住地址
    private String unitName;    //单位名称
    private String workAddress; //单位地址
    private String unitPhone;   //单位电话
    private String nameOne;     //紧急联系人1
    private String phoneOne;    //紧急联系人1电话
    private String nameTwo;     //紧急联系人2
    private String phoneTwo;    //紧急联系人2电话

    private String carSeries;   //车辆型号
    private Integer carType;    //车辆类型
    private BigDecimal actualPrice;//车辆价格
    private BigDecimal loanAmount;//贷款金额
    private String vinCode;     //车架号
    private String engineCode;  //发动机号
    private String ManufacturerPrice;   //精真估价格
}
