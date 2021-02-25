package com.jeethink.system.service;

import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.ExamineVo;
import com.jeethink.system.domain.vo.ZyjrGrant;

import java.util.List;
import java.util.Map;

public interface IStageExamineService {
    /**借款人信息查询*/
    ZyjrBorrower findByBorrower(String transactionCode);
    /**关联人信息查询*/
    List<ZyjrRelation> findByRelation(String transactionCode);
    /**担保人信息查询*/
    List<ZyjrGuarantee> findByGuarantee(String transactionCode);
    /**业务信息查询*/
    ZyjrBusiness findByBusiness(String transactionCode);
    /**用户信息详情*/
    ExamineVo find(String transactionCode);
    /**银行详版征信录入*/
    int addBankDetails(ZyjrDetails q);
    /**详版证信回显*/
    ZyjrDetails findBankDetails(String transactionCode);

    Map<String,Object> findByAllow(Long userId,String transactionCode);

    int addOpinion(ZyjrRepeatOpinion q);
    ZyjrRepeatOpinion findOpinion(String transactionCode);
    List<ZyjrGrant> list();


    int addGrantOpinion(ZyjrGrantOpinion q);
    ZyjrGrantOpinion findGrantOpinion(String transactionCode);
    List<ZyjrGrant> grant();

    Map<String,Object>findByGrant(Long userId,String transactionCode);

    List<ZyjrGrant>findAllow();
}
