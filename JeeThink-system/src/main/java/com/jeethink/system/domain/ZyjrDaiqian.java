package com.jeethink.system.domain;

import lombok.Data;

@Data
public class ZyjrDaiqian {
    private Long id;
    private String state;//1.通过 2.驳回 3.拒绝
    private String opinion;
    private String userId;
    private String transactionCode;
    private Integer carType;
    private String userName;
    private String team;
    private Double loanAmount;
    private Integer repaymentTerm;
    private Double actualPrice;
    private Long dealersId;
    private Integer carInformation;
    private String operator;
    String createTime;
    String gps;
    String insurance;
    String account;
    String gpsPic;

}
