package com.jeethink.system.controller;

import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.utils.DateUtils;
import com.jeethink.system.domain.vo.ChinaPaySelect;
import com.jeethink.system.util.HttpClientUtil;
import com.jeethink.system.util.HttpPostUtil;
import com.jeethink.system.util.SignUtil;
import com.jeethink.system.util.Test2;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.chinapay.secss.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Controller
@RequestMapping("/pay")
public class ChinaPayController {

    @GetMapping("code")
    @ResponseBody
    public AjaxResult pay1() {
        String carNo="6217858000074521656";
        String s = DateUtils.dateTimeNow(DateUtils.YYYYMMDDHHMMSS);
        Map<String,Object> map=new HashMap<>();
        map.put("Version",20150922);
        map.put("AccessType",0);
        long a=92103101967L;
        map.put("MerId",a);
        map.put("BusiType",0001);
        map.put("TranType",0504);
        map.put("MerOrderNo",carNo);
        map.put("OriTranType",9910);
        String ss=SignUtil.decryptData("{'CarNo':"+carNo+"}");
        System.err.println(ss);
        map.put("CardTranData",ss);
        map.put("TranReserved",0);
        map.put("TimeStamp",s);
        map.put("RemoteAddr","114.215.186.186");
        String aa=SignUtil.sign(map);
        System.err.println(aa);
        map.put("Signature",aa);
        JSONObject json = new JSONObject().fromObject(map);
        JSONObject result = HttpPostUtil.doPostRequestJSON("https://newpayment-test.chinapay.com/CTITS/service/rest/forward/syn/000000000017/0/0/0/0/0", json);
        return AjaxResult.success(result);
    }

    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("1","1");
        SecssUtil secssUtil=new SecssUtil();
        secssUtil.sign(map);
        System.err.println(secssUtil.getSign());
    }

    @GetMapping("code2")
    @ResponseBody
    public AjaxResult fi2nd(String carNo) {

        String s = DateUtils.dateTimeNow(DateUtils.YYYYMMDDHHMMSS);
        Map<String,Object> map=new HashMap<>();
        map.put("Version",20150922);
        map.put("AccessType",0);
        long a=92103101967L;
        map.put("MerId",a);
        map.put("MerOrderNo",carNo);
        map.put("TranDate",Integer.parseInt(s.substring(0,8)));
        map.put("TranTime",Integer.parseInt(s.substring(8,s.length())));
        map.put("OrderAmt",Integer.parseInt(s.substring(8,s.length())));
        map.put("TranType",0101);
        map.put("BusiType",0001);
        map.put("OriTranType",9910);
        map.put("CardTranData","{'CarNo':"+carNo+"}");
        map.put("TranReserved",0);
        map.put("TimeStamp",s);
        map.put("RemoteAddr","114.215.186.186");
        map.put("Signature",0);
        return AjaxResult.success();
    }

}
