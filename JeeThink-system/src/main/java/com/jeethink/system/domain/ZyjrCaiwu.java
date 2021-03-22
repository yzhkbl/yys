package com.jeethink.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 zyjr_caiwu
 * 
 * @author jeethink
 * @date 2021-03-18
 */
public class ZyjrCaiwu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 垫资方式 */
    @Excel(name = "垫资方式")
    private String mode;

    /** 打款账户id */
    @Excel(name = "打款账户id")
    private Long zhanghu;

    /** 打款金额 */
    @Excel(name = "打款金额")
    private String money;

    /** 打款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "打款时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    /** 图片 */
    @Excel(name = "图片")
    private String transactionCode;

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMode(String mode) 
    {
        this.mode = mode;
    }

    public String getMode() 
    {
        return mode;
    }
    public void setZhanghu(Long zhanghu)
    {
        this.zhanghu = zhanghu;
    }

    public Long getZhanghu()
    {
        return zhanghu;
    }
    public void setMoney(String money) 
    {
        this.money = money;
    }

    public String getMoney() 
    {
        return money;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("mode", getMode())
            .append("zhanghu", getZhanghu())
            .append("money", getMoney())
            .append("remark", getRemark())
            .append("time", getTime())

            .toString();
    }
}
