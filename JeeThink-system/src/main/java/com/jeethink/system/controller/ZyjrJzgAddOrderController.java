package com.jeethink.system.controller;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeethink.common.utils.StringUtils;
import com.jeethink.common.utils.http.HttpUtils;
import com.jeethink.system.domain.ZyjrDaihouBaoxian;
import com.jeethink.system.domain.ZyjrPic;
import com.jeethink.system.mapper.ZyjrJzgAddOrderMapper;
import com.jeethink.system.mapper.ZyjrPicMapper;
import com.jeethink.system.service.IZyjrJzgAddOrderService;
import com.jeethink.system.util.HttpClientUtil;
import com.jeethink.system.util.HttpPostUtil;
import com.jeethink.system.util.JzgUtil;
import com.rsa.RSASignature;
import com.rsa.RSAUtil;
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
import com.jeethink.system.domain.ZyjrJzgAddOrder;
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
        if(zyjrJzgAddOrder.getPic()!=null) {
            JSONArray jsonarray = JSONArray.fromObject(zyjrJzgAddOrder.getPic());
            System.out.println(jsonarray);
            List<ZyjrPic> list = (List) JSONArray.toList(jsonarray, ZyjrDaihouBaoxian.class);
            for (ZyjrPic zyjrPic : list) {
                zyjrPic.setJinzhengu(zyjrJzgAddOrder.getTransactionCode());
                zyjrPicMapper.insertZyjrPic(zyjrPic);
            }
        }
        return toAjax(zyjrJzgAddOrderService.insertZyjrJzgAddOrder(zyjrJzgAddOrder));
    }

    @ApiOperation("11111111")
    @GetMapping("/ceshi")
    public AjaxResult ad(String transactionCode)  {

        ZyjrJzgAddOrder a=zyjrJzgAddOrderMapper.selectZyjrJzgAddOrderByTransactionCode(transactionCode);
        Map<String,String> map=new HashMap<>();
        map.put("tokenId","177");
        map.put("programmeId","4");
        map.put("userId","18686");
        map.put("orderNum",a.getTransactionCode());
        map.put("vin",a.getVin());
        map.put("regionCodeStyle",a.getRegionCodeStyle());
        map.put("provinceId",a.getProvinceId().toString());
        map.put("cityId",a.getCityId().toString());
        map.put("productType",a.getProductType());
        map.put("imageList",a.getImageList());
        System.err.println(a.getImageList());
        map.put("orderName",a.getOrderName());
        map.put("orderPhone",a.getOrderPhone());
        map.put("carLicense",a.getCarLicense());
        map.put("service",a.getService());
        map.put("engineNum",a.getEngineNum().toString());
        map.put("recordBrand",a.getRecordBrand());
        map.put("businessPrice",a.getBusinessPrice().toString());
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
        return AjaxResult.success(results);
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
