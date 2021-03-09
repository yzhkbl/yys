package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_gps
 * 
 * @author jeethink
 * @date 2020-12-23
 */
public class ZyjrGps
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 车商id */
    @Excel(name = "车商id")
    private String zyjrCarId;

    /** 工商中元华兴有线 */
    @Excel(name = "工商中元华兴有线")
    private String industryWired;

    /** 工商中元华兴无线 */
    @Excel(name = "工商中元华兴无线")
    private String industryWireless;

    /** 郑州银行卫正元有线 */
    @Excel(name = "郑州银行卫正元有线")
    private String zhengzhouWired;

    /** 郑州银行卫正元无线 */
    @Excel(name = "郑州银行卫正元无线")
    private String zhengzhouWireless;

    /** 联系人/经销商 */
    @Excel(name = "联系人/经销商")
    private String linkman;

    /** 安装位置 */
    @Excel(name = "安装位置")
    private String location;

    /** 安装地址 */
    @Excel(name = "安装地址")
    private String address;

    /** 安装人员 */
    @Excel(name = "安装人员")
    private String personnel;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 订单号 */
    @Excel(name = "订单号")
    private String transactionCode;

    /** 状态 */
    @Excel(name = "状态")
    private String state;
    private String remark;
    private String bianhao;
    private String yuanjingPic;
    private String jinjingPic;
    private String pic;
    String statePic;

    public String getStatePic() {
        return statePic;
    }

    public void setStatePic(String statePic) {
        this.statePic = statePic;
    }

    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    public String getYuanjingPic() {
        return yuanjingPic;
    }

    public void setYuanjingPic(String yuanjingPic) {
        this.yuanjingPic = yuanjingPic;
    }

    public String getJinjingPic() {
        return jinjingPic;
    }

    public void setJinjingPic(String jinjingPic) {
        this.jinjingPic = jinjingPic;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setZyjrCarId(String zyjrCarId) 
    {
        this.zyjrCarId = zyjrCarId;
    }

    public String getZyjrCarId() 
    {
        return zyjrCarId;
    }
    public void setIndustryWired(String industryWired) 
    {
        this.industryWired = industryWired;
    }

    public String getIndustryWired() 
    {
        return industryWired;
    }
    public void setIndustryWireless(String industryWireless) 
    {
        this.industryWireless = industryWireless;
    }

    public String getIndustryWireless() 
    {
        return industryWireless;
    }
    public void setZhengzhouWired(String zhengzhouWired) 
    {
        this.zhengzhouWired = zhengzhouWired;
    }

    public String getZhengzhouWired() 
    {
        return zhengzhouWired;
    }
    public void setZhengzhouWireless(String zhengzhouWireless) 
    {
        this.zhengzhouWireless = zhengzhouWireless;
    }

    public String getZhengzhouWireless() 
    {
        return zhengzhouWireless;
    }
    public void setLinkman(String linkman) 
    {
        this.linkman = linkman;
    }

    public String getLinkman() 
    {
        return linkman;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setPersonnel(String personnel) 
    {
        this.personnel = personnel;
    }

    public String getPersonnel() 
    {
        return personnel;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setTransactionCode(String transactionCode) 
    {
        this.transactionCode = transactionCode;
    }

    public String getTransactionCode() 
    {
        return transactionCode;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())

            .append("zyjrCarId", getZyjrCarId())
            .append("industryWired", getIndustryWired())
            .append("industryWireless", getIndustryWireless())
            .append("zhengzhouWired", getZhengzhouWired())
            .append("zhengzhouWireless", getZhengzhouWireless())
            .append("linkman", getLinkman())
            .append("location", getLocation())
            .append("address", getAddress())
            .append("personnel", getPersonnel())
            .append("remark", getRemark())
            .append("userId", getUserId())
            .append("transactionCode", getTransactionCode())
            .append("state", getState())
            .toString();
    }
}
