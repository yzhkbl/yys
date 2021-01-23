package com.jeethink.system.domain.vo;

import com.jeethink.system.domain.ZyjrBorrower;
import com.jeethink.system.domain.ZyjrBusiness;
import com.jeethink.system.domain.ZyjrGuarantee;
import com.jeethink.system.domain.ZyjrRelation;
import lombok.Data;

import java.util.List;
@Data
public class ExamineVo {
    private ZyjrBusiness business;
    private ZyjrBorrower borrower;
    //private ZyjrRelation zyjrRelation;
    //private ZyjrGuarantee zyjrGuarantee;
    private List<ZyjrRelation> relation;
    private List<ZyjrGuarantee> guarantee;
}
