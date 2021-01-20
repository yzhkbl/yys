package com.jeethink.system.domain;

import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 【请填写功能名称】对象 zyjr_finance_charge_card_info
 * 
 * @author jeethink
 * @date 2021-01-19
 */
public class ZyjrFinanceChargeCardInfo2 {

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String marketid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal financecharge;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String guaranteecode;


    public void setMarketid(String marketid) 
    {
        this.marketid = marketid;
    }

    public String getMarketid() 
    {
        return marketid;
    }
    public void setFinancecharge(BigDecimal financecharge) 
    {
        this.financecharge = financecharge;
    }

    public BigDecimal getFinancecharge() 
    {
        return financecharge;
    }
    public void setGuaranteecode(String guaranteecode) 
    {
        this.guaranteecode = guaranteecode;
    }

    public String getGuaranteecode() 
    {
        return guaranteecode;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("marketid", getMarketid())
            .append("financecharge", getFinancecharge())
            .append("guaranteecode", getGuaranteecode())
            .toString();
    }
}
