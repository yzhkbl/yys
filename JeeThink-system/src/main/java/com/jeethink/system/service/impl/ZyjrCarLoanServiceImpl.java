package com.jeethink.system.service.impl;

import java.util.List;

import com.jeethink.system.domain.ZyjrBusiness;
import com.jeethink.system.mapper.ExamineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrCarLoanMapper;
import com.jeethink.system.domain.ZyjrCarLoan;
import com.jeethink.system.service.IZyjrCarLoanService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@Service
public class ZyjrCarLoanServiceImpl implements IZyjrCarLoanService 
{
    @Autowired
    private ZyjrCarLoanMapper zyjrCarLoanMapper;
    @Autowired
    private ExamineMapper examineMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrCarLoan selectZyjrCarLoanById(Long userId,String transactionCode)
    {
        ZyjrCarLoan c = zyjrCarLoanMapper.selectZyjrCarLoanById(userId,transactionCode);
        if(c!=null) {
            ZyjrBusiness zyjrBusiness = examineMapper.Business(transactionCode);
            c.setIntentionPrice(zyjrBusiness.getIntentionPrice());
        }
        return c;
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrCarLoan 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrCarLoan> selectZyjrCarLoanList(ZyjrCarLoan zyjrCarLoan)
    {
        return zyjrCarLoanMapper.selectZyjrCarLoanList(zyjrCarLoan);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrCarLoan 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrCarLoan(ZyjrCarLoan zyjrCarLoan)
    {
        if(zyjrCarLoanMapper.selectZyjrCarLoanById(zyjrCarLoan.getUserId(),zyjrCarLoan.getTransactionCode())==null){
            return zyjrCarLoanMapper.insertZyjrCarLoan(zyjrCarLoan);
        }else {
            return zyjrCarLoanMapper.updateZyjrCarLoan(zyjrCarLoan);
        }

    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrCarLoan 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrCarLoan(ZyjrCarLoan zyjrCarLoan)
    {
        return zyjrCarLoanMapper.updateZyjrCarLoan(zyjrCarLoan);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCarLoanByIds(Long[] ids)
    {
        return zyjrCarLoanMapper.deleteZyjrCarLoanByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCarLoanById(Long id)
    {
        return zyjrCarLoanMapper.deleteZyjrCarLoanById(id);
    }
}
