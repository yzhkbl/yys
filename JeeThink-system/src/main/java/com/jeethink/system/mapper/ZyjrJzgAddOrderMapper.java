package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrJzgAddOrder;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2020-12-31
 */
public interface ZyjrJzgAddOrderMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrJzgAddOrder selectZyjrJzgAddOrderById(Long id);

    public ZyjrJzgAddOrder selectZyjrJzgAddOrderByTransactionCode(String transactionCode);

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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrJzgAddOrderById(String id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrJzgAddOrderByIds(Long[] ids);
}
