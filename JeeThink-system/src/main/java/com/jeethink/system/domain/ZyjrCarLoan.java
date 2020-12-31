package com.jeethink.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_car_loan
 * 
 * @author jeethink
 * @date 2020-12-30
 */
public class ZyjrCarLoan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 车类 */
    @Excel(name = "车类")
    private Integer carType;

    /** VIN码 */
    @Excel(name = "VIN码")
    private String vinCode;

    /** 品牌 */
    @Excel(name = "品牌")
    private String brand;

    /** 车系 */
    @Excel(name = "车系")
    private String carSeries;

    /** 车款年代 */
    @Excel(name = "车款年代")
    private String carYear;

    /** 排量/吨位 */
    @Excel(name = "排量/吨位")
    private String displacement;

    /** 挡位 */
    @Excel(name = "挡位")
    private String gear;

    /** 款式 */
    @Excel(name = "款式")
    private String style;

    /** 发动机号 */
    @Excel(name = "发动机号")
    private String engineCode;

    /** 燃料类型 */
    @Excel(name = "燃料类型")
    private String fuelType;

    /** 二手车行驶里程（新车无） */
    @Excel(name = "二手车行驶里程", readConverterExp = "新=车无")
    private String mileage;

    /** 首次登记日期 */
    @Excel(name = "首次登记日期")
    private String startDate;

    /** 实际销售价 */
    @Excel(name = "实际销售价")
    private BigDecimal actualPrice;

    /** 车辆贷款金额 */
    @Excel(name = "车辆贷款金额")
    private BigDecimal loanAmount;

    /** 还款期限 */
    @Excel(name = "还款期限")
    private Long repaymentTerm;

    /** 利率换挡 */
    @Excel(name = "利率换挡")
    private BigDecimal interestRate;

    /** 续保押金 */
    @Excel(name = "续保押金")
    private BigDecimal deposit;

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
    public void setCarType(Integer carType) 
    {
        this.carType = carType;
    }

    public Integer getCarType() 
    {
        return carType;
    }
    public void setVinCode(String vinCode) 
    {
        this.vinCode = vinCode;
    }

    public String getVinCode() 
    {
        return vinCode;
    }
    public void setBrand(String brand) 
    {
        this.brand = brand;
    }

    public String getBrand() 
    {
        return brand;
    }
    public void setCarSeries(String carSeries) 
    {
        this.carSeries = carSeries;
    }

    public String getCarSeries() 
    {
        return carSeries;
    }
    public void setCarYear(String carYear) 
    {
        this.carYear = carYear;
    }

    public String getCarYear() 
    {
        return carYear;
    }
    public void setDisplacement(String displacement) 
    {
        this.displacement = displacement;
    }

    public String getDisplacement() 
    {
        return displacement;
    }
    public void setGear(String gear) 
    {
        this.gear = gear;
    }

    public String getGear() 
    {
        return gear;
    }
    public void setStyle(String style) 
    {
        this.style = style;
    }

    public String getStyle() 
    {
        return style;
    }
    public void setEngineCode(String engineCode) 
    {
        this.engineCode = engineCode;
    }

    public String getEngineCode() 
    {
        return engineCode;
    }
    public void setFuelType(String fuelType) 
    {
        this.fuelType = fuelType;
    }

    public String getFuelType() 
    {
        return fuelType;
    }
    public void setMileage(String mileage) 
    {
        this.mileage = mileage;
    }

    public String getMileage() 
    {
        return mileage;
    }
    public void setStartDate(String startDate) 
    {
        this.startDate = startDate;
    }

    public String getStartDate() 
    {
        return startDate;
    }
    public void setActualPrice(BigDecimal actualPrice) 
    {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getActualPrice() 
    {
        return actualPrice;
    }
    public void setLoanAmount(BigDecimal loanAmount) 
    {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getLoanAmount() 
    {
        return loanAmount;
    }
    public void setRepaymentTerm(Long repaymentTerm) 
    {
        this.repaymentTerm = repaymentTerm;
    }

    public Long getRepaymentTerm() 
    {
        return repaymentTerm;
    }
    public void setInterestRate(BigDecimal interestRate) 
    {
        this.interestRate = interestRate;
    }

    public BigDecimal getInterestRate() 
    {
        return interestRate;
    }
    public void setDeposit(BigDecimal deposit) 
    {
        this.deposit = deposit;
    }

    public BigDecimal getDeposit() 
    {
        return deposit;
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
            .append("carType", getCarType())
            .append("vinCode", getVinCode())
            .append("brand", getBrand())
            .append("carSeries", getCarSeries())
            .append("carYear", getCarYear())
            .append("displacement", getDisplacement())
            .append("gear", getGear())
            .append("style", getStyle())
            .append("engineCode", getEngineCode())
            .append("fuelType", getFuelType())
            .append("mileage", getMileage())
            .append("startDate", getStartDate())
            .append("actualPrice", getActualPrice())
            .append("loanAmount", getLoanAmount())
            .append("repaymentTerm", getRepaymentTerm())
            .append("interestRate", getInterestRate())
            .append("deposit", getDeposit())
            .append("transactionCode", getTransactionCode())
            .append("orderState", getOrderState())
            .append("userId", getUserId())
            .toString();
    }
}
