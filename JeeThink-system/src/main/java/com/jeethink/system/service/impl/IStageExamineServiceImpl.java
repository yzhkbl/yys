package com.jeethink.system.service.impl;

import com.jeethink.system.domain.*;
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


    @Override
    public ZyjrBorrower findByBorrower(String transactionCode) {
        ZyjrBorrower borrower = examineDao.findByBorrower(transactionCode);
        return borrower;
    }

    @Override
    public ZyjrRelation findByRelation(String transactionCode) {
        ZyjrRelation relation = examineDao.findByRelation(transactionCode);
        return relation;
    }

    @Override
    public ZyjrGuarantee findByGuarantee(String transactionCode) {
        ZyjrGuarantee guarantee = examineDao.findByGuarantee(transactionCode);
        return guarantee;
    }

    @Override
    public ZyjrBusiness findByBusiness(String transactionCode) {
        ZyjrBusiness business = examineDao.findByBusiness(transactionCode);
        return business;
    }

    @Override
    public Map<String, Object> find(String transactionCode) {
        Map<String, Object> map = new HashMap<>();
        map.put("business", findByBusiness(transactionCode));
        map.put("borrower", findByBorrower(transactionCode));
        map.put("relation", findByRelation(transactionCode));
        map.put("guarantee", findByGuarantee(transactionCode));
        return map;
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
        if (zyjrPhotoCar != null && zyjrPhotoCredit != null && zyjrPhotoHouse != null && zyjrPhotoLender != null) {
            /*map.put("photoCar", sysFileInfoMapper.photoCar(zyjrPhotoCar.getId()));*/
       /*     map.put("photoCredit", sysFileInfoMapper.photoCredit(zyjrPhotoCredit.getId()));
            map.put("photoHouse", sysFileInfoMapper.photoHouse(zyjrPhotoHouse.getId()));
            map.put("photoLender", sysFileInfoMapper.photoLender(zyjrPhotoLender.getId()));*/

            List<SysFileInfo> a = sysFileInfoMapper.photoCar(zyjrPhotoCar.getId());

            List<SysFileInfo> b=sysFileInfoMapper.photoCredit(zyjrPhotoCredit.getId());
            List<SysFileInfo> c=sysFileInfoMapper.photoHouse(zyjrPhotoHouse.getId());
            List<SysFileInfo> d=sysFileInfoMapper.photoLender(zyjrPhotoLender.getId());


            List<String> lists=new ArrayList<>();

            for (SysFileInfo sysFileInfo : a) {
                lists.add(sysFileInfo.getFilePath());
                map.put(sysFileInfo.getFileName(), sysFileInfo.getFilePath());
            }
            for (SysFileInfo sysFileInfo : b) {
                lists.add(sysFileInfo.getFilePath());
                map.put(sysFileInfo.getFileName(), sysFileInfo.getFilePath());
            }
            for (SysFileInfo sysFileInfo : c) {
                lists.add(sysFileInfo.getFilePath());
                map.put(sysFileInfo.getFileName(), sysFileInfo.getFilePath());
            }
            for (SysFileInfo sysFileInfo : d) {
                lists.add(sysFileInfo.getFilePath());
                map.put(sysFileInfo.getFileName(), sysFileInfo.getFilePath());
            }
            map.put("pic", lists);
        }
        return map;
    }

    @Override
    public int addOpinion(ZyjrRepeatOpinion q) {
        return examineDao.insertOpinion(q);
    }

    @Override
    public ZyjrRepeatOpinion findOpinion(String transactionCode) {
        return examineDao.findOpinion(transactionCode);
    }

    @Override
    public List<ZyjrBusiness> list() {
        return examineDao.list();
    }
}
