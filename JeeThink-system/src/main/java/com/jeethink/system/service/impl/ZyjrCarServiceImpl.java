package com.jeethink.system.service.impl;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jeethink.common.core.redis.RedisCache;
import com.jeethink.common.utils.DateUtils;
import com.jeethink.common.utils.SecurityUtils;
import com.jeethink.system.domain.ZyjrCarAccount;
import com.jeethink.system.domain.vo.carVo;
import com.jeethink.system.mapper.ExamineMapper;
import com.jeethink.system.mapper.ZyjrCarAccountMapper;
import com.jeethink.system.service.IZyjrCarAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrCarMapper;
import com.jeethink.system.domain.ZyjrCar;
import com.jeethink.system.service.IZyjrCarService;

/**
 * 车商信息Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-14
 */
@Service
public class ZyjrCarServiceImpl implements IZyjrCarService 
{
    @Autowired
    private ZyjrCarMapper zyjrCarMapper;
    @Autowired
    private IZyjrCarAccountService zyjrCarAccountService;
    @Autowired
    private ZyjrCarAccountMapper accountMapper;
    @Autowired
    private ExamineMapper examineMapper;


    /**
     * 查询车商信息
     * 
     * @param id 车商信息ID
     * @return 车商信息
     */
    @Override
    public ZyjrCar selectZyjrCarById(Long id)
    {
        return zyjrCarMapper.selectZyjrCarById(id);
    }

    /**
     * 查询车商信息列表
     * 
     * @param zyjrCar 车商信息
     * @return 车商信息
     */
    @Override
    public List<ZyjrCar> selectZyjrCarList(ZyjrCar zyjrCar)
    {
        return zyjrCarMapper.selectZyjrCarList(zyjrCar);
    }

    @Override
    public List<ZyjrCar> selectZyjrCarLists(String userId) {
        return zyjrCarMapper.selectZyjrCarLists(userId);
    }

    /**
     * 新增车商信息
     * 
     * @param zyjrCar 车商信息
     * @return 结果
     */
    @Override
    public int insertZyjrCar(ZyjrCar zyjrCar)
    {
        zyjrCar.setCreateTime(DateUtils.getNowDate());

        return zyjrCarMapper.insertZyjrCar(zyjrCar);
    }

    /**
     * 修改车商信息
     * 
     * @param zyjrCar 车商信息
     * @return 结果
     */
    @Override
    public int updateZyjrCar(ZyjrCar zyjrCar)
    {
        zyjrCar.setUpdateTime(DateUtils.getNowDate());

       if(zyjrCar!=null&&zyjrCar.getZyjrCarAccount()!=null&&zyjrCar.getZyjrCarAccount().size()>0) {
           List<ZyjrCarAccount> zyjrCarAccount = zyjrCar.getZyjrCarAccount();

           zyjrCarAccountService.deleteZyjrCarAccountById(zyjrCar.getId());
           for (ZyjrCarAccount a: zyjrCarAccount ) {
               a.setZyjrCarId(String.valueOf(zyjrCar.getId()));

           }
           accountMapper.insertTestList(zyjrCar.getZyjrCarAccount());



       }

        return zyjrCarMapper.updateZyjrCar(zyjrCar);
    }


    /**
     * 批量删除车商信息
     * 
     * @param ids 需要删除的车商信息ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCarByIds(Long[] ids)
    {


        return zyjrCarMapper.deleteZyjrCarByIds(ids);
    }

    /**
     * 删除车商信息信息
     * 
     * @param id 车商信息ID
     * @return 结果
     */
    @Override
    public int deleteZyjrCarById(Long id)
    {


        return zyjrCarMapper.deleteZyjrCarById(id);
    }
}
