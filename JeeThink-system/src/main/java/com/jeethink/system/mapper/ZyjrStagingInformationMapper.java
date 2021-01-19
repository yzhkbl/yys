package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrStagingInformation;

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
    public ZyjrStagingInformation selectZyjrStagingInformationById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrStagingInformation 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrStagingInformation> selectZyjrStagingInformationList(ZyjrStagingInformation zyjrStagingInformation);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrStagingInformation 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrStagingInformation(ZyjrStagingInformation zyjrStagingInformation);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrStagingInformation 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrStagingInformation(ZyjrStagingInformation zyjrStagingInformation);

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
