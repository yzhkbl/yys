package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrDaihouTicheMapper;
import com.jeethink.system.domain.ZyjrDaihouTiche;
import com.jeethink.system.service.IZyjrDaihouTicheService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@Service
public class ZyjrDaihouTicheServiceImpl implements IZyjrDaihouTicheService 
{
    @Autowired
    private ZyjrDaihouTicheMapper zyjrDaihouTicheMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrDaihouTiche selectZyjrDaihouTicheById(Long id)
    {
        return zyjrDaihouTicheMapper.selectZyjrDaihouTicheById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaihouTiche 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrDaihouTiche> selectZyjrDaihouTicheList(ZyjrDaihouTiche zyjrDaihouTiche)
    {
        return zyjrDaihouTicheMapper.selectZyjrDaihouTicheList(zyjrDaihouTiche);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaihouTiche 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrDaihouTiche(ZyjrDaihouTiche zyjrDaihouTiche)
    {
        return zyjrDaihouTicheMapper.insertZyjrDaihouTiche(zyjrDaihouTiche);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaihouTiche 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrDaihouTiche(ZyjrDaihouTiche zyjrDaihouTiche)
    {
        return zyjrDaihouTicheMapper.updateZyjrDaihouTiche(zyjrDaihouTiche);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDaihouTicheByIds(Long[] ids)
    {
        return zyjrDaihouTicheMapper.deleteZyjrDaihouTicheByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDaihouTicheById(Long id)
    {
        return zyjrDaihouTicheMapper.deleteZyjrDaihouTicheById(id);
    }
}
