package com.jeethink.system.controller;

import java.util.ArrayList;
import java.util.List;

import com.jeethink.common.utils.file.FileUtils;
import com.jeethink.system.domain.SysFileInfo;
import com.jeethink.system.domain.ZyjrPhotoCar;
import com.jeethink.system.domain.vo.fileInfoVo;
import com.jeethink.system.mapper.SysFileInfoMapper;
import com.jeethink.system.util.androidUpload;
import io.swagger.annotations.ApiOperation;
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
import com.jeethink.system.domain.ZyjrPhotoLender;
import com.jeethink.system.service.IZyjrPhotoLenderService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@RestController
@RequestMapping("/system/photo/lender")
public class ZyjrPhotoLenderController extends BaseController
{
    @Autowired
    private IZyjrPhotoLenderService zyjrPhotoLenderService;
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;

    @PostMapping("/pic")
    @ApiOperation("111111111")
    public AjaxResult testFiles(@RequestBody fileInfoVo q) {

        if (q.getId() != null) {
            SysFileInfo infos = new SysFileInfo();
            infos.setPhotoLenderId(q.getId());
            List<SysFileInfo> sysFileInfos = sysFileInfoMapper.selectSysFileInfoList(infos);
            int a = sysFileInfoMapper.deleteByLender(q.getId());
            String paths = "E:/demo/JeeThink-admin/src/main/java/com/jeethink/web/";
            //System.err.println(path);
            //int a = sysFileInfoMapper.deleteSysFileInfoByPath(path);
            for (SysFileInfo sysFileInfo : sysFileInfos) {
                String[] s = sysFileInfo.getFilePath().split("//");
                System.err.println(paths + "profile/web/" + s[1]);
                boolean b = FileUtils.deleteFile(paths + "profile/web/" + s[1]);
            }
        } else {
            ZyjrPhotoLender zyjrPhotoLender = new ZyjrPhotoLender();
            zyjrPhotoLender.setOrderState(q.getOrderState());
            zyjrPhotoLender.setTransactionCode(q.getTransactionCode());
            zyjrPhotoLender.setUserId(q.getUserId());
            zyjrPhotoLenderService.insertZyjrPhotoLender(zyjrPhotoLender);
            List<String> pic = new ArrayList<>();
            if (q.getPhotoFile() != null) {
                for (int i = 0; i < q.getPhotoFile().size(); i++) {
                    String asd = androidUpload.upload(q.getPhotoFile().get(i).getFilePath());
                    SysFileInfo info = new SysFileInfo();
                    String as = "http://192.168.31.86:8080" + asd;
                    info.setFilePath(as);
                    info.setPhotoLenderId(zyjrPhotoLender.getId());
                    info.setFileName(q.getPhotoFile().get(i).getFileName());
                    int ceshi = sysFileInfoMapper.insertSysFileInfo(info);
                    if (ceshi < 1) {
                        return AjaxResult.error();
                    }
                    pic.add(as);
                }
            }

            return AjaxResult.success(pic);
        }
        return AjaxResult.error();
    }



    /**图片信息回显*/
    //@PreAuthorize("@ss.hasPermi('system:car:query')")
    @GetMapping(value = "/{userId}/{transactionCode}")
    public AjaxResult findPhoto(@PathVariable("userId") Long userId,@PathVariable("transactionCode") String transactionCode)
    {
        ZyjrPhotoLender zyjrPhotoLender = zyjrPhotoLenderService.selectZyjrPhotoLenderById(userId, transactionCode);
        if(zyjrPhotoLender != null) {
            List<SysFileInfo> list = sysFileInfoMapper.photoLender(zyjrPhotoLender.getId());
            fileInfoVo f = new fileInfoVo();
            f.setId(zyjrPhotoLender.getId());
            f.setUserId(zyjrPhotoLender.getUserId());
            f.setTransactionCode(zyjrPhotoLender.getTransactionCode());
            f.setOrderState(zyjrPhotoLender.getOrderState());
            f.setPhotoFile(list);
            return AjaxResult.success(f);
        }else {
            return AjaxResult.error();
        }
    }




    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:lender:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrPhotoLender zyjrPhotoLender)
    {
        startPage();
        List<ZyjrPhotoLender> list = zyjrPhotoLenderService.selectZyjrPhotoLenderList(zyjrPhotoLender);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:lender:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrPhotoLender zyjrPhotoLender)
    {
        List<ZyjrPhotoLender> list = zyjrPhotoLenderService.selectZyjrPhotoLenderList(zyjrPhotoLender);
        ExcelUtil<ZyjrPhotoLender> util = new ExcelUtil<ZyjrPhotoLender>(ZyjrPhotoLender.class);
        return util.exportExcel(list, "lender");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
   /** @PreAuthorize("@ss.hasPermi('system:lender:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrPhotoLenderService.selectZyjrPhotoLenderById(id));
    }*/

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:lender:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrPhotoLender zyjrPhotoLender)
    {
        return toAjax(zyjrPhotoLenderService.insertZyjrPhotoLender(zyjrPhotoLender));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:lender:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrPhotoLender zyjrPhotoLender)
    {
        return toAjax(zyjrPhotoLenderService.updateZyjrPhotoLender(zyjrPhotoLender));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:lender:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrPhotoLenderService.deleteZyjrPhotoLenderByIds(ids));
    }
}