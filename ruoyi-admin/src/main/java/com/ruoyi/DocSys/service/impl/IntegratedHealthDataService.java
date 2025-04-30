package com.ruoyi.DocSys.service.impl;

import com.ruoyi.DocSys.domain.IntegratedHealthData;
import com.ruoyi.DocSys.domain.UserBasicInfo;
import com.ruoyi.DocSys.mapper.IntegratedHealthDataMapper;
import com.ruoyi.DocSys.service.IIntegratedHealthDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegratedHealthDataService implements IIntegratedHealthDataService {

    @Autowired
    private IntegratedHealthDataMapper sensorDataMapper;
//    @Autowired
//    private UserBasciInfoMapper userBasciInfoMapper;
    /**
     * 查询设备数据
     */
    public IntegratedHealthData selectLatestByUserId(Long userId) {
        return sensorDataMapper.selectLatestByUserId(userId);
    };

    /**
     * 插入或更新设备数据
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
    };

    /**
     * 删除设备数据
     */
    @Override
    public int deleteHealthDataByUserId(Long userId) {
        // 调用数据访问层方法，根据 userId 删除设备数据
        return sensorDataMapper.deleteHealthDataByUserId(userId);
    }
    /**-----------------------------------------
     * 查询用户基础数据
     */
    public UserBasicInfo selectUserBasicInfoByUserId(Long userId) {
        return sensorDataMapper.selectUserBasicInfoByUserId(userId);
    };
    /**
     * 插入或更新用户基础数据
     */
    @Override
    public int setUserBasicInfo(UserBasicInfo userBasicInfo) {
        // 根据 userId 判断是否存在设备数据
        UserBasicInfo existing = sensorDataMapper.selectUserBasicInfoByUserId(userBasicInfo.getId());
        if (existing != null) {
            // 已存在则更新数据
            return sensorDataMapper.updateUserBasicInfo(userBasicInfo);
        } else {
            // 不存在则插入新记录
            return sensorDataMapper.insertUserBasicInfo(userBasicInfo);
        }
    };
}
