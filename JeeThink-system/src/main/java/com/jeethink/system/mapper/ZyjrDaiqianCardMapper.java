package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrDaiqianCard;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-03-10
 */
public interface ZyjrDaiqianCardMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrDaiqianCard selectZyjrDaiqianCardById(Long id);
    ZyjrDaiqianCard selectZyjrDaiqianCardByT(String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaiqianCard 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrDaiqianCard> selectZyjrDaiqianCardList(ZyjrDaiqianCard zyjrDaiqianCard);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaiqianCard 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrDaiqianCard(ZyjrDaiqianCard zyjrDaiqianCard);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaiqianCard 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrDaiqianCard(ZyjrDaiqianCard zyjrDaiqianCard);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaiqianCardById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrDaiqianCardByIds(Long[] ids);


}
