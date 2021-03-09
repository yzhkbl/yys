package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrGrantImageMapper;
import com.jeethink.system.domain.ZyjrGrantImage;
import com.jeethink.system.service.IZyjrGrantImageService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-09
 */
@Service
public class ZyjrGrantImageServiceImpl implements IZyjrGrantImageService 
{
    @Autowired
    private ZyjrGrantImageMapper zyjrGrantImageMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrGrantImage selectZyjrGrantImageById(String transactionCode)
    {
        return zyjrGrantImageMapper.selectZyjrGrantImageById(transactionCode);
    }
    @Override
    public ZyjrGrantImage selectZyjrGrantImageById2(String transactionCode)
    {
        return zyjrGrantImageMapper.selectZyjrGrantImageById2(transactionCode);
    }
    @Override
    public ZyjrGrantImage selectZyjrGrantImageById3(String transactionCode)
    {
        return zyjrGrantImageMapper.selectZyjrGrantImageById3(transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrGrantImage 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrGrantImage> selectZyjrGrantImageList(ZyjrGrantImage zyjrGrantImage)
    {
        return zyjrGrantImageMapper.selectZyjrGrantImageList(zyjrGrantImage);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrGrantImage 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrGrantImage(ZyjrGrantImage zyjrGrantImage)
    {
        return zyjrGrantImageMapper.insertZyjrGrantImage(zyjrGrantImage);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrGrantImage 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrGrantImage(ZyjrGrantImage zyjrGrantImage)
    {
        return zyjrGrantImageMapper.updateZyjrGrantImage(zyjrGrantImage);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrGrantImageByIds(Long[] ids)
    {
        return zyjrGrantImageMapper.deleteZyjrGrantImageByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrGrantImageById(Long id)
    {
        return zyjrGrantImageMapper.deleteZyjrGrantImageById(id);
    }
}
