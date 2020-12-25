package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrGpsMapper;
import com.jeethink.system.domain.ZyjrGps;
import com.jeethink.system.service.IZyjrGpsService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-23
 */
@Service
public class ZyjrGpsServiceImpl implements IZyjrGpsService 
{
    @Autowired
    private ZyjrGpsMapper zyjrGpsMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrGps selectZyjrGpsById(String id)
    {
        return zyjrGpsMapper.selectZyjrGpsById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrGps 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrGps> selectZyjrGpsList(ZyjrGps zyjrGps)
    {
        return zyjrGpsMapper.selectZyjrGpsList(zyjrGps);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrGps 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrGps(ZyjrGps zyjrGps)
    {
        zyjrGps.setCreateTime(DateUtils.getNowDate());
        return zyjrGpsMapper.insertZyjrGps(zyjrGps);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrGps 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrGps(ZyjrGps zyjrGps)
    {
        zyjrGps.setUpdateTime(DateUtils.getNowDate());
        return zyjrGpsMapper.updateZyjrGps(zyjrGps);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrGpsByIds(Long[] ids)
    {
        return zyjrGpsMapper.deleteZyjrGpsByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrGpsById(Long id)
    {
        return zyjrGpsMapper.deleteZyjrGpsById(id);
    }
}
