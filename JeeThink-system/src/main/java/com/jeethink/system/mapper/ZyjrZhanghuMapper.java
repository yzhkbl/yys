package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrZhanghu;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-03-19
 */
public interface ZyjrZhanghuMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrZhanghu selectZyjrZhanghuById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrZhanghu 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrZhanghu> selectZyjrZhanghuList(ZyjrZhanghu zyjrZhanghu);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrZhanghu 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrZhanghu(ZyjrZhanghu zyjrZhanghu);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrZhanghu 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrZhanghu(ZyjrZhanghu zyjrZhanghu);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrZhanghuById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrZhanghuByIds(Long[] ids);
}
