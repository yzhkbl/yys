package com.jeethink.system.controller;

import java.util.List;
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
import com.jeethink.system.domain.ZyjrInsurance;
import com.jeethink.system.service.IZyjrInsuranceService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-23
 */
@RestController
@RequestMapping("/system/insurance")
public class ZyjrInsuranceController extends BaseController
{
    @Autowired
    private IZyjrInsuranceService zyjrInsuranceService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:insurance:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrInsurance zyjrInsurance)
    {
        startPage();
        List<ZyjrInsurance> list = zyjrInsuranceService.selectZyjrInsuranceList(zyjrInsurance);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:insurance:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrInsurance zyjrInsurance)
    {
        List<ZyjrInsurance> list = zyjrInsuranceService.selectZyjrInsuranceList(zyjrInsurance);
        ExcelUtil<ZyjrInsurance> util = new ExcelUtil<ZyjrInsurance>(ZyjrInsurance.class);
        return util.exportExcel(list, "insurance");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:insurance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrInsuranceService.selectZyjrInsuranceById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:insurance:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrInsurance zyjrInsurance)
    {
        return toAjax(zyjrInsuranceService.insertZyjrInsurance(zyjrInsurance));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:insurance:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrInsurance zyjrInsurance)
    {
        return toAjax(zyjrInsuranceService.updateZyjrInsurance(zyjrInsurance));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:insurance:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrInsuranceService.deleteZyjrInsuranceByIds(ids));
    }
}
