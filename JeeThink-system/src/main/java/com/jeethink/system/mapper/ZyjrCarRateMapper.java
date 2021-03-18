package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrCarRate;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-03-16
 */
public interface ZyjrCarRateMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrCarRate selectZyjrCarRateById(Integer id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCarRate 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrCarRate> selectZyjrCarRateList(ZyjrCarRate zyjrCarRate);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCarRate 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrCarRate(ZyjrCarRate zyjrCarRate);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCarRate 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrCarRate(ZyjrCarRate zyjrCarRate);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCarRateById(Integer id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrCarRateByIds(Integer[] ids);
}
