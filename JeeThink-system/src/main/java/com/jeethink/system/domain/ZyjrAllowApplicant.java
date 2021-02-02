package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_allow_applicant
 * 
 * @author jeethink
 * @date 2021-01-11
 */
public class ZyjrAllowApplicant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 户口性质 */
    @Excel(name = "户口性质")
    private String householdNature;

    /** 现居住时间/年 */
    @Excel(name = "现居住时间/年")
    private String liveTime;

    /** 住宅区 */
    @Excel(name = "住宅区")
    private String liveArea;

    /** 住宅市 */
    @Excel(name = "住宅市")
    private String liveCity;

    /** 住宅省 */
    @Excel(name = "住宅省")
    private String liveProvince;

    /** 现居住地址 */
    @Excel(name = "现居住地址")
    private String liveAddress;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phoneNumber;

    /** 住房所有权 */
    @Excel(name = "住房所有权")
    private String housePower;

    /** 学历 */
    @Excel(name = "学历")
    private String education;

    /** 购车状况（0.有 1.无）*/
    private String carstat;

    public String getCarstat() {
        return carstat;
    }

    public void setCarstat(String carstat) {
        this.carstat = carstat;
    }

    /** 本人是否有驾驶证 */
    @Excel(name = "本人是否有驾驶证")
    private Integer isLicense;

    /** 驾驶员与主贷人关系 */
    @Excel(name = "驾驶员与主贷人关系")
    private String driverShip;

    /** 驾照类型 */
    @Excel(name = "驾照类型")
    private String licenseType;

    /** 工作单位名称 */
    @Excel(name = "工作单位名称")
    private String unitName;

    /** 工作地址 */
    @Excel(name = "工作地址")
    private String workAddress;

    /** 公司电话 */
    @Excel(name = "公司电话")
    private String unitPhone;

    /** 工作单位性质 */
    @Excel(name = "工作单位性质")
    private String unitNature;

    /** 从事行业 */
    @Excel(name = "从事行业")
    private String industry;

    /** 职位 */
    @Excel(name = "职位")
    private String position;

    /** 税后月收入 */
    @Excel(name = "税后月收入")
    private String monthlyIncome;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private String marriage;

    /** 身份证正面地址 */
    @Excel(name = "身份证正面地址")
    private String cardAddress;

    /** 反面地址 */
    @Excel(name = "反面地址")
    private String backAddress;

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

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Integer orderState;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String transactionCode;

    /** 身份id */
    @Excel(name = "身份id")
    private Long userId;

    /** 工作区 */
    @Excel(name = "工作区")
    private String workArea;

    /** 工作市 */
    @Excel(name = "工作市")
    private String workCity;

    /** 工作省 */
    @Excel(name = "工作省")
    private String workProvince;

    /** 现单位入职时间 */
    private String joindate;

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setHouseholdNature(String householdNature) 
    {
        this.householdNature = householdNature;
    }

    public String getHouseholdNature() 
    {
        return householdNature;
    }
    public void setLiveTime(String liveTime) 
    {
        this.liveTime = liveTime;
    }

    public String getLiveTime() 
    {
        return liveTime;
    }
    public void setLiveArea(String liveArea) 
    {
        this.liveArea = liveArea;
    }

    public String getLiveArea() 
    {
        return liveArea;
    }
    public void setLiveCity(String liveCity) 
    {
        this.liveCity = liveCity;
    }

    public String getLiveCity() 
    {
        return liveCity;
    }
    public void setLiveProvince(String liveProvince) 
    {
        this.liveProvince = liveProvince;
    }

    public String getLiveProvince() 
    {
        return liveProvince;
    }
    public void setLiveAddress(String liveAddress) 
    {
        this.liveAddress = liveAddress;
    }

    public String getLiveAddress() 
    {
        return liveAddress;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setHousePower(String housePower) 
    {
        this.housePower = housePower;
    }

    public String getHousePower() 
    {
        return housePower;
    }
    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }
    public void setIsLicense(Integer isLicense) 
    {
        this.isLicense = isLicense;
    }

    public Integer getIsLicense() 
    {
        return isLicense;
    }
    public void setDriverShip(String driverShip) 
    {
        this.driverShip = driverShip;
    }

    public String getDriverShip() 
    {
        return driverShip;
    }
    public void setLicenseType(String licenseType) 
    {
        this.licenseType = licenseType;
    }

    public String getLicenseType() 
    {
        return licenseType;
    }
    public void setUnitName(String unitName) 
    {
        this.unitName = unitName;
    }

    public String getUnitName() 
    {
        return unitName;
    }
    public void setWorkAddress(String workAddress) 
    {
        this.workAddress = workAddress;
    }

    public String getWorkAddress() 
    {
        return workAddress;
    }
    public void setUnitPhone(String unitPhone) 
    {
        this.unitPhone = unitPhone;
    }

    public String getUnitPhone() 
    {
        return unitPhone;
    }
    public void setUnitNature(String unitNature) 
    {
        this.unitNature = unitNature;
    }

    public String getUnitNature() 
    {
        return unitNature;
    }
    public void setIndustry(String industry) 
    {
        this.industry = industry;
    }

    public String getIndustry() 
    {
        return industry;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setMonthlyIncome(String monthlyIncome) 
    {
        this.monthlyIncome = monthlyIncome;
    }

    public String getMonthlyIncome() 
    {
        return monthlyIncome;
    }
    public void setMarriage(String marriage) 
    {
        this.marriage = marriage;
    }

    public String getMarriage() 
    {
        return marriage;
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
    public void setOrderState(Integer orderState) 
    {
        this.orderState = orderState;
    }

    public Integer getOrderState() 
    {
        return orderState;
    }
    public void setTransactionCode(String transactionCode) 
    {
        this.transactionCode = transactionCode;
    }

    public String getTransactionCode() 
    {
        return transactionCode;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setWorkArea(String workArea) 
    {
        this.workArea = workArea;
    }

    public String getWorkArea() 
    {
        return workArea;
    }
    public void setWorkCity(String workCity) 
    {
        this.workCity = workCity;
    }

    public String getWorkCity() 
    {
        return workCity;
    }
    public void setWorkProvince(String workProvince) 
    {
        this.workProvince = workProvince;
    }

    public String getWorkProvince() 
    {
        return workProvince;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("householdNature", getHouseholdNature())
            .append("liveTime", getLiveTime())
            .append("liveArea", getLiveArea())
            .append("liveCity", getLiveCity())
            .append("liveProvince", getLiveProvince())
            .append("liveAddress", getLiveAddress())
            .append("phoneNumber", getPhoneNumber())
            .append("housePower", getHousePower())
            .append("education", getEducation())
            .append("isLicense", getIsLicense())
            .append("driverShip", getDriverShip())
            .append("licenseType", getLicenseType())
            .append("unitName", getUnitName())
            .append("workAddress", getWorkAddress())
            .append("unitPhone", getUnitPhone())
            .append("unitNature", getUnitNature())
            .append("industry", getIndustry())
            .append("position", getPosition())
            .append("monthlyIncome", getMonthlyIncome())
            .append("marriage", getMarriage())
            .append("cardAddress", getCardAddress())
            .append("backAddress", getBackAddress())
            .append("spouseName", getSpouseName())
            .append("idNumber", getIdNumber())
            .append("permanentAddress", getPermanentAddress())
            .append("phoneNo", getPhoneNo())
                .append("carstat", getCarstat())
            .append("spouseEducation", getSpouseEducation())
            .append("spouseUnitName", getSpouseUnitName())
            .append("spouseWorkPlace", getSpouseWorkPlace())
            .append("spouseWorkPhone", getSpouseWorkPhone())
            .append("spouseMonthlyIncome", getSpouseMonthlyIncome())
            .append("orderState", getOrderState())
            .append("transactionCode", getTransactionCode())
            .append("userId", getUserId())
            .append("workArea", getWorkArea())
            .append("workCity", getWorkCity())
            .append("workProvince", getWorkProvince())
                .append("joindate",getJoindate())
            .toString();
    }
}
