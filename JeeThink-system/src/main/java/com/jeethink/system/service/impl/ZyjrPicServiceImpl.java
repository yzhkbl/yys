package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrPicMapper;
import com.jeethink.system.domain.ZyjrPic;
import com.jeethink.system.service.IZyjrPicService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-05
 */
@Service
public class ZyjrPicServiceImpl implements IZyjrPicService 
{
    @Autowired
    private ZyjrPicMapper zyjrPicMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrPic selectZyjrPicById(Long id)
    {
        return zyjrPicMapper.selectZyjrPicById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrPic 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrPic> selectZyjrPicList(ZyjrPic zyjrPic)
    {
        return zyjrPicMapper.selectZyjrPicList(zyjrPic);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrPic 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrPic(ZyjrPic zyjrPic)
    {
        return zyjrPicMapper.insertZyjrPic(zyjrPic);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrPic 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrPic(ZyjrPic zyjrPic)
    {
        return zyjrPicMapper.updateZyjrPic(zyjrPic);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrPicByIds(Long[] ids)
    {
        return zyjrPicMapper.deleteZyjrPicByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */

}
