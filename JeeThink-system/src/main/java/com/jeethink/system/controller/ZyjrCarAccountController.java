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
import com.jeethink.system.domain.ZyjrCarAccount;
import com.jeethink.system.service.IZyjrCarAccountService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-15
 */
@RestController
@RequestMapping("/system/account")
public class ZyjrCarAccountController extends BaseController
{
    @Autowired
    private IZyjrCarAccountService zyjrCarAccountService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:account:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrCarAccount zyjrCarAccount)
    {
        startPage();
        List<ZyjrCarAccount> list = zyjrCarAccountService.selectZyjrCarAccountList(zyjrCarAccount);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:account:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrCarAccount zyjrCarAccount)
    {
        List<ZyjrCarAccount> list = zyjrCarAccountService.selectZyjrCarAccountList(zyjrCarAccount);
        ExcelUtil<ZyjrCarAccount> util = new ExcelUtil<ZyjrCarAccount>(ZyjrCarAccount.class);
        return util.exportExcel(list, "account");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:account:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrCarAccountService.selectZyjrCarAccountById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:account:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody List<ZyjrCarAccount> zyjrCarAccount)
    {
        return toAjax(zyjrCarAccountService.insertZyjrCarAccount(zyjrCarAccount));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:account:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrCarAccount zyjrCarAccount)
    {
        return toAjax(zyjrCarAccountService.updateZyjrCarAccount(zyjrCarAccount));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:account:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrCarAccountService.deleteZyjrCarAccountByIds(ids));
    }
}
