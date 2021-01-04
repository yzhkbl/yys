package com.jeethink.system.service.impl;

import java.util.List;
import com.jeethink.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrCardMapper;
import com.jeethink.system.domain.ZyjrCard;
import com.jeethink.system.service.IZyjrCardService;

/**
 * cardService业务层处理
 * 
 * @author jeethink
 * @date 2020-12-30
 */
@Service
public class ZyjrCardServiceImpl implements IZyjrCardService 
{
    @Autowired
    private ZyjrCardMapper zyjrCardMapper;

    /**
     * 查询card
     * 
     * @param id cardID
     * @return card
     */
    @Override
    public ZyjrCard selectZyjrCardById(Long id)
    {
        return zyjrCardMapper.selectZyjrCardById(id);
    }

    /**
     * 查询card列表
     * 
     * @param zyjrCard card
     * @return card
     */
    @Override
    public List<ZyjrCard> selectZyjrCardList(ZyjrCard zyjrCard)
    {
        return zyjrCardMapper.selectZyjrCardList(zyjrCard);
    }

    /**
     * 新增card
     * 
     * @param zyjrCard card
     * @return 结果
     */
    @Override
    public int insertZyjrCard(ZyjrCard zyjrCard)
    {
        zyjrCard.setCreateTime(DateUtils.getNowDate());
        return zyjrCardMapper.insertZyjrCard(zyjrCard);
    }

    /**
     * 修改card
     * 
     * @param zyjrCard card
     * @return 结果
     */
    @Override
    public int updateZyjrCard(ZyjrCard zyjrCard)
    {
        zyjrCard.setUpdateTime(DateUtils.getNowDate());
        return zyjrCardMapper.updateZyjrCard(zyjrCard);
    }

    /**
     * 批量删除card
     * 
     * @param ids 需要删除的cardID
     * @return 结果
     */
    @Override
    public int deleteZyjrCardByIds(Long[] ids)
    {
        return zyjrCardMapper.deleteZyjrCardByIds(ids);
    }

    /**
     * 删除card信息
     * 
     * @param id cardID
     * @return 结果
     */
    @Override
    public int deleteZyjrCardById(Long id)
    {
        return zyjrCardMapper.deleteZyjrCardById(id);
    }
}
