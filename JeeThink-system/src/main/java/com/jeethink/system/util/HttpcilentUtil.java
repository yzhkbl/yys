package com.jeethink.system.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class HttpcilentUtil {
    public String tt(String url1, MultipartFile file) throws Exception {
//        //new一个URL对象
//        URL url = new URL(url1);
//        //打开链接
//        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//        //设置请求方式为"GET"
//        conn.setRequestMethod("GET");
//        //超时响应时间为5秒
//        conn.setConnectTimeout(5 * 1000);
//        //通过输入流获取图片数据
//
//
//
//
//        InputStream inStream1 = conn.getInputStream();
//        InputStream inStream2 = file.getInputStream();
//        //得到图片的二进制数据，以二进制封装得到数据，具有通用性
//        byte[] data1 = readInputStream(inStream1);
//        byte[] data2 = readInputStream(inStream2);
        byte[] data3 = GenerateImage(url1);
        //new一个文件对象用来保存图片，默认保存当前工程根目录
        String lateName = System.currentTimeMillis() + ".jpg";
        String destFileName = "C:\\Users\\admin\\Desktop\\a\\" + lateName;
        File imageFile = new File(destFileName);
        //创建输出流
        FileOutputStream outStream = new FileOutputStream(imageFile);
        //写入数据
//        outStream.write(data);
        outStream.write(data3);
        //关闭输出流
        outStream.close();
        return lateName;
    }

    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while ((len = inStream.read(buffer)) != -1) {
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }

    //base64字符串转化成图片
    public static byte[] GenerateImage(String imgStr) {
        //对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null)
            return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            return b;
        } catch (Exception e) {
            return null;
        }
    }
}


