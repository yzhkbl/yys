package com.jeethink.system.domain;

import lombok.Data;

@Data
public class ZyjrFundSide {
    private Long id;
    private String sideName;
    private String transactionCode;
    private Integer orderState;
}
