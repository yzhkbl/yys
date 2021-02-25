package com.jeethink.system.domain;

import lombok.Data;

@Data
public class ZyjrSupplement {
    private Long id;
    private Integer gongchangren;   //共偿人
    private Integer gtsqr;          //共同申请人
    private Integer danbaoren;      //担保人
}
