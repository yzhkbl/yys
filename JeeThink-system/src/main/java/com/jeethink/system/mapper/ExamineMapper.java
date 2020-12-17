package com.jeethink.system.mapper;

import com.jeethink.system.domain.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
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
    int updateStart(ZyjrStartPage q);

    int updateOne(Boolean orderState,String transactionCode);
    int updateTwo(Boolean orderState,String transactionCode);
    int updateThree(Boolean orderState,String transactionCode);
    int updateFour(Boolean orderState,String transactionCode);

    /**借款人信息查询*/
    ZyjrBorrower findByBorrower(Integer orderState);
    /**关联人信息查询*/
    ZyjrRelation findByRelation(Integer orderState);
    /**担保人信息查询*/
    ZyjrGuarantee findByGuarantee(Integer orderState);
    /**业务信息查询*/
    ZyjrBusiness findByBusiness(Integer orderState);

    int insertStart(ZyjrStartPage q);

    ZyjrStartPage findByStart(Integer orderState);
}
