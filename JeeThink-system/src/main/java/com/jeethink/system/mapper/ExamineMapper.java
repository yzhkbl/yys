package com.jeethink.system.mapper;

import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamineMapper {
    List<Region> selectRegion(Region r);
    provinces selectP(String province);
    List<ZyjrDaiqian> selectAllList(ZyjrDaiqian zyjrAllowBasics);
    ZyjrDaiqian selByDaiqian(String transactionCode);
    int insertDaiqian(ZyjrDaiqian zyjrDaiqian);
    int insertDaiqian2(ZyjrDaiqian zyjrDaiqian);
    int insertDaiqians(String transactionCode);
    int updateByDaiqian(ZyjrDaiqian zyjrDaiqian);
    int updateByDaiqian2(ZyjrDaiqian zyjrDaiqian);
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
    int updateStarts2(String transactionCode);
    List<carVo> selectZyjrCarLists(String userId);


    Linkman selectZyjrCarByLinkman(Long id);
    DqVo selectDQ(String transactionCode);
    DqVo selectDQ2(String transactionCode);
    DqVo selectDQ3(String transactionCode);
    List<Huankuan> selectHuankuanList();
    List<orderVo> findOrder(@Param("userId") Long userId,@Param("progress") Integer progress);//全部订单
    List<orderVo> findOrder2(Long userId);
    List<orderVo> findOrder3(Long userId);



    ZyjrBorrower Borrower(String transactionCode);
    ZyjrRelation Relation(String transactionCode);
    ZyjrGuarantee Guarantee(String transactionCode);
    ZyjrBusiness Business(String transactionCode);
    ZyjrStartPage Start(String transactionCode);


    List<CarSeriseGroup> findGroup();/**车辆信息*/
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

    int insertOrderProgress(ZyjrOrderProgress zyjrOrderProgress);
    int updateOrderProgress(ZyjrOrderProgress zyjrOrderProgress);

    int insertShangpai (ZyjrShangpai q);
    int insertZyjrApp (ZyjrApp zyjrApp);
    int updateShangpai(ZyjrShangpai q);
    ZyjrShangpai findShangpai(String transactionCode);
    int insertXiaoxi(Xiaoxi xiaoxi);
    int insertDiya(ZyjrDiya q);
    List<Xiaoxi> selByUserId(String userId);
    int updateDiya(ZyjrDiya q);
    ZyjrDiya findDiya(String transactionCode);

    cities selectC(String city);

    List<orderVo>searchOrder(@Param("search") String search,@Param("userId") Long userId);//安卓订单搜索框

    List<RelationName>relationName(String transactionCode);//补充关联人的列表
    ZyjrRelation findById(Long id);

    List<RelationName>guName(String transactionCode);//补充担保人的列表
    List<RelationName>cmName(String transactionCode);
    ZyjrPeopleGuarantee findByGu(Long id);//id查询担保人
    ZyjrCompanyGuarantee findByCm(Long id);//id查询担保公司

    Bairong selectBairong(Bairong b);

    List<carVo> selectZyjrCarListss(@Param("userId") String createBy, @Param("pid") String pid);

    int addAllowState(ZyjrSubmitStateAllow q);//准入提交
    int updateAllowState(ZyjrSubmitStateAllow q);
    ZyjrSubmitStateAllow findAllowState(String transactionCode);
    int addGrantState(ZyjrSubmitStateGrant q);//授信提交
    int updateGrantState(ZyjrSubmitStateGrant q);
    ZyjrSubmitStateGrant findGrantState(String transactionCode);

    AllowStateVo allowList(String transactionCode);//准入信息填写状态
    GrantStateVo grantList(String transactionCode);//授信信息填写状态


    int insertFundSide(ZyjrFundSide zyjrFundSide);//资金方：准入
    ZyjrFundSide findFundSide(String transactionCode);
    int updateFundSide(ZyjrFundSide zyjrFundSide);

    List<ZyjrRelation> findRe(String transactionCode);
    List<ZyjrGuarantee> findGu(String transactionCode);

    int updateByBairong(Bairong borrower);

    OpinionVo findApType(@Param("transactionCode") String transactionCode);//历史审核意见及审核人

    SubmitVo findSubmit(String transactionCode);//提交状态

    ZyjrCarLoan findCar(String transactionCode);

    PhotoSize carSize(String transactionCode);//图片数量
    PhotoSize mainSize(String transactionCode);

}
