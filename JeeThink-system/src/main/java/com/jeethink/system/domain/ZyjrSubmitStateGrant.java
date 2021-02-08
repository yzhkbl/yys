package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_submit_state_grant
 * 
 * @author jeethink
 * @date 2021-02-07
 */
public class ZyjrSubmitStateGrant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String transactionCode;

    /** 授信提交状态 */
    @Excel(name = "授信提交状态")
    private Integer submitState;

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
    public void setSubmitState(Integer submitState) 
    {
        this.submitState = submitState;
    }

    public Integer getSubmitState() 
    {
        return submitState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("transactionCode", getTransactionCode())
            .append("submitState", getSubmitState())
            .toString();
    }
}
