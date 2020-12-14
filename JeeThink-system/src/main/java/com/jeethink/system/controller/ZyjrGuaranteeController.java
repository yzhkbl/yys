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
import com.jeethink.system.domain.ZyjrGuarantee;
import com.jeethink.system.controller.service.IZyjrGuaranteeService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-10
 */
@RestController
@RequestMapping("/system/guarantee")
public class ZyjrGuaranteeController extends BaseController
{
    @Autowired
    private IZyjrGuaranteeService zyjrGuaranteeService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:guarantee:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrGuarantee zyjrGuarantee)
    {
        startPage();
        List<ZyjrGuarantee> list = zyjrGuaranteeService.selectZyjrGuaranteeList(zyjrGuarantee);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:guarantee:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrGuarantee zyjrGuarantee)
    {
        List<ZyjrGuarantee> list = zyjrGuaranteeService.selectZyjrGuaranteeList(zyjrGuarantee);
        ExcelUtil<ZyjrGuarantee> util = new ExcelUtil<ZyjrGuarantee>(ZyjrGuarantee.class);
        return util.exportExcel(list, "guarantee");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:guarantee:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(zyjrGuaranteeService.selectZyjrGuaranteeById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:guarantee:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrGuarantee zyjrGuarantee)
    {
        return toAjax(zyjrGuaranteeService.insertZyjrGuarantee(zyjrGuarantee));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:guarantee:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrGuarantee zyjrGuarantee)
    {
        return toAjax(zyjrGuaranteeService.updateZyjrGuarantee(zyjrGuarantee));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:guarantee:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(zyjrGuaranteeService.deleteZyjrGuaranteeByIds(ids));
    }
}
