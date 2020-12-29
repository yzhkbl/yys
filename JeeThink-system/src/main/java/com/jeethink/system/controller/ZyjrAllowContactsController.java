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
import com.jeethink.system.domain.ZyjrAllowContacts;
import com.jeethink.system.service.IZyjrAllowContactsService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@RestController
@RequestMapping("/system/contacts")
public class ZyjrAllowContactsController extends BaseController
{
    @Autowired
    private IZyjrAllowContactsService zyjrAllowContactsService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrAllowContacts zyjrAllowContacts)
    {
        startPage();
        List<ZyjrAllowContacts> list = zyjrAllowContactsService.selectZyjrAllowContactsList(zyjrAllowContacts);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrAllowContacts zyjrAllowContacts)
    {
        List<ZyjrAllowContacts> list = zyjrAllowContactsService.selectZyjrAllowContactsList(zyjrAllowContacts);
        ExcelUtil<ZyjrAllowContacts> util = new ExcelUtil<ZyjrAllowContacts>(ZyjrAllowContacts.class);
        return util.exportExcel(list, "contacts");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:query')")
    @GetMapping(value = "/{userId}/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId,@PathVariable("transactionCode")String transactionCode)
    {
        return AjaxResult.success(zyjrAllowContactsService.selectZyjrAllowContactsById(userId, transactionCode));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrAllowContacts zyjrAllowContacts)
    {
        return toAjax(zyjrAllowContactsService.insertZyjrAllowContacts(zyjrAllowContacts));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrAllowContacts zyjrAllowContacts)
    {
        return toAjax(zyjrAllowContactsService.updateZyjrAllowContacts(zyjrAllowContacts));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:contacts:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrAllowContactsService.deleteZyjrAllowContactsByIds(ids));
    }
}
