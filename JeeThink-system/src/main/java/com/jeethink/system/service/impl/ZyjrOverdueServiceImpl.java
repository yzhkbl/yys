package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrOverdueMapper;
import com.jeethink.system.domain.ZyjrOverdue;
import com.jeethink.system.service.IZyjrOverdueService;

/**
 * overdueService业务层处理
 * 
 * @author jeethink
 * @date 2020-12-26
 */
@Service
public class ZyjrOverdueServiceImpl implements IZyjrOverdueService 
{
    @Autowired
    private ZyjrOverdueMapper zyjrOverdueMapper;

    /**
     * 查询overdue
     * 
     * @param id overdueID
     * @return overdue
     */
    @Override
    public ZyjrOverdue selectZyjrOverdueById(Long id)
    {
        return zyjrOverdueMapper.selectZyjrOverdueById(id);
    }

    /**
     * 查询overdue列表
     * 
     * @param zyjrOverdue overdue
     * @return overdue
     */
    @Override
    public List<ZyjrOverdue> selectZyjrOverdueList(ZyjrOverdue zyjrOverdue)
    {
        return zyjrOverdueMapper.selectZyjrOverdueList(zyjrOverdue);
    }

    /**
     * 新增overdue
     * 
     * @param zyjrOverdue overdue
     * @return 结果
     */
    @Override
    public int insertZyjrOverdue(ZyjrOverdue zyjrOverdue)
    {
        zyjrOverdue.setCreateTime(DateUtils.getNowDate());
        return zyjrOverdueMapper.insertZyjrOverdue(zyjrOverdue);
    }

    /**
     * 修改overdue
     * 
     * @param zyjrOverdue overdue
     * @return 结果
     */
    @Override
    public int updateZyjrOverdue(ZyjrOverdue zyjrOverdue)
    {
        zyjrOverdue.setUpdateTime(DateUtils.getNowDate());
        return zyjrOverdueMapper.updateZyjrOverdue(zyjrOverdue);
    }

    /**
     * 批量删除overdue
     * 
     * @param ids 需要删除的overdueID
     * @return 结果
     */
    @Override
    public int deleteZyjrOverdueByIds(Long[] ids)
    {
        return zyjrOverdueMapper.deleteZyjrOverdueByIds(ids);
    }

    /**
     * 删除overdue信息
     * 
     * @param id overdueID
     * @return 结果
     */
    @Override
    public int deleteZyjrOverdueById(Long id)
    {
        return zyjrOverdueMapper.deleteZyjrOverdueById(id);
    }
}
