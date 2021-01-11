package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_allow_opinion
 * 
 * @author jeethink
 * @date 2021-01-11
 */
public class ZyjrAllowOpinion extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 初审意见 */
    @Excel(name = "初审意见")
    private String advise;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private Integer approvalType;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private String transactionCode;

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
    public void setAdvise(String advise) 
    {
        this.advise = advise;
    }

    public String getAdvise() 
    {
        return advise;
    }
    public void setApprovalType(Integer approvalType) 
    {
        this.approvalType = approvalType;
    }

    public Integer getApprovalType() 
    {
        return approvalType;
    }
    public void setTransactionCode(String transactionCode) 
    {
        this.transactionCode = transactionCode;
    }

    public String getTransactionCode() 
    {
        return transactionCode;
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
            .append("advise", getAdvise())
            .append("approvalType", getApprovalType())
            .append("transactionCode", getTransactionCode())
            .append("userId", getUserId())
            .toString();
    }
}
