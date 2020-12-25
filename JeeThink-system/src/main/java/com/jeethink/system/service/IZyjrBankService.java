package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrBank;

/**
 * bankService接口
 * 
 * @author jeethink
 * @date 2020-12-25
 */
public interface IZyjrBankService 
{
    /**
     * 查询bank
     * 
     * @param id bankID
     * @return bank
     */
    public ZyjrBank selectZyjrBankById(Long id);

    /**
     * 查询bank列表
     * 
     * @param zyjrBank bank
     * @return bank集合
     */
    public List<ZyjrBank> selectZyjrBankList(ZyjrBank zyjrBank);

    /**
     * 新增bank
     * 
     * @param zyjrBank bank
     * @return 结果
     */
    public int insertZyjrBank(ZyjrBank zyjrBank);

    /**
     * 修改bank
     * 
     * @param zyjrBank bank
     * @return 结果
     */
    public int updateZyjrBank(ZyjrBank zyjrBank);

    /**
     * 批量删除bank
     * 
     * @param ids 需要删除的bankID
     * @return 结果
     */
    public int deleteZyjrBankByIds(Long[] ids);

    /**
     * 删除bank信息
     * 
     * @param id bankID
     * @return 结果
     */
    public int deleteZyjrBankById(Long id);
}
