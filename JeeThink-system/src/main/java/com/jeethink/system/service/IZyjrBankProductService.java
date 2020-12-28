package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrBankProduct;

/**
 * productService接口
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public interface IZyjrBankProductService 
{
    /**
     * 查询product
     * 
     * @param id productID
     * @return product
     */
    public ZyjrBankProduct selectZyjrBankProductById(Long id);

    /**
     * 查询product列表
     * 
     * @param zyjrBankProduct product
     * @return product集合
     */
    public List<ZyjrBankProduct> selectZyjrBankProductList(ZyjrBankProduct zyjrBankProduct);

    /**
     * 新增product
     * 
     * @param zyjrBankProduct product
     * @return 结果
     */
    public int insertZyjrBankProduct(ZyjrBankProduct zyjrBankProduct);

    /**
     * 修改product
     * 
     * @param zyjrBankProduct product
     * @return 结果
     */
    public int updateZyjrBankProduct(ZyjrBankProduct zyjrBankProduct);

    /**
     * 批量删除product
     * 
     * @param ids 需要删除的productID
     * @return 结果
     */
    public int deleteZyjrBankProductByIds(Long[] ids);

    /**
     * 删除product信息
     * 
     * @param id productID
     * @return 结果
     */
    public int deleteZyjrBankProductById(Long id);
}
