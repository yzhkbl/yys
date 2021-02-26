package com.jeethink.system.domain.vo;

import lombok.Data;

import java.util.List;

@Data
public class LoanRsult {
    String cardNo;
    String loanDate;
    String loanStageDate;
    String recstatMsg;
    String statusName;
    String recstat;
    String status;
    String rejcode;
    String rejreason;
    String loansum;
    String loantime;
    Integer isSupplement;
    List<LoanInfo> loanInfo;
}
