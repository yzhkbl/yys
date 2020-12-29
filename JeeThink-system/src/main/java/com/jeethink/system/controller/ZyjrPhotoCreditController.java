package com.jeethink.system.controller;

import java.util.ArrayList;
import java.util.List;

import com.jeethink.common.utils.file.FileUtils;
import com.jeethink.system.domain.SysFileInfo;
import com.jeethink.system.domain.ZyjrPhotoLender;
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
import com.jeethink.system.domain.ZyjrPhotoCredit;
import com.jeethink.system.service.IZyjrPhotoCreditService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@RestController
@RequestMapping("/system/photo/credit")
public class ZyjrPhotoCreditController extends BaseController
{
    @Autowired
    private IZyjrPhotoCreditService zyjrPhotoCreditService;
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;

    @PostMapping("/pic")
    @ApiOperation("111111111")
    public AjaxResult testFiles(@RequestBody fileInfoVo q) {

        if (q.getId() != null) {
            SysFileInfo infos = new SysFileInfo();
            infos.setPhotoCreditId(q.getId());
            List<SysFileInfo> sysFileInfos = sysFileInfoMapper.selectSysFileInfoList(infos);
            int a = sysFileInfoMapper.deleteByCredit(q.getId());
            String paths = "E:/demo/JeeThink-admin/src/main/java/com/jeethink/web/";
            //System.err.println(path);
            //int a = sysFileInfoMapper.deleteSysFileInfoByPath(path);
            for (SysFileInfo sysFileInfo : sysFileInfos) {
                String[] s = sysFileInfo.getFilePath().split("//");
                System.err.println(paths + "profile/web/" + s[1]);
                boolean b = FileUtils.deleteFile(paths + "profile/web/" + s[1]);
            }
        } else {
            ZyjrPhotoCredit zyjrPhotoCredit = new ZyjrPhotoCredit();
            zyjrPhotoCredit.setOrderState(q.getOrderState());
            zyjrPhotoCredit.setTransactionCode(q.getTransactionCode());
            zyjrPhotoCredit.setUserId(q.getUserId());
            zyjrPhotoCreditService.insertZyjrPhotoCredit(zyjrPhotoCredit);
            List<String> pic = new ArrayList<>();
            if (q.getPhotoFile() != null) {
                for (int i = 0; i < q.getPhotoFile().size(); i++) {
                    String asd = androidUpload.upload(q.getPhotoFile().get(i).getFilePath());
                    SysFileInfo info = new SysFileInfo();
                    String as = "http://192.168.31.86:8080" + asd;
                    info.setFilePath(as);
                    info.setPhotoCreditId(zyjrPhotoCredit.getId());
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
        ZyjrPhotoCredit zyjrPhotoCredit = zyjrPhotoCreditService.selectZyjrPhotoCreditById(userId, transactionCode);
        if(zyjrPhotoCredit != null) {
            List<SysFileInfo> list = sysFileInfoMapper.photoCredit(zyjrPhotoCredit.getId());
            fileInfoVo f = new fileInfoVo();
            f.setId(zyjrPhotoCredit.getId());
            f.setUserId(zyjrPhotoCredit.getUserId());
            f.setTransactionCode(zyjrPhotoCredit.getTransactionCode());
            f.setOrderState(zyjrPhotoCredit.getOrderState());
            f.setPhotoFile(list);
            return AjaxResult.success(f);
        }else {
            return AjaxResult.error();
        }
    }



    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:credit:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrPhotoCredit zyjrPhotoCredit)
    {
        startPage();
        List<ZyjrPhotoCredit> list = zyjrPhotoCreditService.selectZyjrPhotoCreditList(zyjrPhotoCredit);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:credit:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrPhotoCredit zyjrPhotoCredit)
    {
        List<ZyjrPhotoCredit> list = zyjrPhotoCreditService.selectZyjrPhotoCreditList(zyjrPhotoCredit);
        ExcelUtil<ZyjrPhotoCredit> util = new ExcelUtil<ZyjrPhotoCredit>(ZyjrPhotoCredit.class);
        return util.exportExcel(list, "credit");
    }

    /**
     * 获取【请填写功能名称】详细信息

    @PreAuthorize("@ss.hasPermi('system:credit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrPhotoCreditService.selectZyjrPhotoCreditById(id));
    }*/

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:credit:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrPhotoCredit zyjrPhotoCredit)
    {
        return toAjax(zyjrPhotoCreditService.insertZyjrPhotoCredit(zyjrPhotoCredit));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:credit:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrPhotoCredit zyjrPhotoCredit)
    {
        return toAjax(zyjrPhotoCreditService.updateZyjrPhotoCredit(zyjrPhotoCredit));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:credit:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrPhotoCreditService.deleteZyjrPhotoCreditByIds(ids));
    }
}
