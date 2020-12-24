package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrInsurance;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2020-12-23
 */
public interface ZyjrInsuranceMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrInsurance selectZyjrInsuranceById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrInsurance 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrInsurance> selectZyjrInsuranceList(ZyjrInsurance zyjrInsurance);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrInsurance 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrInsurance(ZyjrInsurance zyjrInsurance);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrInsurance 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrInsurance(ZyjrInsurance zyjrInsurance);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrInsuranceById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrInsuranceByIds(Long[] ids);
}
