package com.jeethink.system.domain.vo;

import com.jeethink.common.annotation.Excel;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class CarLoan {
    /** 实际销售价 */
    @Excel(name = "实际销售价")
    private BigDecimal actualPrice;

    /** 车辆贷款金额 */
    @Excel(name = "车辆贷款金额")
    private BigDecimal loanAmount;

    /** 还款期限 */
    @Excel(name = "还款期限")
    private Long repaymentTerm;

    /** 利率换挡 */
    @Excel(name = "对客费率")
    private BigDecimal interestRate;

    /** 续保押金 */
    @Excel(name = "续保押金")
    private BigDecimal deposit;

    private String productType; //产品类型
    private String loanProduct; //贷款产品
    private String gpsCost;//gps费用
    private String fundSide;//资金方
    private BigDecimal fuwufei;//服务费
    private BigDecimal zdke;    //总贷款额
    private BigDecimal sqyg;    //申请月供
    private BigDecimal sqsf;    //申请首付
    private BigDecimal dkfl;    //贷款费率

}
