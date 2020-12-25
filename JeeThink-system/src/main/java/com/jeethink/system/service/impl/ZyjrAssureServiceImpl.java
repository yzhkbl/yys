package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrAssureMapper;
import com.jeethink.system.domain.ZyjrAssure;
import com.jeethink.system.service.IZyjrAssureService;

/**
 * assureService业务层处理
 * 
 * @author jeethink
 * @date 2020-12-25
 */
@Service
public class ZyjrAssureServiceImpl implements IZyjrAssureService 
{
    @Autowired
    private ZyjrAssureMapper zyjrAssureMapper;

    /**
     * 查询assure
     * 
     * @param id assureID
     * @return assure
     */
    @Override
    public ZyjrAssure selectZyjrAssureById(Long id)
    {
        return zyjrAssureMapper.selectZyjrAssureById(id);
    }

    /**
     * 查询assure列表
     * 
     * @param zyjrAssure assure
     * @return assure
     */
    @Override
    public List<ZyjrAssure> selectZyjrAssureList(ZyjrAssure zyjrAssure)
    {
        return zyjrAssureMapper.selectZyjrAssureList(zyjrAssure);
    }

    /**
     * 新增assure
     * 
     * @param zyjrAssure assure
     * @return 结果
     */
    @Override
    public int insertZyjrAssure(ZyjrAssure zyjrAssure)
    {
        zyjrAssure.setCreateTime(DateUtils.getNowDate());
        return zyjrAssureMapper.insertZyjrAssure(zyjrAssure);
    }

    /**
     * 修改assure
     * 
     * @param zyjrAssure assure
     * @return 结果
     */
    @Override
    public int updateZyjrAssure(ZyjrAssure zyjrAssure)
    {
        zyjrAssure.setUpdateTime(DateUtils.getNowDate());
        return zyjrAssureMapper.updateZyjrAssure(zyjrAssure);
    }

    /**
     * 批量删除assure
     * 
     * @param ids 需要删除的assureID
     * @return 结果
     */
    @Override
    public int deleteZyjrAssureByIds(Long[] ids)
    {
        return zyjrAssureMapper.deleteZyjrAssureByIds(ids);
    }

    /**
     * 删除assure信息
     * 
     * @param id assureID
     * @return 结果
     */
    @Override
    public int deleteZyjrAssureById(Long id)
    {
        return zyjrAssureMapper.deleteZyjrAssureById(id);
    }
}
