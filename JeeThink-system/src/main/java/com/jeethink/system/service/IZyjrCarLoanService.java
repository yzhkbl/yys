package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrCarLoan;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public interface IZyjrCarLoanService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrCarLoan selectZyjrCarLoanById(Long userId,String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCarLoan 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrCarLoan> selectZyjrCarLoanList(ZyjrCarLoan zyjrCarLoan);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCarLoan 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrCarLoan(ZyjrCarLoan zyjrCarLoan);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCarLoan 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrCarLoan(ZyjrCarLoan zyjrCarLoan);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCarLoanByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCarLoanById(Long id);
}
