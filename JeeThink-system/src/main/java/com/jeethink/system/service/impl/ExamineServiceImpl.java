package com.jeethink.system.service.impl;

import com.jeethink.common.utils.uuid.IdUtils;
import com.jeethink.system.domain.*;
import com.jeethink.system.mapper.ExamineMapper;
import com.jeethink.system.service.IExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import  com.jeethink.system.util.orderCode;

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
    public ZyjrBorrower findByBorrower(Integer orderState) {
        ZyjrBorrower borrower = examineDao.findByBorrower(orderState);
        return borrower;
    }

    @Override
    public ZyjrRelation findByRelation(Integer orderState) {
        ZyjrRelation relation = examineDao.findByRelation(orderState);
        return relation;
    }

    @Override
    public ZyjrGuarantee findByGuarantee(Integer orderState) {
        ZyjrGuarantee guarantee = examineDao.findByGuarantee(orderState);
        return guarantee;
    }

    @Override
    public ZyjrBusiness findByBusiness(Integer orderState) {
        ZyjrBusiness business = examineDao.findByBusiness(orderState);
        return business;
    }

    @Override
    public Map<String,Object> find(Integer orderState){
        Map<String,Object>map = new HashMap<>();
        map.put("business",findByBusiness(orderState));
        map.put("borrower",findByBorrower(orderState));
        map.put("relation",findByRelation(orderState));
        map.put("guarantee",findByGuarantee(orderState));
        map.put("start",findByStart(orderState));
        return map;
    }



    @Override
    public int addByStart(ZyjrStartPage q) {
        ZyjrStartPage startPage = new ZyjrStartPage();
        startPage.setId(q.getId());
        startPage.setFundSide(q.getFundSide());
        startPage.setBusinessPlace(q.getBusinessPlace());
        startPage.setOrderState(q.getOrderState());
        startPage.setUserId(q.getUserId());

        String a = orderCode.getOrderCode();
        String b = IdUtils.simpleUUID();

        startPage.setTransactionCode(a);
        startPage.setPrivateCode(b);
        examineDao.updateOne(true,a);
        examineDao.updateTwo(true,a);
        examineDao.updateThree(true,a);
        examineDao.updateFour(true,a);
        if(findByStart(q.getUserId())!=null&&q.getOrderState()==0){
            int count = examineDao.insertStart(startPage);

            return count;
        } else {
            return 0;
        }
    }

    @Override
    public ZyjrStartPage findByStart(Integer orderState) {
        ZyjrStartPage startPage = examineDao.findByStart(orderState);
        return startPage;
    }
}
