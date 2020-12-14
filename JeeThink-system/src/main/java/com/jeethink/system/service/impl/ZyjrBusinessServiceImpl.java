package com.jeethink.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeethink.system.mapper.ZyjrBorrowerMapper;
import com.jeethink.system.mapper.ZyjrBusinessMapper;
import com.jeethink.system.mapper.ZyjrGuaranteeMapper;
import com.jeethink.system.mapper.ZyjrRelationMapper;
import com.jeethink.system.domain.ZyjrBorrower;
import com.jeethink.system.domain.ZyjrBusiness;
import com.jeethink.system.domain.ZyjrGuarantee;
import com.jeethink.system.domain.ZyjrRelation;
import com.jeethink.system.service.IZyjrBusinessService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-09
 */
@Service
public class ZyjrBusinessServiceImpl implements IZyjrBusinessService 
{
    @Autowired
    private ZyjrBusinessMapper zyjrBusinessMapper;
   /* @Autowired
    private ZyjrBorrowerMapper b;
    @Autowired
    ZyjrRelationMapper r;
    @Autowired
    ZyjrGuaranteeMapper g;*/


    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrBusiness selectZyjrBusinessById(Long id)
    {
        return zyjrBusinessMapper.selectZyjrBusinessById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrBusiness 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrBusiness> selectZyjrBusinessList(ZyjrBusiness zyjrBusiness)
    {
        return zyjrBusinessMapper.selectZyjrBusinessList(zyjrBusiness);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrBusiness 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrBusiness(ZyjrBusiness zyjrBusiness)
    {
        return zyjrBusinessMapper.insertZyjrBusiness(zyjrBusiness);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrBusiness 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrBusiness(ZyjrBusiness zyjrBusiness)
    {
        return zyjrBusinessMapper.updateZyjrBusiness(zyjrBusiness);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrBusinessByIds(Long[] ids)
    {
        return zyjrBusinessMapper.deleteZyjrBusinessByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrBusinessById(Long id)
    {
        return zyjrBusinessMapper.deleteZyjrBusinessById(id);
    }

/*	@Override
	public Map<String, Object> seleMap(String id) {
		Map<String,Object> a=new HashMap<>();
		ZyjrBusiness selectById = zyjrBusinessMapper.selectById(Long.parseLong(id));
		if(selectById!=null) {
			a.put("zyjrBusiness", selectById);
		}
		ZyjrBorrower selectById2 = b.selectById(Integer.parseInt(id));
		if(selectById2!=null) {
			a.put("zyjrBorrower", selectById2);
		}
		ZyjrRelation selectById4 = r.selectById(Integer.parseInt(id));
		if(selectById4!=null) {
			a.put("zyjrRelation", selectById4);
		}
		ZyjrGuarantee selectById3 = g.selectById(Integer.parseInt(id));
		if(selectById3!=null) {
			a.put("zyjrGuarantee", selectById3);
		}
		return a;
	}*/
}
