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
import com.jeethink.system.domain.ZyjrRelation;
import com.jeethink.system.service.IZyjrRelationService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-09
 */
@RestController
@RequestMapping("/system/relation")
public class ZyjrRelationController extends BaseController
{
    @Autowired
    private IZyjrRelationService zyjrRelationService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:relation:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrRelation zyjrRelation)
    {
        startPage();
        List<ZyjrRelation> list = zyjrRelationService.selectZyjrRelationList(zyjrRelation);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */

    @GetMapping("/export")
    public AjaxResult export(ZyjrRelation zyjrRelation)
    {
        List<ZyjrRelation> list = zyjrRelationService.selectZyjrRelationList(zyjrRelation);
        ExcelUtil<ZyjrRelation> util = new ExcelUtil<ZyjrRelation>(ZyjrRelation.class);
        return util.exportExcel(list, "relation");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:relation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(zyjrRelationService.selectZyjrRelationById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:relation:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrRelation zyjrRelation)
    {
        return toAjax(zyjrRelationService.insertZyjrRelation(zyjrRelation));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:relation:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrRelation zyjrRelation)
    {
        return toAjax(zyjrRelationService.updateZyjrRelation(zyjrRelation));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:relation:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(zyjrRelationService.deleteZyjrRelationByIds(ids));
    }
}
