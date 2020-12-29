package com.jeethink.system.mapper;

import java.util.List;
import com.jeethink.system.domain.ZyjrPhotoCredit;
import org.apache.ibatis.annotations.Param;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public interface ZyjrPhotoCreditMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param userId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrPhotoCredit selectZyjrPhotoCreditById(@Param("userId") Long userId, @Param("transactionCode") String transactionCode);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrPhotoCredit 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrPhotoCredit> selectZyjrPhotoCreditList(ZyjrPhotoCredit zyjrPhotoCredit);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrPhotoCredit 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrPhotoCredit(ZyjrPhotoCredit zyjrPhotoCredit);

    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrPhotoCredit 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrPhotoCredit(ZyjrPhotoCredit zyjrPhotoCredit);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrPhotoCreditById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrPhotoCreditByIds(Long[] ids);
}
