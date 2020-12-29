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
import com.jeethink.system.domain.ZyjrBankScheme;
import com.jeethink.system.service.IZyjrBankSchemeService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * schemeController
 * 
 * @author jeethink
 * @date 2020-12-26
 */
@RestController
@RequestMapping("/system/scheme")
public class ZyjrBankSchemeController extends BaseController
{
    @Autowired
    private IZyjrBankSchemeService zyjrBankSchemeService;

    /**
     * 查询scheme列表
     */
    @PreAuthorize("@ss.hasPermi('system:scheme:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrBankScheme zyjrBankScheme)
    {
        startPage();
        List<ZyjrBankScheme> list = zyjrBankSchemeService.selectZyjrBankSchemeList(zyjrBankScheme);
        return getDataTable(list);
    }

    /**
     * 导出scheme列表
     */
    @PreAuthorize("@ss.hasPermi('system:scheme:export')")
    @Log(title = "scheme", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrBankScheme zyjrBankScheme)
    {
        List<ZyjrBankScheme> list = zyjrBankSchemeService.selectZyjrBankSchemeList(zyjrBankScheme);
        ExcelUtil<ZyjrBankScheme> util = new ExcelUtil<ZyjrBankScheme>(ZyjrBankScheme.class);
        return util.exportExcel(list, "scheme");
    }

    /**
     * 获取scheme详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:scheme:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrBankSchemeService.selectZyjrBankSchemeById(id));
    }

    /**
     * 新增scheme
     */
    @PreAuthorize("@ss.hasPermi('system:scheme:add')")
    @Log(title = "scheme", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrBankScheme zyjrBankScheme)
    {
        return toAjax(zyjrBankSchemeService.insertZyjrBankScheme(zyjrBankScheme));
    }

    /**
     * 修改scheme
     */
    @PreAuthorize("@ss.hasPermi('system:scheme:edit')")
    @Log(title = "scheme", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrBankScheme zyjrBankScheme)
    {
        return toAjax(zyjrBankSchemeService.updateZyjrBankScheme(zyjrBankScheme));
    }

    /**
     * 删除scheme
     */
    @PreAuthorize("@ss.hasPermi('system:scheme:remove')")
    @Log(title = "scheme", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrBankSchemeService.deleteZyjrBankSchemeByIds(ids));
    }
}
