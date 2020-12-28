package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrCar;
import com.jeethink.system.domain.vo.carVo;

/**
 * 车商信息Service接口
 * 
 * @author jeethink
 * @date 2020-12-14
 */
public interface IZyjrCarService 
{
    /**
     * 查询车商信息
     * 
     * @param id 车商信息ID
     * @return 车商信息
     */
    public ZyjrCar selectZyjrCarById(Long id);

    /**
     * 查询车商信息列表
     * 
     * @param zyjrCar 车商信息
     * @return 车商信息集合
     */
    public List<ZyjrCar> selectZyjrCarList(ZyjrCar zyjrCar);

    public List<ZyjrCar> selectZyjrCarLists(String userId);
    /**
     * 新增车商信息
     * 
     * @param zyjrCar 车商信息
     * @return 结果
     */
    public int insertZyjrCar(ZyjrCar zyjrCar);

    /**
     * 修改车商信息
     * 
     * @param zyjrCar 车商信息
     * @return 结果
     */
    public int updateZyjrCar(ZyjrCar zyjrCar);

    /**
     * 批量删除车商信息
     * 
     * @param ids 需要删除的车商信息ID
     * @return 结果
     */
    public int deleteZyjrCarByIds(Long[] ids);

    /**
     * 删除车商信息信息
     * 
     * @param id 车商信息ID
     * @return 结果
     */
    public int deleteZyjrCarById(Long id);
}
