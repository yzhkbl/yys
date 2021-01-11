package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrGrantInstalmentsMapper;
import com.jeethink.system.domain.ZyjrGrantInstalments;
import com.jeethink.system.service.IZyjrGrantInstalmentsService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-09
 */
@Service
public class ZyjrGrantInstalmentsServiceImpl implements IZyjrGrantInstalmentsService 
{
    @Autowired
    private ZyjrGrantInstalmentsMapper zyjrGrantInstalmentsMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrGrantInstalments selectZyjrGrantInstalmentsById(String transactionCode)
    {
        return zyjrGrantInstalmentsMapper.selectZyjrGrantInstalmentsById(transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrGrantInstalments 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrGrantInstalments> selectZyjrGrantInstalmentsList(ZyjrGrantInstalments zyjrGrantInstalments)
    {
        return zyjrGrantInstalmentsMapper.selectZyjrGrantInstalmentsList(zyjrGrantInstalments);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrGrantInstalments 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrGrantInstalments(ZyjrGrantInstalments zyjrGrantInstalments)
    {
        return zyjrGrantInstalmentsMapper.insertZyjrGrantInstalments(zyjrGrantInstalments);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrGrantInstalments 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrGrantInstalments(ZyjrGrantInstalments zyjrGrantInstalments)
    {
        return zyjrGrantInstalmentsMapper.updateZyjrGrantInstalments(zyjrGrantInstalments);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrGrantInstalmentsByIds(Long[] ids)
    {
        return zyjrGrantInstalmentsMapper.deleteZyjrGrantInstalmentsByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrGrantInstalmentsById(Long id)
    {
        return zyjrGrantInstalmentsMapper.deleteZyjrGrantInstalmentsById(id);
    }
}
