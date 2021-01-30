package com.jeethink.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeethink.system.domain.*;
import com.jeethink.system.mapper.*;
import com.jeethink.system.service.IZyjrDaiqianAccoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.service.IZyjrAllowBasicsService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@Service
public class ZyjrAllowBasicsServiceImpl implements IZyjrAllowBasicsService 
{
    @Autowired
    private ZyjrAllowBasicsMapper zyjrAllowBasicsMapper;
    @Autowired
    private ZyjrCarMapper zyjrCarMapper;
    @Autowired
    private ZyjrCarAccountMapper zyjrCarAccountMapper;
    @Autowired
    private ZyjrGpsMapper zyjrGpsMapper;
    @Autowired
    private ZyjrPicMapper zyjrPicMapper;
    @Autowired
    private ZyjrInsuranceMapper zyjrInsuranceMapper;
    @Autowired
    private IZyjrDaiqianAccoutService zyjrDaiqianAccoutService;

    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrAllowBasics selectZyjrAllowBasicsById(Long userId,String transactionCode)
    {
        return zyjrAllowBasicsMapper.selectZyjrAllowBasicsById(userId, transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrAllowBasics 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrAllowBasics> selectZyjrAllowBasicsList(ZyjrAllowBasics zyjrAllowBasics)
    {
        return zyjrAllowBasicsMapper.selectZyjrAllowBasicsList(zyjrAllowBasics);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrAllowBasics 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrAllowBasics(ZyjrAllowBasics zyjrAllowBasics)
    {
        ZyjrAllowBasics z = zyjrAllowBasicsMapper.selectZyjrAllowBasicsById(zyjrAllowBasics.getUserId(), zyjrAllowBasics.getTransactionCode());
        if(z!=null){
            return zyjrAllowBasicsMapper.updateZyjrAllowBasics(zyjrAllowBasics);
        }else {
            return zyjrAllowBasicsMapper.insertZyjrAllowBasics(zyjrAllowBasics);
        }
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrAllowBasics 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrAllowBasics(ZyjrAllowBasics zyjrAllowBasics)
    {
        return zyjrAllowBasicsMapper.updateZyjrAllowBasics(zyjrAllowBasics);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrAllowBasicsByIds(Long[] ids)
    {
        return zyjrAllowBasicsMapper.deleteZyjrAllowBasicsByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrAllowBasicsById(Long id)
    {
        return zyjrAllowBasicsMapper.deleteZyjrAllowBasicsById(id);
    }

    @Override
    public Map<String, Object> selectByMap(String transactionCode) {
        Map<String,Object> map=new HashMap<>();
        ZyjrDaiqian zyjrAllowBasics = zyjrAllowBasicsMapper.selectByT(transactionCode);
        if(zyjrAllowBasics==null||transactionCode==null){
            return null;
        }
        ZyjrCar zyjrCar = zyjrCarMapper.selectZyjrCarById(zyjrAllowBasics.getDealersId());
        ZyjrCarAccount z=new ZyjrCarAccount();
        if(zyjrCar!=null&&zyjrCar.getId()!=null){
          /*  z.setZyjrCarId(zyjrCar.getId().toString());
            List<ZyjrCarAccount> zyjrCarAccounts = zyjrCarAccountMapper.selectZyjrCarAccountList(z);
            map.put("Account",zyjrCarAccounts);*/
            ZyjrDaiqianAccout a=zyjrDaiqianAccoutService.selectZyjrDaiqianAccoutByIds(zyjrAllowBasics.getTransactionCode());
            map.put("Account",null);
            map.put("Account2",null);
            map.put("type",a.getType());
            if(a!=null){
                ZyjrCarAccount b=zyjrCarAccountMapper.selectZyjrCarAccountByStringId(a.getAccountId());
                ZyjrCarAccount c=zyjrCarAccountMapper.selectZyjrCarAccountByStringId(a.getAccountOne());
                map.put("Account",b);
                map.put("Account2",c);
            }

        }
        ZyjrGps zyjrGps = zyjrGpsMapper.selectZyjrGpsById(zyjrAllowBasics.getTransactionCode());

            map.put("Gps",zyjrGps);
        if(zyjrGps!=null){
            ZyjrPic pic=new ZyjrPic();
            pic.setGpsId(zyjrGps.getId().toString());
            List<ZyjrPic> zyjrPics = zyjrPicMapper.selectZyjrPicList(pic);
            map.put("pic",zyjrPics);
        }
        ZyjrInsurance zyjrInsurance = zyjrInsuranceMapper.selectZyjrInsuranceByIds(zyjrAllowBasics.getTransactionCode());
        map.put("Insurance",zyjrInsurance);

        return map;
    }
}
