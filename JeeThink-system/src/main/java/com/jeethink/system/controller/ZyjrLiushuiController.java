package com.jeethink.system.controller;

import java.util.ArrayList;
import java.util.List;

import com.jeethink.common.utils.file.FileUtils;
import com.jeethink.system.domain.ZyjrGrantPhoto;
import com.jeethink.system.domain.ZyjrGrantVisit;
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
import com.jeethink.system.domain.ZyjrLiushui;
import com.jeethink.system.service.IZyjrLiushuiService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-02-25
 */
@RestController
@RequestMapping("/system/liushui")
public class ZyjrLiushuiController extends BaseController
{
    @Autowired
    private IZyjrLiushuiService zyjrLiushuiService;
    @Autowired
    private ZyjrGrantPhotoMapper zyjrGrantPhotoMapper;

    @PostMapping("/pic")
    @ApiOperation("111111111")
    public AjaxResult testFiles(fileInfoVo q) {
        JSONArray jsonarray = JSONArray.fromObject(q.getLiushuiPhoto());
        // System.out.println(jsonarray);
        ZyjrLiushui zyjrLiushui = new ZyjrLiushui();
        List<ZyjrGrantPhoto> list = (List)JSONArray.toList(jsonarray, ZyjrGrantPhoto.class);
        if (q.getLiushuiId() != null) {
            ZyjrGrantPhoto infos = new ZyjrGrantPhoto();
            infos.setLiushuiId(q.getLiushuiId());
            List<ZyjrGrantPhoto> zyjrGrantPhotos = zyjrGrantPhotoMapper.selectZyjrGrantPhotoList(infos);
            int a = zyjrGrantPhotoMapper.deleteByLiushui(q.getLiushuiId());
            String paths = "C:/demo";
            //System.err.println(path);
            //int a = sysFileInfoMapper.deleteSysFileInfoByPath(path);
            for (ZyjrGrantPhoto zyjrGrantPhoto :zyjrGrantPhotos) {
                String[] s = zyjrGrantPhoto.getFilePath().split("//");
                String l = zyjrGrantPhoto.getFilePath().substring(zyjrGrantPhoto.getFilePath().indexOf("e"));
                // System.err.println("删除路径"+paths+l);
                boolean b = FileUtils.deleteFile(paths +l);
            }
            zyjrLiushui.setOrderState(q.getOrderState());
            zyjrLiushui.setTransactionCode(q.getTransactionCode());
            zyjrLiushui.setUserId(q.getUserId());
            zyjrLiushuiService.updateZyjrLiushui(zyjrLiushui);
        } else {

            zyjrLiushui.setOrderState(q.getOrderState());
            zyjrLiushui.setTransactionCode(q.getTransactionCode());
            zyjrLiushui.setUserId(q.getUserId());
            zyjrLiushuiService.insertZyjrLiushui(zyjrLiushui);

        }
        List<String> pic = new ArrayList<>();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                //String asd = androidUpload.upload(list.get(i).getFilePath());
                ZyjrGrantPhoto info = new ZyjrGrantPhoto();
                //String as = "http://192.168.31.86:8080" + asd;
                info.setFilePath(list.get(i).getFilePath());
                if(q.getLiushuiId()!=null){
                    info.setLiushuiId(q.getLiushuiId());
                }else{
                    info.setLiushuiId(zyjrLiushui.getId());
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
    public GrantPhoto findPhoto(@PathVariable("transactionCode") String transactionCode)
    {
        ZyjrLiushui zyjrLiushui = zyjrLiushuiService.selectZyjrLiushuiById(transactionCode);
        GrantPhoto f = new GrantPhoto();
        if(zyjrLiushui != null) {
            List<ZyjrGrantPhoto> list = zyjrGrantPhotoMapper.findLiushui(zyjrLiushui.getId());

            f.setId(zyjrLiushui.getId());
            f.setUserId(zyjrLiushui.getUserId());
            f.setTransactionCode(zyjrLiushui.getTransactionCode());
            //f.setOrderState(zyjrPhotoHouse.getOrderState());
            f.setPhotoFile(list);
            return f;
        }else {
            return f;
        }
    }


    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:liushui:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrLiushui zyjrLiushui)
    {
        startPage();
        List<ZyjrLiushui> list = zyjrLiushuiService.selectZyjrLiushuiList(zyjrLiushui);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:liushui:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrLiushui zyjrLiushui)
    {
        List<ZyjrLiushui> list = zyjrLiushuiService.selectZyjrLiushuiList(zyjrLiushui);
        ExcelUtil<ZyjrLiushui> util = new ExcelUtil<ZyjrLiushui>(ZyjrLiushui.class);
        return util.exportExcel(list, "liushui");
    }

    /**
     * 获取【请填写功能名称】详细信息

    @PreAuthorize("@ss.hasPermi('system:liushui:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrLiushuiService.selectZyjrLiushuiById(id));
    }*/

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:liushui:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrLiushui zyjrLiushui)
    {
        return toAjax(zyjrLiushuiService.insertZyjrLiushui(zyjrLiushui));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:liushui:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrLiushui zyjrLiushui)
    {
        return toAjax(zyjrLiushuiService.updateZyjrLiushui(zyjrLiushui));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:liushui:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrLiushuiService.deleteZyjrLiushuiByIds(ids));
    }
}
