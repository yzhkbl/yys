package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrDaihouZhengshuMapper;
import com.jeethink.system.domain.ZyjrDaihouZhengshu;
import com.jeethink.system.service.IZyjrDaihouZhengshuService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@Service
public class ZyjrDaihouZhengshuServiceImpl implements IZyjrDaihouZhengshuService 
{
    @Autowired
    private ZyjrDaihouZhengshuMapper zyjrDaihouZhengshuMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrDaihouZhengshu selectZyjrDaihouZhengshuById(Long id)
    {
        return zyjrDaihouZhengshuMapper.selectZyjrDaihouZhengshuById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaihouZhengshu 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrDaihouZhengshu> selectZyjrDaihouZhengshuList(ZyjrDaihouZhengshu zyjrDaihouZhengshu)
    {
        return zyjrDaihouZhengshuMapper.selectZyjrDaihouZhengshuList(zyjrDaihouZhengshu);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaihouZhengshu 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrDaihouZhengshu(ZyjrDaihouZhengshu zyjrDaihouZhengshu)
    {
        return zyjrDaihouZhengshuMapper.insertZyjrDaihouZhengshu(zyjrDaihouZhengshu);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaihouZhengshu 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrDaihouZhengshu(ZyjrDaihouZhengshu zyjrDaihouZhengshu)
    {
        return zyjrDaihouZhengshuMapper.updateZyjrDaihouZhengshu(zyjrDaihouZhengshu);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDaihouZhengshuByIds(Long[] ids)
    {
        return zyjrDaihouZhengshuMapper.deleteZyjrDaihouZhengshuByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDaihouZhengshuById(Long id)
    {
        return zyjrDaihouZhengshuMapper.deleteZyjrDaihouZhengshuById(id);
    }
}
