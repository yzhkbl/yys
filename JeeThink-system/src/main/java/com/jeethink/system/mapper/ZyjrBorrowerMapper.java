package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrBorrower;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2020-12-10
 */
public interface ZyjrBorrowerMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrBorrower selectZyjrBorrowerById(Integer id);
    public ZyjrBorrower selectById(Integer id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrBorrower 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrBorrower> selectZyjrBorrowerList(ZyjrBorrower zyjrBorrower);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrBorrower 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrBorrower(ZyjrBorrower zyjrBorrower);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrBorrower 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrBorrower(ZyjrBorrower zyjrBorrower);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrBorrowerById(Integer id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrBorrowerByIds(Integer[] ids);
}
