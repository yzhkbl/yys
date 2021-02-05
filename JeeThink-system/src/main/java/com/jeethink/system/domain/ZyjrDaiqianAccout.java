package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_daiqian_accout
 * 
 * @author jeethink
 * @date 2021-01-05
 */
public class ZyjrDaiqianAccout extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 订单号 */
    @Excel(name = "订单号")
    private String transactionCode;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    /** $column.columnComment */
    @Excel(name = "状态")
    private String accountId;

    /** $column.columnComment */
    @Excel(name = "状态")
    private String accountOne;

    private String type;
    private String fangkuan;
    private String bazaar;
    private String carid;
    private String carname;
    private String shenpitype;
    private String chanpintype;
    private String daikuanchuanpin;

    public String getShenpitype() {
        return shenpitype;
    }

    public void setShenpitype(String shenpitype) {
        this.shenpitype = shenpitype;
    }

    public String getChanpintype() {
        return chanpintype;
    }

    public void setChanpintype(String chanpintype) {
        this.chanpintype = chanpintype;
    }

    public String getDaikuanchuanpin() {
        return daikuanchuanpin;
    }

    public void setDaikuanchuanpin(String daikuanchuanpin) {
        this.daikuanchuanpin = daikuanchuanpin;
    }

    public String getBazaar() {
        return bazaar;
    }

    public void setBazaar(String bazaar) {
        this.bazaar = bazaar;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getFangkuan() {
        return fangkuan;
    }

    public void setFangkuan(String fangkuan) {
        this.fangkuan = fangkuan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTransactionCode(String transactionCode) 
    {
        this.transactionCode = transactionCode;
    }

    public String getTransactionCode() 
    {
        return transactionCode;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setAccountId(String accountId) 
    {
        this.accountId = accountId;
    }

    public String getAccountId() 
    {
        return accountId;
    }
    public void setAccountOne(String accountOne) 
    {
        this.accountOne = accountOne;
    }

    public String getAccountOne() 
    {
        return accountOne;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("transactionCode", getTransactionCode())
            .append("state", getState())
            .append("accountId", getAccountId())
            .append("accountOne", getAccountOne())
            .toString();
    }
}
