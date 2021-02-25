package com.jeethink.system.mapper;

import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.GrantVo;
import com.jeethink.system.domain.vo.ShangpaiDiyaVo;
import com.jeethink.system.domain.vo.ZyjrGrant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StageExamineMapper {
    /**借款人信息查询*/
    ZyjrBorrower findByBorrower(String transactionCode);
    /**关联人信息查询*/
    List<ZyjrRelation> findByRelation(String transactionCode);
    /**担保人信息查询*/
    List<ZyjrGuarantee> findByGuarantee(String transactionCode);
    /**业务信息查询*/
    ZyjrBusiness findByBusiness(String transactionCode);

    ZyjrStartPage findByStartPage(String transactionCode);
    /**银行岗信息录入*/
    int insertBank(ZyjrDetails q);
    /**征信详情回显*/
    ZyjrDetails findByDetails(String transactionCode);


    int deleteOpinion(String transactionCode);
    int insertOpinion(ZyjrRepeatOpinion q);
    ZyjrRepeatOpinion findOpinion(String transactionCode);
    List<ZyjrGrant> list();


    List<ZyjrGrant> findGrant();
    int insertGrantOpinion(ZyjrGrantOpinion q);
    ZyjrGrantOpinion findGrantOpinion(String transactionCode);

    GrantVo findByGrant(String transactionCode);

    List<ZyjrGrant>findAllow();

    //上牌
    List<ShangpaiDiyaVo>findShangpai();
    int insertShangpaiOpinion(ZyjrGrantOpinion q);
    ZyjrGrantOpinion findShangpaiOpinion(String transactionCode);

    //抵押
    List<ShangpaiDiyaVo>findDiya();
    int insertDiyaOpinion(ZyjrGrantOpinion q);
    ZyjrGrantOpinion findDiyaOpinion(String transactionCode);

    int deleteAllowOpinion(Long id);
    int deleteRepeatOpinion(Long id);


    int addSupplement(ZyjrSupplement q);
    ZyjrSupplement findSupplement(String transactionCode);
}
