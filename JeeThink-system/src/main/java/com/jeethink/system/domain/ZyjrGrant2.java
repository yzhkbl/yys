package com.jeethink.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_grant
 * 
 * @author jeethink
 * @date 2021-03-10
 */
@Data
public class ZyjrGrant2 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 保单类型 */
    @Excel(name = "保单类型")
    private String policyType;

    /** 保险公司 */
    @Excel(name = "保险公司")
    private String insuranceCompany;

    /** 保险金额 */
    @Excel(name = "保险金额")
    private String insuranceAmount;

    /** 保单号 */
    @Excel(name = "保单号")
    private String policyCode;

    /** 抵押省市 */
    @Excel(name = "抵押省市")
    private String mortgageCity;

    /** 抵押渠道 */
    @Excel(name = "抵押渠道")
    private String mortgageChannel;

    /** $column.columnComment */
    @Excel(name = "抵押渠道")
    private String transactionCode;

    private Integer orderState;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPolicyType(String policyType) 
    {
        this.policyType = policyType;
    }

    public String getPolicyType() 
    {
        return policyType;
    }
    public void setInsuranceCompany(String insuranceCompany) 
    {
        this.insuranceCompany = insuranceCompany;
    }

    public String getInsuranceCompany() 
    {
        return insuranceCompany;
    }
    public void setInsuranceAmount(String insuranceAmount) 
    {
        this.insuranceAmount = insuranceAmount;
    }

    public String getInsuranceAmount() 
    {
        return insuranceAmount;
    }
    public void setPolicyCode(String policyCode) 
    {
        this.policyCode = policyCode;
    }

    public String getPolicyCode() 
    {
        return policyCode;
    }
    public void setMortgageCity(String mortgageCity) 
    {
        this.mortgageCity = mortgageCity;
    }

    public String getMortgageCity() 
    {
        return mortgageCity;
    }
    public void setMortgageChannel(String mortgageChannel) 
    {
        this.mortgageChannel = mortgageChannel;
    }

    public String getMortgageChannel() 
    {
        return mortgageChannel;
    }
    public void setTransactionCode(String transactionCode) 
    {
        this.transactionCode = transactionCode;
    }

    public String getTransactionCode() 
    {
        return transactionCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("policyType", getPolicyType())
            .append("insuranceCompany", getInsuranceCompany())
            .append("insuranceAmount", getInsuranceAmount())
            .append("policyCode", getPolicyCode())
            .append("mortgageCity", getMortgageCity())
            .append("mortgageChannel", getMortgageChannel())
            .append("transactionCode", getTransactionCode())
            .toString();
    }
}
