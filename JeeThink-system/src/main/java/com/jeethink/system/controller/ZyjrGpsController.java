package com.jeethink.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.DqVo;
import com.jeethink.system.mapper.*;
import com.jeethink.system.util.androidUpload;
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
import com.jeethink.system.service.IZyjrGpsService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-23
 */
@RestController
@RequestMapping("/system/gps")
public class ZyjrGpsController extends BaseController
{
    @Autowired
    private IZyjrGpsService zyjrGpsService;
    @Autowired
    private ZyjrPicMapper zyjrPicMapper;
    @Autowired
    private ExamineMapper examineMapper;
    @Autowired
    private ZyjrInsuranceMapper zyjrInsuranceMapper;
    @Autowired
    private ZyjrDaiqianAccoutMapper zyjrDaiqianAccoutMapper;
    @Autowired
    private ZyjrGpsMapper zyjrGpsMapper;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:gps:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrGps zyjrGps)
    {
        startPage();
        List<ZyjrGps> list = zyjrGpsService.selectZyjrGpsList(zyjrGps);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:gps:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrGps zyjrGps)
    {
        List<ZyjrGps> list = zyjrGpsService.selectZyjrGpsList(zyjrGps);
        ExcelUtil<ZyjrGps> util = new ExcelUtil<ZyjrGps>(ZyjrGps.class);
        return util.exportExcel(list, "gps");
    }

    @PostMapping("insert")
    public AjaxResult post(ZyjrGps zyjrGps){
        zyjrGps.setState("1");
        int ceshi=zyjrGpsService.insertZyjrGps(zyjrGps);
        if(ceshi>0){
            Map<String,String> map=new HashMap<>();
            map.put("transactionCode",zyjrGps.getTransactionCode());
            return  AjaxResult.success(map);
        }
        return  AjaxResult.error();
    }

    @PostMapping("update")
    public AjaxResult date(ZyjrGps zyjrGps){
        ZyjrDaiqian as=examineMapper.selByDaiqian(zyjrGps.getTransactionCode());
        ZyjrGps gsp=zyjrGpsMapper.selectZyjrGpsById(zyjrGps.getTransactionCode());
        if(as!=null){
            as.setGps(zyjrGps.getState());
            examineMapper.updateByDaiqian2(as);
        }else{
            ZyjrDaiqian d=new ZyjrDaiqian();
            d.setGps(zyjrGps.getState());
            d.setTransactionCode(zyjrGps.getTransactionCode());
            examineMapper.insertDaiqian2(d);
        }
        if(gsp!=null){
            zyjrGps.setId(gsp.getId());
            zyjrGpsService.updateZyjrGps(zyjrGps);
            return AjaxResult.success();
        }
        zyjrGpsService.insertZyjrGps(zyjrGps);
        return  AjaxResult.success();
    }

    @PostMapping("insert/pic")
    public AjaxResult pic(ZyjrGps zyjrGps){
        ZyjrDaiqian as=examineMapper.selByDaiqian(zyjrGps.getTransactionCode());
        as.setGpsPic(zyjrGps.getStatePic());
        examineMapper.updateByDaiqian2(as);
        DqVo dq=examineMapper.selectDQ2(zyjrGps.getTransactionCode());
        if(dq!=null&&dq.getGps()!=null){
            zyjrPicMapper.deleteZyjrPicById(dq.getGps());
                JSONArray jsonarray = JSONArray.fromObject(zyjrGps.getPic());
             //   System.out.println(jsonarray);
                List<ZyjrPic> list = (List)JSONArray.toList(jsonarray, ZyjrPic.class);
                for (ZyjrPic pic : list) {
                    pic.setGpsId(dq.getGps().toString());
                    zyjrPicMapper.insertZyjrPic(pic);
                }

                return AjaxResult.success();

        }
        zyjrGpsService.insertZyjrGps(zyjrGps);
        JSONArray jsonarray = JSONArray.fromObject(zyjrGps.getPic());
       // System.out.println(jsonarray);
        List<ZyjrPic> list = (List)JSONArray.toList(jsonarray, ZyjrPic.class);
        for (ZyjrPic pic : list) {
            pic.setGpsId(zyjrGps.getId().toString() );
            zyjrPicMapper.insertZyjrPic(pic);
        }

        return  AjaxResult.success();
    }



    /**
     * 获取【请填写功能名称】详细信息
     */
   // @PreAuthorize("@ss.hasPermi('system:gps:query')")
    @GetMapping(value = "/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("transactionCode") String transactionCode)
    {
        ZyjrDaiqian daiqian=examineMapper.selByDaiqian(transactionCode);
        Map<String,Object> map=new HashMap<>();
        ZyjrGps a=zyjrGpsService.selectZyjrGpsById(transactionCode);
        AjaxResult json=new AjaxResult();
        json.put("msg","操作成功");
        json.put("code",200);
        if(a!=null){
            ZyjrPic zyjrPic=new ZyjrPic();
            zyjrPic.setGpsId(a.getId().toString());
            List<ZyjrPic> b=zyjrPicMapper.selectZyjrPicList(zyjrPic);
            map.put("gps",a);
            map.put("pic",b);
            json.put("data",map);

            return json;
        }

        json.put("data",null);
        return json;
    }

    /**
     * 新增【请填写功能名称】7
     */
    @PreAuthorize("@ss.hasPermi('system:gps:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrGps zyjrGps)
    {
        return toAjax(zyjrGpsService.insertZyjrGps(zyjrGps));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:gps:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrGps zyjrGps)
    {
        return toAjax(zyjrGpsService.updateZyjrGps(zyjrGps));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:gps:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrGpsService.deleteZyjrGpsByIds(ids));
    }
}
