package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrAllowContactsMapper;
import com.jeethink.system.domain.ZyjrAllowContacts;
import com.jeethink.system.service.IZyjrAllowContactsService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@Service
public class ZyjrAllowContactsServiceImpl implements IZyjrAllowContactsService 
{
    @Autowired
    private ZyjrAllowContactsMapper zyjrAllowContactsMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrAllowContacts selectZyjrAllowContactsById(Long userId,String transactionCode)
    {
        return zyjrAllowContactsMapper.selectZyjrAllowContactsById(userId, transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrAllowContacts 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrAllowContacts> selectZyjrAllowContactsList(ZyjrAllowContacts zyjrAllowContacts)
    {
        return zyjrAllowContactsMapper.selectZyjrAllowContactsList(zyjrAllowContacts);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrAllowContacts 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrAllowContacts(ZyjrAllowContacts zyjrAllowContacts)
    {
        if(selectZyjrAllowContactsById(zyjrAllowContacts.getUserId(),zyjrAllowContacts.getTransactionCode())==null) {
            return zyjrAllowContactsMapper.insertZyjrAllowContacts(zyjrAllowContacts);
        }else {
            return zyjrAllowContactsMapper.updateZyjrAllowContacts(zyjrAllowContacts);
        }
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrAllowContacts 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrAllowContacts(ZyjrAllowContacts zyjrAllowContacts)
    {
        return zyjrAllowContactsMapper.updateZyjrAllowContacts(zyjrAllowContacts);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrAllowContactsByIds(Long[] ids)
    {
        return zyjrAllowContactsMapper.deleteZyjrAllowContactsByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrAllowContactsById(Long id)
    {
        return zyjrAllowContactsMapper.deleteZyjrAllowContactsById(id);
    }
}
