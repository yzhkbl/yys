package com.jeethink.system.domain.vo;

import lombok.Data;

@Data
public class OpinionVo {
    private String allowOpinion;
    private String repeatOpinion;
    private String grantOpinion;
    private String daiqianOpinion;
    private String daihouOpinion;
    private String transactionCode;

    private String chushen;   //初审
    private String zhongshen;   //终审
    private String shouxin;     //授信
    private String daiqian;     //贷前
    private String daihou;      //贷后
}
