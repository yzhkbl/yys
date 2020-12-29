package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * scheme对象 zyjr_bank_scheme
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public class ZyjrBankScheme
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 银行合作产品id */
    @Excel(name = "银行合作产品id")
    private String zyjrBankProductId;

    /** 分期期数 */
    @Excel(name = "分期期数")
    private String stageNum;

    /** 银行基准利率 */
    @Excel(name = "银行基准利率")
    private String baseRate;

    /** 应付费率 */
    @Excel(name = "应付费率")
    private String shouldRate;
    private String shouldPut;

    public String getShouldPut() {
        return shouldPut;
    }

    public void setShouldPut(String shouldPut) {
        this.shouldPut = shouldPut;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setZyjrBankProductId(String zyjrBankProductId) 
    {
        this.zyjrBankProductId = zyjrBankProductId;
    }

    public String getZyjrBankProductId() 
    {
        return zyjrBankProductId;
    }
    public void setStageNum(String stageNum) 
    {
        this.stageNum = stageNum;
    }

    public String getStageNum() 
    {
        return stageNum;
    }
    public void setBaseRate(String baseRate) 
    {
        this.baseRate = baseRate;
    }

    public String getBaseRate() 
    {
        return baseRate;
    }
    public void setShouldRate(String shouldRate) 
    {
        this.shouldRate = shouldRate;
    }

    public String getShouldRate() 
    {
        return shouldRate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())

            .append("zyjrBankProductId", getZyjrBankProductId())
            .append("stageNum", getStageNum())
            .append("baseRate", getBaseRate())
            .append("shouldRate", getShouldRate())
            .toString();
    }
}
