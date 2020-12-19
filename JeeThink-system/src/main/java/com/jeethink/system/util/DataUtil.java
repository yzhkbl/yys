package com.jeethink.system.util;

public class DataUtil {

    public static String data(String a){
        StringBuilder sb = new StringBuilder(a);//构造一个StringBuilder对象
        sb.insert(4, ".");//在指定的位置1，插入指定的字符串
        sb.insert(7, ".");
        a = sb.toString();
        return a;
    }
    }
