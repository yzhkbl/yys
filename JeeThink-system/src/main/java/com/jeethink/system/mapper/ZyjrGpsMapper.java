package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrGps;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2020-12-23
 */
public interface ZyjrGpsMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrGps selectZyjrGpsById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrGps 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrGps> selectZyjrGpsList(ZyjrGps zyjrGps);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrGps 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrGps(ZyjrGps zyjrGps);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrGps 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrGps(ZyjrGps zyjrGps);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrGpsById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrGpsByIds(Long[] ids);
}
