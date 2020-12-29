package com.jeethink.system.controller;

import java.util.List;

import com.jeethink.system.domain.ZyjrAllowApplicant;
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
import com.jeethink.system.service.IZyjrAllowApplicantService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@RestController
@RequestMapping("/system/applicant")
public class ZyjrAllowApplicantController extends BaseController
{
    @Autowired
    private IZyjrAllowApplicantService zyjrAllowApplicantService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:applicant:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrAllowApplicant zyjrAllowApplicant)
    {
        startPage();
        List<ZyjrAllowApplicant> list = zyjrAllowApplicantService.selectZyjrAllowApplicantList(zyjrAllowApplicant);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:applicant:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrAllowApplicant zyjrAllowApplicant)
    {
        List<ZyjrAllowApplicant> list = zyjrAllowApplicantService.selectZyjrAllowApplicantList(zyjrAllowApplicant);
        ExcelUtil<ZyjrAllowApplicant> util = new ExcelUtil<ZyjrAllowApplicant>(ZyjrAllowApplicant.class);
        return util.exportExcel(list, "applicant");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:applicant:query')")
    @GetMapping(value = "/{userId}/{transactionCode}")
    //@RequestMapping("/find")
    public AjaxResult getInfo(@PathVariable("userId") Long userId,@PathVariable("transactionCode") String transactionCode)
    {
        return AjaxResult.success(zyjrAllowApplicantService.selectZyjrAllowApplicantById(userId,transactionCode));
    }

    /**
     * 新增【请填写功能名称】
     */
    //@PreAuthorize("@ss.hasPermi('system:applicant:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    //@RequestMapping("/add")
    public AjaxResult add(ZyjrAllowApplicant zyjrAllowApplicant)
    {
        return toAjax(zyjrAllowApplicantService.insertZyjrAllowApplicant(zyjrAllowApplicant));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:applicant:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrAllowApplicant zyjrAllowApplicant)
    {
        return toAjax(zyjrAllowApplicantService.updateZyjrAllowApplicant(zyjrAllowApplicant));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:applicant:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrAllowApplicantService.deleteZyjrAllowApplicantByIds(ids));
    }
}
