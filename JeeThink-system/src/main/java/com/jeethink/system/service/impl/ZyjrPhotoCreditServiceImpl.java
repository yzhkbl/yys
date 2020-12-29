package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrPhotoCreditMapper;
import com.jeethink.system.domain.ZyjrPhotoCredit;
import com.jeethink.system.service.IZyjrPhotoCreditService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@Service
public class ZyjrPhotoCreditServiceImpl implements IZyjrPhotoCreditService 
{
    @Autowired
    private ZyjrPhotoCreditMapper zyjrPhotoCreditMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrPhotoCredit selectZyjrPhotoCreditById(Long userId,String transactionCode)
    {
        return zyjrPhotoCreditMapper.selectZyjrPhotoCreditById(userId, transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrPhotoCredit 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrPhotoCredit> selectZyjrPhotoCreditList(ZyjrPhotoCredit zyjrPhotoCredit)
    {
        return zyjrPhotoCreditMapper.selectZyjrPhotoCreditList(zyjrPhotoCredit);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrPhotoCredit 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrPhotoCredit(ZyjrPhotoCredit zyjrPhotoCredit)
    {
        return zyjrPhotoCreditMapper.insertZyjrPhotoCredit(zyjrPhotoCredit);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrPhotoCredit 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrPhotoCredit(ZyjrPhotoCredit zyjrPhotoCredit)
    {
        return zyjrPhotoCreditMapper.updateZyjrPhotoCredit(zyjrPhotoCredit);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrPhotoCreditByIds(Long[] ids)
    {
        return zyjrPhotoCreditMapper.deleteZyjrPhotoCreditByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrPhotoCreditById(Long id)
    {
        return zyjrPhotoCreditMapper.deleteZyjrPhotoCreditById(id);
    }
}
