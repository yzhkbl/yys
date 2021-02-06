package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_common_applicant
 * 
 * @author jeethink
 * @date 2021-02-06
 */
public class ZyjrCommonApplicant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 共同偿债人主键id */
    private Long id;

    /** 与借款人关系 */
    @Excel(name = "与借款人关系")
    private String peopleShip;

    /** 身份证正面地址 */
    @Excel(name = "身份证正面地址")
    private String cardAddress;

    /** 身份证反面地址 */
    @Excel(name = "身份证反面地址")
    private String backAddress;

    /** 共同申请人姓名 */
    @Excel(name = "共同申请人姓名")
    private String debtName;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 教育程度 */
    @Excel(name = "教育程度")
    private String education;

    /** 担保人现住地址 */
    @Excel(name = "担保人现住地址")
    private String nowPlace;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phoneNumber;

    /** 现工作单位名称 */
    @Excel(name = "现工作单位名称")
    private String nowWork;

    /** 工作单位地址 */
    @Excel(name = "工作单位地址")
    private String workPlace;

    /** 单位电话 */
    @Excel(name = "单位电话")
    private String companyPhone;

    /** 单位性质 */
    @Excel(name = "单位性质")
    private String companyNature;

    /** 税后月收入 */
    @Excel(name = "税后月收入")
    private String monthlyIncome;

    /** 身份识别 */
    @Excel(name = "身份识别")
    private Long userId;

    /** 订单号 */
    @Excel(name = "订单号")
    private String transactionCode;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Integer orderState;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private String marriage;

    /** 主要收入来源 */
    @Excel(name = "主要收入来源")
    private String sourceIncome;

    /** 身份证正面地址 */
    @Excel(name = "身份证正面地址")
    private String positiveAddress;

    /** 反面地址 */
    @Excel(name = "反面地址")
    private String versoAddress;

    /** 配偶姓名 */
    @Excel(name = "配偶姓名")
    private String spouseName;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idNumber;

    /** 户籍地址 */
    @Excel(name = "户籍地址")
    private String permanentAddress;

    /** 配偶手机号 */
    @Excel(name = "配偶手机号")
    private String phoneNo;

    /** 配偶学历 */
    @Excel(name = "配偶学历")
    private String spouseEducation;

    /** 配偶工作单位名称 */
    @Excel(name = "配偶工作单位名称")
    private String spouseUnitName;

    /** 配偶工作地址 */
    @Excel(name = "配偶工作地址")
    private String spouseWorkPlace;

    /** 配偶工作电话 */
    @Excel(name = "配偶工作电话")
    private String spouseWorkPhone;

    /** 配偶税后月收入 */
    @Excel(name = "配偶税后月收入")
    private String spouseMonthlyIncome;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPeopleShip(String peopleShip) 
    {
        this.peopleShip = peopleShip;
    }

    public String getPeopleShip() 
    {
        return peopleShip;
    }
    public void setCardAddress(String cardAddress) 
    {
        this.cardAddress = cardAddress;
    }

    public String getCardAddress() 
    {
        return cardAddress;
    }
    public void setBackAddress(String backAddress) 
    {
        this.backAddress = backAddress;
    }

    public String getBackAddress() 
    {
        return backAddress;
    }
    public void setDebtName(String debtName) 
    {
        this.debtName = debtName;
    }

    public String getDebtName() 
    {
        return debtName;
    }
    public void setIdCard(String idCard) 
    {
        this.idCard = idCard;
    }

    public String getIdCard() 
    {
        return idCard;
    }
    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }
    public void setNowPlace(String nowPlace) 
    {
        this.nowPlace = nowPlace;
    }

    public String getNowPlace() 
    {
        return nowPlace;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setNowWork(String nowWork) 
    {
        this.nowWork = nowWork;
    }

    public String getNowWork() 
    {
        return nowWork;
    }
    public void setWorkPlace(String workPlace) 
    {
        this.workPlace = workPlace;
    }

    public String getWorkPlace() 
    {
        return workPlace;
    }
    public void setCompanyPhone(String companyPhone) 
    {
        this.companyPhone = companyPhone;
    }

    public String getCompanyPhone() 
    {
        return companyPhone;
    }
    public void setCompanyNature(String companyNature) 
    {
        this.companyNature = companyNature;
    }

    public String getCompanyNature() 
    {
        return companyNature;
    }
    public void setMonthlyIncome(String monthlyIncome) 
    {
        this.monthlyIncome = monthlyIncome;
    }

    public String getMonthlyIncome() 
    {
        return monthlyIncome;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
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
    public void setOrderState(Integer orderState) 
    {
        this.orderState = orderState;
    }

    public Integer getOrderState() 
    {
        return orderState;
    }
    public void setMarriage(String marriage) 
    {
        this.marriage = marriage;
    }

    public String getMarriage() 
    {
        return marriage;
    }
    public void setSourceIncome(String sourceIncome) 
    {
        this.sourceIncome = sourceIncome;
    }

    public String getSourceIncome() 
    {
        return sourceIncome;
    }
    public void setPositiveAddress(String positiveAddress) 
    {
        this.positiveAddress = positiveAddress;
    }

    public String getPositiveAddress() 
    {
        return positiveAddress;
    }
    public void setVersoAddress(String versoAddress) 
    {
        this.versoAddress = versoAddress;
    }

    public String getVersoAddress() 
    {
        return versoAddress;
    }
    public void setSpouseName(String spouseName) 
    {
        this.spouseName = spouseName;
    }

    public String getSpouseName() 
    {
        return spouseName;
    }
    public void setIdNumber(String idNumber) 
    {
        this.idNumber = idNumber;
    }

    public String getIdNumber() 
    {
        return idNumber;
    }
    public void setPermanentAddress(String permanentAddress) 
    {
        this.permanentAddress = permanentAddress;
    }

    public String getPermanentAddress() 
    {
        return permanentAddress;
    }
    public void setPhoneNo(String phoneNo) 
    {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() 
    {
        return phoneNo;
    }
    public void setSpouseEducation(String spouseEducation) 
    {
        this.spouseEducation = spouseEducation;
    }

    public String getSpouseEducation() 
    {
        return spouseEducation;
    }
    public void setSpouseUnitName(String spouseUnitName) 
    {
        this.spouseUnitName = spouseUnitName;
    }

    public String getSpouseUnitName() 
    {
        return spouseUnitName;
    }
    public void setSpouseWorkPlace(String spouseWorkPlace) 
    {
        this.spouseWorkPlace = spouseWorkPlace;
    }

    public String getSpouseWorkPlace() 
    {
        return spouseWorkPlace;
    }
    public void setSpouseWorkPhone(String spouseWorkPhone) 
    {
        this.spouseWorkPhone = spouseWorkPhone;
    }

    public String getSpouseWorkPhone() 
    {
        return spouseWorkPhone;
    }
    public void setSpouseMonthlyIncome(String spouseMonthlyIncome) 
    {
        this.spouseMonthlyIncome = spouseMonthlyIncome;
    }

    public String getSpouseMonthlyIncome() 
    {
        return spouseMonthlyIncome;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("peopleShip", getPeopleShip())
            .append("cardAddress", getCardAddress())
            .append("backAddress", getBackAddress())
            .append("debtName", getDebtName())
            .append("idCard", getIdCard())
            .append("education", getEducation())
            .append("nowPlace", getNowPlace())
            .append("phoneNumber", getPhoneNumber())
            .append("nowWork", getNowWork())
            .append("workPlace", getWorkPlace())
            .append("companyPhone", getCompanyPhone())
            .append("companyNature", getCompanyNature())
            .append("monthlyIncome", getMonthlyIncome())
            .append("userId", getUserId())
            .append("transactionCode", getTransactionCode())
            .append("orderState", getOrderState())
            .append("marriage", getMarriage())
            .append("sourceIncome", getSourceIncome())
            .append("positiveAddress", getPositiveAddress())
            .append("versoAddress", getVersoAddress())
            .append("spouseName", getSpouseName())
            .append("idNumber", getIdNumber())
            .append("permanentAddress", getPermanentAddress())
            .append("phoneNo", getPhoneNo())
            .append("spouseEducation", getSpouseEducation())
            .append("spouseUnitName", getSpouseUnitName())
            .append("spouseWorkPlace", getSpouseWorkPlace())
            .append("spouseWorkPhone", getSpouseWorkPhone())
            .append("spouseMonthlyIncome", getSpouseMonthlyIncome())
            .toString();
    }
}
