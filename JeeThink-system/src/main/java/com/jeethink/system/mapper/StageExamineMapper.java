package com.jeethink.system.mapper;

import com.jeethink.system.domain.*;

import java.util.List;

public interface StageExamineMapper {
    /**借款人信息查询*/
    ZyjrBorrower findByBorrower(String transactionCode);
    /**关联人信息查询*/
    ZyjrRelation findByRelation(String transactionCode);
    /**担保人信息查询*/
    ZyjrGuarantee findByGuarantee(String transactionCode);
    /**业务信息查询*/
    ZyjrBusiness findByBusiness(String transactionCode);
    /**银行岗信息录入*/
    int insertBank(ZyjrDetails q);
    /**征信详情回显*/
    ZyjrDetails findByDetails(String transactionCode);


    int insertOpinion(ZyjrRepeatOpinion q);
    ZyjrRepeatOpinion findOpinion(String transactionCode);
    List<ZyjrBusiness> list();
}
