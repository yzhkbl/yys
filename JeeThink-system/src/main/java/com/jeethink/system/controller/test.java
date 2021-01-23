package com.jeethink.system.controller;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


import com.alibaba.fastjson.JSON;
import com.jeethink.common.config.JeeThinkConfig;
import com.jeethink.common.core.domain.entity.SysUser;
import com.jeethink.common.core.redis.RedisCache;
import com.jeethink.common.utils.DateUtils;
import com.jeethink.common.utils.SecurityUtils;
import com.jeethink.common.utils.file.FileUploadUtils;
import com.jeethink.common.utils.file.FileUtils;
import com.jeethink.common.utils.http.HttpUtils;
import com.jeethink.common.utils.ip.IpUtils;
import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.*;
import com.jeethink.system.mapper.*;
import com.jeethink.system.service.IExamineService;
import com.jeethink.system.service.ISysUserService;
import com.jeethink.system.util.*;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.LinkedMap;

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
    @Autowired
    private ZyjrAllowApplicantMapper zyjrAllowApplicantMapper;
    @Autowired
    private ZyjrAllowContactsMapper zyjrAllowContactsMapper;
    @Autowired
    private ZyjrKaikaMapper zyjrKaikaMapper;
    @Autowired
    private ISysUserService userService;

    private static String oCode = "sfzzm";
    private static String pCode = "sfzfm";
    private static String zCode = "zxsqs";

    @GetMapping("code2")
    @ResponseBody
    public AjaxResult fi2nd() {
        Test2.ceshis();
    return AjaxResult.success();
    }

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
        ZyjrRelation relation2 =new ZyjrRelation();
        relation2.setTransactionCode(codes);
        List<ZyjrRelation> relation=r.selectZyjrRelationList(relation2);

        ZyjrBorrower borrowerById = o.selectById(codes);
        ZyjrGuarantee guarantee2 = new ZyjrGuarantee();
        List<ZyjrGuarantee> guarantee=g.selectZyjrGuaranteeList(guarantee2);
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
      //  Pics p1 = new Pics();
        //List<Pics> pp = new ArrayList<>();
        List<Pics> lenp = new ArrayList<>();
        List<Pics> guaranteep = new ArrayList<>();


        if (relation.size()>0) {
            for (ZyjrRelation zyjrRelation : relation) {
                spouse s = new spouse();
                s.setIdCard(zyjrRelation.getIdCard());
                s.setIssueAuthority(zyjrRelation.getIssueAuthority());
                s.setPhoneNum(zyjrRelation.getPhoneNumber());
                s.setBankCardNo(zyjrRelation.getBankCardNo());
                s.setUserName(zyjrRelation.getUserName());
                String sd = DataUtil.data(zyjrRelation.getStartDate());
                s.setStartDate(sd);
                s.setIsQueryCredit(0);
                s.setUserRelationship(2);
                s.setCompany(zyjrRelation.getCompany());
                s.setCompanyAddress(zyjrRelation.getCompanyAddress());
                s.setYearIncome(zyjrRelation.getYearIncome());
                String se = DataUtil.data(zyjrRelation.getEndDate());
                s.setEndDate(se);
                s.setFamilyAddress(zyjrRelation.getFamilyAddress());
                List<Pics> picsList=new ArrayList<>();
                Pics pics1=new Pics();
                pics1.setPicId(1);
                pics1.setPicCode(oCode);
                pics1.setPicAddress(zyjrRelation.getObverseAddress());
                pics1.setPicFileName("3.jpg");
                Pics pics2=new Pics();
                pics2.setPicId(1);
                pics2.setPicCode(pCode);
                pics2.setPicAddress(zyjrRelation.getBackAddress());
                pics2.setPicFileName("4.jpg");
                if (borrowerById.getCreditPower() > 0) {
                    Pics pics3=new Pics();
                    pics3.setPicId(1);
                    pics3.setPicCode(zCode);
                    pics3.setPicAddress(zyjrRelation.getPowerAddress());
                    pics3.setPicFileName("5.jpg");
                    picsList.add(pics3);
                }
                picsList.add(pics1);
                picsList.add(pics2);
                s.setPics(picsList);
                lists.add(s);
            }

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


        if (guarantee .size()>0) {


            for (ZyjrGuarantee zyjrGuarantee : guarantee) {
                spouse g = new spouse();
                g.setIdCard(zyjrGuarantee.getIdCard());
                g.setIssueAuthority(zyjrGuarantee.getIssueAuthority());
                g.setPhoneNum(zyjrGuarantee.getPhoneNumber());
                g.setBankCardNo(zyjrGuarantee.getBankCardNo());
                g.setUserName(zyjrGuarantee.getUserName());
                String gsd = DataUtil.data(zyjrGuarantee.getStartDate());
                g.setStartDate(gsd);
                g.setIsQueryCredit(0);
                g.setUserRelationship(2);
                g.setCompany(zyjrGuarantee.getCompany());
                g.setCompanyAddress(zyjrGuarantee.getCompanyAddress());
                g.setYearIncome(zyjrGuarantee.getYearIncome());
                String gse = DataUtil.data(zyjrGuarantee.getEndDate());
                g.setEndDate(gse);
                g.setFamilyAddress(zyjrGuarantee.getFamilyAddress());
                Pics p7 = new Pics();
                p7.setPicId(1);
                p7.setPicCode(oCode);
                p7.setPicAddress(zyjrGuarantee.getObverseAddress());
                p7.setPicFileName("5.jpg");
                Pics p8 = new Pics();
                p8.setPicId(1);
                p8.setPicCode(pCode);
                p8.setPicAddress(zyjrGuarantee.getBackAddress());
                p8.setPicFileName("6.jpg");
                List<Pics> picsList=new ArrayList<>();
                picsList.add(p7);
                picsList.add(p8);
                if (borrowerById.getCreditPower() > 0) {
                    Pics pics3=new Pics();
                    pics3.setPicId(1);
                    pics3.setPicCode(zCode);
                    pics3.setPicAddress(zyjrGuarantee.getPowerAddress());
                    pics3.setPicFileName("5.jpg");
                    picsList.add(pics3);
                }
                /*	guaranteep.add(p9);*/
                g.setPics(guaranteep);
                lists.add(g);
            }

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
    @ResponseBody
    @PostMapping("php")
    public AjaxResult ss(@RequestBody PhpVo phpVo){
        String dataPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFZnUVz07wuQfI5kf3uOaaJcpq*W3yQhJnIX2k-EKwKZaSkyuXutk0TXqwT-GXxIQJqmkjLup*HN7H1uF7JMfxl00AnncHB82LqUQKQwf5wcdDTNhvKLQtjRoLE3ry6ARoYHu5AkZPKW7sMM4o*UegPlSr45p4ZsK0iVdjqmgZfwIDAQAB";
        String signPrivateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKOoelzwAU5Asw9zknkTYGvfZr0Ap6ZDL6NMSNRYZ2maVJd5xOfSRqTkEq1Ne*h2Qe3wCKdxo0SuCVWNjM-nd3af*fb4YcWdlDuHaA1s28I5hZtVp2sbF*nvgdeUwSz-X0hQGcaqVzcTKDH9l2XuMC**OEofyyosU2jvEIGdwqSNAgMBAAECgYAkojvxvc*tApKSbN5mt82nl-RZbmIYt4VcWmEbF0bevqsc1SccdVdW5a7AmE2aNY6AgnCNesR-RS3Vtr-Ech2tVfwMXypJsXN5hq0uyM6iDkE6kFhGL1zui72u9RQJvdB7CsNfEONIaFlX46MUOdF0fR2n-sGLMc1qzpj*L3k6QQJBAOJfQRF6ehE5d1Sm*7q9uObte1ubako89TSGZmCOk-3vpm9CRTey-18Ids98yMNg3Wy53M4oEzjwjdnnulX9PpUCQQC5E-NySYbigVCsO5Tjr*iAA1ykdGIgaRM45s2tvbMLYQdZYhnkPRjSj*Y7I915cp5klQ75T260InPYQqBkb2gZAkEAjRYtKcWZ*s5EL4B7eCHy8gqlTa0JjAd*FCSH-joexq-snX9CQLrRKtvNoPf28L6YgsE8e0jC4kQbROqGWj2iGQJBAKkXVUCBdL7UrsPs26b6PE1YxPdrbYt29Jz0Ic4ulro6t*AuBMHGIDugRRSbO*mNkrEKjlew-s*M*pIGrUuVjWECQQC3qMemXCmqp7lAaSqYy9Rk8HNVgEeDqJfhcIS4SrRH0DSExPE9yfhadaiC4IIYmmK5L*2V3dxIUI7KXbeO*ptz";
//		String assurerNo = "ceshi001";
//		String bankType = "ICBC";
//		String busiCode = "0001";
//		String platNo = "zajk";
        String assurerNo = "S36029951";
        String bankType = "ICBC";
        String busiCode = phpVo.getBusiCode();
        String platNo = "zyhzjg";
        JSONObject jsons = encryptData(phpVo.getJson(), dataPublicKey, signPrivateKey, assurerNo, bankType, busiCode, platNo, phpVo.getOrder());
        return  AjaxResult.success(jsons);
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

            if (results!=null&&results.getJSONObject("data")!=null&&results.getJSONObject("data").getJSONObject("requestJson")!=null&&results.getJSONObject("data").getJSONObject("requestJson").getJSONObject("req").get("transType").equals(4)) {

                int ceshi=examineMapper.updateStarts(codes);

                if(ceshi>0){
                    return AjaxResult.success((Object)4);

                }
            }
            return AjaxResult.success(results);


        }
        return AjaxResult.success("操作成功",results);
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
        String as = "http://114.215.186.186:8080" + a;
        return AjaxResult.success("操作成功",as);
        //return AjaxResult.success("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3363295869,2467511306&fm=26&gp=0.jpg");
    }

    @RequestMapping(value = {"/ceshi2"}, method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("111111111")
    public AjaxResult ceshi(@RequestParam("name") List<String> name, @RequestParam("file") List<MultipartFile> file, @RequestParam("id") List<String> id) throws IOException {
        System.err.println(name);
        for (int i = 0; i < id.size(); i++) {
            String a = FileUploadUtils.upload(file.get(i));
            SysFileInfo info = new SysFileInfo();
            String as = "http://114.215.186.186:8080"+ a;
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

    @ResponseBody
    @GetMapping("occptn")
    public AjaxResult zwc(){
        SysFileInfo sysFileInfo=new SysFileInfo();
        sysFileInfo.setBankId("99999999");
        List<SysFileInfo> a=sysFileInfoMapper.selectSysFileInfoList(sysFileInfo);
        List<OccptnVo>  list=new ArrayList<>();
        String str= a.get(0).getFilePath();
        HashMap hashMap = JSON.parseObject(str, HashMap.class);
        hashMap.forEach((k, v) ->{
            OccptnVo o=new OccptnVo();
            o.setId(v);
            o.setOccptn(k);
            list.add(o);
        } );
        return AjaxResult.success("操作成功",list);
    }
    @ResponseBody
    @GetMapping("kaika")
    public AjaxResult kaika(String transactionCode){
       ZyjrKaika kaika= zyjrKaikaMapper.selectZyjrKaikaById(transactionCode);
       if(kaika!=null&&kaika.getCount()!=null){
           return AjaxResult.success("操作成功",kaika.getCount());
       }
            ZyjrBusiness business=b.selectById(transactionCode);
            ZyjrBorrower borrower = o.selectById(transactionCode);
            ZyjrAllowApplicant applicant=zyjrAllowApplicantMapper.selectById(transactionCode);
            ZyjrAllowContacts contacts=zyjrAllowContactsMapper.selectById(transactionCode);
            ZyjrCard zyjrCard=new ZyjrCard();
            zyjrCard.setCustsort(0);
            zyjrCard.setCustcode(borrower.getIdCard());
            zyjrCard.setChnsname(borrower.getUserName());
            String name="";
            if(borrower!=null&&borrower.getUserName()!=null){
               name=Chinese2Pinyin.getPinyin(borrower.getUserName());
               name=name.substring(0,name.length()-1);
            }
            zyjrCard.setEngname(name);
            Integer sex=null;
            if(borrower!=null&&borrower.getIdCard()!=null){
                if (Integer.parseInt(borrower.getIdCard().substring(16).substring(0, 1)) % 2 == 0) {// 判断性别
                    sex=2;
                } else {
                    sex =1;
                }
            }
            zyjrCard.setSex(sex);
        Integer mrtlstat=null;
            if(applicant!=null&&applicant.getMarriage()!=null){
              //String  mrtlstats=applicant.getEducation().substring(0,2);
                if("未婚".equals(applicant.getMarriage())){
                    mrtlstat=1;
                }else if("已婚".equals(applicant.getMarriage())){
                    mrtlstat=2;
                }else if("离异".equals(applicant.getMarriage())){
                    mrtlstat=4;
                }else if("丧偶".equals(applicant.getMarriage())){
                    mrtlstat=5;
                }
            }
            zyjrCard.setMrtlstat(mrtlstat);
            Integer edulvl=null;
            if(applicant!=null&&applicant.getEducation()!=null){
                String  Education=applicant.getEducation().substring(0,2);
                if("初中".equals(Education)){
                    edulvl=8;
                }else if("高中".equals(Education)){
                    edulvl=7;
                }else if("大专".equals(Education)){
                    edulvl=4;
                }else if("本科".equals(Education)){
                    edulvl=3;
                }else if("硕士".equals(Education)){
                    edulvl=2;
                }else if("博士".equals(Education)){
                    edulvl=1;
                }
            }
            zyjrCard.setEdulvl(edulvl);
            zyjrCard.setDrawmode(3);
            Integer homestat=null;
            if(applicant!=null&&applicant.getHousePower()!=null){
                    if("贷款购房".equals(applicant.getHousePower())){
                        homestat=2;
                    }else if("租房".equals(applicant.getHousePower())){
                        homestat=3;
                    }else if("全款购房".equals(applicant.getHousePower())||"老家自建房".equals(applicant.getHousePower())){
                        homestat=1;
                    }else if("其他".equals(applicant.getHousePower())||"父母房产".equals(applicant.getHousePower())){
                        homestat=4;
                    }

            }
            zyjrCard.setHomestat(homestat);
            zyjrCard.setHprovince(applicant.getLiveProvince());
            zyjrCard.setHcity(applicant.getLiveCity());
            zyjrCard.setHcounty(applicant.getLiveArea());
            zyjrCard.setHaddress(applicant.getLiveAddress());
           // zyjrCard.setHomezip(applicant.get);
        String indate="";
        if(applicant!=null&&applicant.getLiveTime()!=null){
            Date date=new Date();
            String a=DateUtils.dateTime(date);
            int b=Integer.parseInt(a.substring(0,4));
            indate=String.valueOf(b-Integer.parseInt(applicant.getLiveTime()));
        }
            zyjrCard.setIndate(indate);
            zyjrCard.setMvblno(applicant.getPhoneNumber());
            zyjrCard.setUnitname(applicant.getUnitName());
            Integer duty=null;
            if(applicant!=null&&applicant.getPosition()!=null){
                String app=applicant.getPosition().substring(0,2);
                if("厅级".equals(applicant.getPosition())){
                    duty=3;
                }else if("县处".equals(applicant.getPosition())){
                    duty=4;
                }else if("科级".equals(applicant.getPosition())){
                    duty=5;
                }else if("科员".equals(applicant.getPosition())||"其他".equals(applicant.getPosition())){
                    duty=6;
                }
            }
            zyjrCard.setDuty(duty);
            String cophozono="";
            String cophoneno="";
            if(applicant!=null&&applicant.getUnitPhone()!=null){
                cophoneno= applicant.getUnitPhone().substring(applicant.getUnitPhone().length()-8);
                cophozono=applicant.getUnitPhone().substring(0,applicant.getUnitPhone().length()-cophoneno.length());
            }
            zyjrCard.setCophozono(cophozono);
            zyjrCard.setCophoneno(cophoneno);
            zyjrCard.setCprovince(applicant.getWorkProvince());
            zyjrCard.setCcity(applicant.getWorkCity());
            zyjrCard.setCcounty(applicant.getWorkArea());
            zyjrCard.setCaddress(applicant.getWorkAddress());
            //zyjrCard.setCorpzip();
           // zyjrCard.setJoindate();
        Double yearincome=0.0;
        if(applicant!=null&&applicant.getMonthlyIncome()!=null){

            yearincome=Double.valueOf(applicant.getMonthlyIncome())*12.0;
        }
            zyjrCard.setYearincome(yearincome);
        zyjrCard.setModelcode(190);
        Integer industry=null;
        if(applicant!=null&&applicant.getIndustry()!=null){
            industry=Integer.valueOf(applicant.getIndustry());
        }
        zyjrCard.setOccptn(industry);
       // zyjrCard.setCarstat(applicant.get);
        zyjrCard.setReltname1(contacts.getNameOne());
        zyjrCard.setReltship1(1);
        //zyjrCard.setReltphzon1();
        zyjrCard.setRelaphone1(contacts.getPhoneOne());
        zyjrCard.setReltmobl1(contacts.getPhoneOne());
       // zyjrCard.setStatdate();
        zyjrCard.setPrimnat(156);
        zyjrCard.setCstsign(1);
       // zyjrCard.setAlmebno();
      //  zyjrCard.setOutcardno1();
        JSONObject json2 = new JSONObject().fromObject(zyjrCard);
        return AjaxResult.success("操作成功",json2.toString());
    }

    @ResponseBody
    @PostMapping("card")
    public AjaxResult kaika(@RequestBody ZyjrCard zyjrcard){
        ZyjrKaika a=zyjrKaikaMapper.selectZyjrKaikaById(zyjrcard.getTransactionCode());
        JSONObject json2 = new JSONObject().fromObject(zyjrcard);
        if(a!=null){
            a.setCount(json2.toString());
            zyjrKaikaMapper.updateZyjrKaika(a);
            return  AjaxResult.success();
        }
        ZyjrKaika b=new ZyjrKaika();
        b.setTransactionCode(zyjrcard.getTransactionCode());
        b.setCount(json2.toString());
        zyjrKaikaMapper.insertZyjrKaika(b);
        return  AjaxResult.success();
    }



    public static void main(String[] args) {
        String a="123456789";
    }
    @ResponseBody
    @PostMapping("PWD")
    public AjaxResult pWD(Long userId,String newPassword,String oldPassword){
        SysUser sysUser = userService.selectUserById(userId);
        String password=sysUser.getPassword();
        String userName=sysUser.getUserName();
        if (!SecurityUtils.matchesPassword(oldPassword, password))
        {
            return AjaxResult.error("修改密码失败，旧密码错误");
        }
        if (SecurityUtils.matchesPassword(newPassword, password))
        {
            return AjaxResult.error("新密码不能与旧密码相同");
        }
        if (userService.resetUserPwd(userName, SecurityUtils.encryptPassword(newPassword)) > 0)
        {
            // 更新缓存用户密码
           /* loginUser.getUser().setPassword(SecurityUtils.encryptPassword(newPassword));
            tokenService.setLoginUser(loginUser);*/
            return AjaxResult.success();
        }
        return AjaxResult.error("修改密码异常，请联系管理员");
    }

    @ResponseBody
    @PostMapping("forget")
    public AjaxResult pWsD(String userName,String newPassword){

        if (userService.resetUserPwd(userName, SecurityUtils.encryptPassword(newPassword)) > 0)
        {
            // 更新缓存用户密码
           /* loginUser.getUser().setPassword(SecurityUtils.encryptPassword(newPassword));
            tokenService.setLoginUser(loginUser);*/
            return AjaxResult.success();
        }
        return AjaxResult.error("修改密码异常，请联系管理员");
    }



}
