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
import com.jeethink.system.domain.ZyjrEmployer;
import com.jeethink.system.service.IZyjrEmployerService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-20
 */
@RestController
@RequestMapping("/system/employer")
public class ZyjrEmployerController extends BaseController
{
    @Autowired
    private IZyjrEmployerService zyjrEmployerService;

    /**
     * 查询【请填写功能名称】列表
     */
    //@PreAuthorize("@ss.hasPermi('organization:employer:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrEmployer zyjrEmployer)
    {
        startPage();
        List<ZyjrEmployer> list = zyjrEmployerService.selectZyjrEmployerList(zyjrEmployer);
        return getDataTable(list);
    }

    @GetMapping("/lists")
    public AjaxResult lists()
    {
        List<ZyjrEmployer> list = zyjrEmployerService.selectZyjrEmployerList(null);
        return AjaxResult.success(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('organization:employer:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrEmployer zyjrEmployer)
    {
        List<ZyjrEmployer> list = zyjrEmployerService.selectZyjrEmployerList(zyjrEmployer);
        ExcelUtil<ZyjrEmployer> util = new ExcelUtil<ZyjrEmployer>(ZyjrEmployer.class);
        return util.exportExcel(list, "employer");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('organization:employer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrEmployerService.selectZyjrEmployerById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('organization:employer:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrEmployer zyjrEmployer)
    {
        return toAjax(zyjrEmployerService.insertZyjrEmployer(zyjrEmployer));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('organization:employer:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrEmployer zyjrEmployer)
    {
        return toAjax(zyjrEmployerService.updateZyjrEmployer(zyjrEmployer));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('organization:employer:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrEmployerService.deleteZyjrEmployerByIds(ids));
    }
}
