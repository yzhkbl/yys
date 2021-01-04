package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrJzgAddOrder;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-31
 */
public interface IZyjrJzgAddOrderService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrJzgAddOrder selectZyjrJzgAddOrderById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrJzgAddOrder 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrJzgAddOrder> selectZyjrJzgAddOrderList(ZyjrJzgAddOrder zyjrJzgAddOrder);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrJzgAddOrder 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrJzgAddOrder(ZyjrJzgAddOrder zyjrJzgAddOrder);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrJzgAddOrder 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrJzgAddOrder(ZyjrJzgAddOrder zyjrJzgAddOrder);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrJzgAddOrderByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrJzgAddOrderById(Long id);
}
