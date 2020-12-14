package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrGuarantee;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2020-12-10
 */
public interface ZyjrGuaranteeMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrGuarantee selectZyjrGuaranteeById(Integer id);
    public ZyjrGuarantee selectById(String id);

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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrGuaranteeById(Integer id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrGuaranteeByIds(Integer[] ids);
}
