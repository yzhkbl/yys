package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrBankProductMapper;
import com.jeethink.system.domain.ZyjrBankProduct;
import com.jeethink.system.service.IZyjrBankProductService;

/**
 * productService业务层处理
 * 
 * @author jeethink
 * @date 2020-12-26
 */
@Service
public class ZyjrBankProductServiceImpl implements IZyjrBankProductService 
{
    @Autowired
    private ZyjrBankProductMapper zyjrBankProductMapper;

    /**
     * 查询product
     * 
     * @param id productID
     * @return product
     */
    @Override
    public ZyjrBankProduct selectZyjrBankProductById(Long id)
    {
        return zyjrBankProductMapper.selectZyjrBankProductById(id);
    }

    /**
     * 查询product列表
     * 
     * @param zyjrBankProduct product
     * @return product
     */
    @Override
    public List<ZyjrBankProduct> selectZyjrBankProductList(ZyjrBankProduct zyjrBankProduct)
    {
        return zyjrBankProductMapper.selectZyjrBankProductList(zyjrBankProduct);
    }

    /**
     * 新增product
     * 
     * @param zyjrBankProduct product
     * @return 结果
     */
    @Override
    public int insertZyjrBankProduct(ZyjrBankProduct zyjrBankProduct)
    {

        return zyjrBankProductMapper.insertZyjrBankProduct(zyjrBankProduct);
    }

    /**
     * 修改product
     * 
     * @param zyjrBankProduct product
     * @return 结果
     */
    @Override
    public int updateZyjrBankProduct(ZyjrBankProduct zyjrBankProduct)
    {

        return zyjrBankProductMapper.updateZyjrBankProduct(zyjrBankProduct);
    }

    /**
     * 批量删除product
     * 
     * @param ids 需要删除的productID
     * @return 结果
     */
    @Override
    public int deleteZyjrBankProductByIds(Long[] ids)
    {
        return zyjrBankProductMapper.deleteZyjrBankProductByIds(ids);
    }

    /**
     * 删除product信息
     * 
     * @param id productID
     * @return 结果
     */
    @Override
    public int deleteZyjrBankProductById(Long id)
    {
        return zyjrBankProductMapper.deleteZyjrBankProductById(id);
    }
}
