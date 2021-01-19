package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrMaterials;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-19
 */
public interface ZyjrMaterialsMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrMaterials selectZyjrMaterialsById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrMaterials 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrMaterials> selectZyjrMaterialsList(ZyjrMaterials zyjrMaterials);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrMaterials 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrMaterials(ZyjrMaterials zyjrMaterials);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrMaterials 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrMaterials(ZyjrMaterials zyjrMaterials);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrMaterialsById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrMaterialsByIds(Long[] ids);
}
