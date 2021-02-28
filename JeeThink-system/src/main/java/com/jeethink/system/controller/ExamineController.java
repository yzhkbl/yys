package com.jeethink.system.controller;

import com.jeethink.common.core.controller.BaseController;
import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.core.page.TableDataInfo;
import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.GrantPhoto;
import com.jeethink.system.domain.vo.fileInfoDto;
import com.jeethink.system.domain.vo.fileInfoVo;
import com.jeethink.system.domain.vo.orderVo;
import com.jeethink.system.mapper.*;
import com.jeethink.system.service.IExamineService;
import com.jeethink.system.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
    @Autowired
    private ZyjrPhotoCarController zyjrPhotoCarController;
    @Autowired
    private ZyjrPhotoCreditController zyjrPhotoCreditController;
    @Autowired
    private ZyjrPhotoHouseController zyjrPhotoHouseController;
    @Autowired
    private ZyjrPhotoLenderController zyjrPhotoLenderController;
    @Autowired
    private ZyjrGrantVisitController zyjrGrantVisitController;
    @Autowired
    private ZyjrLiushuiController zyjrLiushuiController;

    @RequestMapping("/add/borrower")
    public AjaxResult addBorrower(ZyjrBorrower q){

        return toAjax(examineService.addByBorrower(q));
    }

    @RequestMapping("/add/relation")
    public AjaxResult addRelation(ZyjrRelation q){

        return toAjax(examineService.addByRelation(q));
    }

    @RequestMapping("/add/guarantee")
    public AjaxResult addGuarantee(ZyjrGuarantee q){

        return toAjax(examineService.addByGuarantee(q));
    }

    @RequestMapping("/add/business")
    public AjaxResult addBusiness(ZyjrBusiness q){

        return toAjax(examineService.addByBusiness(q));
    }

    @RequestMapping("/find/borrower")
    public AjaxResult findBorrower(Integer userId){
        ZyjrBorrower borrower = examineService.findByBorrower(userId);
        if(borrower!=null&&borrower.getIdCard()!=null){

            String date=DataUtil.data(borrower.getIdCard().substring(6,14));
            borrower.setDate(date);
        }
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
        ZyjrOrderProgress zyjrOrderProgress=new ZyjrOrderProgress();
        zyjrOrderProgress.setTransactionCode(q.getTransactionCode());
        zyjrOrderProgress.setApprovalType(0);
        zyjrOrderProgress.setProgress(0);
        examineMapper.insertOrderProgress(zyjrOrderProgress);
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

    @GetMapping
    public TableDataInfo findOrder(Long userId,Integer progress){
        startPage();
        List<orderVo> list = examineService.findOrder(userId,progress);
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

    @PostMapping("/delete/relation")
    public AjaxResult deleteRelationById(Long id){
        return AjaxResult.success(examineMapper.deleteRelationById(id));
    }

    @PostMapping("/delete/guarantee")
    public AjaxResult deleteGuaranteeById(Long id){
        return AjaxResult.success(examineMapper.deleteGuaranteeById(id));
    }


    @PostMapping("/add/shangpai")
    public AjaxResult insertShangpai(ZyjrShangpai q){
        ZyjrShangpai zyjrShangpai = examineMapper.findShangpai(q.getTransactionCode());
        if(zyjrShangpai!=null){
            return toAjax(examineMapper.updateShangpai(q));
        }else {
            return toAjax(examineMapper.insertShangpai(q));
        }
    }


    @PostMapping("/stage/shangpai")
    public AjaxResult insertStageShangpai(@RequestBody ZyjrShangpai q){
        ZyjrShangpai zyjrShangpai = examineMapper.findShangpai(q.getTransactionCode());
        if(zyjrShangpai!=null){
            return toAjax(examineMapper.updateShangpai(q));
        }else {
            return toAjax(examineMapper.insertShangpai(q));
        }
    }


    @GetMapping("/find/shangpai")
    public AjaxResult findShangpai(String transactionCode){
        return AjaxResult.success(examineMapper.findShangpai(transactionCode));
    }


    @PostMapping("/add/diya")
    public AjaxResult insertDiya(ZyjrDiya q){
        ZyjrDiya zyjrDiya = examineMapper.findDiya(q.getTransactionCode());
        if(zyjrDiya!=null){
            return toAjax(examineMapper.updateDiya(q));
        }else {
            return toAjax(examineMapper.insertDiya(q));
        }
    }


    @PostMapping("/stage/diya")
    public AjaxResult insertStageDiya(@RequestBody ZyjrDiya q){
        ZyjrDiya zyjrDiya = examineMapper.findDiya(q.getTransactionCode());
        if(zyjrDiya!=null){
            return toAjax(examineMapper.updateDiya(q));
        }else {
            return toAjax(examineMapper.insertDiya(q));
        }
    }


    @GetMapping("/find/diya")
    public AjaxResult findDiya(String transactionCode){
        return AjaxResult.success(examineMapper.findDiya(transactionCode));
    }

    @GetMapping("/search/order")
    public TableDataInfo searchOrder(String search,Long userId){
        startPage();
        List<orderVo> list = examineMapper.searchOrder(search,userId);
        return getDataTable(list);
    }

    @GetMapping("/relation/name")
    public AjaxResult relationName(String transactionCode){
        return AjaxResult.success(examineMapper.relationName(transactionCode));
    }

    @GetMapping("/relation/id")
    public AjaxResult relationById(Long id){
        return AjaxResult.success(examineMapper.findById(id));
    }


    @PostMapping("/add/fundSide")
    public AjaxResult insertFundSide(ZyjrFundSide zyjrFundSide){
        if(examineMapper.findFundSide(zyjrFundSide.getTransactionCode())!=null){
            return toAjax(examineMapper.updateFundSide(zyjrFundSide));
        }else {
            return toAjax(examineMapper.insertFundSide(zyjrFundSide));
        }
        //return AjaxResult.success();
    }

    @GetMapping("/find/fundSide")
    public AjaxResult findFundSide(String transactionCode){
        return AjaxResult.success(examineMapper.findFundSide(transactionCode));
    }

    @PostMapping("/add/allow/state")
    public AjaxResult addAllowState(ZyjrSubmitStateAllow q){
        ZyjrOrderProgress zyjrOrderProgress=new ZyjrOrderProgress();
        zyjrOrderProgress.setTransactionCode(q.getTransactionCode());
        zyjrOrderProgress.setApprovalType(2);
        zyjrOrderProgress.setProgress(2);
        examineMapper.updateOrderProgress(zyjrOrderProgress);
        if(examineMapper.findAllowState(q.getTransactionCode())!=null){
            return toAjax(examineMapper.updateAllowState(q));
        }else {
            return toAjax(examineMapper.addAllowState(q));
        }
    }

    @PostMapping("/add/grant/state")
    public AjaxResult addGrantState(ZyjrSubmitStateGrant q){
        ZyjrOrderProgress zyjrOrderProgress=new ZyjrOrderProgress();
        zyjrOrderProgress.setTransactionCode(q.getTransactionCode());
        zyjrOrderProgress.setApprovalType(3);
        zyjrOrderProgress.setProgress(3);
        examineMapper.updateOrderProgress(zyjrOrderProgress);
        if(examineMapper.findGrantState(q.getTransactionCode())!=null){
            return toAjax(examineMapper.updateGrantState(q));
        }else {
            return toAjax(examineMapper.addGrantState(q));
        }
    }

    @GetMapping("/find/allowList")
    public AjaxResult allowList(String transactionCode){
        return AjaxResult.success(examineMapper.allowList(transactionCode));
    }

    @GetMapping("/find/grantList")
    public AjaxResult grantList(String transactionCode){
        return AjaxResult.success(examineMapper.grantList(transactionCode));
    }

    @PostMapping("/total/photo")
    public AjaxResult photoTotal(fileInfoVo q){
        Map<String,Object>map = new HashMap<>();
        if(q.getCarPhoto()!=null) {
            AjaxResult a = zyjrPhotoCarController.testFiles(q);
            map.put("car",a);
        }
        if(q.getCreditPhoto()!=null) {
            AjaxResult b = zyjrPhotoCreditController.testFiles(q);
            map.put("credit",b);
        }
        if(q.getHousePhoto()!=null) {
            AjaxResult c = zyjrPhotoHouseController.testFiles(q);
            map.put("house",c);
        }
        if(q.getLenderPhoto()!=null) {
            AjaxResult d = zyjrPhotoLenderController.testFiles(q);
            map.put("qita",d);
        }
        if(q.getVisitPhoto()!=null) {
            AjaxResult e = zyjrGrantVisitController.testFiles(q);
            map.put("visit",e);
        }
        if(q.getLiushuiPhoto()!=null){
            AjaxResult f = zyjrLiushuiController.testFiles(q);
            map.put("liushui",f);
        }
        return AjaxResult.success(map);
    }


    @GetMapping("/find/photo")
    public AjaxResult findPhoto(Long userId,String transactionCode){
        fileInfoDto a = zyjrPhotoCarController.findPhoto(userId, transactionCode);
        fileInfoDto b = zyjrPhotoCreditController.findPhoto(userId,transactionCode);
        fileInfoDto c = zyjrPhotoHouseController.findPhoto(userId, transactionCode);
        fileInfoDto d = zyjrPhotoLenderController.findPhoto(userId, transactionCode);
        GrantPhoto e = zyjrGrantVisitController.findPhoto(transactionCode);
        GrantPhoto f = zyjrLiushuiController.findPhoto(transactionCode);
        ZyjrBorrower zyjrBorrower = examineMapper.Borrower(transactionCode);
        List<String>list = new ArrayList<>();
        list.add(0,zyjrBorrower.getObverseAddress());
        list.add(1,zyjrBorrower.getBackAddress());
        Map<String,Object>map = new HashMap<>();
        map.put("car",a);
        map.put("credit",b);
        map.put("house",c);
        map.put("qita",d);
        map.put("visit",e);
        map.put("liushui",f);
        map.put("borrower",list);
        return AjaxResult.success(map);
    }


    @GetMapping("/approval")
    public AjaxResult opinion(String transactionCode){
        return AjaxResult.success(examineMapper.findApType(transactionCode));
    }
}

