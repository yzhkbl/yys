package com.jeethink.system.controller;

import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.system.domain.ZyjrDetails;
import com.jeethink.system.service.IStageExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{userId}/{transactionCode}")
    public AjaxResult findAllow(@PathVariable("userId") Long userId,@PathVariable("transactionCode")String transactionCode){
        System.err.println(userId);
        System.err.println(transactionCode);
        return AjaxResult.success(stageExamineService.findByAllow(userId, transactionCode));
    }
}
