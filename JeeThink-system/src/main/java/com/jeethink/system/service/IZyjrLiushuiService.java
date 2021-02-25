package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrLiushui;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2021-02-25
 */
public interface IZyjrLiushuiService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrLiushui selectZyjrLiushuiById(String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrLiushui 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrLiushui> selectZyjrLiushuiList(ZyjrLiushui zyjrLiushui);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrLiushui 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrLiushui(ZyjrLiushui zyjrLiushui);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrLiushui 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrLiushui(ZyjrLiushui zyjrLiushui);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrLiushuiByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrLiushuiById(Long id);
}
