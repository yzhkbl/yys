package com.jeethink.system.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class orderCode {
    //订单编号前缀
    public static final String PREFIX = "ZYJR";
    //订单编号后缀（核心部分）
    private static long code;

    // 生成订单编号
    public static synchronized String getOrderCode() {
        code++;
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        long m = Long.parseLong((str)) * 10000;
        m += code;
        return PREFIX + m;
    }
}
