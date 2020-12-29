package com.jeethink.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.system.Helper.BizException;
import com.jeethink.system.domain.SysFileInfo;
import com.jeethink.system.mapper.SysFileInfoMapper;
import com.jeethink.system.util.androidUpload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeethink.system.mapper.ZyjrPhotoCarMapper;
import com.jeethink.system.domain.ZyjrPhotoCar;
import com.jeethink.system.service.IZyjrPhotoCarService;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@Service
@Slf4j
public class ZyjrPhotoCarServiceImpl implements IZyjrPhotoCarService 
{
    @Autowired
    private ZyjrPhotoCarMapper zyjrPhotoCarMapper;
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;


    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public ZyjrPhotoCar selectZyjrPhotoCarById(Long userId,String transactionCode)
    {
        return zyjrPhotoCarMapper.selectZyjrPhotoCarById(userId, transactionCode);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrPhotoCar 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<ZyjrPhotoCar> selectZyjrPhotoCarList(ZyjrPhotoCar zyjrPhotoCar)
    {
        return zyjrPhotoCarMapper.selectZyjrPhotoCarList(zyjrPhotoCar);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrPhotoCar 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertZyjrPhotoCar(ZyjrPhotoCar zyjrPhotoCar)
    {
        return zyjrPhotoCarMapper.insertZyjrPhotoCar(zyjrPhotoCar);
    }
/**
    public String testFiles(List<SysFileInfo>q) {
        List<String> pic=new ArrayList<>();
        for (int i = 0; i < q.size(); i++) {
            String a= androidUpload.upload(q.get(i).getFilePath());
            SysFileInfo info=new SysFileInfo();
            info.setFilePath(a);
            info.setPhotoCarId(q.get(i).getPhotoCarId());
            info.setFileName(q.get(i).getFileName());
            int ceshi=sysFileInfoMapper.insertSysFileInfo(info);
            if(ceshi<1){
                return "参数有误";
            }
            String as="http://192.168.31.82/dev-api"+a;
            pic.add(as);
        }
        return "操作成功";
    }
*/

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrPhotoCar 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateZyjrPhotoCar(ZyjrPhotoCar zyjrPhotoCar)
    {
        return zyjrPhotoCarMapper.updateZyjrPhotoCar(zyjrPhotoCar);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrPhotoCarByIds(Long[] ids)
    {
        return zyjrPhotoCarMapper.deleteZyjrPhotoCarByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteZyjrPhotoCarById(Long id)
    {
        return zyjrPhotoCarMapper.deleteZyjrPhotoCarById(id);
    }
}
