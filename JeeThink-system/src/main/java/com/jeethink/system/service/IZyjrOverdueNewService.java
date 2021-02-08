package com.jeethink.system.service;

import java.util.List;
import java.util.Map;

import com.jeethink.system.domain.ZyjrOverdueNew;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2021-01-29
 */
public interface IZyjrOverdueNewService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public Map<String,Object> selectZyjrOverdueNewById(String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrOverdueNew 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrOverdueNew> selectZyjrOverdueNewList(ZyjrOverdueNew zyjrOverdueNew);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrOverdueNew 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrOverdueNew(ZyjrOverdueNew zyjrOverdueNew);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrOverdueNew 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrOverdueNew(ZyjrOverdueNew zyjrOverdueNew);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrOverdueNewByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrOverdueNewById(Long id);
}
