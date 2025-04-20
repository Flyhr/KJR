package com.ruoyi.DocSys.controller;

import com.ruoyi.DocSys.domain.IntegratedHealthData;
import com.ruoyi.DocSys.service.IntegratedHealthDataService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/healthData")
public class IntegratedHealthDataController {

    @Autowired
    private IntegratedHealthDataService healthDataService;

    @GetMapping("/latest")
    public AjaxResult getLatestHealthData(@RequestParam("user_id") Long user_id) {
        IntegratedHealthData data = healthDataService.selectLatestByUserId(user_id);
        if(data != null){
            return AjaxResult.success(data);
        }
        return AjaxResult.error("暂无数据");
    }}
