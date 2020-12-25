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
import com.jeethink.system.domain.ZyjrBank;
import com.jeethink.system.service.IZyjrBankService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * bankController
 * 
 * @author jeethink
 * @date 2020-12-25
 */
@RestController
@RequestMapping("/system/bank")
public class ZyjrBankController extends BaseController
{
    @Autowired
    private IZyjrBankService zyjrBankService;

    /**
     * 查询bank列表
     */
    @PreAuthorize("@ss.hasPermi('organization:bank:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrBank zyjrBank)
    {
        startPage();
        List<ZyjrBank> list = zyjrBankService.selectZyjrBankList(zyjrBank);
        return getDataTable(list);
    }

    /**
     * 导出bank列表
     */
    @PreAuthorize("@ss.hasPermi('organization:bank:export')")
    @Log(title = "bank", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrBank zyjrBank)
    {
        List<ZyjrBank> list = zyjrBankService.selectZyjrBankList(zyjrBank);
        ExcelUtil<ZyjrBank> util = new ExcelUtil<ZyjrBank>(ZyjrBank.class);
        return util.exportExcel(list, "bank");
    }

    /**
     * 获取bank详细信息
     */
    @PreAuthorize("@ss.hasPermi('organization:bank:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrBankService.selectZyjrBankById(id));
    }

    /**
     * 新增bank
     */
    @PreAuthorize("@ss.hasPermi('organization:bank:add')")
    @Log(title = "bank", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrBank zyjrBank)
    {
        return toAjax(zyjrBankService.insertZyjrBank(zyjrBank));
    }

    /**
     * 修改bank
     */
    @PreAuthorize("@ss.hasPermi('organization:bank:edit')")
    @Log(title = "bank", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrBank zyjrBank)
    {
        return toAjax(zyjrBankService.updateZyjrBank(zyjrBank));
    }

    /**
     * 删除bank
     */
    @PreAuthorize("@ss.hasPermi('organization:bank:remove')")
    @Log(title = "bank", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrBankService.deleteZyjrBankByIds(ids));
    }
}
