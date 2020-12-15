package com.jeethink.system.controller;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


import com.jeethink.common.utils.file.FileUploadUtils;
import com.jeethink.system.domain.vo.*;
import com.jeethink.system.mapper.ZyjrBorrowerMapper;
import com.jeethink.system.mapper.ZyjrBusinessMapper;
import com.jeethink.system.mapper.ZyjrGuaranteeMapper;
import com.jeethink.system.mapper.ZyjrRelationMapper;
import com.jeethink.system.util.FileUtil;
import com.rsa.RSASignature;
import com.rsa.RSAUtil;
import net.sf.json.JSONObject;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.jeethink.system.util.HttpPostUtil;
import com.jeethink.common.core.controller.BaseController;
import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.system.domain.ZyjrBorrower;
import com.jeethink.system.domain.ZyjrBusiness;
import com.jeethink.system.domain.ZyjrGuarantee;
import com.jeethink.system.domain.ZyjrRelation;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/system/test")
@Api("测试接口")
public class test extends BaseController{

	@Autowired
	private ZyjrRelationMapper r;
	@Autowired
	private ZyjrBusinessMapper b;
	@Autowired
	private ZyjrBorrowerMapper o;
	@Autowired
	private ZyjrGuaranteeMapper g;

	private static String oCode="sfzzm";
	private static String pCode="sfzfm";
	private static String zCode="zxsqs";

	@ApiOperation("查询参数列表")
	@PostMapping
	@ResponseBody
	public AjaxResult find(String codes){
		System.err.println("11");
selVO a=new selVO();
		/*List<Object> a=new ArrayList<>();*/
		/**
		 * 现id写死
		 */
		ZyjrBusiness business = b.selectById(codes);
		List<spouse> lists=new ArrayList<>();
		ZyjrRelation relation=r.selectById(codes);
		ZyjrBorrower borrowerById = o.selectById(codes);
		ZyjrGuarantee guarantee = g.selectById(codes);
		/**
		 * 现无数据后期该行改为sql查询
		 */
		String orderNo="vx001002001786984798554951686";
		Pub pub=new Pub();
		pub.setBankCode("0180400023");
		pub.setAssurerNo("S36029951");
		pub.setPlatNo("zyhzjg");
		pub.setOrderNo(orderNo);
		pub.setProductType(1);
		pub.setBankType("ICBC");
		pub.setBusiCode("1001");
		System.out.println(pub);
		Pics p1=new Pics();
		List<Pics> pp=new ArrayList<>();
		List<Pics> lenp=new ArrayList<>();
		List<Pics> guaranteep=new ArrayList<>();
		spouse sguarantee=new spouse();
		spouse s=new spouse();
		if(relation==null){
		p1.setPicId(relation.getObverseId());
		p1.setPicCode(oCode);
		p1.setPicAddress(relation.getObverseAddress()+".jpg");
		p1.setPicFileName(relation.getObverseName()+".jpg");
		Pics p2=new Pics();
		p2.setPicId(relation.getBackId());
		p2.setPicCode(pCode);
		p2.setPicAddress(relation.getBackAddress()+".jpg");
		p2.setPicFileName(relation.getBackName()+".jpg");
		Pics p3=new Pics();
		p3.setPicId(relation.getPowerId());
		p3.setPicCode(zCode);
		p3.setPicAddress(relation.getPowerAddress()+".jpg");
		p3.setPicFileName(relation.getPowerName()+".jpg");
			s.setIdCard(relation.getIdCard());
			s.setIssueAuthority(relation.getIssueAuthority());
			s.setPhoneNum(relation.getPhoneNumber());
			s.setBankCardNo(relation.getBankCardNo());
			s.setUserName(relation.getUserName());
			s.setStartDate(relation.getStartDate());
			s.setIsQueryCredit(0);
			s.setUserRelationship(2);
			s.setCompany(relation.getCompany());
			s.setCompanyAddress(relation.getCompanyAddress());
			s.setYearIncome(relation.getYearIncome());
			s.setEndDate(relation.getEndDate());
			s.setFamilyAddress(relation.getFamilyAddress());
			pp.add(p1);
			pp.add(p2);
			pp.add(p3);
			s.setPics(pp);
			lists.add(s);
		}
		Pics p4=new Pics();
		p4.setPicId(borrowerById.getPowerId());
		p4.setPicCode(oCode);
		p4.setPicAddress(borrowerById.getPowerAddress()+".jpg");
		p4.setPicFileName(borrowerById.getPowerName()+".jpg");
		Pics p5=new Pics();
		p5.setPicId(borrowerById.getPowerId());
		p5.setPicCode(pCode);
		p5.setPicAddress(borrowerById.getPowerAddress()+".jpg");
		p5.setPicFileName(borrowerById.getPowerName()+".jpg");
		Pics p6=new Pics();
		p6.setPicId(borrowerById.getPowerId());
		p6.setPicCode(zCode);
		p6.setPicAddress(borrowerById.getPowerAddress()+".jpg");
		p6.setPicFileName(borrowerById.getPowerName()+".jpg");
				lenp.add(p4);
				lenp.add(p5);
				lenp.add(p6);


		if(guarantee==null){
			Pics p7=new Pics();
			p7.setPicId(guarantee.getPowerId());
			p7.setPicCode(oCode);
			p7.setPicAddress(guarantee.getPowerAddress()+".jpg");
			p7.setPicFileName(guarantee.getPowerName()+".jpg");
			Pics p8=new Pics();
			p8.setPicId(guarantee.getPowerId());
			p8.setPicCode(pCode);
			p8.setPicAddress(guarantee.getPowerAddress()+".jpg");
			p8.setPicFileName(guarantee.getPowerName()+".jpg");
			Pics p9=new Pics();
			p9.setPicId(guarantee.getPowerId());
			p9.setPicCode(zCode);
			p9.setPicAddress(guarantee.getPowerAddress()+".jpg");
			p9.setPicFileName(guarantee.getPowerName()+".jpg");
			sguarantee.setIdCard(guarantee.getIdCard());
			sguarantee.setIssueAuthority(guarantee.getIssueAuthority());
			sguarantee.setPhoneNum(guarantee.getPhoneNumber());
			sguarantee.setBankCardNo(guarantee.getBankCardNo());
			sguarantee.setUserName(guarantee.getUserName());
			sguarantee.setStartDate(guarantee.getStartDate());
			sguarantee.setIsQueryCredit(0);
			sguarantee.setUserRelationship(2);
			sguarantee.setCompany(guarantee.getCompany());
			sguarantee.setCompanyAddress(guarantee.getCompanyAddress());
			sguarantee.setYearIncome(guarantee.getYearIncome());
			sguarantee.setEndDate(guarantee.getEndDate());
			sguarantee.setFamilyAddress(guarantee.getFamilyAddress());
			guaranteep.add(p7);
			guaranteep.add(p8);
			guaranteep.add(p9);
			sguarantee.setPics(guaranteep);
			lists.add(sguarantee);
		}



		lender len=new lender();
		req re=new req();
		len.setIdCard(borrowerById.getIdCard());//relation.getIdCard()
		len.setBankCardNo(borrowerById.getBankCardNo());
		len.setSignMode(1);
		len.setIssueAuthority(borrowerById.getIssueAuthority());
		len.setPhoneNum(borrowerById.getPhoneNumber());//relation.getPhoneNumber()
		len.setUserName(borrowerById.getUserName());//relation.getUserName()
		len.setStartDate(borrowerById.getStartDate());
		len.setEndDate(borrowerById.getEndDate());
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
		re.setBusinessModel(8);
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


		AjaxResult c=AjaxResult.success(a);
		JSONObject json2 = new JSONObject().fromObject(a);
		AjaxResult as=AjaxResult.success(a.toString());
		System.err.println(json2);
		System.err.println(json2.toString());
		JSONObject json = encryptData(json2.toString(), dataPublicKey, signPrivateKey, assurerNo, bankType, busiCode, platNo,orderNo);
		JSONObject result = HttpPostUtil.doPostRequestJSON("http://114.55.55.41:18999/bank/route", json);
		/*	if(result.get("code").equals(0)){
				System.err.println(result.get("data").toString().split("\"")[3]);
				OkVo ok=new OkVo();
				oKreq okreq=new oKreq();
				okreq.setSignConfirm(1);
				pub.setBusiCode("1008");
				busiCode="1008";
				ok.setPub(pub);
				ok.setReq(okreq);
				JSONObject json3 = new JSONObject().fromObject(ok);
				JSONObject jsons = encryptData(json3.toString(), dataPublicKey, signPrivateKey, assurerNo, bankType, busiCode, platNo,orderNo);
				JSONObject results = HttpPostUtil.doPostRequestJSON("http://114.55.55.41:18999/bank/route", jsons);
				if(results.get("code").equals(0)){
					return AjaxResult.error("提交成功");
				}

			}*/
		return AjaxResult.success(result);
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



	/**
	 * test 测试接口，测试是否能接到图片集合
	 * @return
	 */


	@RequestMapping(value ={"/ceshi"},method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation("111111111")
	public AjaxResult testFiles(@RequestBody MultipartFile file) throws Exception {
	/*	FileInputStream fileInputStream = new FileInputStream(file);
		MultipartFile multipartFile = new MockMultipartFile("copy"+file.getName(),file.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(),fileInputStream);
		System.out.println(multipartFile.getName());*/
		String a=FileUploadUtils.upload(file);
		System.err.println(a);
		return AjaxResult.success(a);
}

	@RequestMapping(value ={"/ceshi2"},method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation("111111111")
	public AjaxResult ceshi()  {
		int a=1;
		System.err.println(a);
		return AjaxResult.success(a);
	}






}
