package com.jeethink.system.domain.vo;

import com.jeethink.common.annotation.Excel;
import lombok.Data;

@Data
public class ZyjrCardVo {



    /** 证件类型(0-身份证 1-护照 2-军官证 3-士兵证 4-回乡证 5-临时身份证 6-户口本 7-其他 9-警官证) */
    private Integer custsort;

    /** 证件号码 */
    private String custcode;

    /** 姓名 */
    private String chnsname;

    /** 姓名拼音 */
    private String engname;

    /** 性别 */
    private Integer sex;

    /** 婚姻状况 */
    private Integer mrtlstat;

    /** 受教育程度 */
    private Integer edulvl;

    /** 卡片领取方式 */
    private Integer drawmode;

    /** 领卡地区号 */
    private String drawzono;

    /** 领卡网点号 */
    private String drawbrno;

    /** 住宅状况 */
    private Integer homestat;

    /** 住宅地址省份 */
    private String hprovince;

    /** 住宅地址市 */
    private String hcity;

    /** 住宅地址县(区) */
    private String hcounty;

    /** 住宅地址 */
    private String haddress;

    /** 住宅邮编 */
    private String homezip;

    /** 入住日期 */
    private String indate;

    /** 手机号码 */
    private String mvblno;

    /** 电子邮箱 */
    private String email;

    /** 工作单位名称 */
    private String unitname;

    /** 职务 */
    private Integer duty;

    /** 单位电话区号 */
    private String cophozono;

    /** 单位电话号码 */
    private String cophoneno;

    /** 单位地址省份 */
    private String cprovince;

    /** 单位地址市 */
    private String ccity;

    /** 单位地址县（区） */
    private String ccounty;

    /** 工作单位地址（详细地址） */
    private String caddress;

    /** 单位邮编 */
    private String corpzip;

    /** 进入现单位工作时间 */
    private String joindate;

    /** 本人年收入 */
    private Long yearincome;

    /** 单位性质 */
    private Integer modelcode;

    /** 职业及职级 */
    private Integer occptn;

    /** 自购车状况 */
    private Integer carstat;

    /** 联系人1姓名 */
    private String reltname1;

    /** 联系人1与主卡联系人关系 */
    private Integer reltship1;

    /** 联系人1联系电话区号 */
    private String reltphzon1;

    /** 联系人1联系电话号码 */
    private String relaphone1;

    /** 联系人1手机 */
    private String reltmobl1;

    /** 证件有效期 */
    private String statdate;

    /** 国籍 */
    private Integer primnat;

    /** 亲见客户签名 */
    private Integer cstsign;

    /** 联名单位会员号 */
    private String almebno;

    /**  转出卡号/账号 */
    private String outcardno1;
}
