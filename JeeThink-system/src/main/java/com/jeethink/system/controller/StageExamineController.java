package com.jeethink.system.controller;

import com.jeethink.common.core.controller.BaseController;
import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.core.page.TableDataInfo;
import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.CarLoan;
import com.jeethink.system.domain.vo.ExamineVo;
import com.jeethink.system.domain.vo.ShangpaiDiyaVo;
import com.jeethink.system.domain.vo.ZyjrGrant;
import com.jeethink.system.mapper.ExamineMapper;
import com.jeethink.system.mapper.StageExamineMapper;
import com.jeethink.system.mapper.ZyjrGrantMapper;
import com.jeethink.system.service.IStageExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stage")
public class StageExamineController extends BaseController {
    @Autowired
    private IStageExamineService stageExamineService;
    @Autowired
    private StageExamineMapper stageExamineMapper;
    @Autowired
    private ExamineController examineController;
    @Autowired
    private ZyjrGrantMapper zyjrGrantMapper;
    @Autowired
    private ExamineMapper examineMapper;

    @RequestMapping("/find")
    public AjaxResult find(String transactionCode){
        ExamineVo examineVo = stageExamineService.find(transactionCode);
        return AjaxResult.success(examineVo);
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
      //  System.err.println(userId);
       // System.err.println(transactionCode);
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

    @RequestMapping("/list")//复审列表
    public TableDataInfo list(String name,Integer approvalType){
        startPage();
        List<ZyjrGrant>list = stageExamineService.list(name,approvalType);
        return getDataTable(list);
    }

    @RequestMapping("/grant/add")//授信审批
    public AjaxResult addGrantOpinion(@RequestBody ZyjrGrantOpinion q){
        return AjaxResult.success(stageExamineService.addGrantOpinion(q));
    }

    @GetMapping("/grant/find")
    public AjaxResult findGrantOpinion(String transactionCode){
        return AjaxResult.success(stageExamineService.findGrantOpinion(transactionCode));
    }

    @GetMapping("/grant")//授信列表
    public TableDataInfo findGrant(String name,Integer approvalType){
        startPage();
        List<ZyjrGrant>list = stageExamineService.grant(name,approvalType);
        return getDataTable(list);
    }

    @GetMapping("/grant/basic")
    public AjaxResult findByGrant(Long userId,String transactionCode){
        return AjaxResult.success(stageExamineService.findByGrant(userId,transactionCode));
    }

    @GetMapping("/allow")//准入列表
    public TableDataInfo findAllow (String name,Integer approvalType){
        startPage();
        List<ZyjrGrant>list = stageExamineService.findAllow(name,approvalType);
        //Collections.reverse(list);
        return getDataTable(list);
    }

    @GetMapping("/shangpai/list")
    public TableDataInfo findShangpai(){
        startPage();
        List<ShangpaiDiyaVo>list = stageExamineMapper.findShangpai();
        return getDataTable(list);
    }

    @PostMapping("/add/shangpai/opinion")
    public AjaxResult insertShangpaiOpinion(@RequestBody ZyjrGrantOpinion q){
        return AjaxResult.success(stageExamineMapper.insertShangpaiOpinion(q));
    }

    @GetMapping("/find/shangpai/opinion")
    public AjaxResult findShangpaiOpinion(String transactionCode){
        return AjaxResult.success(stageExamineMapper.findShangpaiOpinion(transactionCode));
    }

    @GetMapping("/diya/list")
    public TableDataInfo findDiya(){
        startPage();
        List<ShangpaiDiyaVo>list = stageExamineMapper.findDiya();
        return getDataTable(list);
    }

    @PostMapping("/add/diya/opinion")
    public AjaxResult insertDiyaOpinion(@RequestBody ZyjrGrantOpinion q){
        return AjaxResult.success(stageExamineMapper.insertDiyaOpinion(q));
    }

    @GetMapping("/find/diya/opinion")
    public AjaxResult findDiyaOpinion(String transactionCode){
        return AjaxResult.success(stageExamineMapper.findDiyaOpinion(transactionCode));
    }

    @PostMapping("/delete/allow/opinion")
    public AjaxResult deleteAllowOpinion(Long id){
        return AjaxResult.success(stageExamineMapper.deleteAllowOpinion(id));
    }


    @PostMapping("/delete/grant/opinion")
    public AjaxResult deleteRepeatOpinion(Long id){
        return AjaxResult.success(stageExamineMapper.deleteRepeatOpinion(id));
    }

    @PostMapping("/add/supplement")
    public AjaxResult addSupplement(@RequestBody ZyjrSupplement q){
        if(stageExamineMapper.findSupplement(q.getTransactionCode())!=null){
            return toAjax(stageExamineMapper.updateSupplement(q));
        }else {
            return toAjax(stageExamineMapper.addSupplement(q));
        }
    }

    @GetMapping("/find/supplement")
    public AjaxResult findSupplement(String transactionCode){
        return AjaxResult.success(stageExamineMapper.findSupplement(transactionCode));
    }

    @GetMapping("/now/grant")
    private AjaxResult findGrantNew(String transactionCode){
        Map<String,Object> map = new HashMap<>();
        ZyjrGrant2 zyjrGrant2 = zyjrGrantMapper.selectZyjrGrantById(transactionCode);
        ZyjrCarLoan zyjrCarLoan = examineMapper.findCar(transactionCode);
        ZyjrFundSide zyjrFundSide = examineMapper.findFundSide(transactionCode);
        CarLoan carLoan = new CarLoan();
        carLoan.setFundSide(zyjrFundSide.getSideName());
        carLoan.setRepaymentTerm(zyjrCarLoan.getRepaymentTerm());
        if(zyjrCarLoan.getRepaymentTerm()==24){
            BigDecimal a = new BigDecimal(6);
            carLoan.setDkfl(a);
        }
        if(zyjrCarLoan.getRepaymentTerm()==36) {
            BigDecimal a = new BigDecimal(9);
            carLoan.setDkfl(a);
        }
        carLoan.setActualPrice(zyjrCarLoan.getActualPrice());
        carLoan.setLoanAmount(zyjrCarLoan.getLoanAmount());
        carLoan.setProductType(zyjrCarLoan.getProductType());
        carLoan.setLoanProduct(zyjrCarLoan.getLoanProduct());
        BigDecimal e = new BigDecimal(100);
        carLoan.setInterestRate(zyjrCarLoan.getInterestRate());
        carLoan.setGpsCost(zyjrCarLoan.getGpsCost());
        carLoan.setDeposit(zyjrCarLoan.getDeposit());
        BigDecimal a = carLoan.getInterestRate();
        BigDecimal b = carLoan.getDkfl();
        BigDecimal c = carLoan.getLoanAmount();
        carLoan.setFuwufei(((a.subtract(b)).multiply(c).divide(e)).setScale(0,BigDecimal.ROUND_UP));
        carLoan.setSqsf((carLoan.getActualPrice().subtract(carLoan.getLoanAmount())).setScale(0,BigDecimal.ROUND_UP));
        carLoan.setZdke((carLoan.getFuwufei().add(carLoan.getLoanAmount())).setScale(0,BigDecimal.ROUND_UP));
        BigDecimal qi = new BigDecimal(1);
        BigDecimal qi1 = new BigDecimal(carLoan.getRepaymentTerm());
        BigDecimal benjin = carLoan.getLoanAmount().divide(qi1,2,BigDecimal.ROUND_UP);
        //System.err.println(benjin);
        BigDecimal benjin1 = carLoan.getLoanAmount().subtract(benjin.multiply(qi1.subtract(qi)));
        //System.err.println(benjin1);
        BigDecimal persxf = (carLoan.getLoanAmount().multiply(carLoan.getDkfl())).divide(qi1,2,BigDecimal.ROUND_UP);
        //System.err.println(persxf);
        BigDecimal sxf1 = (carLoan.getLoanAmount().multiply(carLoan.getDkfl())).subtract(persxf.multiply(qi1.subtract(qi)));
        //System.err.println(sxf1);
        BigDecimal perbenjin1 = carLoan.getFuwufei().divide(qi1,2,BigDecimal.ROUND_UP);
        //System.err.println(perbenjin1);
        BigDecimal benjin11 = carLoan.getFuwufei().subtract(perbenjin1.multiply(qi1.subtract(qi)));
        //System.err.println(benjin11);
        BigDecimal persxf1 = (carLoan.getFuwufei().multiply(carLoan.getDkfl())).divide(qi1,2,BigDecimal.ROUND_UP);
        //System.err.println(persxf1);
        BigDecimal sxf11 = (carLoan.getFuwufei().multiply(carLoan.getDkfl())).subtract(persxf1.multiply(qi1.subtract(qi)));
        //System.err.println(sxf11);
        BigDecimal yuehuan = benjin1.add(sxf1.divide(e)).add(benjin11).add(sxf11.divide(e)).setScale(0,BigDecimal.ROUND_UP);
        //System.err.println(yuehuan);
        carLoan.setSqyg(yuehuan);
        map.put("left",carLoan);
        map.put("right",zyjrGrant2);
        return AjaxResult.success(map);
    }

    /**我的客户*/
    @GetMapping("/my/customer")
    public TableDataInfo myCustomer(Long userId){
        startPage();
        List<ZyjrGrant>list = stageExamineMapper.myCustomer(userId);
        return getDataTable(list);
    }
}
