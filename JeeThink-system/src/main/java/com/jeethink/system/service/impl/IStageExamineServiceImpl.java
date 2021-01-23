package com.jeethink.system.service.impl;

import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.ExamineVo;
import com.jeethink.system.domain.vo.ZyjrGrant;
import com.jeethink.system.mapper.*;
import com.jeethink.system.service.IStageExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        examineVo.setBorrower(findByBorrower(transactionCode));
        examineVo.setBusiness(findByBusiness(transactionCode));
        examineVo.setRelation(findByRelation(transactionCode));
        examineVo.setGuarantee(findByGuarantee(transactionCode));
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
        map.put("borrower", examineDao.findByBorrower(transactionCode));
        map.put("applicant", zyjrAllowApplicantMapper.selectZyjrAllowApplicantById(userId, transactionCode));
        map.put("basics", zyjrAllowBasicsMapper.selectZyjrAllowBasicsById(userId, transactionCode));
        map.put("contacts", zyjrAllowContactsMapper.selectZyjrAllowContactsById(userId, transactionCode));
        map.put("debtService", zyjrDebtServiceMapper.selectZyjrDebtServiceById(userId, transactionCode));
        map.put("carLoan", zyjrCarLoanMapper.selectZyjrCarLoanById(userId, transactionCode));
        map.put("companyGuarantee", zyjrCompanyGuaranteeMapper.selectZyjrCompanyGuaranteeById(userId, transactionCode));
        map.put("peopleGuarantee", zyjrPeopleGuaranteeMapper.selectZyjrPeopleGuaranteeById(userId, transactionCode));
        ZyjrPhotoCar zyjrPhotoCar = zyjrPhotoCarMapper.selectZyjrPhotoCarById(userId, transactionCode);
        ZyjrPhotoCredit zyjrPhotoCredit = zyjrPhotoCreditMapper.selectZyjrPhotoCreditById(userId, transactionCode);
        ZyjrPhotoHouse zyjrPhotoHouse = zyjrPhotoHouseMapper.selectZyjrPhotoHouseById(userId, transactionCode);
        ZyjrPhotoLender zyjrPhotoLender = zyjrPhotoLenderMapper.selectZyjrPhotoLenderById(userId, transactionCode);
        List<String> lists=new ArrayList<>();
        if (zyjrPhotoCar != null) {
            /*map.put("photoCar", sysFileInfoMapper.photoCar(zyjrPhotoCar.getId()));*/
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
           if(zyjrPhotoHouse!=null){
               List<SysFileInfo> c=sysFileInfoMapper.photoHouse(zyjrPhotoHouse.getId());
               for (SysFileInfo sysFileInfo : c) {
                   lists.add(sysFileInfo.getFilePath());
                   map.put(sysFileInfo.getFileName(), sysFileInfo.getFilePath());
               }
           }
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
        ZyjrRepeatOpinion zyjrRepeatOpinion = findOpinion(q.getTransactionCode());
        //if(zyjrRepeatOpinion!=null&&zyjrAllowOpinionMapper.selectZyjrAllowOpinionById(q.getTransactionCode()).getApprovalType()==1){

        //}
        int count = examineDao.insertOpinion(q);
        if(zyjrRepeatOpinion!=null&&zyjrRepeatOpinion.getApprovalType()==2){
            ZyjrAllowOpinion zyjrAllowOpinion = new ZyjrAllowOpinion();
            zyjrAllowOpinion.setApprovalType(4);
            zyjrAllowOpinionMapper.updateZyjrAllowOpinion(zyjrAllowOpinion);
        }
        return count;
    }

    @Override
    public ZyjrRepeatOpinion findOpinion(String transactionCode) {
        return examineDao.findOpinion(transactionCode);
    }

    @Override
    public List<ZyjrGrant> list() {
        return examineDao.list();
    }

    @Override
    public int addGrantOpinion(ZyjrGrantOpinion q) {
        return examineDao.insertGrantOpinion(q);
    }

    @Override
    public ZyjrGrantOpinion findGrantOpinion(String transactionCode) {
        return examineDao.findGrantOpinion(transactionCode);
    }

    @Override
    public List<ZyjrGrant> grant() {
        return examineDao.findGrant();
    }

    @Override
    public Map<String,Object>findByGrant(String transactionCode){
        Map<String, Object> map = new HashMap<>();
        ZyjrGrantImage zyjrGrantImage = zyjrGrantImageMapper.selectZyjrGrantImageById(transactionCode);
        ZyjrGrantInstalments zyjrGrantInstalments = zyjrGrantInstalmentsMapper.selectZyjrGrantInstalmentsById(transactionCode);
        ZyjrGrantVisit zyjrGrantVisit = zyjrGrantVisitMapper.selectZyjrGrantVisitById(transactionCode);
        map.put("basic",examineDao.findByGrant(transactionCode));
        map.put("image",zyjrGrantPhotoMapper.findImage(zyjrGrantImage.getId()));
        map.put("instalments",zyjrGrantPhotoMapper.findInstalments(zyjrGrantInstalments.getId()));
        map.put("visit",zyjrGrantPhotoMapper.findVisit(zyjrGrantVisit.getId()));
        String 董宗杰 = "董宗杰垃圾";
        System.err.println(董宗杰);
        return map;
    }

    @Override
    public List<ZyjrGrant> findAllow() {
        return examineDao.findAllow();
    }

}
