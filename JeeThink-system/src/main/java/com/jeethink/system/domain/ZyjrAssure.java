package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * assure对象 zyjr_assure
 * 
 * @author jeethink
 * @date 2020-12-25
 */
public class ZyjrAssure extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 担保名称 */
    @Excel(name = "担保名称")
    private String assureName;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 机构所在地 */
    @Excel(name = "机构所在地")
    private String assureLocation;

    /** 联系人员 */
    @Excel(name = "联系人员")
    private String linkman;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phoneNumber;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAssureName(String assureName) 
    {
        this.assureName = assureName;
    }

    public String getAssureName() 
    {
        return assureName;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setAssureLocation(String assureLocation) 
    {
        this.assureLocation = assureLocation;
    }

    public String getAssureLocation() 
    {
        return assureLocation;
    }
    public void setLinkman(String linkman) 
    {
        this.linkman = linkman;
    }

    public String getLinkman() 
    {
        return linkman;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("assureName", getAssureName())
            .append("address", getAddress())
            .append("assureLocation", getAssureLocation())
            .append("linkman", getLinkman())
            .append("remark", getRemark())
            .append("phoneNumber", getPhoneNumber())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
