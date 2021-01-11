package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrGrantImage;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2021-01-09
 */
public interface IZyjrGrantImageService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrGrantImage selectZyjrGrantImageById(String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrGrantImage 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrGrantImage> selectZyjrGrantImageList(ZyjrGrantImage zyjrGrantImage);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrGrantImage 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrGrantImage(ZyjrGrantImage zyjrGrantImage);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrGrantImage 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrGrantImage(ZyjrGrantImage zyjrGrantImage);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrGrantImageByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrGrantImageById(Long id);
}
