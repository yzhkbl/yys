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
import com.jeethink.system.domain.ZyjrBankFlow;
import com.jeethink.system.service.IZyjrBankFlowService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * flowController
 * 
 * @author jeethink
 * @date 2020-12-26
 */
@RestController
@RequestMapping("/system/flow")
public class ZyjrBankFlowController extends BaseController
{
    @Autowired
    private IZyjrBankFlowService zyjrBankFlowService;

    /**
     * 查询flow列表
     */
    @PreAuthorize("@ss.hasPermi('system:flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrBankFlow zyjrBankFlow)
    {
        startPage();
        List<ZyjrBankFlow> list = zyjrBankFlowService.selectZyjrBankFlowList(zyjrBankFlow);
        return getDataTable(list);
    }

    /**
     * 导出flow列表
     */
    @PreAuthorize("@ss.hasPermi('system:flow:export')")
    @Log(title = "flow", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrBankFlow zyjrBankFlow)
    {
        List<ZyjrBankFlow> list = zyjrBankFlowService.selectZyjrBankFlowList(zyjrBankFlow);
        ExcelUtil<ZyjrBankFlow> util = new ExcelUtil<ZyjrBankFlow>(ZyjrBankFlow.class);
        return util.exportExcel(list, "flow");
    }

    /**
     * 获取flow详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrBankFlowService.selectZyjrBankFlowById(id));
    }

    /**
     * 新增flow
     */
    @PreAuthorize("@ss.hasPermi('system:flow:add')")
    @Log(title = "flow", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrBankFlow zyjrBankFlow)
    {
        return toAjax(zyjrBankFlowService.insertZyjrBankFlow(zyjrBankFlow));
    }

    /**
     * 修改flow
     */
    @PreAuthorize("@ss.hasPermi('system:flow:edit')")
    @Log(title = "flow", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrBankFlow zyjrBankFlow)
    {
        return toAjax(zyjrBankFlowService.updateZyjrBankFlow(zyjrBankFlow));
    }

    /**
     * 删除flow
     */
    @PreAuthorize("@ss.hasPermi('system:flow:remove')")
    @Log(title = "flow", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrBankFlowService.deleteZyjrBankFlowByIds(ids));
    }
}
