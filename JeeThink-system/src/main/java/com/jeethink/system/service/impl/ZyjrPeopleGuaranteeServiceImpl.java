package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrPeopleGuaranteeMapper;
import com.jeethink.system.domain.ZyjrPeopleGuarantee;
import com.jeethink.system.service.IZyjrPeopleGuaranteeService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@Service
public class ZyjrPeopleGuaranteeServiceImpl implements IZyjrPeopleGuaranteeService 
{
    @Autowired
    private ZyjrPeopleGuaranteeMapper zyjrPeopleGuaranteeMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrPeopleGuarantee selectZyjrPeopleGuaranteeById(Long userId,String transactionCode)
    {
        return zyjrPeopleGuaranteeMapper.selectZyjrPeopleGuaranteeById(userId,transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrPeopleGuarantee 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrPeopleGuarantee> selectZyjrPeopleGuaranteeList(ZyjrPeopleGuarantee zyjrPeopleGuarantee)
    {
        return zyjrPeopleGuaranteeMapper.selectZyjrPeopleGuaranteeList(zyjrPeopleGuarantee);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrPeopleGuarantee 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrPeopleGuarantee(ZyjrPeopleGuarantee zyjrPeopleGuarantee)
    {
        if(selectZyjrPeopleGuaranteeById(zyjrPeopleGuarantee.getUserId(),zyjrPeopleGuarantee.getTransactionCode())==null) {
            return zyjrPeopleGuaranteeMapper.insertZyjrPeopleGuarantee(zyjrPeopleGuarantee);
        }else {
            return zyjrPeopleGuaranteeMapper.updateZyjrPeopleGuarantee(zyjrPeopleGuarantee);
        }
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrPeopleGuarantee 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrPeopleGuarantee(ZyjrPeopleGuarantee zyjrPeopleGuarantee)
    {
        return zyjrPeopleGuaranteeMapper.updateZyjrPeopleGuarantee(zyjrPeopleGuarantee);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrPeopleGuaranteeByIds(Long[] ids)
    {
        return zyjrPeopleGuaranteeMapper.deleteZyjrPeopleGuaranteeByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrPeopleGuaranteeById(Long id)
    {
        return zyjrPeopleGuaranteeMapper.deleteZyjrPeopleGuaranteeById(id);
    }
}
