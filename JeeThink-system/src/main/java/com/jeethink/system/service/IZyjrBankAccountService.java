package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrBankAccount;

/**
 * accountService接口
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public interface IZyjrBankAccountService 
{
    /**
     * 查询account
     * 
     * @param id accountID
     * @return account
     */
    public ZyjrBankAccount selectZyjrBankAccountById(Long id);

    /**
     * 查询account列表
     * 
     * @param zyjrBankAccount account
     * @return account集合
     */
    public List<ZyjrBankAccount> selectZyjrBankAccountList(ZyjrBankAccount zyjrBankAccount);

    /**
     * 新增account
     * 
     * @param zyjrBankAccount account
     * @return 结果
     */
    public int insertZyjrBankAccount(ZyjrBankAccount zyjrBankAccount);

    /**
     * 修改account
     * 
     * @param zyjrBankAccount account
     * @return 结果
     */
    public int updateZyjrBankAccount(ZyjrBankAccount zyjrBankAccount);

    /**
     * 批量删除account
     * 
     * @param ids 需要删除的accountID
     * @return 结果
     */
    public int deleteZyjrBankAccountByIds(Long[] ids);

    /**
     * 删除account信息
     * 
     * @param id accountID
     * @return 结果
     */
    public int deleteZyjrBankAccountById(Long id);

    int deleteZyjrBankAccountByIdd(Long id);
}
