package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrDaihouZhengshu;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2021-01-06
 */
public interface IZyjrDaihouZhengshuService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrDaihouZhengshu selectZyjrDaihouZhengshuById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaihouZhengshu 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrDaihouZhengshu> selectZyjrDaihouZhengshuList(ZyjrDaihouZhengshu zyjrDaihouZhengshu);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaihouZhengshu 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrDaihouZhengshu(ZyjrDaihouZhengshu zyjrDaihouZhengshu);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaihouZhengshu 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrDaihouZhengshu(ZyjrDaihouZhengshu zyjrDaihouZhengshu);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaihouZhengshuByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaihouZhengshuById(Long id);
}
