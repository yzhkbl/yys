package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrOverdue;

/**
 * overdueMapper接口
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public interface ZyjrOverdueMapper 
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
     * 删除overdue
     * 
     * @param id overdueID
     * @return 结果
     */
    public int deleteZyjrOverdueById(Long id);

    /**
     * 批量删除overdue
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrOverdueByIds(Long[] ids);
}
