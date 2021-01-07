package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrDaihouBaoxianMapper;
import com.jeethink.system.domain.ZyjrDaihouBaoxian;
import com.jeethink.system.service.IZyjrDaihouBaoxianService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@Service
public class ZyjrDaihouBaoxianServiceImpl implements IZyjrDaihouBaoxianService 
{
    @Autowired
    private ZyjrDaihouBaoxianMapper zyjrDaihouBaoxianMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrDaihouBaoxian selectZyjrDaihouBaoxianById(Long id)
    {
        return zyjrDaihouBaoxianMapper.selectZyjrDaihouBaoxianById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaihouBaoxian 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrDaihouBaoxian> selectZyjrDaihouBaoxianList(ZyjrDaihouBaoxian zyjrDaihouBaoxian)
    {
        return zyjrDaihouBaoxianMapper.selectZyjrDaihouBaoxianList(zyjrDaihouBaoxian);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaihouBaoxian 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrDaihouBaoxian(ZyjrDaihouBaoxian zyjrDaihouBaoxian)
    {
        return zyjrDaihouBaoxianMapper.insertZyjrDaihouBaoxian(zyjrDaihouBaoxian);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaihouBaoxian 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrDaihouBaoxian(ZyjrDaihouBaoxian zyjrDaihouBaoxian)
    {
        return zyjrDaihouBaoxianMapper.updateZyjrDaihouBaoxian(zyjrDaihouBaoxian);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDaihouBaoxianByIds(Long[] ids)
    {
        return zyjrDaihouBaoxianMapper.deleteZyjrDaihouBaoxianByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDaihouBaoxianById(Long id)
    {
        return zyjrDaihouBaoxianMapper.deleteZyjrDaihouBaoxianById(id);
    }
}
