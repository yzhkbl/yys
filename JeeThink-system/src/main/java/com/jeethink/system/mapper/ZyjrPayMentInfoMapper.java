package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrPayMentInfo;

/**
 * mentInfoMapper接口
 * 
 * @author jeethink
 * @date 2021-01-19
 */
public interface ZyjrPayMentInfoMapper 
{
    /**
     * 查询mentInfo
     * 
     * @param id mentInfoID
     * @return mentInfo
     */
    public ZyjrPayMentInfo selectZyjrPayMentInfoById(Long id);

    /**
     * 查询mentInfo列表
     * 
     * @param zyjrPayMentInfo mentInfo
     * @return mentInfo集合
     */
    public List<ZyjrPayMentInfo> selectZyjrPayMentInfoList(ZyjrPayMentInfo zyjrPayMentInfo);

    /**
     * 新增mentInfo
     * 
     * @param zyjrPayMentInfo mentInfo
     * @return 结果
     */
    public int insertZyjrPayMentInfo(ZyjrPayMentInfo zyjrPayMentInfo);

    /**
     * 修改mentInfo
     * 
     * @param zyjrPayMentInfo mentInfo
     * @return 结果
     */
    public int updateZyjrPayMentInfo(ZyjrPayMentInfo zyjrPayMentInfo);

    /**
     * 删除mentInfo
     * 
     * @param id mentInfoID
     * @return 结果
     */
    public int deleteZyjrPayMentInfoById(Long id);

    /**
     * 批量删除mentInfo
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrPayMentInfoByIds(Long[] ids);
}
