package com.jeethink.system.controller;

import java.util.List;

import com.jeethink.system.domain.ZyjrDebtService;
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
import com.jeethink.system.service.IZyjrDebtServiceService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-28
 */
@RestController
@RequestMapping("/system/service")
public class ZyjrDebtServiceController extends BaseController
{
    @Autowired
    private IZyjrDebtServiceService zyjrDebtServiceService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:service:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrDebtService zyjrDebtService)
    {
        startPage();
        List<ZyjrDebtService> list = zyjrDebtServiceService.selectZyjrDebtServiceList(zyjrDebtService);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:service:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrDebtService zyjrDebtService)
    {
        List<ZyjrDebtService> list = zyjrDebtServiceService.selectZyjrDebtServiceList(zyjrDebtService);
        ExcelUtil<ZyjrDebtService> util = new ExcelUtil<ZyjrDebtService>(ZyjrDebtService.class);
        return util.exportExcel(list, "service");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:service:query')")
    @GetMapping(value = "/{userId}/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId,@PathVariable("transactionCode") String transactionCode)
    {
        return AjaxResult.success(zyjrDebtServiceService.selectZyjrDebtServiceById(userId,transactionCode));
    }

    /**
     * 新增【请填写功能名称】
     */
    //@PreAuthorize("@ss.hasPermi('system:service:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrDebtService zyjrDebtService)
    {
        return toAjax(zyjrDebtServiceService.insertZyjrDebtService(zyjrDebtService));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:service:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrDebtService zyjrDebtService)
    {
        return toAjax(zyjrDebtServiceService.updateZyjrDebtService(zyjrDebtService));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:service:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrDebtServiceService.deleteZyjrDebtServiceByIds(ids));
    }
}
