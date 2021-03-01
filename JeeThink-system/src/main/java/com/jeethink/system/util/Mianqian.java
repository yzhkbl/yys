package com.jeethink.system.util;

import com.jeethink.common.utils.http.HttpUtils;

public class Mianqian {
    public static String post(String name,String idCard) {
        String code="S36029951";
        String s = HttpUtils.sendPost("https://mov.hrfax.cn:446/report/pullCarloanReport", "deptCode="+code+"&&clientName="+name+"&&clientIdCard="+idCard+"");
        return s;
    }
}
