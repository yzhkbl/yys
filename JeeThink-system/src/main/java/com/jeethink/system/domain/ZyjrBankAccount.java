package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * account对象 zyjr_bank_account
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public class ZyjrBankAccount
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** zyjr_bank的id */
    @Excel(name = "zyjr_bank的id")
    private String bankId;

    /** 开户行 */
    @Excel(name = "开户行")
    private String bankDeposit;

    /** 账号 */
    @Excel(name = "账号")
    private String userNumber;

    /** 户名 */
    @Excel(name = "户名")
    private String householdName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBankId(String bankId) 
    {
        this.bankId = bankId;
    }

    public String getBankId() 
    {
        return bankId;
    }
    public void setBankDeposit(String bankDeposit) 
    {
        this.bankDeposit = bankDeposit;
    }

    public String getBankDeposit() 
    {
        return bankDeposit;
    }
    public void setUserNumber(String userNumber) 
    {
        this.userNumber = userNumber;
    }

    public String getUserNumber() 
    {
        return userNumber;
    }
    public void setHouseholdName(String householdName) 
    {
        this.householdName = householdName;
    }

    public String getHouseholdName() 
    {
        return householdName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())

            .append("bankId", getBankId())
            .append("bankDeposit", getBankDeposit())
            .append("userNumber", getUserNumber())
            .append("householdName", getHouseholdName())
            .toString();
    }
}
