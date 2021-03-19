package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_zhanghu
 * 
 * @author jeethink
 * @date 2021-03-19
 */
public class ZyjrZhanghu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 账户名称 */
    @Excel(name = "账户名称")
    private String accountName;

    /** 开户行名称 */
    @Excel(name = "开户行名称")
    private String bankName;

    /** 开户账户 */
    @Excel(name = "开户账户")
    private String account;

    /** 账户户名 */
    @Excel(name = "账户户名")
    private String zhanghuhuming;

    String del;

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAccountName(String accountName) 
    {
        this.accountName = accountName;
    }

    public String getAccountName() 
    {
        return accountName;
    }
    public void setBankName(String bankName) 
    {
        this.bankName = bankName;
    }

    public String getBankName() 
    {
        return bankName;
    }
    public void setAccount(String account) 
    {
        this.account = account;
    }

    public String getAccount() 
    {
        return account;
    }
    public void setZhanghuhuming(String zhanghuhuming) 
    {
        this.zhanghuhuming = zhanghuhuming;
    }

    public String getZhanghuhuming() 
    {
        return zhanghuhuming;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("accountName", getAccountName())
            .append("bankName", getBankName())
            .append("account", getAccount())
            .append("zhanghuhuming", getZhanghuhuming())
            .toString();
    }
}
