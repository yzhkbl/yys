package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrDaihouTiche;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2021-01-06
 */
public interface IZyjrDaihouTicheService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrDaihouTiche selectZyjrDaihouTicheById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaihouTiche 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrDaihouTiche> selectZyjrDaihouTicheList(ZyjrDaihouTiche zyjrDaihouTiche);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaihouTiche 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrDaihouTiche(ZyjrDaihouTiche zyjrDaihouTiche);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaihouTiche 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrDaihouTiche(ZyjrDaihouTiche zyjrDaihouTiche);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaihouTicheByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaihouTicheById(Long id);
}
