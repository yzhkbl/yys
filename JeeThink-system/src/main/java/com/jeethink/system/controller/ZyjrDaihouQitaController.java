package com.jeethink.system.controller;

import java.util.List;

import com.jeethink.system.domain.ZyjrDaihou;
import com.jeethink.system.domain.ZyjrDaihouBaoxian;
import com.jeethink.system.mapper.ZyjrDaihouMapper;
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
import com.jeethink.system.domain.ZyjrDaihouQita;
import com.jeethink.system.service.IZyjrDaihouQitaService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@RestController
@RequestMapping("/system/qita")
public class ZyjrDaihouQitaController extends BaseController
{
    @Autowired
    private IZyjrDaihouQitaService zyjrDaihouQitaService;
    @Autowired
    private ZyjrDaihouMapper zyjrDaihouMapper;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:qita:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrDaihouQita zyjrDaihouQita)
    {
        startPage();
        List<ZyjrDaihouQita> list = zyjrDaihouQitaService.selectZyjrDaihouQitaList(zyjrDaihouQita);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:qita:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrDaihouQita zyjrDaihouQita)
    {
        List<ZyjrDaihouQita> list = zyjrDaihouQitaService.selectZyjrDaihouQitaList(zyjrDaihouQita);
        ExcelUtil<ZyjrDaihouQita> util = new ExcelUtil<ZyjrDaihouQita>(ZyjrDaihouQita.class);
        return util.exportExcel(list, "qita");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("transactionCode") String transactionCode)
    {
        ZyjrDaihou Daihou=zyjrDaihouMapper.selectZyjrDaihouByT(transactionCode);
        AjaxResult json=new AjaxResult();
        json.put("msg","操作成功");
        json.put("code",200);
        json.put("data",null);
        json.put("state","0");
        if(Daihou!=null){
            ZyjrDaihouQita zyjrDaihouBaoxian=new ZyjrDaihouQita();
            zyjrDaihouBaoxian.setDaihou(Daihou.getId().toString());
            List<ZyjrDaihouQita> zyjrDaihouQitas = zyjrDaihouQitaService.selectZyjrDaihouQitaList(zyjrDaihouBaoxian);
            json.put("data",zyjrDaihouQitas);
            json.put("state",Daihou.getQita());
            return json;
        }
        return json;
    }

    /**
     * 新增【请填写功能名称】
     */

    @PostMapping
    public AjaxResult add( ZyjrDaihouQita zyjrDaihouBaoxian)
    {

        ZyjrDaihou Daihou=zyjrDaihouMapper.selectZyjrDaihouByT(zyjrDaihouBaoxian.getDaihou());
        if(Daihou==null){
            ZyjrDaihou Daihou2=new ZyjrDaihou();
            Daihou=Daihou2;
            Daihou.setQita(zyjrDaihouBaoxian.getState());
            Daihou.setTransactionCode(zyjrDaihouBaoxian.getDaihou());
            zyjrDaihouMapper.insertZyjrDaihou(Daihou);
        }else{
            Daihou.setQita(zyjrDaihouBaoxian.getState());
            zyjrDaihouMapper.updateZyjrDaihou(Daihou);
        }

        zyjrDaihouQitaService.deleteZyjrDaihouQitaById(Daihou.getId());
        if(zyjrDaihouBaoxian.getPic()!=null){
            JSONArray jsonarray = JSONArray.fromObject(zyjrDaihouBaoxian.getPic());
           // System.out.println(jsonarray);
            List<ZyjrDaihouQita> list = (List)JSONArray.toList(jsonarray, ZyjrDaihouQita.class);
            for (ZyjrDaihouQita daihouBaoxian : list) {
                daihouBaoxian.setDaihou(Daihou.getId().toString());
                zyjrDaihouQitaService.insertZyjrDaihouQita(daihouBaoxian);
            }
            return AjaxResult.success();
        }

        return AjaxResult.success();
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:qita:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrDaihouQita zyjrDaihouQita)
    {
        return toAjax(zyjrDaihouQitaService.updateZyjrDaihouQita(zyjrDaihouQita));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:qita:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrDaihouQitaService.deleteZyjrDaihouQitaByIds(ids));
    }
}
