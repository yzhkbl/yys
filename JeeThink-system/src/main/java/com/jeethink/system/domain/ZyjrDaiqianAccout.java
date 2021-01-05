package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_daiqian_accout
 * 
 * @author jeethink
 * @date 2021-01-05
 */
public class ZyjrDaiqianAccout extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 订单号 */
    @Excel(name = "订单号")
    private String transactionCode;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    /** $column.columnComment */
    @Excel(name = "状态")
    private String accountId;

    /** $column.columnComment */
    @Excel(name = "状态")
    private String accountOne;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
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
    public void setAccountId(String accountId) 
    {
        this.accountId = accountId;
    }

    public String getAccountId() 
    {
        return accountId;
    }
    public void setAccountOne(String accountOne) 
    {
        this.accountOne = accountOne;
    }

    public String getAccountOne() 
    {
        return accountOne;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("transactionCode", getTransactionCode())
            .append("state", getState())
            .append("accountId", getAccountId())
            .append("accountOne", getAccountOne())
            .toString();
    }
}
