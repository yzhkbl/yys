package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrCailiao;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2021-01-15
 */
public interface IZyjrCailiaoService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrCailiao selectZyjrCailiaoById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCailiao 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrCailiao> selectZyjrCailiaoList(ZyjrCailiao zyjrCailiao);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCailiao 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrCailiao(ZyjrCailiao zyjrCailiao);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCailiao 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrCailiao(ZyjrCailiao zyjrCailiao);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCailiaoByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCailiaoById(Long id);
}
