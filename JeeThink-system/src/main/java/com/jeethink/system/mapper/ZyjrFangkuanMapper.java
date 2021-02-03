package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrFangkuan;
import com.jeethink.system.domain.vo.Huankuan;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-21
 */
public interface ZyjrFangkuanMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrFangkuan selectZyjrFangkuanById(String id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrFangkuan 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrFangkuan> selectZyjrFangkuanList(ZyjrFangkuan zyjrFangkuan);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrFangkuan 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrFangkuan(ZyjrFangkuan zyjrFangkuan);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrFangkuan 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrFangkuan(ZyjrFangkuan zyjrFangkuan);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrFangkuanById(String id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrFangkuanByIds(Long[] ids);

}
