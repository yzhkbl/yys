package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_company_guarantee
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public class ZyjrCompanyGuarantee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    private String isAny;

    /** 公司注册名称 */
    @Excel(name = "公司注册名称")
    private String companyName;

    /** 企业类型 */
    @Excel(name = "企业类型")
    private String enterpriseType;

    /** 注册资金（万元） */
    @Excel(name = "注册资金", readConverterExp = "万=元")
    private String registerMoney;

    /** 成立日期 */
    @Excel(name = "成立日期")
    private String establishTime;

    /** 经营年限 */
    @Excel(name = "经营年限")
    private String operationPeriod;

    /** 公司所属城市 */
    @Excel(name = "公司所属城市")
    private String companyCity;

    /** 公司地址 */
    @Excel(name = "公司地址")
    private String companyAddress;

    /** 法人身份证号 */
    @Excel(name = "法人身份证号")
    private String corporateId;

    /** 法人手机号 */
    @Excel(name = "法人手机号")
    private String corporatePhone;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String transactionCode;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Integer orderState;

    /** 身份识别码 */
    @Excel(name = "身份识别码")
    private Long userId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setEnterpriseType(String enterpriseType) 
    {
        this.enterpriseType = enterpriseType;
    }

    public String getEnterpriseType() 
    {
        return enterpriseType;
    }
    public void setRegisterMoney(String registerMoney) 
    {
        this.registerMoney = registerMoney;
    }

    public String getRegisterMoney() 
    {
        return registerMoney;
    }
    public void setEstablishTime(String establishTime) 
    {
        this.establishTime = establishTime;
    }

    public String getEstablishTime() 
    {
        return establishTime;
    }
    public void setOperationPeriod(String operationPeriod) 
    {
        this.operationPeriod = operationPeriod;
    }

    public String getOperationPeriod() 
    {
        return operationPeriod;
    }
    public void setCompanyCity(String companyCity) 
    {
        this.companyCity = companyCity;
    }

    public String getCompanyCity() 
    {
        return companyCity;
    }
    public void setCompanyAddress(String companyAddress) 
    {
        this.companyAddress = companyAddress;
    }

    public String getCompanyAddress() 
    {
        return companyAddress;
    }
    public void setCorporateId(String corporateId) 
    {
        this.corporateId = corporateId;
    }

    public String getCorporateId() 
    {
        return corporateId;
    }
    public void setCorporatePhone(String corporatePhone) 
    {
        this.corporatePhone = corporatePhone;
    }

    public String getCorporatePhone() 
    {
        return corporatePhone;
    }
    public void setTransactionCode(String transactionCode) 
    {
        this.transactionCode = transactionCode;
    }

    public String getTransactionCode() 
    {
        return transactionCode;
    }
    public void setOrderState(Integer orderState) 
    {
        this.orderState = orderState;
    }

    public Integer getOrderState() 
    {
        return orderState;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public String getIsAny() {
        return isAny;
    }

    public void setIsAny(String isAny) {
        this.isAny = isAny;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isAny",getIsAny())
            .append("companyName", getCompanyName())
            .append("enterpriseType", getEnterpriseType())
            .append("registerMoney", getRegisterMoney())
            .append("establishTime", getEstablishTime())
            .append("operationPeriod", getOperationPeriod())
            .append("companyCity", getCompanyCity())
            .append("companyAddress", getCompanyAddress())
            .append("corporateId", getCorporateId())
            .append("corporatePhone", getCorporatePhone())
            .append("transactionCode", getTransactionCode())
            .append("orderState", getOrderState())
            .append("userId", getUserId())
            .toString();
    }
}
