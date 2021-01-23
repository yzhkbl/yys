package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrEmployer;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2021-01-20
 */
public interface IZyjrEmployerService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrEmployer selectZyjrEmployerById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrEmployer 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrEmployer> selectZyjrEmployerList(ZyjrEmployer zyjrEmployer);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrEmployer 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrEmployer(ZyjrEmployer zyjrEmployer);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrEmployer 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrEmployer(ZyjrEmployer zyjrEmployer);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrEmployerByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrEmployerById(Long id);
}
