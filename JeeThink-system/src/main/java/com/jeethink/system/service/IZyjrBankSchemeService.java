package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrBankScheme;

/**
 * schemeService接口
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public interface IZyjrBankSchemeService 
{
    /**
     * 查询scheme
     * 
     * @param id schemeID
     * @return scheme
     */
    public ZyjrBankScheme selectZyjrBankSchemeById(Long id);

    /**
     * 查询scheme列表
     * 
     * @param zyjrBankScheme scheme
     * @return scheme集合
     */
    public List<ZyjrBankScheme> selectZyjrBankSchemeList(ZyjrBankScheme zyjrBankScheme);

    /**
     * 新增scheme
     * 
     * @param zyjrBankScheme scheme
     * @return 结果
     */
    public int insertZyjrBankScheme(ZyjrBankScheme zyjrBankScheme);

    /**
     * 修改scheme
     * 
     * @param zyjrBankScheme scheme
     * @return 结果
     */
    public int updateZyjrBankScheme(ZyjrBankScheme zyjrBankScheme);

    /**
     * 批量删除scheme
     * 
     * @param ids 需要删除的schemeID
     * @return 结果
     */
    public int deleteZyjrBankSchemeByIds(Long[] ids);

    /**
     * 删除scheme信息
     * 
     * @param id schemeID
     * @return 结果
     */
    public int deleteZyjrBankSchemeById(Long id);
}
