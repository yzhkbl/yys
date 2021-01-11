package com.jeethink.system.controller;

import java.util.ArrayList;
import java.util.List;

import com.jeethink.common.utils.file.FileUtils;
import com.jeethink.system.domain.ZyjrGrantInstalments;
import com.jeethink.system.domain.ZyjrGrantPhoto;
import com.jeethink.system.domain.vo.GrantPhoto;
import com.jeethink.system.domain.vo.fileInfoVo;
import com.jeethink.system.mapper.ZyjrGrantPhotoMapper;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
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
import com.jeethink.system.domain.ZyjrGrantVisit;
import com.jeethink.system.service.IZyjrGrantVisitService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-09
 */
@RestController
@RequestMapping("/system/visit")
public class ZyjrGrantVisitController extends BaseController
{
    @Autowired
    private IZyjrGrantVisitService zyjrGrantVisitService;
    @Autowired
    private ZyjrGrantPhotoMapper zyjrGrantPhotoMapper;

    @PostMapping("/pic")
    @ApiOperation("111111111")
    public AjaxResult testFiles(fileInfoVo q) {
        JSONArray jsonarray = JSONArray.fromObject(q.getPhotoFile());
        System.out.println(jsonarray);
        ZyjrGrantVisit zyjrGrantVisit = new ZyjrGrantVisit();
        List<ZyjrGrantPhoto> list = (List)JSONArray.toList(jsonarray, ZyjrGrantPhoto.class);
        if (q.getId() != null) {
            ZyjrGrantPhoto infos = new ZyjrGrantPhoto();
            infos.setVisitId(q.getId());
            List<ZyjrGrantPhoto> zyjrGrantPhotos = zyjrGrantPhotoMapper.selectZyjrGrantPhotoList(infos);
            int a = zyjrGrantPhotoMapper.deleteByVisit(q.getId());
            String paths = "C:/demo";
            //System.err.println(path);
            //int a = sysFileInfoMapper.deleteSysFileInfoByPath(path);
            for (ZyjrGrantPhoto zyjrGrantPhoto :zyjrGrantPhotos) {
                String[] s = zyjrGrantPhoto.getFilePath().split("//");
                String l = zyjrGrantPhoto.getFilePath().substring(33);
                System.err.println("删除路径"+paths+l);
                boolean b = FileUtils.deleteFile(paths +l);
            }
        } else {

            //zyjrPhotoHouse.setOrderState(q.getOrderState());
            zyjrGrantVisit.setTransactionCode(q.getTransactionCode());
            zyjrGrantVisit.setUserId(q.getUserId());
            zyjrGrantVisitService.insertZyjrGrantVisit(zyjrGrantVisit);

        }
        List<String> pic = new ArrayList<>();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                //String asd = androidUpload.upload(list.get(i).getFilePath());
                ZyjrGrantPhoto info = new ZyjrGrantPhoto();
                //String as = "http://192.168.31.86:8080" + asd;
                info.setFilePath(list.get(i).getFilePath());
                if(q.getId()!=null){
                    info.setVisitId(q.getId());
                }else{
                    info.setVisitId(zyjrGrantVisit.getId());
                }
                info.setFileName(list.get(i).getFileName());
                int ceshi = zyjrGrantPhotoMapper.insertZyjrGrantPhoto(info);
                if (ceshi < 1) {
                    return AjaxResult.error();
                }
                pic.add(info.getFilePath());
            }
        }
        return AjaxResult.success(pic);
    }



    /**图片信息回显*/
    //@PreAuthorize("@ss.hasPermi('system:car:query')")
    @GetMapping(value = "/{transactionCode}")
    public AjaxResult findPhoto(@PathVariable("transactionCode") String transactionCode)
    {
        ZyjrGrantVisit zyjrGrantVisit = zyjrGrantVisitService.selectZyjrGrantVisitById(transactionCode);
        GrantPhoto f = new GrantPhoto();
        if(zyjrGrantVisit != null) {
            List<ZyjrGrantPhoto> list = zyjrGrantPhotoMapper.findVisit(zyjrGrantVisit.getId());

            f.setId(zyjrGrantVisit.getId());
            f.setUserId(zyjrGrantVisit.getUserId());
            f.setTransactionCode(zyjrGrantVisit.getTransactionCode());
            //f.setOrderState(zyjrPhotoHouse.getOrderState());
            f.setPhotoFile(list);
            return AjaxResult.success(f);
        }else {
            return AjaxResult.success(f);
        }
    }





    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:visit:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrGrantVisit zyjrGrantVisit)
    {
        startPage();
        List<ZyjrGrantVisit> list = zyjrGrantVisitService.selectZyjrGrantVisitList(zyjrGrantVisit);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:visit:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrGrantVisit zyjrGrantVisit)
    {
        List<ZyjrGrantVisit> list = zyjrGrantVisitService.selectZyjrGrantVisitList(zyjrGrantVisit);
        ExcelUtil<ZyjrGrantVisit> util = new ExcelUtil<ZyjrGrantVisit>(ZyjrGrantVisit.class);
        return util.exportExcel(list, "visit");
    }

    /**
     * 获取【请填写功能名称】详细信息

    @PreAuthorize("@ss.hasPermi('system:visit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrGrantVisitService.selectZyjrGrantVisitById(id));
    }*/

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:visit:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrGrantVisit zyjrGrantVisit)
    {
        return toAjax(zyjrGrantVisitService.insertZyjrGrantVisit(zyjrGrantVisit));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:visit:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrGrantVisit zyjrGrantVisit)
    {
        return toAjax(zyjrGrantVisitService.updateZyjrGrantVisit(zyjrGrantVisit));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:visit:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrGrantVisitService.deleteZyjrGrantVisitByIds(ids));
    }
}
