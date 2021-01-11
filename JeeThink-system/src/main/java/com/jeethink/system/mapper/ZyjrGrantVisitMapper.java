package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrGrantVisit;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-09
 */
public interface ZyjrGrantVisitMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrGrantVisit selectZyjrGrantVisitById(String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrGrantVisit 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrGrantVisit> selectZyjrGrantVisitList(ZyjrGrantVisit zyjrGrantVisit);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrGrantVisit 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrGrantVisit(ZyjrGrantVisit zyjrGrantVisit);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrGrantVisit 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrGrantVisit(ZyjrGrantVisit zyjrGrantVisit);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrGrantVisitById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrGrantVisitByIds(Long[] ids);
}
