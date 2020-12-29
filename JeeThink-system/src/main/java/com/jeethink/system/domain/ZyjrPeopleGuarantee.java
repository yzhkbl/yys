package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_people_guarantee
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public class ZyjrPeopleGuarantee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    private String isAny;

    /** 正面照地址 */
    @Excel(name = "正面照地址")
    private String cardAddress;

    /** 背面照地址 */
    @Excel(name = "背面照地址")
    private String backAddress;

    /** 担保人姓名 */
    @Excel(name = "担保人姓名")
    private String guaranteeName;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idNumber;

    /** 与申请人关系 */
    @Excel(name = "与申请人关系")
    private String peopleShip;

    /** 担保人户籍省市 */
    @Excel(name = "担保人户籍省市")
    private String nativePlace;

    /** 担保人现居省市 */
    @Excel(name = "担保人现居省市")
    private String currentPlace;

    /** 担保人现住地址 */
    @Excel(name = "担保人现住地址")
    private String detailPlace;

    /** 担保人现工作单位名称 */
    @Excel(name = "担保人现工作单位名称")
    private String workUnit;

    /** 担保人现工作单位省市 */
    @Excel(name = "担保人现工作单位省市")
    private String workPlace;

    /** 担保人工作单位地址 */
    @Excel(name = "担保人工作单位地址")
    private String unitPlace;

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
    public void setGuaranteeName(String guaranteeName) 
    {
        this.guaranteeName = guaranteeName;
    }

    public String getGuaranteeName() 
    {
        return guaranteeName;
    }
    public void setIdNumber(String idNumber) 
    {
        this.idNumber = idNumber;
    }

    public String getIdNumber() 
    {
        return idNumber;
    }
    public void setPeopleShip(String peopleShip) 
    {
        this.peopleShip = peopleShip;
    }

    public String getPeopleShip() 
    {
        return peopleShip;
    }
    public void setNativePlace(String nativePlace) 
    {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() 
    {
        return nativePlace;
    }
    public void setCurrentPlace(String currentPlace) 
    {
        this.currentPlace = currentPlace;
    }

    public String getCurrentPlace() 
    {
        return currentPlace;
    }
    public void setDetailPlace(String detailPlace) 
    {
        this.detailPlace = detailPlace;
    }

    public String getDetailPlace() 
    {
        return detailPlace;
    }
    public void setWorkUnit(String workUnit) 
    {
        this.workUnit = workUnit;
    }

    public String getWorkUnit() 
    {
        return workUnit;
    }
    public void setWorkPlace(String workPlace) 
    {
        this.workPlace = workPlace;
    }

    public String getWorkPlace() 
    {
        return workPlace;
    }
    public void setUnitPlace(String unitPlace) 
    {
        this.unitPlace = unitPlace;
    }

    public String getUnitPlace() 
    {
        return unitPlace;
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

    public String getIsAny() {
        return isAny;
    }

    public void setIsAny(String isAny) {
        this.isAny = isAny;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isAny", getIsAny())
            .append("cardAddress", getCardAddress())
            .append("backAddress", getBackAddress())
            .append("guaranteeName", getGuaranteeName())
            .append("idNumber", getIdNumber())
            .append("peopleShip", getPeopleShip())
            .append("nativePlace", getNativePlace())
            .append("currentPlace", getCurrentPlace())
            .append("detailPlace", getDetailPlace())
            .append("workUnit", getWorkUnit())
            .append("workPlace", getWorkPlace())
            .append("unitPlace", getUnitPlace())
            .append("transactionCode", getTransactionCode())
            .append("orderState", getOrderState())
            .append("userId", getUserId())
            .toString();
    }
}
