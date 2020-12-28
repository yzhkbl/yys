package com.jeethink.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

import lombok.Data;

/**
 * 【请填写功能名称】对象 zyjr_business
 * 
 * @author jeethink
 * @date 2020-12-09
 */
@Data
public class ZyjrBusiness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 销售团队 */
    @Excel(name = "销售团队")
    private String team;

    /** 车辆信息 */
    @Excel(name = "车辆信息")
    private Integer carInformation;

    /** 意向价格 */
    @Excel(name = "意向价格")
    private BigDecimal intentionPrice;

    /** 意向贷款金额 */
    @Excel(name = "意向贷款金额")
    private BigDecimal loanMoney;

    /** 意向贷款期限 */
    @Excel(name = "意向贷款期限")
    private Integer repayPeriod;

    /** 业务品种 */
    @Excel(name = "业务品种")
    private Integer carType;

    /** 身份唯一识别码 */
    @Excel(name = "身份唯一识别码")
    private Integer userId;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Integer orderState;
    private String name;//联查用户名
    private String transactionCode;
    private String operator;
    private String falseOperator;
    private String falseOperatorId;
    private String realAddress;


    public String getFalseOperator() {
        return falseOperator;
    }

    public void setFalseOperator(String falseOperator) {
        this.falseOperator = falseOperator;
    }

    public String getFalseOperatorId() {
        return falseOperatorId;
    }

    public void setFalseOperatorId(String falseOperatorId) {
        this.falseOperatorId = falseOperatorId;
    }

    public void setTransactionCode(String transactionCode)
    {
        this.transactionCode = transactionCode;
    }

    public String getTransactionCode()
    {
        return transactionCode;
    }

    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    public String getOperator()
    {
        return operator;
    }
    

	public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTeam(String team) 
    {
        this.team = team;
    }

    public String getTeam() 
    {
        return team;
    }
    public void setCarInformation(Integer carInformation) 
    {
        this.carInformation = carInformation;
    }

    public Integer getCarInformation() 
    {
        return carInformation;
    }
    public void setIntentionPrice(BigDecimal intentionPrice) 
    {
        this.intentionPrice = intentionPrice;
    }

    public BigDecimal getIntentionPrice() 
    {
        return intentionPrice;
    }
    public void setLoanMoney(BigDecimal loanMoney) 
    {
        this.loanMoney = loanMoney;
    }

    public BigDecimal getLoanMoney() 
    {
        return loanMoney;
    }
    public void setRepayPeriod(Integer repayPeriod) 
    {
        this.repayPeriod = repayPeriod;
    }

    public Integer getRepayPeriod() 
    {
        return repayPeriod;
    }
    public void setCarType(Integer carType) 
    {
        this.carType = carType;
    }

    public Integer getCarType() 
    {
        return carType;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getUserId()
    {
        return userId;
    }
    public void setOrderState(Integer orderState) 
    {
        this.orderState = orderState;
    }

    public Integer getOrderState() 
    {
        return orderState;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("team", getTeam())
            .append("carInformation", getCarInformation())
            .append("intentionPrice", getIntentionPrice())
            .append("loanMoney", getLoanMoney())
            .append("repayPeriod", getRepayPeriod())
            .append("carType", getCarType())
            .append("userId", getUserId())
            .append("orderState", getOrderState())
                .append("transactionCode", getTransactionCode())
                .append("operator",getOperator())
                .append("falseOperator",getFalseOperator())
                .append("falseOperatorId",getFalseOperatorId())
            .toString();
    }
}
