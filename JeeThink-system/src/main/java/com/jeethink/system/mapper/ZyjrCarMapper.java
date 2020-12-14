package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrCar;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2020-12-14
 */
public interface ZyjrCarMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrCar selectZyjrCarById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCar 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrCar> selectZyjrCarList(ZyjrCar zyjrCar);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCar 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrCar(ZyjrCar zyjrCar);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCar 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrCar(ZyjrCar zyjrCar);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCarById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrCarByIds(Long[] ids);
}
