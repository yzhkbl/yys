package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrDaihouMapper;
import com.jeethink.system.domain.ZyjrDaihou;
import com.jeethink.system.service.IZyjrDaihouService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@Service
public class ZyjrDaihouServiceImpl implements IZyjrDaihouService 
{
    @Autowired
    private ZyjrDaihouMapper zyjrDaihouMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrDaihou selectZyjrDaihouById(Long id)
    {
        return zyjrDaihouMapper.selectZyjrDaihouById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaihou 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrDaihou> selectZyjrDaihouList(ZyjrDaihou zyjrDaihou)
    {
        return zyjrDaihouMapper.selectZyjrDaihouList(zyjrDaihou);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaihou 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrDaihou(ZyjrDaihou zyjrDaihou)
    {
        return zyjrDaihouMapper.insertZyjrDaihou(zyjrDaihou);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaihou 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrDaihou(ZyjrDaihou zyjrDaihou)
    {
        return zyjrDaihouMapper.updateZyjrDaihou(zyjrDaihou);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDaihouByIds(Long[] ids)
    {
        return zyjrDaihouMapper.deleteZyjrDaihouByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDaihouById(Long id)
    {
        return zyjrDaihouMapper.deleteZyjrDaihouById(id);
    }
}
