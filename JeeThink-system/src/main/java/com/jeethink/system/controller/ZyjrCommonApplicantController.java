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
import com.jeethink.system.domain.ZyjrCommonApplicant;
import com.jeethink.system.service.IZyjrCommonApplicantService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-02-06
 */
@RestController
@RequestMapping("/system/common")
public class ZyjrCommonApplicantController extends BaseController
{
    @Autowired
    private IZyjrCommonApplicantService zyjrCommonApplicantService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:applicant:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrCommonApplicant zyjrCommonApplicant)
    {
        startPage();
        List<ZyjrCommonApplicant> list = zyjrCommonApplicantService.selectZyjrCommonApplicantList(zyjrCommonApplicant);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:applicant:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrCommonApplicant zyjrCommonApplicant)
    {
        List<ZyjrCommonApplicant> list = zyjrCommonApplicantService.selectZyjrCommonApplicantList(zyjrCommonApplicant);
        ExcelUtil<ZyjrCommonApplicant> util = new ExcelUtil<ZyjrCommonApplicant>(ZyjrCommonApplicant.class);
        return util.exportExcel(list, "applicant");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:applicant:query')")
    @GetMapping(value = "/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("transactionCode") String transactionCode)
    {
        return AjaxResult.success(zyjrCommonApplicantService.selectZyjrCommonApplicantById(transactionCode));
    }

    /**
     * 新增【请填写功能名称】
     */
    //@PreAuthorize("@ss.hasPermi('system:applicant:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(ZyjrCommonApplicant zyjrCommonApplicant)
    {
        return toAjax(zyjrCommonApplicantService.insertZyjrCommonApplicant(zyjrCommonApplicant));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:applicant:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrCommonApplicant zyjrCommonApplicant)
    {
        return toAjax(zyjrCommonApplicantService.updateZyjrCommonApplicant(zyjrCommonApplicant));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:applicant:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrCommonApplicantService.deleteZyjrCommonApplicantByIds(ids));
    }
}
