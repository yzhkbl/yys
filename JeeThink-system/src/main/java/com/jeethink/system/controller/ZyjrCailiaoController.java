package com.jeethink.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.jeethink.common.utils.StringUtils;
import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.*;
import com.jeethink.system.mapper.ZyjrCailiaoMapper;
import com.jeethink.system.mapper.ZyjrCarLoanMapper;
import com.jeethink.system.mapper.ZyjrJzgAddOrderMapper;
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
import com.jeethink.system.service.IZyjrCailiaoService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-15
 */
@RestController
@RequestMapping("/system/cailiao")
public class ZyjrCailiaoController extends BaseController
{
    @Autowired
    private IZyjrCailiaoService zyjrCailiaoService;
    @Autowired
    private ZyjrCailiaoMapper zyjrCailiaoMapper;
    @Autowired
    private ZyjrCarLoanMapper zyjrCarLoanMapper;
    @Autowired
    private ZyjrJzgAddOrderMapper zyjrJzgAddOrderMapper;

    /**
     * 查询【请填写功能名称】列表
     */

    @GetMapping("/list")
    public TableDataInfo list(ZyjrCailiao zyjrCailiao)
    {
        startPage();
        List<ZyjrCailiao> list = zyjrCailiaoService.selectZyjrCailiaoList(zyjrCailiao);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:cailiao:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrCailiao zyjrCailiao)
    {
        List<ZyjrCailiao> list = zyjrCailiaoService.selectZyjrCailiaoList(zyjrCailiao);
        ExcelUtil<ZyjrCailiao> util = new ExcelUtil<ZyjrCailiao>(ZyjrCailiao.class);
        return util.exportExcel(list, "cailiao");
    }

    @PostMapping("/go")
    public AjaxResult post(@RequestBody ZyjrCailiao zyjrCailiao){
        if(zyjrCailiao.getUserId()==null){
            zyjrCailiaoMapper.updateZyjrCailiaos(zyjrCailiao);
            return AjaxResult.success();
        }
            ZyjrCailiao zyjrCailiao1 = zyjrCailiaoService.selectZyjrCailiaoById(zyjrCailiao.getId());
            if(zyjrCailiao1!=null&& StringUtils.isNotEmpty(zyjrCailiao1.getUserId())) {
                if (zyjrCailiao1.getUserId().equals(zyjrCailiao.getUserId())){
                    return AjaxResult.success();
                }
                AjaxResult json=new AjaxResult();
                json.put("code",400);
                json.put("msg", "手慢了，下次再快点！！！");
                return json;
            }
        zyjrCailiaoService.updateZyjrCailiao(zyjrCailiao);
        return AjaxResult.success();
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:cailiao:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrCailiaoService.selectZyjrCailiaoById(id));
    }

    @GetMapping("fenqi")
    public AjaxResult getfenqi(String transactionCode){
        ZyjrCarLoan a=zyjrCarLoanMapper.selectHandle(transactionCode);
        ZyjrJzgAddOrder jzg=zyjrJzgAddOrderMapper.selectZyjrJzgAddOrderByTransactionCode(transactionCode);

        HashMap hashMap = JSON.parseObject(jzg.getData(),HashMap.class);
        System.err.println(hashMap.get("Data"));
        HashMap hashMap1=JSON.parseObject(hashMap.get("Data").toString(),HashMap.class);
        hashMap1.get("");
        FenqiVo fenqiVo=new FenqiVo();
        Pub pub=new Pub();
        FenqiReq fenqiReq=new FenqiReq();
        ZyjrCarType2 zyjrCarType2=new ZyjrCarType2();
        //zyjrCarType2.setCarPrice(a.get);
        fenqiReq.setCarInfo(zyjrCarType2);
        ZyjrStagingInformation2 zyjrStagingInformation2=new ZyjrStagingInformation2();
        fenqiReq.setStageInfo(zyjrStagingInformation2);
        ZyjrGuaranteeinfo2 zyjrGuaranteeinfo2=new ZyjrGuaranteeinfo2();
        fenqiReq.setGuaranteeInfo(zyjrGuaranteeinfo2);
        ZyjrFinanceChargeCardInfo2 zyjrFinanceChargeCardInfo2=new ZyjrFinanceChargeCardInfo2();
        fenqiReq.setFinanceChargeCardInfo(zyjrFinanceChargeCardInfo2);
        ZyjrPayMentInfo2 zyjrPayMentInfo2=new ZyjrPayMentInfo2();
        fenqiReq.setPayMentInfo(zyjrPayMentInfo2);
        JkrclVo jkrclVo=new JkrclVo();
        List<MatesVo> mates=new ArrayList<>();
        MatesVo matesVo=new MatesVo();
        mates.add(matesVo);
        List<Materials> materials=new ArrayList<>();
        Materials materials1=new Materials();
        materials1.setMates(mates);
        materials.add(materials1);
        jkrclVo.setMaterials(materials);
        fenqiReq.setJKRCL(jkrclVo);
        fenqiVo.setPub(pub);
        fenqiVo.setReq(fenqiReq);

        return AjaxResult.success(fenqiVo);
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:cailiao:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrCailiao zyjrCailiao)
    {
        return toAjax(zyjrCailiaoService.insertZyjrCailiao(zyjrCailiao));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:cailiao:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrCailiao zyjrCailiao)
    {
        return toAjax(zyjrCailiaoService.updateZyjrCailiao(zyjrCailiao));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:cailiao:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrCailiaoService.deleteZyjrCailiaoByIds(ids));
    }
}
