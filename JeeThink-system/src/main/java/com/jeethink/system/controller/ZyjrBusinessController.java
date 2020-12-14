package com.jeethink.system.controller;

import java.util.List;
import java.util.Map;

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
import com.jeethink.system.domain.ZyjrBusiness;
import com.jeethink.system.service.IZyjrBusinessService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-09
 */
@RestController
@RequestMapping("/system/business")
@Api("zzzzzzzzzz")
public class ZyjrBusinessController extends BaseController
{
    @Autowired
    private IZyjrBusinessService zyjrBusinessService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('process:business:list')")
    @GetMapping("/list")
    @ApiOperation("查询参数列表")
    public TableDataInfo list(ZyjrBusiness zyjrBusiness)
    {
        startPage();
        List<ZyjrBusiness> list = zyjrBusinessService.selectZyjrBusinessList(zyjrBusiness);
        return getDataTable(list);
    }
    
/*    @GetMapping("/info")
    @ApiOperation("查询参数列表")
    public AjaxResult info(String id)
    {
        Map<String,Object> list = zyjrBusinessService.seleMap(id);
        return AjaxResult.success(list);
    }*/

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('process:business:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrBusiness zyjrBusiness)
    {
        List<ZyjrBusiness> list = zyjrBusinessService.selectZyjrBusinessList(zyjrBusiness);
        ExcelUtil<ZyjrBusiness> util = new ExcelUtil<ZyjrBusiness>(ZyjrBusiness.class);
        return util.exportExcel(list, "business");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('process:business:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrBusinessService.selectZyjrBusinessById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('process:business:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrBusiness zyjrBusiness)
    {
        return toAjax(zyjrBusinessService.insertZyjrBusiness(zyjrBusiness));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('process:business:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrBusiness zyjrBusiness)
    {
        return toAjax(zyjrBusinessService.updateZyjrBusiness(zyjrBusiness));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('process:business:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrBusinessService.deleteZyjrBusinessByIds(ids));
    }
}
