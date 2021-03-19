package com.jeethink.system.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeethink.common.utils.file.FileUploadUtils;
import com.jeethink.system.domain.*;
import com.jeethink.system.mapper.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jeethink.common.annotation.Log;
import com.jeethink.common.core.controller.BaseController;
import com.jeethink.common.core.domain.AjaxResult;
import com.jeethink.common.enums.BusinessType;
import com.jeethink.system.service.IZyjrCaiwuService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-03-18
 */
@RestController
@RequestMapping("/system/caiwu")
public class ZyjrCaiwuController extends BaseController
{
    @Autowired
    private IZyjrCaiwuService zyjrCaiwuService;
    @Autowired
    private ZyjrBusinessMapper zyjrBusinessMapper;
    @Autowired
    private ExamineMapper examineMapper;
    @Autowired
    private ZyjrCarLoanMapper zyjrCarLoanMapper;
    @Autowired
    private ExamineController examineController;
    @Autowired
    private ZyjrDaiqianAccoutMapper zyjrDaiqianAccoutMapper;
    @Autowired
    private ZyjrCarAccountMapper zyjrCarAccountMapper;
    @Autowired
    private ZyjrCarMapper zyjrCarMapper;
    @Autowired
    private ZyjrPicMapper zyjrPicMapper;
    @Autowired
    private ZyjrCaiwuMapper zyjrCaiwuMapper;

    /**
     * 查询【请填写功能名称】列表
     */
    @GetMapping("/list")
    public TableDataInfo list(ZyjrCaiwu zyjrCaiwu)
    {
        startPage();
        List<ZyjrCaiwu> list = zyjrCaiwuService.selectZyjrCaiwuList(zyjrCaiwu);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:caiwu:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrCaiwu zyjrCaiwu)
    {
        List<ZyjrCaiwu> list = zyjrCaiwuService.selectZyjrCaiwuList(zyjrCaiwu);
        ExcelUtil<ZyjrCaiwu> util = new ExcelUtil<ZyjrCaiwu>(ZyjrCaiwu.class);
        return util.exportExcel(list, "caiwu");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("transactionCode") String transactionCode)
    {
        ZyjrBusiness business = zyjrBusinessMapper.selectById(transactionCode);
        ZyjrStartPage byStarts = examineMapper.findByStarts(transactionCode);
        ZyjrCarLoan zyjrCarLoan = zyjrCarLoanMapper.selectHandle(transactionCode);
        AjaxResult ajaxResult = examineController.countGrant(transactionCode);
        ZyjrDaiqianAccout zyjrDaiqianAccout = zyjrDaiqianAccoutMapper.selectById(transactionCode);
        ZyjrCar zyjrCar = zyjrCarMapper.selectZyjrCarById(Long.parseLong(zyjrDaiqianAccout.getCarid()));
        ZyjrCarAccount zyjrCarAccount=new ZyjrCarAccount();
        zyjrCarAccount.setZyjrCarId(zyjrDaiqianAccout.getCarid());
        List<ZyjrCarAccount> zyjrCarAccounts = zyjrCarAccountMapper.selectZyjrCarAccountList(zyjrCarAccount);
        ZyjrCaiwu zyjrCaiwu=zyjrCaiwuMapper.selectZyjrCaiwuByT(transactionCode);

        Object data = ajaxResult.get("data");
        Map<String,Object> map=new HashMap<>();
        map.put("xiaoshoutuandui",business.getTeam());
        map.put("quyu",byStarts.getBusinessPlace());
        map.put("shenpileixing",zyjrCarLoan.getApprovalType());
        map.put("shoukuandanwei",zyjrCar.getDealerName());
        map.put("data",data);
        map.put("shoukuandanwei",zyjrDaiqianAccout.getCarname());
        map.put("zhanghu",zyjrCarAccounts);
        map.put("cheliangleixing",zyjrCarLoan.getCheliangleixing());
        map.put("yewuquyu",zyjrCar.getArea());
        map.put("fenqiqishu",business.getRepayPeriod());
        map.put("pic",null);
        if(zyjrCaiwu!=null){
            ZyjrPic zyjrPic=new ZyjrPic();
            zyjrPic.setCaiwu(zyjrCaiwu.getId().toString());
            List<ZyjrPic> zyjrPics = zyjrPicMapper.selectZyjrPicList(zyjrPic);
            map.put("pic",zyjrPics);
        }




        return AjaxResult.success(map);
    }

    /**
     * 新增【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrCaiwu zyjrCaiwu)
    {
        zyjrCaiwuService.insertZyjrCaiwu(zyjrCaiwu);
        return AjaxResult.success(zyjrCaiwu.getId());
    }
    @RequestMapping(value = {"/ceshi2"}, method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult ceshi(@RequestParam("name") String name, @RequestParam("file") MultipartFile file, @RequestParam("id") String id) throws IOException {
            String a = FileUploadUtils.upload(file);
            String as = "http://114.215.186.186:8080"+ a;
            ZyjrPic zyjrPic=new ZyjrPic();
            zyjrPic.setCaiwu(id);
            zyjrPic.setFilePath(as);
            zyjrPic.setFileName(name);
        zyjrPicMapper.insertZyjrPic(zyjrPic);

        return AjaxResult.success();
    }

    /**
     * 修改【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrCaiwu zyjrCaiwu)
    {
        return toAjax(zyjrCaiwuService.updateZyjrCaiwu(zyjrCaiwu));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrCaiwuService.deleteZyjrCaiwuByIds(ids));
    }
}
