package com.jeethink.system.controller.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrCarMapper;
import com.jeethink.system.domain.ZyjrCar;
import com.jeethink.system.controller.service.IZyjrCarService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-14
 */
@Service
public class ZyjrCarServiceImpl implements IZyjrCarService 
{
    @Autowired
    private ZyjrCarMapper zyjrCarMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrCar selectZyjrCarById(Long id)
    {
        return zyjrCarMapper.selectZyjrCarById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCar 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrCar> selectZyjrCarList(ZyjrCar zyjrCar)
    {
        return zyjrCarMapper.selectZyjrCarList(zyjrCar);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCar 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrCar(ZyjrCar zyjrCar)
    {
        zyjrCar.setCreateTime(DateUtils.getNowDate());
        return zyjrCarMapper.insertZyjrCar(zyjrCar);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCar 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrCar(ZyjrCar zyjrCar)
    {
        zyjrCar.setUpdateTime(DateUtils.getNowDate());
        return zyjrCarMapper.updateZyjrCar(zyjrCar);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCarByIds(Long[] ids)
    {
        return zyjrCarMapper.deleteZyjrCarByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCarById(Long id)
    {
        return zyjrCarMapper.deleteZyjrCarById(id);
    }
}
