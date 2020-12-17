package com.jeethink.system.service;

import com.jeethink.system.domain.*;

import java.util.List;
import java.util.Map;

public interface IStageExamineService {
    /**借款人信息查询*/
    ZyjrBorrower findByBorrower(String transactionCode);
    /**关联人信息查询*/
    ZyjrRelation findByRelation(String transactionCode);
    /**担保人信息查询*/
    ZyjrGuarantee findByGuarantee(String transactionCode);
    /**业务信息查询*/
    ZyjrBusiness findByBusiness(String transactionCode);
    /**用户信息详情*/
    Map<String,Object> find(String transactionCode);
    /**银行详版征信录入*/
    int addBankDetails(ZyjrDetails q);
    /**详版证信回显*/
    ZyjrDetails findBankDetails(String transactionCode);
}
