package com.jeethink.system.service;

import com.jeethink.system.domain.ZyjrAllowApplicant;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public interface IZyjrAllowApplicantService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrAllowApplicant selectZyjrAllowApplicantById(Long userId, String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrAllowApplicant 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrAllowApplicant> selectZyjrAllowApplicantList(ZyjrAllowApplicant zyjrAllowApplicant);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrAllowApplicant 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrAllowApplicant(ZyjrAllowApplicant zyjrAllowApplicant);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrAllowApplicant 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrAllowApplicant(ZyjrAllowApplicant zyjrAllowApplicant);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrAllowApplicantByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrAllowApplicantById(Long id);
}
