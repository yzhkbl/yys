package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrBankAccountMapper;
import com.jeethink.system.domain.ZyjrBankAccount;
import com.jeethink.system.service.IZyjrBankAccountService;

/**
 * accountService业务层处理
 * 
 * @author jeethink
 * @date 2020-12-26
 */
@Service
public class ZyjrBankAccountServiceImpl implements IZyjrBankAccountService 
{
    @Autowired
    private ZyjrBankAccountMapper zyjrBankAccountMapper;

    /**
     * 查询account
     * 
     * @param id accountID
     * @return account
     */
    @Override
    public ZyjrBankAccount selectZyjrBankAccountById(Long id)
    {
        return zyjrBankAccountMapper.selectZyjrBankAccountById(id);
    }

    /**
     * 查询account列表
     * 
     * @param zyjrBankAccount account
     * @return account
     */
    @Override
    public List<ZyjrBankAccount> selectZyjrBankAccountList(ZyjrBankAccount zyjrBankAccount)
    {
        return zyjrBankAccountMapper.selectZyjrBankAccountList(zyjrBankAccount);
    }

    /**
     * 新增account
     * 
     * @param zyjrBankAccount account
     * @return 结果
     */
    @Override
    public int insertZyjrBankAccount(ZyjrBankAccount zyjrBankAccount)
    {

        return zyjrBankAccountMapper.insertZyjrBankAccount(zyjrBankAccount);
    }

    /**
     * 修改account
     * 
     * @param zyjrBankAccount account
     * @return 结果
     */
    @Override
    public int updateZyjrBankAccount(ZyjrBankAccount zyjrBankAccount)
    {

        return zyjrBankAccountMapper.updateZyjrBankAccount(zyjrBankAccount);
    }

    /**
     * 批量删除account
     * 
     * @param ids 需要删除的accountID
     * @return 结果
     */
    @Override
    public int deleteZyjrBankAccountByIds(Long[] ids)
    {
        return zyjrBankAccountMapper.deleteZyjrBankAccountByIds(ids);
    }

    /**
     * 删除account信息
     * 
     * @param id accountID
     * @return 结果
     */
    @Override
    public int deleteZyjrBankAccountById(Long id)
    {
        return zyjrBankAccountMapper.deleteZyjrBankAccountById(id);
    }
}
