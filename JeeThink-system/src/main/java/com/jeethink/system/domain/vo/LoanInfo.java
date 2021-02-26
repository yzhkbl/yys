package com.jeethink.system.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanInfo {
    BigDecimal loanAmount;
    String loanAccount;
    Integer loanFlag;
    BigDecimal firstamt;
    BigDecimal eachamt;
    BigDecimal feeamt;
    BigDecimal eachpfee;
    BigDecimal firstpfee;
    Integer eachdate;
    String nextdate;
    String workdate;
    String trxpot;

}
