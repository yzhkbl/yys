package com.jeethink.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jeethink.system.domain.ZyjrDaiqian;
import com.jeethink.system.domain.vo.UserVo;
import com.jeethink.system.mapper.ExamineMapper;
import com.jeethink.system.mapper.ZyjrAllowBasicsMapper;
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
import com.jeethink.system.domain.ZyjrAllowBasics;
import com.jeethink.system.service.IZyjrAllowBasicsService;
import com.jeethink.common.utils.poi.ExcelUtil;
import com.jeethink.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author jeethink
 * @date 2020-12-22
 */
@RestController
@RequestMapping("/system/basics")
public class ZyjrAllowBasicsController extends BaseController
{
    @Autowired
    private IZyjrAllowBasicsService zyjrAllowBasicsService;
    @Autowired
    private ZyjrAllowBasicsMapper zyjrAllowBasicsMapper;
    @Autowired
    private ExamineMapper examineMapper;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:basics:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZyjrAllowBasics zyjrAllowBasics)
    {
        startPage();
        List<ZyjrAllowBasics> list = zyjrAllowBasicsService.selectZyjrAllowBasicsList(zyjrAllowBasics);
        return getDataTable(list);
    }

    @GetMapping("/lists")
    public TableDataInfo lists(ZyjrDaiqian zyjrAllowBasics)
    {
        startPage();
        List<ZyjrDaiqian> list = examineMapper.selectAllList(zyjrAllowBasics);
        return getDataTable(list);
    }
    @GetMapping("/get/{transactionCode}")
    public AjaxResult gets(@PathVariable("transactionCode") String transactionCode)
    {
        Map<String,Object> map=zyjrAllowBasicsService.selectByMap(transactionCode);
        return AjaxResult.success(map);
    }
    @PostMapping("/get/user")
    public AjaxResult getuser(@RequestBody UserVo userVo){
        if(userVo.getUserId()==null){
            examineMapper.updateByDaiqians(userVo);

            return AjaxResult.success();
        }
        ZyjrDaiqian zyjrDaiqian = examineMapper.selDaiqianById(userVo.getId());
        if(zyjrDaiqian!=null&&zyjrDaiqian.getUserId()!=null){
            if(zyjrDaiqian.getUserId().equals(userVo.getUserId())){
                return AjaxResult.success();
            }
                AjaxResult json=new AjaxResult();
            json.put("code", 400);
            json.put("msg", "手慢了，下次再快点！！！");
            return json;
        }
        examineMapper.updateByDaiqians(userVo);

        return AjaxResult.success();
    }


    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:basics:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZyjrAllowBasics zyjrAllowBasics)
    {
        List<ZyjrAllowBasics> list = zyjrAllowBasicsService.selectZyjrAllowBasicsList(zyjrAllowBasics);
        ExcelUtil<ZyjrAllowBasics> util = new ExcelUtil<ZyjrAllowBasics>(ZyjrAllowBasics.class);
        return util.exportExcel(list, "basics");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:basics:query')")
    @GetMapping(value = "/{userId}/{transactionCode}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId,@PathVariable("transactionCode") String transactionCode)
    {
        ZyjrAllowBasics zyjrAllowBasics = zyjrAllowBasicsService.selectZyjrAllowBasicsById(userId, transactionCode);
            return AjaxResult.success(zyjrAllowBasics);

    }

    /**
     * 新增【请填写功能名称】
     */
    //@PreAuthorize("@ss.hasPermi('system:basics:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(ZyjrAllowBasics zyjrAllowBasics)
    {
        return toAjax(zyjrAllowBasicsService.insertZyjrAllowBasics(zyjrAllowBasics));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:basics:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZyjrAllowBasics zyjrAllowBasics)
    {
        return toAjax(zyjrAllowBasicsService.updateZyjrAllowBasics(zyjrAllowBasics));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:basics:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zyjrAllowBasicsService.deleteZyjrAllowBasicsByIds(ids));
    }
}
