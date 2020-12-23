package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_insurance
 * 
 * @author jeethink
 * @date 2020-12-23
 */
public class ZyjrInsurance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 保险公司 */
    @Excel(name = "保险公司")
    private String insuranceCompany;

    /** 保单金额 */
    @Excel(name = "保单金额")
    private String money;

    /** 车商id */
    @Excel(name = "车商id")
    private String zyjrCarId;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 订单号 */
    @Excel(name = "订单号")
    private String transactionCode;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setInsuranceCompany(String insuranceCompany) 
    {
        this.insuranceCompany = insuranceCompany;
    }

    public String getInsuranceCompany() 
    {
        return insuranceCompany;
    }
    public void setMoney(String money) 
    {
        this.money = money;
    }

    public String getMoney() 
    {
        return money;
    }
    public void setZyjrCarId(String zyjrCarId) 
    {
        this.zyjrCarId = zyjrCarId;
    }

    public String getZyjrCarId() 
    {
        return zyjrCarId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setTransactionCode(String transactionCode) 
    {
        this.transactionCode = transactionCode;
    }

    public String getTransactionCode() 
    {
        return transactionCode;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("insuranceCompany", getInsuranceCompany())
            .append("money", getMoney())
            .append("zyjrCarId", getZyjrCarId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("userId", getUserId())
            .append("transactionCode", getTransactionCode())
            .append("state", getState())
            .toString();
    }
}
