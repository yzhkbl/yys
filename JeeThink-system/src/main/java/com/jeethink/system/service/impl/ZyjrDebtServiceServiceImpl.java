package com.jeethink.system.service.impl;

import java.util.List;

import com.jeethink.system.domain.ZyjrDebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrDebtServiceMapper;
import com.jeethink.system.service.IZyjrDebtServiceService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-28
 */
@Service
public class ZyjrDebtServiceServiceImpl implements IZyjrDebtServiceService 
{
    @Autowired
    private ZyjrDebtServiceMapper zyjrDebtServiceMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrDebtService selectZyjrDebtServiceById(Long userId,String transactionCode)
    {
        return zyjrDebtServiceMapper.selectZyjrDebtServiceById(userId, transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDebtService 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrDebtService> selectZyjrDebtServiceList(ZyjrDebtService zyjrDebtService)
    {

        return zyjrDebtServiceMapper.selectZyjrDebtServiceList(zyjrDebtService);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDebtService 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrDebtService(ZyjrDebtService zyjrDebtService)
    {    if(selectZyjrDebtServiceById(zyjrDebtService.getUserId(),zyjrDebtService.getTransactionCode())!=null){
        return zyjrDebtServiceMapper.updateZyjrDebtService(zyjrDebtService);
    }else {
        return zyjrDebtServiceMapper.insertZyjrDebtService(zyjrDebtService);
    }
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDebtService 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrDebtService(ZyjrDebtService zyjrDebtService)
    {
        return zyjrDebtServiceMapper.updateZyjrDebtService(zyjrDebtService);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDebtServiceByIds(Long[] ids)
    {
        return zyjrDebtServiceMapper.deleteZyjrDebtServiceByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDebtServiceById(Long id)
    {
        return zyjrDebtServiceMapper.deleteZyjrDebtServiceById(id);
    }
}
