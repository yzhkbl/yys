package com.jeethink.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jeethink.common.core.domain.entity.SysUser;
import com.jeethink.common.utils.DateUtils;
import com.jeethink.system.domain.ZyjrBorrower;
import com.jeethink.system.domain.ZyjrSubmitStateAllow;
import com.jeethink.system.domain.vo.Xiaoxi;
import com.jeethink.system.mapper.*;
import com.jeethink.system.util.PushMessageByPushIdTest;
import com.jeethink.system.util.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.domain.ZyjrAllowOpinion;
import com.jeethink.system.service.IZyjrAllowOpinionService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author jeethink
 * @date 2021-01-04
 */
@Service
public class ZyjrAllowOpinionServiceImpl implements IZyjrAllowOpinionService
{
    @Autowired
    private ZyjrAllowOpinionMapper zyjrAllowOpinionMapper;
    @Autowired
    private StageExamineMapper stageExamineMapper;
    @Autowired
    private ExamineMapper examineMapper;
    @Autowired
    private ZyjrBorrowerMapper zyjrBorrowerMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    /**
     * 查询【请填写功能名称】
     *
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrAllowOpinion selectZyjrAllowOpinionById(String transactionCode)
    {
        return zyjrAllowOpinionMapper.selectZyjrAllowOpinionById(transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param zyjrAllowOpinion 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrAllowOpinion> selectZyjrAllowOpinionList(ZyjrAllowOpinion zyjrAllowOpinion)
    {
        return zyjrAllowOpinionMapper.selectZyjrAllowOpinionList(zyjrAllowOpinion);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param zyjrAllowOpinion 初审审批（插入）
     * @return 结果
     */
    @Override
    public int insertZyjrAllowOpinion(ZyjrAllowOpinion zyjrAllowOpinion)
    {
        String date = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date()).substring(11, 19);
        ZyjrAllowOpinion o = selectZyjrAllowOpinionById(zyjrAllowOpinion.getTransactionCode());
        ZyjrBorrower zyjrBorrower = zyjrBorrowerMapper.selectById(zyjrAllowOpinion.getTransactionCode());
        String date2 = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date());
        //System.err.println(o);
        if (zyjrAllowOpinion.getApprovalType() == 2) {
            /**ZyjrSubmitStateAllow zyjrSubmitStateAllow = new ZyjrSubmitStateAllow();
             zyjrSubmitStateAllow.setSubmitState(0);
             zyjrSubmitStateAllow.setTransactionCode(zyjrAllowOpinion.getTransactionCode());
             examineMapper.updateAllowState(zyjrSubmitStateAllow);*/
            String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
            PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(), zyjrAllowOpinion.getTransactionCode(), "初审退回", stringsList,zyjrAllowOpinion.getAdvise());
            Xiaoxi xiaoxi=new Xiaoxi();
            xiaoxi.setCode(zyjrAllowOpinion.getTransactionCode());
            xiaoxi.setData("您的客户:"+zyjrBorrower.getUserName()+"在初审退回了！(订单号"+zyjrAllowOpinion.getTransactionCode()+"),退回意见："+zyjrAllowOpinion.getAdvise());
            xiaoxi.setDate(date2);
            xiaoxi.setUser(zyjrBorrower.getUserId().toString());
            examineMapper.insertXiaoxi(xiaoxi);
        } else if (zyjrAllowOpinion.getApprovalType() == 1) {

            WebSocket webSocket = new WebSocket();
            //String date = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date()).substring(11, 19);
            webSocket.sendMessage("终审来新单了," + date + ",终审," + zyjrAllowOpinion.getTransactionCode() + "");
            String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
            PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(), zyjrAllowOpinion.getTransactionCode(), "初审通过", stringsList,zyjrAllowOpinion.getAdvise());
            Xiaoxi xiaoxi=new Xiaoxi();
            xiaoxi.setCode(zyjrAllowOpinion.getTransactionCode());
            xiaoxi.setData("您的客户:"+zyjrBorrower.getUserName()+"在初审通过了！(订单号"+zyjrAllowOpinion.getTransactionCode()+"),通过意见："+zyjrAllowOpinion.getAdvise());
            xiaoxi.setDate(date2);
            xiaoxi.setUser(zyjrBorrower.getUserId().toString());
            examineMapper.insertXiaoxi(xiaoxi);
        } else if (zyjrAllowOpinion.getApprovalType() == 3) {
            String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
            PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(), zyjrAllowOpinion.getTransactionCode(), "初审拒绝", stringsList,zyjrAllowOpinion.getAdvise());
            Xiaoxi xiaoxi=new Xiaoxi();
            xiaoxi.setCode(zyjrAllowOpinion.getTransactionCode());
            xiaoxi.setData("您的客户:"+zyjrBorrower.getUserName()+"在初审拒绝了！(订单号"+zyjrAllowOpinion.getTransactionCode()+"),拒绝意见："+zyjrAllowOpinion.getAdvise());
            xiaoxi.setDate(date2);
            xiaoxi.setUser(zyjrBorrower.getUserId().toString());
            examineMapper.insertXiaoxi(xiaoxi);
        }
        if(o!=null) {
            stageExamineMapper.deleteOpinion(zyjrAllowOpinion.getTransactionCode());
            zyjrAllowOpinionMapper.deleteZyjrAllowOpinionById(zyjrAllowOpinion.getTransactionCode());
            ZyjrAllowOpinion i = zyjrAllowOpinion;
            i.setAdvise(zyjrAllowOpinion.getAdvise()+";"+date2);
            return zyjrAllowOpinionMapper.insertZyjrAllowOpinion(i);
        }else {
            if (zyjrAllowOpinion.getApprovalType() == 2) {
                ZyjrSubmitStateAllow zyjrSubmitStateAllow = new ZyjrSubmitStateAllow();
                zyjrSubmitStateAllow.setSubmitState(0);
                zyjrSubmitStateAllow.setTransactionCode(zyjrAllowOpinion.getTransactionCode());
                examineMapper.updateAllowState(zyjrSubmitStateAllow);
                //String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
                //PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(), zyjrAllowOpinion.getTransactionCode(), "初审退回", stringsList);
            } /**else if (zyjrAllowOpinion.getApprovalType() == 1) {

                WebSocket webSocket = new WebSocket();
                String date = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date()).substring(11, 19);
                webSocket.sendMessage("终审来新单了," + date + ",终审," + zyjrAllowOpinion.getTransactionCode() + "");
                String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
                PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(), zyjrAllowOpinion.getTransactionCode(), "初审通过", stringsList);
            } else if (zyjrAllowOpinion.getApprovalType() == 3) {
                String stringsList = sysUserMapper.selectId(zyjrBorrower.getUserId());
                PushMessageByPushIdTest.tongzhi(zyjrBorrower.getUserName(), zyjrAllowOpinion.getTransactionCode(), "初审拒绝", stringsList);
            }*/
            ZyjrAllowOpinion i = zyjrAllowOpinion;
            i.setAdvise(zyjrAllowOpinion.getAdvise()+";"+date2);
            return zyjrAllowOpinionMapper.insertZyjrAllowOpinion(i);
        }

    }

    /**
     * 修改【请填写功能名称】
     *
     * @param zyjrAllowOpinion 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrAllowOpinion(ZyjrAllowOpinion zyjrAllowOpinion)
    {
        return zyjrAllowOpinionMapper.updateZyjrAllowOpinion(zyjrAllowOpinion);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrAllowOpinionByIds(Long[] ids)
    {
        return zyjrAllowOpinionMapper.deleteZyjrAllowOpinionByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param transactionCode 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrAllowOpinionById(String transactionCode)
    {
        return zyjrAllowOpinionMapper.deleteZyjrAllowOpinionById(transactionCode);
    }
}
