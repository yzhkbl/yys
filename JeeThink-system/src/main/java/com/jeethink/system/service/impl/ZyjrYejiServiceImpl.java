package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrYejiMapper;
import com.jeethink.system.domain.ZyjrYeji;
import com.jeethink.system.service.IZyjrYejiService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-23
 */
@Service
public class ZyjrYejiServiceImpl implements IZyjrYejiService 
{
    @Autowired
    private ZyjrYejiMapper zyjrYejiMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrYeji selectZyjrYejiById(Long id)
    {
        return zyjrYejiMapper.selectZyjrYejiById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrYeji 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrYeji> selectZyjrYejiList(ZyjrYeji zyjrYeji)
    {
        return zyjrYejiMapper.selectZyjrYejiList(zyjrYeji);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrYeji 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrYeji(ZyjrYeji zyjrYeji)
    {
        zyjrYeji.setCreateTime(DateUtils.getNowDate());
        return zyjrYejiMapper.insertZyjrYeji(zyjrYeji);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrYeji 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrYeji(ZyjrYeji zyjrYeji)
    {
        zyjrYeji.setUpdateTime(DateUtils.getNowDate());
        return zyjrYejiMapper.updateZyjrYeji(zyjrYeji);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrYejiByIds(Long[] ids)
    {
        return zyjrYejiMapper.deleteZyjrYejiByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrYejiById(Long id)
    {
        return zyjrYejiMapper.deleteZyjrYejiById(id);
    }
}
