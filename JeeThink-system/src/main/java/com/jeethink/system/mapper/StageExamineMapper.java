package com.jeethink.system.mapper;

import com.jeethink.system.domain.ZyjrBorrower;
import com.jeethink.system.domain.ZyjrBusiness;
import com.jeethink.system.domain.ZyjrGuarantee;
import com.jeethink.system.domain.ZyjrRelation;

public interface StageExamineMapper {
    /**借款人信息查询*/
    ZyjrBorrower findByBorrower(String transactionCode);
    /**关联人信息查询*/
    ZyjrRelation findByRelation(String transactionCode);
    /**担保人信息查询*/
    ZyjrGuarantee findByGuarantee(String transactionCode);
    /**业务信息查询*/
    ZyjrBusiness findByBusiness(String transactionCode);
}
