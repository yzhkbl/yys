package com.jeethink.system.controller.service;

import java.util.List;

import com.jeethink.system.domain.ZyjrBusiness;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-09
 */
public interface IZyjrBusinessService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrBusiness selectZyjrBusinessById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrBusiness 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrBusiness> selectZyjrBusinessList(ZyjrBusiness zyjrBusiness);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrBusiness 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrBusiness(ZyjrBusiness zyjrBusiness);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrBusiness 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrBusiness(ZyjrBusiness zyjrBusiness);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrBusinessByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrBusinessById(Long id);

	/*public Map<String, Object> seleMap(String id);*/
}
