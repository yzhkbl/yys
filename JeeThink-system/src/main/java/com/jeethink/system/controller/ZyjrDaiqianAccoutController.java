package com.jeethink.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.DqVo;
import com.jeethink.system.mapper.*;
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
import com.jeethink.system.service.IZyjrDaiqianAccoutService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-05
 */
@RestController
@RequestMapping("/system/accout")
public class ZyjrDaiqianAccoutController extends BaseController
{
    @Autowired
    private IZyjrDaiqianAccoutService zyjrDaiqianAccoutService;
    @Autowired
    private ZyjrDaiqianAccoutMapper zyjrDaiqianAccoutMapper;
    @Autowired
    private ZyjrAllowBasicsMapper zyjrAllowBasicsMapper;
    @Autowired
    private ZyjrCarAccountMapper zyjrCarAccountMapper;
    @Autowired
    private ExamineMapper examineMapper;
    @Autowired
    private ZyjrGpsMapper zyjrGpsMapper;
    @Autowired
    private ZyjrInsuranceMapper zyjrInsuranceMapper;
    @Autowired
    private ZyjrGrantImageMapper zyjrGrantImageMapper;
    @Autowired
    private ZyjrGrantInstalmentsMapper zyjrGrantInstalmentsMapper;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:accout:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrDaiqianAccout zyjrDaiqianAccout)
    {
        startPage();
        List<ZyjrDaiqianAccout> list = zyjrDaiqianAccoutService.selectZyjrDaiqianAccoutList(zyjrDaiqianAccout);
        return getDataTable(list);
    }


    @PostMapping("/no")
    public AjaxResult li(@RequestBody ZyjrDaiqian zyjrDaiqian)
    {

        ZyjrDaiqian as=examineMapper.selByDaiqian(zyjrDaiqian.getTransactionCode());
        if(as!=null){
            examineMapper.updateByDaiqian(zyjrDaiqian);
        }else{
            examineMapper.insertDaiqian(zyjrDaiqian);
        }

        if(as!=null&&zyjrDaiqian.getState()!=null&&zyjrDaiqian.getState().equals("2")){
            as.setGps("2");
            as.setInsurance("2");
            as.setAccount("2");
            as.setTijiao("0");
            as.setState("2");
            as.setGpsPic("2");
            examineMapper.updateByDaiqian2(as);
            ZyjrGrantImage zyjrGrantImage = zyjrGrantImageMapper.selectZyjrGrantImageById(zyjrDaiqian.getTransactionCode());
            zyjrGrantImage.setOrderState(2);
            zyjrGrantImageMapper.updateZyjrGrantImage(zyjrGrantImage);
            ZyjrGrantInstalments zyjrGrantInstalments = zyjrGrantInstalmentsMapper.selectZyjrGrantInstalmentsById(zyjrDaiqian.getTransactionCode());
            zyjrGrantInstalments.setOrderState(2);
            zyjrGrantInstalmentsMapper.updateZyjrGrantInstalments(zyjrGrantInstalments);
        }


        return AjaxResult.success();
    }

    @GetMapping("/yes/{transactionCode}")
    public AjaxResult list(@PathVariable("transactionCode")  String transactionCode)
    {
        ZyjrDaiqian as=examineMapper.selByDaiqian(transactionCode);

        return AjaxResult.success(as);
    }



    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:accout:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrDaiqianAccout zyjrDaiqianAccout)
    {
        List<ZyjrDaiqianAccout> list = zyjrDaiqianAccoutService.selectZyjrDaiqianAccoutList(zyjrDaiqianAccout);
        ExcelUtil<ZyjrDaiqianAccout> util = new ExcelUtil<ZyjrDaiqianAccout>(ZyjrDaiqianAccout.class);
        return util.exportExcel(list, "accout");
    }

    @GetMapping("getAccout/{transactionCode}")
    public AjaxResult apps(@PathVariable("transactionCode") String transactionCode){
        ZyjrDaiqian daiqian=examineMapper.selByDaiqian(transactionCode);
        ZyjrDaiqianAccout a=zyjrDaiqianAccoutMapper.selectById(transactionCode);
        AjaxResult json=new AjaxResult();
        json.put("msg","操作成功");
        json.put("code",200);
        if(a!=null){
            ZyjrCarAccount c=zyjrCarAccountMapper.selectZyjrCarAccountByStringId(a.getAccountId());
            ZyjrCarAccount d=zyjrCarAccountMapper.selectZyjrCarAccountByStringId(a.getAccountOne());
            ZyjrCarAccount e=zyjrCarAccountMapper.selectZyjrCarAccountByStringId(a.getFangkuan());
            Map<String,Object> map=new HashMap<>();
            map.put("fangkuan",e);
            map.put("account",c);
            map.put("account2",d);
            json.put("data",map);
            json.put("type",a.getType());
            return json;
        }
        json.put("data",null);
        return json;
    }

    @GetMapping("tijiao")
    public AjaxResult tijiao(String transactionCode){
        ZyjrDaiqian a=examineMapper.selByDaiqian(transactionCode);
        if(a!=null&&a.getGps()!=null&&a.getAccount()!=null&&a.getInsurance()!=null&&a.getGpsPic()!=null){
            a.setTijiao("1");
            examineMapper.updateByDaiqian2(a);
            return AjaxResult.success();
        }else{
            return AjaxResult.success("提交失败，您的信息未填完整,请完善信息！");
        }

    }

    @GetMapping("getInfo/{id}")
    public AjaxResult apqp(@PathVariable("id") String id){
                ZyjrCarAccount zyjrCarAccount=new ZyjrCarAccount();
                zyjrCarAccount.setZyjrCarId(id);
                List<ZyjrCarAccount> c=zyjrCarAccountMapper.selectZyjrCarAccountList(zyjrCarAccount);
                return AjaxResult.success(c);
    }
    @GetMapping("getZhanghu/{id}")
    public AjaxResult zhanghu(@PathVariable("id") String id){
        ZyjrCarAccount a=zyjrCarAccountMapper.selectZyjrCarAccountByStringId(id);
        return  AjaxResult.success(a);
    }

    @GetMapping("state")
    public AjaxResult state(String transactionCode){
        ZyjrDaiqian as=examineMapper.selByDaiqian(transactionCode);
        Map<String,Object> map=new HashMap<>();
        ZyjrGrantImage zyjrGrantImage = zyjrGrantImageMapper.selectZyjrGrantImageById(transactionCode);
        if(zyjrGrantImage!=null&&zyjrGrantImage.getOrderState()!=null){
            map.put("yingxiang",zyjrGrantImage.getOrderState().toString());
        }else{
            map.put("yingxiang",null);
        }
        ZyjrGrantInstalments zyjrGrantInstalments = zyjrGrantInstalmentsMapper.selectZyjrGrantInstalmentsById(transactionCode);
        if(zyjrGrantInstalments!=null&&zyjrGrantInstalments.getOrderState()!=null){
            map.put("fenqi",zyjrGrantInstalments.getOrderState().toString());
        }else{
            map.put("fenqi",null);
        }

        if(as!=null){
        map.put("gps",as.getGps());
        map.put("gpsPic",as.getGpsPic());
        map.put("zhanghu",as.getAccount());
        map.put("baoxian",as.getInsurance());
        map.put("tijiao",as.getTijiao());
            return AjaxResult.success(map);
        }
        map.put("gps",null);
        map.put("gpsPic",null);
        map.put("zhanghu",null);
        map.put("baoxian",null);
        map.put("tijiao",null);
        return AjaxResult.success(map);
    }



    @PostMapping("update")
    public AjaxResult insert(ZyjrDaiqianAccout zyjrDaiqianAccout){
        ZyjrDaiqianAccout ids=zyjrDaiqianAccoutMapper.selectById(zyjrDaiqianAccout.getTransactionCode());
        ZyjrDaiqian as=examineMapper.selByDaiqian(zyjrDaiqianAccout.getTransactionCode());
        if(as!=null){
            as.setAccount(zyjrDaiqianAccout.getState());
            examineMapper.updateByDaiqian2(as);
        }else{
            ZyjrDaiqian d=new ZyjrDaiqian();
            d.setAccount(zyjrDaiqianAccout.getState());
            d.setTransactionCode(zyjrDaiqianAccout.getTransactionCode());
            examineMapper.insertDaiqian2(d);
        }
        if(ids!=null){
            zyjrDaiqianAccout.setId(ids.getId());
            zyjrDaiqianAccoutMapper.updateZyjrDaiqianAccout(zyjrDaiqianAccout);
            return  AjaxResult.success();
        }
        zyjrDaiqianAccoutMapper.insertZyjrDaiqianAccout(zyjrDaiqianAccout);

        return  AjaxResult.success();
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
 /*   @PreAuthorize("@ss.hasPermi('system:accout:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrDaiqianAccoutService.selectZyjrDaiqianAccoutById(id));
    }*/

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:accout:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrDaiqianAccout zyjrDaiqianAccout)
    {
        return toAjax(zyjrDaiqianAccoutService.insertZyjrDaiqianAccout(zyjrDaiqianAccout));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:accout:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrDaiqianAccout zyjrDaiqianAccout)
    {
        return toAjax(zyjrDaiqianAccoutService.updateZyjrDaiqianAccout(zyjrDaiqianAccout));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:accout:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrDaiqianAccoutService.deleteZyjrDaiqianAccoutByIds(ids));
    }
}
