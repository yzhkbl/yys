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
import com.jeethink.system.domain.ZyjrDaihouQita;
import com.jeethink.system.service.IZyjrDaihouQitaService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@RestController
@RequestMapping("/system/qita")
public class ZyjrDaihouQitaController extends BaseController
{
    @Autowired
    private IZyjrDaihouQitaService zyjrDaihouQitaService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:qita:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrDaihouQita zyjrDaihouQita)
    {
        startPage();
        List<ZyjrDaihouQita> list = zyjrDaihouQitaService.selectZyjrDaihouQitaList(zyjrDaihouQita);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:qita:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrDaihouQita zyjrDaihouQita)
    {
        List<ZyjrDaihouQita> list = zyjrDaihouQitaService.selectZyjrDaihouQitaList(zyjrDaihouQita);
        ExcelUtil<ZyjrDaihouQita> util = new ExcelUtil<ZyjrDaihouQita>(ZyjrDaihouQita.class);
        return util.exportExcel(list, "qita");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:qita:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrDaihouQitaService.selectZyjrDaihouQitaById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:qita:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrDaihouQita zyjrDaihouQita)
    {
        return toAjax(zyjrDaihouQitaService.insertZyjrDaihouQita(zyjrDaihouQita));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:qita:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrDaihouQita zyjrDaihouQita)
    {
        return toAjax(zyjrDaihouQitaService.updateZyjrDaihouQita(zyjrDaihouQita));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:qita:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrDaihouQitaService.deleteZyjrDaihouQitaByIds(ids));
    }
}
