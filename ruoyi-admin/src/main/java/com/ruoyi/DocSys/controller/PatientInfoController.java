package com.ruoyi.DocSys.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.DocSys.domain.PatientInfo;
import com.ruoyi.DocSys.service.IPatientInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 患者信息Controller
 * 
 * @author ruoyi
 * @date 2025-03-31
 */
@RestController
@RequestMapping("/DocSys/PatSysinfo")
public class PatientInfoController extends BaseController
{
    @Autowired
    private IPatientInfoService patientInfoService;

    /**
     * 查询患者信息列表
     */
    @PreAuthorize("@ss.hasPermi('DocSys:PatSysinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(PatientInfo patientInfo)
    {
        startPage();
        List<PatientInfo> list = patientInfoService.selectPatientInfoList(patientInfo);
        return getDataTable(list);
    }

    /**
     * 导出患者信息列表
     */
    @PreAuthorize("@ss.hasPermi('DocSys:PatSysinfo:export')")
    @Log(title = "患者信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PatientInfo patientInfo)
    {
        List<PatientInfo> list = patientInfoService.selectPatientInfoList(patientInfo);
        ExcelUtil<PatientInfo> util = new ExcelUtil<PatientInfo>(PatientInfo.class);
        util.exportExcel(response, list, "患者信息数据");
    }

    /**
     * 获取患者信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('DocSys:PatSysinfo:query')")
    @GetMapping(value = "/{patId}")
    public AjaxResult getInfo(@PathVariable("patId") Long patId)
    {
        return success(patientInfoService.selectPatientInfoByPatId(patId));
    }

    /**
     * 新增患者信息
     */
    @PreAuthorize("@ss.hasPermi('DocSys:PatSysinfo:add')")
    @Log(title = "患者信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PatientInfo patientInfo)
    {
        return toAjax(patientInfoService.insertPatientInfo(patientInfo));
    }

    /**
     * 修改患者信息
     */
    @PreAuthorize("@ss.hasPermi('DocSys:PatSysinfo:edit')")
    @Log(title = "患者信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PatientInfo patientInfo)
    {
        return toAjax(patientInfoService.updatePatientInfo(patientInfo));
    }

    /**
     * 删除患者信息
     */
    @PreAuthorize("@ss.hasPermi('DocSys:PatSysinfo:remove')")
    @Log(title = "患者信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{patIds}")
    public AjaxResult remove(@PathVariable Long[] patIds)
    {
        return toAjax(patientInfoService.deletePatientInfoByPatIds(patIds));
    }
}
