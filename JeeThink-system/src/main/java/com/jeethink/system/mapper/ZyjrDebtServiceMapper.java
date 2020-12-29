package com.jeethink.system.mapper;

import java.util.List;

import com.jeethink.system.domain.ZyjrDebtService;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2020-12-28
 */
public interface ZyjrDebtServiceMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrDebtService selectZyjrDebtServiceById(@Param("userId") Long userId, @Param("transactionCode") String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrDebtService 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrDebtService> selectZyjrDebtServiceList(ZyjrDebtService zyjrDebtService);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrDebtService 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrDebtService(ZyjrDebtService zyjrDebtService);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrDebtService 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrDebtService(ZyjrDebtService zyjrDebtService);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrDebtServiceById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrDebtServiceByIds(Long[] ids);
}
