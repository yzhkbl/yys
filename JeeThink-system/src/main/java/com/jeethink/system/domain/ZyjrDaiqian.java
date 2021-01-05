package com.jeethink.system.domain;

import lombok.Data;

@Data
public class ZyjrDaiqian {
    private Long id;
    private String state;//1.通过 2.驳回 3.拒绝
    private String opinion;
    private String userId;
    private String transactionCode;

}
