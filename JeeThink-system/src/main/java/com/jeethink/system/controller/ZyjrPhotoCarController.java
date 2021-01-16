package com.jeethink.system.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.jeethink.common.utils.file.FileUtils;
import com.jeethink.common.utils.ip.IpUtils;
import com.jeethink.system.domain.SysFileInfo;
import com.jeethink.system.domain.vo.fileInfoDto;
import com.jeethink.system.domain.vo.fileInfoVo;
import com.jeethink.system.mapper.SysFileInfoMapper;
import com.jeethink.system.util.androidUpload;
import io.swagger.annotations.ApiOperation;
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
import com.jeethink.system.domain.ZyjrPhotoCar;
import com.jeethink.system.service.IZyjrPhotoCarService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@RestController
@RequestMapping("/system/photo/car")
public class ZyjrPhotoCarController extends BaseController
{
    @Autowired
    private IZyjrPhotoCarService zyjrPhotoCarService;
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;

    @PostMapping("/pic")
    @ApiOperation("111111111")
    public AjaxResult testFiles(fileInfoVo q){
        JSONArray jsonarray = JSONArray.fromObject(q.getPhotoFile());
        System.err.println(q);
        System.out.println(jsonarray);
        List<SysFileInfo> list = (List)JSONArray.toList(jsonarray, SysFileInfo.class);
        ZyjrPhotoCar zyjrPhotoCar = new ZyjrPhotoCar();
        if(q.getId()!=null){
                SysFileInfo infos=new SysFileInfo();
                infos.setPhotoCarId(q.getId());
                List<SysFileInfo> sysFileInfos = sysFileInfoMapper.selectSysFileInfoList(infos);
                int a = sysFileInfoMapper.deleteSysFileInfoByPhotoCarId(q.getId());
                String paths = "C:/demo";
                //System.err.println(path);
                //int a = sysFileInfoMapper.deleteSysFileInfoByPath(path);
                for (SysFileInfo sysFileInfo :sysFileInfos) {
                    String[] s = sysFileInfo.getFilePath().split("//");
                    String l = sysFileInfo.getFilePath().substring(sysFileInfo.getFilePath().indexOf("e"));
                    System.err.println("删除路径"+paths+l);
                    boolean b = FileUtils.deleteFile(paths +l);
                }
            }else{

                zyjrPhotoCar.setOrderState(q.getOrderState());
                zyjrPhotoCar.setTransactionCode(q.getTransactionCode());
                zyjrPhotoCar.setUserId(q.getUserId());
                zyjrPhotoCarService.insertZyjrPhotoCar(zyjrPhotoCar);
               /* List<String> pic = new ArrayList<>();
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        String asd = androidUpload.upload(list.get(i).getFilePath());
                        SysFileInfo info = new SysFileInfo();
                        String as = "http://192.168.31.86:8080" + asd;
                        info.setFilePath(as);
                        info.setPhotoCarId(zyjrPhotoCar.getId());
                        info.setFileName(list.get(i).getFileName());
                        int ceshi = sysFileInfoMapper.insertSysFileInfo(info);
                        if (ceshi < 1) {
                            return AjaxResult.error();
                        }
                        pic.add(as);
                    }
                }
                System.err.println(pic);
                return AjaxResult.success(pic);*/
            }
        List<String> pic = new ArrayList<>();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                //String asd = androidUpload.upload(list.get(i).getFilePath());
                SysFileInfo info = new SysFileInfo();
                //String as = "http://"+ IpUtils.getHostIp()+":8080" + asd;
                info.setFilePath(list.get(i).getFilePath());
                if(q.getId()!=null){
                    info.setPhotoCarId(q.getId());
                }else{
                    info.setPhotoCarId(zyjrPhotoCar.getId());
                }

                info.setFileName(list.get(i).getFileName());
                int ceshi = sysFileInfoMapper.insertSysFileInfo(info);
                if (ceshi < 1) {
                    return AjaxResult.error();
                }
                pic.add(info.getFilePath());
            }
        }
        System.err.println(pic);
        return AjaxResult.success(pic);

    }

        /**if(zyjrPhotoCarService.selectZyjrPhotoCarById(q.getUserId(),q.getTransactionCode())!=null){
            ZyjrPhotoCar zyjrPhotoCar = new ZyjrPhotoCar();
            zyjrPhotoCar.setOrderState(q.getOrderState());
            zyjrPhotoCar.setTransactionCode(q.getTransactionCode());
            zyjrPhotoCar.setUserId(q.getUserId());
            zyjrPhotoCarService.updateZyjrPhotoCar(zyjrPhotoCar);
            List<String> pic=new ArrayList<>();
            if(q.getPhotoFile()!=null) {

                SysFileInfo info = new SysFileInfo();
                for (int i = 0; i < q.getPhotoFile().size(); i++) {
                    String paths = "E:/demo/JeeThink-admin/src/main/java/com/jeethink/web/";
                    //System.err.println(path);
                    String asd = androidUpload.upload(q.getPhotoFile().get(i).getFilePath());
                    String as = "http://192.168.31.86:8080" + asd;
                    info.setFilePath(as);
                    info.setPhotoCarId(zyjrPhotoCarService.selectZyjrPhotoCarById(q.getUserId(),q.getTransactionCode()).getId());
                    info.setFileName(q.getPhotoFile().get(i).getFileName());
                    int ceshi = sysFileInfoMapper.updateSysFileInfo(info);
                    if (ceshi < 1) {
                        return AjaxResult.error();
                    }
                    pic.add(as);
                }


                int b = sysFileInfoMapper.insertSysFileInfo(info);
            }
            return AjaxResult.success(pic);


        }else {*/



    /**图片信息回显*/
    //@PreAuthorize("@ss.hasPermi('system:car:query')")
    @GetMapping(value = "/{userId}/{transactionCode}")
    public AjaxResult findPhoto(@PathVariable("userId") Long userId,@PathVariable("transactionCode") String transactionCode)
    {
        ZyjrPhotoCar zyjrPhotoCar = zyjrPhotoCarService.selectZyjrPhotoCarById(userId, transactionCode);
        if(zyjrPhotoCar != null) {
            List<SysFileInfo> list = sysFileInfoMapper.photoCar(zyjrPhotoCar.getId());
            fileInfoDto f = new fileInfoDto();
            f.setId(zyjrPhotoCar.getId());
            f.setUserId(zyjrPhotoCar.getUserId());
            f.setTransactionCode(zyjrPhotoCar.getTransactionCode());
            f.setOrderState(zyjrPhotoCar.getOrderState());
            f.setPhotoFile(list);
            return AjaxResult.success(f);
        }else {
            return AjaxResult.error();
        }
    }


    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:car:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrPhotoCar zyjrPhotoCar)
    {
        startPage();
        List<ZyjrPhotoCar> list = zyjrPhotoCarService.selectZyjrPhotoCarList(zyjrPhotoCar);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:car:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrPhotoCar zyjrPhotoCar)
    {
        List<ZyjrPhotoCar> list = zyjrPhotoCarService.selectZyjrPhotoCarList(zyjrPhotoCar);
        ExcelUtil<ZyjrPhotoCar> util = new ExcelUtil<ZyjrPhotoCar>(ZyjrPhotoCar.class);
        return util.exportExcel(list, "car");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    /**@PreAuthorize("@ss.hasPermi('system:car:query')")
    @GetMapping(value = "/{userId}/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId,@PathVariable("transactionCode") String transactionCode)
    {
        return AjaxResult.success(zyjrPhotoCarService.selectZyjrPhotoCarById(userId,transactionCode));
    }*/

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:car:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrPhotoCar zyjrPhotoCar)
    {
        return toAjax(zyjrPhotoCarService.insertZyjrPhotoCar(zyjrPhotoCar));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:car:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrPhotoCar zyjrPhotoCar)
    {


        return toAjax(zyjrPhotoCarService.updateZyjrPhotoCar(zyjrPhotoCar));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:car:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrPhotoCarService.deleteZyjrPhotoCarByIds(ids));
    }
}
