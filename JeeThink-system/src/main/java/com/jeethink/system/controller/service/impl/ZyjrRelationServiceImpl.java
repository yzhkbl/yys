package com.jeethink.system.controller.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrRelationMapper;
import com.jeethink.system.domain.ZyjrRelation;
import com.jeethink.system.controller.service.IZyjrRelationService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-09
 */
@Service
public class ZyjrRelationServiceImpl implements IZyjrRelationService 
{
    @Autowired
    private ZyjrRelationMapper zyjrRelationMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrRelation selectZyjrRelationById(Integer id)
    {
        return zyjrRelationMapper.selectZyjrRelationById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrRelation 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrRelation> selectZyjrRelationList(ZyjrRelation zyjrRelation)
    {
        return zyjrRelationMapper.selectZyjrRelationList(zyjrRelation);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrRelation 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrRelation(ZyjrRelation zyjrRelation)
    {
        return zyjrRelationMapper.insertZyjrRelation(zyjrRelation);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrRelation 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrRelation(ZyjrRelation zyjrRelation)
    {
        return zyjrRelationMapper.updateZyjrRelation(zyjrRelation);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrRelationByIds(Integer[] ids)
    {
        return zyjrRelationMapper.deleteZyjrRelationByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrRelationById(Integer id)
    {
        return zyjrRelationMapper.deleteZyjrRelationById(id);
    }
}
