package com.jeethink.system.service;

import java.util.List;
import com.jeethink.system.domain.ZyjrCard;

/**
 * cardService接口
 * 
 * @author jeethink
 * @date 2020-12-30
 */
public interface IZyjrCardService 
{
    /**
     * 查询card
     * 
     * @param id cardID
     * @return card
     */
    public ZyjrCard selectZyjrCardById(Long id);

    /**
     * 查询card列表
     * 
     * @param zyjrCard card
     * @return card集合
     */
    public List<ZyjrCard> selectZyjrCardList(ZyjrCard zyjrCard);

    /**
     * 新增card
     * 
     * @param zyjrCard card
     * @return 结果
     */
    public int insertZyjrCard(ZyjrCard zyjrCard);

    /**
     * 修改card
     * 
     * @param zyjrCard card
     * @return 结果
     */
    public int updateZyjrCard(ZyjrCard zyjrCard);

    /**
     * 批量删除card
     * 
     * @param ids 需要删除的cardID
     * @return 结果
     */
    public int deleteZyjrCardByIds(Long[] ids);

    /**
     * 删除card信息
     * 
     * @param id cardID
     * @return 结果
     */
    public int deleteZyjrCardById(Long id);
}
