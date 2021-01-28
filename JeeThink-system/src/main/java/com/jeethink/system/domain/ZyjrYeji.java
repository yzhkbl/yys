package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 【请填写功能名称】对象 zyjr_yeji
 * 
 * @author jeethink
 * @date 2021-01-23
 */
public class ZyjrYeji extends BaseEntity
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

    /** 放款总金额 */
    @Excel(name = "放款总金额")
    private String fangkuan;

    /** 次数 */
    @Excel(name = "次数")
    private Long number;

    /** ID */
    private Long id;

    /** 部门ID */
    @Excel(name = "部门ID")
    private Long deptId;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String transaction;

    /** 名称 */
    @Excel(name = "名称")
    private String name;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
    public void setFangkuan(String fangkuan) 
    {
        this.fangkuan = fangkuan;
    }

    public String getFangkuan() 
    {
        return fangkuan;
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
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setTransaction(String transaction) 
    {
        this.transaction = transaction;
    }

    public String getTransaction() 
    {
        return transaction;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("team", getTeam())
            .append("area", getArea())
            .append("mubiao", getMubiao())
            .append("fangkuan", getFangkuan())
            .append("number", getNumber())
            .append("id", getId())
            .append("deptId", getDeptId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("date",getDate())
            .append("userId", getUserId())
            .append("transaction", getTransaction())
            .append("name", getName())
            .toString();
    }
}
