package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrPhotoCredit;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public interface IZyjrPhotoCreditService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrPhotoCredit selectZyjrPhotoCreditById(Long userId,String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrPhotoCredit 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrPhotoCredit> selectZyjrPhotoCreditList(ZyjrPhotoCredit zyjrPhotoCredit);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrPhotoCredit 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrPhotoCredit(ZyjrPhotoCredit zyjrPhotoCredit);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrPhotoCredit 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrPhotoCredit(ZyjrPhotoCredit zyjrPhotoCredit);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrPhotoCreditByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrPhotoCreditById(Long id);
}
