package com.jeethink.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.jeethink.common.utils.DateUtils;
import com.jeethink.system.domain.*;
import com.jeethink.system.mapper.*;
import com.jeethink.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * bankService业务层处理
 * 
 * @author jeethink
 * @date 2020-12-26
 */
@Service
public class ZyjrBankServiceImpl implements IZyjrBankService 
{
    @Autowired
    private ZyjrBankMapper zyjrBankMapper;
    @Autowired
    private IZyjrBankAccountService iZyjrBankAccountService;
    @Autowired
    private IZyjrBankExtendService iZyjrBankExtendService;
    @Autowired
    private IZyjrBankFlowService iZyjrBankFlowService;
    @Autowired
    private IZyjrBankProductService iZyjrBankProductService;
    @Autowired
    private IZyjrBankSchemeService iZyjrBankSchemeService;
    @Autowired
    private ZyjrBankAccountMapper zyjrBankAccountMapper;
    @Autowired
    private ZyjrBankExtendMapper zyjrBankExtendMapper;
    @Autowired
    private ZyjrBankFlowMapper zyjrBankFlowMapper;
    @Autowired
    private ZyjrBankProductMapper zyjrBankProductMapper;
    @Autowired
    private ZyjrBankSchemeMapper zyjrBankSchemeMapper;



    /**
     * 查询bank
     * 
     * @param id bankID
     * @return bank
     */
    @Override
    public ZyjrBank selectZyjrBankById(Long id)
    {
        return zyjrBankMapper.selectZyjrBankById(id);
    }

    /**
     * 查询bank列表
     * 
     * @param zyjrBank bank
     * @return bank
     */
    @Override
    public List<ZyjrBank> selectZyjrBankList(ZyjrBank zyjrBank)
    {
        return zyjrBankMapper.selectZyjrBankList(zyjrBank);
    }

    public int delete(){
        long a=1;
        iZyjrBankAccountService.deleteZyjrBankAccountById(a);
        iZyjrBankExtendService.deleteZyjrBankExtendById(a);
        iZyjrBankFlowService.deleteZyjrBankFlowById(a);
        iZyjrBankProductService.deleteZyjrBankProductById(a);
        return 1;
    }

    /**
     * 新增bank
     * 
     * @param zyjrBank bank
     * @return 结果
     */
    @Override
    public Long insertZyjrBank(ZyjrBank zyjrBank)
    {

        zyjrBank.setCreateTime(DateUtils.getNowDate());
        iZyjrBankAccountService.deleteZyjrBankAccountById(zyjrBank.getId());
        iZyjrBankExtendService.deleteZyjrBankExtendById(zyjrBank.getId());
        iZyjrBankFlowService.deleteZyjrBankFlowById(zyjrBank.getId());
        iZyjrBankProductService.deleteZyjrBankProductById(zyjrBank.getId());
        zyjrBankMapper.insertZyjrBank(zyjrBank);
        if(zyjrBank.getReturns().size()>0){
            for (ZyjrBankAccount aReturn : zyjrBank.getReturns()) {
                aReturn.setBankId(zyjrBank.getId().toString());
            }
                zyjrBankAccountMapper.insertZyjrBankAccounts(zyjrBank.getReturns());
        }
        if(zyjrBank.getExtend().size()>0){
            for (ZyjrBankExtend zyjrBankExtend : zyjrBank.getExtend()) {
                zyjrBankExtend.setBankId(zyjrBank.getId().toString());
            }
            zyjrBankExtendMapper.insertZyjrBankExtends(zyjrBank.getExtend());
        }
        if(zyjrBank.getFlow().size()>0){
            for (ZyjrBankFlow zyjrBankFlow : zyjrBank.getFlow()) {
                zyjrBankFlow.setBankId(zyjrBank.getId().toString());
            }
            zyjrBankFlowMapper.insertZyjrBankFlows(zyjrBank.getFlow());
        }
        if(zyjrBank.getProduct().size()>0){
            List<ZyjrBankProduct> list=new ArrayList<>();
            for (ZyjrBankProduct zyjrBankProduct : zyjrBank.getProduct()) {
                zyjrBankProduct.setBankId(zyjrBank.getId().toString());
                zyjrBankProductMapper.insertZyjrBankProduct(zyjrBankProduct);
                list.add(zyjrBankProduct);
            }


            System.err.println(list);
            if(list.size()>0){
                List<ZyjrBankScheme> slist=new ArrayList<>();
                for (ZyjrBankProduct zyjrBankProduct : list) {
                    iZyjrBankSchemeService.deleteZyjrBankSchemeById(zyjrBankProduct.getId());
                    for (ZyjrBankScheme zyjrBankScheme : zyjrBankProduct.getScheme()) {
                        zyjrBankScheme.setZyjrBankProductId(zyjrBankProduct.getId().toString());
                        slist.add(zyjrBankScheme);
                    }
                }
                zyjrBankSchemeMapper.insertZyjrBankSchemes(slist);

            }
        }

        return zyjrBank.getId();
    }

    /**
     * 修改bank
     * 
     * @param zyjrBank bank
     * @return 结果
     */
    @Override
    public int updateZyjrBank(ZyjrBank zyjrBank)
    {
        zyjrBank.setUpdateTime(DateUtils.getNowDate());
        zyjrBankMapper.updateZyjrBank(zyjrBank);
        iZyjrBankAccountService.deleteZyjrBankAccountById(zyjrBank.getId());
        iZyjrBankExtendService.deleteZyjrBankExtendById(zyjrBank.getId());
        iZyjrBankFlowService.deleteZyjrBankFlowById(zyjrBank.getId());
        iZyjrBankProductService.deleteZyjrBankProductById(zyjrBank.getId());
        zyjrBankMapper.updateZyjrBank(zyjrBank);
        if(zyjrBank.getReturns().size()>0){
            for (ZyjrBankAccount aReturn : zyjrBank.getReturns()) {
                aReturn.setBankId(zyjrBank.getId().toString());
            }
            zyjrBankAccountMapper.insertZyjrBankAccounts(zyjrBank.getReturns());
        }
        if(zyjrBank.getExtend().size()>0){
            for (ZyjrBankExtend zyjrBankExtend : zyjrBank.getExtend()) {
                zyjrBankExtend.setBankId(zyjrBank.getId().toString());
            }
            zyjrBankExtendMapper.insertZyjrBankExtends(zyjrBank.getExtend());
        }
        if(zyjrBank.getFlow().size()>0){
            for (ZyjrBankFlow zyjrBankFlow : zyjrBank.getFlow()) {
                zyjrBankFlow.setBankId(zyjrBank.getId().toString());
            }
            zyjrBankFlowMapper.insertZyjrBankFlows(zyjrBank.getFlow());
        }
        if(zyjrBank.getProduct().size()>0){
            List<ZyjrBankProduct> list=new ArrayList<>();
            for (ZyjrBankProduct zyjrBankProduct : zyjrBank.getProduct()) {
                zyjrBankProduct.setBankId(zyjrBank.getId().toString());
                zyjrBankProductMapper.insertZyjrBankProduct(zyjrBankProduct);
                list.add(zyjrBankProduct);
            }


            System.err.println(list);
            if(list.size()>0){
                List<ZyjrBankScheme> slist=new ArrayList<>();
                for (ZyjrBankProduct zyjrBankProduct : list) {
                    iZyjrBankSchemeService.deleteZyjrBankSchemeById(zyjrBankProduct.getId());
                    for (ZyjrBankScheme zyjrBankScheme : zyjrBankProduct.getScheme()) {
                        zyjrBankScheme.setZyjrBankProductId(zyjrBankProduct.getId().toString());
                        slist.add(zyjrBankScheme);
                    }
                }
                zyjrBankSchemeMapper.insertZyjrBankSchemes(slist);

            }
        }

        return 1;
    }

    /**
     * 批量删除bank
     * 
     * @param ids 需要删除的bankID
     * @return 结果
     */
    @Override
    public int deleteZyjrBankByIds(Long[] ids)
    {

        iZyjrBankAccountService.deleteZyjrBankAccountByIds(ids);
        iZyjrBankExtendService.deleteZyjrBankExtendByIds(ids);
        iZyjrBankFlowService.deleteZyjrBankFlowByIds(ids);
        iZyjrBankProductService.deleteZyjrBankProductByIds(ids);
        return zyjrBankMapper.deleteZyjrBankByIds(ids);
    }

    /**
     * 删除bank信息
     * 
     * @param id bankID
     * @return 结果
     */
    @Override
    public int deleteZyjrBankById(Long id)
    {
        ZyjrBankProduct a=new ZyjrBankProduct();
        a.setBankId(id.toString());
        List<ZyjrBankProduct> b=zyjrBankProductMapper.selectZyjrBankProductList(a);
        if(b.size()>0){
            for (ZyjrBankProduct zyjrBankProduct : b) {
                iZyjrBankSchemeService.deleteZyjrBankSchemeById(zyjrBankProduct.getId());
            }
        }
        iZyjrBankAccountService.deleteZyjrBankAccountById(id);
        iZyjrBankExtendService.deleteZyjrBankExtendById(id);
        iZyjrBankFlowService.deleteZyjrBankFlowById(id);
        iZyjrBankProductService.deleteZyjrBankProductById(id);
        return zyjrBankMapper.deleteZyjrBankById(id);
    }
}
