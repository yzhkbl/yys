package com.jeethink.system.domain.vo;

import com.jeethink.system.domain.*;
import lombok.Data;

import java.util.List;
@Data
public class ExamineVo {
    private ZyjrBusiness business;
    private ZyjrBorrower borrower;
    private ZyjrStartPage startPage;
    //private ZyjrRelation zyjrRelation;
    //private ZyjrGuarantee zyjrGuarantee;
    private List<ZyjrRelation> relation;
    private List<ZyjrGuarantee> guarantee;
}
