package com.jeethink.system.controller;

import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.system.domain.ZyjrDetails;
import com.jeethink.system.service.IStageExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stage")
public class StageExamineController {
    @Autowired
    private IStageExamineService stageExamineService;

    @RequestMapping("/find")
    public AjaxResult find(String transactionCode){
        Map<String,Object> list = stageExamineService.find(transactionCode);
        return AjaxResult.success(list);
    }

    @RequestMapping("/add/details")
    public AjaxResult addDetails(@RequestBody ZyjrDetails q){
        int count = stageExamineService.addBankDetails(q);
        return AjaxResult.success(count);
    }

    @RequestMapping("/find/details")
    public AjaxResult findDetails(String transactionCode){
        return AjaxResult.success(stageExamineService.findBankDetails(transactionCode));
    }
}
