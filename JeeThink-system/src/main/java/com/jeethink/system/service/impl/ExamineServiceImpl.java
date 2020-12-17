package com.jeethink.system.service.impl;

import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.utils.uuid.IdUtils;
import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.OkVo;
import com.jeethink.system.domain.vo.Pub;
import com.jeethink.system.domain.vo.oKreq;
import com.jeethink.system.mapper.ExamineMapper;
import com.jeethink.system.service.IExamineService;
import com.jeethink.system.util.HttpPostUtil;
import com.rsa.RSASignature;
import com.rsa.RSAUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import  com.jeethink.system.util.orderCode;

@Service
public class ExamineServiceImpl implements IExamineService {
    @Autowired
    private ExamineMapper examineDao;


    @Override
    public int addByBorrower(ZyjrBorrower q) {
        if(findByBorrower(q.getUserId())!=null&&q.getOrderState()==0){
            int count = examineDao.updateBorrower(q);
            return count;
        } else {
            int count = examineDao.insertBorrower(q);
            return count;

        }
    }

    @Override
    public int addByRelation(ZyjrRelation q) {
        if(findByRelation(q.getUserId())!=null&&q.getOrderState()==0){
            int count = examineDao.updateRelation(q);
            return count;
        } else {
            int count = examineDao.insertRelation(q);
            return count;

        }
    }

    @Override
    public int addByGuarantee(ZyjrGuarantee q) {
        if(findByGuarantee(q.getUserId())!=null&&q.getOrderState()==0){
            int count = examineDao.updateGuarantee(q);
            return count;
        } else {
            int count = examineDao.insertGuarantee(q);
            return count;

        }
    }

    @Override
    public int addByBusiness(ZyjrBusiness q) {
        if(findByBusiness(q.getUserId())!=null&&q.getOrderState()==0){
            int count = examineDao.updateBusiness(q);
            return count;
        } else {
            int count = examineDao.insertBusiness(q);
            return count;

        }
    }



    @Override
    public ZyjrBorrower findByBorrower(Integer userId) {
        ZyjrBorrower borrower = examineDao.findByBorrower(userId);
        return borrower;
    }

    @Override
    public ZyjrRelation findByRelation(Integer userId) {
        ZyjrRelation relation = examineDao.findByRelation(userId);
        return relation;
    }

    @Override
    public ZyjrGuarantee findByGuarantee(Integer userId) {
        ZyjrGuarantee guarantee = examineDao.findByGuarantee(userId);
        return guarantee;
    }

    @Override
    public ZyjrBusiness findByBusiness(Integer userId) {
        ZyjrBusiness business = examineDao.findByBusiness(userId);
        return business;
    }

    @Override
    public Map<String,Object> find(Integer userId){
        Map<String,Object>map = new HashMap<>();
        map.put("business",findByBusiness(userId));
        map.put("borrower",findByBorrower(userId));
        map.put("relation",findByRelation(userId));
        map.put("guarantee",findByGuarantee(userId));
        map.put("start",findByStart(userId));
        return map;
    }



    @Override
    public int addByStart(ZyjrStartPage q) {
        ZyjrStartPage startPage = new ZyjrStartPage();
        startPage.setId(q.getId());
        startPage.setFundSide(q.getFundSide());
        startPage.setBusinessPlace(q.getBusinessPlace());
        startPage.setOrderState(q.getOrderState());
        startPage.setUserId(q.getUserId());

        String a = orderCode.getOrderCode();
        //String b = IdUtils.simpleUUID();

        startPage.setTransactionCode(a);
        //startPage.setPrivateCode(b);
        examineDao.updateOne(q.getUserId(),a);
        examineDao.updateTwo(q.getUserId(),a);
        examineDao.updateThree(q.getUserId(),a);
        examineDao.updateFour(q.getUserId(),a);
        if(findByStart(q.getUserId())!=null&&q.getOrderState()==0){
            int count = examineDao.insertStart(startPage);

            return count;
        } else {
            return 0;
        }
    }

    @Override
    public ZyjrStartPage findByStart(Integer userId) {
        ZyjrStartPage startPage = examineDao.findByStart(userId);
        return startPage;
    }

    @Override
    public String okPurchase(String codes) {
        String dataPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFZnUVz07wuQfI5kf3uOaaJcpq*W3yQhJnIX2k-EKwKZaSkyuXutk0TXqwT-GXxIQJqmkjLup*HN7H1uF7JMfxl00AnncHB82LqUQKQwf5wcdDTNhvKLQtjRoLE3ry6ARoYHu5AkZPKW7sMM4o*UegPlSr45p4ZsK0iVdjqmgZfwIDAQAB";
        String signPrivateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKOoelzwAU5Asw9zknkTYGvfZr0Ap6ZDL6NMSNRYZ2maVJd5xOfSRqTkEq1Ne*h2Qe3wCKdxo0SuCVWNjM-nd3af*fb4YcWdlDuHaA1s28I5hZtVp2sbF*nvgdeUwSz-X0hQGcaqVzcTKDH9l2XuMC**OEofyyosU2jvEIGdwqSNAgMBAAECgYAkojvxvc*tApKSbN5mt82nl-RZbmIYt4VcWmEbF0bevqsc1SccdVdW5a7AmE2aNY6AgnCNesR-RS3Vtr-Ech2tVfwMXypJsXN5hq0uyM6iDkE6kFhGL1zui72u9RQJvdB7CsNfEONIaFlX46MUOdF0fR2n-sGLMc1qzpj*L3k6QQJBAOJfQRF6ehE5d1Sm*7q9uObte1ubako89TSGZmCOk-3vpm9CRTey-18Ids98yMNg3Wy53M4oEzjwjdnnulX9PpUCQQC5E-NySYbigVCsO5Tjr*iAA1ykdGIgaRM45s2tvbMLYQdZYhnkPRjSj*Y7I915cp5klQ75T260InPYQqBkb2gZAkEAjRYtKcWZ*s5EL4B7eCHy8gqlTa0JjAd*FCSH-joexq-snX9CQLrRKtvNoPf28L6YgsE8e0jC4kQbROqGWj2iGQJBAKkXVUCBdL7UrsPs26b6PE1YxPdrbYt29Jz0Ic4ulro6t*AuBMHGIDugRRSbO*mNkrEKjlew-s*M*pIGrUuVjWECQQC3qMemXCmqp7lAaSqYy9Rk8HNVgEeDqJfhcIS4SrRH0DSExPE9yfhadaiC4IIYmmK5L*2V3dxIUI7KXbeO*ptz";
        String bankType = "ICBC";
        Pub pub=new Pub();
        pub.setBankCode("0180400023");
        pub.setAssurerNo("S36029951");
        pub.setPlatNo("zyhzjg");
        pub.setOrderNo(codes);
        pub.setProductType(1);
        pub.setBankType(bankType);
        String assurerNo = "S36029951";
        String platNo = "zyhzjg";
        OkVo ok = new OkVo();
        oKreq okreq = new oKreq();
        okreq.setSignConfirm(1);
        String busiCode = "1008";
        pub.setBusiCode(busiCode);
        ok.setPub(pub);
        ok.setReq(okreq);
        JSONObject json3 = new JSONObject().fromObject(ok);
        JSONObject jsons = encryptData(json3.toString(), dataPublicKey, signPrivateKey, assurerNo, bankType, busiCode, platNo, codes);
        JSONObject results = HttpPostUtil.doPostRequestJSON("http://114.55.55.41:18999/bank/route", jsons);
        if (results.get("code").equals(0)) {
            return "ok";
        }
        return "出现未知错误";
    }
    public static JSONObject encryptData(String data, String dataPublicKey ,String signPrivateKey ,String assurerNo
            , String bankType, String busiCode, String platNo,String orderNo){
        JSONObject request = new JSONObject();
        String encryptData = RSAUtil.encrypt(data, dataPublicKey);
        request.put("data", encryptData);
        String signData = RSASignature.sign(data, signPrivateKey);
        request.put("sign", signData);
        request.put("assurerNo", assurerNo);
        request.put("bankType", bankType);
        request.put("busiCode", busiCode);
        request.put("platNo", platNo);
        request.put("bankCode","0180400023");
        request.put("orderNo",orderNo);
        return request;
    }
}
