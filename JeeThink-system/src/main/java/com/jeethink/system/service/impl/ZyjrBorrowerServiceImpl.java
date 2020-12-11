package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrBorrowerMapper;
import com.jeethink.system.domain.ZyjrBorrower;
import com.jeethink.system.service.IZyjrBorrowerService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-10
 */
@Service
public class ZyjrBorrowerServiceImpl implements IZyjrBorrowerService 
{
    @Autowired
    private ZyjrBorrowerMapper zyjrBorrowerMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrBorrower selectZyjrBorrowerById(Integer id)
    {
        return zyjrBorrowerMapper.selectZyjrBorrowerById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrBorrower 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrBorrower> selectZyjrBorrowerList(ZyjrBorrower zyjrBorrower)
    {
        return zyjrBorrowerMapper.selectZyjrBorrowerList(zyjrBorrower);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrBorrower 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrBorrower(ZyjrBorrower zyjrBorrower)
    {
        zyjrBorrower.setCreateTime(DateUtils.getNowDate());
        return zyjrBorrowerMapper.insertZyjrBorrower(zyjrBorrower);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrBorrower 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrBorrower(ZyjrBorrower zyjrBorrower)
    {
        zyjrBorrower.setUpdateTime(DateUtils.getNowDate());
        return zyjrBorrowerMapper.updateZyjrBorrower(zyjrBorrower);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrBorrowerByIds(Integer[] ids)
    {
        return zyjrBorrowerMapper.deleteZyjrBorrowerByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrBorrowerById(Integer id)
    {
        return zyjrBorrowerMapper.deleteZyjrBorrowerById(id);
    }
}
