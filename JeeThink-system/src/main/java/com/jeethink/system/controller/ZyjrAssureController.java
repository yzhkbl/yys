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
import com.jeethink.system.domain.ZyjrAssure;
import com.jeethink.system.service.IZyjrAssureService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * assureController
 * 
 * @author jeethink
 * @date 2020-12-25
 */
@RestController
@RequestMapping("/system/assure")
public class ZyjrAssureController extends BaseController
{
    @Autowired
    private IZyjrAssureService zyjrAssureService;

    /**
     * 查询assure列表
     */
    @PreAuthorize("@ss.hasPermi('organization:assure:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrAssure zyjrAssure)
    {
        startPage();
        List<ZyjrAssure> list = zyjrAssureService.selectZyjrAssureList(zyjrAssure);
        return getDataTable(list);
    }

    /**
     * 导出assure列表
     */
    @PreAuthorize("@ss.hasPermi('organization:assure:export')")
    @Log(title = "assure", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrAssure zyjrAssure)
    {
        List<ZyjrAssure> list = zyjrAssureService.selectZyjrAssureList(zyjrAssure);
        ExcelUtil<ZyjrAssure> util = new ExcelUtil<ZyjrAssure>(ZyjrAssure.class);
        return util.exportExcel(list, "assure");
    }

    /**
     * 获取assure详细信息
     */
    @PreAuthorize("@ss.hasPermi('organization:assure:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrAssureService.selectZyjrAssureById(id));
    }

    /**
     * 新增assure
     */
    @PreAuthorize("@ss.hasPermi('organization:assure:add')")
    @Log(title = "assure", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrAssure zyjrAssure)
    {
        return toAjax(zyjrAssureService.insertZyjrAssure(zyjrAssure));
    }

    /**
     * 修改assure
     */
    @PreAuthorize("@ss.hasPermi('organization:assure:edit')")
    @Log(title = "assure", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrAssure zyjrAssure)
    {
        return toAjax(zyjrAssureService.updateZyjrAssure(zyjrAssure));
    }

    /**
     * 删除assure
     */
    @PreAuthorize("@ss.hasPermi('organization:assure:remove')")
    @Log(title = "assure", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrAssureService.deleteZyjrAssureByIds(ids));
    }
}
