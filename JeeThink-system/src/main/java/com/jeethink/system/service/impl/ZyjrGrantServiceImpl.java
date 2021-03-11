package com.jeethink.system.service.impl;

import java.util.List;

import com.jeethink.system.domain.ZyjrFundSide;
import com.jeethink.system.domain.vo.ZyjrGrant;
import com.jeethink.system.mapper.ExamineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrGrantMapper;
import com.jeethink.system.domain.ZyjrGrant2;
import com.jeethink.system.service.IZyjrGrantService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-03-10
 */
@Service
public class ZyjrGrantServiceImpl implements IZyjrGrantService 
{
    @Autowired
    private ZyjrGrantMapper zyjrGrantMapper;
    @Autowired
    private ExamineMapper examineMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrGrant2 selectZyjrGrantById(String transactionCode)
    {   ZyjrFundSide zyjrFundSide = examineMapper.findFundSide(transactionCode);
        ZyjrGrant2 zyjrGrant2 = zyjrGrantMapper.selectZyjrGrantById(transactionCode);
        if(zyjrGrant2==null&&zyjrFundSide!=null){
            ZyjrGrant2 z = new ZyjrGrant2();
            z.setMortgageChannel(zyjrFundSide.getSideName());
            return z;
        }else {
            return zyjrGrant2;
        }
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrGrant 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrGrant2> selectZyjrGrantList(ZyjrGrant2 zyjrGrant)
    {
        return zyjrGrantMapper.selectZyjrGrantList(zyjrGrant);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrGrant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrGrant(ZyjrGrant2 zyjrGrant)
    {   ZyjrFundSide zyjrFundSide = examineMapper.findFundSide(zyjrGrant.getTransactionCode());
        if(zyjrFundSide!=null) {
            zyjrGrant.setMortgageChannel(zyjrFundSide.getSideName());
        }
        if(zyjrGrantMapper.selectZyjrGrantById(zyjrGrant.getTransactionCode())!=null){
            return zyjrGrantMapper.updateZyjrGrant(zyjrGrant);
        }else {
            return zyjrGrantMapper.insertZyjrGrant(zyjrGrant);
        }
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrGrant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrGrant(ZyjrGrant2 zyjrGrant)
    {
        return zyjrGrantMapper.updateZyjrGrant(zyjrGrant);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrGrantByIds(Long[] ids)
    {
        return zyjrGrantMapper.deleteZyjrGrantByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrGrantById(Long id)
    {
        return zyjrGrantMapper.deleteZyjrGrantById(id);
    }
}
