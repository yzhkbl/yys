package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrDaiqianAccoutMapper;
import com.jeethink.system.domain.ZyjrDaiqianAccout;
import com.jeethink.system.service.IZyjrDaiqianAccoutService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-05
 */
@Service
public class ZyjrDaiqianAccoutServiceImpl implements IZyjrDaiqianAccoutService 
{
    @Autowired
    private ZyjrDaiqianAccoutMapper zyjrDaiqianAccoutMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrDaiqianAccout selectZyjrDaiqianAccoutById(Long id)
    {
        return zyjrDaiqianAccoutMapper.selectZyjrDaiqianAccoutById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaiqianAccout 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrDaiqianAccout> selectZyjrDaiqianAccoutList(ZyjrDaiqianAccout zyjrDaiqianAccout)
    {
        return zyjrDaiqianAccoutMapper.selectZyjrDaiqianAccoutList(zyjrDaiqianAccout);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaiqianAccout 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrDaiqianAccout(ZyjrDaiqianAccout zyjrDaiqianAccout)
    {
        return zyjrDaiqianAccoutMapper.insertZyjrDaiqianAccout(zyjrDaiqianAccout);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaiqianAccout 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrDaiqianAccout(ZyjrDaiqianAccout zyjrDaiqianAccout)
    {
        return zyjrDaiqianAccoutMapper.updateZyjrDaiqianAccout(zyjrDaiqianAccout);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDaiqianAccoutByIds(Long[] ids)
    {
        return zyjrDaiqianAccoutMapper.deleteZyjrDaiqianAccoutByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDaiqianAccoutById(Long id)
    {
        return zyjrDaiqianAccoutMapper.deleteZyjrDaiqianAccoutById(id);
    }

    @Override
    public ZyjrDaiqianAccout selectZyjrDaiqianAccoutByIds(String transactionCode) {
        ZyjrDaiqianAccout a=zyjrDaiqianAccoutMapper.selectById(transactionCode);
        return a;
    }
}
