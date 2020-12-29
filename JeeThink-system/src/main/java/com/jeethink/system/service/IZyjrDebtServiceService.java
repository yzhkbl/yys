package com.jeethink.system.service;

import com.jeethink.system.domain.ZyjrDebtService;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-28
 */
public interface IZyjrDebtServiceService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrDebtService selectZyjrDebtServiceById(Long userId, String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDebtService 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrDebtService> selectZyjrDebtServiceList(ZyjrDebtService zyjrDebtService);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDebtService 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrDebtService(ZyjrDebtService zyjrDebtService);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDebtService 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrDebtService(ZyjrDebtService zyjrDebtService);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDebtServiceByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDebtServiceById(Long id);
}
