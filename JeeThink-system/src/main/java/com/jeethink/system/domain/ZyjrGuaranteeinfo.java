package com.jeethink.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_guaranteeinfo
 * 
 * @author jeethink
 * @date 2021-01-19
 */
public class ZyjrGuaranteeinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long encbno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String mortname;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String chnsname;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer apprel;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String mortltype;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String mortmtype;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String mortstype;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal mortvalue;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String mortaddr;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String encbregdate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String encbpreddate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal maxmortrate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String mortbegdate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String mortenddate;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String mortcontrno;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String dbimpno;

    /** $column.columnComment */
    private Long id;

    public void setEncbno(Long encbno) 
    {
        this.encbno = encbno;
    }

    public Long getEncbno() 
    {
        return encbno;
    }
    public void setMortname(String mortname) 
    {
        this.mortname = mortname;
    }

    public String getMortname() 
    {
        return mortname;
    }
    public void setChnsname(String chnsname) 
    {
        this.chnsname = chnsname;
    }

    public String getChnsname() 
    {
        return chnsname;
    }
    public void setApprel(Integer apprel) 
    {
        this.apprel = apprel;
    }

    public Integer getApprel() 
    {
        return apprel;
    }
    public void setMortltype(String mortltype) 
    {
        this.mortltype = mortltype;
    }

    public String getMortltype() 
    {
        return mortltype;
    }
    public void setMortmtype(String mortmtype) 
    {
        this.mortmtype = mortmtype;
    }

    public String getMortmtype() 
    {
        return mortmtype;
    }
    public void setMortstype(String mortstype) 
    {
        this.mortstype = mortstype;
    }

    public String getMortstype() 
    {
        return mortstype;
    }
    public void setMortvalue(BigDecimal mortvalue) 
    {
        this.mortvalue = mortvalue;
    }

    public BigDecimal getMortvalue() 
    {
        return mortvalue;
    }
    public void setMortaddr(String mortaddr) 
    {
        this.mortaddr = mortaddr;
    }

    public String getMortaddr() 
    {
        return mortaddr;
    }
    public void setEncbregdate(String encbregdate) 
    {
        this.encbregdate = encbregdate;
    }

    public String getEncbregdate() 
    {
        return encbregdate;
    }
    public void setEncbpreddate(String encbpreddate) 
    {
        this.encbpreddate = encbpreddate;
    }

    public String getEncbpreddate() 
    {
        return encbpreddate;
    }
    public void setMaxmortrate(BigDecimal maxmortrate) 
    {
        this.maxmortrate = maxmortrate;
    }

    public BigDecimal getMaxmortrate() 
    {
        return maxmortrate;
    }
    public void setMortbegdate(String mortbegdate) 
    {
        this.mortbegdate = mortbegdate;
    }

    public String getMortbegdate() 
    {
        return mortbegdate;
    }
    public void setMortenddate(String mortenddate) 
    {
        this.mortenddate = mortenddate;
    }

    public String getMortenddate() 
    {
        return mortenddate;
    }
    public void setMortcontrno(String mortcontrno) 
    {
        this.mortcontrno = mortcontrno;
    }

    public String getMortcontrno() 
    {
        return mortcontrno;
    }
    public void setDbimpno(String dbimpno) 
    {
        this.dbimpno = dbimpno;
    }

    public String getDbimpno() 
    {
        return dbimpno;
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
            .append("encbno", getEncbno())
            .append("mortname", getMortname())
            .append("chnsname", getChnsname())
            .append("apprel", getApprel())
            .append("mortltype", getMortltype())
            .append("mortmtype", getMortmtype())
            .append("mortstype", getMortstype())
            .append("mortvalue", getMortvalue())
            .append("mortaddr", getMortaddr())
            .append("encbregdate", getEncbregdate())
            .append("encbpreddate", getEncbpreddate())
            .append("maxmortrate", getMaxmortrate())
            .append("mortbegdate", getMortbegdate())
            .append("mortenddate", getMortenddate())
            .append("mortcontrno", getMortcontrno())
            .append("dbimpno", getDbimpno())
            .append("id", getId())
            .toString();
    }
}
