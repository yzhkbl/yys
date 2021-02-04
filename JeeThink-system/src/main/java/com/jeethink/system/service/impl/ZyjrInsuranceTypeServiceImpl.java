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
 * insuranceTypeService业务层处理
 * 
 * @author jeethink
 * @date 2020-12-29
 */
@Service
public class ZyjrInsuranceTypeServiceImpl implements IZyjrInsuranceTypeService 
{
    @Autowired
    private ZyjrInsuranceTypeMapper zyjrInsuranceTypeMapper;
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
     * 查询insuranceType
     * 
     * @param id insuranceTypeID
     * @return insuranceType
     */
    @Override
    public ZyjrInsuranceType selectZyjrInsuranceTypeById(Long id)
    {
        return zyjrInsuranceTypeMapper.selectZyjrInsuranceTypeById(id);
    }

    /**
     * 查询insuranceType列表
     * 
     * @param zyjrInsuranceType insuranceType
     * @return insuranceType
     */
    @Override
    public List<ZyjrInsuranceType> selectZyjrInsuranceTypeList(ZyjrInsuranceType zyjrInsuranceType)
    {
        return zyjrInsuranceTypeMapper.selectZyjrInsuranceTypeList(zyjrInsuranceType);
    }

    /**
     * 新增insuranceType
     * 
     * @param
     * @return 结果
     */
    @Override
    public Long insertZyjrInsuranceType(ZyjrInsuranceType zyjrBank)
    {
        zyjrBank.setCreateTime(DateUtils.getNowDate());
        zyjrInsuranceTypeMapper.insertZyjrInsuranceType(zyjrBank);
        iZyjrBankAccountService.deleteZyjrBankAccountByIdd(zyjrBank.getId());
        iZyjrBankFlowService.deleteZyjrBankFlowByIdd(zyjrBank.getId());
        iZyjrBankProductService.deleteZyjrBankProductByIdd(zyjrBank.getId());
        if(zyjrBank.getReturns().size()>0){
            for (ZyjrBankAccount aReturn : zyjrBank.getReturns()) {
                aReturn.setBaoxian(zyjrBank.getId().toString());
            }
            zyjrBankAccountMapper.insertZyjrBankAccounts(zyjrBank.getReturns());
        }
        if(zyjrBank.getFlow().size()>0){
            for (ZyjrBankFlow zyjrBankFlow : zyjrBank.getFlow()) {
                zyjrBankFlow.setBaoxian(zyjrBank.getId().toString());
            }
            zyjrBankFlowMapper.insertZyjrBankFlows(zyjrBank.getFlow());
        }
        if(zyjrBank.getProduct().size()>0){
            List<ZyjrBankProduct> list=new ArrayList<>();
            for (ZyjrBankProduct zyjrBankProduct : zyjrBank.getProduct()) {
                zyjrBankProduct.setBaoxian(zyjrBank.getId().toString());
                zyjrBankProductMapper.insertZyjrBankProduct(zyjrBankProduct);
                list.add(zyjrBankProduct);
            }


          //  System.err.println(list);
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
     * 修改insuranceType
     * 
     * @param
     * @return 结果
     */
    @Override
    public int updateZyjrInsuranceType(ZyjrInsuranceType zyjrBank)
    {
        zyjrBank.setUpdateTime(DateUtils.getNowDate());
        zyjrInsuranceTypeMapper.updateZyjrInsuranceType(zyjrBank);
        iZyjrBankAccountService.deleteZyjrBankAccountByIdd(zyjrBank.getId());
        iZyjrBankFlowService.deleteZyjrBankFlowByIdd(zyjrBank.getId());
        iZyjrBankProductService.deleteZyjrBankProductByIdd(zyjrBank.getId());
        if(zyjrBank.getReturns().size()>0){
            for (ZyjrBankAccount aReturn : zyjrBank.getReturns()) {
                aReturn.setBaoxian(zyjrBank.getId().toString());
            }
            zyjrBankAccountMapper.insertZyjrBankAccounts(zyjrBank.getReturns());
        }
        if(zyjrBank.getFlow().size()>0){
            for (ZyjrBankFlow zyjrBankFlow : zyjrBank.getFlow()) {
                zyjrBankFlow.setBaoxian(zyjrBank.getId().toString());
            }
            zyjrBankFlowMapper.insertZyjrBankFlows(zyjrBank.getFlow());
        }
        if(zyjrBank.getProduct().size()>0){
            List<ZyjrBankProduct> list=new ArrayList<>();
            for (ZyjrBankProduct zyjrBankProduct : zyjrBank.getProduct()) {
                zyjrBankProduct.setBaoxian(zyjrBank.getId().toString());
                zyjrBankProductMapper.insertZyjrBankProduct(zyjrBankProduct);
                list.add(zyjrBankProduct);
            }


           // System.err.println(list);
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
     * 批量删除insuranceType
     * 
     * @param ids 需要删除的insuranceTypeID
     * @return 结果
     */
    @Override
    public int deleteZyjrInsuranceTypeByIds(Long[] ids)
    {
        return zyjrInsuranceTypeMapper.deleteZyjrInsuranceTypeByIds(ids);
    }

    /**
     * 删除insuranceType信息
     * 
     * @param id insuranceTypeID
     * @return 结果
     */
    @Override
    public int deleteZyjrInsuranceTypeById(Long id)
    {
        return zyjrInsuranceTypeMapper.deleteZyjrInsuranceTypeById(id);
    }
}
