package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrDaihouLvbenMapper;
import com.jeethink.system.domain.ZyjrDaihouLvben;
import com.jeethink.system.service.IZyjrDaihouLvbenService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@Service
public class ZyjrDaihouLvbenServiceImpl implements IZyjrDaihouLvbenService 
{
    @Autowired
    private ZyjrDaihouLvbenMapper zyjrDaihouLvbenMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrDaihouLvben selectZyjrDaihouLvbenById(Long id)
    {
        return zyjrDaihouLvbenMapper.selectZyjrDaihouLvbenById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaihouLvben 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrDaihouLvben> selectZyjrDaihouLvbenList(ZyjrDaihouLvben zyjrDaihouLvben)
    {
        return zyjrDaihouLvbenMapper.selectZyjrDaihouLvbenList(zyjrDaihouLvben);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaihouLvben 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrDaihouLvben(ZyjrDaihouLvben zyjrDaihouLvben)
    {
        return zyjrDaihouLvbenMapper.insertZyjrDaihouLvben(zyjrDaihouLvben);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaihouLvben 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrDaihouLvben(ZyjrDaihouLvben zyjrDaihouLvben)
    {
        return zyjrDaihouLvbenMapper.updateZyjrDaihouLvben(zyjrDaihouLvben);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDaihouLvbenByIds(Long[] ids)
    {
        return zyjrDaihouLvbenMapper.deleteZyjrDaihouLvbenByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDaihouLvbenById(Long id)
    {
        return zyjrDaihouLvbenMapper.deleteZyjrDaihouLvbenById(id);
    }
}
