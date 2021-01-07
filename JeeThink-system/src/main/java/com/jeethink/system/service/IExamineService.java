package com.jeethink.system.service;

import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.CarInfo;
import com.jeethink.system.domain.vo.CarSeries;
import com.jeethink.system.domain.vo.CarSeriseGroup;
import com.jeethink.system.domain.vo.orderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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

    String order(Integer userId);

    String okPurchase(String codes);
    ZyjrStartPage findByStart(Integer userId);

    List<orderVo> findOrder(Long userId);

    Map<String,Object> findExamine(String transactionCode);


    List<CarSeriseGroup> findGroup();
    List<CarSeries> findSeries(Integer brandId);
    List<CarInfo> findInfo(Integer brandId,Integer groupId);
}
