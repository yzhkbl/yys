package com.jeethink.system.controller;

import java.util.List;

import com.jeethink.system.domain.ZyjrDaihou;
import com.jeethink.system.domain.ZyjrDaihouBaoxian;
import com.jeethink.system.domain.ZyjrDaihouTiche;
import com.jeethink.system.mapper.ZyjrDaihouMapper;
import net.sf.json.JSONArray;
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
import com.jeethink.system.domain.ZyjrDaihouZhengshu;
import com.jeethink.system.service.IZyjrDaihouZhengshuService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@RestController
@RequestMapping("/system/zhengshu")
public class ZyjrDaihouZhengshuController extends BaseController
{
    @Autowired
    private IZyjrDaihouZhengshuService zyjrDaihouZhengshuService;
    @Autowired
    private ZyjrDaihouMapper zyjrDaihouMapper;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:zhengshu:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrDaihouZhengshu zyjrDaihouZhengshu)
    {
        startPage();
        List<ZyjrDaihouZhengshu> list = zyjrDaihouZhengshuService.selectZyjrDaihouZhengshuList(zyjrDaihouZhengshu);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:zhengshu:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrDaihouZhengshu zyjrDaihouZhengshu)
    {
        List<ZyjrDaihouZhengshu> list = zyjrDaihouZhengshuService.selectZyjrDaihouZhengshuList(zyjrDaihouZhengshu);
        ExcelUtil<ZyjrDaihouZhengshu> util = new ExcelUtil<ZyjrDaihouZhengshu>(ZyjrDaihouZhengshu.class);
        return util.exportExcel(list, "zhengshu");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("transactionCode") String transactionCode)
    {
        ZyjrDaihou Daihou=zyjrDaihouMapper.selectZyjrDaihouByT(transactionCode);
        if(Daihou!=null){
            ZyjrDaihouZhengshu zyjrDaihouBaoxian=new ZyjrDaihouZhengshu();
            zyjrDaihouBaoxian.setDaihou(Daihou.getId().toString());
            List<ZyjrDaihouZhengshu> zyjrDaihouTiches = zyjrDaihouZhengshuService.selectZyjrDaihouZhengshuList(zyjrDaihouBaoxian);
            return AjaxResult.success(zyjrDaihouTiches);
        }
        return AjaxResult.success();
    }

    /**
     * 新增【请填写功能名称】
     */

    @PostMapping
    public AjaxResult add( ZyjrDaihouZhengshu zyjrDaihouBaoxian)
    {

        ZyjrDaihou Daihou=zyjrDaihouMapper.selectZyjrDaihouByT(zyjrDaihouBaoxian.getDaihou());
        if(Daihou==null){
            ZyjrDaihou Daihou2=new ZyjrDaihou();
            Daihou=Daihou2;
            Daihou.setZhengshu("1");
            Daihou.setTransactionCode(zyjrDaihouBaoxian.getDaihou());
            zyjrDaihouMapper.insertZyjrDaihou(Daihou);
        }else{
            Daihou.setZhengshu("1");
            zyjrDaihouMapper.updateZyjrDaihou(Daihou);
        }

        zyjrDaihouZhengshuService.deleteZyjrDaihouZhengshuById(Daihou.getId());
        if(zyjrDaihouBaoxian.getPic()!=null){
            JSONArray jsonarray = JSONArray.fromObject(zyjrDaihouBaoxian.getPic());
            System.out.println(jsonarray);
            List<ZyjrDaihouZhengshu> list = (List)JSONArray.toList(jsonarray, ZyjrDaihouBaoxian.class);
            for (ZyjrDaihouZhengshu daihouBaoxian : list) {
                daihouBaoxian.setDaihou(Daihou.getId().toString());
                zyjrDaihouZhengshuService.insertZyjrDaihouZhengshu(daihouBaoxian);
            }
            return AjaxResult.success();
        }

        return AjaxResult.success();
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:zhengshu:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrDaihouZhengshu zyjrDaihouZhengshu)
    {
        return toAjax(zyjrDaihouZhengshuService.updateZyjrDaihouZhengshu(zyjrDaihouZhengshu));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:zhengshu:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrDaihouZhengshuService.deleteZyjrDaihouZhengshuByIds(ids));
    }
}
