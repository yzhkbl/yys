package com.jeethink.system.domain.vo;

import lombok.Data;

@Data
public class AllowStateVo {
    private Integer shenqingren;    //申请人提交状态
    private Integer cheliang;       //车辆信息提交状态
    private Integer zijinfang;      //资金方提交状态
    private Integer jinjilianxiren; //紧急联系人提交状态
    private String transactionCode; //订单号
    private Integer submitState;    //准入总体提交状态
}
