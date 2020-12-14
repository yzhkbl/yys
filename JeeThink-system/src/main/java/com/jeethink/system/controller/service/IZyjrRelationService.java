package com.jeethink.system.controller.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrRelation;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-09
 */
public interface IZyjrRelationService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrRelation selectZyjrRelationById(Integer id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrRelation 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrRelation> selectZyjrRelationList(ZyjrRelation zyjrRelation);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrRelation 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrRelation(ZyjrRelation zyjrRelation);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrRelation 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrRelation(ZyjrRelation zyjrRelation);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrRelationByIds(Integer[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrRelationById(Integer id);
}
