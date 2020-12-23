package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrInsuranceMapper;
import com.jeethink.system.domain.ZyjrInsurance;
import com.jeethink.system.service.IZyjrInsuranceService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-23
 */
@Service
public class ZyjrInsuranceServiceImpl implements IZyjrInsuranceService 
{
    @Autowired
    private ZyjrInsuranceMapper zyjrInsuranceMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrInsurance selectZyjrInsuranceById(Long id)
    {
        return zyjrInsuranceMapper.selectZyjrInsuranceById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrInsurance 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrInsurance> selectZyjrInsuranceList(ZyjrInsurance zyjrInsurance)
    {
        return zyjrInsuranceMapper.selectZyjrInsuranceList(zyjrInsurance);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrInsurance 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrInsurance(ZyjrInsurance zyjrInsurance)
    {
        zyjrInsurance.setCreateTime(DateUtils.getNowDate());
        return zyjrInsuranceMapper.insertZyjrInsurance(zyjrInsurance);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrInsurance 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrInsurance(ZyjrInsurance zyjrInsurance)
    {
        zyjrInsurance.setUpdateTime(DateUtils.getNowDate());
        return zyjrInsuranceMapper.updateZyjrInsurance(zyjrInsurance);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrInsuranceByIds(Long[] ids)
    {
        return zyjrInsuranceMapper.deleteZyjrInsuranceByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrInsuranceById(Long id)
    {
        return zyjrInsuranceMapper.deleteZyjrInsuranceById(id);
    }
}
