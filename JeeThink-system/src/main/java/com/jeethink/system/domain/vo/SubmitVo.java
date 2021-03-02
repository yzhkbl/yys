package com.jeethink.system.domain.vo;

import lombok.Data;

@Data
public class SubmitVo {
    private Integer zhunru; //准入提交状态
    private Integer shouxin;//授信提交状态
    private Integer daiqian;//贷前提交状态
    private Integer daihou; //贷后提交状态
    private String transactionCode;
}
