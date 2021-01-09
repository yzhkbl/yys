package com.jeethink.system.controller;

import java.io.IOException;
import java.util.List;

import com.jeethink.common.utils.file.FileUploadUtils;
import com.jeethink.common.utils.ip.IpUtils;
import com.jeethink.system.domain.SysFileInfo;
import com.jeethink.system.mapper.SysFileInfoMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jeethink.common.annotation.Log;
import com.jeethink.common.core.controller.BaseController;
import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.enums.BusinessType;
import com.jeethink.system.domain.ZyjrBank;
import com.jeethink.system.service.IZyjrBankService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * bankController
 * 
 * @author jeethink
 * @date 2020-12-26
 */
@RestController
@RequestMapping("/system/bank")
@Api
public class ZyjrBankController extends BaseController
{
    @Autowired
    private IZyjrBankService zyjrBankService;
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;

    /**
     * 查询bank列表
     */
   // @PreAuthorize("@ss.hasPermi('organization:bank:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrBank zyjrBank)
    {
        startPage();
        List<ZyjrBank> list = zyjrBankService.selectZyjrBankList(zyjrBank);
        return getDataTable(list);
    }

    /**
     * 导出bank列表
     */
    @PreAuthorize("@ss.hasPermi('organization:bank:export')")
    @Log(title = "bank", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrBank zyjrBank)
    {
        List<ZyjrBank> list = zyjrBankService.selectZyjrBankList(zyjrBank);
        ExcelUtil<ZyjrBank> util = new ExcelUtil<ZyjrBank>(ZyjrBank.class);
        return util.exportExcel(list, "bank");
    }

    @ApiOperation("11")
    @GetMapping("de")
    public AjaxResult de(){
        int a=zyjrBankService.delete();
      return   AjaxResult.success(a);
    }

    /**
     * 获取bank详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrBankService.selectZyjrBankById(id));
    }

    /**
     * 新增bank
     */
    @ApiOperation("ccc")
    @Log(title = "bank", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrBank zyjrBank)
    {
        Long a=zyjrBankService.insertZyjrBank(zyjrBank);
        return AjaxResult.success(a);
    }

    @RequestMapping(value = {"/ceshi2"}, method = RequestMethod.POST)

    @ApiOperation("111111111")
    public AjaxResult ceshi(@RequestParam("name") List<String> name, @RequestParam("file") List<MultipartFile> file, @RequestParam("id") List<String> id) throws IOException {
        for (int i = 0; i < id.size(); i++) {
            String a = FileUploadUtils.upload(file.get(i));
            SysFileInfo info = new SysFileInfo();
            String as = "http://"+ IpUtils.getHostIp()+":8080" + a;
            info.setFilePath(as);
            info.setBankId(id.get(i));
            info.setFileName(name.get(i));
            sysFileInfoMapper.insertSysFileInfo(info);
        }

        return AjaxResult.success();
    }

    /**
     * 修改bank
     */

    @Log(title = "bank", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrBank zyjrBank)
    {
        return toAjax(zyjrBankService.updateZyjrBank(zyjrBank));
    }

    /**
     * 删除bank
     */
    @PreAuthorize("@ss.hasPermi('organization:bank:remove')")
    @Log(title = "bank", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrBankService.deleteZyjrBankByIds(ids));
    }
}
