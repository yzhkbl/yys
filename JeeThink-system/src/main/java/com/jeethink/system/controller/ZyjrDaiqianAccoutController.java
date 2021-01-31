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

        ZyjrDaiqian a=zyjrAllowBasicsMapper.selectByT(transactionCode);
        if(a!=null){
            ZyjrCarAccount zyjrCarAccount=new ZyjrCarAccount();
            zyjrCarAccount.setZyjrCarId(a.getId().toString());
            List<ZyjrCarAccount> c=zyjrCarAccountMapper.selectZyjrCarAccountList(zyjrCarAccount);
            return AjaxResult.success("操作成功",c);
        }
        return AjaxResult.success("操作成功",null);
    }

    @GetMapping("getInfo/{transactionCode}/{id}")
    public AjaxResult apqp(@PathVariable("transactionCode") String transactionCode,@PathVariable("id") String id){
        if(id!=null){
            ZyjrCarAccount c=zyjrCarAccountMapper.selectZyjrCarAccountByStringId(id);
            return AjaxResult.success(c);
        }
            ZyjrDaiqianAccout a=zyjrDaiqianAccoutService.selectZyjrDaiqianAccoutByIds(transactionCode);
            if(a!=null){
                ZyjrCarAccount b=zyjrCarAccountMapper.selectZyjrCarAccountByStringId(a.getAccountId());
                ZyjrCarAccount c=zyjrCarAccountMapper.selectZyjrCarAccountByStringId(a.getAccountOne());
                Map<String,Object> map=new HashMap<>();
                map.put("Account",b);
                map.put("Account2",c);
                return AjaxResult.success(map);
            }
            ZyjrDaiqian b=zyjrAllowBasicsMapper.selectByT(transactionCode);
            if(b!=null){
                ZyjrCarAccount c=zyjrCarAccountMapper.selectZyjrCarAccountById(b.getDealersId());
                return AjaxResult.success(c);
            }


           return AjaxResult.success();
    }




    @PostMapping("update")
    public AjaxResult insert(ZyjrDaiqianAccout zyjrDaiqianAccout){
        ZyjrInsurance ids=zyjrInsuranceMapper.selectZyjrInsuranceByIds(zyjrDaiqianAccout.getTransactionCode());
        ZyjrDaiqian as=examineMapper.selByDaiqian(zyjrDaiqianAccout.getTransactionCode());
        if(as!=null){
            as.setAccount("1");
            examineMapper.updateByDaiqian2(as);
        }else{
            ZyjrDaiqian d=new ZyjrDaiqian();
            d.setAccount("1");
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
    @PreAuthorize("@ss.hasPermi('system:accout:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrDaiqianAccoutService.selectZyjrDaiqianAccoutById(id));
    }

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
