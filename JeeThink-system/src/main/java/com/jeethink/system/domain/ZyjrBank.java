package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * bank对象 zyjr_bank
 * 
 * @author jeethink
 * @date 2020-12-25
 */
public class ZyjrBank extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 银行名称 */
    @Excel(name = "银行名称")
    private String bankName;

    /** 银行所在地 */
    @Excel(name = "银行所在地")
    private String bankLocation;

    /** 联系人员 */
    @Excel(name = "联系人员")
    private String linkman;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phoneNumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBankName(String bankName) 
    {
        this.bankName = bankName;
    }

    public String getBankName() 
    {
        return bankName;
    }
    public void setBankLocation(String bankLocation) 
    {
        this.bankLocation = bankLocation;
    }

    public String getBankLocation() 
    {
        return bankLocation;
    }
    public void setLinkman(String linkman) 
    {
        this.linkman = linkman;
    }

    public String getLinkman() 
    {
        return linkman;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bankName", getBankName())
            .append("bankLocation", getBankLocation())
            .append("linkman", getLinkman())
            .append("remark", getRemark())
            .append("phoneNumber", getPhoneNumber())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
