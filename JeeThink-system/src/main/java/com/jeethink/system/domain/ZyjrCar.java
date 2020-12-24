package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 车商信息对象 zyjr_car
 * 
 * @author jeethink
 * @date 2020-12-14
 */
public class ZyjrCar extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 车商名称 */
    @Excel(name = "车商名称")
    private String userName;

    /** 年龄 */
    @Excel(name = "年龄")
    private String gender;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phoneNumber;

    /** 是否是重要联系人 */
    @Excel(name = "是否是重要联系人")
    private String isLinkman;

    /** 身份 */
    @Excel(name = "身份")
    private String identity;

    /** 所属区域 */
    @Excel(name = "所属区域")
    private String area;

    /** 所属城市 */
    @Excel(name = "所属城市")
    private String city;

    /** 所属市场 */
    @Excel(name = "所属市场")
    private String bazaar;

    /** 第一个门店类型 */
    @Excel(name = "第一个门店类型")
    private String shopType;

    /** 第二个门店类型 */
    @Excel(name = "第二个门店类型")
    private String businessType;

    /** 车位数 */
    @Excel(name = "车位数")
    private String stall;

    /** 经营性质 */
    @Excel(name = "经营性质")
    private String businessNature;

    /** 乘用车 */
    @Excel(name = "乘用车")
    private String passengerCar;



    /** 月交易量 */
    @Excel(name = "月交易量")
    private String monthDeal;

    /** 月分期量 */
    @Excel(name = "月分期量")
    private String monthInstallment;

    /** 竟对单量 */
    @Excel(name = "竟对单量")
    private String matchAmount;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String detailAddress;

    /** 门店照片 */
    @Excel(name = "门店照片")
    private String pic;
    private List<SysFileInfo> sysFileInfo;

    private String dealerName;
    private String oneCarState;
    private String twoCarState;
    private String threeCarState;


    /** id */
    private Long id;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    private List<ZyjrCarAccount> zyjrCarAccount;

    public void setThreeCarState(String threeCarState)
    {
        this.threeCarState = threeCarState;
    }

    public String getThreeCarState()
    {
        return threeCarState;
    }

    public void setTwoCarState(String twoCarState)
    {
        this.twoCarState = twoCarState;
    }

    public String getTwoCarState()
    {
        return twoCarState;
    }
    public void setOneCarState(String oneCarState)
    {
        this.oneCarState = oneCarState;
    }

    public String getOneCarState()
    {
        return oneCarState;
    }

    public void setDealerName(String dealerName)
    {
        this.dealerName = dealerName;
    }

    public String getDealerName()
    {
        return dealerName;
    }

    public void setZyjrCarAccount(List<ZyjrCarAccount> zyjrCarAccount)
    {
        this.zyjrCarAccount = zyjrCarAccount;
    }

    public List<ZyjrCarAccount> getZyjrCarAccount()
    {
        return zyjrCarAccount;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setIsLinkman(String isLinkman) 
    {
        this.isLinkman = isLinkman;
    }

    public String getIsLinkman() 
    {
        return isLinkman;
    }
    public void setIdentity(String identity) 
    {
        this.identity = identity;
    }

    public String getIdentity() 
    {
        return identity;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setBazaar(String bazaar) 
    {
        this.bazaar = bazaar;
    }

    public String getBazaar()
    {
        return bazaar;
    }
    public void setShopType(String shopType)
    {
        this.shopType = shopType;
    }

    public String getShopType()
    {
        return shopType;
    }
    public void setBusinessType(String businessType)
    {
        this.businessType = businessType;
    }

    public String getBusinessType()
    {
        return businessType;
    }
    public void setStall(String stall) 
    {
        this.stall = stall;
    }

    public String getStall() 
    {
        return stall;
    }
    public void setBusinessNature(String businessNature) 
    {
        this.businessNature = businessNature;
    }

    public String getBusinessNature() 
    {
        return businessNature;
    }
    public void setPassengerCar(String passengerCar) 
    {
        this.passengerCar = passengerCar;
    }

    public String getPassengerCar() 
    {
        return passengerCar;
    }

    public void setMonthDeal(String monthDeal) 
    {
        this.monthDeal = monthDeal;
    }

    public String getMonthDeal() 
    {
        return monthDeal;
    }
    public void setMonthInstallment(String monthInstallment) 
    {
        this.monthInstallment = monthInstallment;
    }

    public String getMonthInstallment() 
    {
        return monthInstallment;
    }
    public void setMatchAmount(String matchAmount) 
    {
        this.matchAmount = matchAmount;
    }

    public String getMatchAmount() 
    {
        return matchAmount;
    }
    public void setDetailAddress(String detailAddress) 
    {
        this.detailAddress = detailAddress;
    }

    public String getDetailAddress() 
    {
        return detailAddress;
    }

    public void setPic(String pic)
    {
        this.pic = pic;
    }

    public String getPic()
    {
        return pic;
    }
    public void setSysFileInfo(List<SysFileInfo> sysFileInfo)
    {
        this.sysFileInfo = sysFileInfo;
    }

    public List<SysFileInfo> getSysFileInfo()
    {
        return sysFileInfo;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userName", getUserName())
            .append("gender", getGender())
            .append("phoneNumber", getPhoneNumber())
            .append("isLinkman", getIsLinkman())
            .append("identity", getIdentity())
            .append("remark", getRemark())
            .append("area", getArea())
            .append("city", getCity())
            .append("bazaar", getBazaar())
            .append("typeOne", getShopType())
            .append("typeToo", getBusinessType())
            .append("stall", getStall())
            .append("businessNature", getBusinessNature())
            .append("passengerCar", getPassengerCar())
            .append("monthDeal", getMonthDeal())
            .append("monthInstallment", getMonthInstallment())
            .append("matchAmount", getMatchAmount())
            .append("detailAddress", getDetailAddress())
            .append("pic", getPic())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("id", getId())
            .append("state", getState())
            .append("zyjrCarAccount",getZyjrCarAccount())
            .append("dealerName",getDealerName())
             .append("sysFileInfo",getSysFileInfo())
                .append("threeCarState",getThreeCarState())
                .append("twoCarState",getTwoCarState())
                .append("oneCarState",getOneCarState())
            .toString();
    }
}
