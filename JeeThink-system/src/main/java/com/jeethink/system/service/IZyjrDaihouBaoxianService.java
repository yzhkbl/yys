package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrDaihouBaoxian;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2021-01-06
 */
public interface IZyjrDaihouBaoxianService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrDaihouBaoxian selectZyjrDaihouBaoxianById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaihouBaoxian 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrDaihouBaoxian> selectZyjrDaihouBaoxianList(ZyjrDaihouBaoxian zyjrDaihouBaoxian);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaihouBaoxian 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrDaihouBaoxian(ZyjrDaihouBaoxian zyjrDaihouBaoxian);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaihouBaoxian 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrDaihouBaoxian(ZyjrDaihouBaoxian zyjrDaihouBaoxian);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaihouBaoxianByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaihouBaoxianById(Long id);
}
