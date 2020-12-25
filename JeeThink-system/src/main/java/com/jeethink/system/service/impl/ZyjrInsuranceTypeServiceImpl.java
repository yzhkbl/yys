package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrInsuranceTypeMapper;
import com.jeethink.system.domain.ZyjrInsuranceType;
import com.jeethink.system.service.IZyjrInsuranceTypeService;

/**
 * 保险Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-25
 */
@Service
public class ZyjrInsuranceTypeServiceImpl implements IZyjrInsuranceTypeService 
{
    @Autowired
    private ZyjrInsuranceTypeMapper zyjrInsuranceTypeMapper;

    /**
     * 查询保险
     * 
     * @param id 保险ID
     * @return 保险
     */
    @Override
    public ZyjrInsuranceType selectZyjrInsuranceTypeById(Long id)
    {
        return zyjrInsuranceTypeMapper.selectZyjrInsuranceTypeById(id);
    }

    /**
     * 查询保险列表
     * 
     * @param zyjrInsuranceType 保险
     * @return 保险
     */
    @Override
    public List<ZyjrInsuranceType> selectZyjrInsuranceTypeList(ZyjrInsuranceType zyjrInsuranceType)
    {
        return zyjrInsuranceTypeMapper.selectZyjrInsuranceTypeList(zyjrInsuranceType);
    }

    /**
     * 新增保险
     * 
     * @param zyjrInsuranceType 保险
     * @return 结果
     */
    @Override
    public int insertZyjrInsuranceType(ZyjrInsuranceType zyjrInsuranceType)
    {
        zyjrInsuranceType.setCreateTime(DateUtils.getNowDate());
        return zyjrInsuranceTypeMapper.insertZyjrInsuranceType(zyjrInsuranceType);
    }

    /**
     * 修改保险
     * 
     * @param zyjrInsuranceType 保险
     * @return 结果
     */
    @Override
    public int updateZyjrInsuranceType(ZyjrInsuranceType zyjrInsuranceType)
    {
        zyjrInsuranceType.setUpdateTime(DateUtils.getNowDate());
        return zyjrInsuranceTypeMapper.updateZyjrInsuranceType(zyjrInsuranceType);
    }

    /**
     * 批量删除保险
     * 
     * @param ids 需要删除的保险ID
     * @return 结果
     */
    @Override
    public int deleteZyjrInsuranceTypeByIds(Long[] ids)
    {
        return zyjrInsuranceTypeMapper.deleteZyjrInsuranceTypeByIds(ids);
    }

    /**
     * 删除保险信息
     * 
     * @param id 保险ID
     * @return 结果
     */
    @Override
    public int deleteZyjrInsuranceTypeById(Long id)
    {
        return zyjrInsuranceTypeMapper.deleteZyjrInsuranceTypeById(id);
    }
}
