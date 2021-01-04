package com.jeethink.system.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class JzgUtil {
    /**
     * paramMap为请求参数的集合
     *
     * tokenKey 由精真估提供的加密参数
     *
     * @param paramMap
     * @param tokenKey
     * @return
     */
    public static String getSign(Map<String, String> paramMap, String tokenKey) {
        List<String> paramList = new ArrayList<>();
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            String key = entry.getKey();
            if ("sign".equals(key) || "Sign".equals(key)) {
                continue;
            }
            String value = entry.getValue();
            // 拼接key和value并转换为小写
            paramList.add(key.toLowerCase() + "=" + value.toLowerCase());
        }
        Collections.sort(paramList);// 参数按照A--Z排序
        StringBuilder paramBuilder = new StringBuilder();
        for (String param : paramList) {
            paramBuilder.append(param);
        }
        String blankParam = paramBuilder.toString();
        // 加上机构对应的key小写
        blankParam += tokenKey.toLowerCase();
        // md5加密以后
        String sign = null;
        try {
            sign = md5(blankParam);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sign;
    }

    /**
     * Md5生成方式
     *
     * @param key
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static String md5(String key) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {

        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(key.getBytes("UTF-8"));
            byte[] data = md.digest();
            int index;
            for (byte b : data) {
                index = b;
                if (index < 0) {
                    index += 256;
                }
                if (index < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(index));
            }
        } catch (NoSuchAlgorithmException e) {
            System.err.println("key:" + key + ", use md5 failed");
        }

        return sb.toString().toUpperCase();

    }

    public static void removeNullEntry(Map map){
        removeNullKey(map);
        removeNullValue(map);
    }

    /**
     * 移除map的空key
     * @param map
     * @return
     */
    public static void removeNullKey(Map map){
        Set set = map.keySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext();) {
            Object obj = (Object) iterator.next();
            remove(obj, iterator);
        }
    }

    /**
     * 移除map中的value空值
     * @param map
     * @return
     */
    public static void removeNullValue(Map map) {
        Set set = map.keySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            Object obj = (Object) iterator.next();
            Object value = (Object) map.get(obj);
            remove(value, iterator);
        }
    }
    private static void remove(Object obj,Iterator iterator){
        if(obj instanceof String){
            String str = (String)obj;
            if(isEmpty(str)){  //过滤掉为null和""的值 主函数输出结果map：{2=BB, 1=AA, 5=CC, 8=  }
//            if("".equals(str.trim())){  //过滤掉为null、""和" "的值 主函数输出结果map：{2=BB, 1=AA, 5=CC}
                iterator.remove();
            }

        }else if(obj instanceof Collection){
            Collection col = (Collection)obj;
            if(col==null||col.isEmpty()){
                iterator.remove();
            }

        }else if(obj instanceof Map){
            Map temp = (Map)obj;
            if(temp==null||temp.isEmpty()){
                iterator.remove();
            }

        }else if(obj instanceof Object[]){
            Object[] array =(Object[])obj;
            if(array==null||array.length<=0){
                iterator.remove();
            }
        }else{
            if(obj==null){
                iterator.remove();
            }
        }
    }

    public static boolean isEmpty(Object obj){
        return obj == null || obj.toString().length() == 0;
    }




}
