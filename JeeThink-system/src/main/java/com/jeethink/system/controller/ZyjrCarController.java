package com.jeethink.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeethink.common.utils.file.FileUploadUtils;
import com.jeethink.system.domain.SysFileInfo;
import com.jeethink.system.domain.ZyjrCarAccount;
import com.jeethink.system.domain.vo.Linkman;
import com.jeethink.system.domain.vo.StoreInformation;
import com.jeethink.system.mapper.SysFileInfoMapper;
import com.jeethink.system.service.IZyjrCarAccountService;
import com.jeethink.system.util.androidUpload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jeethink.common.annotation.Log;
import com.jeethink.common.core.controller.BaseController;
import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.enums.BusinessType;
import com.jeethink.system.domain.ZyjrCar;
import com.jeethink.system.service.IZyjrCarService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 车商信息Controller
 * 
 * @author jeethink
 * @date 2020-12-14
 */
@RestController
@RequestMapping("/system/car")
@Api("ccccc")
public class ZyjrCarController extends BaseController
{
    @Autowired
    private IZyjrCarService zyjrCarService;
    @Autowired
    private IZyjrCarAccountService zyjrCarAccountService;
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;


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

   /* @GetMapping("/get")
    public AjaxResult insert()
    {
        ZyjrCar zyjrCar=new ZyjrCar();
        int a=zyjrCarService.insertZyjrCar(zyjrCar);
        if(a>0){
            return AjaxResult.success(zyjrCar.getId());
        }
        return AjaxResult.error();
    }*/

    @PostMapping("/linkman")
    @ApiOperation("ffffffffffff")
    public AjaxResult linkman(Linkman linkman)
    {
        if(linkman==null){
            return AjaxResult.error("参数没传过来");
        }
        ZyjrCar a=zyjrCarService.selectZyjrCarById(Long.parseLong(linkman.getId()));
        a.setRemark(linkman.getRemark());
        a.setUserName(linkman.getUserName());
        a.setGender(linkman.getGender());
        a.setPhoneNumber(linkman.getPhoneNumber());
        a.setIsLinkman(linkman.getIsLinkman());
        a.setIdentity(linkman.getIdentity());
        a.setOneCarState("1");
        int ceshi=zyjrCarService.updateZyjrCar(a);
        if(ceshi>0){
            Map<String,Object> map=new HashMap<>();
            map.put("shopId",a.getId());
            return AjaxResult.success(map);

        }
        return AjaxResult.error();
    }

    @PostMapping("/storeInformation")
    @ApiOperation("ccccc")
    public AjaxResult linkman2(StoreInformation storeInformation)
    {
        if(storeInformation==null){
            return AjaxResult.error("参数没传过来");
        }
        ZyjrCar a=new ZyjrCar();
        a.setArea(storeInformation.getArea());
        a.setCity(storeInformation.getCity());
        a.setBazaar(storeInformation.getBazaar());
        a.setShopType(storeInformation.getShopType());
        a.setBusinessType(storeInformation.getBusinessType());
        if(storeInformation.getStall()!=null){
            a.setStall(storeInformation.getStall());
            a.setBusinessNature(storeInformation.getBusinessNature());
        }

        a.setPassengerCar(storeInformation.getPassengerCar());
        a.setMonthDeal(storeInformation.getMonthDeal());
        a.setMonthInstallment(storeInformation.getMonthInstallment());
        a.setMatchAmount(storeInformation.getMatchAmount());
        a.setDetailAddress(storeInformation.getDetailAddress());
        a.setPic(storeInformation.getPic());
        a.setTwoCarState("1");
        int ceshi=zyjrCarService.insertZyjrCar(a);
        if(ceshi>0){
            Map<String,Object> map=new HashMap<>();
            map.put("shopId",a.getId());
            return AjaxResult.success(map);
        }
        return AjaxResult.error();
    }

    @PostMapping("/account")
    @ApiOperation("ccccc")
    public AjaxResult linkman2(ZyjrCarAccount zyjrCarAccount)
    {
        if(zyjrCarAccount==null){
            return AjaxResult.error("参数没传过来");
        }
        ZyjrCar zz=new ZyjrCar();
        zz.setId(Long.parseLong(zyjrCarAccount.getZyjrCarId()));
        zz.setThreeCarState("1");
        zyjrCarService.updateZyjrCar(zz);
        int ceshi=zyjrCarAccountService.insertZyjrCarAccount(zyjrCarAccount);
        if(ceshi>0){
            Map<String,Object> map=new HashMap<>();
            map.put("shopId",zyjrCarAccount.getZyjrCarId());
            return AjaxResult.success(map);
        }
        return AjaxResult.error();
    }

    @GetMapping("/delete/{id}")
    public AjaxResult dele(@PathVariable("id") String id)
    {
        int ceshi=zyjrCarService.deleteZyjrCarById(Long.parseLong(id));
        if(ceshi>0){
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    @PostMapping("/pic")
    @ApiOperation("111111111")
    public AjaxResult testFiles(@RequestParam("file")List<String> file, @RequestParam("name") List<String> name,  @RequestParam("id") List<String> id){
        List<String> pic=new ArrayList<>();
        for (int i = 0; i < id.size(); i++) {
            String a= androidUpload.upload(file.get(i));
            SysFileInfo info=new SysFileInfo();
            info.setFilePath(a);
            info.setId(id.get(i));
            info.setFileName(name.get(i));
            int ceshi=sysFileInfoMapper.insertSysFileInfo(info);
            if(ceshi<1){
                return AjaxResult.error();
            }
            String as="http://192.168.31.82/dev-api"+a;
            pic.add(as);
        }

        return AjaxResult.success(pic);
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
