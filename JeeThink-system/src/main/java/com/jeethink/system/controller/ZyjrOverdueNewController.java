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
import com.jeethink.system.domain.ZyjrOverdueNew;
import com.jeethink.system.service.IZyjrOverdueNewService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-29
 */
@RestController
@RequestMapping("/system/new")
public class ZyjrOverdueNewController extends BaseController
{
    @Autowired
    private IZyjrOverdueNewService zyjrOverdueNewService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:new:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrOverdueNew zyjrOverdueNew)
    {
        startPage();
        List<ZyjrOverdueNew> list = zyjrOverdueNewService.selectZyjrOverdueNewList(zyjrOverdueNew);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:new:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrOverdueNew zyjrOverdueNew)
    {
        List<ZyjrOverdueNew> list = zyjrOverdueNewService.selectZyjrOverdueNewList(zyjrOverdueNew);
        ExcelUtil<ZyjrOverdueNew> util = new ExcelUtil<ZyjrOverdueNew>(ZyjrOverdueNew.class);
        return util.exportExcel(list, "new");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */

    //@PreAuthorize("@ss.hasPermi('system:new:query')")
    @GetMapping(value = "/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("transactionCode") String transactionCode)
    {
        return AjaxResult.success(zyjrOverdueNewService.selectZyjrOverdueNewById(transactionCode));
    }

    /**
     * 新增【请填写功能名称】
     */
    //@PreAuthorize("@ss.hasPermi('system:new:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrOverdueNew zyjrOverdueNew)
    {
        return toAjax(zyjrOverdueNewService.insertZyjrOverdueNew(zyjrOverdueNew));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:new:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrOverdueNew zyjrOverdueNew)
    {
        return toAjax(zyjrOverdueNewService.updateZyjrOverdueNew(zyjrOverdueNew));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:new:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrOverdueNewService.deleteZyjrOverdueNewByIds(ids));
    }
}
