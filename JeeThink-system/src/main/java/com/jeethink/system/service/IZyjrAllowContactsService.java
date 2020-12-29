package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrAllowContacts;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public interface IZyjrAllowContactsService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrAllowContacts selectZyjrAllowContactsById(Long userId,String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrAllowContacts 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrAllowContacts> selectZyjrAllowContactsList(ZyjrAllowContacts zyjrAllowContacts);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrAllowContacts 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrAllowContacts(ZyjrAllowContacts zyjrAllowContacts);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrAllowContacts 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrAllowContacts(ZyjrAllowContacts zyjrAllowContacts);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrAllowContactsByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrAllowContactsById(Long id);
}
