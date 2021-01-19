package com.jeethink.system.domain.vo;

import com.jeethink.system.domain.*;
import lombok.Data;

@Data
public class FenqiReq {
    Integer signMode;
    String reczoneno;
    ZyjrCarType2 carInfo;
    ZyjrStagingInformation2 stageInfo;
    ZyjrGuaranteeinfo2 guaranteeInfo;
    ZyjrFinanceChargeCardInfo2 financeChargeCardInfo;
    ZyjrPayMentInfo2 payMentInfo;
    JkrclVo JKRCL;


}
