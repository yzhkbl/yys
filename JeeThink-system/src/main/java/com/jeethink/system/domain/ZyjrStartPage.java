package com.jeethink.system.domain;

import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 【请填写功能名称】对象 zyjr_start_page
 * 
 * @author jeethink
 * @date 2020-12-14
 */
public class ZyjrStartPage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 资金方 */
    @Excel(name = "资金方")
    private String fundSide;

    /** 业务发生地 */
    @Excel(name = "业务发生地")
    private String businessPlace;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Integer orderState;

    /** 身份验证码 */
    @Excel(name = "身份验证码")
    private Integer userId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String transactionCode;

    /** 内部订单号 */
    @Excel(name = "内部订单号")
    private String privateCode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFundSide(String fundSide) 
    {
        this.fundSide = fundSide;
    }

    public String getFundSide() 
    {
        return fundSide;
    }
    public void setBusinessPlace(String businessPlace) 
    {
        this.businessPlace = businessPlace;
    }

    public String getBusinessPlace() 
    {
        return businessPlace;
    }
    public void setOrderState(Integer orderState) 
    {
        this.orderState = orderState;
    }

    public Integer getOrderState() 
    {
        return orderState;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getUserId()
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
    public void setPrivateCode(String privateCode) 
    {
        this.privateCode = privateCode;
    }

    public String getPrivateCode() 
    {
        return privateCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("id", getId())
            .append("fundSide", getFundSide())
            .append("businessPlace", getBusinessPlace())
            .append("orderState", getOrderState())
            .append("userId", getUserId())
            .append("transactionCode", getTransactionCode())
            .append("privateCode", getPrivateCode())
            .toString();
    }
}