package com.jeethink.system.service;

import com.jeethink.system.domain.*;

import java.util.Map;

public interface IExamineService {
    int addByBorrower(ZyjrBorrower q);
    int addByRelation(ZyjrRelation q);
    int addByGuarantee(ZyjrGuarantee q);
    int addByBusiness(ZyjrBusiness q);
    ZyjrBorrower findByBorrower(Integer orderState);
    ZyjrRelation findByRelation(Integer orderState);
    ZyjrGuarantee findByGuarantee(Integer orderState);
    ZyjrBusiness findByBusiness(Integer orderState);
    Map<String,Object> find(Integer orderState);
    int addByStart(ZyjrStartPage q);
    ZyjrStartPage findByStart(Integer orderState);
}
