package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrBankExtend;

/**
 * extendMapper接口
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public interface ZyjrBankExtendMapper 
{
    /**
     * 查询extend
     * 
     * @param id extendID
     * @return extend
     */
    public ZyjrBankExtend selectZyjrBankExtendById(Long id);

    /**
     * 查询extend列表
     * 
     * @param zyjrBankExtend extend
     * @return extend集合
     */
    public List<ZyjrBankExtend> selectZyjrBankExtendList(ZyjrBankExtend zyjrBankExtend);

    /**
     * 新增extend
     * 
     * @param zyjrBankExtend extend
     * @return 结果
     */
    public int insertZyjrBankExtend(ZyjrBankExtend zyjrBankExtend);

    /**
     * 修改extend
     * 
     * @param zyjrBankExtend extend
     * @return 结果
     */
    public int updateZyjrBankExtend(ZyjrBankExtend zyjrBankExtend);

    /**
     * 删除extend
     * 
     * @param id extendID
     * @return 结果
     */
    public int deleteZyjrBankExtendById(Long id);

    /**
     * 批量删除extend
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrBankExtendByIds(Long[] ids);
}
