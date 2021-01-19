package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrMates;

/**
 * matesMapper接口
 * 
 * @author jeethink
 * @date 2021-01-19
 */
public interface ZyjrMatesMapper 
{
    /**
     * 查询mates
     * 
     * @param demandMateId matesID
     * @return mates
     */
    public ZyjrMates selectZyjrMatesById(Long demandMateId);

    /**
     * 查询mates列表
     * 
     * @param zyjrMates mates
     * @return mates集合
     */
    public List<ZyjrMates> selectZyjrMatesList(ZyjrMates zyjrMates);

    /**
     * 新增mates
     * 
     * @param zyjrMates mates
     * @return 结果
     */
    public int insertZyjrMates(ZyjrMates zyjrMates);

    /**
     * 修改mates
     * 
     * @param zyjrMates mates
     * @return 结果
     */
    public int updateZyjrMates(ZyjrMates zyjrMates);

    /**
     * 删除mates
     * 
     * @param demandMateId matesID
     * @return 结果
     */
    public int deleteZyjrMatesById(Long demandMateId);

    /**
     * 批量删除mates
     * 
     * @param demandMateIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrMatesByIds(Long[] demandMateIds);
}
