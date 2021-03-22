package com.jeethink.system.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class OverdueVo {
    private String time;             //时间
    private String borrower;           //名字
    private String bankCard;           //银行卡
    private String fundSide;            //经办行
    private Integer byStages;           //分期期数
    private BigDecimal loanAmount;      //车辆贷款金额
    private BigDecimal repaymentAmount; //月还款额
    private String repaymentDate;       //还款日期
    private Integer shouldStages;       //应还期数
}
