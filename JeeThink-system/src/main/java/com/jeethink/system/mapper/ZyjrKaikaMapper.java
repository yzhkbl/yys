package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrKaika;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-12
 */
public interface ZyjrKaikaMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrKaika selectZyjrKaikaById(String id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrKaika 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrKaika> selectZyjrKaikaList(ZyjrKaika zyjrKaika);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrKaika 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrKaika(ZyjrKaika zyjrKaika);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrKaika 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrKaika(ZyjrKaika zyjrKaika);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrKaikaById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrKaikaByIds(Long[] ids);
}
