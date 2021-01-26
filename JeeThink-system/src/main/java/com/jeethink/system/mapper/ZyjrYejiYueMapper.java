package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrYejiYue;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-25
 */
public interface ZyjrYejiYueMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrYejiYue selectZyjrYejiYueById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrYejiYue 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrYejiYue> selectZyjrYejiYueList(ZyjrYejiYue zyjrYejiYue);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrYejiYue 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrYejiYue(ZyjrYejiYue zyjrYejiYue);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrYejiYue 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrYejiYue(ZyjrYejiYue zyjrYejiYue);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrYejiYueById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrYejiYueByIds(Long[] ids);
}
