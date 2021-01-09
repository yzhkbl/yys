package com.jeethink.system.controller;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


import com.jeethink.common.config.JeeThinkConfig;
import com.jeethink.common.core.redis.RedisCache;
import com.jeethink.common.utils.file.FileUploadUtils;
import com.jeethink.common.utils.file.FileUtils;
import com.jeethink.common.utils.http.HttpUtils;
import com.jeethink.common.utils.ip.IpUtils;
import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.*;
import com.jeethink.system.mapper.*;
import com.jeethink.system.service.IExamineService;
import com.jeethink.system.util.*;
import com.rsa.RSASignature;
import com.rsa.RSAUtil;
import net.sf.json.JSONObject;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.jeethink.common.core.controller.BaseController;
import com.jeethink.common.core.domain.AjaxResult;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.w3c.dom.html.HTMLFormElement;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;


@Controller
@RequestMapping("/system/test")
@Api("测试接口")
public class test extends BaseController {

    @Autowired
    private ZyjrRelationMapper r;
    @Autowired
    private ZyjrBusinessMapper b;
    @Autowired
    private ZyjrBorrowerMapper o;
    @Autowired
    private ZyjrGuaranteeMapper g;
    @Autowired
    private IExamineService examineService;
    @Autowired
    private ExamineMapper examineMapper;
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;
    @Autowired
    private RedisCache redisCache;

    private static String oCode = "sfzzm";
    private static String pCode = "sfzfm";
    private static String zCode = "zxsqs";

    @ApiOperation("查询参数列表")
    @PostMapping("code")
    @ResponseBody
    public AjaxResult find(String codes) {
	/*	ZyjrBorrower byBorrower = examineMapper.findByBorrower(userId);
		ZyjrBusiness byBusiness = examineMapper.findByBusiness(userId);
		String codes=byBorrower.getTransactionCode();*/
        if (codes == null) {
            return AjaxResult.error("编号为空");
        }
        selVO a = new selVO();
        /*List<Object> a=new ArrayList<>();*/
        /**
         * 现id写死
         */
        ZyjrBusiness business = b.selectById(codes);
        List<spouse> lists = new ArrayList<>();
        ZyjrRelation relation = r.selectById(codes);
        ZyjrBorrower borrowerById = o.selectById(codes);
        ZyjrGuarantee guarantee = g.selectById(codes);
        /**
         * 现无数据后期该行改为sql查询
         */
        String orderNo = codes;
        Pub pub = new Pub();
        pub.setBankCode("0180400023");
        pub.setAssurerNo("S36029951");
        pub.setPlatNo("zyhzjg");
        pub.setOrderNo(orderNo);
        pub.setProductType(1);
        pub.setBankType("ICBC");
        pub.setBusiCode("1001");
        System.out.println(pub);
        Pics p1 = new Pics();
        List<Pics> pp = new ArrayList<>();
        List<Pics> lenp = new ArrayList<>();
        List<Pics> guaranteep = new ArrayList<>();
        spouse sguarantee = new spouse();
        spouse s = new spouse();
        if (relation != null) {
            p1.setPicId(1);
            p1.setPicCode(oCode);
            p1.setPicAddress(relation.getObverseAddress());
            p1.setPicFileName("1.jpg");
            Pics p2 = new Pics();
            p2.setPicId(1);
            p2.setPicCode(pCode);
            p2.setPicAddress(relation.getBackAddress());
            p2.setPicFileName("2.jpg");
		/*Pics p3=new Pics();
		p3.setPicId(relation.getPowerId());
		p3.setPicCode(zCode);
		p3.setPicAddress("http://192.168.31.82:8080"+relation.getPowerAddress());
		p3.setPicFileName(relation.getPowerName()+".jpg");*/
            s.setIdCard(relation.getIdCard());
            s.setIssueAuthority(relation.getIssueAuthority());
            s.setPhoneNum(relation.getPhoneNumber());
            s.setBankCardNo(relation.getBankCardNo());
            s.setUserName(relation.getUserName());
            String sd = DataUtil.data(relation.getStartDate());
            s.setStartDate(sd);
            s.setIsQueryCredit(0);
            s.setUserRelationship(2);
            s.setCompany(relation.getCompany());
            s.setCompanyAddress(relation.getCompanyAddress());
            s.setYearIncome(relation.getYearIncome());
            String se = DataUtil.data(relation.getEndDate());
            s.setEndDate(se);
            s.setFamilyAddress(relation.getFamilyAddress());
            pp.add(p1);
            pp.add(p2);
            /*pp.add(p3);*/
            s.setPics(pp);
            lists.add(s);
        }
        Pics p4 = new Pics();
        p4.setPicId(1);
        p4.setPicCode(oCode);
        p4.setPicAddress(borrowerById.getObverseAddress());
        p4.setPicFileName("3.jpg");
        Pics p5 = new Pics();
        p5.setPicId(1);
        p5.setPicCode(pCode);
        p5.setPicAddress(borrowerById.getBackAddress());
        p5.setPicFileName("4.jpg");
        if (borrowerById.getCreditPower() > 0) {
            Pics p6 = new Pics();
            p6.setPicId(1);
            p6.setPicCode(zCode);
            p6.setPicAddress(borrowerById.getPowerAddress());
            p6.setPicFileName("5.jpg");
            lenp.add(p6);
        }
	/*	Pics p6=new Pics();
		p6.setPicId(borrowerById.getPowerId());
		p6.setPicCode(zCode);
		p6.setPicAddress("http://192.168.31.82:8080"+borrowerById.getPowerAddress());
		p6.setPicFileName(borrowerById.getPowerName()+".jpg");*/
        lenp.add(p4);
        lenp.add(p5);


        if (guarantee != null) {
            Pics p7 = new Pics();
            p7.setPicId(1);
            p7.setPicCode(oCode);
            p7.setPicAddress(guarantee.getPowerAddress());
            p7.setPicFileName("5.jpg");
            Pics p8 = new Pics();
            p8.setPicId(1);
            p8.setPicCode(pCode);
            p8.setPicAddress(guarantee.getPowerAddress());
            p8.setPicFileName("6.jpg");
		/*	Pics p9=new Pics();
			p9.setPicId(guarantee.getPowerId());
			p9.setPicCode(zCode);
			p9.setPicAddress("http://192.168.31.82:8080"+guarantee.getPowerAddress());
			p9.setPicFileName(guarantee.getPowerName()+".jpg");*/
            sguarantee.setIdCard(guarantee.getIdCard());
            sguarantee.setIssueAuthority(guarantee.getIssueAuthority());
            sguarantee.setPhoneNum(guarantee.getPhoneNumber());
            sguarantee.setBankCardNo(guarantee.getBankCardNo());
            sguarantee.setUserName(guarantee.getUserName());
            String gsd = DataUtil.data(guarantee.getStartDate());
            sguarantee.setStartDate(gsd);
            sguarantee.setIsQueryCredit(0);
            sguarantee.setUserRelationship(2);
            sguarantee.setCompany(guarantee.getCompany());
            sguarantee.setCompanyAddress(guarantee.getCompanyAddress());
            sguarantee.setYearIncome(guarantee.getYearIncome());
            String gse = DataUtil.data(guarantee.getEndDate());
            sguarantee.setEndDate(gse);
            sguarantee.setFamilyAddress(guarantee.getFamilyAddress());
            guaranteep.add(p7);
            guaranteep.add(p8);
            /*	guaranteep.add(p9);*/
            sguarantee.setPics(guaranteep);
            lists.add(sguarantee);
        }


        lender len = new lender();
        req re = new req();
        len.setIdCard(borrowerById.getIdCard());//relation.getIdCard()
        len.setBankCardNo(borrowerById.getBankCardNo());
        len.setSignMode(borrowerById.getCreditPower() + 1);
        len.setIssueAuthority(borrowerById.getIssueAuthority());
        len.setPhoneNum(borrowerById.getPhoneNumber());//relation.getPhoneNumber()
        len.setUserName(borrowerById.getUserName());//relation.getUserName()
        String lsd = DataUtil.data(borrowerById.getStartDate());
        len.setStartDate(lsd);
        String lse = DataUtil.data(borrowerById.getEndDate());
        len.setEndDate(lse);
        len.setFamilyAddress(borrowerById.getFamilyAddress());
	/*	len.setLoanMoney(borrowerById.getLoanMoney());
		len.setRepayPeriod(borrowerById.getRepayPeriod());*/
        len.setPics(lenp);
        /**
         * lender中缺少签约方式
         */
        re.setLender(len);
        re.setCarType(business.getCarType());
        re.setIntentionPrice(business.getIntentionPrice());
        re.setDownloadMode(1);
        re.setSpouse(lists);
        re.setBusinessModel(7);
        a.setPub(pub);
        a.setReq(re);


        String dataPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFZnUVz07wuQfI5kf3uOaaJcpq*W3yQhJnIX2k-EKwKZaSkyuXutk0TXqwT-GXxIQJqmkjLup*HN7H1uF7JMfxl00AnncHB82LqUQKQwf5wcdDTNhvKLQtjRoLE3ry6ARoYHu5AkZPKW7sMM4o*UegPlSr45p4ZsK0iVdjqmgZfwIDAQAB";
        String signPrivateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKOoelzwAU5Asw9zknkTYGvfZr0Ap6ZDL6NMSNRYZ2maVJd5xOfSRqTkEq1Ne*h2Qe3wCKdxo0SuCVWNjM-nd3af*fb4YcWdlDuHaA1s28I5hZtVp2sbF*nvgdeUwSz-X0hQGcaqVzcTKDH9l2XuMC**OEofyyosU2jvEIGdwqSNAgMBAAECgYAkojvxvc*tApKSbN5mt82nl-RZbmIYt4VcWmEbF0bevqsc1SccdVdW5a7AmE2aNY6AgnCNesR-RS3Vtr-Ech2tVfwMXypJsXN5hq0uyM6iDkE6kFhGL1zui72u9RQJvdB7CsNfEONIaFlX46MUOdF0fR2n-sGLMc1qzpj*L3k6QQJBAOJfQRF6ehE5d1Sm*7q9uObte1ubako89TSGZmCOk-3vpm9CRTey-18Ids98yMNg3Wy53M4oEzjwjdnnulX9PpUCQQC5E-NySYbigVCsO5Tjr*iAA1ykdGIgaRM45s2tvbMLYQdZYhnkPRjSj*Y7I915cp5klQ75T260InPYQqBkb2gZAkEAjRYtKcWZ*s5EL4B7eCHy8gqlTa0JjAd*FCSH-joexq-snX9CQLrRKtvNoPf28L6YgsE8e0jC4kQbROqGWj2iGQJBAKkXVUCBdL7UrsPs26b6PE1YxPdrbYt29Jz0Ic4ulro6t*AuBMHGIDugRRSbO*mNkrEKjlew-s*M*pIGrUuVjWECQQC3qMemXCmqp7lAaSqYy9Rk8HNVgEeDqJfhcIS4SrRH0DSExPE9yfhadaiC4IIYmmK5L*2V3dxIUI7KXbeO*ptz";
//		String assurerNo = "ceshi001";
//		String bankType = "ICBC";
//		String busiCode = "0001";
//		String platNo = "zajk";
        String assurerNo = "S36029951";
        String bankType = "ICBC";
        String busiCode = "1001";
        String platNo = "zyhzjg";


        AjaxResult c = AjaxResult.success(a);
        JSONObject json2 = new JSONObject().fromObject(a);
        AjaxResult as = AjaxResult.success(a.toString());

        JSONObject json = encryptData(json2.toString(), dataPublicKey, signPrivateKey, assurerNo, bankType, busiCode, platNo, orderNo);

        JSONObject result = HttpPostUtil.doPostRequestJSON("http://114.55.55.41:18999/bank/route", json);

        if (result.get("code").equals(0)) {

            borrowerById.setTransactionCode(codes);
            borrowerById.setPrivateCode(result.getJSONObject("data").get("estageOrderNo").toString());
            int ceshi = o.updateZyjrBorrower(borrowerById);
            if (ceshi > 0) {
                return AjaxResult.success();
            }
        }
        return AjaxResult.error("错误", result);
    }


    @ApiOperation("发起确认")
    @PostMapping("ok")
    @ResponseBody
    public AjaxResult find2(String codes) {

        String a = examineService.okPurchase(codes);


        return AjaxResult.success(a);
    }

    @ApiOperation("查询状态")
    @GetMapping("selectState")
    @ResponseBody
    public AjaxResult find3(String codes) {

        ZyjrStartPage zyjrStartPage=examineMapper.findByStarts(codes);

        if(zyjrStartPage!=null&&zyjrStartPage.getCreditState()!=null&&zyjrStartPage.getCreditState().equals("1")){
            return AjaxResult.success((Object)4);
        }

        System.err.println(codes);
        String dataPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFZnUVz07wuQfI5kf3uOaaJcpq*W3yQhJnIX2k-EKwKZaSkyuXutk0TXqwT-GXxIQJqmkjLup*HN7H1uF7JMfxl00AnncHB82LqUQKQwf5wcdDTNhvKLQtjRoLE3ry6ARoYHu5AkZPKW7sMM4o*UegPlSr45p4ZsK0iVdjqmgZfwIDAQAB";
        String signPrivateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKOoelzwAU5Asw9zknkTYGvfZr0Ap6ZDL6NMSNRYZ2maVJd5xOfSRqTkEq1Ne*h2Qe3wCKdxo0SuCVWNjM-nd3af*fb4YcWdlDuHaA1s28I5hZtVp2sbF*nvgdeUwSz-X0hQGcaqVzcTKDH9l2XuMC**OEofyyosU2jvEIGdwqSNAgMBAAECgYAkojvxvc*tApKSbN5mt82nl-RZbmIYt4VcWmEbF0bevqsc1SccdVdW5a7AmE2aNY6AgnCNesR-RS3Vtr-Ech2tVfwMXypJsXN5hq0uyM6iDkE6kFhGL1zui72u9RQJvdB7CsNfEONIaFlX46MUOdF0fR2n-sGLMc1qzpj*L3k6QQJBAOJfQRF6ehE5d1Sm*7q9uObte1ubako89TSGZmCOk-3vpm9CRTey-18Ids98yMNg3Wy53M4oEzjwjdnnulX9PpUCQQC5E-NySYbigVCsO5Tjr*iAA1ykdGIgaRM45s2tvbMLYQdZYhnkPRjSj*Y7I915cp5klQ75T260InPYQqBkb2gZAkEAjRYtKcWZ*s5EL4B7eCHy8gqlTa0JjAd*FCSH-joexq-snX9CQLrRKtvNoPf28L6YgsE8e0jC4kQbROqGWj2iGQJBAKkXVUCBdL7UrsPs26b6PE1YxPdrbYt29Jz0Ic4ulro6t*AuBMHGIDugRRSbO*mNkrEKjlew-s*M*pIGrUuVjWECQQC3qMemXCmqp7lAaSqYy9Rk8HNVgEeDqJfhcIS4SrRH0DSExPE9yfhadaiC4IIYmmK5L*2V3dxIUI7KXbeO*ptz";
        String assurerNo = "S36029951";
        String bankType = "ICBC";
        String busiCode = "1013";
        String platNo = "zyhzjg";
        Pub pub = new Pub();
        pub.setBankCode("0180400023");
        pub.setAssurerNo("S36029951");
        pub.setPlatNo("zyhzjg");
        pub.setOrderNo(codes);
        pub.setProductType(1);
        pub.setBankType(bankType);
        pub.setBusiCode("1013");
        ceshi ceshis=new ceshi();
        ceshis.setPub(pub);
        JSONObject json3 = new JSONObject().fromObject(ceshis);

        JSONObject jsons = encryptData(json3.toString(), dataPublicKey, signPrivateKey, assurerNo, bankType, busiCode, platNo, codes);

        JSONObject results = HttpPostUtil.doPostRequestJSON("http://114.55.55.41:18999/bank/route", jsons);


        if (results.get("code").equals(0)) {

            if (results.getJSONObject("data").getJSONObject("requestJson").getJSONObject("req").get("transType").equals(4)) {

                int ceshi=examineMapper.updateStarts(codes);

                if(ceshi>0){
                    return AjaxResult.success((Object)4);

                }
            }
            return AjaxResult.success(results.getJSONObject("data").getJSONObject("requestJson").getJSONObject("req").get("transType"));


        }
        return null;
    }


    public static JSONObject encryptData(String data, String dataPublicKey, String signPrivateKey, String assurerNo
            , String bankType, String busiCode, String platNo, String orderNo) {
        JSONObject request = new JSONObject();
        String encryptData = RSAUtil.encrypt(data, dataPublicKey);
        request.put("data", encryptData);
        String signData = RSASignature.sign(data, signPrivateKey);
        request.put("sign", signData);
        request.put("assurerNo", assurerNo);
        request.put("bankType", bankType);
        request.put("busiCode", busiCode);
        request.put("platNo", platNo);
        request.put("bankCode", "0180400023");
        request.put("orderNo", orderNo);
        return request;
    }


    /**
     * test 测试接口，测试是否能接到图片集合
     *
     * @return
     */


    @PostMapping("/ceshi")
    @ResponseBody
    @ApiOperation("111111111")
    public AjaxResult testFiles(String file) {
        String a = androidUpload.upload(file);
        String as = "http://192.168.31.86:8080" + a;
        System.err.println(as);
        return AjaxResult.success("操作成功",as);
        //return AjaxResult.success("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3363295869,2467511306&fm=26&gp=0.jpg");
    }

    @RequestMapping(value = {"/ceshi2"}, method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("111111111")
    public AjaxResult ceshi(@RequestParam("name") List<String> name, @RequestParam("file") List<MultipartFile> file, @RequestParam("id") List<String> id) throws IOException {
        for (int i = 0; i < id.size(); i++) {
            String a = FileUploadUtils.upload(file.get(i));
            SysFileInfo info = new SysFileInfo();
            String as = "http://"+IpUtils.getHostIp() +":8080"+ a;
            info.setFilePath(as);
            info.setId(id.get(i));
            info.setFileName(name.get(i));
            sysFileInfoMapper.insertSysFileInfo(info);
        }

        return AjaxResult.success();
    }

    @RequestMapping(value = {"/ceshi3"}, method = RequestMethod.GET)
    @ApiOperation("111111111")
    public String ceshi3(String transactionCode) {
        ZyjrBorrower a = o.selectById(transactionCode);
        a.setContractState("1");
         o.updateZyjrBorrower(a);
         examineService.okPurchase(transactionCode);
        return "index";
    }

    @RequestMapping(value = {"/ceshi4"}, method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("111111111")
    public AjaxResult ceshi4(String id) {
        ZyjrBorrower a = new ZyjrBorrower();
        a.setContractState("1");
        a.setTransactionCode(null);
        o.updateZyjrBorrower(a);
        return AjaxResult.success();
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("111111111")
    public AjaxResult delete(String path) {
        String paths = "C:/demo";
        System.err.println(path);

        int a = sysFileInfoMapper.deleteSysFileInfoByPath(path);
        if (a > 0) {
            path=path.substring(36,path.length());


            boolean b = FileUtils.deleteFile(paths + "/20" + path);
            if (b) {
                return AjaxResult.success(b);
            } else {
                return AjaxResult.error("路径删除成功，但图片删除失败", b);
            }
        }

        System.err.println(a);
        return AjaxResult.success(a);
    }

    @RequestMapping(value = {"/getByToken"}, method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("getByToken")
    public AjaxResult ceshi5() {
        String aa=redisCache.getCacheObject("getByToken");
        if(aa!=null){
            return AjaxResult.success(aa);
        }
        String a = HttpUtils.sendPost("https://apiservice.100credit.com/api/auth-service/auth/getToken", "username=zyrzWEB&password=zyrzWEB123");
        String [] c=a.split("\"");
        redisCache.setCacheObject("getByToken",c[7],29, TimeUnit.MINUTES);
        return AjaxResult.success(c[7]);
    }

    @RequestMapping(value = {"/getByMelting"}, method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("getByMelting")
    public AjaxResult ceshi6(String id) {
        if(id==null){
            AjaxResult.error("没接收到参数");
        }
       ZyjrBorrower borrower=o.selectById(id);
        if(borrower.getConf()!=null){
            return AjaxResult.success(borrower.getEncryptData(),borrower.getConf());
        }
        String aa=redisCache.getCacheObject("getByMelting");
        if(aa!=null){
           String c= Test2.conf(aa,borrower.getIdCard(),borrower.getPhoneNumber(),borrower.getUserName());
           String d=Test.getStrategy(aa,borrower.getIdCard(),borrower.getPhoneNumber(),borrower.getUserName());
            borrower.setConf(c);
            borrower.setEncryptData(d);
            o.updateZyjrBorrower(borrower);
            return AjaxResult.success(d,c);
        }else{
            String t=Test.getTokenId();
            redisCache.setCacheObject("getByMelting",t,59, TimeUnit.MINUTES);
            String c=Test2.conf(t,borrower.getIdCard(),borrower.getPhoneNumber(),borrower.getUserName());
            String d=Test.getStrategy(t,borrower.getIdCard(),borrower.getPhoneNumber(),borrower.getUserName());
            borrower.setConf(c);
            borrower.setEncryptData(d);
            o.updateZyjrBorrower(borrower);
            return AjaxResult.success(d,c);
        }
    }



    @ResponseBody
    @GetMapping("jinzhengu")
    public AjaxResult wc(){
        SysFileInfo sysFileInfo=new SysFileInfo();
        sysFileInfo.setBankId("99");
        List<SysFileInfo> a=sysFileInfoMapper.selectSysFileInfoList(sysFileInfo);
        Map<String,String> map=new HashMap<>();
        for (SysFileInfo fileInfo : a) {
            map.put(fileInfo.getFileName(),fileInfo.getFilePath());
        }
        return AjaxResult.success(map);
    }
    @PreAuthorize("@ss.hasPermi('dzj')")
    @ResponseBody
    @GetMapping("kaika")
    public AjaxResult kaika(String transactionCode){
            ZyjrCard z=b.selKaika(transactionCode);
        return AjaxResult.success("666");
    }


}
