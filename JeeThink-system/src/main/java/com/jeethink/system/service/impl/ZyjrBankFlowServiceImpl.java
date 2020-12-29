package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrBankFlowMapper;
import com.jeethink.system.domain.ZyjrBankFlow;
import com.jeethink.system.service.IZyjrBankFlowService;

/**
 * flowService业务层处理
 * 
 * @author jeethink
 * @date 2020-12-26
 */
@Service
public class ZyjrBankFlowServiceImpl implements IZyjrBankFlowService 
{
    @Autowired
    private ZyjrBankFlowMapper zyjrBankFlowMapper;

    /**
     * 查询flow
     * 
     * @param id flowID
     * @return flow
     */
    @Override
    public ZyjrBankFlow selectZyjrBankFlowById(Long id)
    {
        return zyjrBankFlowMapper.selectZyjrBankFlowById(id);
    }

    /**
     * 查询flow列表
     * 
     * @param zyjrBankFlow flow
     * @return flow
     */
    @Override
    public List<ZyjrBankFlow> selectZyjrBankFlowList(ZyjrBankFlow zyjrBankFlow)
    {
        return zyjrBankFlowMapper.selectZyjrBankFlowList(zyjrBankFlow);
    }

    /**
     * 新增flow
     * 
     * @param zyjrBankFlow flow
     * @return 结果
     */
    @Override
    public int insertZyjrBankFlow(ZyjrBankFlow zyjrBankFlow)
    {

        return zyjrBankFlowMapper.insertZyjrBankFlow(zyjrBankFlow);
    }

    /**
     * 修改flow
     * 
     * @param zyjrBankFlow flow
     * @return 结果
     */
    @Override
    public int updateZyjrBankFlow(ZyjrBankFlow zyjrBankFlow)
    {

        return zyjrBankFlowMapper.updateZyjrBankFlow(zyjrBankFlow);
    }

    /**
     * 批量删除flow
     * 
     * @param ids 需要删除的flowID
     * @return 结果
     */
    @Override
    public int deleteZyjrBankFlowByIds(Long[] ids)
    {
        return zyjrBankFlowMapper.deleteZyjrBankFlowByIds(ids);
    }

    /**
     * 删除flow信息
     * 
     * @param id flowID
     * @return 结果
     */
    @Override
    public int deleteZyjrBankFlowById(Long id)
    {
        return zyjrBankFlowMapper.deleteZyjrBankFlowById(id);
    }
}
