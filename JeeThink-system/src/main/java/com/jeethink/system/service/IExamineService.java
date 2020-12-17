package com.jeethink.system.service;

import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.OkVo;

import java.util.Map;

public interface IExamineService {
    int addByBorrower(ZyjrBorrower q);
    int addByRelation(ZyjrRelation q);
    int addByGuarantee(ZyjrGuarantee q);
    int addByBusiness(ZyjrBusiness q);
    ZyjrBorrower findByBorrower(Integer id);
    ZyjrRelation findByRelation(Integer id);
    ZyjrGuarantee findByGuarantee(Integer id);
    ZyjrBusiness findByBusiness(Integer id);
    Map<String,Object> find(Integer id);
    int addByStart(ZyjrStartPage q);
    ZyjrStartPage findByStart(Integer id);

    String okPurchase(String codes);
}
