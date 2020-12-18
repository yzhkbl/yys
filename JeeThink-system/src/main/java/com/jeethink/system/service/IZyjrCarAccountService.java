package com.jeethink.system.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jeethink.system.base.service.BaseService;
import com.jeethink.system.domain.ZyjrCarAccount;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author jeethink
 * @date 2020-12-15
 */
public interface IZyjrCarAccountService extends BaseService<ZyjrCarAccount>
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrCarAccount selectZyjrCarAccountById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCarAccount 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrCarAccount> selectZyjrCarAccountList(ZyjrCarAccount zyjrCarAccount);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCarAccount 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrCarAccount(List<ZyjrCarAccount> zyjrCarAccount);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCarAccount 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrCarAccount(ZyjrCarAccount zyjrCarAccount);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCarAccountByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCarAccountById(Long id);
}
