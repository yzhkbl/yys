package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_daihou
 * 
 * @author jeethink
 * @date 2021-01-06
 */
public class ZyjrDaihou
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String state;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String opinion;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 订单号 */
    @Excel(name = "订单号")
    private String transactionCode;

    /** $column.columnComment */
    @Excel(name = "订单号")
    private String zhengshu;

    /** $column.columnComment */
    @Excel(name = "订单号")
    private String baoxian;

    /** $column.columnComment */
    @Excel(name = "订单号")
    private String qita;

    /** $column.columnComment */
    @Excel(name = "订单号")
    private String lvben;

    /** $column.columnComment */
    @Excel(name = "订单号")
    private String tiche;
    private String operator;
    private String userName;
    private String team;
    private Double loanAmount;
    private Integer repaymentTerm;
    private Double actualPrice;
    private Long dealersId;
    private Integer carInformation;
    private String carType;
    String createTime;
    String tijiao;

    public String getTijiao() {
        return tijiao;
    }

    public void setTijiao(String tijiao) {
        this.tijiao = tijiao;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getRepaymentTerm() {
        return repaymentTerm;
    }

    public void setRepaymentTerm(Integer repaymentTerm) {
        this.repaymentTerm = repaymentTerm;
    }

    public Double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Long getDealersId() {
        return dealersId;
    }

    public void setDealersId(Long dealersId) {
        this.dealersId = dealersId;
    }

    public Integer getCarInformation() {
        return carInformation;
    }

    public void setCarInformation(Integer carInformation) {
        this.carInformation = carInformation;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setOpinion(String opinion) 
    {
        this.opinion = opinion;
    }

    public String getOpinion() 
    {
        return opinion;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setTransactionCode(String transactionCode) 
    {
        this.transactionCode = transactionCode;
    }

    public String getTransactionCode() 
    {
        return transactionCode;
    }
    public void setZhengshu(String zhengshu) 
    {
        this.zhengshu = zhengshu;
    }

    public String getZhengshu() 
    {
        return zhengshu;
    }
    public void setBaoxian(String baoxian) 
    {
        this.baoxian = baoxian;
    }

    public String getBaoxian() 
    {
        return baoxian;
    }
    public void setQita(String qita) 
    {
        this.qita = qita;
    }

    public String getQita() 
    {
        return qita;
    }
    public void setLvben(String lvben) 
    {
        this.lvben = lvben;
    }

    public String getLvben() 
    {
        return lvben;
    }
    public void setTiche(String tiche) 
    {
        this.tiche = tiche;
    }

    public String getTiche() 
    {
        return tiche;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("state", getState())
            .append("opinion", getOpinion())
            .append("userId", getUserId())
            .append("transactionCode", getTransactionCode())
            .append("zhengshu", getZhengshu())
            .append("baoxian", getBaoxian())
            .append("qita", getQita())
            .append("lvben", getLvben())
            .append("tiche", getTiche())
            .toString();
    }
}
