package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

/**
 * card对象 zyjr_card
 * 
 * @author jeethink
 * @date 2020-12-30
 */
public class ZyjrCard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 证件类型(0-身份证 1-护照 2-军官证 3-士兵证 4-回乡证 5-临时身份证 6-户口本 7-其他 9-警官证) */
    @Excel(name = "证件类型(0-身份证 1-护照 2-军官证 3-士兵证 4-回乡证 5-临时身份证 6-户口本 7-其他 9-警官证)")
    private Integer custsort;

    /** 证件号码 */
    @Excel(name = "证件号码")
    private String custcode;

    /** 姓名 */
    @Excel(name = "姓名")
    private String chnsname;

    /** 姓名拼音 */
    @Excel(name = "姓名拼音")
    private String engname;

    /** 性别 */
    @Excel(name = "性别")
    private Integer sex;

    /** 婚姻状况 */
    @Excel(name = "婚姻状况")
    private Integer mrtlstat;

    /** 受教育程度 */
    @Excel(name = "受教育程度")
    private Integer edulvl;

    /** 卡片领取方式 */
    @Excel(name = "卡片领取方式")
    private Integer drawmode;

    /** 领卡地区号 */
    @Excel(name = "领卡地区号")
    private String drawzono;

    /** 领卡网点号 */
    @Excel(name = "领卡网点号")
    private String drawbrno;

    /** 住宅状况 */
    @Excel(name = "住宅状况")
    private Integer homestat;

    /** 住宅地址省份 */
    @Excel(name = "住宅地址省份")
    private String hprovince;

    /** 住宅地址市 */
    @Excel(name = "住宅地址市")
    private String hcity;

    /** 住宅地址县(区) */
    @Excel(name = "住宅地址县(区)")
    private String hcounty;

    /** 住宅地址 */
    @Excel(name = "住宅地址")
    private String haddress;

    /** 住宅邮编 */
    @Excel(name = "住宅邮编")
    private String homezip;

    /** 入住日期 */
    @Excel(name = "入住日期")
    private String indate;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String mvblno;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    /** 工作单位名称 */
    @Excel(name = "工作单位名称")
    private String unitname;

    /** 职务 */
    @Excel(name = "职务")
    private Integer duty;

    /** 单位电话区号 */
    @Excel(name = "单位电话区号")
    private String cophozono;

    /** 单位电话号码 */
    @Excel(name = "单位电话号码")
    private String cophoneno;

    /** 单位地址省份 */
    @Excel(name = "单位地址省份")
    private String cprovince;

    /** 单位地址市 */
    @Excel(name = "单位地址市")
    private String ccity;

    /** 单位地址县（区） */
    @Excel(name = "单位地址县", readConverterExp = "区=")
    private String ccounty;

    /** 工作单位地址（详细地址） */
    @Excel(name = "工作单位地址", readConverterExp = "详=细地址")
    private String caddress;

    /** 单位邮编 */
    @Excel(name = "单位邮编")
    private String corpzip;

    /** 进入现单位工作时间 */
    @Excel(name = "进入现单位工作时间")
    private String joindate;

    /** 本人年收入 */
    @Excel(name = "本人年收入")
    private Long yearincome;

    /** 单位性质 */
    @Excel(name = "单位性质")
    private Integer modelcode;

    /** 职业及职级 */
    @Excel(name = "职业及职级")
    private Integer occptn;

    /** 自购车状况 */
    @Excel(name = "自购车状况")
    private Integer carstat;

    /** 联系人1姓名 */
    @Excel(name = "联系人1姓名")
    private String reltname1;

    /** 联系人1与主卡联系人关系 */
    @Excel(name = "联系人1与主卡联系人关系")
    private Integer reltship1;

    /** 联系人1联系电话区号 */
    @Excel(name = "联系人1联系电话区号")
    private String reltphzon1;

    /** 联系人1联系电话号码 */
    @Excel(name = "联系人1联系电话号码")
    private String relaphone1;

    /** 联系人1手机 */
    @Excel(name = "联系人1手机")
    private String reltmobl1;

    /** 证件有效期 */
    @Excel(name = "证件有效期")
    private String statdate;

    /** 国籍 */
    @Excel(name = "国籍")
    private Integer primnat;

    /** 亲见客户签名 */
    @Excel(name = "亲见客户签名")
    private Integer cstsign;

    /** 联名单位会员号 */
    @Excel(name = "联名单位会员号")
    private String almebno;

    /**  转出卡号/账号 */
    @Excel(name = " 转出卡号/账号")
    private String outcardno1;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String transactionCode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCustsort(Integer custsort) 
    {
        this.custsort = custsort;
    }

    public Integer getCustsort() 
    {
        return custsort;
    }
    public void setCustcode(String custcode) 
    {
        this.custcode = custcode;
    }

    public String getCustcode() 
    {
        return custcode;
    }
    public void setChnsname(String chnsname) 
    {
        this.chnsname = chnsname;
    }

    public String getChnsname() 
    {
        return chnsname;
    }
    public void setEngname(String engname) 
    {
        this.engname = engname;
    }

    public String getEngname() 
    {
        return engname;
    }
    public void setSex(Integer sex) 
    {
        this.sex = sex;
    }

    public Integer getSex() 
    {
        return sex;
    }
    public void setMrtlstat(Integer mrtlstat) 
    {
        this.mrtlstat = mrtlstat;
    }

    public Integer getMrtlstat() 
    {
        return mrtlstat;
    }
    public void setEdulvl(Integer edulvl) 
    {
        this.edulvl = edulvl;
    }

    public Integer getEdulvl() 
    {
        return edulvl;
    }
    public void setDrawmode(Integer drawmode) 
    {
        this.drawmode = drawmode;
    }

    public Integer getDrawmode() 
    {
        return drawmode;
    }
    public void setDrawzono(String drawzono) 
    {
        this.drawzono = drawzono;
    }

    public String getDrawzono() 
    {
        return drawzono;
    }
    public void setDrawbrno(String drawbrno) 
    {
        this.drawbrno = drawbrno;
    }

    public String getDrawbrno() 
    {
        return drawbrno;
    }
    public void setHomestat(Integer homestat) 
    {
        this.homestat = homestat;
    }

    public Integer getHomestat() 
    {
        return homestat;
    }
    public void setHprovince(String hprovince) 
    {
        this.hprovince = hprovince;
    }

    public String getHprovince() 
    {
        return hprovince;
    }
    public void setHcity(String hcity) 
    {
        this.hcity = hcity;
    }

    public String getHcity() 
    {
        return hcity;
    }
    public void setHcounty(String hcounty) 
    {
        this.hcounty = hcounty;
    }

    public String getHcounty() 
    {
        return hcounty;
    }
    public void setHaddress(String haddress) 
    {
        this.haddress = haddress;
    }

    public String getHaddress() 
    {
        return haddress;
    }
    public void setHomezip(String homezip) 
    {
        this.homezip = homezip;
    }

    public String getHomezip() 
    {
        return homezip;
    }
    public void setIndate(String indate) 
    {
        this.indate = indate;
    }

    public String getIndate() 
    {
        return indate;
    }
    public void setMvblno(String mvblno) 
    {
        this.mvblno = mvblno;
    }

    public String getMvblno() 
    {
        return mvblno;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setUnitname(String unitname) 
    {
        this.unitname = unitname;
    }

    public String getUnitname() 
    {
        return unitname;
    }
    public void setDuty(Integer duty) 
    {
        this.duty = duty;
    }

    public Integer getDuty() 
    {
        return duty;
    }
    public void setCophozono(String cophozono) 
    {
        this.cophozono = cophozono;
    }

    public String getCophozono() 
    {
        return cophozono;
    }
    public void setCophoneno(String cophoneno) 
    {
        this.cophoneno = cophoneno;
    }

    public String getCophoneno() 
    {
        return cophoneno;
    }
    public void setCprovince(String cprovince) 
    {
        this.cprovince = cprovince;
    }

    public String getCprovince() 
    {
        return cprovince;
    }
    public void setCcity(String ccity) 
    {
        this.ccity = ccity;
    }

    public String getCcity() 
    {
        return ccity;
    }
    public void setCcounty(String ccounty) 
    {
        this.ccounty = ccounty;
    }

    public String getCcounty() 
    {
        return ccounty;
    }
    public void setCaddress(String caddress) 
    {
        this.caddress = caddress;
    }

    public String getCaddress() 
    {
        return caddress;
    }
    public void setCorpzip(String corpzip) 
    {
        this.corpzip = corpzip;
    }

    public String getCorpzip() 
    {
        return corpzip;
    }
    public void setJoindate(String joindate) 
    {
        this.joindate = joindate;
    }

    public String getJoindate() 
    {
        return joindate;
    }
    public void setYearincome(Long yearincome) 
    {
        this.yearincome = yearincome;
    }

    public Long getYearincome() 
    {
        return yearincome;
    }
    public void setModelcode(Integer modelcode) 
    {
        this.modelcode = modelcode;
    }

    public Integer getModelcode() 
    {
        return modelcode;
    }
    public void setOccptn(Integer occptn) 
    {
        this.occptn = occptn;
    }

    public Integer getOccptn() 
    {
        return occptn;
    }
    public void setCarstat(Integer carstat) 
    {
        this.carstat = carstat;
    }

    public Integer getCarstat() 
    {
        return carstat;
    }
    public void setReltname1(String reltname1) 
    {
        this.reltname1 = reltname1;
    }

    public String getReltname1() 
    {
        return reltname1;
    }
    public void setReltship1(Integer reltship1) 
    {
        this.reltship1 = reltship1;
    }

    public Integer getReltship1() 
    {
        return reltship1;
    }
    public void setReltphzon1(String reltphzon1) 
    {
        this.reltphzon1 = reltphzon1;
    }

    public String getReltphzon1() 
    {
        return reltphzon1;
    }
    public void setRelaphone1(String relaphone1) 
    {
        this.relaphone1 = relaphone1;
    }

    public String getRelaphone1() 
    {
        return relaphone1;
    }
    public void setReltmobl1(String reltmobl1) 
    {
        this.reltmobl1 = reltmobl1;
    }

    public String getReltmobl1() 
    {
        return reltmobl1;
    }
    public void setStatdate(String statdate) 
    {
        this.statdate = statdate;
    }

    public String getStatdate() 
    {
        return statdate;
    }
    public void setPrimnat(Integer primnat) 
    {
        this.primnat = primnat;
    }

    public Integer getPrimnat() 
    {
        return primnat;
    }
    public void setCstsign(Integer cstsign) 
    {
        this.cstsign = cstsign;
    }

    public Integer getCstsign() 
    {
        return cstsign;
    }
    public void setAlmebno(String almebno) 
    {
        this.almebno = almebno;
    }

    public String getAlmebno() 
    {
        return almebno;
    }
    public void setOutcardno1(String outcardno1) 
    {
        this.outcardno1 = outcardno1;
    }

    public String getOutcardno1() 
    {
        return outcardno1;
    }
    public void setTransactionCode(String transactionCode) 
    {
        this.transactionCode = transactionCode;
    }

    public String getTransactionCode() 
    {
        return transactionCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("custsort", getCustsort())
            .append("custcode", getCustcode())
            .append("chnsname", getChnsname())
            .append("engname", getEngname())
            .append("sex", getSex())
            .append("mrtlstat", getMrtlstat())
            .append("edulvl", getEdulvl())
            .append("drawmode", getDrawmode())
            .append("drawzono", getDrawzono())
            .append("drawbrno", getDrawbrno())
            .append("homestat", getHomestat())
            .append("hprovince", getHprovince())
            .append("hcity", getHcity())
            .append("hcounty", getHcounty())
            .append("haddress", getHaddress())
            .append("homezip", getHomezip())
            .append("indate", getIndate())
            .append("mvblno", getMvblno())
            .append("email", getEmail())
            .append("unitname", getUnitname())
            .append("duty", getDuty())
            .append("cophozono", getCophozono())
            .append("cophoneno", getCophoneno())
            .append("cprovince", getCprovince())
            .append("ccity", getCcity())
            .append("ccounty", getCcounty())
            .append("caddress", getCaddress())
            .append("corpzip", getCorpzip())
            .append("joindate", getJoindate())
            .append("yearincome", getYearincome())
            .append("modelcode", getModelcode())
            .append("occptn", getOccptn())
            .append("carstat", getCarstat())
            .append("reltname1", getReltname1())
            .append("reltship1", getReltship1())
            .append("reltphzon1", getReltphzon1())
            .append("relaphone1", getRelaphone1())
            .append("reltmobl1", getReltmobl1())
            .append("statdate", getStatdate())
            .append("primnat", getPrimnat())
            .append("cstsign", getCstsign())
            .append("almebno", getAlmebno())
            .append("outcardno1", getOutcardno1())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("transactionCode", getTransactionCode())
            .toString();
    }
}
