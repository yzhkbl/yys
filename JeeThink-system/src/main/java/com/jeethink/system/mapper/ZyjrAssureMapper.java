package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrAssure;

/**
 * assureMapper接口
 * 
 * @author jeethink
 * @date 2020-12-25
 */
public interface ZyjrAssureMapper 
{
    /**
     * 查询assure
     * 
     * @param id assureID
     * @return assure
     */
    public ZyjrAssure selectZyjrAssureById(Long id);

    /**
     * 查询assure列表
     * 
     * @param zyjrAssure assure
     * @return assure集合
     */
    public List<ZyjrAssure> selectZyjrAssureList(ZyjrAssure zyjrAssure);

    /**
     * 新增assure
     * 
     * @param zyjrAssure assure
     * @return 结果
     */
    public int insertZyjrAssure(ZyjrAssure zyjrAssure);

    /**
     * 修改assure
     * 
     * @param zyjrAssure assure
     * @return 结果
     */
    public int updateZyjrAssure(ZyjrAssure zyjrAssure);

    /**
     * 删除assure
     * 
     * @param id assureID
     * @return 结果
     */
    public int deleteZyjrAssureById(Long id);

    /**
     * 批量删除assure
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrAssureByIds(Long[] ids);
}
