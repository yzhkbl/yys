package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrDaihouQita;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-06
 */
public interface ZyjrDaihouQitaMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrDaihouQita selectZyjrDaihouQitaById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaihouQita 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrDaihouQita> selectZyjrDaihouQitaList(ZyjrDaihouQita zyjrDaihouQita);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaihouQita 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrDaihouQita(ZyjrDaihouQita zyjrDaihouQita);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaihouQita 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrDaihouQita(ZyjrDaihouQita zyjrDaihouQita);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaihouQitaById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrDaihouQitaByIds(Long[] ids);
}
