package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrCarParent;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2021-02-05
 */
public interface IZyjrCarParentService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrCarParent selectZyjrCarParentById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCarParent 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrCarParent> selectZyjrCarParentList(ZyjrCarParent zyjrCarParent);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCarParent 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrCarParent(ZyjrCarParent zyjrCarParent);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCarParent 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrCarParent(ZyjrCarParent zyjrCarParent);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCarParentByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCarParentById(Long id);
}
