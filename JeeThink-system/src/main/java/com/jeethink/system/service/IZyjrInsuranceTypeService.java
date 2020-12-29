package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrInsuranceType;

/**
 * insuranceTypeService接口
 * 
 * @author jeethink
 * @date 2020-12-29
 */
public interface IZyjrInsuranceTypeService 
{
    /**
     * 查询insuranceType
     * 
     * @param id insuranceTypeID
     * @return insuranceType
     */
    public ZyjrInsuranceType selectZyjrInsuranceTypeById(Long id);

    /**
     * 查询insuranceType列表
     * 
     * @param zyjrInsuranceType insuranceType
     * @return insuranceType集合
     */
    public List<ZyjrInsuranceType> selectZyjrInsuranceTypeList(ZyjrInsuranceType zyjrInsuranceType);

    /**
     * 新增insuranceType
     * 
     * @param zyjrInsuranceType insuranceType
     * @return 结果
     */
    public Long insertZyjrInsuranceType(ZyjrInsuranceType zyjrInsuranceType);

    /**
     * 修改insuranceType
     * 
     * @param zyjrInsuranceType insuranceType
     * @return 结果
     */
    public int updateZyjrInsuranceType(ZyjrInsuranceType zyjrInsuranceType);

    /**
     * 批量删除insuranceType
     * 
     * @param ids 需要删除的insuranceTypeID
     * @return 结果
     */
    public int deleteZyjrInsuranceTypeByIds(Long[] ids);

    /**
     * 删除insuranceType信息
     * 
     * @param id insuranceTypeID
     * @return 结果
     */
    public int deleteZyjrInsuranceTypeById(Long id);
}
