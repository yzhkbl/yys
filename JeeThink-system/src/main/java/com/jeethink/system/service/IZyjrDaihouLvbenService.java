package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrDaihouLvben;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2021-01-06
 */
public interface IZyjrDaihouLvbenService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrDaihouLvben selectZyjrDaihouLvbenById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaihouLvben 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrDaihouLvben> selectZyjrDaihouLvbenList(ZyjrDaihouLvben zyjrDaihouLvben);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaihouLvben 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrDaihouLvben(ZyjrDaihouLvben zyjrDaihouLvben);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaihouLvben 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrDaihouLvben(ZyjrDaihouLvben zyjrDaihouLvben);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaihouLvbenByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaihouLvbenById(Long id);
}
