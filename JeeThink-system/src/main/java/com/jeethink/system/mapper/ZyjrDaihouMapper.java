package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrDaihou;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-06
 */
public interface ZyjrDaihouMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrDaihou selectZyjrDaihouById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaihou 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrDaihou> selectZyjrDaihouList(ZyjrDaihou zyjrDaihou);
    public List<ZyjrDaihou> selectZyjrDaihouLists(ZyjrDaihou zyjrDaihou);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaihou 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrDaihou(ZyjrDaihou zyjrDaihou);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaihou 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrDaihou(ZyjrDaihou zyjrDaihou);
    public int updateZyjrDaihou2(ZyjrDaihou zyjrDaihou);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaihouById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrDaihouByIds(Long[] ids);

    ZyjrDaihou selectZyjrDaihouByT(String daihou);

    int updateZyjrDaihous(ZyjrDaihou zyjrDaihou);
}
