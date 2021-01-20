package com.jeethink.system.domain;

import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * mentInfo对象 zyjr_pay_ment_info
 * 
 * @author jeethink
 * @date 2021-01-19
 */
public class ZyjrPayMentInfo2
{

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer payMode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer payeeType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String cooperateAgencyCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String insuranceAgencyCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String recommendAgencyCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer agencyReceiveMode1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal agencyReceiveAmt1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer agencyReceiveType1;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer agencyReceiveMode2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal agencyReceiveAmt2;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer agencyReceiveType2;

    public void setPayMode(Integer payMode) 
    {
        this.payMode = payMode;
    }

    public Integer getPayMode() 
    {
        return payMode;
    }
    public void setPayeeType(Integer payeeType) 
    {
        this.payeeType = payeeType;
    }

    public Integer getPayeeType() 
    {
        return payeeType;
    }
    public void setCooperateAgencyCode(String cooperateAgencyCode) 
    {
        this.cooperateAgencyCode = cooperateAgencyCode;
    }

    public String getCooperateAgencyCode() 
    {
        return cooperateAgencyCode;
    }
    public void setInsuranceAgencyCode(String insuranceAgencyCode) 
    {
        this.insuranceAgencyCode = insuranceAgencyCode;
    }

    public String getInsuranceAgencyCode() 
    {
        return insuranceAgencyCode;
    }
    public void setRecommendAgencyCode(String recommendAgencyCode) 
    {
        this.recommendAgencyCode = recommendAgencyCode;
    }

    public String getRecommendAgencyCode() 
    {
        return recommendAgencyCode;
    }
    public void setAgencyReceiveMode1(Integer agencyReceiveMode1) 
    {
        this.agencyReceiveMode1 = agencyReceiveMode1;
    }

    public Integer getAgencyReceiveMode1() 
    {
        return agencyReceiveMode1;
    }
    public void setAgencyReceiveAmt1(BigDecimal agencyReceiveAmt1) 
    {
        this.agencyReceiveAmt1 = agencyReceiveAmt1;
    }

    public BigDecimal getAgencyReceiveAmt1() 
    {
        return agencyReceiveAmt1;
    }
    public void setAgencyReceiveType1(Integer agencyReceiveType1) 
    {
        this.agencyReceiveType1 = agencyReceiveType1;
    }

    public Integer getAgencyReceiveType1() 
    {
        return agencyReceiveType1;
    }
    public void setAgencyReceiveMode2(Integer agencyReceiveMode2) 
    {
        this.agencyReceiveMode2 = agencyReceiveMode2;
    }

    public Integer getAgencyReceiveMode2() 
    {
        return agencyReceiveMode2;
    }
    public void setAgencyReceiveAmt2(BigDecimal agencyReceiveAmt2) 
    {
        this.agencyReceiveAmt2 = agencyReceiveAmt2;
    }

    public BigDecimal getAgencyReceiveAmt2() 
    {
        return agencyReceiveAmt2;
    }
    public void setAgencyReceiveType2(Integer agencyReceiveType2) 
    {
        this.agencyReceiveType2 = agencyReceiveType2;
    }

    public Integer getAgencyReceiveType2() 
    {
        return agencyReceiveType2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("payMode", getPayMode())
            .append("payeeType", getPayeeType())
            .append("cooperateAgencyCode", getCooperateAgencyCode())
            .append("insuranceAgencyCode", getInsuranceAgencyCode())
            .append("recommendAgencyCode", getRecommendAgencyCode())
            .append("agencyReceiveMode1", getAgencyReceiveMode1())
            .append("agencyReceiveAmt1", getAgencyReceiveAmt1())
            .append("agencyReceiveType1", getAgencyReceiveType1())
            .append("agencyReceiveMode2", getAgencyReceiveMode2())
            .append("agencyReceiveAmt2", getAgencyReceiveAmt2())
            .append("agencyReceiveType2", getAgencyReceiveType2())
            .toString();
    }
}
