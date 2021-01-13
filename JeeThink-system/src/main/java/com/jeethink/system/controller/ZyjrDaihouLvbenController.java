package com.jeethink.system.controller;

import java.util.List;

import com.jeethink.system.domain.ZyjrDaihou;
import com.jeethink.system.domain.ZyjrDaihouQita;
import com.jeethink.system.mapper.ZyjrDaihouMapper;
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
import com.jeethink.system.domain.ZyjrDaihouLvben;
import com.jeethink.system.service.IZyjrDaihouLvbenService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@RestController
@RequestMapping("/system/lvben")
public class ZyjrDaihouLvbenController extends BaseController
{
    @Autowired
    private IZyjrDaihouLvbenService zyjrDaihouLvbenService;
    @Autowired
    private ZyjrDaihouMapper zyjrDaihouMapper;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:lvben:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrDaihouLvben zyjrDaihouLvben)
    {
        startPage();
        List<ZyjrDaihouLvben> list = zyjrDaihouLvbenService.selectZyjrDaihouLvbenList(zyjrDaihouLvben);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:lvben:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrDaihouLvben zyjrDaihouLvben)
    {
        List<ZyjrDaihouLvben> list = zyjrDaihouLvbenService.selectZyjrDaihouLvbenList(zyjrDaihouLvben);
        ExcelUtil<ZyjrDaihouLvben> util = new ExcelUtil<ZyjrDaihouLvben>(ZyjrDaihouLvben.class);
        return util.exportExcel(list, "lvben");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("transactionCode") String transactionCode)
    {
        ZyjrDaihou Daihou=zyjrDaihouMapper.selectZyjrDaihouByT(transactionCode);
        if(Daihou!=null){
            ZyjrDaihouLvben zyjrDaihouBaoxian=new ZyjrDaihouLvben();
            zyjrDaihouBaoxian.setDaihou(Daihou.getId().toString());
            List<ZyjrDaihouLvben> zyjrDaihouQitas = zyjrDaihouLvbenService.selectZyjrDaihouLvbenList(zyjrDaihouBaoxian);
            return AjaxResult.success(zyjrDaihouQitas);
        }
        return AjaxResult.success();
    }

    /**
     * 新增【请填写功能名称】
     */
    @PostMapping
    public AjaxResult add( ZyjrDaihouLvben zyjrDaihouLvben)
    {
        ZyjrDaihou zyjrDaihou = zyjrDaihouMapper.selectZyjrDaihouByT(zyjrDaihouLvben.getDaihou());
        if(zyjrDaihou==null){
            ZyjrDaihou Daihou2=new ZyjrDaihou();
            zyjrDaihou=Daihou2;
            zyjrDaihou.setLvben("1");
            zyjrDaihou.setTransactionCode(zyjrDaihouLvben.getDaihou());
            zyjrDaihouMapper.insertZyjrDaihou(zyjrDaihou);
        }else{
            zyjrDaihou.setLvben("1");
            zyjrDaihouMapper.updateZyjrDaihou(zyjrDaihou);
        }
        zyjrDaihouLvbenService.deleteZyjrDaihouLvbenById(zyjrDaihou.getId());
        if(zyjrDaihou.getId()!=null){
            zyjrDaihouLvben.setDaihou(zyjrDaihou.getId().toString());
            zyjrDaihouLvbenService.insertZyjrDaihouLvben(zyjrDaihouLvben);
        }
        return AjaxResult.success();
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:lvben:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrDaihouLvben zyjrDaihouLvben)
    {
        return toAjax(zyjrDaihouLvbenService.updateZyjrDaihouLvben(zyjrDaihouLvben));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:lvben:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrDaihouLvbenService.deleteZyjrDaihouLvbenByIds(ids));
    }
}