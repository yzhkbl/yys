package com.jeethink.system.service.impl;

import com.jeethink.common.core.domain.entity.SysUser;
import com.jeethink.common.utils.DateUtils;
import com.jeethink.system.controller.ExamineController;
import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.ExamineVo;
import com.jeethink.system.domain.vo.Xiaoxi;
import com.jeethink.system.domain.vo.ZyjrGrant;
import com.jeethink.system.mapper.*;
import com.jeethink.system.service.IStageExamineService;
import com.jeethink.system.util.DataUtil;
import com.jeethink.system.util.PushMessageByPushIdTest;
import com.jeethink.system.util.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IStageExamineServiceImpl implements IStageExamineService {
    @Autowired
    private StageExamineMapper examineDao;
    @Autowired
    private ZyjrAllowApplicantMapper zyjrAllowApplicantMapper;
    @Autowired
    private ZyjrAllowBasicsMapper zyjrAllowBasicsMapper;
    @Autowired
    private ZyjrAllowContactsMapper zyjrAllowContactsMapper;
    @Autowired
    private ZyjrCarLoanMapper zyjrCarLoanMapper;
    @Autowired
    private ZyjrCompanyGuaranteeMapper zyjrCompanyGuaranteeMapper;
    @Autowired
    private ZyjrDebtServiceMapper zyjrDebtServiceMapper;
    @Autowired
    private ZyjrPeopleGuaranteeMapper zyjrPeopleGuaranteeMapper;
    @Autowired
    private ZyjrPhotoCarMapper zyjrPhotoCarMapper;
    @Autowired
    private ZyjrPhotoCreditMapper zyjrPhotoCreditMapper;
    @Autowired
    private ZyjrPhotoHouseMapper zyjrPhotoHouseMapper;
    @Autowired
    private ZyjrPhotoLenderMapper zyjrPhotoLenderMapper;
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;
    @Autowired
    private ZyjrGrantImageMapper zyjrGrantImageMapper;
    @Autowired
    private ZyjrGrantInstalmentsMapper zyjrGrantInstalmentsMapper;
    @Autowired
    private ZyjrGrantPhotoMapper zyjrGrantPhotoMapper;
    @Autowired
    private ZyjrGrantVisitMapper zyjrGrantVisitMapper;
    @Autowired
    private ZyjrAllowOpinionMapper zyjrAllowOpinionMapper;
    @Autowired
    private ExamineMapper examineMapper;
    @Autowired
    private ZyjrCommonApplicantMapper zyjrCommonApplicantMapper;
    @Autowired
    private ExamineController examineController;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private ZyjrLiushuiMapper zyjrLiushuiMapper;


    @Override
    public ZyjrBorrower findByBorrower(String transactionCode) {
        ZyjrBorrower borrower = examineDao.findByBorrower(transactionCode);
        return borrower;
    }

    @Override
    public List<ZyjrRelation> findByRelation(String transactionCode) {
        List<ZyjrRelation> relation = examineDao.findByRelation(transactionCode);
        return relation;
    }

    @Override
    public List<ZyjrGuarantee> findByGuarantee(String transactionCode) {
        List<ZyjrGuarantee> guarantee = examineDao.findByGuarantee(transactionCode);
        return guarantee;
    }

    @Override
    public ZyjrBusiness findByBusiness(String transactionCode) {
        ZyjrBusiness business = examineDao.findByBusiness(transactionCode);
        return business;
    }

    @Override
    public ExamineVo find(String transactionCode) {
        ExamineVo examineVo = new ExamineVo();
        ZyjrBorrower borrower=findByBorrower(transactionCode);
        if(borrower!=null&&borrower.getIdCard()!=null){

            String date= DataUtil.data(borrower.getIdCard().substring(6,14));
            borrower.setDate(date);
        }
        examineVo.setBorrower(borrower);
        examineVo.setBusiness(findByBusiness(transactionCode));
        examineVo.setRelation(findByRelation(transactionCode));
        examineVo.setGuarantee(findByGuarantee(transactionCode));
        examineVo.setStartPage(examineDao.findByStartPage(transactionCode));
        /**map.put("business", findByBusiness(transactionCode));
        map.put("borrower", findByBorrower(transactionCode));
        map.put("relation", findByRelation(transactionCode));
        map.put("guarantee", findByGuarantee(transactionCode));*/
        return examineVo;
    }

    @Override
    public int addBankDetails(ZyjrDetails q) {
        int count = examineDao.insertBank(q);
        return count;
    }

    @Override
    public ZyjrDetails findBankDetails(String transactionCode) {
        ZyjrDetails zyjrDetails = examineDao.findByDetails(transactionCode);
        return zyjrDetails;
    }

    @Override
    public Map<String, Object> findByAllow(Long userId, String transactionCode) {
        Map<String, Object> map = new HashMap<>();
        map.put("startPage",examineDao.findByStartPage(transactionCode));
        map.put("business",findByBusiness(transactionCode));
        map.put("borrower", examineDao.findByBorrower(transactionCode));
        map.put("relation",examineDao.findByRelation(transactionCode));
        map.put("guarantee",examineDao.findByGuarantee(transactionCode));
        ZyjrAllowApplicant zyjrAllowApplicant = zyjrAllowApplicantMapper.selectZyjrAllowApplicantById(userId, transactionCode);
        map.put("applicant",zyjrAllowApplicant);
        //ZyjrAllowBasics zyjrAllowBasics = zyjrAllowBasicsMapper.selectZyjrAllowBasicsById(userId, transactionCode);
        //map.put("basics",zyjrAllowBasics);
        ZyjrAllowContacts zyjrAllowContacts = zyjrAllowContactsMapper.selectZyjrAllowContactsById(userId, transactionCode);
        map.put("contacts",zyjrAllowContacts);
        //ZyjrDebtService zyjrDebtService = zyjrDebtServiceMapper.selectZyjrDebtServiceById(userId, transactionCode);
        //map.put("debtService",zyjrDebtService);
        ZyjrCarLoan zyjrCarLoan = zyjrCarLoanMapper.selectZyjrCarLoanById(userId, transactionCode);
        map.put("carLoan",zyjrCarLoan);

        ZyjrFundSide zyjrFundSide = examineMapper.findFundSide(transactionCode);
        map.put("fundSide",zyjrFundSide);
        //ZyjrCompanyGuarantee zyjrCompanyGuarantee = zyjrCompanyGuaranteeMapper.selectZyjrCompanyGuaranteeById(userId, transactionCode);
        //map.put("companyGuarantee",zyjrCompanyGuarantee);//担保公司
        //ZyjrPeopleGuarantee zyjrPeopleGuarantee = zyjrPeopleGuaranteeMapper.selectZyjrPeopleGuaranteeById(userId, transactionCode);
        //map.put("peopleGuarantee",zyjrPeopleGuarantee);//担保人
        ZyjrPhotoCar zyjrPhotoCar = zyjrPhotoCarMapper.selectZyjrPhotoCarById(userId, transactionCode);
        ZyjrPhotoCredit zyjrPhotoCredit = zyjrPhotoCreditMapper.selectZyjrPhotoCreditById(userId, transactionCode);
        ZyjrPhotoHouse zyjrPhotoHouse = zyjrPhotoHouseMapper.selectZyjrPhotoHouseById(userId, transactionCode);
        ZyjrPhotoLender zyjrPhotoLender = zyjrPhotoLenderMapper.selectZyjrPhotoLenderById(userId, transactionCode);
        ZyjrLiushui zyjrLiushui = zyjrLiushuiMapper.selectZyjrLiushuiById(transactionCode);
        if(zyjrLiushui!=null) {
            map.put("liushui", zyjrGrantPhotoMapper.findLiushui(zyjrLiushui.getId()));
        }
        if(zyjrPhotoHouse!=null) {
            map.put("house", sysFileInfoMapper.photoHouse(zyjrPhotoHouse.getId()));
        }
        /**if(zyjrAllowApplicant!=null&&zyjrAllowBasics!=null&&zyjrAllowContacts!=null&&zyjrCarLoan!=null&&zyjrPhotoCar!=null&&zyjrPhotoCredit!=null
        &&zyjrPhotoHouse!=null&&zyjrPhotoLender!=null){
            if(zyjrCompanyGuarantee!=null||zyjrPeopleGuarantee!=null) {
                map.put("stateId", 1);
            }
        }*/
        List<String> lists=new ArrayList<>();
        if (zyjrPhotoCar != null) {
            /**map.put("photoCar", sysFileInfoMapper.photoCar(zyjrPhotoCar.getId()));*/
       /*     map.put("photoCredit", sysFileInfoMapper.photoCredit(zyjrPhotoCredit.getId()));
            map.put("photoHouse", sysFileInfoMapper.photoHouse(zyjrPhotoHouse.getId()));
            map.put("photoLender", sysFileInfoMapper.photoLender(zyjrPhotoLender.getId()));*/

            List<SysFileInfo> a = sysFileInfoMapper.photoCar(zyjrPhotoCar.getId());
            for (SysFileInfo sysFileInfo : a) {
                lists.add(sysFileInfo.getFilePath());
                map.put(sysFileInfo.getFileName(), sysFileInfo.getFilePath());
            }
        }
          if(zyjrPhotoCredit!=null){  List<SysFileInfo> b=sysFileInfoMapper.photoCredit(zyjrPhotoCredit.getId());
              for (SysFileInfo sysFileInfo : b) {
                  lists.add(sysFileInfo.getFilePath());
                  map.put(sysFileInfo.getFileName(), sysFileInfo.getFilePath());
              }
          }
           /**if(zyjrPhotoHouse!=null){
               List<SysFileInfo> c=sysFileInfoMapper.photoHouse(zyjrPhotoHouse.getId());
               for (SysFileInfo sysFileInfo : c) {
                   lists.add(sysFileInfo.getFilePath());
                   map.put(sysFileInfo.getFileName(), sysFileInfo.getFilePath());
               }
           }*/
            if(zyjrPhotoLender!=null){
                List<SysFileInfo> d=sysFileInfoMapper.photoLender(zyjrPhotoLender.getId());
                for (SysFileInfo sysFileInfo : d) {
                    lists.add(sysFileInfo.getFilePath());
                    map.put(sysFileInfo.getFileName(), sysFileInfo.getFilePath());
                }
            }

            map.put("pic", lists);
        return map;
    }

    @Override
    public int addOpinion(ZyjrRepeatOpinion q) {
        //if(zyjrRepeatOpinion!=null&&zyjrAllowOpinionMapper.selectZyjrAllowOpinionById(q.getTransactionCode()).getApprovalType()==1){
        //}
        String date2 = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date());
        ZyjrRepeatOpinion zyjrRepeatOpinion = findOpinion(q.getTransactionCode());
        ZyjrBorrower zyjrBorrower = examineDao.findByBorrower(q.getTransactionCode());
        String date = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date()).substring(11, 19);

        if (q.getApprovalType() == 1) {
            WebSocket webSocket = new WebSocket();
            //String date = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date()).substring(11, 19);
            webSocket.sendMessage("终审已通过," + date + ",贷前资料审核," + q.getTransactionCode() + "");
            String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
            PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(), q.getTransactionCode(), "终审通过", stringsList);
            Xiaoxi xiaoxi=new Xiaoxi();
            xiaoxi.setCode(q.getTransactionCode());
            xiaoxi.setData("您的客户:"+zyjrBorrower.getUserName()+"在终审通过了！(订单号"+q.getTransactionCode()+")");
            xiaoxi.setDate(date2);
            xiaoxi.setUser(zyjrBorrower.getUserId().toString());
            examineMapper.insertXiaoxi(xiaoxi);
        } else if (q.getApprovalType() == 2) {
            String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
            PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(), q.getTransactionCode(), "终审退回", stringsList);

            ZyjrAllowOpinion zyjrAllowOpinion = new ZyjrAllowOpinion();
            zyjrAllowOpinion.setTransactionCode(q.getTransactionCode());
            zyjrAllowOpinion.setApprovalType(4);
            zyjrAllowOpinionMapper.updateZyjrAllowOpinion(zyjrAllowOpinion);
            Xiaoxi xiaoxi=new Xiaoxi();
            xiaoxi.setCode(q.getTransactionCode());
            xiaoxi.setData("您的客户:"+zyjrBorrower.getUserName()+"在终审退回了！(订单号"+q.getTransactionCode()+")");
            xiaoxi.setDate(date2);
            xiaoxi.setUser(zyjrBorrower.getUserId().toString());
            examineMapper.insertXiaoxi(xiaoxi);
        } else if (q.getApprovalType() == 3) {
            String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
            PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(), q.getTransactionCode(), "终审拒绝", stringsList);
            Xiaoxi xiaoxi=new Xiaoxi();
            xiaoxi.setCode(q.getTransactionCode());
            xiaoxi.setData("您的客户:"+zyjrBorrower.getUserName()+"在终审拒绝了！(订单号"+q.getTransactionCode()+")");
            xiaoxi.setDate(date2);
            xiaoxi.setUser(zyjrBorrower.getUserId().toString());
            examineMapper.insertXiaoxi(xiaoxi);

        }
        if(zyjrRepeatOpinion!=null){
            /**if(zyjrRepeatOpinion!=null&&zyjrRepeatOpinion.getApprovalType()==2) {
                ZyjrAllowOpinion zyjrAllowOpinion = new ZyjrAllowOpinion();
                zyjrAllowOpinion.setTransactionCode(q.getTransactionCode());
                zyjrAllowOpinion.setApprovalType(4);
                zyjrAllowOpinionMapper.updateZyjrAllowOpinion(zyjrAllowOpinion);
            }*/
            ZyjrRepeatOpinion i = q;
            i.setAdvise(q.getAdvise()+";"+date2);
            return examineDao.updateOpinion(i);
        }else {
            ZyjrRepeatOpinion i = q;
            i.setAdvise(q.getAdvise()+";"+date2);
            int count = examineDao.insertOpinion(i);
            /**if(zyjrRepeatOpinion!=null&&zyjrRepeatOpinion.getApprovalType()==2) {
             ZyjrAllowOpinion zyjrAllowOpinion = new ZyjrAllowOpinion();
             zyjrAllowOpinion.setTransactionCode(q.getTransactionCode());
             zyjrAllowOpinion.setApprovalType(4);
             zyjrAllowOpinionMapper.updateZyjrAllowOpinion(zyjrAllowOpinion);


             }else if(zyjrRepeatOpinion!=null&&zyjrRepeatOpinion.getApprovalType()==1){



             }else {

             }*/

            return count;
        }
    }

    @Override
    public ZyjrRepeatOpinion findOpinion(String transactionCode) {
        return examineDao.findOpinion(transactionCode);
    }

    @Override
    public List<ZyjrGrant> list(String name,Integer approvalType) {
        return examineDao.list(name,approvalType);
    }

    @Override
    public int addGrantOpinion(ZyjrGrantOpinion q) {
        ZyjrBorrower zyjrBorrower = examineDao.findByBorrower(q.getTransactionCode());
        ZyjrGrantOpinion zyjrGrantOpinion = examineDao.findGrantOpinion(q.getTransactionCode());
        SysUser sysUser=new SysUser();
        sysUser.setPhonenumber("9");
        sysUser.setUserName("10");
        String date = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date()).substring(11, 19);
        String date2 = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date());
        if (q.getApprovalType() == 2) {
            ZyjrSubmitStateGrant zyjrSubmitStateGrant = new ZyjrSubmitStateGrant();
            zyjrSubmitStateGrant.setSubmitState(0);
            zyjrSubmitStateGrant.setTransactionCode(q.getTransactionCode());
            examineMapper.updateGrantState(zyjrSubmitStateGrant);

            String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
            PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(), q.getTransactionCode(), "授信退回", stringsList);
            Xiaoxi xiaoxi=new Xiaoxi();
            xiaoxi.setCode(q.getTransactionCode());
            xiaoxi.setData("您的客户:"+zyjrBorrower.getUserName()+"在授信退回了！(订单号"+q.getTransactionCode()+")");
            xiaoxi.setDate(date2);
            xiaoxi.setUser(zyjrBorrower.getUserId().toString());
            examineMapper.insertXiaoxi(xiaoxi);
        } else if (q.getApprovalType() == 1) {
            ZyjrOrderProgress zyjrOrderProgress=new ZyjrOrderProgress();
            zyjrOrderProgress.setTransactionCode(q.getTransactionCode());
            zyjrOrderProgress.setApprovalType(3);
            zyjrOrderProgress.setProgress(3);
            examineMapper.updateOrderProgress(zyjrOrderProgress);
            String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
            PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(), q.getTransactionCode(), "授信通过", stringsList);
            Xiaoxi xiaoxi=new Xiaoxi();
            xiaoxi.setCode(q.getTransactionCode());
            xiaoxi.setData("您的客户:"+zyjrBorrower.getUserName()+"在授信通过了！(订单号"+q.getTransactionCode()+")");
            xiaoxi.setDate(date2);
            xiaoxi.setUser(zyjrBorrower.getUserId().toString());
            examineMapper.insertXiaoxi(xiaoxi);
        } else {
            String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
            PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(), q.getTransactionCode(), "授信拒绝", stringsList);
            Xiaoxi xiaoxi=new Xiaoxi();
            xiaoxi.setCode(q.getTransactionCode());
            xiaoxi.setData("您的客户:"+zyjrBorrower.getUserName()+"在授信拒绝了！(订单号"+q.getTransactionCode()+")");
            xiaoxi.setDate(date2);
            xiaoxi.setUser(zyjrBorrower.getUserId().toString());
            examineMapper.insertXiaoxi(xiaoxi);
        }
        if(zyjrGrantOpinion!=null){
            /**if (q.getApprovalType() == 2) {
                ZyjrSubmitStateGrant zyjrSubmitStateGrant = new ZyjrSubmitStateGrant();
                zyjrSubmitStateGrant.setSubmitState(0);
                zyjrSubmitStateGrant.setTransactionCode(q.getTransactionCode());
                examineMapper.updateGrantState(zyjrSubmitStateGrant);
            }*/
            ZyjrGrantOpinion i = q;
            i.setAdvise(q.getAdvise()+";"+date2);
            return examineDao.updateGrantOpinion(i);
        }else {
            ZyjrGrantOpinion i = q;
            i.setAdvise(q.getAdvise()+";"+date2);
            return examineDao.insertGrantOpinion(i);
        }
    }

    @Override
    public ZyjrGrantOpinion findGrantOpinion(String transactionCode) {
        return examineDao.findGrantOpinion(transactionCode);
    }

    @Override
    public List<ZyjrGrant> grant(String name,Integer approvalType) {
        return examineDao.findGrant(name,approvalType);
    }

    @Override
    public Map<String,Object>findByGrant(Long userId,String transactionCode){
        //Map<String, Object> map = new HashMap<>();
        Map<String, Object> map = examineController.findPhoto(userId,transactionCode);
        ZyjrDebtService zyjrDebtService = zyjrDebtServiceMapper.selectZyjrDebtServiceById(userId, transactionCode);
        map.put("debtService",zyjrDebtService);
        ZyjrCompanyGuarantee zyjrCompanyGuarantee = zyjrCompanyGuaranteeMapper.selectZyjrCompanyGuaranteeById(userId, transactionCode);
        map.put("companyGuarantee",zyjrCompanyGuarantee);
        ZyjrPeopleGuarantee zyjrPeopleGuarantee = zyjrPeopleGuaranteeMapper.selectZyjrPeopleGuaranteeById(userId, transactionCode);
        map.put("peopleGuarantee",zyjrPeopleGuarantee);
        ZyjrCommonApplicant zyjrCommonApplicant = zyjrCommonApplicantMapper.selectZyjrCommonApplicantById(transactionCode);
        map.put("common",zyjrCommonApplicant);
        /**ZyjrGrantImage zyjrGrantImage = zyjrGrantImageMapper.selectZyjrGrantImageById(transactionCode);
        ZyjrGrantInstalments zyjrGrantInstalments = zyjrGrantInstalmentsMapper.selectZyjrGrantInstalmentsById(transactionCode);
        ZyjrGrantVisit zyjrGrantVisit = zyjrGrantVisitMapper.selectZyjrGrantVisitById(transactionCode);
        //if (zyjrGrantImage!=null&&zyjrGrantInstalments!=null)
        if(zyjrGrantImage!=null&&zyjrGrantInstalments!=null) {
            map.put("basic", examineDao.findByGrant(transactionCode));
            map.put("image", zyjrGrantPhotoMapper.findImage(zyjrGrantImage.getId()));
            map.put("instalments", zyjrGrantPhotoMapper.findInstalments(zyjrGrantInstalments.getId()));
            //map.put("stateId",1);
            //System.err.println(111);
        }
        if(zyjrGrantVisit!=null) {
            map.put("visit", zyjrGrantPhotoMapper.findVisit(zyjrGrantVisit.getId()));
        }
        String 董宗杰 = "董宗杰垃圾";
      //System.err.println(董宗杰);*/


        return map;
    }

    @Override
    public List<ZyjrGrant> findAllow(String name,Integer approvalType) {

        return examineDao.findAllow(name,approvalType);
    }

}
