package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrCaiwu;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-03-18
 */
public interface ZyjrCaiwuMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrCaiwu selectZyjrCaiwuById(Long id);
    ZyjrCaiwu selectZyjrCaiwuByT(String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCaiwu 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrCaiwu> selectZyjrCaiwuList(ZyjrCaiwu zyjrCaiwu);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCaiwu 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrCaiwu(ZyjrCaiwu zyjrCaiwu);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCaiwu 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrCaiwu(ZyjrCaiwu zyjrCaiwu);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCaiwuById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrCaiwuByIds(Long[] ids);


}
