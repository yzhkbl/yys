package com.jeethink.system.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.5.3</version>
</dependency>
*/
public class Message {
    public static int makeAuthCode() {
        int authCodeNew =authCodeNew = (int) Math.round(Math.random() * (9999 - 1000) + 1000);
        return authCodeNew;
    }



    public static  Integer a(String phoneNumber,int code){
            DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI8g9QsKTyDySM", "63b6ksWZ0B1KEFlaI0IZW3kXhCL2nR");
            IAcsClient client = new DefaultAcsClient(profile);
            CommonRequest request = new CommonRequest();
            request.setSysMethod(MethodType.POST);
            request.setSysDomain("dysmsapi.aliyuncs.com");
            request.setSysVersion("2017-05-25");
            request.setSysAction("SendSms");
            request.putQueryParameter("RegionId", "cn-hangzhou");
            request.putQueryParameter("PhoneNumbers", phoneNumber);
            request.putQueryParameter("SignName", "中豫融资租赁");
            request.putQueryParameter("TemplateCode", "SMS_210310133");

       // System.err.println(code);
            request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
            try {
                CommonResponse response = client.getCommonResponse(request);
             //  System.out.println(response.getData());
            } catch (ServerException e) {
                e.printStackTrace();
            } catch (ClientException e) {
                e.printStackTrace();
            }
            return code;
        }



}
