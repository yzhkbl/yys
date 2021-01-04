package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;
import org.springframework.security.core.parameters.P;

/**
 * 文件信息对象 sys_file_info
 * 
 * @author jeethink
 * @date 2020-12-16
 */
public class SysFileInfo
{
    //private static final long serialVersionUID = 1L;

    /** 文件id */
    private Long fileId;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String fileName;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    private String id;

    private Long photoCarId;
    private Long photoLenderId;
    private Long photoCreditId;
    private Long photoHouseId;


    private String bankId;
    private String baoxian;

    public String getBaoxian() {
        return baoxian;
    }

    public void setBaoxian(String baoxian) {
        this.baoxian = baoxian;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public void setPhotoCarId(Long photoCarId)
    {
        this.photoCarId = photoCarId;
    }

    public Long getPhotoCarId()
    {
        return photoCarId;
    }
    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setFileId(Long fileId) 
    {
        this.fileId = fileId;
    }

    public Long getFileId() 
    {
        return fileId;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }

    public Long getPhotoLenderId() {
        return photoLenderId;
    }

    public void setPhotoLenderId(Long photoLenderId) {
        this.photoLenderId = photoLenderId;
    }

    public Long getPhotoCreditId() {
        return photoCreditId;
    }

    public void setPhotoCreditId(Long photoCreditId) {
        this.photoCreditId = photoCreditId;
    }

    public Long getPhotoHouseId() {
        return photoHouseId;
    }

    public void setPhotoHouseId(Long photoHouseId) {
        this.photoHouseId = photoHouseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fileId", getFileId())
            .append("fileName", getFileName())
            .append("filePath", getFilePath())
                .append("id",getId())
                .append("photoCarId",getPhotoCarId())
                .append("bankId",getBankId())
                .append("photoLenderId",getPhotoLenderId())
                .append("photoCreditId",getPhotoCreditId())
                .append("photoHouseId",getPhotoHouseId())
            .toString();
    }
}
