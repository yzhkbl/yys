package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrYeji;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2021-01-23
 */
public interface IZyjrYejiService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrYeji selectZyjrYejiById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrYeji 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrYeji> selectZyjrYejiList(ZyjrYeji zyjrYeji);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrYeji 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrYeji(ZyjrYeji zyjrYeji);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrYeji 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrYeji(ZyjrYeji zyjrYeji);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrYejiByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrYejiById(Long id);
}
