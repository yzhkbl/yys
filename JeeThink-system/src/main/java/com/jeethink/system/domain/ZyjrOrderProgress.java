package com.jeethink.system.domain;

import lombok.Data;

@Data
public class ZyjrOrderProgress {
    private Long id;
    private String transactionCode;
    private Integer progress;
    private Integer approvalType;
}
