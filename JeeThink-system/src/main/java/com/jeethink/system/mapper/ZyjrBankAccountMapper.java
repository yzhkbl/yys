package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrBankAccount;

/**
 * accountMapper接口
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public interface ZyjrBankAccountMapper 
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

    public int insertZyjrBankAccounts(List<ZyjrBankAccount> ZyjrBankAccount);

    /**
     * 修改account
     * 
     * @param zyjrBankAccount account
     * @return 结果
     */
    public int updateZyjrBankAccount(ZyjrBankAccount zyjrBankAccount);

    /**
     * 删除account
     * 
     * @param id accountID
     * @return 结果
     */
    public int deleteZyjrBankAccountById(Long id);

    /**
     * 批量删除account
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrBankAccountByIds(Long[] ids);
}
