package com.jeethink.system.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.jeethink.common.utils.StringUtils;
import com.jeethink.common.utils.file.FileUploadUtils;
import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.*;
import com.jeethink.system.mapper.*;
import net.sf.json.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jeethink.common.annotation.Log;
import com.jeethink.common.core.controller.BaseController;
import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.enums.BusinessType;
import com.jeethink.system.service.IZyjrCailiaoService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private ZyjrAllowApplicantMapper zyjrAllowApplicantMapper;
    @Autowired
    private ZyjrBusinessMapper zyjrBusinessMapper;
    @Autowired
    private ZyjrBorrowerMapper zyjrBorrowerMapper;
    @Autowired
    private ZyjrFangkuanpicMapper zyjrFangkuanpicMapper;
    @Autowired
    private ZyjrFangkuanMapper zyjrFangkuanMapper;
    @Autowired
    private ExamineMapper examineMapper;

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

    @RequestMapping(value = {"/ceshi2"}, method = RequestMethod.POST)
    public AjaxResult ceshi(@RequestParam("type") String type,@RequestParam("code") String code, @RequestParam("file") MultipartFile file, @RequestParam("id") String id) throws IOException {

        String a = FileUploadUtils.upload(file);
        ZyjrFangkuanpic info = new ZyjrFangkuanpic();
        String as = "http://114.215.186.186:8080"+ a;
        info.setFilePath(as);
        info.setTransactionCode(id);
        info.setFileName(code);
        info.setType(type);
        zyjrFangkuanpicMapper.insertZyjrFangkuanpic(info);


        return AjaxResult.success();
    }
    @GetMapping("demaxiya")
    public AjaxResult gg(){
        Region region=new Region();
        region.setLevel(1);
        region.setRegionName("北京市");
        List<Region> a=examineMapper.selectRegion(region);
        return AjaxResult.success(a);
    }

    @GetMapping("fenqi")
    public AjaxResult getfenqi(String transactionCode){
        ZyjrBusiness b=zyjrBusinessMapper.selectById(transactionCode);
        ZyjrFangkuan kaika= zyjrFangkuanMapper.selectZyjrFangkuanById(transactionCode);
        if(kaika!=null&&kaika.getCount()!=null){
            AjaxResult json=new AjaxResult();
            json.put("msg",b.getIntentionPrice());
            json.put("code",200);
            json.put("data",kaika.getCount());
            json.put("state",1);
            return json;
        }
        ZyjrCarLoan a=zyjrCarLoanMapper.selectHandle(transactionCode);
        ZyjrJzgAddOrder jzg=zyjrJzgAddOrderMapper.selectZyjrJzgAddOrderByTransactionCode(transactionCode);
        ZyjrAllowApplicant app=zyjrAllowApplicantMapper.selectById(transactionCode);

        ZyjrBorrower bo=zyjrBorrowerMapper.selectById(transactionCode);
        FenqiVo fenqiVo=new FenqiVo();
        Pub pub = new Pub();
        pub.setBankCode("0180400023");
        pub.setAssurerNo("S36029951");
        pub.setPlatNo("zyhzjg");
        pub.setOrderNo(transactionCode);
        pub.setProductType(1);
        pub.setBankType("ICBC");
        pub.setBusiCode("1002");
        FenqiReq fenqiReq=new FenqiReq();
        ZyjrCarType2 zyjrCarType2=new ZyjrCarType2();
        if(jzg!=null){
            HashMap hashMap = JSON.parseObject(jzg.getData(),HashMap.class);

            // System.err.println(hashMap.get("Data"));
            //车辆价格
            zyjrCarType2.setCarPrice(a.getActualPrice());
            HashMap hashMap1=JSON.parseObject(hashMap.get("Data").toString(),HashMap.class);

            BigDecimal CarPrice=BigDecimal.valueOf(Double.parseDouble(hashMap1.get("ManufacturerPrice").toString()));
            //系统查询价
            zyjrCarType2.setSystemCarPrice(CarPrice);
            String VIN=hashMap1.get("VIN").toString();
            //车架号
            zyjrCarType2.setFrameNo(VIN);
            Integer carType=1;
            if(VIN.substring(0,1).equals("L")||VIN.substring(0,1).equals("R")){
                carType=0;
            }
            //国产车还是进口车
            zyjrCarType2.setCarType(carType);
            //车型
            zyjrCarType2.setCarSpecs(hashMap1.get("CarName").toString());

            //品牌
            zyjrCarType2.setCarBrands(hashMap1.get("MakeName").toString());
            //车系
            zyjrCarType2.setCarSeries(hashMap1.get("ModelName").toString());
            //发动机号
            zyjrCarType2.setEngineNo(hashMap1.get("EngineNum").toString());
            //车牌号码
            zyjrCarType2.setLicensePlateNo(hashMap1.get("CarLicense").toString());

        }
        fenqiReq.setCarInfo(zyjrCarType2);
        ZyjrStagingInformation2 zyjrStagingInformation2=new ZyjrStagingInformation2();
        if(a!=null){
            //业务模式
            zyjrStagingInformation2.setBusinessModel(6);
            //产品代码
            zyjrStagingInformation2.setProductCode("120180001001");
            //还款方式
            zyjrStagingInformation2.setRepaymentType(1);
            //分期金额
            zyjrStagingInformation2.setStageMoney(a.getLoanAmount());
            //首月还款金额
            //    zyjrStagingInformation2.setFirstMonthMoney();
            //还款期限
            zyjrStagingInformation2.setRepayPeriod(Integer.parseInt(a.getRepaymentTerm().toString()));
            //营销档案编号
            zyjrStagingInformation2.setMarketingArchivesNum("46009102");
            //营销代码
            zyjrStagingInformation2.setDscode("PS0001702020602217");
            //是否重新签约
            zyjrStagingInformation2.setWillResign(0);
            //还款人月均总收入
            zyjrStagingInformation2.setMonthincome(BigDecimal.valueOf(Double.parseDouble(app.getMonthlyIncome())));
            //其他月还款额
            BigDecimal yamt=new BigDecimal(0);
            zyjrStagingInformation2.setMonrepayamt(yamt);
            zyjrStagingInformation2.setOthdebtbal(yamt);
        }
        fenqiReq.setStageInfo(zyjrStagingInformation2);
        ZyjrGuaranteeinfo2 zyjrGuaranteeinfo2=new ZyjrGuaranteeinfo2();
        zyjrGuaranteeinfo2.setMortname("汽车");
        zyjrGuaranteeinfo2.setMortltype("002");
        zyjrGuaranteeinfo2.setMortmtype("002001");
        zyjrGuaranteeinfo2.setMortstype("002001001");
        fenqiReq.setGuaranteeInfo(zyjrGuaranteeinfo2);
        pub.setOrderNo(transactionCode);
        fenqiVo.setPub(pub);
        ZyjrFinanceChargeCardInfo2 zyjrFinanceChargeCardInfo2=new ZyjrFinanceChargeCardInfo2();
        fenqiReq.setFinanceChargeCardInfo(zyjrFinanceChargeCardInfo2);
        ZyjrPayMentInfo2 zyjrPayMentInfo2=new ZyjrPayMentInfo2();
        List<CocomNos> cocomNos=new ArrayList<>();
        zyjrPayMentInfo2.setCocomNos(cocomNos);
        fenqiReq.setPayMentInfo(zyjrPayMentInfo2);

        JkrclVo JkrclVo=new JkrclVo();

        JkrclVo.setName(bo.getUserName());
        JkrclVo.setIdCard(bo.getIdCard());
        List<MatesVo> mates=new ArrayList<>();
        MatesVo matesVos=new MatesVo();
        mates.add(matesVos);
        List<Materials> materials=new ArrayList<>();
        JkrclVo.setMaterials(materials);
        ZyjrFangkuanpic zyjrFangkuanpic=new ZyjrFangkuanpic();
        zyjrFangkuanpic.setTransactionCode(transactionCode);
        fenqiReq.setJKRCL(JkrclVo);

        fenqiVo.setReq(fenqiReq);
        List<ZyjrFangkuanpic> zyjrFangkuanpicList=zyjrFangkuanpicMapper.selectZyjrFangkuanpicList(zyjrFangkuanpic);
        Set<String> set=zyjrFangkuanpicList.stream().map(ZyjrFangkuanpic::getFileName).collect(Collectors.toSet());
        for (String s : set) {
            Materials zyjrMaterials=new Materials();
            zyjrMaterials.setDownloadMode("1");
            List<MatesVo> mlist=new ArrayList<>();
            List<ZyjrFangkuanpic> data = zyjrFangkuanpicList.stream().filter(as -> as.getFileName().equals(s)).collect(Collectors.toList());
            for (ZyjrFangkuanpic datum : data) {
                zyjrMaterials.setMaterialCode(datum.getFileName());
                zyjrMaterials.setMaterialsType(datum.getType());
                MatesVo matesVo=new MatesVo();
                int i=datum.getFilePath().lastIndexOf("/");
                String name=datum.getFilePath().substring(i+1,datum.getFilePath().length());
                matesVo.setFileName(name);
                matesVo.setDemandMateId(Integer.parseInt(datum.getId().toString()));
                matesVo.setMaterialsPic(datum.getFilePath());
                mlist.add(matesVo);
            }
            zyjrMaterials.setMates(mlist);
            fenqiVo.getReq().getJKRCL().getMaterials().add(zyjrMaterials);

        }
        JSONObject json2 = new JSONObject().fromObject(fenqiVo);
        // Json
        AjaxResult json=new AjaxResult();
        json.put("msg",b.getIntentionPrice());
        json.put("code",200);
        json.put("data",json2.toString());
        json.put("state",null);
        return json;
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
