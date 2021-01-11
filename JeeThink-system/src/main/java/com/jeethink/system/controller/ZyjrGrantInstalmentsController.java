package com.jeethink.system.controller;

import java.util.ArrayList;
import java.util.List;

import com.jeethink.common.utils.file.FileUtils;
import com.jeethink.system.domain.ZyjrGrantImage;
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
import com.jeethink.system.domain.ZyjrGrantInstalments;
import com.jeethink.system.service.IZyjrGrantInstalmentsService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2021-01-09
 */
@RestController
@RequestMapping("/system/instalments")
public class ZyjrGrantInstalmentsController extends BaseController
{
    @Autowired
    private IZyjrGrantInstalmentsService zyjrGrantInstalmentsService;
    @Autowired
    private ZyjrGrantPhotoMapper zyjrGrantPhotoMapper;

    @PostMapping("/pic")
    @ApiOperation("111111111")
    public AjaxResult testFiles(fileInfoVo q) {
        JSONArray jsonarray = JSONArray.fromObject(q.getPhotoFile());
        System.out.println(jsonarray);
        ZyjrGrantInstalments zyjrGrantInstalments = new ZyjrGrantInstalments();
        List<ZyjrGrantPhoto> list = (List)JSONArray.toList(jsonarray, ZyjrGrantPhoto.class);
        if (q.getId() != null) {
            ZyjrGrantPhoto infos = new ZyjrGrantPhoto();
            infos.setInstalmentsId(q.getId());
            List<ZyjrGrantPhoto> zyjrGrantPhotos = zyjrGrantPhotoMapper.selectZyjrGrantPhotoList(infos);
            int a = zyjrGrantPhotoMapper.deleteByInstalments(q.getId());
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
            zyjrGrantInstalments.setTransactionCode(q.getTransactionCode());
            zyjrGrantInstalments.setUserId(q.getUserId());
            zyjrGrantInstalmentsService.insertZyjrGrantInstalments(zyjrGrantInstalments);

        }
        List<String> pic = new ArrayList<>();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                //String asd = androidUpload.upload(list.get(i).getFilePath());
                ZyjrGrantPhoto info = new ZyjrGrantPhoto();
                //String as = "http://192.168.31.86:8080" + asd;
                info.setFilePath(list.get(i).getFilePath());
                if(q.getId()!=null){
                    info.setInstalmentsId(q.getId());
                }else{
                    info.setInstalmentsId(zyjrGrantInstalments.getId());
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
        ZyjrGrantInstalments zyjrGrantInstalments = zyjrGrantInstalmentsService.selectZyjrGrantInstalmentsById(transactionCode);
        GrantPhoto f = new GrantPhoto();
        if(zyjrGrantInstalments != null) {
            List<ZyjrGrantPhoto> list = zyjrGrantPhotoMapper.findInstalments(zyjrGrantInstalments.getId());

            f.setId(zyjrGrantInstalments.getId());
            f.setUserId(zyjrGrantInstalments.getUserId());
            f.setTransactionCode(zyjrGrantInstalments.getTransactionCode());
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
    @PreAuthorize("@ss.hasPermi('system:instalments:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrGrantInstalments zyjrGrantInstalments)
    {
        startPage();
        List<ZyjrGrantInstalments> list = zyjrGrantInstalmentsService.selectZyjrGrantInstalmentsList(zyjrGrantInstalments);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:instalments:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrGrantInstalments zyjrGrantInstalments)
    {
        List<ZyjrGrantInstalments> list = zyjrGrantInstalmentsService.selectZyjrGrantInstalmentsList(zyjrGrantInstalments);
        ExcelUtil<ZyjrGrantInstalments> util = new ExcelUtil<ZyjrGrantInstalments>(ZyjrGrantInstalments.class);
        return util.exportExcel(list, "instalments");
    }

    /**
     * 获取【请填写功能名称】详细信息

    @PreAuthorize("@ss.hasPermi('system:instalments:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zyjrGrantInstalmentsService.selectZyjrGrantInstalmentsById(id));
    }*/

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:instalments:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZyjrGrantInstalments zyjrGrantInstalments)
    {
        return toAjax(zyjrGrantInstalmentsService.insertZyjrGrantInstalments(zyjrGrantInstalments));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:instalments:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrGrantInstalments zyjrGrantInstalments)
    {
        return toAjax(zyjrGrantInstalmentsService.updateZyjrGrantInstalments(zyjrGrantInstalments));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:instalments:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrGrantInstalmentsService.deleteZyjrGrantInstalmentsByIds(ids));
    }
}
