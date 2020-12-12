package com.jeethink.system.service;

import com.jeethink.system.domain.*;

import java.util.Map;

public interface IExamineService {
    int addByBorrower(ZyjrBorrower q);
    int addByRelation(ZyjrRelation q);
    int addByGuarantee(ZyjrGuarantee q);
    int addByBusiness(ZyjrBusiness q);
    ZyjrBorrower findByBorrower(String id);
    ZyjrRelation findByRelation(String id);
    ZyjrGuarantee findByGuarantee(String id);
    ZyjrBusiness findByBusiness(String id);
    Map<String,Object> find(String id);
    int addByStart(StartPage q);
    StartPage findByStart(String id);
}
