package com.jeethink.system.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {

    public static String data(String a){
        StringBuilder sb = new StringBuilder(a);//构造一个StringBuilder对象
        sb.insert(4, ".");//在指定的位置1，插入指定的字符串
        sb.insert(7, ".");
        a = sb.toString();
        return a;
    }

    public static String date(String a){
        StringBuilder sb = new StringBuilder(a);//构造一个StringBuilder对象
        sb.insert(4, "-");//在指定的位置1，插入指定的字符串
        sb.insert(7, "-");
        a = sb.toString();
        return a;
    }
    public static String subMonth(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, 1);
        rightNow.add(Calendar.DAY_OF_MONTH, -1);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }
    }
