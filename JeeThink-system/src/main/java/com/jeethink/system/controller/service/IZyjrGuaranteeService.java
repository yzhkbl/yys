package com.jeethink.system.controller.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrGuarantee;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-10
 */
public interface IZyjrGuaranteeService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrGuarantee selectZyjrGuaranteeById(Integer id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrGuarantee 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrGuarantee> selectZyjrGuaranteeList(ZyjrGuarantee zyjrGuarantee);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrGuarantee 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrGuarantee(ZyjrGuarantee zyjrGuarantee);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrGuarantee 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrGuarantee(ZyjrGuarantee zyjrGuarantee);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrGuaranteeByIds(Integer[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrGuaranteeById(Integer id);
}
