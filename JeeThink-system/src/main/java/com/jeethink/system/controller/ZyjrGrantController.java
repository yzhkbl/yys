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
import com.jeethink.system.domain.ZyjrGrant2;
import com.jeethink.system.service.IZyjrGrantService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-03-10
 */
@RestController
@RequestMapping("/system/grant")
public class ZyjrGrantController extends BaseController
{
    @Autowired
    private IZyjrGrantService zyjrGrantService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:grant:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrGrant2 zyjrGrant)
    {
        startPage();
        List<ZyjrGrant2> list = zyjrGrantService.selectZyjrGrantList(zyjrGrant);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:grant:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrGrant2 zyjrGrant)
    {
        List<ZyjrGrant2> list = zyjrGrantService.selectZyjrGrantList(zyjrGrant);
        ExcelUtil<ZyjrGrant2> util = new ExcelUtil<ZyjrGrant2>(ZyjrGrant2.class);
        return util.exportExcel(list, "grant");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:grant:query')")
    @GetMapping(value = "/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("transactionCode") String transactionCode)
    {
        return AjaxResult.success(zyjrGrantService.selectZyjrGrantById(transactionCode));
    }

    /**
     * 新增【请填写功能名称】
     */
    //@PreAuthorize("@ss.hasPermi('system:grant:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(ZyjrGrant2 zyjrGrant)
    {
        return toAjax(zyjrGrantService.insertZyjrGrant(zyjrGrant));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:grant:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrGrant2 zyjrGrant)
    {
        return toAjax(zyjrGrantService.updateZyjrGrant(zyjrGrant));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:grant:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrGrantService.deleteZyjrGrantByIds(ids));
    }
}
