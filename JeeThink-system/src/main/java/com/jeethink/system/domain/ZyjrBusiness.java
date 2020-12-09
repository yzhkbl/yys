package com.jeethink.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_business
 * 
 * @author jeethink
 * @date 2020-12-09
 */
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
    private Long carType;

    /** 身份唯一识别码 */
    @Excel(name = "身份唯一识别码")
    private String identityId;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Integer orderState;

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
    public void setCarType(Long carType) 
    {
        this.carType = carType;
    }

    public Long getCarType() 
    {
        return carType;
    }
    public void setIdentityId(String identityId) 
    {
        this.identityId = identityId;
    }

    public String getIdentityId() 
    {
        return identityId;
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
            .append("identityId", getIdentityId())
            .append("orderState", getOrderState())
            .toString();
    }
}
