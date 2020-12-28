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
import com.jeethink.system.domain.ZyjrOverdue;
import com.jeethink.system.service.IZyjrOverdueService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * overdueController
 * 
 * @author jeethink
 * @date 2020-12-26
 */
@RestController
@RequestMapping("/system/overdue")
public class ZyjrOverdueController extends BaseController
{
    @Autowired
    private IZyjrOverdueService zyjrOverdueService;

    /**
     * 查询overdue列表
     */
    @PreAuthorize("@ss.hasPermi('overdue:overdue:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrOverdue zyjrOverdue)
    {
        startPage();
        List<ZyjrOverdue> list = zyjrOverdueService.selectZyjrOverdueList(zyjrOverdue);
        return getDataTable(list);
    }

    /**
     * 导出overdue列表
     */
    @PreAuthorize("@ss.hasPermi('overdue:overdue:export')")
    @Log(title = "overdue", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrOverdue zyjrOverdue)
    {
        List<ZyjrOverdue> list = zyjrOverdueService.selectZyjrOverdueList(zyjrOverdue);
        ExcelUtil<ZyjrOverdue> util = new ExcelUtil<ZyjrOverdue>(ZyjrOverdue.class);
        return util.exportExcel(list, "overdue");
    }

    /**
     * 获取overdue详细信息
     */
    @PreAuthorize("@ss.hasPermi('overdue:overdue:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrOverdueService.selectZyjrOverdueById(id));
    }

    /**
     * 新增overdue
     */
    @PreAuthorize("@ss.hasPermi('overdue:overdue:add')")
    @Log(title = "overdue", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrOverdue zyjrOverdue)
    {
        return toAjax(zyjrOverdueService.insertZyjrOverdue(zyjrOverdue));
    }

    /**
     * 修改overdue
     */
    @PreAuthorize("@ss.hasPermi('overdue:overdue:edit')")
    @Log(title = "overdue", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrOverdue zyjrOverdue)
    {
        return toAjax(zyjrOverdueService.updateZyjrOverdue(zyjrOverdue));
    }

    /**
     * 删除overdue
     */
    @PreAuthorize("@ss.hasPermi('overdue:overdue:remove')")
    @Log(title = "overdue", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrOverdueService.deleteZyjrOverdueByIds(ids));
    }
}
