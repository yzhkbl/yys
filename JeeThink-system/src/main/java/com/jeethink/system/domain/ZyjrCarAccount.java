package com.jeethink.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.jeethink.common.core.domain.BaseEntity;
import com.jeethink.system.base.model.BaseModel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;


/**
 * 【请填写功能名称】对象 zyjr_car_account
 * 
 * @author jeethink
 * @date 2020-12-15
 */
@TableName(value = "zyjr_car_account")
public class ZyjrCarAccount extends BaseModel<ZyjrCarAccount>
{
    private static final long serialVersionUID = 1L;

    /** 账户名 */
    @Excel(name = "账户名")
    private String accountName;

    /** 账户用途 */
    @Excel(name = "账户用途")
    private String accountUse;

    /** 账户类型 */
    @Excel(name = "账户类型")
    private String accountType;

    /** 账户卡号 */
    @Excel(name = "账户卡号")
    private String accountNumber;

    /** 账户开户行 */
    @Excel(name = "账户开户行")
    private String accountLicence;

    /** 账户行所在城市 */
    @Excel(name = "账户行所在城市")
    private String accountCity;

    /** 账户所在省份 */
    @Excel(name = "账户所在省份")
    private String accountProvinc;

    /** 账户开户支行 */
    @Excel(name = "账户开户支行")
    private String accountSubBranch;

    /** $column.columnComment */
    /*private Long id;*/

    /** 车商id */
    @Excel(name = "车商id")
    private String zyjrCarId;

    public void setAccountName(String accountName) 
    {
        this.accountName = accountName;
    }

    public String getAccountName() 
    {
        return accountName;
    }
    public void setAccountUse(String accountUse) 
    {
        this.accountUse = accountUse;
    }

    public String getAccountUse() 
    {
        return accountUse;
    }
    public void setAccountType(String accountType) 
    {
        this.accountType = accountType;
    }

    public String getAccountType() 
    {
        return accountType;
    }
    public void setAccountNumber(String accountNumber) 
    {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() 
    {
        return accountNumber;
    }
    public void setAccountLicence(String accountLicence) 
    {
        this.accountLicence = accountLicence;
    }

    public String getAccountLicence() 
    {
        return accountLicence;
    }
    public void setAccountCity(String accountCity) 
    {
        this.accountCity = accountCity;
    }

    public String getAccountCity() 
    {
        return accountCity;
    }
    public void setAccountProvinc(String accountProvinc) 
    {
        this.accountProvinc = accountProvinc;
    }

    public String getAccountProvinc() 
    {
        return accountProvinc;
    }
    public void setAccountSubBranch(String accountSubBranch) 
    {
        this.accountSubBranch = accountSubBranch;
    }

    public String getAccountSubBranch() 
    {
        return accountSubBranch;
    }
 /*   public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }*/
    public void setZyjrCarId(String zyjrCarId) 
    {
        this.zyjrCarId = zyjrCarId;
    }

    public String getZyjrCarId() 
    {
        return zyjrCarId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("accountName", getAccountName())
            .append("accountUse", getAccountUse())
            .append("accountType", getAccountType())
            .append("accountNumber", getAccountNumber())
            .append("accountLicence", getAccountLicence())
            .append("accountCity", getAccountCity())
            .append("accountProvinc", getAccountProvinc())
            .append("accountSubBranch", getAccountSubBranch())
           /* .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())*/
           /* .append("id", getId())*/
            .append("zyjrCarId", getZyjrCarId())
            .toString();
    }
}
