package com.jeethink.system.util;

import com.alibaba.fastjson.JSON;
import com.baidu.techain.sdk.model.*;
import com.baidu.techain.sdk.push.IPushClient;
import com.baidu.techain.sdk.push.PushClient;
import com.baidu.techain.sdk.model.Message;

public class PushMessageByPushIdTest {
    public static void main(String[] args) {

        String APPKEY = "Hh5r2rtTTSAEWg7DAgbM3zGpIuUEvnH1";
        String MASTERSECRET = "03j3WGwK1CWkSsbicussk9mwFMRngUGy";
        IPushClient pushClient = new PushClient(APPKEY, MASTERSECRET);

        Message msg = new Message();
        //构建通知栏消息
        Notification notification = new Notification.Builder().
                title("中豫金融").
                content("您的订单：退回了").
                build();

        msg.setMessageType(0); //设置消息类型为通知栏消息
        msg.setNotification(notification);
        //向设备id为"123"的设备发送消息
        PushResult<MessageResult> result = pushClient.
                pushMessageByPushId(msg, "123");
        if (result != null) {
            System.out.println(JSON.toJSONString(result));
        }
    }

    public static String tongzhi(String id,String t,String b) {

        String APPKEY = "Hh5r2rtTTSAEWg7DAgbM3zGpIuUEvnH1";
        String MASTERSECRET = "03j3WGwK1CWkSsbicussk9mwFMRngUGy";
        IPushClient pushClient = new PushClient(APPKEY, MASTERSECRET);

        Message msg = new Message();
        //构建通知栏消息
        Notification notification = new Notification.Builder().
                title("中豫金融").
                content("您的订单："+t+"在"+b+"退回了").
                build();

        msg.setMessageType(0); //设置消息类型为通知栏消息
        msg.setNotification(notification);
        //向设备id为"123"的设备发送消息
        PushResult<MessageResult> result = pushClient.
                pushMessageByPushId(msg, id);
        if (result != null) {
            System.out.println(JSON.toJSONString(result));
        }
        return result.toString();
    }
}