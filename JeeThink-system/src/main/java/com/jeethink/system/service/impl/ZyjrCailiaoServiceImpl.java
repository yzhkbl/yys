package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrCailiaoMapper;
import com.jeethink.system.domain.ZyjrCailiao;
import com.jeethink.system.service.IZyjrCailiaoService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-15
 */
@Service
public class ZyjrCailiaoServiceImpl implements IZyjrCailiaoService 
{
    @Autowired
    private ZyjrCailiaoMapper zyjrCailiaoMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrCailiao selectZyjrCailiaoById(Long id)
    {
        return zyjrCailiaoMapper.selectZyjrCailiaoById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCailiao 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrCailiao> selectZyjrCailiaoList(ZyjrCailiao zyjrCailiao)
    {
        return zyjrCailiaoMapper.selectZyjrCailiaoList(zyjrCailiao);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCailiao 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrCailiao(ZyjrCailiao zyjrCailiao)
    {
        return zyjrCailiaoMapper.insertZyjrCailiao(zyjrCailiao);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCailiao 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrCailiao(ZyjrCailiao zyjrCailiao)
    {
        return zyjrCailiaoMapper.updateZyjrCailiao(zyjrCailiao);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCailiaoByIds(Long[] ids)
    {
        return zyjrCailiaoMapper.deleteZyjrCailiaoByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCailiaoById(Long id)
    {
        return zyjrCailiaoMapper.deleteZyjrCailiaoById(id);
    }
}
