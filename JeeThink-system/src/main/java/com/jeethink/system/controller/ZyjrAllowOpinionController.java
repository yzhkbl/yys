package com.jeethink.system.controller;

import java.util.List;
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
import com.jeethink.system.domain.ZyjrAllowOpinion;
import com.jeethink.system.service.IZyjrAllowOpinionService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 *
 * @author jeethink
 * @date 2021-01-04
 */
@RestController
@RequestMapping("/system/opinion")
public class ZyjrAllowOpinionController extends BaseController
{
    @Autowired
    private IZyjrAllowOpinionService zyjrAllowOpinionService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:opinion:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrAllowOpinion zyjrAllowOpinion)
    {
        startPage();
        List<ZyjrAllowOpinion> list = zyjrAllowOpinionService.selectZyjrAllowOpinionList(zyjrAllowOpinion);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:opinion:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrAllowOpinion zyjrAllowOpinion)
    {
        List<ZyjrAllowOpinion> list = zyjrAllowOpinionService.selectZyjrAllowOpinionList(zyjrAllowOpinion);
        ExcelUtil<ZyjrAllowOpinion> util = new ExcelUtil<ZyjrAllowOpinion>(ZyjrAllowOpinion.class);
        return util.exportExcel(list, "opinion");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */



    @GetMapping(value = "/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("transactionCode") String transactionCode)
    {

        return AjaxResult.success(zyjrAllowOpinionService.selectZyjrAllowOpinionById(transactionCode));
    }
    /**
     * 新增【请填写功能名称】
     */
    //@PreAuthorize("@ss.hasPermi('system:opinion:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrAllowOpinion zyjrAllowOpinion)
    {
        return toAjax(zyjrAllowOpinionService.insertZyjrAllowOpinion(zyjrAllowOpinion));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:opinion:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrAllowOpinion zyjrAllowOpinion)
    {
        return toAjax(zyjrAllowOpinionService.updateZyjrAllowOpinion(zyjrAllowOpinion));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:opinion:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrAllowOpinionService.deleteZyjrAllowOpinionByIds(ids));
    }
}
