package com.jeethink.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeethink.system.domain.vo.BorrowerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrOverdueNewMapper;
import com.jeethink.system.domain.ZyjrOverdueNew;
import com.jeethink.system.service.IZyjrOverdueNewService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2021-01-29
 */
@Service
public class ZyjrOverdueNewServiceImpl implements IZyjrOverdueNewService 
{
    @Autowired
    private ZyjrOverdueNewMapper zyjrOverdueNewMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param transactionCode 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public Map<String, Object> selectZyjrOverdueNewById(String transactionCode)
    {   Map<String,Object> map = new HashMap<>();
        ZyjrOverdueNew zyjrOverdueNew = zyjrOverdueNewMapper.selectZyjrOverdueNewById(transactionCode);
        BorrowerVo borrowerVo = zyjrOverdueNewMapper.findBorrower(transactionCode);
        map.put("zyjrOverdueNew",zyjrOverdueNew);
        map.put("borrower",borrowerVo);
        return map;
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrOverdueNew 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrOverdueNew> selectZyjrOverdueNewList(ZyjrOverdueNew zyjrOverdueNew)
    {
        return zyjrOverdueNewMapper.selectZyjrOverdueNewList(zyjrOverdueNew);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrOverdueNew 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrOverdueNew(ZyjrOverdueNew zyjrOverdueNew)
    {
        if(selectZyjrOverdueNewById(zyjrOverdueNew.getTransactionCode())!=null){
            return zyjrOverdueNewMapper.updateZyjrOverdueNew(zyjrOverdueNew);
        }else {
            return zyjrOverdueNewMapper.insertZyjrOverdueNew(zyjrOverdueNew);
        }
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrOverdueNew 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrOverdueNew(ZyjrOverdueNew zyjrOverdueNew)
    {
        return zyjrOverdueNewMapper.updateZyjrOverdueNew(zyjrOverdueNew);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrOverdueNewByIds(Long[] ids)
    {
        return zyjrOverdueNewMapper.deleteZyjrOverdueNewByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrOverdueNewById(Long id)
    {
        return zyjrOverdueNewMapper.deleteZyjrOverdueNewById(id);
    }
}
