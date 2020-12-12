package com.jeethink.system.mapper;

import com.jeethink.system.domain.*;

public interface ExamineMapper {
    /**借款人信息添加*/
    int insertBorrower(ZyjrBorrower q);
    /**关联人信息添加*/
    int insertRelation(ZyjrRelation q);
    /**担保人信息添加*/
    int insertGuarantee(ZyjrGuarantee q);
    /**业务信息添加*/
    int insertBusiness(ZyjrBusiness q);

    int updateBorrower(ZyjrBorrower q);
    int updateRelation(ZyjrRelation q);
    int updateGuarantee(ZyjrGuarantee q);
    int updateBusiness(ZyjrBusiness q);
    int updateStart(StartPage q);

    int updateOne(Boolean orderState);
    int updateTwo(Boolean orderState);
    int updateThree(Boolean orderState);
    int updateFour(Boolean orderState);

    /**借款人信息查询*/
    ZyjrBorrower findByBorrower(String id);
    /**关联人信息查询*/
    ZyjrRelation findByRelation(String id);
    /**担保人信息查询*/
    ZyjrGuarantee findByGuarantee(String id);
    /**业务信息查询*/
    ZyjrBusiness findByBusiness(String id);

    int insertStart(StartPage q);

    StartPage findByStart(String id);
}
