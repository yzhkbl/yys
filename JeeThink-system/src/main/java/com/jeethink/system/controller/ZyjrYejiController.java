package com.jeethink.system.controller;

import java.util.List;
import java.util.Set;

import com.jeethink.common.core.domain.entity.SysDept;
import com.jeethink.system.mapper.SysDeptMapper;
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
import com.jeethink.system.domain.ZyjrYeji;
import com.jeethink.system.service.IZyjrYejiService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-23
 */
@RestController
@RequestMapping("/system/yeji")
public class ZyjrYejiController extends BaseController
{
    @Autowired
    private IZyjrYejiService zyjrYejiService;
    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询【请填写功能名称】列表
     */
  //  @PreAuthorize("@ss.hasPermi('system:yeji:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrYeji zyjrYeji)
    {
        startPage();
       // List<ZyjrYeji> list = zyjrYejiService.selectZyjrYejiList(zyjrYeji);
        List<SysDept> a=sysDeptMapper.selectChildrenDeptById((long)204);
        return getDataTable(a);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:yeji:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrYeji zyjrYeji)
    {
        List<ZyjrYeji> list = zyjrYejiService.selectZyjrYejiList(zyjrYeji);
        ExcelUtil<ZyjrYeji> util = new ExcelUtil<ZyjrYeji>(ZyjrYeji.class);
        return util.exportExcel(list, "yeji");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:yeji:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrYejiService.selectZyjrYejiById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:yeji:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrYeji zyjrYeji)
    {
        return toAjax(zyjrYejiService.insertZyjrYeji(zyjrYeji));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:yeji:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrYeji zyjrYeji)
    {
        return toAjax(zyjrYejiService.updateZyjrYeji(zyjrYeji));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:yeji:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrYejiService.deleteZyjrYejiByIds(ids));
    }

    public static void main(String[] args) {
       int a=1;
        a=2;
        a=223;
        System.err.println(a);
    }
}
