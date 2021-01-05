package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrDaiqianAccout;
import com.jeethink.system.domain.ZyjrInsurance;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2021-01-05
 */
public interface IZyjrDaiqianAccoutService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrDaiqianAccout selectZyjrDaiqianAccoutById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDaiqianAccout 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrDaiqianAccout> selectZyjrDaiqianAccoutList(ZyjrDaiqianAccout zyjrDaiqianAccout);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDaiqianAccout 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrDaiqianAccout(ZyjrDaiqianAccout zyjrDaiqianAccout);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDaiqianAccout 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrDaiqianAccout(ZyjrDaiqianAccout zyjrDaiqianAccout);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaiqianAccoutByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDaiqianAccoutById(Long id);

    ZyjrDaiqianAccout selectZyjrDaiqianAccoutByIds(String transactionCode);
}
