package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrPhotoHouseMapper;
import com.jeethink.system.domain.ZyjrPhotoHouse;
import com.jeethink.system.service.IZyjrPhotoHouseService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@Service
public class ZyjrPhotoHouseServiceImpl implements IZyjrPhotoHouseService 
{
    @Autowired
    private ZyjrPhotoHouseMapper zyjrPhotoHouseMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrPhotoHouse selectZyjrPhotoHouseById(Long userId,String transactionCode)
    {
        return zyjrPhotoHouseMapper.selectZyjrPhotoHouseById(userId, transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrPhotoHouse 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrPhotoHouse> selectZyjrPhotoHouseList(ZyjrPhotoHouse zyjrPhotoHouse)
    {
        return zyjrPhotoHouseMapper.selectZyjrPhotoHouseList(zyjrPhotoHouse);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrPhotoHouse 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrPhotoHouse(ZyjrPhotoHouse zyjrPhotoHouse)
    {
        return zyjrPhotoHouseMapper.insertZyjrPhotoHouse(zyjrPhotoHouse);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrPhotoHouse 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrPhotoHouse(ZyjrPhotoHouse zyjrPhotoHouse)
    {
        return zyjrPhotoHouseMapper.updateZyjrPhotoHouse(zyjrPhotoHouse);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrPhotoHouseByIds(Long[] ids)
    {
        return zyjrPhotoHouseMapper.deleteZyjrPhotoHouseByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrPhotoHouseById(Long id)
    {
        return zyjrPhotoHouseMapper.deleteZyjrPhotoHouseById(id);
    }
}
