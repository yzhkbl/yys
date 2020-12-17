package com.jeethink.system.service.impl;

import com.jeethink.system.domain.*;
import com.jeethink.system.mapper.StageExamineMapper;
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
    public Map<String,Object> find(String transactionCode){
        Map<String,Object> map = new HashMap<>();
        map.put("business",findByBusiness(transactionCode));
        map.put("borrower",findByBorrower(transactionCode));
        map.put("relation",findByRelation(transactionCode));
        map.put("guarantee",findByGuarantee(transactionCode));
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

}
