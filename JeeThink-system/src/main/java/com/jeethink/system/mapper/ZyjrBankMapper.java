package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrBank;

/**
 * bankMapper接口
 * 
 * @author jeethink
 * @date 2020-12-25
 */
public interface ZyjrBankMapper 
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
     * 删除bank
     * 
     * @param id bankID
     * @return 结果
     */
    public int deleteZyjrBankById(Long id);

    /**
     * 批量删除bank
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrBankByIds(Long[] ids);
}
