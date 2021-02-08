package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrOverdueNew;
import com.jeethink.system.domain.vo.BorrowerVo;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-29
 */
public interface ZyjrOverdueNewMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrOverdueNew selectZyjrOverdueNewById(String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrOverdueNew 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrOverdueNew> selectZyjrOverdueNewList(ZyjrOverdueNew zyjrOverdueNew);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrOverdueNew 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrOverdueNew(ZyjrOverdueNew zyjrOverdueNew);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrOverdueNew 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrOverdueNew(ZyjrOverdueNew zyjrOverdueNew);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrOverdueNewById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrOverdueNewByIds(Long[] ids);

    ZyjrOverdueNew findOverdue(String transactionCode);
    //OverdueCar findCar(String transactionCode);
    BorrowerVo findBorrower(String transactionCode);
}
