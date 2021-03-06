package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrDaiqianAccout;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-05
 */
public interface ZyjrDaiqianAccoutMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrDaiqianAccout selectZyjrDaiqianAccoutById(Long id);
    public ZyjrDaiqianAccout selectById(String id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaiqianAccout 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrDaiqianAccout> selectZyjrDaiqianAccoutList(ZyjrDaiqianAccout zyjrDaiqianAccout);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaiqianAccout 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrDaiqianAccout(ZyjrDaiqianAccout zyjrDaiqianAccout);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaiqianAccout 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrDaiqianAccout(ZyjrDaiqianAccout zyjrDaiqianAccout);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaiqianAccoutById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrDaiqianAccoutByIds(Long[] ids);
}
