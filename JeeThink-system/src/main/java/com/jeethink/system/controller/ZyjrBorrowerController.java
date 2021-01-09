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
import com.jeethink.system.domain.ZyjrBorrower;
import com.jeethink.system.service.IZyjrBorrowerService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-10
 */
@RestController
@RequestMapping("/system/borrower")
public class ZyjrBorrowerController extends BaseController
{
    @Autowired
    private IZyjrBorrowerService zyjrBorrowerService;

    /**
     * 查询【请填写功能名称】列表
     */
  //  @PreAuthorize("@ss.hasPermi('system:borrower:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrBorrower zyjrBorrower)
    {
        startPage();
        List<ZyjrBorrower> list = zyjrBorrowerService.selectZyjrBorrowerList(zyjrBorrower);
        return getDataTable(list);
    }

    /**
     *
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:borrower:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrBorrower zyjrBorrower)
    {
        List<ZyjrBorrower> list = zyjrBorrowerService.selectZyjrBorrowerList(zyjrBorrower);
        ExcelUtil<ZyjrBorrower> util = new ExcelUtil<ZyjrBorrower>(ZyjrBorrower.class);
        return util.exportExcel(list, "borrower");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:borrower:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(zyjrBorrowerService.selectZyjrBorrowerById(id));
    }

    /**0
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:borrower:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrBorrower zyjrBorrower)
    {
        return toAjax(zyjrBorrowerService.insertZyjrBorrower(zyjrBorrower));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:borrower:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrBorrower zyjrBorrower)
    {
        return toAjax(zyjrBorrowerService.updateZyjrBorrower(zyjrBorrower));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:borrower:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(zyjrBorrowerService.deleteZyjrBorrowerByIds(ids));
    }
}
