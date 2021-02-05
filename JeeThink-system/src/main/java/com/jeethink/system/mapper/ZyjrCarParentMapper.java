package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrCarParent;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-02-05
 */
public interface ZyjrCarParentMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCarParentById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrCarParentByIds(Long[] ids);
}
