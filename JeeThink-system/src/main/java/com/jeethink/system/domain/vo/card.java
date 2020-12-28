package com.jeethink.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeethink.common.annotation.Excel;
import com.jeethink.system.domain.SysFileInfo;
import com.jeethink.system.domain.ZyjrCarAccount;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class card {
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 备注 */
    private String remark;
    /** 车商名称 */
    @Excel(name = "车商名称")
    private String userName;

    /** 年龄 */
    @Excel(name = "年龄")
    private String gender;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phoneNumber;

    /** 是否是重要联系人 */
    @Excel(name = "是否是重要联系人")
    private String isLinkman;

    /** 身份 */
    @Excel(name = "身份")
    private String identity;

    /** 所属区域 */
    @Excel(name = "所属区域")
    private String area;

    /** 所属城市 */
    @Excel(name = "所属城市")
    private String city;

    /** 所属市场 */
    @Excel(name = "所属市场")
    private String bazaar;

    /** 第一个门店类型 */
    @Excel(name = "第一个门店类型")
    private String shopType;

    /** 第二个门店类型 */
    @Excel(name = "第二个门店类型")
    private String businessType;

    /** 车位数 */
    @Excel(name = "车位数")
    private String stall;

    /** 经营性质 */
    @Excel(name = "经营性质")
    private String businessNature;

    /** 乘用车 */
    @Excel(name = "乘用车")
    private String passengerCar;



    /** 月交易量 */
    @Excel(name = "月交易量")
    private String monthDeal;

    /** 月分期量 */
    @Excel(name = "月分期量")
    private String monthInstallment;

    /** 竟对单量 */
    @Excel(name = "竟对单量")
    private String matchAmount;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String detailAddress;

    /** 门店照片 */
    @Excel(name = "门店照片")
    private String pic;
    private List<SysFileInfo> sysFileInfo;

    private String dealerName;
    private String oneCarState;
    private String twoCarState;
    private String threeCarState;


    /** id */
    private Long id;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    private List<ZyjrCarAccount> zyjrCarAccount;
}
