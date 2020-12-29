package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * flow对象 zyjr_bank_flow
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public class ZyjrBankFlow
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** zyjr_bank的id */
    @Excel(name = "zyjr_bank的id")
    private String bankId;

    /** 流程名称 */
    @Excel(name = "流程名称")
    private String flowName;

    /** 流程编码 */
    @Excel(name = "流程编码")
    private String flowCode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBankId(String bankId) 
    {
        this.bankId = bankId;
    }

    public String getBankId() 
    {
        return bankId;
    }
    public void setFlowName(String flowName) 
    {
        this.flowName = flowName;
    }

    public String getFlowName() 
    {
        return flowName;
    }
    public void setFlowCode(String flowCode) 
    {
        this.flowCode = flowCode;
    }

    public String getFlowCode() 
    {
        return flowCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())

            .append("bankId", getBankId())
            .append("flowName", getFlowName())
            .append("flowCode", getFlowCode())
            .toString();
    }
}
