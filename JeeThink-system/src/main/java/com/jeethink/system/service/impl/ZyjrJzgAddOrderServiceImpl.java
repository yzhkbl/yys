package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrJzgAddOrderMapper;
import com.jeethink.system.domain.ZyjrJzgAddOrder;
import com.jeethink.system.service.IZyjrJzgAddOrderService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-31
 */
@Service
public class ZyjrJzgAddOrderServiceImpl implements IZyjrJzgAddOrderService 
{
    @Autowired
    private ZyjrJzgAddOrderMapper zyjrJzgAddOrderMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrJzgAddOrder selectZyjrJzgAddOrderById(Long id)
    {
        return zyjrJzgAddOrderMapper.selectZyjrJzgAddOrderById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrJzgAddOrder 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrJzgAddOrder> selectZyjrJzgAddOrderList(ZyjrJzgAddOrder zyjrJzgAddOrder)
    {
        return zyjrJzgAddOrderMapper.selectZyjrJzgAddOrderList(zyjrJzgAddOrder);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrJzgAddOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrJzgAddOrder(ZyjrJzgAddOrder zyjrJzgAddOrder)
    {
        return zyjrJzgAddOrderMapper.insertZyjrJzgAddOrder(zyjrJzgAddOrder);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrJzgAddOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrJzgAddOrder(ZyjrJzgAddOrder zyjrJzgAddOrder)
    {
        return zyjrJzgAddOrderMapper.updateZyjrJzgAddOrder(zyjrJzgAddOrder);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrJzgAddOrderByIds(Long[] ids)
    {
        return zyjrJzgAddOrderMapper.deleteZyjrJzgAddOrderByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrJzgAddOrderById(Long id)
    {
        return zyjrJzgAddOrderMapper.deleteZyjrJzgAddOrderById(id);
    }
}
