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
import com.jeethink.system.domain.ZyjrCarParent;
import com.jeethink.system.service.IZyjrCarParentService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-02-05
 */
@RestController
@RequestMapping("/system/parent")
public class ZyjrCarParentController extends BaseController
{
    @Autowired
    private IZyjrCarParentService zyjrCarParentService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('organization:parent:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrCarParent zyjrCarParent)
    {
        startPage();
        List<ZyjrCarParent> list = zyjrCarParentService.selectZyjrCarParentList(zyjrCarParent);
        return getDataTable(list);
    }

    @GetMapping("/lists")
    public AjaxResult lists(ZyjrCarParent zyjrCarParent)
    {
        List<ZyjrCarParent> list = zyjrCarParentService.selectZyjrCarParentList(zyjrCarParent);
        return AjaxResult.success(list);
    }


    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('organization:parent:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrCarParent zyjrCarParent)
    {
        List<ZyjrCarParent> list = zyjrCarParentService.selectZyjrCarParentList(zyjrCarParent);
        ExcelUtil<ZyjrCarParent> util = new ExcelUtil<ZyjrCarParent>(ZyjrCarParent.class);
        return util.exportExcel(list, "parent");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('organization:parent:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrCarParentService.selectZyjrCarParentById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('organization:parent:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrCarParent zyjrCarParent)
    {
        return toAjax(zyjrCarParentService.insertZyjrCarParent(zyjrCarParent));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('organization:parent:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrCarParent zyjrCarParent)
    {
        return toAjax(zyjrCarParentService.updateZyjrCarParent(zyjrCarParent));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('organization:parent:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrCarParentService.deleteZyjrCarParentByIds(ids));
    }
}
