package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrCarParentMapper;
import com.jeethink.system.domain.ZyjrCarParent;
import com.jeethink.system.service.IZyjrCarParentService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-02-05
 */
@Service
public class ZyjrCarParentServiceImpl implements IZyjrCarParentService 
{
    @Autowired
    private ZyjrCarParentMapper zyjrCarParentMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrCarParent selectZyjrCarParentById(Long id)
    {
        return zyjrCarParentMapper.selectZyjrCarParentById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCarParent 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrCarParent> selectZyjrCarParentList(ZyjrCarParent zyjrCarParent)
    {
        return zyjrCarParentMapper.selectZyjrCarParentList(zyjrCarParent);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCarParent 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrCarParent(ZyjrCarParent zyjrCarParent)
    {
        return zyjrCarParentMapper.insertZyjrCarParent(zyjrCarParent);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCarParent 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrCarParent(ZyjrCarParent zyjrCarParent)
    {
        return zyjrCarParentMapper.updateZyjrCarParent(zyjrCarParent);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCarParentByIds(Long[] ids)
    {
        return zyjrCarParentMapper.deleteZyjrCarParentByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCarParentById(Long id)
    {
        return zyjrCarParentMapper.deleteZyjrCarParentById(id);
    }
}
