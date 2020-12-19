package com.jeethink.system.service.impl;

import java.util.List;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeethink.common.utils.DateUtils;
import com.jeethink.system.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrCarAccountMapper;
import com.jeethink.system.domain.ZyjrCarAccount;
import com.jeethink.system.service.IZyjrCarAccountService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-15
 */
@Service
public class ZyjrCarAccountServiceImpl  implements IZyjrCarAccountService
{
    @Autowired
    private ZyjrCarAccountMapper zyjrCarAccountMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrCarAccount selectZyjrCarAccountById(Long id)
    {
        return zyjrCarAccountMapper.selectZyjrCarAccountById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCarAccount 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrCarAccount> selectZyjrCarAccountList(ZyjrCarAccount zyjrCarAccount)
    {
        return zyjrCarAccountMapper.selectZyjrCarAccountList(zyjrCarAccount);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCarAccount 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrCarAccount(List<ZyjrCarAccount> zyjrCarAccount)
    {

        return zyjrCarAccountMapper.insertZyjrCarAccount(zyjrCarAccount);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCarAccount 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrCarAccount(ZyjrCarAccount zyjrCarAccount)
    {
        /*zyjrCarAccount.setUpdateTime(DateUtils.getNowDate());*/
        return zyjrCarAccountMapper.updateZyjrCarAccount(zyjrCarAccount);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCarAccountByIds(Long[] ids)
    {
        return zyjrCarAccountMapper.deleteZyjrCarAccountByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCarAccountById(Long id)
    {
        return zyjrCarAccountMapper.deleteZyjrCarAccountById(id);
    }
}
