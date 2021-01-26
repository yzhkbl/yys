package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_yeji_yue
 * 
 * @author jeethink
 * @date 2021-01-25
 */
public class ZyjrYejiYue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 团队 */
    @Excel(name = "团队")
    private String team;

    /** 地区 */
    @Excel(name = "地区")
    private String area;

    /** 目标贷款额 */
    @Excel(name = "目标贷款额")
    private String mubiao;

    /** 次数 */
    @Excel(name = "次数")
    private Long number;

    /** ID */
    private Long id;

    String fangkuan;
    String wanchenglv;
    String junjia;

    public String getJunjia() {
        return junjia;
    }

    public void setJunjia(String junjia) {
        this.junjia = junjia;
    }

    public String getWanchenglv() {
        return wanchenglv;
    }

    public void setWanchenglv(String wanchenglv) {
        this.wanchenglv = wanchenglv;
    }

    public String getFangkuan() {
        return fangkuan;
    }

    public void setFangkuan(String fangkuan) {
        this.fangkuan = fangkuan;
    }

    public void setTeam(String team)
    {
        this.team = team;
    }

    public String getTeam() 
    {
        return team;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setMubiao(String mubiao) 
    {
        this.mubiao = mubiao;
    }

    public String getMubiao() 
    {
        return mubiao;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
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
            .append("team", getTeam())
            .append("area", getArea())
            .append("mubiao", getMubiao())
            .append("number", getNumber())
            .append("id", getId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("junjia", getJunjia())
            .toString();
    }
}
