package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrBankProduct;

/**
 * productMapper接口
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public interface ZyjrBankProductMapper 
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
    public int insertZyjrBankProducts(List<ZyjrBankProduct> ZyjrBankProduct);

    /**
     * 修改product
     * 
     * @param zyjrBankProduct product
     * @return 结果
     */
    public int updateZyjrBankProduct(ZyjrBankProduct zyjrBankProduct);

    /**
     * 删除product
     * 
     * @param id productID
     * @return 结果
     */
    public int deleteZyjrBankProductById(Long id);

    /**
     * 批量删除product
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrBankProductByIds(Long[] ids);
}
