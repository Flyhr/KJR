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
import com.ruoyi.DocSys.domain.DocInfo;
import com.ruoyi.DocSys.service.IDocInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医生信息Controller
 *
 * @author ruoyi
 * @date 2025-03-31
 */
@RestController
@RequestMapping("/DocSys/Doc")
public class DocInfoController extends BaseController
{
    @Autowired
    private IDocInfoService docInfoService;

    /**
     * 查询医生信息列表
     */
//    @PreAuthorize("@ss.hasPermi('DocSys:Doc:list')")
//    @GetMapping("/list")
//    public TableDataInfo list(DocInfo docInfo)
//    {
//        startPage();
//        List<DocInfo> list = docInfoService.selectDocInfoList(docInfo);
//        return getDataTable(list);
//    }

    /**
     * 导出医生信息列表
     */
    @PreAuthorize("@ss.hasPermi('DocSys:Doc:export')")
    @Log(title = "医生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DocInfo docInfo)
    {
        List<DocInfo> list = docInfoService.selectDocInfoList(docInfo);
        ExcelUtil<DocInfo> util = new ExcelUtil<DocInfo>(DocInfo.class);
        util.exportExcel(response, list, "医生信息数据");
    }

    /**
     * 获取医生信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('DocSys:Doc:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(docInfoService.selectDocInfoByUserId(userId));
    }

    /**
     * 新增医生信息
     */
    @PreAuthorize("@ss.hasPermi('DocSys:Doc:add')")
    @Log(title = "医生信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DocInfo docInfo)
    {
        return toAjax(docInfoService.insertDocInfo(docInfo));
    }

    /**
     * 修改医生信息
     */
    @PreAuthorize("@ss.hasPermi('DocSys:Doc:edit')")
    @Log(title = "医生信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DocInfo docInfo)
    {
        return toAjax(docInfoService.updateDocInfo(docInfo));
    }

    /**
     * 删除医生信息
     */
    @PreAuthorize("@ss.hasPermi('DocSys:Doc:remove')")
    @Log(title = "医生信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(docInfoService.deleteDocInfoByUserIds(userIds));
    }
}
