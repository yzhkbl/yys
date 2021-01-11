package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrGrantVisitMapper;
import com.jeethink.system.domain.ZyjrGrantVisit;
import com.jeethink.system.service.IZyjrGrantVisitService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-09
 */
@Service
public class ZyjrGrantVisitServiceImpl implements IZyjrGrantVisitService 
{
    @Autowired
    private ZyjrGrantVisitMapper zyjrGrantVisitMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrGrantVisit selectZyjrGrantVisitById(String transactionCode)
    {
        return zyjrGrantVisitMapper.selectZyjrGrantVisitById(transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrGrantVisit 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrGrantVisit> selectZyjrGrantVisitList(ZyjrGrantVisit zyjrGrantVisit)
    {
        return zyjrGrantVisitMapper.selectZyjrGrantVisitList(zyjrGrantVisit);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrGrantVisit 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrGrantVisit(ZyjrGrantVisit zyjrGrantVisit)
    {
        return zyjrGrantVisitMapper.insertZyjrGrantVisit(zyjrGrantVisit);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrGrantVisit 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrGrantVisit(ZyjrGrantVisit zyjrGrantVisit)
    {
        return zyjrGrantVisitMapper.updateZyjrGrantVisit(zyjrGrantVisit);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrGrantVisitByIds(Long[] ids)
    {
        return zyjrGrantVisitMapper.deleteZyjrGrantVisitByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrGrantVisitById(Long id)
    {
        return zyjrGrantVisitMapper.deleteZyjrGrantVisitById(id);
    }
}
