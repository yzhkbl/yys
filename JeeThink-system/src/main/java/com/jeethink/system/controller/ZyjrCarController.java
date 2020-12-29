package com.jeethink.system.controller;

import java.util.*;
import java.util.stream.Collectors;

import com.jeethink.common.utils.DateUtils;
import com.jeethink.common.utils.SecurityUtils;
import com.jeethink.common.utils.file.FileUploadUtils;
import com.jeethink.common.utils.file.FileUtils;
import com.jeethink.system.domain.SysFileInfo;
import com.jeethink.system.domain.ZyjrCarAccount;
import com.jeethink.system.domain.vo.Linkman;
import com.jeethink.system.domain.vo.StoreInformation;
import com.jeethink.system.domain.vo.carVo;
import com.jeethink.system.mapper.ExamineMapper;
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
public class ZyjrCarController extends BaseController {
    @Autowired
    private IZyjrCarService zyjrCarService;
    @Autowired
    private IZyjrCarAccountService zyjrCarAccountService;
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;
    @Autowired
    private ExamineMapper examineMapper;


    /**
     * 查询车商信息列表
     */
    @PreAuthorize("@ss.hasPermi('organization:car:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrCar zyjrCar) {
        startPage();
        List<ZyjrCar> list = zyjrCarService.selectZyjrCarList(zyjrCar);

        return getDataTable(list);
    }

    /**
     * 导出车商信息列表
     */
    @PreAuthorize("@ss.hasPermi('organization:car:export')")
    @Log(title = "车商信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrCar zyjrCar) {
        List<ZyjrCar> list = zyjrCarService.selectZyjrCarList(zyjrCar);
        ExcelUtil<ZyjrCar> util = new ExcelUtil<ZyjrCar>(ZyjrCar.class);
        return util.exportExcel(list, "car");
    }

    @GetMapping("/lists")
    public AjaxResult lists(String createBy) {

        List<carVo> list = examineMapper.selectZyjrCarLists(createBy);

        System.err.println(list);
        return AjaxResult.success(list);
    }

    @GetMapping(value = "/getInfo/{id}")
    public AjaxResult getInfos(@PathVariable("id") Long id) {

        ZyjrCar a=zyjrCarService.selectZyjrCarById(id);
        SysFileInfo info=new SysFileInfo();
        info.setId(id.toString());
        info.setFileName("store");
        List<SysFileInfo> aa=sysFileInfoMapper.selectSysFileInfoList(info);
        List<String> path=aa.stream().map(SysFileInfo::getFilePath).collect(Collectors.toList());
        a.setPic(path);
        List<SysFileInfo> ceshi=new ArrayList<>();
        a.setSysFileInfo(ceshi);
        return AjaxResult.success(a);
    }


    @GetMapping(value = "/getLinkman/{id}")
    public AjaxResult getInfoss(@PathVariable("id") Long id) {

        Linkman a=examineMapper.selectZyjrCarByLinkman(id);

        return AjaxResult.success(a);
    }

    @GetMapping(value = "/getAccount/{id}")
    public AjaxResult getAccount(@PathVariable("id") Long id) {
       ZyjrCarAccount zyjrCarAccount= zyjrCarAccountService.selectZyjrCarAccountById(id);

        return AjaxResult.success(zyjrCarAccount);
    }


    /**
     * 获取车商信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('organization:car:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(zyjrCarService.selectZyjrCarById(id));
    }

    /**
     * 新增车商信息
     */
//    @PreAuthorize("@ss.hasPermi('organization:car:add')")
    @Log(title = "车商信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrCar zyjrCar) {
        int a = zyjrCarService.insertZyjrCar(zyjrCar);

        return toAjax(a);
    }

    @GetMapping("/get")
    public AjaxResult insert() {
        ZyjrCar zyjrCar = new ZyjrCar();
        zyjrCarService.insertZyjrCar(zyjrCar);

        return AjaxResult.success(zyjrCar.getId());
    }

    @PostMapping("/linkman")
    @ApiOperation("ffffffffffff")
    public AjaxResult linkman(Linkman linkman) {
        if (linkman == null&&linkman.getId()!=null) {
            return AjaxResult.error("参数没传过来");
        }
        System.err.println(linkman);
        ZyjrCar a = zyjrCarService.selectZyjrCarById(linkman.getId());
        a.setRemark(linkman.getRemark());
        a.setUserName(linkman.getUserName());
        a.setGender(linkman.getGender());
        a.setPhoneNumber(linkman.getPhoneNumber());
        a.setIsLinkman(linkman.getIsLinkman());
        a.setIdentity(linkman.getIdentity());
        a.setOneCarState("1");
        int ceshi = zyjrCarService.updateZyjrCar(a);
        if (ceshi > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("shopId", a.getId());
            return AjaxResult.success(map);

        }
        return AjaxResult.error();
    }

    @PostMapping("/storeInformation")
    @ApiOperation("ccccc")
    public AjaxResult linkman2(StoreInformation storeInformation) {
        if (storeInformation == null) {
            return AjaxResult.error("参数没传过来");
        }
        if(storeInformation.getStatus().equals("add")){

            ZyjrCar a = new ZyjrCar();
            a.setArea(storeInformation.getArea());
            a.setCity(storeInformation.getCity());
            a.setBazaar(storeInformation.getBazaar());
            a.setShopType(storeInformation.getShopType());
            a.setBusinessType(storeInformation.getBusinessType());

            a.setStall(storeInformation.getStall());
            a.setBusinessNature(storeInformation.getBusinessNature());

            a.setDealerName(storeInformation.getDealerName());
            a.setPassengerCar(storeInformation.getPassengerCar());
            a.setMonthDeal(storeInformation.getMonthDeal());
            a.setMonthInstallment(storeInformation.getMonthInstallment());
            a.setMatchAmount(storeInformation.getMatchAmount());
            a.setDetailAddress(storeInformation.getDetailAddress());


            //a.setPic(storeInformation.getPic());
            a.setTwoCarState("1");
            a.setCreateBy(storeInformation.getCreateBy());
            int ceshi = zyjrCarService.insertZyjrCar(a);
            String pics=storeInformation.getPic().substring(1,storeInformation.getPic().length() - 1);
            String[] pic=pics.split(",");
            for (String s : pic) {
                String asd=androidUpload.upload(s);
                SysFileInfo sysFileInfo=new SysFileInfo();
                sysFileInfo.setFileName("store");
                sysFileInfo.setId(a.getId().toString());
                String as = "http://192.168.31.82/dev-api" + asd;
                sysFileInfo.setFilePath(as);
                sysFileInfoMapper.insertSysFileInfo(sysFileInfo);
            }
            if (ceshi > 0) {
                Map<String, Object> map = new HashMap<>();
                map.put("shopId", a.getId());
                return AjaxResult.success(map);
            }
        }else if(storeInformation.getStatus().equals("edit")){
            SysFileInfo infos=new SysFileInfo();
            infos.setId(storeInformation.getId());
            List<SysFileInfo> SysFileInfo=sysFileInfoMapper.selectSysFileInfoList(infos);
            sysFileInfoMapper.deleteSysFileInfoByCarId(storeInformation.getId());
            if(SysFileInfo!=null){
                for (SysFileInfo sysFileInfo : SysFileInfo) {
                    String paths = "E:/demo/JeeThink-admin/src/main/java/com/jeethink/web/";
                    String[] s = sysFileInfo.getFilePath().split("//");
                    System.err.println(paths + "profile/web/" + s[1]);
                    boolean b = FileUtils.deleteFile(paths + "profile/web/" + s[1]);
                    if (b) {
                        return AjaxResult.success(b);
                    } else {
                        return AjaxResult.error("路径删除成功，但图片删除失败", b);
                    }
                }
            }


            ZyjrCar a = new ZyjrCar();
            a.setId(Long.parseLong(storeInformation.getId()));
            a.setArea(storeInformation.getArea());
            a.setCity(storeInformation.getCity());
            a.setBazaar(storeInformation.getBazaar());
            a.setShopType(storeInformation.getShopType());
            a.setBusinessType(storeInformation.getBusinessType());
            System.err.println(storeInformation.getStall());

            a.setStall(storeInformation.getStall());
            a.setBusinessNature(storeInformation.getBusinessNature());

            a.setDealerName(storeInformation.getDealerName());
            a.setPassengerCar(storeInformation.getPassengerCar());
            a.setMonthDeal(storeInformation.getMonthDeal());
            a.setMonthInstallment(storeInformation.getMonthInstallment());
            a.setMatchAmount(storeInformation.getMatchAmount());
            a.setDetailAddress(storeInformation.getDetailAddress());


            //a.setPic(storeInformation.getPic());
            a.setTwoCarState("1");
            a.setCreateBy(storeInformation.getCreateBy());
            int ceshi = zyjrCarService.updateZyjrCar(a);
            String pics=storeInformation.getPic().substring(1,storeInformation.getPic().length() - 1);
            String[] pic=pics.split(",");
            for (String s : pic) {
                String asd=androidUpload.upload(s);
                SysFileInfo sysFileInfo=new SysFileInfo();
                sysFileInfo.setFileName("store");
                sysFileInfo.setId(a.getId().toString());
                String as = "http://192.168.31.82/dev-api" + asd;
                sysFileInfo.setFilePath(as);
                sysFileInfoMapper.insertSysFileInfo(sysFileInfo);
            }
            if (ceshi > 0) {
                Map<String, Object> map = new HashMap<>();
                map.put("shopId", a.getId());
                return AjaxResult.success(map);
            }
        }

        return AjaxResult.error();
    }


    @PostMapping("/account")
    @ApiOperation("ccccc")
    public AjaxResult linkman2(ZyjrCarAccount zyjrCarAccount) {
        if (zyjrCarAccount == null) {
            return AjaxResult.error("参数没传过来");
        }
        ZyjrCarAccount zyjrCarAccounts=new ZyjrCarAccount();
        zyjrCarAccounts.setZyjrCarId(zyjrCarAccount.getZyjrCarId());
        List<ZyjrCarAccount> zyjrCarAccounts1=zyjrCarAccountService.selectZyjrCarAccountList(zyjrCarAccounts);
        if(zyjrCarAccounts1.size()>0){

            int size=zyjrCarAccountService.updateZyjrCarAccount(zyjrCarAccount);
            if (size > 0) {
                Map<String, Object> map = new HashMap<>();
                map.put("shopId", zyjrCarAccount.getZyjrCarId());
                return AjaxResult.success(map);
            }
        }
        int ceshi = zyjrCarAccountService.insertZyjrCarAccount(zyjrCarAccount);
        if (ceshi > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("shopId", zyjrCarAccount.getZyjrCarId());
            return AjaxResult.success(map);
        }

        return AjaxResult.error();
    }

    @GetMapping("/delete/{id}")
    public AjaxResult delete(@PathVariable("id") String id) {
        int ceshi = zyjrCarService.deleteZyjrCarById(Long.parseLong(id));
        if (ceshi > 0) {
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    @PostMapping("/pic")
    @ApiOperation("111111111")
    public AjaxResult testFiles(@RequestParam("file") List<String> file, @RequestParam("name") List<String> name, @RequestParam("id") List<String> id) {
        List<String> pic = new ArrayList<>();
        for (int i = 0; i < id.size(); i++) {
            String a = androidUpload.upload(file.get(i));
            SysFileInfo info = new SysFileInfo();
            info.setFilePath(a);
            info.setId(id.get(i));
            info.setFileName(name.get(i));
            int ceshi = sysFileInfoMapper.insertSysFileInfo(info);
            if (ceshi < 1) {
                return AjaxResult.error();
            }
            String as = "http://192.168.31.82/dev-api" + a;
            pic.add(as);
        }

        return AjaxResult.success(pic);
    }


    /**
     * 修改车商信息
     */
    @PreAuthorize("@ss.hasPermi('organization:car:edit')")
    @Log(title = "车商信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrCar zyjrCar) {
        return toAjax(zyjrCarService.updateZyjrCar(zyjrCar));
    }

    /**
     * 删除车商信息
     */
    @PreAuthorize("@ss.hasPermi('organization:car:remove')")
    @Log(title = "车商信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        zyjrCarAccountService.deleteZyjrCarAccountByIds(ids);
        return toAjax(zyjrCarService.deleteZyjrCarByIds(ids));
    }
}
