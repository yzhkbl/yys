package com.jeethink.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 【请填写功能名称】对象 zyjr_start_page
 * 
 * @author jeethink
 * @date 2020-12-14
 */
public class ZyjrStartPage
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

    private String realAddress;

    private String creditState;
    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRealAddress() {
        return realAddress;
    }

    public void setRealAddress(String realAddress) {
        this.realAddress = realAddress;
    }

    public void setCreditState(String creditState)
    {
        this.creditState = creditState;
    }

    public String getCreditState()
    {
        return creditState;
    }

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


}
