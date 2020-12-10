package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrRelation;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2020-12-09
 */
public interface ZyjrRelationMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrRelationById(Integer id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrRelationByIds(Integer[] ids);
}
