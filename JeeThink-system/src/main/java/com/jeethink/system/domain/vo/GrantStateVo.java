package com.jeethink.system.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GrantStateVo {
    //private Integer fenqizongjine;      //分期总金额
    //private Integer yingxiangziliao;    //影像资料
    //private Integer jiafangzhaopian;    //家访照片
    //private Integer tupianxinxi;        //图片信息
    private Integer cheliangzhaopian;   //车辆照片
    //private Integer zichantupian;       //资产图片
    //private Integer qitaziliao;         //其他资料
    //private Integer zhengxin;           //征信
    //private Integer buchongxinxi;       //补充信息
    private Double loanAmount;          //车辆贷款金额
    private Integer submitState;        //授信提交总状态
    private String transactionCode;
}
