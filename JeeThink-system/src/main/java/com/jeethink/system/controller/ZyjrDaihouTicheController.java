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
import com.jeethink.system.domain.ZyjrDaihouTiche;
import com.jeethink.system.service.IZyjrDaihouTicheService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@RestController
@RequestMapping("/system/tiche")
public class ZyjrDaihouTicheController extends BaseController
{
    @Autowired
    private IZyjrDaihouTicheService zyjrDaihouTicheService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:tiche:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrDaihouTiche zyjrDaihouTiche)
    {
        startPage();
        List<ZyjrDaihouTiche> list = zyjrDaihouTicheService.selectZyjrDaihouTicheList(zyjrDaihouTiche);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:tiche:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrDaihouTiche zyjrDaihouTiche)
    {
        List<ZyjrDaihouTiche> list = zyjrDaihouTicheService.selectZyjrDaihouTicheList(zyjrDaihouTiche);
        ExcelUtil<ZyjrDaihouTiche> util = new ExcelUtil<ZyjrDaihouTiche>(ZyjrDaihouTiche.class);
        return util.exportExcel(list, "tiche");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:tiche:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrDaihouTicheService.selectZyjrDaihouTicheById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:tiche:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrDaihouTiche zyjrDaihouTiche)
    {
        return toAjax(zyjrDaihouTicheService.insertZyjrDaihouTiche(zyjrDaihouTiche));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:tiche:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrDaihouTiche zyjrDaihouTiche)
    {
        return toAjax(zyjrDaihouTicheService.updateZyjrDaihouTiche(zyjrDaihouTiche));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:tiche:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrDaihouTicheService.deleteZyjrDaihouTicheByIds(ids));
    }
}
