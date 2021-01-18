package com.jeethink.system.domain.vo;

import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 【请填写功能名称】对象 zyjr_business
 * 
 * @author jeethink
 * @date 2020-12-09
 */
@Data
public class ZyjrGrant extends BaseEntity
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
    @Excel(name = "实际销售价格")
    private BigDecimal actualPrice;

    /** 意向贷款金额 */
    @Excel(name = "贷款金额")
    private BigDecimal loanAmount;

    /** 意向贷款期限 */
    @Excel(name = "贷款期限")
    private Integer repaymentTerm;

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
    private Integer approvalType;//审批状态
    private String transactionCode;//订单号
    private String operator;
    private String falseOperator;
    private String falseOperatorId;
    private String realAddress;//真实地址
    private String allowBy;
    private String repeatBy;
    private String grantBy;
    private Long allowId;
    private Long repeatId;
    private Long grantId;

    public Long getAllowId() {
        return allowId;
    }

    public void setAllowId(Long allowId) {
        this.allowId = allowId;
    }

    public Long getRepeatId() {
        return repeatId;
    }

    public void setRepeatId(Long repeatId) {
        this.repeatId = repeatId;
    }

    public Long getGrantId() {
        return grantId;
    }

    public void setGrantId(Long grantId) {
        this.grantId = grantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealAddress() {
        return realAddress;
    }

    public void setRealAddress(String realAddress) {
        this.realAddress = realAddress;
    }

    public String getAllowBy() {
        return allowBy;
    }

    public void setAllowBy(String allowBy) {
        this.allowBy = allowBy;
    }

    public String getRepeatBy() {
        return repeatBy;
    }

    public void setRepeatBy(String repeatBy) {
        this.repeatBy = repeatBy;
    }

    public String getGrantBy() {
        return grantBy;
    }

    public void setGrantBy(String grantBy) {
        this.grantBy = grantBy;
    }

    public Integer getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(Integer approvalType) {
        this.approvalType = approvalType;
    }
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

    public Integer getRepaymentTerm() {
        return repaymentTerm;
    }

    public void setRepaymentTerm(Integer repaymentTerm) {
        this.repaymentTerm = repaymentTerm;
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

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("team", getTeam())
            .append("carInformation", getCarInformation())
            .append("intentionPrice", getActualPrice())
            .append("loanMoney", getLoanAmount())
            .append("repayPeriod", getRepaymentTerm())
            .append("carType", getCarType())
            .append("userId", getUserId())
            .append("orderState", getOrderState())
                .append("transactionCode", getTransactionCode())
                .append("operator",getOperator())
                .append("falseOperator",getFalseOperator())
                .append("falseOperatorId",getFalseOperatorId())
                .append("allowBy",getAllowBy())
                .append("repeatBy",getRepeatBy())
                .append("grantBy",getGrantBy())
                .append("allowId",getAllowId())
                .append("repeatId",getRepeatId())
                .append("grantId",getGrantId())
            .toString();
    }
}
