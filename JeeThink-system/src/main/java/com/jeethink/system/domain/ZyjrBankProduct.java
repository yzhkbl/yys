package com.jeethink.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;

import java.util.List;

/**
 * product对象 zyjr_bank_product
 * 
 * @author jeethink
 * @date 2020-12-26
 */
public class ZyjrBankProduct
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** zyjr_bank的id */
    @Excel(name = "zyjr_bank的id")
    private String bankId;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 产品代码 */
    @Excel(name = "产品代码")
    private String productCode;

    /** 产品品牌 */
    @Excel(name = "产品品牌")
    private String productBrand;

    /** 备注 */
    @Excel(name = "备注")
    private String productRemark;

    /** 车辆类型 */
    @Excel(name = "车辆类型")
    private String carType;

    /** 业务区域 */
    @Excel(name = "业务区域")
    private String businessArea;
    private List<ZyjrBankScheme> scheme;
    private String areaInput;
    private String brandInput;
    private String baoxian;
    private String belongBank;

    public String getBelongBank() {
        return belongBank;
    }

    public void setBelongBank(String belongBank) {
        this.belongBank = belongBank;
    }

    public String getBaoxian() {
        return baoxian;
    }

    public void setBaoxian(String baoxian) {
        this.baoxian = baoxian;
    }

    public String getBrandInput() {
        return brandInput;
    }

    public void setBrandInput(String brandInput) {
        this.brandInput = brandInput;
    }

    public String getAreaInput() {
        return areaInput;
    }

    public void setAreaInput(String areaInput) {
        this.areaInput = areaInput;
    }

    public List<ZyjrBankScheme> getScheme() {
        return scheme;
    }

    public void setScheme(List<ZyjrBankScheme> scheme) {
        this.scheme = scheme;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBankId(String bankId) 
    {
        this.bankId = bankId;
    }

    public String getBankId() 
    {
        return bankId;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductCode(String productCode) 
    {
        this.productCode = productCode;
    }

    public String getProductCode() 
    {
        return productCode;
    }
    public void setProductBrand(String productBrand) 
    {
        this.productBrand = productBrand;
    }

    public String getProductBrand() 
    {
        return productBrand;
    }
    public void setProductRemark(String productRemark) 
    {
        this.productRemark = productRemark;
    }

    public String getProductRemark() 
    {
        return productRemark;
    }
    public void setCarType(String carType) 
    {
        this.carType = carType;
    }

    public String getCarType() 
    {
        return carType;
    }
    public void setBusinessArea(String businessArea) 
    {
        this.businessArea = businessArea;
    }

    public String getBusinessArea() 
    {
        return businessArea;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())

            .append("bankId", getBankId())
            .append("productName", getProductName())
            .append("productCode", getProductCode())
            .append("productBrand", getProductBrand())
            .append("productRemark", getProductRemark())
            .append("carType", getCarType())
                .append("scheme",getScheme())
            .append("businessArea", getBusinessArea())
                .append("areaInput",getAreaInput())
                .append("brandInput",getBrandInput())
                .append("baoxian",getBaoxian())
                .append("belongBank",getBelongBank())
            .toString();
    }
}
