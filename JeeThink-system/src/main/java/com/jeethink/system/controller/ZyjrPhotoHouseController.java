package com.jeethink.system.controller;

import java.util.ArrayList;
import java.util.List;

import com.jeethink.common.utils.file.FileUtils;
import com.jeethink.system.Helper.BizException;
import com.jeethink.system.domain.SysFileInfo;
import com.jeethink.system.domain.ZyjrPhotoCredit;
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
import com.jeethink.system.domain.ZyjrPhotoHouse;
import com.jeethink.system.service.IZyjrPhotoHouseService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@RestController
@RequestMapping("/system/photo/house")
public class ZyjrPhotoHouseController extends BaseController
{
    @Autowired
    private IZyjrPhotoHouseService zyjrPhotoHouseService;
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;

    @PostMapping("/pic")
    @ApiOperation("111111111")
    public AjaxResult testFiles(fileInfoVo q) {
        JSONArray jsonarray = JSONArray.fromObject(q.getHousePhoto());
      //  System.out.println(jsonarray);
        ZyjrPhotoHouse zyjrPhotoHouse = new ZyjrPhotoHouse();
        List<SysFileInfo> list = (List)JSONArray.toList(jsonarray, SysFileInfo.class);
        if (q.getHouseId() != null) {
            SysFileInfo infos = new SysFileInfo();
            infos.setPhotoHouseId(q.getHouseId());
            List<SysFileInfo> sysFileInfos = sysFileInfoMapper.selectSysFileInfoList(infos);
            int a = sysFileInfoMapper.deleteByHouse(q.getHouseId());
            String paths = "C:/demo";
            //System.err.println(path);
            //int a = sysFileInfoMapper.deleteSysFileInfoByPath(path);
            for (SysFileInfo sysFileInfo :sysFileInfos) {
                String[] s = sysFileInfo.getFilePath().split("//");
                String l = sysFileInfo.getFilePath().substring(sysFileInfo.getFilePath().indexOf("e"));
               // System.err.println("删除路径"+paths+l);
                boolean b = FileUtils.deleteFile(paths +l);
            }
            zyjrPhotoHouse.setOrderState(q.getOrderState());
            zyjrPhotoHouse.setTransactionCode(q.getTransactionCode());
            zyjrPhotoHouse.setUserId(q.getUserId());
            zyjrPhotoHouseService.updateZyjrPhotoHouse(zyjrPhotoHouse);
        } else {

            zyjrPhotoHouse.setOrderState(q.getOrderState());
            zyjrPhotoHouse.setTransactionCode(q.getTransactionCode());
            zyjrPhotoHouse.setUserId(q.getUserId());
            zyjrPhotoHouseService.insertZyjrPhotoHouse(zyjrPhotoHouse);

        }
        List<String> pic = new ArrayList<>();
        if (q.getHousePhoto() != null) {
            for (int i = 0; i < list.size(); i++) {
                //String asd = androidUpload.upload(list.get(i).getFilePath());
                SysFileInfo info = new SysFileInfo();
                //String as = "http://192.168.31.86:8080" + asd;
                info.setFilePath(list.get(i).getFilePath());
                if(q.getHouseId()!=null){
                    info.setPhotoHouseId(q.getHouseId());
                }else{
                    info.setPhotoHouseId(zyjrPhotoHouse.getId());
                }
                info.setFileName(list.get(i).getFileName());
                int ceshi = sysFileInfoMapper.insertSysFileInfo(info);
                if (ceshi < 1) {
                    return AjaxResult.error();
                }
                pic.add(info.getFilePath());
            }
        }
        return AjaxResult.success(pic);
    }


    /**图片信息回显*/
    //@PreAuthorize("@ss.hasPermi('system:car:query')")
    @GetMapping(value = "/{userId}/{transactionCode}")
    public fileInfoDto findPhoto(@PathVariable("userId") Long userId,@PathVariable("transactionCode") String transactionCode)
    {
        ZyjrPhotoHouse zyjrPhotoHouse = zyjrPhotoHouseService.selectZyjrPhotoHouseById(userId, transactionCode);
        fileInfoDto f = new fileInfoDto();
        if(zyjrPhotoHouse != null) {
            List<SysFileInfo> list = sysFileInfoMapper.photoHouse(zyjrPhotoHouse.getId());

            f.setId(zyjrPhotoHouse.getId());
            f.setUserId(zyjrPhotoHouse.getUserId());
            f.setTransactionCode(zyjrPhotoHouse.getTransactionCode());
            f.setOrderState(zyjrPhotoHouse.getOrderState());
            f.setPhotoFile(list);
            return f;
        }else {
            return f;
        }
    }


    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:house:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrPhotoHouse zyjrPhotoHouse)
    {
        startPage();
        List<ZyjrPhotoHouse> list = zyjrPhotoHouseService.selectZyjrPhotoHouseList(zyjrPhotoHouse);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:house:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrPhotoHouse zyjrPhotoHouse)
    {
        List<ZyjrPhotoHouse> list = zyjrPhotoHouseService.selectZyjrPhotoHouseList(zyjrPhotoHouse);
        ExcelUtil<ZyjrPhotoHouse> util = new ExcelUtil<ZyjrPhotoHouse>(ZyjrPhotoHouse.class);
        return util.exportExcel(list, "house");
    }

    /**
     * 获取【请填写功能名称】详细信息

    @PreAuthorize("@ss.hasPermi('system:house:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrPhotoHouseService.selectZyjrPhotoHouseById(id));
    }*/

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:house:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrPhotoHouse zyjrPhotoHouse)
    {
        return toAjax(zyjrPhotoHouseService.insertZyjrPhotoHouse(zyjrPhotoHouse));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:house:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrPhotoHouse zyjrPhotoHouse)
    {
        return toAjax(zyjrPhotoHouseService.updateZyjrPhotoHouse(zyjrPhotoHouse));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:house:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrPhotoHouseService.deleteZyjrPhotoHouseByIds(ids));
    }
}
