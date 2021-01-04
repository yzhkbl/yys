package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

import java.util.List;

/**
 * insuranceType对象 zyjr_insurance_type
 * 
 * @author jeethink
 * @date 2020-12-29
 */
public class ZyjrInsuranceType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 保险名称 */
    @Excel(name = "保险名称")
    private String name;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 联系人员 */
    @Excel(name = "联系人员")
    private String linkman;

    /** 履约保险设置 */
    @Excel(name = "履约保险设置")
    private Boolean isInsurance;

    /** 是否电子签约设置 */
    @Excel(name = "是否电子签约设置")
    private Boolean isSign;
    private List<ZyjrBankFlow> flow;
    private List<ZyjrBankAccount> returns;
    private List<ZyjrBankProduct> product;
    private List<SysFileInfo> sysFileInfo;
    private String area;

    public List<SysFileInfo> getSysFileInfo() {
        return sysFileInfo;
    }

    public void setSysFileInfo(List<SysFileInfo> sysFileInfo) {
        this.sysFileInfo = sysFileInfo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<ZyjrBankFlow> getFlow() {
        return flow;
    }

    public void setFlow(List<ZyjrBankFlow> flow) {
        this.flow = flow;
    }

    public List<ZyjrBankAccount> getReturns() {
        return returns;
    }

    public void setReturns(List<ZyjrBankAccount> returns) {
        this.returns = returns;
    }

    public List<ZyjrBankProduct> getProduct() {
        return product;
    }

    public void setProduct(List<ZyjrBankProduct> product) {
        this.product = product;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setLinkman(String linkman) 
    {
        this.linkman = linkman;
    }

    public String getLinkman() 
    {
        return linkman;
    }
    public void setIsInsurance(Boolean isInsurance)
    {
        this.isInsurance = isInsurance;
    }

    public Boolean getIsInsurance()
    {
        return isInsurance;
    }
    public void setIsSign(Boolean isSign)
    {
        this.isSign = isSign;
    }

    public Boolean getIsSign()
    {
        return isSign;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("address", getAddress())
            .append("linkman", getLinkman())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("isInsurance", getIsInsurance())
            .append("isSign", getIsSign())
                .append("area",getArea())
            .toString();
    }
}
