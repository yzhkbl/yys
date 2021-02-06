package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrCommonApplicantMapper;
import com.jeethink.system.domain.ZyjrCommonApplicant;
import com.jeethink.system.service.IZyjrCommonApplicantService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-02-06
 */
@Service
public class ZyjrCommonApplicantServiceImpl implements IZyjrCommonApplicantService 
{
    @Autowired
    private ZyjrCommonApplicantMapper zyjrCommonApplicantMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrCommonApplicant selectZyjrCommonApplicantById(String transactionCode)
    {
        return zyjrCommonApplicantMapper.selectZyjrCommonApplicantById(transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCommonApplicant 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrCommonApplicant> selectZyjrCommonApplicantList(ZyjrCommonApplicant zyjrCommonApplicant)
    {
        return zyjrCommonApplicantMapper.selectZyjrCommonApplicantList(zyjrCommonApplicant);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCommonApplicant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrCommonApplicant(ZyjrCommonApplicant zyjrCommonApplicant)
    {   ZyjrCommonApplicant a = zyjrCommonApplicantMapper.selectZyjrCommonApplicantById(zyjrCommonApplicant.getTransactionCode());
        if(a!=null){
            return zyjrCommonApplicantMapper.updateZyjrCommonApplicant(zyjrCommonApplicant);
        }else {
            return zyjrCommonApplicantMapper.insertZyjrCommonApplicant(zyjrCommonApplicant);
        }
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCommonApplicant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrCommonApplicant(ZyjrCommonApplicant zyjrCommonApplicant)
    {
        return zyjrCommonApplicantMapper.updateZyjrCommonApplicant(zyjrCommonApplicant);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCommonApplicantByIds(Long[] ids)
    {
        return zyjrCommonApplicantMapper.deleteZyjrCommonApplicantByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCommonApplicantById(Long id)
    {
        return zyjrCommonApplicantMapper.deleteZyjrCommonApplicantById(id);
    }
}
