package com.jeethink.system.mapper;

import com.jeethink.system.domain.ZyjrGrantPhoto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author jeethink
 * @date 2021-01-09
 */
public interface ZyjrGrantPhotoMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param fileId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public ZyjrGrantPhoto selectZyjrGrantPhotoById(Long fileId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param zyjrGrantPhoto 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<ZyjrGrantPhoto> selectZyjrGrantPhotoList(ZyjrGrantPhoto zyjrGrantPhoto);

    /**
     * 新增【请填写功能名称】
     * 
     * @param zyjrGrantPhoto 【请填写功能名称】
     * @return 结果
     */
    public int insertZyjrGrantPhoto(ZyjrGrantPhoto zyjrGrantPhoto);
    int insertZyjrGrantPhoto2(ZyjrGrantPhoto info);
    int insertZyjrGrantPhoto3(ZyjrGrantPhoto info);
    /**
     * 修改【请填写功能名称】
     * 
     * @param zyjrGrantPhoto 【请填写功能名称】
     * @return 结果
     */
    public int updateZyjrGrantPhoto(ZyjrGrantPhoto zyjrGrantPhoto);

    /**
     * 删除【请填写功能名称】
     * 
     * @param fileId 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteZyjrGrantPhotoById(Long fileId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param fileIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteZyjrGrantPhotoByIds(Long[] fileIds);

    public int deleteByImage(Long imageId);
    int deleteByImage2(Long id);
    int deleteByImage3(Long id);
    List<ZyjrGrantPhoto> findImage(@Param("imageId") Long imageId);
    List<ZyjrGrantPhoto> findImage2(@Param("imageId") Long imageId);
    List<ZyjrGrantPhoto> findImage3(@Param("imageId") Long imageId);

    public int deleteByInstalments(Long instalmentsId);
    List<ZyjrGrantPhoto> findInstalments(@Param("instalmentsId") Long instalmentsId);

    public int deleteByVisit(Long visitId);
    List<ZyjrGrantPhoto> findVisit(@Param("visitId") Long visitId);

    public int deleteByLiushui(Long visitId);
    List<ZyjrGrantPhoto> findLiushui(@Param("liushuiId") Long liushuiId);



}
