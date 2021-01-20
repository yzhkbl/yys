package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrCarType;

/**
 * carTypeMapper接口
 * 
 * @author jeethink
 * @date 2021-01-19
 */
public interface ZyjrCarTypeMapper 
{
    /**
     * 查询carType
     * 
     * @param id carTypeID
     * @return carType
     */
    public ZyjrCarType selectZyjrCarTypeById(Long id);

    /**
     * 查询carType列表
     * 
     * @param zyjrCarType carType
     * @return carType集合
     */
    public List<ZyjrCarType> selectZyjrCarTypeList(ZyjrCarType zyjrCarType);

    /**
     * 新增carType
     * 
     * @param zyjrCarType carType
     * @return 结果
     */
    public int insertZyjrCarType(ZyjrCarType zyjrCarType);

    /**
     * 修改carType
     * 
     * @param zyjrCarType carType
     * @return 结果
     */
    public int updateZyjrCarType(ZyjrCarType zyjrCarType);

    /**
     * 删除carType
     * 
     * @param id carTypeID
     * @return 结果
     */
    public int deleteZyjrCarTypeById(Long id);

    /**
     * 批量删除carType
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrCarTypeByIds(Long[] ids);
}
