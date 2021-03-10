package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrGrant2;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2021-03-10
 */
public interface IZyjrGrantService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrGrant2 selectZyjrGrantById(String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrGrant 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrGrant2> selectZyjrGrantList(ZyjrGrant2 zyjrGrant);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrGrant 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrGrant(ZyjrGrant2 zyjrGrant);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrGrant 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrGrant(ZyjrGrant2 zyjrGrant);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrGrantByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrGrantById(Long id);
}
