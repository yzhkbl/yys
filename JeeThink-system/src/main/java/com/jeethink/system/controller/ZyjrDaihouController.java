package com.jeethink.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jeethink.system.domain.*;
import com.jeethink.system.mapper.*;
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
import com.jeethink.system.service.IZyjrDaihouService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@RestController
@RequestMapping("/system/daihou")
public class ZyjrDaihouController extends BaseController
{
    @Autowired
    private IZyjrDaihouService zyjrDaihouService;
    @Autowired
    private ZyjrDaihouBaoxianMapper zyjrDaihouBaoxianMapper;
    @Autowired
    private ZyjrDaihouLvbenMapper zyjrDaihouLvbenMapper;
    @Autowired
    private ZyjrDaihouQitaMapper zyjrDaihouQitaMapper;
    @Autowired
    private ZyjrDaihouTicheMapper zyjrDaihouTicheMapper;
    @Autowired
    private ZyjrDaihouZhengshuMapper zyjrDaihouZhengshuMapper;

    /**
     * 查询【请填写功能名称】列表
     */

    @GetMapping("/list")
    public TableDataInfo list(ZyjrDaihou zyjrDaihou)
    {
        startPage();
        List<ZyjrDaihou> list = zyjrDaihouService.selectZyjrDaihouList(zyjrDaihou);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:daihou:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrDaihou zyjrDaihou)
    {
        List<ZyjrDaihou> list = zyjrDaihouService.selectZyjrDaihouList(zyjrDaihou);
        ExcelUtil<ZyjrDaihou> util = new ExcelUtil<ZyjrDaihou>(ZyjrDaihou.class);
        return util.exportExcel(list, "daihou");
    }



    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        Map<String,Object> map=new HashMap<>();
        ZyjrDaihou a=zyjrDaihouService.selectZyjrDaihouById(id);
        map.put("shenpi",a);

        if(a!=null){
            ZyjrDaihouBaoxian zyjrDaihouBaoxian=new ZyjrDaihouBaoxian();
            zyjrDaihouBaoxian.setDaihou(a.getId().toString());
            List<ZyjrDaihouBaoxian> b=zyjrDaihouBaoxianMapper.selectZyjrDaihouBaoxianList(zyjrDaihouBaoxian);
            for (ZyjrDaihouBaoxian daihouBaoxian : b) {
                map.put(daihouBaoxian.getFileName(),daihouBaoxian.getFilePath());
            }
            List<String> bb=b.stream().map(ZyjrDaihouBaoxian::getFilePath).collect(Collectors.toList());
            ZyjrDaihouLvben c=zyjrDaihouLvbenMapper.selectZyjrDaihouLvbenById(a.getId());
            ZyjrDaihouTiche zyjrDaihouTiche=new ZyjrDaihouTiche();
            zyjrDaihouTiche.setDaihou(a.getId().toString());
            List<ZyjrDaihouTiche> d=zyjrDaihouTicheMapper.selectZyjrDaihouTicheList(zyjrDaihouTiche);
            for (ZyjrDaihouTiche daihouBaoxian : d) {
                map.put(daihouBaoxian.getFileName(),daihouBaoxian.getFilePath());
            }
            List<String> dd=d.stream().map(ZyjrDaihouTiche::getFilePath).collect(Collectors.toList());
            ZyjrDaihouQita qita=new ZyjrDaihouQita();
            qita.setDaihou(a.getId().toString());
            List<ZyjrDaihouQita> e=zyjrDaihouQitaMapper.selectZyjrDaihouQitaList(qita);
            for (ZyjrDaihouQita daihouBaoxian : e) {
                map.put(daihouBaoxian.getFileName(),daihouBaoxian.getFilePath());
            }
            List<String> ee=e.stream().map(ZyjrDaihouQita::getFilePath).collect(Collectors.toList());
            ZyjrDaihouZhengshu zyjrDaihouZhengshu=new ZyjrDaihouZhengshu();
            zyjrDaihouZhengshu.setDaihou(a.getId().toString());
            List<ZyjrDaihouZhengshu> f=zyjrDaihouZhengshuMapper.selectZyjrDaihouZhengshuList(zyjrDaihouZhengshu);
            for (ZyjrDaihouZhengshu daihouBaoxian : f) {
                map.put(daihouBaoxian.getFileName(),daihouBaoxian.getFilePath());
            }
            List<String> ff=f.stream().map(ZyjrDaihouZhengshu::getFilePath).collect(Collectors.toList());


            map.put("baoxian",bb);
            map.put("lvben",c);
            map.put("tiche",dd);
            map.put("qita",ee);
            map.put("zhengshu",ff);
        }


        return AjaxResult.success(map);
    }



    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:daihou:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrDaihou zyjrDaihou)
    {
        return toAjax(zyjrDaihouService.insertZyjrDaihou(zyjrDaihou));
    }

    @GetMapping("ok")
    public AjaxResult g(ZyjrDaihou zyjrDaihou)
    {
        return toAjax(zyjrDaihouService.updateZyjrDaihou(zyjrDaihou));
    }

    /**
     * 修改【请填写功能名称】
     */

    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrDaihou zyjrDaihou)
    {
        return toAjax(zyjrDaihouService.updateZyjrDaihou(zyjrDaihou));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:daihou:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrDaihouService.deleteZyjrDaihouByIds(ids));
    }
}
