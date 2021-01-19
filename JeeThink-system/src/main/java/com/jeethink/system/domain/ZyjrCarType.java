package com.jeethink.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * carType对象 zyjr_car_type
 * 
 * @author jeethink
 * @date 2021-01-19
 */
public class ZyjrCarType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String carPrice;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer carType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String frameNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String engineNo;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String carBrands;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String carSeries;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String carSpecs;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal systemCarPrice;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String licensePlateNo;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCarPrice(String carPrice) 
    {
        this.carPrice = carPrice;
    }

    public String getCarPrice() 
    {
        return carPrice;
    }
    public void setCarType(Integer carType) 
    {
        this.carType = carType;
    }

    public Integer getCarType() 
    {
        return carType;
    }
    public void setFrameNo(String frameNo) 
    {
        this.frameNo = frameNo;
    }

    public String getFrameNo() 
    {
        return frameNo;
    }
    public void setEngineNo(String engineNo) 
    {
        this.engineNo = engineNo;
    }

    public String getEngineNo() 
    {
        return engineNo;
    }
    public void setCarBrands(String carBrands) 
    {
        this.carBrands = carBrands;
    }

    public String getCarBrands() 
    {
        return carBrands;
    }
    public void setCarSeries(String carSeries) 
    {
        this.carSeries = carSeries;
    }

    public String getCarSeries() 
    {
        return carSeries;
    }
    public void setCarSpecs(String carSpecs) 
    {
        this.carSpecs = carSpecs;
    }

    public String getCarSpecs() 
    {
        return carSpecs;
    }
    public void setSystemCarPrice(BigDecimal systemCarPrice) 
    {
        this.systemCarPrice = systemCarPrice;
    }

    public BigDecimal getSystemCarPrice() 
    {
        return systemCarPrice;
    }
    public void setLicensePlateNo(String licensePlateNo) 
    {
        this.licensePlateNo = licensePlateNo;
    }

    public String getLicensePlateNo() 
    {
        return licensePlateNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("carPrice", getCarPrice())
            .append("carType", getCarType())
            .append("frameNo", getFrameNo())
            .append("engineNo", getEngineNo())
            .append("carBrands", getCarBrands())
            .append("carSeries", getCarSeries())
            .append("carSpecs", getCarSpecs())
            .append("systemCarPrice", getSystemCarPrice())
            .append("licensePlateNo", getLicensePlateNo())
            .toString();
    }
}
