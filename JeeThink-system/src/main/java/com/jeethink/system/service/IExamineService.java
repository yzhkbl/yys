package com.jeethink.system.service;

import com.jeethink.system.domain.*;

import java.util.Map;

public interface IExamineService {
    int addByBorrower(ZyjrBorrower q);
    int addByRelation(ZyjrRelation q);
    int addByGuarantee(ZyjrGuarantee q);
    int addByBusiness(ZyjrBusiness q);
    ZyjrBorrower findByBorrower(Integer userId);
    ZyjrRelation findByRelation(Integer userId);
    ZyjrGuarantee findByGuarantee(Integer userId);
    ZyjrBusiness findByBusiness(Integer userId);
    Map<String,Object> find(Integer userId);
    int addByStart(ZyjrStartPage q);


    String okPurchase(String codes);
    ZyjrStartPage findByStart(Integer userId);
}
