package com.jeethink.system.controller;

import com.jeethink.common.core.controller.BaseController;
import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.core.page.TableDataInfo;
import com.jeethink.system.domain.ZyjrBusiness;
import com.jeethink.system.domain.ZyjrDetails;
import com.jeethink.system.domain.ZyjrGrantOpinion;
import com.jeethink.system.domain.ZyjrRepeatOpinion;
import com.jeethink.system.domain.vo.ZyjrGrant;
import com.jeethink.system.service.IStageExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stage")
public class StageExamineController extends BaseController {
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

    @RequestMapping("/add/opinion")
    public AjaxResult addOpinion(@RequestBody ZyjrRepeatOpinion q){
        return AjaxResult.success(stageExamineService.addOpinion(q));
    }

    @RequestMapping("/find/opinion")
    public AjaxResult findOpinion(String transactionCode){
        return AjaxResult.success(stageExamineService.findOpinion(transactionCode));
    }

    @RequestMapping("/list")
    public TableDataInfo list(){
        startPage();
        List<ZyjrGrant>list = stageExamineService.list();
        return getDataTable(list);
    }

    @RequestMapping("/grant/add")
    public AjaxResult addGrantOpinion(@RequestBody ZyjrGrantOpinion q){
        return AjaxResult.success(stageExamineService.addGrantOpinion(q));
    }

    @GetMapping("/grant/find")
    public AjaxResult findGrantOpinion(String transactionCode){
        return AjaxResult.success(stageExamineService.findGrantOpinion(transactionCode));
    }

    @GetMapping("/grant")
    public TableDataInfo findGrant(){
        startPage();
        List<ZyjrGrant>list = stageExamineService.grant();
        return getDataTable(list);
    }
}
