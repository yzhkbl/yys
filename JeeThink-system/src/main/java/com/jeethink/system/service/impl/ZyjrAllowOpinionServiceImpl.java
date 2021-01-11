package com.jeethink.system.service.impl;

import java.util.List;

import com.jeethink.system.mapper.StageExamineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrAllowOpinionMapper;
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
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
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
     * @param zyjrAllowOpinion 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrAllowOpinion(ZyjrAllowOpinion zyjrAllowOpinion)
    {   ZyjrAllowOpinion o = selectZyjrAllowOpinionById(zyjrAllowOpinion.getTransactionCode());
        if(o==null) {
            return zyjrAllowOpinionMapper.insertZyjrAllowOpinion(zyjrAllowOpinion);
        }else {

            return zyjrAllowOpinionMapper.updateZyjrAllowOpinion(zyjrAllowOpinion);
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
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrAllowOpinionById(Long id)
    {
        return zyjrAllowOpinionMapper.deleteZyjrAllowOpinionById(id);
    }
}
