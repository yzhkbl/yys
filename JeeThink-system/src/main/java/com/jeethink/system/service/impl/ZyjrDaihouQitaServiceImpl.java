package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrDaihouQitaMapper;
import com.jeethink.system.domain.ZyjrDaihouQita;
import com.jeethink.system.service.IZyjrDaihouQitaService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-06
 */
@Service
public class ZyjrDaihouQitaServiceImpl implements IZyjrDaihouQitaService 
{
    @Autowired
    private ZyjrDaihouQitaMapper zyjrDaihouQitaMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrDaihouQita selectZyjrDaihouQitaById(Long id)
    {
        return zyjrDaihouQitaMapper.selectZyjrDaihouQitaById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaihouQita 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrDaihouQita> selectZyjrDaihouQitaList(ZyjrDaihouQita zyjrDaihouQita)
    {
        return zyjrDaihouQitaMapper.selectZyjrDaihouQitaList(zyjrDaihouQita);
    }



    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaihouQita 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrDaihouQita(ZyjrDaihouQita zyjrDaihouQita)
    {
        return zyjrDaihouQitaMapper.insertZyjrDaihouQita(zyjrDaihouQita);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaihouQita 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrDaihouQita(ZyjrDaihouQita zyjrDaihouQita)
    {
        return zyjrDaihouQitaMapper.updateZyjrDaihouQita(zyjrDaihouQita);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDaihouQitaByIds(Long[] ids)
    {
        return zyjrDaihouQitaMapper.deleteZyjrDaihouQitaByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrDaihouQitaById(Long id)
    {
        return zyjrDaihouQitaMapper.deleteZyjrDaihouQitaById(id);
    }
}
