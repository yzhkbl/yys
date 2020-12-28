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
import com.jeethink.system.domain.ZyjrBankExtend;
import com.jeethink.system.service.IZyjrBankExtendService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * extendController
 * 
 * @author jeethink
 * @date 2020-12-26
 */
@RestController
@RequestMapping("/system/extend")
public class ZyjrBankExtendController extends BaseController
{
    @Autowired
    private IZyjrBankExtendService zyjrBankExtendService;

    /**
     * 查询extend列表
     */
    @PreAuthorize("@ss.hasPermi('system:extend:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrBankExtend zyjrBankExtend)
    {
        startPage();
        List<ZyjrBankExtend> list = zyjrBankExtendService.selectZyjrBankExtendList(zyjrBankExtend);
        return getDataTable(list);
    }

    /**
     * 导出extend列表
     */
    @PreAuthorize("@ss.hasPermi('system:extend:export')")
    @Log(title = "extend", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrBankExtend zyjrBankExtend)
    {
        List<ZyjrBankExtend> list = zyjrBankExtendService.selectZyjrBankExtendList(zyjrBankExtend);
        ExcelUtil<ZyjrBankExtend> util = new ExcelUtil<ZyjrBankExtend>(ZyjrBankExtend.class);
        return util.exportExcel(list, "extend");
    }

    /**
     * 获取extend详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:extend:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrBankExtendService.selectZyjrBankExtendById(id));
    }

    /**
     * 新增extend
     */
    @PreAuthorize("@ss.hasPermi('system:extend:add')")
    @Log(title = "extend", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrBankExtend zyjrBankExtend)
    {
        return toAjax(zyjrBankExtendService.insertZyjrBankExtend(zyjrBankExtend));
    }

    /**
     * 修改extend
     */
    @PreAuthorize("@ss.hasPermi('system:extend:edit')")
    @Log(title = "extend", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrBankExtend zyjrBankExtend)
    {
        return toAjax(zyjrBankExtendService.updateZyjrBankExtend(zyjrBankExtend));
    }

    /**
     * 删除extend
     */
    @PreAuthorize("@ss.hasPermi('system:extend:remove')")
    @Log(title = "extend", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrBankExtendService.deleteZyjrBankExtendByIds(ids));
    }
}
