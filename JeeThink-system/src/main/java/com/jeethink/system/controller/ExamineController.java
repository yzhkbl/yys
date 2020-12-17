package com.jeethink.system.controller;

import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.system.Helper.ResponseDto;
import com.jeethink.system.domain.*;
import com.jeethink.system.service.IExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/examine")
public class ExamineController {
    @Autowired
    private IExamineService examineService;

    @RequestMapping("/add/borrower")
    public AjaxResult addBorrower(ZyjrBorrower q){
        examineService.addByBorrower(q);
        return AjaxResult.success();
    }

    @RequestMapping("/add/relation")
    public AjaxResult addRelation(ZyjrRelation q){
        examineService.addByRelation(q);
        return AjaxResult.success();
    }

    @RequestMapping("/add/guarantee")
    public AjaxResult addGuarantee(ZyjrGuarantee q){
        examineService.addByGuarantee(q);
        return AjaxResult.success();
    }

    @RequestMapping("/add/business")
    public AjaxResult addBusiness(ZyjrBusiness q){
        examineService.addByBusiness(q);
        return AjaxResult.success();
    }

    @RequestMapping("/find/borrower")
    public AjaxResult findBorrower(Integer orderState){
        ZyjrBorrower borrower = examineService.findByBorrower(orderState);
        return AjaxResult.success(borrower);
    }

    @RequestMapping("/find/relation")
    public AjaxResult findRelation(Integer orderState){
        ZyjrRelation relation = examineService.findByRelation(orderState);
        return AjaxResult.success(relation);
    }

    @RequestMapping("/find/guarantee")
    public AjaxResult findGuarantee(Integer orderState){
        ZyjrGuarantee guarantee= examineService.findByGuarantee(orderState);
        return AjaxResult.success(guarantee);
    }

    @RequestMapping("/find/business")
    public AjaxResult findBusiness(Integer orderState){
        ZyjrBusiness business = examineService.findByBusiness(orderState);
        return AjaxResult.success(business);
    }

    @RequestMapping("/find")
    public AjaxResult find(Integer orderState){
        Map<String,Object> find = examineService.find(orderState);
        return AjaxResult.success(find);
    }

    @RequestMapping("/add/start")
    public AjaxResult addByStart(ZyjrStartPage q){
        examineService.addByStart(q);
        return AjaxResult.success();
    }

    @RequestMapping("/find/start")
    public AjaxResult findByStart(Integer orderState){
        ZyjrStartPage startPage = examineService.findByStart(orderState);
        return AjaxResult.success(startPage);
    }
}
