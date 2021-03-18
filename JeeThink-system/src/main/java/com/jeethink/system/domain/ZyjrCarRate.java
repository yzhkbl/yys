package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_car_rate
 * 
 * @author jeethink
 * @date 2021-03-16
 */
public class ZyjrCarRate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 分期期数 */
    @Excel(name = "分期期数")
    private String stage;

    /** 银行基准利率 */
    @Excel(name = "银行基准利率")
    private String interestRate;

    /** 应付费率 */
    @Excel(name = "应付费率")
    private String ratePayable;

    /** 应收费率 */
    @Excel(name = "应收费率")
    private String chargeableRate;

    /** 车商合作方案id */
    @Excel(name = "车商合作方案id")
    private String programmeId;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setStage(String stage) 
    {
        this.stage = stage;
    }

    public String getStage() 
    {
        return stage;
    }
    public void setInterestRate(String interestRate) 
    {
        this.interestRate = interestRate;
    }

    public String getInterestRate() 
    {
        return interestRate;
    }
    public void setRatePayable(String ratePayable) 
    {
        this.ratePayable = ratePayable;
    }

    public String getRatePayable() 
    {
        return ratePayable;
    }
    public void setChargeableRate(String chargeableRate) 
    {
        this.chargeableRate = chargeableRate;
    }

    public String getChargeableRate() 
    {
        return chargeableRate;
    }
    public void setProgrammeId(String programmeId) 
    {
        this.programmeId = programmeId;
    }

    public String getProgrammeId() 
    {
        return programmeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("stage", getStage())
            .append("interestRate", getInterestRate())
            .append("ratePayable", getRatePayable())
            .append("chargeableRate", getChargeableRate())
            .append("programmeId", getProgrammeId())
            .toString();
    }
}
