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
        if(findByBorrower(q.getUserId())!=null&&q.getOrderState()==0){
            int count = examineDao.updateBorrower(q);
            return count;
        } else {
            int count = examineDao.insertBorrower(q);
            return count;

        }
    }

    @Override
    public int addByRelation(ZyjrRelation q) {
        if(findByRelation(q.getUserId())!=null&&q.getOrderState()==0){
            int count = examineDao.updateRelation(q);
            return count;
        } else {
            int count = examineDao.insertRelation(q);
            return count;

        }
    }

    @Override
    public int addByGuarantee(ZyjrGuarantee q) {
        if(findByGuarantee(q.getUserId())!=null&&q.getOrderState()==0){
            int count = examineDao.updateGuarantee(q);
            return count;
        } else {
            int count = examineDao.insertGuarantee(q);
            return count;

        }
    }

    @Override
    public int addByBusiness(ZyjrBusiness q) {
        if(findByBusiness(q.getUserId())!=null&&q.getOrderState()==0){
            int count = examineDao.updateBusiness(q);
            return count;
        } else {
            int count = examineDao.insertBusiness(q);
            return count;

        }
    }



    @Override
    public ZyjrBorrower findByBorrower(Integer userId) {
        ZyjrBorrower borrower = examineDao.findByBorrower(userId);
        return borrower;
    }

    @Override
    public ZyjrRelation findByRelation(Integer userId) {
        ZyjrRelation relation = examineDao.findByRelation(userId);
        return relation;
    }

    @Override
    public ZyjrGuarantee findByGuarantee(Integer userId) {
        ZyjrGuarantee guarantee = examineDao.findByGuarantee(userId);
        return guarantee;
    }

    @Override
    public ZyjrBusiness findByBusiness(Integer userId) {
        ZyjrBusiness business = examineDao.findByBusiness(userId);
        return business;
    }

    @Override
    public Map<String,Object> find(Integer userId){
        Map<String,Object>map = new HashMap<>();
        map.put("business",findByBusiness(userId));
        map.put("borrower",findByBorrower(userId));
        map.put("relation",findByRelation(userId));
        map.put("guarantee",findByGuarantee(userId));
        map.put("start",findByStart(userId));
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
        startPage.setUserId(q.getUserId());
        examineDao.updateOne(true);
        examineDao.updateTwo(true);
        examineDao.updateThree(true);
        examineDao.updateFour(true);
        if(findByStart(q.getUserId())!=null&&q.getOrderState()==false){
            int count = examineDao.insertStart(startPage);

            return count;
        } else {
            return 0;
        }
    }

    @Override
    public StartPage findByStart(Integer userId) {
        StartPage startPage = examineDao.findByStart(userId);
        return startPage;
    }
}