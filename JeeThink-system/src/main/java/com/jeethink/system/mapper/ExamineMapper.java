package com.jeethink.system.mapper;

import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamineMapper {
    List<ZyjrDaiqian> selectAllList(ZyjrAllowBasics zyjrAllowBasics);
    ZyjrDaiqian selByDaiqian(String transactionCode);
    int insertDaiqian(ZyjrDaiqian zyjrDaiqian);
    int insertDaiqians(String transactionCode);
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
    int updateOne(@Param("userId") Integer userId, @Param("transactionCode") String transactionCode,@Param("orderState") Integer orderState);
    int updateTwo(@Param("userId") Integer userId, @Param("transactionCode") String transactionCode,@Param("orderState") Integer orderState);
    int updateThree(@Param("userId") Integer userId, @Param("transactionCode") String transactionCode,@Param("orderState") Integer orderState);
    int updateFour(@Param("userId") Integer userId, @Param("transactionCode") String transactionCode,@Param("orderState") Integer orderState);
    int updateFive(@Param("userId") Integer userId, @Param("transactionCode") String transactionCode);

    /**借款人信息查询*/
    ZyjrBorrower findByBorrower(Integer userId);
    /**关联人信息查询*/
    List<ZyjrRelation> findByRelation(Integer userId);
    /**担保人信息查询*/
    List<ZyjrGuarantee> findByGuarantee(Integer userId);
    /**业务信息查询*/
    ZyjrBusiness findByBusiness(Integer userId);

    int insertStart(ZyjrStartPage q);

    ZyjrStartPage findByStart(Integer userId);
    ZyjrStartPage findByStarts(String transactionCode);

    int updateStarts(String transactionCode);
    List<carVo> selectZyjrCarLists(String userId);

    Linkman selectZyjrCarByLinkman(Long id);
    DqVo selectDQ(String transactionCode);
    DqVo selectDQ2(String transactionCode);
    DqVo selectDQ3(String transactionCode);

    List<orderVo>findOrder(Long userId);



    ZyjrBorrower Borrower(String transactionCode);
    ZyjrRelation Relation(String transactionCode);
    ZyjrGuarantee Guarantee(String transactionCode);
    ZyjrBusiness Business(String transactionCode);
    ZyjrStartPage Start(String transactionCode);


    List<CarSeriseGroup> findGroup();
    List<CarSeries> findSeries(Integer brandId);
    List<CarInfo> findInfo(@Param("brandId") Integer brandId,@Param("groupId") Integer groupId);

    int updateByDaiqians(UserVo userVo);

    int updateByDaihou(ZyjrDaihou zyjrDaihou);

    ZyjrApp findAppCode();

    ZyjrDaiqian selDaiqianById(String id);

    int deleteBusiness(Long userId);
    int deleteBorrower(Long userId);
    int deleteRelation(Long userId);
    int deleteGuarantee(Long userId);
    int deleteStartPage(Long userId);


    int deleteRelationById(Long id);
    int deleteGuaranteeById(Long id);
}
