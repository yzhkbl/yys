package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrEmployer;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-20
 */
public interface ZyjrEmployerMapper 
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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrEmployerById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrEmployerByIds(Long[] ids);
}
