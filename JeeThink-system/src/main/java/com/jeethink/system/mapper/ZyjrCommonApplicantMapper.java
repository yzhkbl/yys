package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrCommonApplicant;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-02-06
 */
public interface ZyjrCommonApplicantMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrCommonApplicant selectZyjrCommonApplicantById(String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCommonApplicant 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrCommonApplicant> selectZyjrCommonApplicantList(ZyjrCommonApplicant zyjrCommonApplicant);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCommonApplicant 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrCommonApplicant(ZyjrCommonApplicant zyjrCommonApplicant);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCommonApplicant 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrCommonApplicant(ZyjrCommonApplicant zyjrCommonApplicant);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCommonApplicantById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrCommonApplicantByIds(Long[] ids);
}
