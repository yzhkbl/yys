package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_allow_contacts
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public class ZyjrAllowContacts extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 联系人姓名1 */
    @Excel(name = "联系人姓名1")
    private String nameOne;

    /** 与贷款人关系1 */
    @Excel(name = "与贷款人关系1")
    private String shipOne;

    /** 手机号1 */
    @Excel(name = "手机号1")
    private String phoneOne;

    /** 联系人姓名2 */
    @Excel(name = "联系人姓名2")
    private String nameTwo;

    /** 与借款人关系2 */
    @Excel(name = "与借款人关系2")
    private String shipTwo;

    /** 手机号2 */
    @Excel(name = "手机号2")
    private String phoneTwo;

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
    public void setNameOne(String nameOne) 
    {
        this.nameOne = nameOne;
    }

    public String getNameOne() 
    {
        return nameOne;
    }
    public void setShipOne(String shipOne) 
    {
        this.shipOne = shipOne;
    }

    public String getShipOne() 
    {
        return shipOne;
    }
    public void setPhoneOne(String phoneOne) 
    {
        this.phoneOne = phoneOne;
    }

    public String getPhoneOne() 
    {
        return phoneOne;
    }
    public void setNameTwo(String nameTwo) 
    {
        this.nameTwo = nameTwo;
    }

    public String getNameTwo() 
    {
        return nameTwo;
    }
    public void setShipTwo(String shipTwo) 
    {
        this.shipTwo = shipTwo;
    }

    public String getShipTwo() 
    {
        return shipTwo;
    }
    public void setPhoneTwo(String phoneTwo) 
    {
        this.phoneTwo = phoneTwo;
    }

    public String getPhoneTwo() 
    {
        return phoneTwo;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("nameOne", getNameOne())
            .append("shipOne", getShipOne())
            .append("phoneOne", getPhoneOne())
            .append("nameTwo", getNameTwo())
            .append("shipTwo", getShipTwo())
            .append("phoneTwo", getPhoneTwo())
            .append("transactionCode", getTransactionCode())
            .append("orderState", getOrderState())
            .append("userId", getUserId())
            .toString();
    }
}
