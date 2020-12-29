package com.jeethink.system.mapper;

import java.util.List;


import com.jeethink.system.base.mapper.BaseMapper;
import com.jeethink.system.domain.ZyjrCarAccount;
import org.mybatis.spring.annotation.MapperScan;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2020-12-15
 */
@MapperScan
public interface ZyjrCarAccountMapper
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

    public int insertZyjrCarAccount(ZyjrCarAccount zyjrCarAccount);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCarAccount 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrCarAccount(ZyjrCarAccount zyjrCarAccount);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrCarAccountById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrCarAccountByIds(Long[] ids);
    int insertTestList(List<ZyjrCarAccount>  ZyjrCarAccount);
}
