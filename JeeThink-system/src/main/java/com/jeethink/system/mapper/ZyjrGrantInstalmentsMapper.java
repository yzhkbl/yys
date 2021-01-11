package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrGrantInstalments;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-09
 */
public interface ZyjrGrantInstalmentsMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrGrantInstalments selectZyjrGrantInstalmentsById(String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrGrantInstalments 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrGrantInstalments> selectZyjrGrantInstalmentsList(ZyjrGrantInstalments zyjrGrantInstalments);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrGrantInstalments 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrGrantInstalments(ZyjrGrantInstalments zyjrGrantInstalments);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrGrantInstalments 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrGrantInstalments(ZyjrGrantInstalments zyjrGrantInstalments);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrGrantInstalmentsById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrGrantInstalmentsByIds(Long[] ids);
}
