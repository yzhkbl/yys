package com.jeethink.system.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeethink.common.core.controller.BaseController;
import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.system.domain.ZyjrBusiness;
import com.jeethink.system.domain.ZyjrRelation;
import com.jeethink.system.domain.vo.Pics;
import com.jeethink.system.domain.vo.Pub;
import com.jeethink.system.domain.vo.lender;
import com.jeethink.system.domain.vo.req;
import com.jeethink.system.domain.vo.selVO;
import com.jeethink.system.domain.vo.spouse;
import com.jeethink.system.service.IZyjrBusinessService;
import com.jeethink.system.service.IZyjrRelationService;
import com.jeethink.system.util.HttpPostUtil;
import com.rsa.RSASignature;
import com.rsa.RSAUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/system/test")
@Api("测试接口")
public class test extends BaseController{

	@Autowired
	private IZyjrRelationService r;
	@Autowired
	private IZyjrBusinessService b;
	
	@ApiOperation("查询参数列表")
	@PostMapping
	@ResponseBody
	    public AjaxResult find(){
		System.err.println("11");
		selVO a=new selVO();
		/**
		 * 现id写死
		 */
		ZyjrBusiness business = b.selectZyjrBusinessById((long) 26);
		List<spouse> lists=new ArrayList<>();
		ZyjrRelation relation=r.selectZyjrRelationById(9);
	
		/**
		 * 现无数据后期该行改为sql查询
		 */
		
		Pub pub=new Pub();
		pub.setBankCode("0180400023");
		pub.setAssurerNo("S36020729");
		pub.setOrderNo("vx01804000011113333999900000001");
		pub.setProductType(1);
		pub.setPlatNo("htxc");
		pub.setBankType("ICBC");
		/*pub.setBusiCode("1001");*/
		System.out.println(pub);
		Pics p1=new Pics();
		p1.setPicId(relation.getObverseId());
		p1.setPicCode(relation.getObverseCode());
		p1.setPicAddress(relation.getObverseAddress());
		p1.setPicFileName(relation.getObverseName());
		Pics p2=new Pics();
		p2.setPicId(relation.getBackId());
		p2.setPicCode(relation.getBackCode());
		p2.setPicAddress(relation.getBackAddress());
		p2.setPicFileName(relation.getBackName());
		Pics p3=new Pics();
		p3.setPicId(relation.getPowerId());
		p3.setPicCode(relation.getPowerCode());
		p3.setPicAddress(relation.getPowerAddress());
		p3.setPicFileName(relation.getPowerName());
		spouse s=new spouse();
		s.setIdCard(relation.getIdCard());
		/*s.setIssueAuthority(relation.getIssueAuthority());*/
		s.setPhoneNum(relation.getPhoneNumber());
		s.setUserName(relation.getUserName());
		s.setRelationName("母子");
		s.setRelationShip(2);
		/*s.setStartDate(relation.getStartDate());
		s.setEndDate(relation.getEndDate());*/
	/*	s.setCompany(relation.getCompany());
		s.setCompanyAddress(relation.getCompanyAddress());
		s.setYearIncome(relation.getYearIncome());
		s.setIsQueryCredit(1);
		s.setUserRelationship(2);
		s.setFamilyAddress(relation.getFamilyAddress());
		s.setBankCardNo(relation.getBankCardNo());*/
		List<Pics> pp=new ArrayList<>();
		pp.add(p1);
		pp.add(p2);
		pp.add(p3);
		s.setPic(pp);
		lists.add(s);
		lender len=new lender();
		req re=new req();
		len.setPics(pp);
	/*	len.setSignMode(1);
		len.setStartDate(relation.getStartDate());
		len.setEndDate(relation.getEndDate());*/
		len.setUserName("老曹");//relation.getUserName()
		/*len.setIssueAuthority(relation.getIssueAuthority());*/
		len.setIdCard("123456789123456789");//relation.getIdCard()
		/*len.setBankCardNo(relation.getBankCardNo());
		len.setFamilyAddress(relation.getFamilyAddress());*/
		len.setPhoneNum("13800000000");//relation.getPhoneNumber()
	/*	len.setLoanMoney(business.getLoanMoney());
		len.setRepayPeriod(business.getRepayPeriod());*/
		/**
		 * lender中缺少签约方式
		 */
		re.setLender(len);
/*		re.setCarType(business.getCarType());
		re.setIntentionPrice(886466.00);
		re.setDownloadMode(1);*/
		re.setSpouse(lists);
		a.setReq(re);
		a.setPub(pub);
		String dataPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFZnUVz07wuQfI5kf3uOaaJcpq*W3yQhJnIX2k-EKwKZaSkyuXutk0TXqwT-GXxIQJqmkjLup*HN7H1uF7JMfxl00AnncHB82LqUQKQwf5wcdDTNhvKLQtjRoLE3ry6ARoYHu5AkZPKW7sMM4o*UegPlSr45p4ZsK0iVdjqmgZfwIDAQAB";
		String signPrivateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKOoelzwAU5Asw9zknkTYGvfZr0Ap6ZDL6NMSNRYZ2maVJd5xOfSRqTkEq1Ne*h2Qe3wCKdxo0SuCVWNjM-nd3af*fb4YcWdlDuHaA1s28I5hZtVp2sbF*nvgdeUwSz-X0hQGcaqVzcTKDH9l2XuMC**OEofyyosU2jvEIGdwqSNAgMBAAECgYAkojvxvc*tApKSbN5mt82nl-RZbmIYt4VcWmEbF0bevqsc1SccdVdW5a7AmE2aNY6AgnCNesR-RS3Vtr-Ech2tVfwMXypJsXN5hq0uyM6iDkE6kFhGL1zui72u9RQJvdB7CsNfEONIaFlX46MUOdF0fR2n-sGLMc1qzpj*L3k6QQJBAOJfQRF6ehE5d1Sm*7q9uObte1ubako89TSGZmCOk-3vpm9CRTey-18Ids98yMNg3Wy53M4oEzjwjdnnulX9PpUCQQC5E-NySYbigVCsO5Tjr*iAA1ykdGIgaRM45s2tvbMLYQdZYhnkPRjSj*Y7I915cp5klQ75T260InPYQqBkb2gZAkEAjRYtKcWZ*s5EL4B7eCHy8gqlTa0JjAd*FCSH-joexq-snX9CQLrRKtvNoPf28L6YgsE8e0jC4kQbROqGWj2iGQJBAKkXVUCBdL7UrsPs26b6PE1YxPdrbYt29Jz0Ic4ulro6t*AuBMHGIDugRRSbO*mNkrEKjlew-s*M*pIGrUuVjWECQQC3qMemXCmqp7lAaSqYy9Rk8HNVgEeDqJfhcIS4SrRH0DSExPE9yfhadaiC4IIYmmK5L*2V3dxIUI7KXbeO*ptz";
//		String assurerNo = "ceshi001";
//		String bankType = "ICBC";
//		String busiCode = "0001";
//		String platNo = "zajk";
		String assurerNo = "S36020729";
		String bankType = "ICBC";
		String busiCode = "1003";
		String platNo = "htxc";
		String c=a.toString();
		
		JSONObject json = encryptData(c, dataPublicKey, signPrivateKey, assurerNo, bankType, busiCode, platNo);
		JSONObject result = HttpPostUtil.doPostRequestJSON("http://114.55.55.41:8998/bank/route", json);
	    return AjaxResult.success(result);
	    }
	
	public static JSONObject encryptData(String data, String dataPublicKey ,String signPrivateKey ,String assurerNo
			, String bankType, String busiCode, String platNo){
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
	    request.put("orderNo","vx01804000011113333999900000001");
	    return request;
	}
	
	



}
