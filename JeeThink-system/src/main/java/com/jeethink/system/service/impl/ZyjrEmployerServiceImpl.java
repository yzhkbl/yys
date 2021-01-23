package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrEmployerMapper;
import com.jeethink.system.domain.ZyjrEmployer;
import com.jeethink.system.service.IZyjrEmployerService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-20
 */
@Service
public class ZyjrEmployerServiceImpl implements IZyjrEmployerService 
{
    @Autowired
    private ZyjrEmployerMapper zyjrEmployerMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrEmployer selectZyjrEmployerById(Long id)
    {
        return zyjrEmployerMapper.selectZyjrEmployerById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrEmployer 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrEmployer> selectZyjrEmployerList(ZyjrEmployer zyjrEmployer)
    {
        return zyjrEmployerMapper.selectZyjrEmployerList(zyjrEmployer);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrEmployer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrEmployer(ZyjrEmployer zyjrEmployer)
    {
        return zyjrEmployerMapper.insertZyjrEmployer(zyjrEmployer);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrEmployer 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrEmployer(ZyjrEmployer zyjrEmployer)
    {
        return zyjrEmployerMapper.updateZyjrEmployer(zyjrEmployer);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrEmployerByIds(Long[] ids)
    {
        return zyjrEmployerMapper.deleteZyjrEmployerByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrEmployerById(Long id)
    {
        return zyjrEmployerMapper.deleteZyjrEmployerById(id);
    }
}
