package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrPhotoLenderMapper;
import com.jeethink.system.domain.ZyjrPhotoLender;
import com.jeethink.system.service.IZyjrPhotoLenderService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@Service
public class ZyjrPhotoLenderServiceImpl implements IZyjrPhotoLenderService 
{
    @Autowired
    private ZyjrPhotoLenderMapper zyjrPhotoLenderMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrPhotoLender selectZyjrPhotoLenderById(Long userId,String transactionCode)
    {
        return zyjrPhotoLenderMapper.selectZyjrPhotoLenderById(userId, transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrPhotoLender 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrPhotoLender> selectZyjrPhotoLenderList(ZyjrPhotoLender zyjrPhotoLender)
    {
        return zyjrPhotoLenderMapper.selectZyjrPhotoLenderList(zyjrPhotoLender);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrPhotoLender 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrPhotoLender(ZyjrPhotoLender zyjrPhotoLender)
    {
        return zyjrPhotoLenderMapper.insertZyjrPhotoLender(zyjrPhotoLender);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrPhotoLender 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrPhotoLender(ZyjrPhotoLender zyjrPhotoLender)
    {
        return zyjrPhotoLenderMapper.updateZyjrPhotoLender(zyjrPhotoLender);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrPhotoLenderByIds(Long[] ids)
    {
        return zyjrPhotoLenderMapper.deleteZyjrPhotoLenderByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrPhotoLenderById(Long id)
    {
        return zyjrPhotoLenderMapper.deleteZyjrPhotoLenderById(id);
    }
}
