package com.jeethink.system.controller;

import java.util.List;

import com.jeethink.system.domain.ZyjrCarAccount;
import com.jeethink.system.service.IZyjrCarAccountService;
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
import com.jeethink.system.domain.ZyjrCar;
import com.jeethink.system.service.IZyjrCarService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 车商信息Controller
 * 
 * @author jeethink
 * @date 2020-12-14
 */
@RestController
@RequestMapping("/system/car")
public class ZyjrCarController extends BaseController
{
    @Autowired
    private IZyjrCarService zyjrCarService;
    @Autowired
    private IZyjrCarAccountService zyjrCarAccountService;


    /**
     * 查询车商信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:car:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrCar zyjrCar)
    {
        startPage();
        List<ZyjrCar> list = zyjrCarService.selectZyjrCarList(zyjrCar);

        return getDataTable(list);
    }

    /**
     * 导出车商信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:car:export')")
    @Log(title = "车商信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrCar zyjrCar)
    {
        List<ZyjrCar> list = zyjrCarService.selectZyjrCarList(zyjrCar);
        ExcelUtil<ZyjrCar> util = new ExcelUtil<ZyjrCar>(ZyjrCar.class);
        return util.exportExcel(list, "car");
    }

    /**
     * 获取车商信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:car:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrCarService.selectZyjrCarById(id));
    }

    /**
     * 新增车商信息
     */
    @PreAuthorize("@ss.hasPermi('system:car:add')")
    @Log(title = "车商信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrCar zyjrCar)
    {
        int a=zyjrCarService.insertZyjrCar(zyjrCar);

        return toAjax(a);
    }

    /**
     * 修改车商信息
     */
    @PreAuthorize("@ss.hasPermi('system:car:edit')")
    @Log(title = "车商信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrCar zyjrCar)
    {
        return toAjax(zyjrCarService.updateZyjrCar(zyjrCar));
    }

    /**
     * 删除车商信息
     */
    @PreAuthorize("@ss.hasPermi('system:car:remove')")
    @Log(title = "车商信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        zyjrCarAccountService.deleteZyjrCarAccountByIds(ids);
        return toAjax(zyjrCarService.deleteZyjrCarByIds(ids));
    }
}
