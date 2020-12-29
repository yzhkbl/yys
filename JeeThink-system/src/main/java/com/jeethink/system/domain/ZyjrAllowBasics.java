package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_allow_basics
 * 
 * @author jeethink
 * @date 2020-12-22
 */
public class ZyjrAllowBasics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /**审批类型*/
    private String approvalType;

    /**车商id*/
    private Long dealersId;

    /** 经销商门店 */
    @Excel(name = "经销商门店")
    private String dealerStores;

    /** 车牌类型 0公牌 1私牌 */
    @Excel(name = "车牌类型 0公牌 1私牌")
    private Integer plateType;

    /** 市场 */
    @Excel(name = "市场")
    private String market;

    /** 门店 */
    @Excel(name = "门店")
    private String store;

    /** 运营 */
    @Excel(name = "运营")
    private String operate;

    /** 补充说明 */
    @Excel(name = "补充说明")
    private String moreInfo;

    /** 身份识别码 */
    @Excel(name = "身份识别码")
    private Long userId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String transactionCode;

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Integer orderState;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDealerStores(String dealerStores) 
    {
        this.dealerStores = dealerStores;
    }

    public String getDealerStores() 
    {
        return dealerStores;
    }
    public void setPlateType(Integer plateType) 
    {
        this.plateType = plateType;
    }

    public Integer getPlateType() 
    {
        return plateType;
    }
    public void setMarket(String market) 
    {
        this.market = market;
    }

    public String getMarket() 
    {
        return market;
    }
    public void setStore(String store) 
    {
        this.store = store;
    }

    public String getStore() 
    {
        return store;
    }
    public void setOperate(String operate) 
    {
        this.operate = operate;
    }

    public String getOperate() 
    {
        return operate;
    }
    public void setMoreInfo(String moreInfo) 
    {
        this.moreInfo = moreInfo;
    }

    public String getMoreInfo() 
    {
        return moreInfo;
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

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public Long getDealersId() {
        return dealersId;
    }

    public void setDealersId(Long dealersId) {
        this.dealersId = dealersId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
                .append("approvalType",getApprovalType())
                .append("dealersId",getDealersId())
            .append("dealerStores", getDealerStores())
            .append("plateType", getPlateType())
            .append("market", getMarket())
            .append("store", getStore())
            .append("operate", getOperate())
            .append("moreInfo", getMoreInfo())
            .append("userId", getUserId())
            .append("transactionCode", getTransactionCode())
            .append("orderState", getOrderState())
            .toString();
    }
}
