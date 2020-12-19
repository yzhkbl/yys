package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_borrower
 * 
 * @author jeethink
 * @date 2020-12-10
 */
public class ZyjrBorrower extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Integer id;

    /** 借款人姓名 */
    @Excel(name = "借款人姓名")
    private String userName;

    /** 借款人身份证号 */
    @Excel(name = "借款人身份证号")
    private String idCard;

    /** 借款人银行卡号 */
    @Excel(name = "借款人银行卡号")
    private String bankCardNo;

    /** 借款人手机号码 */
    @Excel(name = "借款人手机号码")
    private String phoneNumber;

    /** 身份证签发机关 */
    @Excel(name = "身份证签发机关")
    private String issueAuthority;

    /** 证件有效期起始日 */
    @Excel(name = "证件有效期起始日")
    private String startDate;

    /** 证件有效期截止日 */
    @Excel(name = "证件有效期截止日")
    private String endDate;

    /** 住宅地址 */
    @Excel(name = "住宅地址")
    private String familyAddress;

    /** 身份证正面id */
    @Excel(name = "身份证正面id")
    private Integer obverseId;

    /** 身份证正面code */
    @Excel(name = "身份证正面code")
    private String obverseCode;

    /** 身份证正面图下载地址 */
    @Excel(name = "身份证正面图下载地址")
    private String obverseAddress;

    /** 身份证正面jpg */
    @Excel(name = "身份证正面jpg")
    private String obverseName;

    /** 身份证反面id */
    @Excel(name = "身份证反面id")
    private Integer backId;

    /** 身份证反面code */
    @Excel(name = "身份证反面code")
    private String backCode;

    /** 身份证反面图下载地址 */
    @Excel(name = "身份证反面图下载地址")
    private String backAddress;

    /** 身份证反面jpg */
    @Excel(name = "身份证反面jpg")
    private String backName;

    /** 授权书id */
    @Excel(name = "授权书id")
    private Integer powerId;

    /** 授权书code */
    @Excel(name = "授权书code")
    private String powerCode;

    /** 授权书下载地址 */
    @Excel(name = "授权书下载地址")
    private String powerAddress;

    /** 授权书jpg */
    @Excel(name = "授权书jpg")
    private String powerName;

    /** 征信授权 */
    @Excel(name = "征信授权")
    private Integer creditPower;

    /** 唯一身份码 */
    @Excel(name = "唯一身份码")
    private Integer userId;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Integer orderState;
    /** 内部订单号 */
    @Excel(name = "内部订单号")
    private String privateCode;

    private String transactionCode;

    private String electronicState;
    private String electrpnicAddress;
    private String contractState;
    public void setContractState(String contractState)
    {
        this.contractState = contractState;
    }

    public String getContractState()
    {
        return contractState;
    }
    public void setPrivateCode(String privateCode)
    {
        this.privateCode = privateCode;
    }

    public String getPrivateCode()
    {
        return privateCode;
    }

    public void setElectronicState(String electronicState)
    {
        this.electronicState = electronicState;
    }

    public String getElectronicState()
    {
        return electronicState;
    }
    public void setElectrpnicAddress(String electrpnicAddress)
    {
        this.electrpnicAddress = electrpnicAddress;
    }

    public String getElectrpnicAddress()
    {
        return electrpnicAddress;
    }
    public void setTransactionCode(String transactionCode)
    {
        this.transactionCode = transactionCode;
    }

    public String getTransactionCode()
    {
        return transactionCode;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
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
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setBankCardNo(String bankCardNo) 
    {
        this.bankCardNo = bankCardNo;
    }

    public String getBankCardNo() 
    {
        return bankCardNo;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setIssueAuthority(String issueAuthority) 
    {
        this.issueAuthority = issueAuthority;
    }

    public String getIssueAuthority() 
    {
        return issueAuthority;
    }
    public void setStartDate(String startDate) 
    {
        this.startDate = startDate;
    }

    public String getStartDate() 
    {
        return startDate;
    }
    public void setEndDate(String endDate) 
    {
        this.endDate = endDate;
    }

    public String getEndDate() 
    {
        return endDate;
    }
    public void setFamilyAddress(String familyAddress) 
    {
        this.familyAddress = familyAddress;
    }

    public String getFamilyAddress() 
    {
        return familyAddress;
    }
    public void setObverseId(Integer obverseId) 
    {
        this.obverseId = obverseId;
    }

    public Integer getObverseId() 
    {
        return obverseId;
    }
    public void setObverseCode(String obverseCode) 
    {
        this.obverseCode = obverseCode;
    }

    public String getObverseCode() 
    {
        return obverseCode;
    }
    public void setObverseAddress(String obverseAddress) 
    {
        this.obverseAddress = obverseAddress;
    }

    public String getObverseAddress() 
    {
        return obverseAddress;
    }
    public void setObverseName(String obverseName) 
    {
        this.obverseName = obverseName;
    }

    public String getObverseName() 
    {
        return obverseName;
    }
    public void setBackId(Integer backId) 
    {
        this.backId = backId;
    }

    public Integer getBackId() 
    {
        return backId;
    }
    public void setBackCode(String backCode) 
    {
        this.backCode = backCode;
    }

    public String getBackCode() 
    {
        return backCode;
    }
    public void setBackAddress(String backAddress) 
    {
        this.backAddress = backAddress;
    }

    public String getBackAddress() 
    {
        return backAddress;
    }
    public void setBackName(String backName) 
    {
        this.backName = backName;
    }

    public String getBackName() 
    {
        return backName;
    }
    public void setPowerId(Integer powerId) 
    {
        this.powerId = powerId;
    }

    public Integer getPowerId() 
    {
        return powerId;
    }
    public void setPowerCode(String powerCode) 
    {
        this.powerCode = powerCode;
    }

    public String getPowerCode() 
    {
        return powerCode;
    }
    public void setPowerAddress(String powerAddress) 
    {
        this.powerAddress = powerAddress;
    }

    public String getPowerAddress() 
    {
        return powerAddress;
    }
    public void setPowerName(String powerName) 
    {
        this.powerName = powerName;
    }

    public String getPowerName() 
    {
        return powerName;
    }
    public void setCreditPower(Integer creditPower) 
    {
        this.creditPower = creditPower;
    }

    public Integer getCreditPower() 
    {
        return creditPower;
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
            .append("userName", getUserName())
            .append("idCard", getIdCard())
            .append("bankCardNo", getBankCardNo())
            .append("phoneNumber", getPhoneNumber())
            .append("issueAuthority", getIssueAuthority())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("familyAddress", getFamilyAddress())
            .append("obverseId", getObverseId())
            .append("obverseCode", getObverseCode())
            .append("obverseAddress", getObverseAddress())
            .append("obverseName", getObverseName())
            .append("backId", getBackId())
            .append("backCode", getBackCode())
            .append("backAddress", getBackAddress())
            .append("backName", getBackName())
            .append("powerId", getPowerId())
            .append("powerCode", getPowerCode())
            .append("powerAddress", getPowerAddress())
            .append("powerName", getPowerName())
            .append("creditPower", getCreditPower())
            .append("userId", getUserId())
            .append("orderState", getOrderState())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("transactionCode", getTransactionCode())
            .append("electronicState",getElectronicState())
            .append("electrpnicAddress",getElectrpnicAddress())
            .append("contractState",getContractState())
                .append("privateCode", getPrivateCode())
            .toString();
    }
}
