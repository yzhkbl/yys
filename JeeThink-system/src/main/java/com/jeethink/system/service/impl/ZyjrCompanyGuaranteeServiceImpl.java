package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrCompanyGuaranteeMapper;
import com.jeethink.system.domain.ZyjrCompanyGuarantee;
import com.jeethink.system.service.IZyjrCompanyGuaranteeService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@Service
public class ZyjrCompanyGuaranteeServiceImpl implements IZyjrCompanyGuaranteeService 
{
    @Autowired
    private ZyjrCompanyGuaranteeMapper zyjrCompanyGuaranteeMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrCompanyGuarantee> selectZyjrCompanyGuaranteeById(Long userId,String transactionCode)
    {
        List<ZyjrCompanyGuarantee> list = zyjrCompanyGuaranteeMapper.selectZyjrCompanyGuaranteeById(userId,transactionCode);
        return list;
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCompanyGuarantee 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrCompanyGuarantee> selectZyjrCompanyGuaranteeList(ZyjrCompanyGuarantee zyjrCompanyGuarantee)
    {
        return zyjrCompanyGuaranteeMapper.selectZyjrCompanyGuaranteeList(zyjrCompanyGuarantee);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCompanyGuarantee 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrCompanyGuarantee(ZyjrCompanyGuarantee zyjrCompanyGuarantee)
    {
        if(selectZyjrCompanyGuaranteeById(zyjrCompanyGuarantee.getUserId(),zyjrCompanyGuarantee.getTransactionCode())==null) {
            return zyjrCompanyGuaranteeMapper.insertZyjrCompanyGuarantee(zyjrCompanyGuarantee);
        }else {
            return zyjrCompanyGuaranteeMapper.updateZyjrCompanyGuarantee(zyjrCompanyGuarantee);
        }
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCompanyGuarantee 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrCompanyGuarantee(ZyjrCompanyGuarantee zyjrCompanyGuarantee)
    {
        return zyjrCompanyGuaranteeMapper.updateZyjrCompanyGuarantee(zyjrCompanyGuarantee);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCompanyGuaranteeByIds(Long[] ids)
    {
        return zyjrCompanyGuaranteeMapper.deleteZyjrCompanyGuaranteeByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCompanyGuaranteeById(Long id)
    {
        return zyjrCompanyGuaranteeMapper.deleteZyjrCompanyGuaranteeById(id);
    }
}
