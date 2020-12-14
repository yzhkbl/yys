package com.jeethink.system.controller.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrGuaranteeMapper;
import com.jeethink.system.domain.ZyjrGuarantee;
import com.jeethink.system.controller.service.IZyjrGuaranteeService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-10
 */
@Service
public class ZyjrGuaranteeServiceImpl implements IZyjrGuaranteeService 
{
    @Autowired
    private ZyjrGuaranteeMapper zyjrGuaranteeMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrGuarantee selectZyjrGuaranteeById(Integer id)
    {
        return zyjrGuaranteeMapper.selectZyjrGuaranteeById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrGuarantee 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrGuarantee> selectZyjrGuaranteeList(ZyjrGuarantee zyjrGuarantee)
    {
        return zyjrGuaranteeMapper.selectZyjrGuaranteeList(zyjrGuarantee);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrGuarantee 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrGuarantee(ZyjrGuarantee zyjrGuarantee)
    {
        return zyjrGuaranteeMapper.insertZyjrGuarantee(zyjrGuarantee);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrGuarantee 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrGuarantee(ZyjrGuarantee zyjrGuarantee)
    {
        return zyjrGuaranteeMapper.updateZyjrGuarantee(zyjrGuarantee);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrGuaranteeByIds(Integer[] ids)
    {
        return zyjrGuaranteeMapper.deleteZyjrGuaranteeByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrGuaranteeById(Integer id)
    {
        return zyjrGuaranteeMapper.deleteZyjrGuaranteeById(id);
    }
}
