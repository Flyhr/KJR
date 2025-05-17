package com.ruoyi.DocSys.service;

import com.ruoyi.DocSys.domain.DoctorPatientRelation;
import com.ruoyi.DocSys.domain.IntegratedHealthData;
import com.ruoyi.DocSys.domain.PatientSelect;
import com.ruoyi.DocSys.domain.UserBasicInfo;
import com.ruoyi.common.core.domain.entity.SysUser;

public interface IIntegratedHealthDataService {


    SysUser selectPatientInfo(String name, String phone);

    int insertRelation(DoctorPatientRelation doctorRelation);

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
