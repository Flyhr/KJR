package com.ruoyi.DocSys.service;

import com.ruoyi.DocSys.domain.IntegratedHealthData;
import com.ruoyi.DocSys.domain.UserBasicInfo;

public interface IIntegratedHealthDataService {
    /**
     * 根据 userId 插入或更新设备数据
     */
    int upsertSensorData(IntegratedHealthData sensorData);
    /**
     * 根据 userId 删除设备数据
     */
    int deleteHealthDataByUserId(Long userId);


    /**
     * 根据 userId 插入或更新用户基础信息数据
     */
    int setUserBasicInfo(UserBasicInfo userBasicInfo);
}
