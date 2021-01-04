package com.jeethink.system.controller;

import java.io.IOException;
import java.util.List;

import com.jeethink.common.utils.file.FileUploadUtils;
import com.jeethink.system.domain.SysFileInfo;
import com.jeethink.system.mapper.SysFileInfoMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jeethink.common.annotation.Log;
import com.jeethink.common.core.controller.BaseController;
import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.enums.BusinessType;
import com.jeethink.system.domain.ZyjrInsuranceType;
import com.jeethink.system.service.IZyjrInsuranceTypeService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * insuranceTypeController
 * 
 * @author jeethink
 * @date 2020-12-29
 */
@RestController
@RequestMapping("/system/insuranceType")
public class ZyjrInsuranceTypeController extends BaseController
{
    @Autowired
    private IZyjrInsuranceTypeService zyjrInsuranceTypeService;
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;

    /**
     * 查询insuranceType列表
     */
    @PreAuthorize("@ss.hasPermi('system:insuranceType:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrInsuranceType zyjrInsuranceType)
    {
        startPage();
        List<ZyjrInsuranceType> list = zyjrInsuranceTypeService.selectZyjrInsuranceTypeList(zyjrInsuranceType);
        return getDataTable(list);
    }

    /**
     * 导出insuranceType列表
     */
    @PreAuthorize("@ss.hasPermi('system:insuranceType:export')")
    @Log(title = "insuranceType", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrInsuranceType zyjrInsuranceType)
    {
        List<ZyjrInsuranceType> list = zyjrInsuranceTypeService.selectZyjrInsuranceTypeList(zyjrInsuranceType);
        ExcelUtil<ZyjrInsuranceType> util = new ExcelUtil<ZyjrInsuranceType>(ZyjrInsuranceType.class);
        return util.exportExcel(list, "insuranceType");
    }

    /**
     * 获取insuranceType详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrInsuranceTypeService.selectZyjrInsuranceTypeById(id));
    }

    /**
     * 新增insuranceType
     */
    @Log(title = "insuranceType", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrInsuranceType zyjrInsuranceType)
    {
        Long a=zyjrInsuranceTypeService.insertZyjrInsuranceType(zyjrInsuranceType);
        return AjaxResult.success(a);
    }

    @RequestMapping(value = {"/ceshi2"}, method = RequestMethod.POST)
    @ApiOperation("111111111")
    public AjaxResult ceshi(@RequestParam("name") List<String> name, @RequestParam("file") List<MultipartFile> file, @RequestParam("id") List<String> id) throws IOException {
        for (int i = 0; i < id.size(); i++) {
            String a = FileUploadUtils.upload(file.get(i));
            SysFileInfo info = new SysFileInfo();
            String as = "http://192.168.31.82/dev-api" + a;
            info.setFilePath(as);
            info.setBaoxian(id.get(i));
            info.setFileName(name.get(i));
            sysFileInfoMapper.insertSysFileInfo(info);
        }

        return AjaxResult.success();
    }

    /**
     * 修改insuranceType
     */

    @Log(title = "insuranceType", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrInsuranceType zyjrInsuranceType)
    {
        return toAjax(zyjrInsuranceTypeService.updateZyjrInsuranceType(zyjrInsuranceType));
    }

    /**
     * 删除insuranceType
     */
    @PreAuthorize("@ss.hasPermi('system:insuranceType:remove')")
    @Log(title = "insuranceType", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrInsuranceTypeService.deleteZyjrInsuranceTypeByIds(ids));
    }
}
