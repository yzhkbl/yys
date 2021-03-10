package com.jeethink.system.controller;

import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.utils.DateUtils;
import com.jeethink.system.domain.vo.ChinaPaySelect;
import com.jeethink.system.util.Test2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pay")
public class ChinaPayController {

    @GetMapping("code2")
    @ResponseBody
    public AjaxResult fi2nd(String carNo) {

        String s = DateUtils.dateTimeNow(DateUtils.YYYYMMDDHHMMSS);
        Map<String,Object> map=new HashMap<>();
        map.put("Version",20150922);
        map.put("AccessType",1);
        map.put("InstuId",0);
        map.put("AcqCode",0);
        map.put("MerId",0);
        map.put("BusiType",0001);
        map.put("TranType",0504);
        map.put("OriTranType",9910);
        map.put("CardTranData","{'CarNo':"+carNo+"}");
        map.put("TranReserved",0);
        map.put("TimeStamp",s);
        map.put("RemoteAddr","114.215.186.186");
        map.put("Signature",0);
        return AjaxResult.success();
    }

}
