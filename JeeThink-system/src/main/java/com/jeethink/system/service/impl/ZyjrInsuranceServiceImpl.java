package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrInsuranceMapper;
import com.jeethink.system.domain.ZyjrInsurance;
import com.jeethink.system.service.IZyjrInsuranceService;

/**
 * 123Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-24
 */
@Service
public class ZyjrInsuranceServiceImpl implements IZyjrInsuranceService 
{
    @Autowired
    private ZyjrInsuranceMapper zyjrInsuranceMapper;

    /**
     * 查询123
     * 
     * @param id 123ID
     * @return 123
     */
    @Override
    public ZyjrInsurance selectZyjrInsuranceById(Long id)
    {
        return zyjrInsuranceMapper.selectZyjrInsuranceById(id);
    }

    public ZyjrInsurance selectZyjrInsuranceByIds(String id)
    {
        return zyjrInsuranceMapper.selectZyjrInsuranceByIds(id);
    }

    /**
     * 查询123列表
     * 
     * @param zyjrInsurance 123
     * @return 123
     */
    @Override
    public List<ZyjrInsurance> selectZyjrInsuranceList(ZyjrInsurance zyjrInsurance)
    {
        return zyjrInsuranceMapper.selectZyjrInsuranceList(zyjrInsurance);
    }


    /**
     * 新增123
     * 
     * @param zyjrInsurance 123
     * @return 结果
     */
    @Override
    public int insertZyjrInsurance(ZyjrInsurance zyjrInsurance)
    {
        zyjrInsurance.setCreateTime(DateUtils.getNowDate());
        return zyjrInsuranceMapper.insertZyjrInsurance(zyjrInsurance);
    }

    /**
     * 修改123
     * 
     * @param zyjrInsurance 123
     * @return 结果
     */
    @Override
    public int updateZyjrInsurance(ZyjrInsurance zyjrInsurance)
    {
        zyjrInsurance.setUpdateTime(DateUtils.getNowDate());
        return zyjrInsuranceMapper.updateZyjrInsurance(zyjrInsurance);
    }

    /**
     * 批量删除123
     * 
     * @param ids 需要删除的123ID
     * @return 结果
     */
    @Override
    public int deleteZyjrInsuranceByIds(Long[] ids)
    {
        return zyjrInsuranceMapper.deleteZyjrInsuranceByIds(ids);
    }

    /**
     * 删除123信息
     * 
     * @param id 123ID
     * @return 结果
     */
    @Override
    public int deleteZyjrInsuranceById(Long id)
    {
        return zyjrInsuranceMapper.deleteZyjrInsuranceById(id);
    }
}
