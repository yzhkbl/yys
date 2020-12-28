package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrOverdue;

/**
 * overdueService接口
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public interface IZyjrOverdueService 
{
    /**
     * 查询overdue
     * 
     * @param id overdueID
     * @return overdue
     */
    public ZyjrOverdue selectZyjrOverdueById(Long id);

    /**
     * 查询overdue列表
     * 
     * @param zyjrOverdue overdue
     * @return overdue集合
     */
    public List<ZyjrOverdue> selectZyjrOverdueList(ZyjrOverdue zyjrOverdue);

    /**
     * 新增overdue
     * 
     * @param zyjrOverdue overdue
     * @return 结果
     */
    public int insertZyjrOverdue(ZyjrOverdue zyjrOverdue);

    /**
     * 修改overdue
     * 
     * @param zyjrOverdue overdue
     * @return 结果
     */
    public int updateZyjrOverdue(ZyjrOverdue zyjrOverdue);

    /**
     * 批量删除overdue
     * 
     * @param ids 需要删除的overdueID
     * @return 结果
     */
    public int deleteZyjrOverdueByIds(Long[] ids);

    /**
     * 删除overdue信息
     * 
     * @param id overdueID
     * @return 结果
     */
    public int deleteZyjrOverdueById(Long id);
}
