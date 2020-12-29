package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrPhotoHouse;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public interface ZyjrPhotoHouseMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrPhotoHouse selectZyjrPhotoHouseById(@Param("userId") Long userId, @Param("transactionCode") String transactionCode);

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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrPhotoHouseById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrPhotoHouseByIds(Long[] ids);
}
