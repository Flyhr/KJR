package com.ruoyi.DocSys.service;

import com.ruoyi.DocSys.domain.IntegratedHealthData;

public interface IIntegratedHealthDataService {
    /**
     * 根据 userId 插入或更新设备数据
     */
    int upsertSensorData(IntegratedHealthData sensorData);
}
