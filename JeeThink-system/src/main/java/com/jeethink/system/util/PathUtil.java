package com.jeethink.system.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PathUtil {
    private static Properties properties = null;
    static{
        try {
            InputStream is = PathUtil.class.getResourceAsStream("/path.properties");
            properties = new Properties();
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 根据key值取得对应的value值
     * @param key
     * @return
     */
    public static String getValue(String key) {
        return properties.getProperty(key);
    }
}