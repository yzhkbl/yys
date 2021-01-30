package com.jeethink.system.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jeethink.common.utils.StringUtils;
import com.jeethink.common.utils.http.HttpUtils;
import com.jeethink.system.domain.*;
import com.jeethink.system.domain.vo.*;
import com.jeethink.system.mapper.*;
import com.jeethink.system.service.IZyjrJzgAddOrderService;
import com.jeethink.system.util.HttpClientUtil;
import com.jeethink.system.util.HttpPostUtil;
import com.jeethink.system.util.JzgUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
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
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-31
 */
@Api
@RestController
@RequestMapping("/system/jzg/addOrder")
public class ZyjrJzgAddOrderController extends BaseController
{
    @Autowired
    private IZyjrJzgAddOrderService zyjrJzgAddOrderService;
    @Autowired
    private ZyjrJzgAddOrderMapper zyjrJzgAddOrderMapper;
    @Autowired
    private ZyjrPicMapper zyjrPicMapper;
    @Autowired
    private ZyjrPhotoCarMapper zyjrPhotoCarMapper;
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;
    @Autowired
    private ZyjrCarLoanMapper zyjrCarLoanMapper;
    @Autowired
    private ExamineMapper examineMapper;
    private static final String userId="18686";
    private static final String tokenId="177";
    private static final String tokenKey="82CF76A1-3C3A-4E0B-9969-1789137982F5";

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrJzgAddOrder zyjrJzgAddOrder)
    {
        startPage();
        List<ZyjrJzgAddOrder> list = zyjrJzgAddOrderService.selectZyjrJzgAddOrderList(zyjrJzgAddOrder);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrJzgAddOrder zyjrJzgAddOrder)
    {
        List<ZyjrJzgAddOrder> list = zyjrJzgAddOrderService.selectZyjrJzgAddOrderList(zyjrJzgAddOrder);
        ExcelUtil<ZyjrJzgAddOrder> util = new ExcelUtil<ZyjrJzgAddOrder>(ZyjrJzgAddOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @GetMapping(value = "/{vin}")
    public AjaxResult getInfo(@PathVariable("vin") Long vin)
    {
        return AjaxResult.success(zyjrJzgAddOrderService.selectZyjrJzgAddOrderById(vin));
    }

    /**
     * 新增【请填写功能名称】
     */

    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrJzgAddOrder zyjrJzgAddOrder)
    {
        return toAjax(zyjrJzgAddOrderService.insertZyjrJzgAddOrder(zyjrJzgAddOrder));
    }
    @ApiOperation("11111111")
    @PostMapping("/insert")
    public AjaxResult addd(ZyjrJzgAddOrder zyjrJzgAddOrder)
    {

        ZyjrJzgAddOrder zyjrJzgAddOrder1 = zyjrJzgAddOrderMapper.selectZyjrJzgAddOrderByTransactionCode(zyjrJzgAddOrder.getTransactionCode());
        if(zyjrJzgAddOrder.getPic()!=null) {
            System.err.println(zyjrJzgAddOrder.getPic());
            zyjrPicMapper.deleteZyjrPicById2(zyjrJzgAddOrder.getTransactionCode());
            JSONArray jsonarray = JSONArray.fromObject(zyjrJzgAddOrder.getPic());
            List<ZyjrPic> list = (List) JSONArray.toList(jsonarray, ZyjrPic.class);
            for (ZyjrPic zyjrPic : list) {
                zyjrPic.setJinzhengu(zyjrJzgAddOrder.getTransactionCode());
                zyjrPicMapper.insertZyjrPic(zyjrPic);
            }
        }
        if(zyjrJzgAddOrder1!=null){
            zyjrJzgAddOrderService.updateZyjrJzgAddOrder(zyjrJzgAddOrder);
            return AjaxResult.success();
        }
        zyjrJzgAddOrderService.insertZyjrJzgAddOrder(zyjrJzgAddOrder);
        return AjaxResult.success();
    }

    @GetMapping("/getPic/{transactionCode}")
    public AjaxResult as(@PathVariable("transactionCode") String transactionCode){
        ZyjrPic zyjrPic=new ZyjrPic();
        zyjrPic.setJinzhengu(transactionCode);
        List<ZyjrPic> zyjrPics = zyjrPicMapper.selectZyjrPicList(zyjrPic);
        return AjaxResult.success(zyjrPics);
    }

    @GetMapping("/get")
    public AjaxResult sd(String pid){
        if(pid!=null){
           List<cities> l= examineMapper.selectC(pid);
            List<valueVo> list=l.stream().map(provinces -> {
                valueVo valueVo=new valueVo();
                valueVo.setLabel(provinces.getCity());
                valueVo.setValue(provinces.getCityid());
                return valueVo;
            }).collect(Collectors.toList());
            return AjaxResult.success(list);
        }
        List<provinces> a=examineMapper.selectP();
        //Map<String,String> map=a.stream().collect(Collectors.toMap(provinces::getProvince,provinces::getProvinceid));
        List<valueVo> list=a.stream().map(provinces -> {
            valueVo valueVo=new valueVo();
            valueVo.setLabel(provinces.getProvince());
            valueVo.setValue(provinces.getProvinceid());
            return valueVo;
        }).collect(Collectors.toList());
        return AjaxResult.success(list);
    }

    @ApiOperation("11111111")
    @PostMapping("/ceshi")
    public AjaxResult ad(@RequestBody JingVo jingVo)  {
        ZyjrJzgAddOrder jzgorder=zyjrJzgAddOrderMapper.selectZyjrJzgAddOrderByTransactionCode(jingVo.getTransactionCode());
        ZyjrPhotoCar c=zyjrPhotoCarMapper.selectByT(jingVo.getTransactionCode());
        List<SysFileInfo> list = sysFileInfoMapper.photoCar(c.getId());
        ZyjrCarLoan a=zyjrCarLoanMapper.selectHandle(jingVo.getTransactionCode());
        Map<String,String> map=new HashMap<>();
        map.put("tokenId","177");
        map.put("programmeId","5");
        map.put("userId","18686");
        map.put("orderNum",a.getTransactionCode());
        map.put("vin",a.getVinCode());
        map.put("regionCodeStyle","1");
        map.put("provinceId",jingVo.getProvinceId());
        map.put("cityId",jingVo.getCityId());
        map.put("productType","1");
        List<jzgVo> jzgvo=new ArrayList<>();
        for (SysFileInfo sysFileInfo : list) {
            jzgVo jzg=new jzgVo();
            jzg.setImageUrl(sysFileInfo.getFilePath());
            jzg.setPartCode(Integer.parseInt(sysFileInfo.getFileName()));
            jzgvo.add(jzg);
        }

        JSONArray json3=new JSONArray().fromObject(jzgvo);
        map.put("imageList",json3.toString());
        map.put("orderName",jingVo.getOrderName());
        map.put("orderPhone",jingVo.getOrderPhone());
        // map.put("carLicense",a.getCarLicense());
        //map.put("service",a.getService());
        map.put("engineNum",a.getEngineCode());
        map.put("recordBrand",a.getBrand());
        // map.put("businessPrice",a.getBusinessPrice().toString());
        String sign=JzgUtil.getSign(map,"82CF76A1-3C3A-4E0B-9969-1789137982F5");
       /* Map<String,Object> maps=new HashMap<>();
        maps.putAll(map);
        maps.put("programmeId",4);
        maps.put("userId",18686);
        maps.put("provinceId",a.getProvinceId());
        maps.put("cityId",a.getCityId());*/
        map.put("sign",sign);

        /*  maps.put("businessPrice",a.getBusinessPrice());*/

        String results = HttpClientUtil.doPost("http://jcptapi.sandbox.jingzhengu.com/api/online/addOrder", map);
        if(jzgorder!=null){
            if(jzgorder.getData()!=null){
                AjaxResult json=new AjaxResult();
                json.put("code",400);
                json.put("msg", "操作多次（有记录）！！！");
                return json;
            }
        }else{
            if(results.substring(10,13).equals("100")){
                ZyjrJzgAddOrder zyjrJzgAddOrder=new ZyjrJzgAddOrder();
                zyjrJzgAddOrder.setUserId((long)66);
                zyjrJzgAddOrder.setTransactionCode(jingVo.getTransactionCode());
                zyjrJzgAddOrderMapper.insertZyjrJzgAddOrder(zyjrJzgAddOrder);
            }

        }
        return AjaxResult.success(results.substring(10,13),results.substring(20,results.length()-1));
    }

    @ApiOperation("11111111")
    @GetMapping("/select")
    public AjaxResult sel(String transactionCode) {
        ZyjrJzgAddOrder a=zyjrJzgAddOrderMapper.selectZyjrJzgAddOrderByTransactionCode(transactionCode);
        if(a!=null&&a.getData()!=null&&a.getData().split(":")[1].split(",")[0].equals("100")) {
            return  AjaxResult.success("操作成功",a.getData());
        }
        Map<String,String> map=new HashMap<>();
        map.put("tokenId","177");
        map.put("UserId","18686");
        map.put("OrderNum",transactionCode);
        String sign=JzgUtil.getSign(map,"82CF76A1-3C3A-4E0B-9969-1789137982F5");
        map.put("sign",sign);

        String results = HttpClientUtil.doPost("http://jcptapi.sandbox.jingzhengu.com/api/v2/onLineTask/getEighteenthTask", map);

        if(results.split(":")[1].split(",")[0].equals("100")){
            a.setData(results);
            zyjrJzgAddOrderMapper.updateZyjrJzgAddOrder(a);
        }

        return AjaxResult.success("操作成功",results);
    }



    public static Map<String, String> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, String> map = new HashMap<String,String>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            map.put(fieldName, String.valueOf(field.get(obj)));
        }
        return map;
    }
    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrJzgAddOrder zyjrJzgAddOrder)
    {
        return toAjax(zyjrJzgAddOrderService.updateZyjrJzgAddOrder(zyjrJzgAddOrder));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:order:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{vins}")
    public AjaxResult remove(@PathVariable Long[] vins)
    {
        return AjaxResult.success(zyjrJzgAddOrderService.deleteZyjrJzgAddOrderByIds(vins));
    }
}
