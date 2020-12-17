package com.jeethink.system.domain;

import lombok.Data;

@Data
public class ZyjrDetails {
    private Integer id;//主键
    private String transactionCode;//订单编号
    private String details;//银行详版征信信息
}
