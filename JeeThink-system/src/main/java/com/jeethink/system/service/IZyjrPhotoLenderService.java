package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrPhotoLender;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public interface IZyjrPhotoLenderService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrPhotoLender selectZyjrPhotoLenderById(Long userId,String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrPhotoLender 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrPhotoLender> selectZyjrPhotoLenderList(ZyjrPhotoLender zyjrPhotoLender);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrPhotoLender 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrPhotoLender(ZyjrPhotoLender zyjrPhotoLender);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrPhotoLender 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrPhotoLender(ZyjrPhotoLender zyjrPhotoLender);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrPhotoLenderByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrPhotoLenderById(Long id);
}
