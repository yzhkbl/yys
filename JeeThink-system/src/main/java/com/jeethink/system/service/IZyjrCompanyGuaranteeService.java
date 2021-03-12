package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrCompanyGuarantee;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public interface IZyjrCompanyGuaranteeService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public List<ZyjrCompanyGuarantee> selectZyjrCompanyGuaranteeById(Long userId,String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCompanyGuarantee 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrCompanyGuarantee> selectZyjrCompanyGuaranteeList(ZyjrCompanyGuarantee zyjrCompanyGuarantee);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCompanyGuarantee 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrCompanyGuarantee(ZyjrCompanyGuarantee zyjrCompanyGuarantee);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCompanyGuarantee 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrCompanyGuarantee(ZyjrCompanyGuarantee zyjrCompanyGuarantee);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCompanyGuaranteeByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCompanyGuaranteeById(Long id);
}
