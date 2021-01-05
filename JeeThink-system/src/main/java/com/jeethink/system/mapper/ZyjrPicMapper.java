package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrPic;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-05
 */
public interface ZyjrPicMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrPic selectZyjrPicById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrPic 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrPic> selectZyjrPicList(ZyjrPic zyjrPic);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrPic 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrPic(ZyjrPic zyjrPic);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrPic 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrPic(ZyjrPic zyjrPic);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrPicById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrPicByIds(Long[] ids);
}
