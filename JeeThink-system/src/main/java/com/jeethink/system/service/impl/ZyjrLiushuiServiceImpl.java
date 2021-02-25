package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrLiushuiMapper;
import com.jeethink.system.domain.ZyjrLiushui;
import com.jeethink.system.service.IZyjrLiushuiService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-02-25
 */
@Service
public class ZyjrLiushuiServiceImpl implements IZyjrLiushuiService 
{
    @Autowired
    private ZyjrLiushuiMapper zyjrLiushuiMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrLiushui selectZyjrLiushuiById(String transactionCode)
    {
        return zyjrLiushuiMapper.selectZyjrLiushuiById(transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrLiushui 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrLiushui> selectZyjrLiushuiList(ZyjrLiushui zyjrLiushui)
    {
        return zyjrLiushuiMapper.selectZyjrLiushuiList(zyjrLiushui);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrLiushui 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrLiushui(ZyjrLiushui zyjrLiushui)
    {
        return zyjrLiushuiMapper.insertZyjrLiushui(zyjrLiushui);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrLiushui 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrLiushui(ZyjrLiushui zyjrLiushui)
    {
        return zyjrLiushuiMapper.updateZyjrLiushui(zyjrLiushui);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrLiushuiByIds(Long[] ids)
    {
        return zyjrLiushuiMapper.deleteZyjrLiushuiByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrLiushuiById(Long id)
    {
        return zyjrLiushuiMapper.deleteZyjrLiushuiById(id);
    }
}
