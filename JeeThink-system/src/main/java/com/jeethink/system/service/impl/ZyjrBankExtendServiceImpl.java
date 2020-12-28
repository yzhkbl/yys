package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrBankExtendMapper;
import com.jeethink.system.domain.ZyjrBankExtend;
import com.jeethink.system.service.IZyjrBankExtendService;

/**
 * extendService业务层处理
 * 
 * @author jeethink
 * @date 2020-12-26
 */
@Service
public class ZyjrBankExtendServiceImpl implements IZyjrBankExtendService 
{
    @Autowired
    private ZyjrBankExtendMapper zyjrBankExtendMapper;

    /**
     * 查询extend
     * 
     * @param id extendID
     * @return extend
     */
    @Override
    public ZyjrBankExtend selectZyjrBankExtendById(Long id)
    {
        return zyjrBankExtendMapper.selectZyjrBankExtendById(id);
    }

    /**
     * 查询extend列表
     * 
     * @param zyjrBankExtend extend
     * @return extend
     */
    @Override
    public List<ZyjrBankExtend> selectZyjrBankExtendList(ZyjrBankExtend zyjrBankExtend)
    {
        return zyjrBankExtendMapper.selectZyjrBankExtendList(zyjrBankExtend);
    }

    /**
     * 新增extend
     * 
     * @param zyjrBankExtend extend
     * @return 结果
     */
    @Override
    public int insertZyjrBankExtend(ZyjrBankExtend zyjrBankExtend)
    {

        return zyjrBankExtendMapper.insertZyjrBankExtend(zyjrBankExtend);
    }

    /**
     * 修改extend
     * 
     * @param zyjrBankExtend extend
     * @return 结果
     */
    @Override
    public int updateZyjrBankExtend(ZyjrBankExtend zyjrBankExtend)
    {

        return zyjrBankExtendMapper.updateZyjrBankExtend(zyjrBankExtend);
    }

    /**
     * 批量删除extend
     * 
     * @param ids 需要删除的extendID
     * @return 结果
     */
    @Override
    public int deleteZyjrBankExtendByIds(Long[] ids)
    {
        return zyjrBankExtendMapper.deleteZyjrBankExtendByIds(ids);
    }

    /**
     * 删除extend信息
     * 
     * @param id extendID
     * @return 结果
     */
    @Override
    public int deleteZyjrBankExtendById(Long id)
    {
        return zyjrBankExtendMapper.deleteZyjrBankExtendById(id);
    }
}
