package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrAllowOpinion;

/**
 * 【请填写功能名称】Service接口
 *
 * @author jeethink
 * @date 2021-01-04
 */
public interface IZyjrAllowOpinionService
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrAllowOpinion selectZyjrAllowOpinionById(String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param zyjrAllowOpinion 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrAllowOpinion> selectZyjrAllowOpinionList(ZyjrAllowOpinion zyjrAllowOpinion);

    /**
     * 新增【请填写功能名称】
     *
     * @param zyjrAllowOpinion 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrAllowOpinion(ZyjrAllowOpinion zyjrAllowOpinion);

    /**
     * 修改【请填写功能名称】
     *
     * @param zyjrAllowOpinion 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrAllowOpinion(ZyjrAllowOpinion zyjrAllowOpinion);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrAllowOpinionByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     *
     * @param transactionCode 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrAllowOpinionById(String transactionCode);
}
