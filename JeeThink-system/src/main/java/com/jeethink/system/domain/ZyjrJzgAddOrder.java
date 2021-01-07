package com.jeethink.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_jzg_add_order
 * 
 * @author jeethink
 * @date 2020-12-31
 */
public class ZyjrJzgAddOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String vin;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String carLicense;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String recordBrand;

    private String transactionCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long engineNum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String service;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date recordDate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long provinceId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long userId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String regionCodeStyle;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long cityId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String productType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String imageList;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String thirdImageList;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String appendImageList;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String thirdAppendImageList;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String videoPath;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String orderName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String orderPhone;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer businessPrice;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String data;
    private Long id;
    private String pic;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public void setVin(String vin)
    {
        this.vin = vin;
    }

    public String getVin() 
    {
        return vin;
    }
    public void setCarLicense(String carLicense) 
    {
        this.carLicense = carLicense;
    }

    public String getCarLicense() 
    {
        return carLicense;
    }
    public void setRecordBrand(String recordBrand) 
    {
        this.recordBrand = recordBrand;
    }

    public String getRecordBrand() 
    {
        return recordBrand;
    }
    public void setEngineNum(Long engineNum) 
    {
        this.engineNum = engineNum;
    }

    public Long getEngineNum() 
    {
        return engineNum;
    }
    public void setService(String service) 
    {
        this.service = service;
    }

    public String getService() 
    {
        return service;
    }
    public void setRecordDate(Date recordDate) 
    {
        this.recordDate = recordDate;
    }

    public Date getRecordDate() 
    {
        return recordDate;
    }
    public void setProvinceId(Long provinceId) 
    {
        this.provinceId = provinceId;
    }

    public Long getProvinceId() 
    {
        return provinceId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setRegionCodeStyle(String regionCodeStyle) 
    {
        this.regionCodeStyle = regionCodeStyle;
    }

    public String getRegionCodeStyle() 
    {
        return regionCodeStyle;
    }
    public void setCityId(Long cityId) 
    {
        this.cityId = cityId;
    }

    public Long getCityId() 
    {
        return cityId;
    }
    public void setProductType(String productType) 
    {
        this.productType = productType;
    }

    public String getProductType() 
    {
        return productType;
    }
    public void setImageList(String imageList) 
    {
        this.imageList = imageList;
    }

    public String getImageList() 
    {
        return imageList;
    }
    public void setThirdImageList(String thirdImageList) 
    {
        this.thirdImageList = thirdImageList;
    }

    public String getThirdImageList() 
    {
        return thirdImageList;
    }
    public void setAppendImageList(String appendImageList) 
    {
        this.appendImageList = appendImageList;
    }

    public String getAppendImageList() 
    {
        return appendImageList;
    }
    public void setThirdAppendImageList(String thirdAppendImageList) 
    {
        this.thirdAppendImageList = thirdAppendImageList;
    }

    public String getThirdAppendImageList() 
    {
        return thirdAppendImageList;
    }
    public void setVideoPath(String videoPath) 
    {
        this.videoPath = videoPath;
    }

    public String getVideoPath() 
    {
        return videoPath;
    }
    public void setOrderName(String orderName) 
    {
        this.orderName = orderName;
    }

    public String getOrderName() 
    {
        return orderName;
    }
    public void setOrderPhone(String orderPhone) 
    {
        this.orderPhone = orderPhone;
    }

    public String getOrderPhone() 
    {
        return orderPhone;
    }
    public void setBusinessPrice(Integer businessPrice)
    {
        this.businessPrice = businessPrice;
    }

    public Integer getBusinessPrice()
    {
        return businessPrice;
    }
    public void setData(String data) 
    {
        this.data = data;
    }

    public String getData() 
    {
        return data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("vin", getVin())
            .append("carLicense", getCarLicense())
            .append("recordBrand", getRecordBrand())
            .append("engineNum", getEngineNum())
            .append("service", getService())
            .append("recordDate", getRecordDate())
            .append("provinceId", getProvinceId())
            .append("userId", getUserId())
            .append("regionCodeStyle", getRegionCodeStyle())
            .append("cityId", getCityId())
            .append("productType", getProductType())
            .append("imageList", getImageList())
            .append("thirdImageList", getThirdImageList())
            .append("appendImageList", getAppendImageList())
            .append("thirdAppendImageList", getThirdAppendImageList())
            .append("videoPath", getVideoPath())
            .append("orderName", getOrderName())
            .append("orderPhone", getOrderPhone())
            .append("businessPrice", getBusinessPrice())
            .append("data", getData())
                .append("transactionCode",getTransactionCode())
            .toString();
    }
}
