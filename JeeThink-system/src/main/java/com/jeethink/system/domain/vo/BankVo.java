package com.jeethink.system.domain.vo;

import com.jeethink.common.annotation.Excel;
import com.jeethink.common.core.domain.BaseEntity;
import com.jeethink.system.domain.ZyjrBankAccount;
import com.jeethink.system.domain.ZyjrBankExtend;
import com.jeethink.system.domain.ZyjrBankFlow;
import com.jeethink.system.domain.ZyjrBankProduct;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class BankVo extends BaseEntity {

        private static final long serialVersionUID = 1L;

        /** $column.columnComment */
        private Long id;

        /** 银行名称 */
        @Excel(name = "银行名称")
        private String bankName;

        /** 银行所在地 */
        @Excel(name = "银行所在地")
        private String bankLocation;

        /** 联系人员 */
        @Excel(name = "联系人员")
        private String linkman;

        /** 联系电话 */
        @Excel(name = "联系电话")
        private String phoneNumber;

        /** 履约保险设置 */
        @Excel(name = "履约保险设置")
        private Integer isInsurance;

        /** 是否电子签约设置 */
        @Excel(name = "是否电子签约设置")
        private Integer isSign;

        /** 选择需要关联的字段模板 */
        @Excel(name = "选择需要关联的字段模板")
        private String template;
        /**进件流程*/
        private List<ZyjrBankFlow> flow;
        private List<ZyjrBankAccount> returns;
        private List<ZyjrBankProduct> product;
        private List<ZyjrBankExtend> extend;

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

        public List<ZyjrBankExtend> getExtend() {
            return extend;
        }

        public void setExtend(List<ZyjrBankExtend> extend) {
            this.extend = extend;
        }

        public void setId(Long id)
        {
            this.id = id;
        }

        public Long getId()
        {
            return id;
        }
        public void setBankName(String bankName)
        {
            this.bankName = bankName;
        }

        public String getBankName()
        {
            return bankName;
        }
        public void setBankLocation(String bankLocation)
        {
            this.bankLocation = bankLocation;
        }

        public String getBankLocation()
        {
            return bankLocation;
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
        public void setIsInsurance(Integer isInsurance)
        {
            this.isInsurance = isInsurance;
        }

        public Integer getIsInsurance()
        {
            return isInsurance;
        }
        public void setIsSign(Integer isSign)
        {
            this.isSign = isSign;
        }

        public Integer getIsSign()
        {
            return isSign;
        }
        public void setTemplate(String template)
        {
            this.template = template;
        }

        public String getTemplate()
        {
            return template;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                    .append("id", getId())
                    .append("bankName", getBankName())
                    .append("bankLocation", getBankLocation())
                    .append("linkman", getLinkman())
                    .append("remark", getRemark())
                    .append("phoneNumber", getPhoneNumber())
                    .append("createBy", getCreateBy())
                    .append("createTime", getCreateTime())
                    .append("updateBy", getUpdateBy())
                    .append("updateTime", getUpdateTime())
                    .append("isInsurance", getIsInsurance())
                    .append("isSign", getIsSign())
                    .append("template", getTemplate())
                    .append("product",getProduct())
                    .append("returns",getReturns())
                    .append("extend",getExtend())
                    .append("flow",getFlow())
                    .toString();
        }
    }


