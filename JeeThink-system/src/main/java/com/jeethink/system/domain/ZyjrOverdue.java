package com.jeethink.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * overdue对象 zyjr_overdue
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public class ZyjrOverdue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String userName;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String identityCard;

    /** 分期期数 */
    @Excel(name = "分期期数")
    private String installmentPeriod;

    /** 分期金额 */
    @Excel(name = "分期金额")
    private String instalmentAmount;

    /** 月还款额 */
    @Excel(name = "月还款额")
    private String monthlyPayment;

    /** 还款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "还款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date repaymentDate;

    /** 应还期数 */
    @Excel(name = "应还期数")
    private String shouldApplicable;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private String state;

    /** 处理人员 */
    @Excel(name = "处理人员")
    private String processingStaff;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setIdentityCard(String identityCard) 
    {
        this.identityCard = identityCard;
    }

    public String getIdentityCard() 
    {
        return identityCard;
    }
    public void setInstallmentPeriod(String installmentPeriod) 
    {
        this.installmentPeriod = installmentPeriod;
    }

    public String getInstallmentPeriod() 
    {
        return installmentPeriod;
    }
    public void setInstalmentAmount(String instalmentAmount) 
    {
        this.instalmentAmount = instalmentAmount;
    }

    public String getInstalmentAmount() 
    {
        return instalmentAmount;
    }
    public void setMonthlyPayment(String monthlyPayment) 
    {
        this.monthlyPayment = monthlyPayment;
    }

    public String getMonthlyPayment() 
    {
        return monthlyPayment;
    }
    public void setRepaymentDate(Date repaymentDate) 
    {
        this.repaymentDate = repaymentDate;
    }

    public Date getRepaymentDate() 
    {
        return repaymentDate;
    }
    public void setShouldApplicable(String shouldApplicable) 
    {
        this.shouldApplicable = shouldApplicable;
    }

    public String getShouldApplicable() 
    {
        return shouldApplicable;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setProcessingStaff(String processingStaff) 
    {
        this.processingStaff = processingStaff;
    }

    public String getProcessingStaff() 
    {
        return processingStaff;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userName", getUserName())
            .append("identityCard", getIdentityCard())
            .append("installmentPeriod", getInstallmentPeriod())
            .append("instalmentAmount", getInstalmentAmount())
            .append("monthlyPayment", getMonthlyPayment())
            .append("repaymentDate", getRepaymentDate())
            .append("shouldApplicable", getShouldApplicable())
            .append("state", getState())
            .append("processingStaff", getProcessingStaff())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
