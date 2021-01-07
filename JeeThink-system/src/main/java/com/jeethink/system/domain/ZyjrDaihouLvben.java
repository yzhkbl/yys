package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_daihou_lvben
 * 
 * @author jeethink
 * @date 2021-01-06
 */
public class ZyjrDaihouLvben
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String shenqingdanhao;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String name;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String gongsi;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String kuaididanhao;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String type;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String count;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String fujian;

    private String daihou;

    public String getDaihou() {
        return daihou;
    }

    public void setDaihou(String daihou) {
        this.daihou = daihou;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setShenqingdanhao(String shenqingdanhao) 
    {
        this.shenqingdanhao = shenqingdanhao;
    }

    public String getShenqingdanhao() 
    {
        return shenqingdanhao;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setGongsi(String gongsi) 
    {
        this.gongsi = gongsi;
    }

    public String getGongsi() 
    {
        return gongsi;
    }
    public void setKuaididanhao(String kuaididanhao) 
    {
        this.kuaididanhao = kuaididanhao;
    }

    public String getKuaididanhao() 
    {
        return kuaididanhao;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setCount(String count) 
    {
        this.count = count;
    }

    public String getCount() 
    {
        return count;
    }
    public void setFujian(String fujian) 
    {
        this.fujian = fujian;
    }

    public String getFujian() 
    {
        return fujian;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shenqingdanhao", getShenqingdanhao())
            .append("name", getName())
            .append("gongsi", getGongsi())
            .append("kuaididanhao", getKuaididanhao())
            .append("type", getType())
            .append("count", getCount())
            .append("fujian", getFujian())
            .toString();
    }
}
