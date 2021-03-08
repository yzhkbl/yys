package com.jeethink.system.controller;


import com.jeethink.system.domain.ZyjrBorrower;
import com.jeethink.system.mapper.ZyjrBorrowerMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sign.common.http.HttpPostUtil;
import sign.common.login.EscapeLogin;
import sign.common.param.ApiResponse;
import sign.common.param.ResponseInfo;
import sign.common.rsa.RSASignature;
import sign.common.rsa.RSAUtil;
import sign.common.rsa.RSAkeyConstant;
import sign.common.util.StringUtil;

import javax.servlet.http.HttpServletRequest;

import java.io.*;

@Controller
public class test2 {
    @Autowired
    private ZyjrBorrowerMapper zyjrBorrowerMapper;

    @RequestMapping("/pullSignReport")
    @ResponseBody
    @EscapeLogin
    public ApiResponse pullSignReport(HttpServletRequest request) throws IOException{
        String requestData = HttpPostUtil.getRequestData(request);

        JSONObject requestJSON = JSONObject.fromObject(requestData);

        //获取密文

        String encrypt = requestJSON.getString("data");

        //2、解密

        String dataStr = RSAUtil.decrypt(encrypt, RSAkeyConstant.DATA_PRIVATE_KEY);

        if(StringUtil.isNotEmpty(dataStr)){

            //3、验证签名

            String sign = requestJSON.getString("sign");//签名

            boolean b = RSASignature.doCheck(dataStr, sign, RSAkeyConstant.SIGN_PUBLIC_KEY);

            if(!b){

                //
                return new ApiResponse(ResponseInfo.SIGN_NOT_MATCH);

            }else{

                //成功逻辑
                JSONObject	date= JSONObject.fromObject(dataStr);
                JSONObject pub = JSONObject.fromObject(date.get("pub"));
                JSONObject req = JSONObject.fromObject(date.get("req"));
                System.out.println(pub.toString()+">>>>>>>"+req.toString());
                ZyjrBorrower zyjrBorrower = zyjrBorrowerMapper.selectById(pub.get("orderNo").toString());
                if(req.get("status")!=null&&req.get("status").equals("2")){
                    zyjrBorrower.setMianqian("1");
                    zyjrBorrowerMapper.updateZyjrBorrower(zyjrBorrower);
                }else if(req.get("status")!=null&&req.get("status").equals("3")){
                    zyjrBorrower.setMianqian("2");
                    zyjrBorrowerMapper.updateZyjrBorrower(zyjrBorrower);
                }

            }

        }else{

            return new ApiResponse(ResponseInfo.INVALID_PARAM);

        }

        return ApiResponse.SUCCESS;

    }

}