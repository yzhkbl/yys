package com.jeethink.system.controller;

import java.util.List;

import com.jeethink.system.domain.ZyjrDaihou;
import com.jeethink.system.mapper.ZyjrDaihouMapper;
import com.jeethink.system.service.IZyjrDaihouService;
import net.sf.json.JSONArray;
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
import com.jeethink.system.domain.ZyjrDaihouBaoxian;
import com.jeethink.system.service.IZyjrDaihouBaoxianService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@RestController
@RequestMapping("/system/baoxian")
public class ZyjrDaihouBaoxianController extends BaseController
{
    @Autowired
    private IZyjrDaihouBaoxianService zyjrDaihouBaoxianService;
    @Autowired
    private IZyjrDaihouService zyjrDaihouService;
    @Autowired
    private ZyjrDaihouMapper zyjrDaihouMapper;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:baoxian:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrDaihouBaoxian zyjrDaihouBaoxian)
    {
        startPage();
        List<ZyjrDaihouBaoxian> list = zyjrDaihouBaoxianService.selectZyjrDaihouBaoxianList(zyjrDaihouBaoxian);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:baoxian:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrDaihouBaoxian zyjrDaihouBaoxian)
    {
        List<ZyjrDaihouBaoxian> list = zyjrDaihouBaoxianService.selectZyjrDaihouBaoxianList(zyjrDaihouBaoxian);
        ExcelUtil<ZyjrDaihouBaoxian> util = new ExcelUtil<ZyjrDaihouBaoxian>(ZyjrDaihouBaoxian.class);
        return util.exportExcel(list, "baoxian");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("transactionCode") String transactionCode)
    {
        ZyjrDaihou Daihou=zyjrDaihouMapper.selectZyjrDaihouByT(transactionCode);
        if(Daihou!=null){
            ZyjrDaihouBaoxian zyjrDaihouBaoxian=new ZyjrDaihouBaoxian();
            zyjrDaihouBaoxian.setDaihou(Daihou.getId().toString());
            List<ZyjrDaihouBaoxian> zyjrDaihouBaoxians = zyjrDaihouBaoxianService.selectZyjrDaihouBaoxianList(zyjrDaihouBaoxian);
            return AjaxResult.success(zyjrDaihouBaoxians);
        }
        return AjaxResult.success();
    }

    /**
     * 新增【请填写功能名称】
     */

    @PostMapping
    public AjaxResult add( ZyjrDaihouBaoxian zyjrDaihouBaoxian)
    {

        ZyjrDaihou Daihou=zyjrDaihouMapper.selectZyjrDaihouByT(zyjrDaihouBaoxian.getDaihou());
        if(Daihou==null){
            Daihou.setBaoxian("1");
            Daihou.setTransactionCode(zyjrDaihouBaoxian.getDaihou());
            zyjrDaihouMapper.insertZyjrDaihou(Daihou);
        }else{
            Daihou.setBaoxian("1");
            zyjrDaihouMapper.updateZyjrDaihou(Daihou);
        }

            zyjrDaihouBaoxianService.deleteZyjrDaihouBaoxianById(Daihou.getId());
            if(zyjrDaihouBaoxian.getPic()!=null){
                JSONArray jsonarray = JSONArray.fromObject(zyjrDaihouBaoxian.getPic());
                System.out.println(jsonarray);
                List<ZyjrDaihouBaoxian> list = (List)JSONArray.toList(jsonarray, ZyjrDaihouBaoxian.class);
                for (ZyjrDaihouBaoxian daihouBaoxian : list) {
                    daihouBaoxian.setDaihou(Daihou.getId().toString());
                    zyjrDaihouBaoxianService.insertZyjrDaihouBaoxian(daihouBaoxian);
                }
                return AjaxResult.success();
            }

        return AjaxResult.success();
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:baoxian:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrDaihouBaoxian zyjrDaihouBaoxian)
    {
        return toAjax(zyjrDaihouBaoxianService.updateZyjrDaihouBaoxian(zyjrDaihouBaoxian));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:baoxian:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrDaihouBaoxianService.deleteZyjrDaihouBaoxianByIds(ids));
    }
}
