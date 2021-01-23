package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrFangkuanpic;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-22
 */
public interface ZyjrFangkuanpicMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrFangkuanpic selectZyjrFangkuanpicById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrFangkuanpic 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrFangkuanpic> selectZyjrFangkuanpicList(ZyjrFangkuanpic zyjrFangkuanpic);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrFangkuanpic 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrFangkuanpic(ZyjrFangkuanpic zyjrFangkuanpic);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrFangkuanpic 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrFangkuanpic(ZyjrFangkuanpic zyjrFangkuanpic);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrFangkuanpicById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrFangkuanpicByIds(Long[] ids);
}
