package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrDaihouZhengshu;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-06
 */
public interface ZyjrDaihouZhengshuMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaihouZhengshuById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrDaihouZhengshuByIds(Long[] ids);
}
