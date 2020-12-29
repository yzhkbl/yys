package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrPhotoCar;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public interface IZyjrPhotoCarService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrPhotoCar selectZyjrPhotoCarById(Long userId,String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrPhotoCar 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrPhotoCar> selectZyjrPhotoCarList(ZyjrPhotoCar zyjrPhotoCar);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrPhotoCar 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrPhotoCar(ZyjrPhotoCar zyjrPhotoCar);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrPhotoCar 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrPhotoCar(ZyjrPhotoCar zyjrPhotoCar);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrPhotoCarByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrPhotoCarById(Long id);
}
