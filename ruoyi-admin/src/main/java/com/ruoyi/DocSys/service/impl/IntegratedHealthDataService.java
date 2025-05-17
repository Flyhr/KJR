package com.ruoyi.DocSys.service.impl;

import com.ruoyi.DocSys.domain.DoctorPatientRelation;
import com.ruoyi.DocSys.domain.IntegratedHealthData;
import com.ruoyi.DocSys.domain.UserBasicInfo;
import com.ruoyi.DocSys.mapper.IntegratedHealthDataMapper;
import com.ruoyi.DocSys.service.IIntegratedHealthDataService;
import com.ruoyi.common.core.domain.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegratedHealthDataService implements IIntegratedHealthDataService {

    @Autowired
    private IntegratedHealthDataMapper sensorDataMapper;
//    @Autowired
//    private UserBasciInfoMapper userBasciInfoMapper;
    /**
     * 患者：根据患者id查询医生关系表
     */
    public DoctorPatientRelation getDoctorRelationByUserId(Long userId) {
        return sensorDataMapper.getDoctorRelationByUserId(userId);
    };
    /**
     * 医生：根据医生id查询对应医生关系表
     */
    public DoctorPatientRelation getPatientRelationByUserId(Long docId) {
        return sensorDataMapper.getPatientRelationByUserId(docId);
    };
    /**
     * 根据医生id查询医生信息
     */
    public SysUser getDoctorInfoByUserId(Long docId) {
        return sensorDataMapper.getDoctorInfoByUserId(docId);
    };
    /**
     * 根据患者id查询医生患者
     */
    public SysUser getPatientInfoByUserId(Long PatId) {
        return sensorDataMapper.getPatientInfoByUserId(PatId);
    };
    /**
     * 查询设备数据
     */
    public IntegratedHealthData selectLatestByUserId(Long userId) {
        return sensorDataMapper.selectLatestByUserId(userId);
    };
    /**
     * 医生：根据姓名和手机号查询患者是否有账号
     */
    @Override
    public SysUser selectPatientInfo(String name, String phone) {
        return sensorDataMapper.selectPatientInfo(name,phone);
    };
    /**
     * 医生：插入或更新自己的患者
     */
    @Override
    public int insertRelation(DoctorPatientRelation doctorRelation) {
            return sensorDataMapper.insertRelation(doctorRelation);
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
