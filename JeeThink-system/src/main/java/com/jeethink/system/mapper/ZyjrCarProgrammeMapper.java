package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrCarProgramme;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-03-16
 */
public interface ZyjrCarProgrammeMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrCarProgramme selectZyjrCarProgrammeById(Integer id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCarProgramme 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrCarProgramme> selectZyjrCarProgrammeList(ZyjrCarProgramme zyjrCarProgramme);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCarProgramme 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrCarProgramme(ZyjrCarProgramme zyjrCarProgramme);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCarProgramme 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrCarProgramme(ZyjrCarProgramme zyjrCarProgramme);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCarProgrammeById(Integer id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrCarProgrammeByIds(Integer[] ids);
}
