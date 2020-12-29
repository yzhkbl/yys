package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrPhotoHouse;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public interface IZyjrPhotoHouseService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrPhotoHouse selectZyjrPhotoHouseById(Long userId,String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrPhotoHouse 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrPhotoHouse> selectZyjrPhotoHouseList(ZyjrPhotoHouse zyjrPhotoHouse);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrPhotoHouse 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrPhotoHouse(ZyjrPhotoHouse zyjrPhotoHouse);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrPhotoHouse 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrPhotoHouse(ZyjrPhotoHouse zyjrPhotoHouse);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrPhotoHouseByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrPhotoHouseById(Long id);
}
