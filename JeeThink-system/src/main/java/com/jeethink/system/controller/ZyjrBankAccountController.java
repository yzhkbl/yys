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
import com.jeethink.system.domain.ZyjrBankAccount;
import com.jeethink.system.service.IZyjrBankAccountService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * accountController
 * 
 * @author jeethink
 * @date 2020-12-26
 */
@RestController
@RequestMapping("/system/bank/account")
public class ZyjrBankAccountController extends BaseController
{
    @Autowired
    private IZyjrBankAccountService zyjrBankAccountService;

    /**
     * 查询account列表
     */
    @PreAuthorize("@ss.hasPermi('system:account:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrBankAccount zyjrBankAccount)
    {
        startPage();
        List<ZyjrBankAccount> list = zyjrBankAccountService.selectZyjrBankAccountList(zyjrBankAccount);
        return getDataTable(list);
    }

    /**
     * 导出account列表
     */
    @PreAuthorize("@ss.hasPermi('system:account:export')")
    @Log(title = "account", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrBankAccount zyjrBankAccount)
    {
        List<ZyjrBankAccount> list = zyjrBankAccountService.selectZyjrBankAccountList(zyjrBankAccount);
        ExcelUtil<ZyjrBankAccount> util = new ExcelUtil<ZyjrBankAccount>(ZyjrBankAccount.class);
        return util.exportExcel(list, "account");
    }

    /**
     * 获取account详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:account:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrBankAccountService.selectZyjrBankAccountById(id));
    }

    /**
     * 新增account
     */
    @PreAuthorize("@ss.hasPermi('system:account:add')")
    @Log(title = "account", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrBankAccount zyjrBankAccount)
    {
        return toAjax(zyjrBankAccountService.insertZyjrBankAccount(zyjrBankAccount));
    }

    /**
     * 修改account
     */
    @PreAuthorize("@ss.hasPermi('system:account:edit')")
    @Log(title = "account", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrBankAccount zyjrBankAccount)
    {
        return toAjax(zyjrBankAccountService.updateZyjrBankAccount(zyjrBankAccount));
    }

    /**
     * 删除account
     */
    @PreAuthorize("@ss.hasPermi('system:account:remove')")
    @Log(title = "account", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrBankAccountService.deleteZyjrBankAccountByIds(ids));
    }
}
