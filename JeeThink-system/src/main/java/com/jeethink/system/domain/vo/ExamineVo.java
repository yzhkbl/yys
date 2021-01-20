package com.jeethink.system.domain.vo;

import com.jeethink.system.domain.ZyjrBorrower;
import com.jeethink.system.domain.ZyjrBusiness;
import com.jeethink.system.domain.ZyjrGuarantee;
import com.jeethink.system.domain.ZyjrRelation;
import lombok.Data;

import java.util.List;
@Data
public class ExamineVo {
    private ZyjrBusiness zyjrBusiness;
    private ZyjrBorrower zyjrBorrower;
    //private ZyjrRelation zyjrRelation;
    //private ZyjrGuarantee zyjrGuarantee;
    private List<ZyjrRelation> zyjrRelation;
    private List<ZyjrGuarantee> zyjrGuarantee;
}
