package com.jeethink.system.util;


import com.alibaba.fastjson.JSON;
import com.baidu.techain.sdk.model.*;
import com.baidu.techain.sdk.push.IPushClient;
import com.baidu.techain.sdk.push.PushClient;
import com.baidu.techain.sdk.model.Message;

import java.util.ArrayList;
import java.util.List;


public class PushMessageByPushIdTest {
    public static void main(String[] args) {

        String APPKEY = "700000915";//Hh5r2rtTTSAEWg7DAgbM3zGpIuUEvnH1
        String MASTERSECRET = "9c40ea76859eaea61820a4e3fa3713f7";
        IPushClient pushClient = new PushClient(APPKEY, MASTERSECRET);

        Message msg = new Message();
        //构建通知栏消息
        Notification notification = new Notification.Builder().
                title("中豫金融").
                content("您的订单：xxxxxxxxxxx" +
                        "退回至xxxxxx。").
                build();
        Aps aps=new Aps();
        aps.setSound("是");
        msg.setAps(aps);
        msg.setMessageType(0); //设置消息类型为通知栏消息
        msg.setNotification(notification);
        //向设备id为"123"的设备发送消息
        PushResult<MessageResult> result = pushClient.
                pushMessageByPushId(msg, "5|0|0aceeca1ba9dcc51591f9f1b3535406a");
        if (result != null) {
            System.out.println(JSON.toJSONString(result));
        }
    }

    public static String tongzhi(String id,String name,String t,String b,List<String> pushIds) {

        String APPKEY = "Hh5r2rtTTSAEWg7DAgbM3zGpIuUEvnH1";
        String MASTERSECRET = "03j3WGwK1CWkSsbicussk9mwFMRngUGy";
        IPushClient pushClient = new PushClient(APPKEY, MASTERSECRET);

        Message msg = new Message();
        Transmission transmission = new Transmission.Builder().
                title("中豫金融").
                content("您的客户:"+name+"(订单号："+t+")在"+b+"退回了！请及时查看！").
                build();
        msg.setMessageType(0); //设置消息类型为通知栏消息
        msg.setTransmission(transmission);

        PushResult<MessageResult> result = pushClient.
                pushMessageByPushIds(msg, pushIds);
        if (result != null) {
            System.out.println(JSON.toJSONString(result));
        }

        return result.toString();
    }
}