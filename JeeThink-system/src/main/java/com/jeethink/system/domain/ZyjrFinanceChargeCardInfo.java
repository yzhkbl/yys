package com.jeethink.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_finance_charge_card_info
 * 
 * @author jeethink
 * @date 2021-01-19
 */
public class ZyjrFinanceChargeCardInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String marketid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal financecharge;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String guaranteecode;

    /** $column.columnComment */
    private Long id;

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
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("marketid", getMarketid())
            .append("financecharge", getFinancecharge())
            .append("guaranteecode", getGuaranteecode())
            .append("id", getId())
            .toString();
    }
}
