package com.jeethink.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_staging_information
 * 
 * @author jeethink
 * @date 2021-01-19
 */
public class ZyjrStageInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dealer;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dscode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal contractSfRatio;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer repayPeriod;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String marketingArchivesNum;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String commissionFeeRate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer businessModel;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal firstMonthMoney;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String productCode;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer willResign;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer repaymentType;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal stageMoney;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sfMoney;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal sfProportion;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal monthincome;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal monthhomeincome;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal property;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal houseArea;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal othdebtbal;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal monrepayamt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal insureamt;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal contractLoanMoney;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal loanMoney;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal actualLoanAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String homeFlag;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String bussFlag;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer inStdPay;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal poundageAmount;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal annualInterestRate;

    /** $column.columnComment */
    private Long id;

    public void setDealer(String dealer) 
    {
        this.dealer = dealer;
    }

    public String getDealer() 
    {
        return dealer;
    }
    public void setDscode(String dscode) 
    {
        this.dscode = dscode;
    }

    public String getDscode() 
    {
        return dscode;
    }
    public void setContractSfRatio(BigDecimal contractSfRatio) 
    {
        this.contractSfRatio = contractSfRatio;
    }

    public BigDecimal getContractSfRatio() 
    {
        return contractSfRatio;
    }
    public void setRepayPeriod(Integer repayPeriod) 
    {
        this.repayPeriod = repayPeriod;
    }

    public Integer getRepayPeriod() 
    {
        return repayPeriod;
    }
    public void setMarketingArchivesNum(String marketingArchivesNum) 
    {
        this.marketingArchivesNum = marketingArchivesNum;
    }

    public String getMarketingArchivesNum() 
    {
        return marketingArchivesNum;
    }
    public void setCommissionFeeRate(String commissionFeeRate) 
    {
        this.commissionFeeRate = commissionFeeRate;
    }

    public String getCommissionFeeRate() 
    {
        return commissionFeeRate;
    }
    public void setBusinessModel(Integer businessModel) 
    {
        this.businessModel = businessModel;
    }

    public Integer getBusinessModel() 
    {
        return businessModel;
    }
    public void setFirstMonthMoney(BigDecimal firstMonthMoney) 
    {
        this.firstMonthMoney = firstMonthMoney;
    }

    public BigDecimal getFirstMonthMoney() 
    {
        return firstMonthMoney;
    }
    public void setProductCode(String productCode) 
    {
        this.productCode = productCode;
    }

    public String getProductCode() 
    {
        return productCode;
    }
    public void setWillResign(Integer willResign) 
    {
        this.willResign = willResign;
    }

    public Integer getWillResign() 
    {
        return willResign;
    }
    public void setRepaymentType(Integer repaymentType) 
    {
        this.repaymentType = repaymentType;
    }

    public Integer getRepaymentType() 
    {
        return repaymentType;
    }
    public void setStageMoney(BigDecimal stageMoney) 
    {
        this.stageMoney = stageMoney;
    }

    public BigDecimal getStageMoney() 
    {
        return stageMoney;
    }
    public void setSfMoney(BigDecimal sfMoney) 
    {
        this.sfMoney = sfMoney;
    }

    public BigDecimal getSfMoney() 
    {
        return sfMoney;
    }
    public void setSfProportion(BigDecimal sfProportion) 
    {
        this.sfProportion = sfProportion;
    }

    public BigDecimal getSfProportion() 
    {
        return sfProportion;
    }
    public void setMonthincome(BigDecimal monthincome) 
    {
        this.monthincome = monthincome;
    }

    public BigDecimal getMonthincome() 
    {
        return monthincome;
    }
    public void setMonthhomeincome(BigDecimal monthhomeincome) 
    {
        this.monthhomeincome = monthhomeincome;
    }

    public BigDecimal getMonthhomeincome() 
    {
        return monthhomeincome;
    }
    public void setProperty(BigDecimal property) 
    {
        this.property = property;
    }

    public BigDecimal getProperty() 
    {
        return property;
    }
    public void setHouseArea(BigDecimal houseArea) 
    {
        this.houseArea = houseArea;
    }

    public BigDecimal getHouseArea() 
    {
        return houseArea;
    }
    public void setOthdebtbal(BigDecimal othdebtbal) 
    {
        this.othdebtbal = othdebtbal;
    }

    public BigDecimal getOthdebtbal() 
    {
        return othdebtbal;
    }
    public void setMonrepayamt(BigDecimal monrepayamt) 
    {
        this.monrepayamt = monrepayamt;
    }

    public BigDecimal getMonrepayamt() 
    {
        return monrepayamt;
    }
    public void setInsureamt(BigDecimal insureamt) 
    {
        this.insureamt = insureamt;
    }

    public BigDecimal getInsureamt() 
    {
        return insureamt;
    }
    public void setContractLoanMoney(BigDecimal contractLoanMoney) 
    {
        this.contractLoanMoney = contractLoanMoney;
    }

    public BigDecimal getContractLoanMoney() 
    {
        return contractLoanMoney;
    }
    public void setLoanMoney(BigDecimal loanMoney) 
    {
        this.loanMoney = loanMoney;
    }

    public BigDecimal getLoanMoney() 
    {
        return loanMoney;
    }
    public void setActualLoanAmount(BigDecimal actualLoanAmount) 
    {
        this.actualLoanAmount = actualLoanAmount;
    }

    public BigDecimal getActualLoanAmount() 
    {
        return actualLoanAmount;
    }
    public void setHomeFlag(String homeFlag) 
    {
        this.homeFlag = homeFlag;
    }

    public String getHomeFlag() 
    {
        return homeFlag;
    }
    public void setBussFlag(String bussFlag) 
    {
        this.bussFlag = bussFlag;
    }

    public String getBussFlag() 
    {
        return bussFlag;
    }
    public void setInStdPay(Integer inStdPay) 
    {
        this.inStdPay = inStdPay;
    }

    public Integer getInStdPay() 
    {
        return inStdPay;
    }
    public void setPoundageAmount(BigDecimal poundageAmount) 
    {
        this.poundageAmount = poundageAmount;
    }

    public BigDecimal getPoundageAmount() 
    {
        return poundageAmount;
    }
    public void setAnnualInterestRate(BigDecimal annualInterestRate) 
    {
        this.annualInterestRate = annualInterestRate;
    }

    public BigDecimal getAnnualInterestRate() 
    {
        return annualInterestRate;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dealer", getDealer())
            .append("dscode", getDscode())
            .append("contractSfRatio", getContractSfRatio())
            .append("repayPeriod", getRepayPeriod())
            .append("marketingArchivesNum", getMarketingArchivesNum())
            .append("commissionFeeRate", getCommissionFeeRate())
            .append("businessModel", getBusinessModel())
            .append("firstMonthMoney", getFirstMonthMoney())
            .append("productCode", getProductCode())
            .append("willResign", getWillResign())
            .append("repaymentType", getRepaymentType())
            .append("stageMoney", getStageMoney())
            .append("sfMoney", getSfMoney())
            .append("sfProportion", getSfProportion())
            .append("monthincome", getMonthincome())
            .append("monthhomeincome", getMonthhomeincome())
            .append("property", getProperty())
            .append("houseArea", getHouseArea())
            .append("othdebtbal", getOthdebtbal())
            .append("monrepayamt", getMonrepayamt())
            .append("insureamt", getInsureamt())
            .append("contractLoanMoney", getContractLoanMoney())
            .append("loanMoney", getLoanMoney())
            .append("actualLoanAmount", getActualLoanAmount())
            .append("homeFlag", getHomeFlag())
            .append("bussFlag", getBussFlag())
            .append("inStdPay", getInStdPay())
            .append("poundageAmount", getPoundageAmount())
            .append("annualInterestRate", getAnnualInterestRate())
            .append("id", getId())
            .toString();
    }
}
