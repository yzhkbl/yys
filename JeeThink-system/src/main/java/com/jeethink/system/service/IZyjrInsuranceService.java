package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrInsurance;

/**
 * 123Service接口
 * 
 * @author jeethink
 * @date 2020-12-24
 */
public interface IZyjrInsuranceService 
{
    /**
     * 查询123
     * 
     * @param id 123ID
     * @return 123
     */
    public ZyjrInsurance selectZyjrInsuranceById(Long id);

    public ZyjrInsurance selectZyjrInsuranceByIds(String id);

    /**
     * 查询123列表
     * 
     * @param zyjrInsurance 123
     * @return 123集合
     */
    public List<ZyjrInsurance> selectZyjrInsuranceList(ZyjrInsurance zyjrInsurance);

    /**
     * 新增123
     * 
     * @param zyjrInsurance 123
     * @return 结果
     */
    public int insertZyjrInsurance(ZyjrInsurance zyjrInsurance);

    /**
     * 修改123
     * 
     * @param zyjrInsurance 123
     * @return 结果
     */
    public int updateZyjrInsurance(ZyjrInsurance zyjrInsurance);

    /**
     * 批量删除123
     * 
     * @param ids 需要删除的123ID
     * @return 结果
     */
    public int deleteZyjrInsuranceByIds(Long[] ids);

    /**
     * 删除123信息
     * 
     * @param id 123ID
     * @return 结果
     */
    public int deleteZyjrInsuranceById(Long id);
}
