package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrBankSchemeMapper;
import com.jeethink.system.domain.ZyjrBankScheme;
import com.jeethink.system.service.IZyjrBankSchemeService;

/**
 * schemeService业务层处理
 * 
 * @author jeethink
 * @date 2020-12-26
 */
@Service
public class ZyjrBankSchemeServiceImpl implements IZyjrBankSchemeService 
{
    @Autowired
    private ZyjrBankSchemeMapper zyjrBankSchemeMapper;

    /**
     * 查询scheme
     * 
     * @param id schemeID
     * @return scheme
     */
    @Override
    public ZyjrBankScheme selectZyjrBankSchemeById(Long id)
    {
        return zyjrBankSchemeMapper.selectZyjrBankSchemeById(id);
    }

    /**
     * 查询scheme列表
     * 
     * @param zyjrBankScheme scheme
     * @return scheme
     */
    @Override
    public List<ZyjrBankScheme> selectZyjrBankSchemeList(ZyjrBankScheme zyjrBankScheme)
    {
        return zyjrBankSchemeMapper.selectZyjrBankSchemeList(zyjrBankScheme);
    }

    /**
     * 新增scheme
     * 
     * @param zyjrBankScheme scheme
     * @return 结果
     */
    @Override
    public int insertZyjrBankScheme(ZyjrBankScheme zyjrBankScheme)
    {

        return zyjrBankSchemeMapper.insertZyjrBankScheme(zyjrBankScheme);
    }

    /**
     * 修改scheme
     * 
     * @param zyjrBankScheme scheme
     * @return 结果
     */
    @Override
    public int updateZyjrBankScheme(ZyjrBankScheme zyjrBankScheme)
    {

        return zyjrBankSchemeMapper.updateZyjrBankScheme(zyjrBankScheme);
    }

    /**
     * 批量删除scheme
     * 
     * @param ids 需要删除的schemeID
     * @return 结果
     */
    @Override
    public int deleteZyjrBankSchemeByIds(Long[] ids)
    {
        return zyjrBankSchemeMapper.deleteZyjrBankSchemeByIds(ids);
    }

    /**
     * 删除scheme信息
     * 
     * @param id schemeID
     * @return 结果
     */
    @Override
    public int deleteZyjrBankSchemeById(Long id)
    {
        return zyjrBankSchemeMapper.deleteZyjrBankSchemeById(id);
    }
}
