package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrStageInfo;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-19
 */
public interface ZyjrStagingInformationMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrStageInfo selectZyjrStagingInformationById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrStageInfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrStageInfo> selectZyjrStagingInformationList(ZyjrStageInfo zyjrStageInfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrStageInfo 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrStagingInformation(ZyjrStageInfo zyjrStageInfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrStageInfo 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrStagingInformation(ZyjrStageInfo zyjrStageInfo);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrStagingInformationById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrStagingInformationByIds(Long[] ids);
}
