package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrFinanceChargeCardInfo;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-19
 */
public interface ZyjrFinanceChargeCardInfoMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrFinanceChargeCardInfo selectZyjrFinanceChargeCardInfoById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrFinanceChargeCardInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrFinanceChargeCardInfo> selectZyjrFinanceChargeCardInfoList(ZyjrFinanceChargeCardInfo zyjrFinanceChargeCardInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrFinanceChargeCardInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrFinanceChargeCardInfo(ZyjrFinanceChargeCardInfo zyjrFinanceChargeCardInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrFinanceChargeCardInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrFinanceChargeCardInfo(ZyjrFinanceChargeCardInfo zyjrFinanceChargeCardInfo);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrFinanceChargeCardInfoById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrFinanceChargeCardInfoByIds(Long[] ids);
}
