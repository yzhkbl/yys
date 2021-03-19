package com.jeethink.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrCaiwuMapper;
import com.jeethink.system.domain.ZyjrCaiwu;
import com.jeethink.system.service.IZyjrCaiwuService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-03-18
 */
@Service
public class ZyjrCaiwuServiceImpl implements IZyjrCaiwuService 
{
    @Autowired
    private ZyjrCaiwuMapper zyjrCaiwuMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrCaiwu selectZyjrCaiwuById(Long id)
    {
        return zyjrCaiwuMapper.selectZyjrCaiwuById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCaiwu 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrCaiwu> selectZyjrCaiwuList(ZyjrCaiwu zyjrCaiwu)
    {
        return zyjrCaiwuMapper.selectZyjrCaiwuList(zyjrCaiwu);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCaiwu 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrCaiwu(ZyjrCaiwu zyjrCaiwu)
    {
        return zyjrCaiwuMapper.insertZyjrCaiwu(zyjrCaiwu);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCaiwu 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrCaiwu(ZyjrCaiwu zyjrCaiwu)
    {
        return zyjrCaiwuMapper.updateZyjrCaiwu(zyjrCaiwu);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCaiwuByIds(Long[] ids)
    {
        return zyjrCaiwuMapper.deleteZyjrCaiwuByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCaiwuById(Long id)
    {
        return zyjrCaiwuMapper.deleteZyjrCaiwuById(id);
    }
}
