package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 【请填写功能名称】对象 zyjr_car_programme
 * 
 * @author jeethink
 * @date 2021-03-16
 */
public class ZyjrCarProgramme extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 方案名称 */
    @Excel(name = "方案名称")
    private String name;

    /** 产品代码 */
    @Excel(name = "产品代码")
    private String code;

    /** 所属银行 */
    @Excel(name = "所属银行")
    private String icbc;

    /** 车辆品牌 */
    @Excel(name = "车辆品牌")
    private String carBrand;

    /** 车辆类型 */
    @Excel(name = "车辆类型")
    private String type;

    /** 业务区域 */
    @Excel(name = "业务区域")
    private String area;

    /** 车商id */
    @Excel(name = "车商id")
    private String carId;
    private List<ZyjrCarRate> zyjrCarRate;
    private String brandInput;
    private String areaInput;

    public String getBrandInput() {
        return brandInput;
    }

    public void setBrandInput(String brandInput) {
        this.brandInput = brandInput;
    }

    public String getAreaInput() {
        return areaInput;
    }

    public void setAreaInput(String areaInput) {
        this.areaInput = areaInput;
    }

    public List<ZyjrCarRate> getZyjrCarRate() {
        return zyjrCarRate;
    }

    public void setZyjrCarRate(List<ZyjrCarRate> zyjrCarRate) {
        this.zyjrCarRate = zyjrCarRate;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setIcbc(String icbc) 
    {
        this.icbc = icbc;
    }

    public String getIcbc() 
    {
        return icbc;
    }
    public void setCarBrand(String carBrand) 
    {
        this.carBrand = carBrand;
    }

    public String getCarBrand() 
    {
        return carBrand;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setCarId(String carId) 
    {
        this.carId = carId;
    }

    public String getCarId() 
    {
        return carId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("name", getName())
            .append("code", getCode())
            .append("icbc", getIcbc())
            .append("carBrand", getCarBrand())
            .append("remark", getRemark())
            .append("type", getType())
            .append("area", getArea())
            .append("carId", getCarId())
            .toString();
    }
}
