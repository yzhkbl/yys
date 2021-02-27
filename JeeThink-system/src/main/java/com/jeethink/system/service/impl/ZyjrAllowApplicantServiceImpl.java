package com.jeethink.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.jeethink.system.domain.*;
import com.jeethink.system.mapper.ExamineMapper;
import com.jeethink.system.mapper.ZyjrCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrAllowApplicantMapper;
import com.jeethink.system.service.IZyjrAllowApplicantService;
import com.alibaba.fastjson.JSON;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author jeethink
 * @date 2020-12-22
 */
@Service
public class ZyjrAllowApplicantServiceImpl implements IZyjrAllowApplicantService
{
    @Autowired
    private ZyjrAllowApplicantMapper zyjrAllowApplicantMapper;
    @Autowired
    private ZyjrCardMapper zyjrCardMapper;
    @Autowired
    private ExamineMapper examineMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrAllowApplicant selectZyjrAllowApplicantById(Long userId, String transactionCode)
    {
        ZyjrAllowApplicant zyjrAllowApplicant = zyjrAllowApplicantMapper.selectZyjrAllowApplicantById(userId, transactionCode);
        if(zyjrAllowApplicant==null) {
            zyjrAllowApplicant = new ZyjrAllowApplicant();
            ZyjrBorrower zyjrBorrower = examineMapper.Borrower(transactionCode);
            List<ZyjrRelation> r = examineMapper.findRe(transactionCode);
            List<ZyjrRelation> data = r.stream().filter(a -> a.getPeopleShip().equals("配偶")).collect(Collectors.toList());
            List<ZyjrGuarantee> g = examineMapper.findGu(transactionCode);
            List<ZyjrGuarantee> gu = g.stream().filter(a -> a.getPeopleShip().equals("配偶")).collect(Collectors.toList());
            zyjrAllowApplicant.setFamilyAddress(zyjrBorrower.getFamilyAddress());
            zyjrAllowApplicant.setPhoneNumber(zyjrBorrower.getPhoneNumber());
            if (data.size()>0) {
                ZyjrRelation zyjrRelation=data.get(0);
                zyjrAllowApplicant.setCardAddress(zyjrRelation.getObverseAddress());
                zyjrAllowApplicant.setBackAddress(zyjrRelation.getBackAddress());
                zyjrAllowApplicant.setSpouseName(zyjrRelation.getUserName());
                zyjrAllowApplicant.setIdNumber(zyjrRelation.getIdCard());
                zyjrAllowApplicant.setPhoneNo(zyjrRelation.getPhoneNumber());
                zyjrAllowApplicant.setSpouseFamilyAddress(zyjrRelation.getFamilyAddress());
                zyjrAllowApplicant.setSpouseUnitName(zyjrRelation.getCompany());
                zyjrAllowApplicant.setSpouseWorkPlace(zyjrRelation.getCompanyAddress());
                zyjrAllowApplicant.setMarriage("已婚");
            }
            if (gu.size()>0) {
                ZyjrGuarantee zyjrGuarantee = gu.get(0);
                zyjrAllowApplicant.setCardAddress(zyjrGuarantee.getObverseAddress());
                zyjrAllowApplicant.setBackAddress(zyjrGuarantee.getBackAddress());
                zyjrAllowApplicant.setSpouseName(zyjrGuarantee.getUserName());
                zyjrAllowApplicant.setIdNumber(zyjrGuarantee.getIdCard());
                zyjrAllowApplicant.setPhoneNo(zyjrGuarantee.getPhoneNumber());
                zyjrAllowApplicant.setSpouseFamilyAddress(zyjrGuarantee.getFamilyAddress());
                zyjrAllowApplicant.setSpouseUnitName(zyjrGuarantee.getCompany());
                zyjrAllowApplicant.setSpouseWorkPlace(zyjrGuarantee.getCompanyAddress());
                zyjrAllowApplicant.setMarriage("已婚");
            }
        }
        if(zyjrAllowApplicant!=null&&zyjrAllowApplicant.getIndustry()!=null){
            ZyjrCard a=zyjrCardMapper.selectZyjrCardByTransactionCode("1");
            String str= a.getAlmebno();
            HashMap hashMap = JSON.parseObject(str, HashMap.class);
            Object asd=hashMap.get(Integer.parseInt(zyjrAllowApplicant.getIndustry()));
            zyjrAllowApplicant.setIndustry(asd.toString());
        }
        return zyjrAllowApplicant;
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param zyjrAllowApplicant 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrAllowApplicant> selectZyjrAllowApplicantList(ZyjrAllowApplicant zyjrAllowApplicant)
    {
        return zyjrAllowApplicantMapper.selectZyjrAllowApplicantList(zyjrAllowApplicant);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param zyjrAllowApplicant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrAllowApplicant(ZyjrAllowApplicant zyjrAllowApplicant) {
        if(zyjrAllowApplicantMapper.selectZyjrAllowApplicantById(zyjrAllowApplicant.getUserId(),zyjrAllowApplicant.getTransactionCode())==null) {
            return zyjrAllowApplicantMapper.insertZyjrAllowApplicant(zyjrAllowApplicant);
        }else{
            return zyjrAllowApplicantMapper.updateZyjrAllowApplicant(zyjrAllowApplicant);
        }
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param zyjrAllowApplicant 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrAllowApplicant(ZyjrAllowApplicant zyjrAllowApplicant)
    {
        return zyjrAllowApplicantMapper.updateZyjrAllowApplicant(zyjrAllowApplicant);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrAllowApplicantByIds(Long[] ids)
    {
        return zyjrAllowApplicantMapper.deleteZyjrAllowApplicantByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrAllowApplicantById(Long id)
    {
        return zyjrAllowApplicantMapper.deleteZyjrAllowApplicantById(id);
    }
}
