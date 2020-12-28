package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrBankFlow;

/**
 * flowService接口
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public interface IZyjrBankFlowService 
{
    /**
     * 查询flow
     * 
     * @param id flowID
     * @return flow
     */
    public ZyjrBankFlow selectZyjrBankFlowById(Long id);

    /**
     * 查询flow列表
     * 
     * @param zyjrBankFlow flow
     * @return flow集合
     */
    public List<ZyjrBankFlow> selectZyjrBankFlowList(ZyjrBankFlow zyjrBankFlow);

    /**
     * 新增flow
     * 
     * @param zyjrBankFlow flow
     * @return 结果
     */
    public int insertZyjrBankFlow(ZyjrBankFlow zyjrBankFlow);

    /**
     * 修改flow
     * 
     * @param zyjrBankFlow flow
     * @return 结果
     */
    public int updateZyjrBankFlow(ZyjrBankFlow zyjrBankFlow);

    /**
     * 批量删除flow
     * 
     * @param ids 需要删除的flowID
     * @return 结果
     */
    public int deleteZyjrBankFlowByIds(Long[] ids);

    /**
     * 删除flow信息
     * 
     * @param id flowID
     * @return 结果
     */
    public int deleteZyjrBankFlowById(Long id);
}
