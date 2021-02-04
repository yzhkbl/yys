package com.jeethink.system.controller;

import java.util.List;

import com.jeethink.system.domain.ZyjrCarAccount;
import com.jeethink.system.domain.vo.Bodys;
import com.jeethink.system.mapper.ZyjrBusinessMapper;
import com.jeethink.system.service.IZyjrCarAccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    private ZyjrBusinessMapper zyjrBusinessMapper;
    @Autowired
    private IZyjrCarAccountService zyjrCarAccountService;

    /**
     * 查询【请填写功能名称】列表
     */
    /*@PreAuthorize("@ss.hasPermi('process:business:list')")*/
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
    /*@PreAuthorize("@ss.hasPermi('process:business:export')")*/
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

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrBusinessService.selectZyjrBusinessById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    /*@PreAuthorize("@ss.hasPermi('process:business:add')")*/
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrBusiness zyjrBusiness)
    {
        return toAjax(zyjrBusinessService.insertZyjrBusiness(zyjrBusiness));
    }

    /**
     * 修改【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrBusiness zyjrBusiness)
    {
        int a=zyjrBusinessService.updateZyjrBusiness(zyjrBusiness);
        if(a==999){
            AjaxResult json=new AjaxResult();
                    json.put("code", 400);
            json.put("msg", "手慢了，下次再快点！！！");
        return json;
        }
        return toAjax(a);
    }

    @GetMapping("edit")
    public AjaxResult edit2(String id)
    {
        return toAjax(zyjrBusinessMapper.updateById(id));
    }

    @GetMapping("edit2")
    public AjaxResult edit22(Bodys bodys)
    {
       // System.err.println(bodys);
        return toAjax(zyjrBusinessMapper.updateByIds(bodys));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrBusinessService.deleteZyjrBusinessByIds(ids));
    }
}
