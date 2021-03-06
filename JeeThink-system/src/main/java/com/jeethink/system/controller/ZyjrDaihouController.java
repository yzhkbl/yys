package com.jeethink.system.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jeethink.common.utils.DateUtils;
import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.UserVo;
import com.jeethink.system.domain.vo.Xiaoxi;
import com.jeethink.system.mapper.*;
import com.jeethink.system.util.PushMessageByPushIdTest;
import com.jeethink.system.util.WebSocket;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jeethink.common.annotation.Log;
import com.jeethink.common.core.controller.BaseController;
import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.enums.BusinessType;
import com.jeethink.system.service.IZyjrDaihouService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@RestController
@RequestMapping("/system/daihou")
public class ZyjrDaihouController extends BaseController
{
    @Autowired
    private IZyjrDaihouService zyjrDaihouService;
    @Autowired
    private ZyjrDaihouBaoxianMapper zyjrDaihouBaoxianMapper;
    @Autowired
    private ZyjrDaihouLvbenMapper zyjrDaihouLvbenMapper;
    @Autowired
    private ZyjrDaihouQitaMapper zyjrDaihouQitaMapper;
    @Autowired
    private ZyjrDaihouTicheMapper zyjrDaihouTicheMapper;
    @Autowired
    private ZyjrDaihouZhengshuMapper zyjrDaihouZhengshuMapper;
    @Autowired
    private ZyjrDaihouMapper zyjrDaihouMapper;
    @Autowired
    private ExamineMapper examineMapper;
    @Autowired
    private ZyjrCailiaoMapper zyjrCailiaoMapper;
    @Autowired
    private ZyjrBorrowerMapper zyjrBorrowerMapper;
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询【请填写功能名称】列表
     */

    @GetMapping("/list")
    public TableDataInfo list(ZyjrDaihou zyjrDaihou)
    {
        startPage();
        List<ZyjrDaihou> list = zyjrDaihouService.selectZyjrDaihouList(zyjrDaihou);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:daihou:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrDaihou zyjrDaihou)
    {
        List<ZyjrDaihou> list = zyjrDaihouService.selectZyjrDaihouList(zyjrDaihou);
        ExcelUtil<ZyjrDaihou> util = new ExcelUtil<ZyjrDaihou>(ZyjrDaihou.class);
        return util.exportExcel(list, "daihou");
    }

    @PostMapping("/get/user")
    public AjaxResult ajaxResult(@RequestBody UserVo userVo){
        ZyjrDaihou zyjrDaihou=new ZyjrDaihou();
            if(userVo!=null){
                zyjrDaihou.setId(Long.valueOf(userVo.getId()));
                zyjrDaihou.setUserId(userVo.getUserId());
                zyjrDaihou.setOperator(userVo.getOperator());
            }else{
                zyjrDaihou.setId(Long.valueOf(userVo.getId()));
            }
        zyjrDaihouMapper.updateZyjrDaihous(zyjrDaihou);
         return AjaxResult.success();
    }

    @PostMapping("tijiao")
    public AjaxResult tijiao(String transactionCode){
        ZyjrDaihou zyjrDaihou = zyjrDaihouMapper.selectZyjrDaihouByT(transactionCode);
        if(zyjrDaihou!=null&&zyjrDaihou.getZhengshu()!=null){
            zyjrDaihou.setTijiao("1");
            zyjrDaihouMapper.updateZyjrDaihou(zyjrDaihou);
            WebSocket webSocket=new WebSocket();
            String date= DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS,new Date()).substring(11,19);
            webSocket.sendMessage("贷后来新单了,"+date+",车资审核,"+transactionCode+"");
            return AjaxResult.success();
        }else{
            return AjaxResult.success("提交失败，您的信息未填完整,请完善信息！");
        }
    }



    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        Map<String,Object> map=new HashMap<>();
        ZyjrDaihou a=zyjrDaihouService.selectZyjrDaihouById(id);
        map.put("shenpi",a);

        if(a!=null){
            ZyjrDaihouBaoxian zyjrDaihouBaoxian=new ZyjrDaihouBaoxian();
            zyjrDaihouBaoxian.setDaihou(a.getId().toString());
            List<ZyjrDaihouBaoxian> b=zyjrDaihouBaoxianMapper.selectZyjrDaihouBaoxianList(zyjrDaihouBaoxian);
            for (ZyjrDaihouBaoxian daihouBaoxian : b) {
                map.put(daihouBaoxian.getFileName(),daihouBaoxian.getFilePath());
            }
            List<String> bb=b.stream().map(ZyjrDaihouBaoxian::getFilePath).collect(Collectors.toList());
            ZyjrDaihouLvben c=zyjrDaihouLvbenMapper.selectZyjrDaihouLvbenById(a.getId());
            ZyjrDaihouTiche zyjrDaihouTiche=new ZyjrDaihouTiche();
            zyjrDaihouTiche.setDaihou(a.getId().toString());
            List<ZyjrDaihouTiche> d=zyjrDaihouTicheMapper.selectZyjrDaihouTicheList(zyjrDaihouTiche);
            for (ZyjrDaihouTiche daihouBaoxian : d) {
             //   map.put(daihouBaoxian.getFileName(),daihouBaoxian.getFilePath());
            }
            List<String> dd=d.stream().map(ZyjrDaihouTiche::getFilePath).collect(Collectors.toList());
            ZyjrDaihouQita qita=new ZyjrDaihouQita();
            qita.setDaihou(a.getId().toString());
            List<ZyjrDaihouQita> e=zyjrDaihouQitaMapper.selectZyjrDaihouQitaList(qita);
            for (ZyjrDaihouQita daihouBaoxian : e) {
            //    map.put(daihouBaoxian.getFileName(),daihouBaoxian.getFilePath());
            }
            List<String> ee=e.stream().map(ZyjrDaihouQita::getFilePath).collect(Collectors.toList());
            ZyjrDaihouZhengshu zyjrDaihouZhengshu=new ZyjrDaihouZhengshu();
            zyjrDaihouZhengshu.setDaihou(a.getId().toString());
            List<ZyjrDaihouZhengshu> f=zyjrDaihouZhengshuMapper.selectZyjrDaihouZhengshuList(zyjrDaihouZhengshu);
            for (ZyjrDaihouZhengshu daihouBaoxian : f) {
                map.put(daihouBaoxian.getFileName(),daihouBaoxian.getFilePath());
            }
            List<String> ff=f.stream().map(ZyjrDaihouZhengshu::getFilePath).collect(Collectors.toList());


            map.put("baoxian",bb);
            /*map.put("lvben",c);
            map.put("tiche",dd);
            map.put("qita",ee);*/
            map.put("zhengshu",ff);
        }


        return AjaxResult.success(map);
    }



    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:daihou:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrDaihou zyjrDaihou)
    {
        return toAjax(zyjrDaihouService.insertZyjrDaihou(zyjrDaihou));
    }

    @GetMapping("ok")
    public AjaxResult g(ZyjrDaihou zyjrDaihou)
    {

        return toAjax(zyjrDaihouService.updateZyjrDaihou(zyjrDaihou)
        );
    }
    @GetMapping("state")
    public AjaxResult gg(String transactionCode){
        ZyjrDaihou a=zyjrDaihouMapper.selectZyjrDaihouByT(transactionCode);
        a.setState("0");
        zyjrDaihouMapper.updateZyjrDaihou(a);
        return AjaxResult.success();
    }
    @GetMapping("state2")
    public AjaxResult ggg(String transactionCode){
        ZyjrDaihou as=zyjrDaihouMapper.selectZyjrDaihouByT(transactionCode);
        Map<String,Object> map=new HashMap<>();
        if(as!=null){
            map.put("zhengshu",as.getZhengshu());
            map.put("tiche",as.getTiche());
            map.put("qita",as.getQita());
            map.put("lvben",as.getLvben());
            map.put("baoxian",as.getBaoxian());
            map.put("tijiao",as.getTijiao());
            return AjaxResult.success(map);
        }
        map.put("zhengshu",null);
        map.put("tiche",null);
        map.put("qita",null);
        map.put("lvben",null);
        map.put("baoxian",null);
        map.put("tijiao",null);
        return AjaxResult.success(map);
    }

    @PostMapping("go")
    public AjaxResult sg(@RequestBody ZyjrDaihou zyjrDaihou)
    {
        String date = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date());
        if(zyjrDaihou.getOpinion()!=null){

            zyjrDaihou.setOpinion(zyjrDaihou.getOpinion()+";"+date);
        }
        ZyjrBorrower zyjrBorrower = zyjrBorrowerMapper.selectById(zyjrDaihou.getTransactionCode());
        if(zyjrDaihou!=null&&zyjrDaihou.getState().equals("1")){

            ZyjrCailiao zyjrCailiao=new ZyjrCailiao();
            zyjrCailiao.setTransactionCode(zyjrDaihou.getTransactionCode());
            List<ZyjrCailiao> zyjrCailiaos = zyjrCailiaoMapper.selectZyjrCailiaoList2(zyjrCailiao);
            if(zyjrCailiaos.size()<1){
                zyjrCailiaoMapper.insertZyjrCailiao(zyjrCailiao);
            }
            String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
            PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(),zyjrDaihou.getTransactionCode(),"贷后通过",stringsList,zyjrDaihou.getOpinion());
            Xiaoxi xiaoxi=new Xiaoxi();
            xiaoxi.setCode(zyjrDaihou.getTransactionCode());
            xiaoxi.setData("您的客户:"+zyjrBorrower.getUserName()+"在贷后通过了！(订单号"+zyjrDaihou.getTransactionCode()+"),通过意见:"+zyjrDaihou.getOpinion());
            xiaoxi.setDate(date);
            xiaoxi.setUser(zyjrBorrower.getUserId().toString());
            examineMapper.insertXiaoxi(xiaoxi);

        }
        examineMapper.updateByDaihou(zyjrDaihou);

        if(zyjrDaihou!=null&&zyjrDaihou.getState().equals("2")){
            ZyjrDaihou zyjrDaihou2=zyjrDaihouMapper.selectZyjrDaihouByT(zyjrDaihou.getTransactionCode());

            zyjrDaihou2.setTijiao("0");
            zyjrDaihou2.setState("2");
            zyjrDaihouMapper.updateZyjrDaihou(zyjrDaihou2);
            String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
            PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(),zyjrDaihou.getTransactionCode(),"贷后退回",stringsList,zyjrDaihou.getOpinion());
            Xiaoxi xiaoxi=new Xiaoxi();
            xiaoxi.setCode(zyjrDaihou.getTransactionCode());
            xiaoxi.setData("您的客户:"+zyjrBorrower.getUserName()+"在贷后退回了！(订单号"+zyjrDaihou.getTransactionCode()+"),退回意见:"+zyjrDaihou.getOpinion());
            xiaoxi.setDate(date);
            xiaoxi.setUser(zyjrBorrower.getUserId().toString());
            examineMapper.insertXiaoxi(xiaoxi);
        }else if(zyjrDaihou!=null&&zyjrDaihou.getState().equals("3")){
            String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
            PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(),zyjrDaihou.getTransactionCode(),"贷后拒绝",stringsList,zyjrDaihou.getOpinion());
            Xiaoxi xiaoxi=new Xiaoxi();
            xiaoxi.setCode(zyjrDaihou.getTransactionCode());
            xiaoxi.setData("您的客户:"+zyjrBorrower.getUserName()+"在贷后拒绝了！(订单号"+zyjrDaihou.getTransactionCode()+"),拒绝意见:"+zyjrDaihou.getOpinion());
            xiaoxi.setDate(date);
            xiaoxi.setUser(zyjrBorrower.getUserId().toString());
            examineMapper.insertXiaoxi(xiaoxi);
        }
        return AjaxResult.success();
    }

    /**
     * 修改【请填写功能名称】
     */

    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrDaihou zyjrDaihou)
    {
        return toAjax(zyjrDaihouService.updateZyjrDaihou(zyjrDaihou));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:daihou:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrDaihouService.deleteZyjrDaihouByIds(ids));
    }
}
