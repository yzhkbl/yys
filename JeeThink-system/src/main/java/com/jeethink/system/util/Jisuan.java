package com.jeethink.system.util;

import java.math.BigDecimal;

public class Jisuan {
    //银行汇率
    //公司汇率
    //车辆价格
    //贷款金额
    public static BigDecimal calulat(BigDecimal lilv, BigDecimal loan_lilv, BigDecimal price, BigDecimal amount, BigDecimal loan_qi) {
        System.out.println("向上取整:" + (int) Math.ceil(96.1));// 97 (去掉小数凑整:不管小数是多少，都进一)
        System.out.println("向下取整" + (int) Math.floor(96.8));// 96 (去掉小数凑整:不论小数是多少，都不进位)
        System.out.println("四舍五入取整:" + Math.round(96.1));// 96 (这个好理解，不解释)
        System.out.println("四舍五入取整:" + Math.round(96.8));// 97
        BigDecimal s=new BigDecimal(10000);
        BigDecimal ss=new BigDecimal(100);
        BigDecimal sss=new BigDecimal(1);
        BigDecimal a = amount.multiply(s) ;
        //附加费 = （贷款利率-基准利率）*垫资金额
        BigDecimal fujia = (loan_lilv.subtract(lilv)).multiply(a).divide(ss, 2, BigDecimal.ROUND_HALF_UP);
        System.err.println(fujia);
        //透支金额(贷款合计总额) = 垫资金额+手续费
        BigDecimal touzhi = a.add(fujia);
        //分期手续费总额
        BigDecimal shouxf = touzhi.multiply(lilv).divide(ss, 2, BigDecimal.ROUND_HALF_UP);
        //分期款还款总额 = 贷款合计金额 + 手续费
        BigDecimal total = touzhi.add(shouxf);
        /***
         * I5 = a   K5=shouxf   D3=loan_qi  I3 = touzhi  C3=loan_lilv  H3=lilv  M5=persxf
         * */
        //银行本金1期 =I5-K5*(D3-1)  touzhi-shouxf*(loan_qi-1) + a/loan_qi
        BigDecimal perbenjin = a.divide(loan_qi, 2, BigDecimal.ROUND_HALF_UP);
        //银行本金每期
        BigDecimal benjin1 = a.subtract(perbenjin.multiply(loan_qi.subtract(sss)));
        //银行分期每期手续费
        BigDecimal persxf = a.multiply(lilv).divide(loan_qi, 2, BigDecimal.ROUND_HALF_UP);//I5*H3/D3
        //银行分期首期手续费
        BigDecimal sxf1 =a.multiply(lilv).subtract(persxf.multiply(loan_qi.subtract(sss)));//(I5*H3-M5*(D3-1)
        // 附加费本金1期
        BigDecimal perbenjin1 = fujia.divide(loan_qi, 2, BigDecimal.ROUND_HALF_UP);
        // 附加费本金每期
        BigDecimal benjin11 = fujia.subtract(perbenjin1.multiply(loan_qi.subtract(sss)));
        // 附加费分期每期手续费
        BigDecimal persxf1 = fujia.multiply(lilv).divide(loan_qi, 2, BigDecimal.ROUND_HALF_UP);//I5*H3/D3
        //  附加费分期首期手续费
        BigDecimal sxf11 = fujia.multiply(lilv).subtract(persxf1.multiply(loan_qi.subtract(sss)));//(I5*H3-M5*(D3-1)

        /* double b1 = Math.floor(a / loan_qi) + Math.floor(fujia / loan_qi);//4133
        //银行本金首期
        double a1 = Math.floor(touzhi - b1 * (loan_qi - 1)); //4155
        //银行利息首期
        double a2 = Math.floor(a * lilv / loan_qi / 100) + Math.floor(fujia * lilv / loan_qi / 100);//350
        double a3 = touzhi * lilv / 100 - Math.floor(a2 * (loan_qi - 1));//398*/
        BigDecimal ceshi1=sxf1.divide(ss, 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal ceshi2=sxf11.divide(ss, 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal yuehuan = benjin1.add(ceshi1).add(benjin11).add(ceshi2);
        System.err.println(yuehuan);
        System.err.println("向上取整:" + (int) Math.ceil(Double.parseDouble(yuehuan.toString())));// 97 (去掉小数凑整:不管小数是多少，都进一)
        return yuehuan;
    }

    public static void main(String[] args) {
        BigDecimal a=new BigDecimal(9);
        BigDecimal b=new BigDecimal(27);
        BigDecimal c=new BigDecimal("7.2");
        BigDecimal d=new BigDecimal("5");
        BigDecimal e=new BigDecimal(36);
        Jisuan.calulat(a,b,c,d,e);
    }
}
