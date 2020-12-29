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
import com.jeethink.system.domain.ZyjrBankProduct;
import com.jeethink.system.service.IZyjrBankProductService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * productController
 * 
 * @author jeethink
 * @date 2020-12-26
 */
@RestController
@RequestMapping("/system/product")
public class ZyjrBankProductController extends BaseController
{
    @Autowired
    private IZyjrBankProductService zyjrBankProductService;

    /**
     * 查询product列表
     */
    @PreAuthorize("@ss.hasPermi('system:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrBankProduct zyjrBankProduct)
    {
        startPage();
        List<ZyjrBankProduct> list = zyjrBankProductService.selectZyjrBankProductList(zyjrBankProduct);
        return getDataTable(list);
    }

    /**
     * 导出product列表
     */
    @PreAuthorize("@ss.hasPermi('system:product:export')")
    @Log(title = "product", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrBankProduct zyjrBankProduct)
    {
        List<ZyjrBankProduct> list = zyjrBankProductService.selectZyjrBankProductList(zyjrBankProduct);
        ExcelUtil<ZyjrBankProduct> util = new ExcelUtil<ZyjrBankProduct>(ZyjrBankProduct.class);
        return util.exportExcel(list, "product");
    }

    /**
     * 获取product详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:product:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrBankProductService.selectZyjrBankProductById(id));
    }

    /**
     * 新增product
     */
    @PreAuthorize("@ss.hasPermi('system:product:add')")
    @Log(title = "product", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrBankProduct zyjrBankProduct)
    {
        return toAjax(zyjrBankProductService.insertZyjrBankProduct(zyjrBankProduct));
    }

    /**
     * 修改product
     */
    @PreAuthorize("@ss.hasPermi('system:product:edit')")
    @Log(title = "product", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrBankProduct zyjrBankProduct)
    {
        return toAjax(zyjrBankProductService.updateZyjrBankProduct(zyjrBankProduct));
    }

    /**
     * 删除product
     */
    @PreAuthorize("@ss.hasPermi('system:product:remove')")
    @Log(title = "product", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrBankProductService.deleteZyjrBankProductByIds(ids));
    }
}
