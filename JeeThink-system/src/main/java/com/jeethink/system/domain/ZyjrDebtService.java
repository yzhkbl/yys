package com.jeethink.system.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_debt_service
 * 
 * @author jeethink
 * @date 2020-12-29
 */
@Data
public class ZyjrDebtService extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 共同偿债人主键id */
    private Long id;

    /** 是否有共偿 */
    @Excel(name = "是否有共偿")
    private Integer isDebt;

    /** 与借款人关系 */
    @Excel(name = "与借款人关系")
    private String peopleShip;

    /** 身份证正面地址 */
    @Excel(name = "身份证正面地址")
    private String cardAddress;

    /** 身份证反面地址 */
    @Excel(name = "身份证反面地址")
    private String backAddress;

    /** 共偿人姓名 */
    @Excel(name = "共偿人姓名")
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

    /** 公司电话 */
    @Excel(name = "公司电话")
    private String companyPhone;

    /** 公司性质 */
    @Excel(name = "公司性质")
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
    private String sourceIncome;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setIsDebt(Integer isDebt) 
    {
        this.isDebt = isDebt;
    }

    public Integer getIsDebt() 
    {
        return isDebt;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isDebt", getIsDebt())
            .append("peopleShip", getPeopleShip())
            .append("cardAddress", getCardAddress())
            .append("backAddress", getBackAddress())
            .append("debtName", getDebtName())
            .append("idCard", getIdCard())
            .append("education", getEducation())
            .append("newPlace", getNowPlace())
            .append("phoneNamber", getPhoneNumber())
            .append("newWork", getNowWork())
            .append("workPlace", getWorkPlace())
            .append("companyPhone", getCompanyPhone())
            .append("companyNature", getCompanyNature())
            .append("monthlyIncome", getMonthlyIncome())
            .append("userId", getUserId())
            .append("transactionCode", getTransactionCode())
            .append("orderState", getOrderState())
            .toString();
    }
}
