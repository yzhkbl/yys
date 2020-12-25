package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrInsuranceType;

/**
 * 保险Service接口
 * 
 * @author jeethink
 * @date 2020-12-25
 */
public interface IZyjrInsuranceTypeService 
{
    /**
     * 查询保险
     * 
     * @param id 保险ID
     * @return 保险
     */
    public ZyjrInsuranceType selectZyjrInsuranceTypeById(Long id);

    /**
     * 查询保险列表
     * 
     * @param zyjrInsuranceType 保险
     * @return 保险集合
     */
    public List<ZyjrInsuranceType> selectZyjrInsuranceTypeList(ZyjrInsuranceType zyjrInsuranceType);

    /**
     * 新增保险
     * 
     * @param zyjrInsuranceType 保险
     * @return 结果
     */
    public int insertZyjrInsuranceType(ZyjrInsuranceType zyjrInsuranceType);

    /**
     * 修改保险
     * 
     * @param zyjrInsuranceType 保险
     * @return 结果
     */
    public int updateZyjrInsuranceType(ZyjrInsuranceType zyjrInsuranceType);

    /**
     * 批量删除保险
     * 
     * @param ids 需要删除的保险ID
     * @return 结果
     */
    public int deleteZyjrInsuranceTypeByIds(Long[] ids);

    /**
     * 删除保险信息
     * 
     * @param id 保险ID
     * @return 结果
     */
    public int deleteZyjrInsuranceTypeById(Long id);
}
