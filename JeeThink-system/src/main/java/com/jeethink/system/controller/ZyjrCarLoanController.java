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
import com.jeethink.system.domain.ZyjrCarLoan;
import com.jeethink.system.service.IZyjrCarLoanService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@RestController
@RequestMapping("/system/loan")
public class ZyjrCarLoanController extends BaseController
{
    @Autowired
    private IZyjrCarLoanService zyjrCarLoanService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:loan:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrCarLoan zyjrCarLoan)
    {
        startPage();
        List<ZyjrCarLoan> list = zyjrCarLoanService.selectZyjrCarLoanList(zyjrCarLoan);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:loan:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrCarLoan zyjrCarLoan)
    {
        List<ZyjrCarLoan> list = zyjrCarLoanService.selectZyjrCarLoanList(zyjrCarLoan);
        ExcelUtil<ZyjrCarLoan> util = new ExcelUtil<ZyjrCarLoan>(ZyjrCarLoan.class);
        return util.exportExcel(list, "loan");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:loan:query')")
    @GetMapping(value = "/{userId}/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId,@PathVariable("transactionCode") String transactionCode)
    {
        return AjaxResult.success(zyjrCarLoanService.selectZyjrCarLoanById(userId, transactionCode));
    }

    /**
     * 新增【请填写功能名称】
     */
    //@PreAuthorize("@ss.hasPermi('system:loan:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(ZyjrCarLoan zyjrCarLoan)
    {
        return toAjax(zyjrCarLoanService.insertZyjrCarLoan(zyjrCarLoan));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:loan:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrCarLoan zyjrCarLoan)
    {
        return toAjax(zyjrCarLoanService.updateZyjrCarLoan(zyjrCarLoan));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:loan:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrCarLoanService.deleteZyjrCarLoanByIds(ids));
    }
}
