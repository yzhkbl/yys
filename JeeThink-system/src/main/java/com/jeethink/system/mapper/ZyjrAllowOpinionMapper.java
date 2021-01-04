package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrAllowOpinion;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-04
 */
public interface ZyjrAllowOpinionMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrAllowOpinion selectZyjrAllowOpinionById(Long id);

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
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrAllowOpinionById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrAllowOpinionByIds(Long[] ids);


    //public int updateOrderState(Long userId,String transactionCode);
}
