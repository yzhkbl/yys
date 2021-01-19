package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrGuaranteeinfo;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-19
 */
public interface ZyjrGuaranteeinfoMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrGuaranteeinfo selectZyjrGuaranteeinfoById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrGuaranteeinfo 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrGuaranteeinfo> selectZyjrGuaranteeinfoList(ZyjrGuaranteeinfo zyjrGuaranteeinfo);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrGuaranteeinfo 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrGuaranteeinfo(ZyjrGuaranteeinfo zyjrGuaranteeinfo);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrGuaranteeinfo 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrGuaranteeinfo(ZyjrGuaranteeinfo zyjrGuaranteeinfo);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrGuaranteeinfoById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrGuaranteeinfoByIds(Long[] ids);
}
