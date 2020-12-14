package com.jeethink.system.controller;

import com.jeethink.system.Helper.ResponseDto;
import com.jeethink.system.domain.*;
import com.jeethink.system.service.IExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/examine")
public class ExamineController {
    @Autowired
    private IExamineService examineService;

    @RequestMapping("/add/borrower")
    public ResponseDto addBorrower(ZyjrBorrower q){
        examineService.addByBorrower(q);
        return ResponseDto.success();
    }

    @RequestMapping("/add/relation")
    public ResponseDto addRelation(ZyjrRelation q){
        examineService.addByRelation(q);
        return ResponseDto.success();
    }

    @RequestMapping("/add/guarantee")
    public ResponseDto addGuarantee(ZyjrGuarantee q){
        examineService.addByGuarantee(q);
        return ResponseDto.success();
    }

    @RequestMapping("/add/business")
    public ResponseDto addBusiness(ZyjrBusiness q){
        examineService.addByBusiness(q);
        return ResponseDto.success();
    }

    @RequestMapping("/find/borrower")
    public ResponseDto findBorrower(Integer userId){
        ZyjrBorrower borrower = examineService.findByBorrower(userId);
        return ResponseDto.success(borrower);
    }

    @RequestMapping("/find/relation")
    public ResponseDto findRelation(Integer userId){
        ZyjrRelation relation = examineService.findByRelation(userId);
        return ResponseDto.success(relation);
    }

    @RequestMapping("/find/guarantee")
    public ResponseDto findGuarantee(Integer userId){
        ZyjrGuarantee guarantee= examineService.findByGuarantee(userId);
        return ResponseDto.success(guarantee);
    }

    @RequestMapping("/find/business")
    public ResponseDto findBusiness(Integer userId){
        ZyjrBusiness business = examineService.findByBusiness(userId);
        return ResponseDto.success(business);
    }

    @RequestMapping("/find")
    public ResponseDto find(Integer userId){
        Map<String,Object> find = examineService.find(userId);
        return ResponseDto.success(find);
    }

    @RequestMapping("/add/start")
    public ResponseDto addByStart(StartPage q){
        examineService.addByStart(q);
        return ResponseDto.success();
    }

    @RequestMapping("/find/start")
    public ResponseDto findByStart(Integer userId){
        StartPage startPage = examineService.findByStart(userId);
        return ResponseDto.success(startPage);
    }
}
