package com.jeethink.system.mapper;

import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.DqVo;
import com.jeethink.system.domain.vo.Linkman;
import com.jeethink.system.domain.vo.carVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamineMapper {
    ZyjrDaiqian selByDaiqian(String transactionCode);
    int insertDaiqian(ZyjrDaiqian zyjrDaiqian);
    int updateByDaiqian(ZyjrDaiqian zyjrDaiqian);
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

    /**int updateOne(Boolean orderState,String transactionCode);
    int updateTwo(Boolean orderState,String transactionCode);
    int updateThree(Boolean orderState,String transactionCode);
    int updateFour(Boolean orderState,String transactionCode);*/
    int updateBystates(ZyjrStartPage q);
    int updateByCode(ZyjrStartPage q);
    int updateOne(@Param("userId") Integer userId, @Param("transactionCode") String transactionCode);
    int updateTwo(@Param("userId") Integer userId, @Param("transactionCode") String transactionCode);
    int updateThree(@Param("userId") Integer userId, @Param("transactionCode") String transactionCode);
    int updateFour(@Param("userId") Integer userId, @Param("transactionCode") String transactionCode);
    int updateFive(@Param("userId") Integer userId, @Param("transactionCode") String transactionCode);

    /**借款人信息查询*/
    ZyjrBorrower findByBorrower(Integer userId);
    /**关联人信息查询*/
    ZyjrRelation findByRelation(Integer userId);
    /**担保人信息查询*/
    ZyjrGuarantee findByGuarantee(Integer userId);
    /**业务信息查询*/
    ZyjrBusiness findByBusiness(Integer userId);

    int insertStart(ZyjrStartPage q);

    ZyjrStartPage findByStart(Integer userId);
    ZyjrStartPage findByStarts(String transactionCode);

    int updateStarts(String transactionCode);
    List<carVo> selectZyjrCarLists(String userId);

    Linkman selectZyjrCarByLinkman(Long id);
    DqVo selectDQ(String transactionCode);
}
