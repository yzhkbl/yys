package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrBankScheme;

/**
 * schemeMapper接口
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public interface ZyjrBankSchemeMapper 
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

    public int insertZyjrBankSchemes(List<ZyjrBankScheme> ZyjrBankScheme);

    /**
     * 修改scheme
     * 
     * @param zyjrBankScheme scheme
     * @return 结果
     */
    public int updateZyjrBankScheme(ZyjrBankScheme zyjrBankScheme);

    /**
     * 删除scheme
     * 
     * @param id schemeID
     * @return 结果
     */
    public int deleteZyjrBankSchemeById(Long id);

    /**
     * 批量删除scheme
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrBankSchemeByIds(Long[] ids);
}
