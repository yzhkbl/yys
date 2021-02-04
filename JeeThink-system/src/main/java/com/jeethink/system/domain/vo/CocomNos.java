package com.jeethink.system.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class CocomNos {
    String cocomId;
    Integer cocomInterestFlag;
    String cocomInterestNo;
    BigDecimal cocomReceiveAmt;
    Integer cocomReceiveType;
}
