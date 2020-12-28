package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * extend对象 zyjr_bank_extend
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public class ZyjrBankExtend
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** zyjr_bank的id */
    @Excel(name = "zyjr_bank的id")
    private String bankId;

    /** 扩展合同编码 */
    @Excel(name = "扩展合同编码")
    private String extendCode;

    /** 字段名称 */
    @Excel(name = "字段名称")
    private String extendField;

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
    public void setExtendCode(String extendCode) 
    {
        this.extendCode = extendCode;
    }

    public String getExtendCode() 
    {
        return extendCode;
    }
    public void setExtendField(String extendField) 
    {
        this.extendField = extendField;
    }

    public String getExtendField() 
    {
        return extendField;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())

            .append("bankId", getBankId())
            .append("extendCode", getExtendCode())
            .append("extendField", getExtendField())
            .toString();
    }
}
