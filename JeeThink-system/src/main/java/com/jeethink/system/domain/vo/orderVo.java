package com.jeethink.system.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class orderVo {
    /**订单编号*/
    private String transactionCode;
    /**客户姓名*/
    private String userName;
    /**身份证号*/
    private String idCard;
    /**车辆信息*/
    private Integer carInformation;
    /**业务品种（新车/二手车）*/
    private Integer carType;
    /**订单流程进度*/
    private Integer progress;
    /**订单创建时间*/
    private Date createTime;
    /**审批状态*/
    private Integer approvalType;

    private Integer creditPower;//签约方式
    private Integer contractState;//签约状态默认0 成功为1 失败为2

}
