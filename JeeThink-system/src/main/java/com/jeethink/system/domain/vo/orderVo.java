package com.jeethink.system.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class orderVo {
    /**订单编号*/
    private String transactionCode;
    /**客户姓名*/
    private String userName;
    /**车辆信息*/
    private Integer carInformation;
    /**业务品种（新车/二手车）*/
    private Integer carType;
    /**订单流程进度*/
    private Integer progress;
    /**订单创建时间*/
    private Date createTime;
    //private Integer approvalType;

}
