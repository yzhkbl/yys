package com.jeethink.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.DqVo;
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
import com.jeethink.system.service.IZyjrDaiqianAccoutService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-05
 */
@RestController
@RequestMapping("/system/accout")
public class ZyjrDaiqianAccoutController extends BaseController
{
    @Autowired
    private IZyjrDaiqianAccoutService zyjrDaiqianAccoutService;
    @Autowired
    private ZyjrAllowBasicsMapper zyjrAllowBasicsMapper;
    @Autowired
    private ZyjrCarAccountMapper zyjrCarAccountMapper;
    @Autowired
    private ExamineMapper examineMapper;
    @Autowired
    private ZyjrGpsMapper zyjrGpsMapper;
    @Autowired
    private ZyjrInsuranceMapper zyjrInsuranceMapper;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:accout:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrDaiqianAccout zyjrDaiqianAccout)
    {
        startPage();
        List<ZyjrDaiqianAccout> list = zyjrDaiqianAccoutService.selectZyjrDaiqianAccoutList(zyjrDaiqianAccout);
        return getDataTable(list);
    }

    @PostMapping("/no")
    public AjaxResult li(ZyjrDaiqian zyjrDaiqian)
    {

        ZyjrDaiqian as=examineMapper.selByDaiqian(zyjrDaiqian.getTransactionCode());
        if(as!=null){
            examineMapper.updateByDaiqian(zyjrDaiqian);
        }
        examineMapper.insertDaiqian(zyjrDaiqian);
        if(zyjrDaiqian.getState().equals("2")){
            DqVo a=examineMapper.selectDQ(zyjrDaiqian.getTransactionCode());
            ZyjrGps zyjrGps=new ZyjrGps();
            zyjrGps.setId(a.getGps());
            zyjrGps.setState("0");
            zyjrGpsMapper.updateZyjrGps(zyjrGps);
            ZyjrInsurance zyjrInsurance=new ZyjrInsurance();
            zyjrInsurance.setState("0");
            zyjrInsurance.setId(a.getInsurance());
            zyjrInsuranceMapper.updateZyjrInsurance(zyjrInsurance);
            ZyjrDaiqianAccout zyjrDaiqianAccout =new ZyjrDaiqianAccout();
            zyjrDaiqianAccout.setState("0");
            zyjrDaiqianAccout.setId(a.getDaiqian());
            zyjrDaiqianAccoutService.updateZyjrDaiqianAccout(zyjrDaiqianAccout);
        }else if(zyjrDaiqian.getState().equals("3")){
            DqVo a=examineMapper.selectDQ(zyjrDaiqian.getTransactionCode());
            ZyjrGps zyjrGps=new ZyjrGps();
            zyjrGps.setId(a.getGps());
            zyjrGps.setState("0");
            zyjrGpsMapper.updateZyjrGps(zyjrGps);
            ZyjrInsurance zyjrInsurance=new ZyjrInsurance();
            zyjrInsurance.setState("0");
            zyjrInsurance.setId(a.getInsurance());
            zyjrInsuranceMapper.updateZyjrInsurance(zyjrInsurance);
            ZyjrDaiqianAccout zyjrDaiqianAccout =new ZyjrDaiqianAccout();
            zyjrDaiqianAccout.setState("0");
            zyjrDaiqianAccout.setId(a.getDaiqian());
            zyjrDaiqianAccoutService.updateZyjrDaiqianAccout(zyjrDaiqianAccout);
        }

        return AjaxResult.success();
    }

    @GetMapping("/yes")
    public AjaxResult list(String transactionCode)
    {
        ZyjrDaiqian as=examineMapper.selByDaiqian(transactionCode);

        return AjaxResult.success(as);
    }



    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:accout:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrDaiqianAccout zyjrDaiqianAccout)
    {
        List<ZyjrDaiqianAccout> list = zyjrDaiqianAccoutService.selectZyjrDaiqianAccoutList(zyjrDaiqianAccout);
        ExcelUtil<ZyjrDaiqianAccout> util = new ExcelUtil<ZyjrDaiqianAccout>(ZyjrDaiqianAccout.class);
        return util.exportExcel(list, "accout");
    }

    @GetMapping("getAccout/{transactionCode}")
    public AjaxResult apps(@PathVariable("transactionCode") String transactionCode){

        ZyjrAllowBasics a=zyjrAllowBasicsMapper.selectByT(transactionCode);
        if(a!=null){
            ZyjrCarAccount c=zyjrCarAccountMapper.selectZyjrCarAccountById(a.getId());
            return AjaxResult.success("操作成功",c);
        }
        return AjaxResult.error();
    }

 @GetMapping("ceshi/{transactionCode}")
    public AjaxResult apqp(@PathVariable("transactionCode") String transactionCode){
       /* DqVo a=examineMapper.selectDQ(transactionCode);*/
        return AjaxResult.success();
    }

  /*
    @PostMapping("update")
    public AjaxResult insert(ZyjrInsurance zyjrInsurance){
        DqVo a=examineMapper.selectDQ(zyjrInsurance.getTransactionCode());
        ZyjrGps gps=new ZyjrGps();
        gps.setId(a.getGps());
        gps.setState("2");
        ZyjrDaiqianAccout zyjrDaiqianAccout=new ZyjrDaiqianAccout();
        zyjrDaiqianAccout.setId(a.getDaiqian());
        zyjrDaiqianAccout.setState("2");
        if(zyjrInsurance.getId()!=null){
            zyjrInsurance.setState("1");
            if("1".equals(a.getStateb())&&"1".equals(a.getStatec())){
                zyjrInsurance.setState("2");
                zyjrGpsMapper.updateZyjrGps(gps);
                zyjrDaiqianAccoutMapper.updateZyjrDaiqianAccout(zyjrDaiqianAccout);
            }
            zyjrInsuranceMapper.updateZyjrInsurance(zyjrInsurance);
            return  AjaxResult.success();
        }
        zyjrInsurance.setState("1");
        if("1".equals(a.getStateb())&&"1".equals(a.getStatec())){
            zyjrInsurance.setState("2");
            zyjrGpsMapper.updateZyjrGps(gps);
            zyjrDaiqianAccoutMapper.updateZyjrDaiqianAccout(zyjrDaiqianAccout);
        }
        zyjrInsuranceMapper.insertZyjrInsurance(zyjrInsurance);
        return  AjaxResult.success();
    }
*/
    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:accout:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrDaiqianAccoutService.selectZyjrDaiqianAccoutById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:accout:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrDaiqianAccout zyjrDaiqianAccout)
    {
        return toAjax(zyjrDaiqianAccoutService.insertZyjrDaiqianAccout(zyjrDaiqianAccout));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:accout:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrDaiqianAccout zyjrDaiqianAccout)
    {
        return toAjax(zyjrDaiqianAccoutService.updateZyjrDaiqianAccout(zyjrDaiqianAccout));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:accout:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrDaiqianAccoutService.deleteZyjrDaiqianAccoutByIds(ids));
    }
}
