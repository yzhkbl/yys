package com.jeethink.system.controller;

import java.util.List;

import com.jeethink.system.domain.vo.OpenCard;
import com.jeethink.system.domain.vo.Pub;
import com.jeethink.system.domain.vo.ZyjrCardVo;
import com.jeethink.system.domain.vo.ceshi;
import com.jeethink.system.mapper.ZyjrCardMapper;
import com.jeethink.system.util.HttpPostUtil;
import com.jeethink.system.util.RSASignature;
import com.jeethink.system.util.RSAUtil;
import net.sf.json.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jeethink.common.annotation.Log;
import com.jeethink.common.core.controller.BaseController;
import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.enums.BusinessType;
import com.jeethink.system.domain.ZyjrCard;
import com.jeethink.system.service.IZyjrCardService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * cardController
 * 
 * @author jeethink
 * @date 2020-12-30
 */
@RestController
@RequestMapping("/system/card")
public class ZyjrCardController extends BaseController
{
    @Autowired
    private IZyjrCardService zyjrCardService;
    @Autowired
    private ZyjrCardMapper zyjrCardMapper;

    /**
     * 查询card列表
     */
    @PreAuthorize("@ss.hasPermi('system:card:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrCard zyjrCard)
    {
        startPage();
        List<ZyjrCard> list = zyjrCardService.selectZyjrCardList(zyjrCard);
        return getDataTable(list);
    }

    @GetMapping("/a")
    public AjaxResult aja(String codes){
        ZyjrCard a=zyjrCardMapper.selectZyjrCardByTransactionCode(codes);
        String dataPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCFZnUVz07wuQfI5kf3uOaaJcpq*W3yQhJnIX2k-EKwKZaSkyuXutk0TXqwT-GXxIQJqmkjLup*HN7H1uF7JMfxl00AnncHB82LqUQKQwf5wcdDTNhvKLQtjRoLE3ry6ARoYHu5AkZPKW7sMM4o*UegPlSr45p4ZsK0iVdjqmgZfwIDAQAB";
        String signPrivateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKOoelzwAU5Asw9zknkTYGvfZr0Ap6ZDL6NMSNRYZ2maVJd5xOfSRqTkEq1Ne*h2Qe3wCKdxo0SuCVWNjM-nd3af*fb4YcWdlDuHaA1s28I5hZtVp2sbF*nvgdeUwSz-X0hQGcaqVzcTKDH9l2XuMC**OEofyyosU2jvEIGdwqSNAgMBAAECgYAkojvxvc*tApKSbN5mt82nl-RZbmIYt4VcWmEbF0bevqsc1SccdVdW5a7AmE2aNY6AgnCNesR-RS3Vtr-Ech2tVfwMXypJsXN5hq0uyM6iDkE6kFhGL1zui72u9RQJvdB7CsNfEONIaFlX46MUOdF0fR2n-sGLMc1qzpj*L3k6QQJBAOJfQRF6ehE5d1Sm*7q9uObte1ubako89TSGZmCOk-3vpm9CRTey-18Ids98yMNg3Wy53M4oEzjwjdnnulX9PpUCQQC5E-NySYbigVCsO5Tjr*iAA1ykdGIgaRM45s2tvbMLYQdZYhnkPRjSj*Y7I915cp5klQ75T260InPYQqBkb2gZAkEAjRYtKcWZ*s5EL4B7eCHy8gqlTa0JjAd*FCSH-joexq-snX9CQLrRKtvNoPf28L6YgsE8e0jC4kQbROqGWj2iGQJBAKkXVUCBdL7UrsPs26b6PE1YxPdrbYt29Jz0Ic4ulro6t*AuBMHGIDugRRSbO*mNkrEKjlew-s*M*pIGrUuVjWECQQC3qMemXCmqp7lAaSqYy9Rk8HNVgEeDqJfhcIS4SrRH0DSExPE9yfhadaiC4IIYmmK5L*2V3dxIUI7KXbeO*ptz";
        String assurerNo = "S36029951";
        String bankType = "ICBC";
        String busiCode = "1003";
        String platNo = "zyhzjg";
        Pub pub = new Pub();
        pub.setBankCode("0180400023");
        pub.setAssurerNo("S36029951");
        pub.setPlatNo("zyhzjg");
        pub.setOrderNo(codes);
        pub.setProductType(1);
        pub.setBankType(bankType);
        pub.setBusiCode("1003");
        ZyjrCardVo zyjrCardVo=new ZyjrCardVo();
        zyjrCardVo.setCustsort(a.getCustsort());
        zyjrCardVo.setCustcode(a.getCustcode());
        zyjrCardVo.setChnsname(a.getChnsname());
        zyjrCardVo.setEngname(a.getEngname());
        zyjrCardVo.setSex(a.getSex());
        zyjrCardVo.setMrtlstat(a.getMrtlstat());
        zyjrCardVo.setEdulvl(a.getEdulvl());
        zyjrCardVo.setDrawmode(a.getDrawmode());
        zyjrCardVo.setDrawzono(a.getDrawzono());
        zyjrCardVo.setDrawbrno(a.getDrawbrno());
        zyjrCardVo.setHomestat(a.getHomestat());
        zyjrCardVo.setHprovince(a.getHprovince());
        zyjrCardVo.setHcity(a.getHcity());
        zyjrCardVo.setHcounty(a.getHcounty());
        zyjrCardVo.setHaddress(a.getHaddress());
        zyjrCardVo.setHomezip(a.getHomezip());
        zyjrCardVo.setIndate(a.getIndate());
        zyjrCardVo.setMvblno(a.getMvblno());
        zyjrCardVo.setEmail(a.getEmail());
        zyjrCardVo.setUnitname(a.getUnitname());
        zyjrCardVo.setDuty(a.getDuty());
        zyjrCardVo.setCophozono(a.getCophozono());
        zyjrCardVo.setCophoneno(a.getCophoneno());
        zyjrCardVo.setCprovince(a.getCprovince());
        zyjrCardVo.setCcity(a.getCcity());
        zyjrCardVo.setCcounty(a.getCcounty());
        zyjrCardVo.setCaddress(a.getCaddress());
        zyjrCardVo.setCorpzip(a.getCorpzip());
        zyjrCardVo.setJoindate(a.getJoindate());
        zyjrCardVo.setYearincome(a.getYearincome());
        zyjrCardVo.setModelcode(a.getModelcode());
        zyjrCardVo.setOccptn(a.getOccptn());
        zyjrCardVo.setCarstat(a.getCarstat());
        zyjrCardVo.setReltname1(a.getReltname1());
        zyjrCardVo.setReltship1(a.getReltship1());
        zyjrCardVo.setRelaphone1(a.getRelaphone1());
        zyjrCardVo.setReltmobl1(a.getReltmobl1());
        zyjrCardVo.setStatdate(a.getStatdate());
        zyjrCardVo.setPrimnat(a.getPrimnat());
        zyjrCardVo.setCstsign(a.getCstsign());
        zyjrCardVo.setAlmebno(a.getAlmebno());
        zyjrCardVo.setOutcardno1(a.getOutcardno1());

        OpenCard openCard=new OpenCard();
        openCard.setPub(pub);
        openCard.setReq(zyjrCardVo);
        JSONObject json3 = new JSONObject().fromObject(openCard);

        JSONObject jsons = encryptData(json3.toString(), dataPublicKey, signPrivateKey, assurerNo, bankType, busiCode, platNo, codes);

        JSONObject results = HttpPostUtil.doPostRequestJSON(





































































                "http://114.55.55.41:18999/bank/route", jsons);

        return AjaxResult.error();
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
     * 导出card列表
     */
    @PreAuthorize("@ss.hasPermi('system:card:export')")
    @Log(title = "card", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrCard zyjrCard)
    {
        List<ZyjrCard> list = zyjrCardService.selectZyjrCardList(zyjrCard);
        ExcelUtil<ZyjrCard> util = new ExcelUtil<ZyjrCard>(ZyjrCard.class);
        return util.exportExcel(list, "card");
    }

    /**
     * 获取card详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:card:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrCardService.selectZyjrCardById(id));
    }

    /**
     * 新增card
     */
    @PreAuthorize("@ss.hasPermi('system:card:add')")
    @Log(title = "card", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrCard zyjrCard)
    {
        return toAjax(zyjrCardService.insertZyjrCard(zyjrCard));
    }

    /**
     * 修改card
     */
    @PreAuthorize("@ss.hasPermi('system:card:edit')")
    @Log(title = "card", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrCard zyjrCard)
    {
        return toAjax(zyjrCardService.updateZyjrCard(zyjrCard));
    }

    /**
     * 删除card
     */
    @PreAuthorize("@ss.hasPermi('system:card:remove')")
    @Log(title = "card", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrCardService.deleteZyjrCardByIds(ids));
    }
}
