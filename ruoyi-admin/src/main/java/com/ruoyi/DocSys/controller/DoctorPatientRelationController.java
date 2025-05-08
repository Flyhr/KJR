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
import com.ruoyi.DocSys.domain.DoctorPatientRelation;
import com.ruoyi.DocSys.service.IDoctorPatientRelationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医生患者关系Controller
 *
 * @author ruoyi
 * @date 2025-03-31
 */
@RestController
@RequestMapping("/DocSys/relation")
public class DoctorPatientRelationController extends BaseController
{
    @Autowired
    private IDoctorPatientRelationService doctorPatientRelationService;

    /**
     * 查询医生患者关系列表
     */
//    @PreAuthorize("@ss.hasPermi('DocSys:relation:list')")
//    @GetMapping("/list")
//    public TableDataInfo list(DoctorPatientRelation doctorPatientRelation)
//    {
//        startPage();
//        List<DoctorPatientRelation> list = doctorPatientRelationService.selectDoctorPatientRelationList(doctorPatientRelation);
//        return getDataTable(list);
//    }

    /**
     * 导出医生患者关系列表
     */
    @PreAuthorize("@ss.hasPermi('DocSys:relation:export')")
    @Log(title = "医生患者关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DoctorPatientRelation doctorPatientRelation)
    {
        List<DoctorPatientRelation> list = doctorPatientRelationService.selectDoctorPatientRelationList(doctorPatientRelation);
        ExcelUtil<DoctorPatientRelation> util = new ExcelUtil<DoctorPatientRelation>(DoctorPatientRelation.class);
        util.exportExcel(response, list, "医生患者关系数据");
    }

    /**
     * 获取医生患者关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('DocSys:relation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(doctorPatientRelationService.selectDoctorPatientRelationById(id));
    }

    /**
     * 新增医生患者关系
     */
    @PreAuthorize("@ss.hasPermi('DocSys:relation:add')")
    @Log(title = "医生患者关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DoctorPatientRelation doctorPatientRelation)
    {
        return toAjax(doctorPatientRelationService.insertDoctorPatientRelation(doctorPatientRelation));
    }

    /**
     * 修改医生患者关系
     */
    @PreAuthorize("@ss.hasPermi('DocSys:relation:edit')")
    @Log(title = "医生患者关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DoctorPatientRelation doctorPatientRelation)
    {
        return toAjax(doctorPatientRelationService.updateDoctorPatientRelation(doctorPatientRelation));
    }

    /**
     * 删除医生患者关系
     */
    @PreAuthorize("@ss.hasPermi('DocSys:relation:remove')")
    @Log(title = "医生患者关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(doctorPatientRelationService.deleteDoctorPatientRelationByIds(ids));
    }
}
