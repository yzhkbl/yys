package com.jeethink.system.service.impl;

import java.util.HashMap;
import java.util.List;

import com.jeethink.system.domain.ZyjrAllowApplicant;
import com.jeethink.system.domain.ZyjrCard;
import com.jeethink.system.mapper.ZyjrCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrAllowApplicantMapper;
import com.jeethink.system.service.IZyjrAllowApplicantService;
import com.alibaba.fastjson.JSON;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@Service
public class ZyjrAllowApplicantServiceImpl implements IZyjrAllowApplicantService 
{
    @Autowired
    private ZyjrAllowApplicantMapper zyjrAllowApplicantMapper;
    @Autowired
    private ZyjrCardMapper zyjrCardMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrAllowApplicant selectZyjrAllowApplicantById(Long userId, String transactionCode)
    {
        ZyjrAllowApplicant zyjrAllowApplicant = zyjrAllowApplicantMapper.selectZyjrAllowApplicantById(userId, transactionCode);
        if(zyjrAllowApplicant.getIndustry()!=null){
            ZyjrCard a=zyjrCardMapper.selectZyjrCardByTransactionCode("1");
            String str= a.getAlmebno();
            HashMap hashMap = JSON.parseObject(str, HashMap.class);
            Object asd=hashMap.get(Integer.parseInt(zyjrAllowApplicant.getIndustry()));
            zyjrAllowApplicant.setIndustry(asd.toString());
        }
        return zyjrAllowApplicant;
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrAllowApplicant 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrAllowApplicant> selectZyjrAllowApplicantList(ZyjrAllowApplicant zyjrAllowApplicant)
    {
        return zyjrAllowApplicantMapper.selectZyjrAllowApplicantList(zyjrAllowApplicant);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrAllowApplicant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrAllowApplicant(ZyjrAllowApplicant zyjrAllowApplicant) {
        if(selectZyjrAllowApplicantById(zyjrAllowApplicant.getUserId(),zyjrAllowApplicant.getTransactionCode())==null) {
            return zyjrAllowApplicantMapper.insertZyjrAllowApplicant(zyjrAllowApplicant);
        }else{
            return zyjrAllowApplicantMapper.updateZyjrAllowApplicant(zyjrAllowApplicant);
        }
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrAllowApplicant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrAllowApplicant(ZyjrAllowApplicant zyjrAllowApplicant)
    {
        return zyjrAllowApplicantMapper.updateZyjrAllowApplicant(zyjrAllowApplicant);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrAllowApplicantByIds(Long[] ids)
    {
        return zyjrAllowApplicantMapper.deleteZyjrAllowApplicantByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrAllowApplicantById(Long id)
    {
        return zyjrAllowApplicantMapper.deleteZyjrAllowApplicantById(id);
    }
}
