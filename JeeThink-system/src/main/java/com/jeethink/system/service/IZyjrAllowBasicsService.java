package com.jeethink.system.service;

import java.util.List;
import java.util.Map;

import com.jeethink.system.domain.ZyjrAllowBasics;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public interface IZyjrAllowBasicsService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrAllowBasics selectZyjrAllowBasicsById(Long userId,String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrAllowBasics 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrAllowBasics> selectZyjrAllowBasicsList(ZyjrAllowBasics zyjrAllowBasics);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrAllowBasics 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrAllowBasics(ZyjrAllowBasics zyjrAllowBasics);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrAllowBasics 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrAllowBasics(ZyjrAllowBasics zyjrAllowBasics);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrAllowBasicsByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrAllowBasicsById(Long id);

    Map<String, Object> selectByMap(String id);
}
