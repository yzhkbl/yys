package com.jeethink.system.controller;

import com.jeethink.common.core.controller.BaseController;
import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.core.page.TableDataInfo;
import com.jeethink.system.Helper.ResponseDto;
import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.orderVo;
import com.jeethink.system.mapper.*;
import com.jeethink.system.service.IExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/examine")
public class ExamineController extends BaseController {
    @Autowired
    private IExamineService examineService;
    @Autowired
    private ExamineMapper examineMapper;
    @Autowired
    private test t;
    @Autowired
    private ZyjrBusinessMapper zyjrBusinessMapper;
    @Autowired
    private ZyjrBorrowerMapper zyjrBorrowerMapper;
    @Autowired
    private ZyjrRelationMapper zyjrRelationMapper;
    @Autowired
    private ZyjrGuaranteeMapper zyjrGuaranteeMapper;

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
    public AjaxResult findBorrower(Integer userId){
        ZyjrBorrower borrower = examineService.findByBorrower(userId);
        return AjaxResult.success(borrower);
    }

    @RequestMapping("/find/relation")
    public AjaxResult findRelation(Integer userId){
        List<ZyjrRelation> relation = examineService.findByRelation(userId);
        return AjaxResult.success(relation);
    }

    @RequestMapping("/find/guarantee")
    public AjaxResult findGuarantee(Integer userId){
        List<ZyjrGuarantee> guarantee= examineService.findByGuarantee(userId);
        return AjaxResult.success(guarantee);
    }

    @RequestMapping("/find/business")
    public AjaxResult findBusiness(Integer userId){
        ZyjrBusiness business = examineService.findByBusiness(userId);
        return AjaxResult.success(business);
    }

    @RequestMapping("/find")
    public AjaxResult find(Integer userId){
        Map<String,Object> find = examineService.find(userId);
        return AjaxResult.success(find);
    }

    @RequestMapping("/add/start")
    public AjaxResult addByStart(ZyjrStartPage q){
        examineService.addByStart(q);
        return AjaxResult.success();
    }

    @RequestMapping("/find/start")
    public AjaxResult findByStart(Integer userId){
        ZyjrStartPage startPage = examineService.findByStart(userId);
        return AjaxResult.success(startPage);
    }

    @RequestMapping("/order")
    public AjaxResult order(Integer userId){
        String orderCode = examineService.order(userId);
        AjaxResult ajaxResult = t.find(orderCode);
        if (ajaxResult.get("code").equals(200)) {
            return AjaxResult.success(orderCode);
        }else {
            ZyjrBorrower zyjrBorrower = zyjrBorrowerMapper.selectById(orderCode);
            if(zyjrBorrower != null) {
                zyjrBorrower.setOrderState(0);
                //zyjrBorrower.setTransactionCode(null);
                zyjrBorrowerMapper.updateZyjrBorrower(zyjrBorrower);
            }

            ZyjrBusiness zyjrBusiness = zyjrBusinessMapper.selectById(orderCode);
            if(zyjrBusiness != null) {
                zyjrBusiness.setOrderState(0);
                //zyjrBusiness.setTransactionCode(null);
                zyjrBusinessMapper.updateZyjrBusiness(zyjrBusiness);
            }
            ZyjrRelation zyjrRelation = zyjrRelationMapper.selectById(orderCode);
            if(zyjrRelation != null) {
                zyjrRelation.setOrderState(0);
                //zyjrRelation.setTransactionCode(null);
                zyjrRelationMapper.updateZyjrRelation(zyjrRelation);
            }

            ZyjrGuarantee zyjrGuarantee = zyjrGuaranteeMapper.selectById(orderCode);
            if(zyjrRelation != null) {
                zyjrGuarantee.setOrderState(0);
                //zyjrGuarantee.setTransactionCode(null);
                zyjrGuaranteeMapper.updateZyjrGuarantee(zyjrGuarantee);
            }
            return ajaxResult;
        }
    }

    @RequestMapping("/findByState")
    public AjaxResult findbY(String transactionCode){
        ZyjrBorrower z= zyjrBorrowerMapper.selectById(transactionCode);
            if(z!=null){


        return AjaxResult.success(z.getContractState());
            }
            return  AjaxResult.success(z);
    }

    @GetMapping(value = "/{userId}")
    public TableDataInfo findOrder(@PathVariable("userId") Long userId){
        startPage();
        List<orderVo> list = examineService.findOrder(userId);
        return getDataTable(list);
    }

    @GetMapping("/total")
    public AjaxResult findExamine(String transactionCode){
        return AjaxResult.success(examineService.findExamine(transactionCode));
    }

    @GetMapping("/group")
    public AjaxResult findGroup(){
        return AjaxResult.success(examineService.findGroup());
    }

    @GetMapping("/series")
    public AjaxResult findSeries(Integer brandId){
        return AjaxResult.success(examineService.findSeries(brandId));
    }

    @GetMapping("/info")
    public AjaxResult findInfo(Integer brandId,Integer groupId){
        return AjaxResult.success(examineService.findInfo(brandId, groupId));
    }

    @GetMapping("/app/code")
    public AjaxResult findAppCode(){
        return AjaxResult.success(examineMapper.findAppCode());
    }

    @PostMapping("/cancel")
    public AjaxResult cancelOrder(Long userId){
        examineMapper.deleteBusiness(userId);
        examineMapper.deleteBorrower(userId);
        examineMapper.deleteRelation(userId);
        examineMapper.deleteGuarantee(userId);
        examineMapper.deleteStartPage(userId);
        return AjaxResult.success();
    }
}

