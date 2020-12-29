package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrAllowBasicsMapper;
import com.jeethink.system.domain.ZyjrAllowBasics;
import com.jeethink.system.service.IZyjrAllowBasicsService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@Service
public class ZyjrAllowBasicsServiceImpl implements IZyjrAllowBasicsService 
{
    @Autowired
    private ZyjrAllowBasicsMapper zyjrAllowBasicsMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrAllowBasics selectZyjrAllowBasicsById(Long userId,String transactionCode)
    {
        return zyjrAllowBasicsMapper.selectZyjrAllowBasicsById(userId, transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrAllowBasics 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrAllowBasics> selectZyjrAllowBasicsList(ZyjrAllowBasics zyjrAllowBasics)
    {
        return zyjrAllowBasicsMapper.selectZyjrAllowBasicsList(zyjrAllowBasics);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrAllowBasics 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrAllowBasics(ZyjrAllowBasics zyjrAllowBasics)
    {
        return zyjrAllowBasicsMapper.insertZyjrAllowBasics(zyjrAllowBasics);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrAllowBasics 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrAllowBasics(ZyjrAllowBasics zyjrAllowBasics)
    {
        return zyjrAllowBasicsMapper.updateZyjrAllowBasics(zyjrAllowBasics);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrAllowBasicsByIds(Long[] ids)
    {
        return zyjrAllowBasicsMapper.deleteZyjrAllowBasicsByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrAllowBasicsById(Long id)
    {
        return zyjrAllowBasicsMapper.deleteZyjrAllowBasicsById(id);
    }
}
