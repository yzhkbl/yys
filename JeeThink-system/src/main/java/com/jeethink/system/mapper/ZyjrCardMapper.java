package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrCard;

/**
 * cardMapper接口
 * 
 * @author jeethink
 * @date 2020-12-30
 */
public interface ZyjrCardMapper 
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
     * 删除card
     * 
     * @param id cardID
     * @return 结果
     */
    public int deleteZyjrCardById(Long id);

    /**
     * 批量删除card
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrCardByIds(Long[] ids);

    ZyjrCard selectZyjrCardByTransactionCode(String transactionCode);
}
