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
import com.jeethink.system.domain.ZyjrInsuranceType;
import com.jeethink.system.service.IZyjrInsuranceTypeService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * insuranceTypeController
 * 
 * @author jeethink
 * @date 2020-12-29
 */
@RestController
@RequestMapping("/system/insuranceType")
public class ZyjrInsuranceTypeController extends BaseController
{
    @Autowired
    private IZyjrInsuranceTypeService zyjrInsuranceTypeService;

    /**
     * 查询insuranceType列表
     */
    @PreAuthorize("@ss.hasPermi('system:insuranceType:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrInsuranceType zyjrInsuranceType)
    {
        startPage();
        List<ZyjrInsuranceType> list = zyjrInsuranceTypeService.selectZyjrInsuranceTypeList(zyjrInsuranceType);
        return getDataTable(list);
    }

    /**
     * 导出insuranceType列表
     */
    @PreAuthorize("@ss.hasPermi('system:insuranceType:export')")
    @Log(title = "insuranceType", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrInsuranceType zyjrInsuranceType)
    {
        List<ZyjrInsuranceType> list = zyjrInsuranceTypeService.selectZyjrInsuranceTypeList(zyjrInsuranceType);
        ExcelUtil<ZyjrInsuranceType> util = new ExcelUtil<ZyjrInsuranceType>(ZyjrInsuranceType.class);
        return util.exportExcel(list, "insuranceType");
    }

    /**
     * 获取insuranceType详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrInsuranceTypeService.selectZyjrInsuranceTypeById(id));
    }

    /**
     * 新增insuranceType
     */
    @Log(title = "insuranceType", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrInsuranceType zyjrInsuranceType)
    {
        Long a=zyjrInsuranceTypeService.insertZyjrInsuranceType(zyjrInsuranceType);
        return AjaxResult.success(a);
    }

    /**
     * 修改insuranceType
     */

    @Log(title = "insuranceType", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrInsuranceType zyjrInsuranceType)
    {
        return toAjax(zyjrInsuranceTypeService.updateZyjrInsuranceType(zyjrInsuranceType));
    }

    /**
     * 删除insuranceType
     */
    @PreAuthorize("@ss.hasPermi('system:insuranceType:remove')")
    @Log(title = "insuranceType", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrInsuranceTypeService.deleteZyjrInsuranceTypeByIds(ids));
    }
}
