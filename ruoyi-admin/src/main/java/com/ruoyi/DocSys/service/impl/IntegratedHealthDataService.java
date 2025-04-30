package com.ruoyi.DocSys.service.impl;

import com.ruoyi.DocSys.domain.IntegratedHealthData;
import com.ruoyi.DocSys.mapper.IntegratedHealthDataMapper;
import com.ruoyi.DocSys.service.IIntegratedHealthDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegratedHealthDataService implements IIntegratedHealthDataService {

    @Autowired
    private IntegratedHealthDataMapper sensorDataMapper;
    /**
     * 查询设备数据
     */
    public IntegratedHealthData selectLatestByUserId(Long userId) {
        return sensorDataMapper.selectLatestByUserId(userId);
    };
    /**
     * 插入设备数据
     */
    @Override
    public int upsertSensorData(IntegratedHealthData sensorData) {
        // 根据 userId 判断是否存在设备数据
        IntegratedHealthData existing = sensorDataMapper.selectLatestByUserId(sensorData.getUserId());
        if (existing != null) {
            // 已存在则更新数据
            return sensorDataMapper.updateSensorData(sensorData);
        } else {
            // 不存在则插入新记录
            return sensorDataMapper.insertSensorData(sensorData);
        }
    }
}
