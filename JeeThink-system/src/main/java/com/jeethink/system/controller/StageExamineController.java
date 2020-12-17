package com.jeethink.system.controller;

import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.system.service.IStageExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stage")
public class StageExamineController {
    @Autowired
    private IStageExamineService stageExamineService;

    @RequestMapping("/find")
    public AjaxResult find(String transactionCode){
        List<Object> list = stageExamineService.find(transactionCode);
        return AjaxResult.success(list);
    }
}
