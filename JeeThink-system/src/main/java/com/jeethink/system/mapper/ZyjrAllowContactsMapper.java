package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrAllowContacts;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public interface ZyjrAllowContactsMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrAllowContacts selectZyjrAllowContactsById(@Param("userId") Long userId, @Param("transactionCode") String transactionCode);

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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrAllowContactsById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrAllowContactsByIds(Long[] ids);

    ZyjrAllowContacts selectById(String transactionCode);
}
