package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrBankMapper;
import com.jeethink.system.domain.ZyjrBank;
import com.jeethink.system.service.IZyjrBankService;

/**
 * bankService业务层处理
 * 
 * @author jeethink
 * @date 2020-12-25
 */
@Service
public class ZyjrBankServiceImpl implements IZyjrBankService 
{
    @Autowired
    private ZyjrBankMapper zyjrBankMapper;

    /**
     * 查询bank
     * 
     * @param id bankID
     * @return bank
     */
    @Override
    public ZyjrBank selectZyjrBankById(Long id)
    {
        return zyjrBankMapper.selectZyjrBankById(id);
    }

    /**
     * 查询bank列表
     * 
     * @param zyjrBank bank
     * @return bank
     */
    @Override
    public List<ZyjrBank> selectZyjrBankList(ZyjrBank zyjrBank)
    {
        return zyjrBankMapper.selectZyjrBankList(zyjrBank);
    }

    /**
     * 新增bank
     * 
     * @param zyjrBank bank
     * @return 结果
     */
    @Override
    public int insertZyjrBank(ZyjrBank zyjrBank)
    {
        zyjrBank.setCreateTime(DateUtils.getNowDate());
        return zyjrBankMapper.insertZyjrBank(zyjrBank);
    }

    /**
     * 修改bank
     * 
     * @param zyjrBank bank
     * @return 结果
     */
    @Override
    public int updateZyjrBank(ZyjrBank zyjrBank)
    {
        zyjrBank.setUpdateTime(DateUtils.getNowDate());
        return zyjrBankMapper.updateZyjrBank(zyjrBank);
    }

    /**
     * 批量删除bank
     * 
     * @param ids 需要删除的bankID
     * @return 结果
     */
    @Override
    public int deleteZyjrBankByIds(Long[] ids)
    {
        return zyjrBankMapper.deleteZyjrBankByIds(ids);
    }

    /**
     * 删除bank信息
     * 
     * @param id bankID
     * @return 结果
     */
    @Override
    public int deleteZyjrBankById(Long id)
    {
        return zyjrBankMapper.deleteZyjrBankById(id);
    }
}
