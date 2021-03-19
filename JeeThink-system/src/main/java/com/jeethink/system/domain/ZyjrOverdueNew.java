package com.jeethink.system.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_overdue_new
 * 
 * @author jeethink
 * @date 2021-01-29
 */
@Data
public class ZyjrOverdueNew extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 借款人姓名 */
    @Excel(name = "借款人姓名")
    private String borrower;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phoneNumber;

    /** 银行卡号 */
    @Excel(name = "银行卡号")
    private String bankCard;

    /** 应还期数 */
    @Excel(name = "应还期数")
    private Long shouldStages;

    /** 逾期还款日期 */
    @Excel(name = "逾期还款日期")
    private String repaymentDate;

    /** 分期期数 */
    @Excel(name = "分期期数")
    private Long byStages;

    /** 车辆贷款金额 */
    @Excel(name = "车辆贷款金额")
    private BigDecimal loanAmount;

    /** 月还款金额 */
    @Excel(name = "月还款金额")
    private BigDecimal repaymentAmount;

    /** 滞纳金 */
    @Excel(name = "滞纳金")
    private BigDecimal lateFee;

    /** 当前逾期金额 */
    @Excel(name = "当前逾期金额")
    private BigDecimal overdueAmount;

    /** 累计违约次数 */
    @Excel(name = "累计违约次数")
    private Long cumulative;

    /** 附加费 */
    @Excel(name = "附加费")
    private BigDecimal surcharge;

    /** 连续违约次数 */
    @Excel(name = "连续违约次数")
    private Long continuity;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String transactionCode;
    private Date time;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBorrower(String borrower) 
    {
        this.borrower = borrower;
    }

    public String getBorrower() 
    {
        return borrower;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setBankCard(String bankCard) 
    {
        this.bankCard = bankCard;
    }

    public String getBankCard() 
    {
        return bankCard;
    }
    public void setShouldStages(Long shouldStages) 
    {
        this.shouldStages = shouldStages;
    }

    public Long getShouldStages() 
    {
        return shouldStages;
    }
    public void setRepaymentDate(String repaymentDate) 
    {
        this.repaymentDate = repaymentDate;
    }

    public String getRepaymentDate() 
    {
        return repaymentDate;
    }
    public void setByStages(Long byStages) 
    {
        this.byStages = byStages;
    }

    public Long getByStages() 
    {
        return byStages;
    }
    public void setLoanAmount(BigDecimal loanAmount) 
    {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getLoanAmount() 
    {
        return loanAmount;
    }
    public void setRepaymentAmount(BigDecimal repaymentAmount) 
    {
        this.repaymentAmount = repaymentAmount;
    }

    public BigDecimal getRepaymentAmount() 
    {
        return repaymentAmount;
    }
    public void setLateFee(BigDecimal lateFee) 
    {
        this.lateFee = lateFee;
    }

    public BigDecimal getLateFee() 
    {
        return lateFee;
    }
    public void setOverdueAmount(BigDecimal overdueAmount) 
    {
        this.overdueAmount = overdueAmount;
    }

    public BigDecimal getOverdueAmount() 
    {
        return overdueAmount;
    }
    public void setCumulative(Long cumulative) 
    {
        this.cumulative = cumulative;
    }

    public Long getCumulative() 
    {
        return cumulative;
    }
    public void setSurcharge(BigDecimal surcharge) 
    {
        this.surcharge = surcharge;
    }

    public BigDecimal getSurcharge() 
    {
        return surcharge;
    }
    public void setContinuity(Long continuity) 
    {
        this.continuity = continuity;
    }

    public Long getContinuity() 
    {
        return continuity;
    }
    public void setTransactionCode(String transactionCode) 
    {
        this.transactionCode = transactionCode;
    }

    public String getTransactionCode() 
    {
        return transactionCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("borrower", getBorrower())
            .append("idCard", getIdCard())
            .append("phoneNumber", getPhoneNumber())
            .append("bankCard", getBankCard())
            .append("shouldStages", getShouldStages())
            .append("repaymentDate", getRepaymentDate())
            .append("byStages", getByStages())
            .append("loanAmount", getLoanAmount())
            .append("repaymentAmount", getRepaymentAmount())
            .append("lateFee", getLateFee())
            .append("overdueAmount", getOverdueAmount())
            .append("cumulative", getCumulative())
            .append("surcharge", getSurcharge())
            .append("continuity", getContinuity())
            .append("transactionCode", getTransactionCode())
            .toString();
    }
}
