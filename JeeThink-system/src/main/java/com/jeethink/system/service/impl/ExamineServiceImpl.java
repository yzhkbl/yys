package com.jeethink.system.service.impl;

import com.jeethink.system.domain.*;
import com.jeethink.system.mapper.ExamineMapper;
import com.jeethink.system.service.IExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExamineServiceImpl implements IExamineService {
    @Autowired
    private ExamineMapper examineDao;


    @Override
    public int addByBorrower(ZyjrBorrower q) {
        if(findByBorrower(q.getIdentityId())!=null&&q.getOrderState()==0){
            int count = examineDao.updateBorrower(q);
            return count;
        } else {
            int count = examineDao.insertBorrower(q);
            return count;

        }
    }

    @Override
    public int addByRelation(ZyjrRelation q) {
        if(findByRelation(q.getIdentityId())!=null&&q.getOrderState()==0){
            int count = examineDao.updateRelation(q);
            return count;
        } else {
            int count = examineDao.insertRelation(q);
            return count;

        }
    }

    @Override
    public int addByGuarantee(ZyjrGuarantee q) {
        if(findByGuarantee(q.getIdentityId())!=null&&q.getOrderState()==0){
            int count = examineDao.updateGuarantee(q);
            return count;
        } else {
            int count = examineDao.insertGuarantee(q);
            return count;

        }
    }

    @Override
    public int addByBusiness(ZyjrBusiness q) {
        if(findByBusiness(q.getIdentityId())!=null&&q.getOrderState()==0){
            int count = examineDao.updateBusiness(q);
            return count;
        } else {
            int count = examineDao.insertBusiness(q);
            return count;

        }
    }



    @Override
    public ZyjrBorrower findByBorrower(String id) {
        ZyjrBorrower borrower = examineDao.findByBorrower(id);
        return borrower;
    }

    @Override
    public ZyjrRelation findByRelation(String id) {
        ZyjrRelation relation = examineDao.findByRelation(id);
        return relation;
    }

    @Override
    public ZyjrGuarantee findByGuarantee(String id) {
        ZyjrGuarantee guarantee = examineDao.findByGuarantee(id);
        return guarantee;
    }

    @Override
    public ZyjrBusiness findByBusiness(String id) {
        ZyjrBusiness business = examineDao.findByBusiness(id);
        return business;
    }

    @Override
    public Map<String,Object> find(String id){
        Map<String,Object>map = new HashMap<>();
        map.put("business",findByBusiness(id));
        map.put("borrower",findByBorrower(id));
        map.put("relation",findByRelation(id));
        map.put("guarantee",findByGuarantee(id));
        map.put("start",findByStart(id));
        System.out.println(map);
        return map;
    }

    @Override
    public int addByStart(StartPage q) {
        StartPage startPage = new StartPage();
        startPage.setId(q.getId());
        startPage.setFundSide(q.getFundSide());
        startPage.setBusinessPlace(q.getBusinessPlace());
        startPage.setOrderState(q.getOrderState());
        startPage.setIdentityId(q.getIdentityId());
        examineDao.updateOne(true);
        examineDao.updateTwo(true);
        examineDao.updateThree(true);
        examineDao.updateFour(true);
        if(findByStart(q.getIdentityId())!=null&&q.getOrderState()==false){
            int count = examineDao.insertStart(startPage);

            return count;
        } else {
            return 0;
        }
    }

    @Override
    public StartPage findByStart(String id) {
        StartPage startPage = examineDao.findByStart(id);
        return startPage;
    }
}
