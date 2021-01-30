package com.jeethink.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeethink.system.domain.ZyjrDaiqian;
import com.jeethink.system.domain.ZyjrDaiqianAccout;
import com.jeethink.system.domain.ZyjrGps;
import com.jeethink.system.domain.vo.DqVo;
import com.jeethink.system.mapper.ExamineMapper;
import com.jeethink.system.mapper.ZyjrDaiqianAccoutMapper;
import com.jeethink.system.mapper.ZyjrGpsMapper;
import com.jeethink.system.mapper.ZyjrInsuranceMapper;
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
import com.jeethink.system.domain.ZyjrInsurance;
import com.jeethink.system.service.IZyjrInsuranceService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 123Controller
 * 
 * @author jeethink
 * @date 2020-12-24
 */
@RestController
@RequestMapping("/system/insurance")
public class ZyjrInsuranceController extends BaseController
{
    @Autowired
    private IZyjrInsuranceService zyjrInsuranceService;
    @Autowired
    private ZyjrInsuranceMapper zyjrInsuranceMapper;
    @Autowired
    private ExamineMapper examineMapper;
    @Autowired
    private ZyjrGpsMapper zyjrGpsMapper;
    @Autowired
    private ZyjrDaiqianAccoutMapper zyjrDaiqianAccoutMapper;



    /**
     * 查询123列表
     */
    @PreAuthorize("@ss.hasPermi('system:insurance:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrInsurance zyjrInsurance)
    {
        startPage();
        List<ZyjrInsurance> list = zyjrInsuranceService.selectZyjrInsuranceList(zyjrInsurance);
        return getDataTable(list);
    }

    @GetMapping("getCar/{transactionCode}")
    public AjaxResult app(@PathVariable("transactionCode") String transactionCode){
        ZyjrInsurance zyjrInsurance = zyjrInsuranceMapper.selectZyjrInsuranceByIds(transactionCode);
        Map<String,Object> map=new HashMap<>();
        if(zyjrInsurance!=null){
            map.put("id",zyjrInsurance.getId());
            map.put("insuranceCompany",zyjrInsurance.getInsuranceCompany());
            map.put("money",zyjrInsurance.getMoney());
            map.put("zyjrCarId",zyjrInsurance.getZyjrCarId());
            map.put("transactionCode",zyjrInsurance.getTransactionCode());
            map.put("userId",zyjrInsurance.getUserId());
        }


        return AjaxResult.success("操作成功",zyjrInsurance);
    }

    @GetMapping("ceshi/{transactionCode}")
    public AjaxResult apqp(@PathVariable("transactionCode") String transactionCode){
        DqVo a=examineMapper.selectDQ(transactionCode);
        return AjaxResult.success(a);
    }


    @PostMapping("update")
    public AjaxResult insert(ZyjrInsurance zyjrInsurance){
        DqVo a=examineMapper.selectDQ3(zyjrInsurance.getTransactionCode());
        ZyjrInsurance zyjrInsurance1 = zyjrInsuranceMapper.selectZyjrInsuranceByIds(zyjrInsurance.getTransactionCode());
        ZyjrGps gps=new ZyjrGps();
        ZyjrDaiqianAccout zyjrDaiqianAccout=new ZyjrDaiqianAccout();
        if(a!=null){
            gps.setId(a.getGps());
            gps.setState("2");
            zyjrDaiqianAccout.setId(a.getDaiqian());
            zyjrDaiqianAccout.setState("2");
        }

        if(zyjrInsurance1!=null&&zyjrInsurance1.getId()!=null){
            zyjrInsurance.setState("1");
            if(a!=null&&"1".equals(a.getStateb())&&"1".equals(a.getStatec())){
                zyjrInsurance.setState("2");
                zyjrGpsMapper.updateZyjrGps(gps);
                zyjrDaiqianAccoutMapper.updateZyjrDaiqianAccout(zyjrDaiqianAccout);
                ZyjrDaiqian daiqian=examineMapper.selByDaiqian(zyjrInsurance.getTransactionCode());
                if(daiqian!=null){

                }else{
                    examineMapper.insertDaiqians(zyjrInsurance.getTransactionCode());
                }
            }
            zyjrInsuranceMapper.updateZyjrInsurance(zyjrInsurance);
            return  AjaxResult.success();
        }
        zyjrInsurance.setState("1");
        if(a!=null&&"1".equals(a.getStateb())&&"1".equals(a.getStatec())){
            zyjrInsurance.setState("2");
            zyjrGpsMapper.updateZyjrGps(gps);
            zyjrDaiqianAccoutMapper.updateZyjrDaiqianAccout(zyjrDaiqianAccout);
            ZyjrDaiqian daiqian=examineMapper.selByDaiqian(zyjrInsurance.getTransactionCode());
            if(daiqian!=null){

            }else{
                examineMapper.insertDaiqians(zyjrInsurance.getTransactionCode());
            }
        }
        zyjrInsuranceMapper.insertZyjrInsurance(zyjrInsurance);

        return  AjaxResult.success();
    }




    /**
     * 导出123列表
     */
    @PreAuthorize("@ss.hasPermi('system:insurance:export')")
    @Log(title = "123", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrInsurance zyjrInsurance)
    {
        List<ZyjrInsurance> list = zyjrInsuranceService.selectZyjrInsuranceList(zyjrInsurance);
        ExcelUtil<ZyjrInsurance> util = new ExcelUtil<ZyjrInsurance>(ZyjrInsurance.class);
        return util.exportExcel(list, "insurance");
    }

    /**
     * 获取123详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:insurance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrInsuranceService.selectZyjrInsuranceById(id));
    }

    @GetMapping(value = "/get/{id}")
    public AjaxResult getInfos(@PathVariable("id") String id)
    {
        return AjaxResult.success(zyjrInsuranceService.selectZyjrInsuranceByIds(id));
    }

    /**
     * 新增123
     */
    @PreAuthorize("@ss.hasPermi('system:insurance:add')")
    @Log(title = "123", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrInsurance zyjrInsurance)
    {
        return toAjax(zyjrInsuranceService.insertZyjrInsurance(zyjrInsurance));
    }

    /**
     * 修改123
     */
    @PreAuthorize("@ss.hasPermi('system:insurance:edit')")
    @Log(title = "123", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrInsurance zyjrInsurance)
    {
        return toAjax(zyjrInsuranceService.updateZyjrInsurance(zyjrInsurance));
    }

    /**
     * 删除123
     */
    @PreAuthorize("@ss.hasPermi('system:insurance:remove')")
    @Log(title = "123", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrInsuranceService.deleteZyjrInsuranceByIds(ids));
    }
}
