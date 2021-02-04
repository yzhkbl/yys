package com.jeethink.system.controller;

import java.util.List;

import com.jeethink.system.domain.ZyjrDaihou;
import com.jeethink.system.domain.ZyjrDaihouBaoxian;
import com.jeethink.system.domain.ZyjrDaihouQita;
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
import com.jeethink.system.domain.ZyjrDaihouTiche;
import com.jeethink.system.service.IZyjrDaihouTicheService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@RestController
@RequestMapping("/system/tiche")
public class ZyjrDaihouTicheController extends BaseController
{
    @Autowired
    private IZyjrDaihouTicheService zyjrDaihouTicheService;
    @Autowired
    private ZyjrDaihouMapper zyjrDaihouMapper;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:tiche:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrDaihouTiche zyjrDaihouTiche)
    {
        startPage();
        List<ZyjrDaihouTiche> list = zyjrDaihouTicheService.selectZyjrDaihouTicheList(zyjrDaihouTiche);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:tiche:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrDaihouTiche zyjrDaihouTiche)
    {
        List<ZyjrDaihouTiche> list = zyjrDaihouTicheService.selectZyjrDaihouTicheList(zyjrDaihouTiche);
        ExcelUtil<ZyjrDaihouTiche> util = new ExcelUtil<ZyjrDaihouTiche>(ZyjrDaihouTiche.class);
        return util.exportExcel(list, "tiche");
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
            ZyjrDaihouTiche zyjrDaihouBaoxian=new ZyjrDaihouTiche();
            zyjrDaihouBaoxian.setDaihou(Daihou.getId().toString());
            List<ZyjrDaihouTiche> zyjrDaihouTiches = zyjrDaihouTicheService.selectZyjrDaihouTicheList(zyjrDaihouBaoxian);
            json.put("data",zyjrDaihouTiches);
            String a=null;
            if(Daihou.getZhengshu()!=null&&Daihou.getBaoxian()!=null&&Daihou.getQita()!=null&&Daihou.getLvben()!=null&&Daihou.getTiche()!=null){
                a="1";
            }
            json.put("state",a);
            return json;
        }
        return json;
    }

    /**
     * 新增【请填写功能名称】
     */

    @PostMapping
    public AjaxResult add( ZyjrDaihouTiche zyjrDaihouBaoxian)
    {

        ZyjrDaihou Daihou=zyjrDaihouMapper.selectZyjrDaihouByT(zyjrDaihouBaoxian.getDaihou());
        if(Daihou==null){
            ZyjrDaihou Daihou2=new ZyjrDaihou();
            Daihou=Daihou2;
            Daihou.setTiche("1");
            Daihou.setTransactionCode(zyjrDaihouBaoxian.getDaihou());
            zyjrDaihouMapper.insertZyjrDaihou(Daihou);
        }else{
            Daihou.setTiche("1");
            zyjrDaihouMapper.updateZyjrDaihou(Daihou);
        }

        zyjrDaihouTicheService.deleteZyjrDaihouTicheById(Daihou.getId());
        if(zyjrDaihouBaoxian.getPic()!=null){
            JSONArray jsonarray = JSONArray.fromObject(zyjrDaihouBaoxian.getPic());
           // System.out.println(jsonarray);
            List<ZyjrDaihouTiche> list = (List)JSONArray.toList(jsonarray, ZyjrDaihouTiche.class);
            for (ZyjrDaihouTiche daihouBaoxian : list) {
                daihouBaoxian.setDaihou(Daihou.getId().toString());
                zyjrDaihouTicheService.insertZyjrDaihouTiche(daihouBaoxian);
            }
            return AjaxResult.success();
        }

        return AjaxResult.success();
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:tiche:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrDaihouTiche zyjrDaihouTiche)
    {
        return toAjax(zyjrDaihouTicheService.updateZyjrDaihouTiche(zyjrDaihouTiche));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:tiche:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrDaihouTicheService.deleteZyjrDaihouTicheByIds(ids));
    }
}
