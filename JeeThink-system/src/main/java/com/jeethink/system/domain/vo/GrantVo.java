package com.jeethink.system.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class GrantVo {
    private String userName;
    private String idCard;//身份证
    private String phoneNumber;//手机号
    private String fundSide;//经办行
    private String bankCardNo;//银行卡号
    private BigDecimal actualPrice;//实际销售价
    private BigDecimal loanAmount;//车辆贷款金额
    private Integer repaymentTerm;//还款期限
    private BigDecimal interestRate;//利率换挡
    private BigDecimal deposit;//续保押金
    private String transactionCode;//订单号
    private String userId;
}
