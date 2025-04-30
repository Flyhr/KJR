package com.ruoyi.DocSys.controller;

import com.ruoyi.DocSys.domain.IntegratedHealthData;
import com.ruoyi.DocSys.service.impl.IntegratedHealthDataService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/healthData")
public class IntegratedHealthDataController {

    @Autowired
    private IntegratedHealthDataService healthDataService;
    /**
     * 查询设备数据
     */
    @GetMapping("/getData")
    public AjaxResult getLatestHealthData(@RequestParam("user_id") Long user_id) {
        IntegratedHealthData data = healthDataService.selectLatestByUserId(user_id);
        if(data != null){
            return AjaxResult.success(data);
        }
        return AjaxResult.error("暂无数据");
    };
    /**
     * 存储设备数据
     * 使用 POST 方法接收设备数据，根据 userId 执行更新或插入操作
     */
    @PostMapping("/setData")
    public AjaxResult upsertSensorData(@RequestBody IntegratedHealthData sensorData) {
        System.out.println(sensorData);
        int rows = healthDataService.upsertSensorData(sensorData);
        if (rows > 0) {
            return AjaxResult.success("操作成功");
        }
        return AjaxResult.error("操作失败");
    }
}
