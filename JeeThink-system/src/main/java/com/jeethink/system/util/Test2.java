package com.jeethink.system.util;

import com.bfd.facade.MerchantServer;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

public class Test2 {
    /**
     * 策略贷前、验证接口
     */
    //使用邮箱里面的账号、密码、apicode
    private static String userName="zyrzWEB";
    private static String  password="zyrzWEB";
    private static String apiCode="3004954";
    private static volatile String tokenId;
    private static MerchantServer ms = new MerchantServer();
    //可以使用正式环境接口地址  LoginApi(正式环境)   SandboxLoginApi(测试环境)
    private static String loginName="LoginApi";
    //接口地址(apiName传以下参数)---
    //	贷前策略地址：strategyApi(正式环境)		SandboxstrategyApi(测试环境)
    //	验证策略地址：verificationApi (正式地址)	SandboxverApi(测试地址)
    //注：1.测试过程可以使用正式地址
    //   2.apiName环境要保持与loginName环境一致,正式都是正式、测试都是测试,不可以交叉使用.
    //   3.在调用测试环境时需要事先联系百融技术并提供apicode及策略编号（策略编号请查看邮件里的策略配置表）
    private static String apiName= "verificationApi";
    //验证请使用以下代码
    public static void main(String[] args) {
        JSONObject jsonData = new JSONObject();
        JSONObject reqData = new JSONObject();
        jsonData.put("apiName",apiName);
        jsonData.put("tokenid","zyrzWEB_67005A073406B38369C9B9B50BFD767B");
        //验证的策略编号(请查看策略配置表)
        reqData.put("conf_id","MCP0034436");
        //请求参数 id cell name (如产品文档有其他必传参数按照产品文档为主)
        reqData.put("id","411521199801206410");
        reqData.put("cell","17596567126");
        reqData.put("name","杨玉山");
        jsonData.put("reqData",reqData);
        System.out.println("请求参数:"+jsonData.toString());
        String result = getBrData(jsonData.toString());
        System.out.println("返回值:"+result);
    }

    public static String conf(String tokenid,String id,String cell,String name){
        JSONObject jsonData = new JSONObject();
        JSONObject reqData = new JSONObject();
        jsonData.put("apiName",apiName);
        jsonData.put("tokenid",tokenid);
        //验证的策略编号(请查看策略配置表)
        reqData.put("conf_id","MCP0034436");
        //请求参数 id cell name (如产品文档有其他必传参数按照产品文档为主)
        reqData.put("id",id);
        reqData.put("cell",cell);
        reqData.put("name",name);
        jsonData.put("reqData",reqData);
        System.out.println("请求参数:"+jsonData.toString());
        String result = getBrData(jsonData.toString());
        System.out.println("返回值:"+result);
        return result;
    }
    //贷前请使用以下代码
 /*   public static void main(String[] args) {

        JSONObject jsonData = new JSONObject();
        JSONObject reqData = new JSONObject();
        jsonData.put("apiName",apiName);
        jsonData.put("tokenid", Test2.getTokenId());
        //贷前的策略编号(请查看策略配置表)
        reqData.put("strategy_id","MCP0034436");
        //请求参数 id cell name (如产品文档有其他必传参数按照文档为主)
        reqData.put("id","411521199801206410");
        reqData.put("cell","17596567126");
        reqData.put("name","杨玉山");
        jsonData.put("reqData",reqData);
        System.out.println("请求参数:"+jsonData.toString());
        String result = getBrData(jsonData.toString());
        System.out.println("返回值:"+result);
    }*/

    public static String getTokenId(){
        if(StringUtils.isBlank(tokenId)){
            synchronized (Test2.class){
                if(StringUtils.isBlank(tokenId)){
                    tokenId=generateToken();
                }
            }
        }
        return tokenId;
    }

    public static String generateToken(){
        String token="";
        try{
            String login_res_str = ms.login(userName,password,loginName,apiCode);
            if(StringUtils.isNotBlank(login_res_str)){
                JSONObject loginJson = JSONObject.fromObject(login_res_str);
                if(loginJson.containsKey("tokenid")){
                    token = loginJson.getString("tokenid");
                }else {
                    System.out.println("返回结果异常，无token!结果为:"+login_res_str);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return token;
    }

    public static String getBrData(String jsonStr){
        String res="";
        try {
            res = ms.getApiData(jsonStr,apiCode);
            if(StringUtils.isNotBlank(res)){
                JSONObject json = JSONObject.fromObject(res);
                if(json.containsKey("code")&&json.getString("code").equals("100007")){
                    tokenId = null;
                    JSONObject jsonData = JSONObject.fromObject(jsonStr);
                    jsonData.put("tokenid", Test2.getTokenId());
                    res = ms.getApiData(jsonData.toString(),apiCode);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }
}