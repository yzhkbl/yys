package com.jeethink.system.domain.vo;

import lombok.Data;

@Data
public class ChinaPaySelect {
    Integer version;
    Integer accessType;
    Integer instuId;
    Integer acqCode;
    Integer merId;
    Integer busiType;
    Integer tranType;
    Integer oriTranType;
    String cardTranData;
    String tranReserved;
    String timeStamp;
    String remoteAddr;
    String signature;
}
