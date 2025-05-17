package com.ruoyi.DocSys.mapper;
import com.ruoyi.DocSys.domain.DoctorPatientRelation;
import com.ruoyi.DocSys.domain.IntegratedHealthData;
import com.ruoyi.DocSys.domain.PatientSelect;
import com.ruoyi.DocSys.domain.UserBasicInfo;
import com.ruoyi.common.core.domain.entity.SysUser;
import io.lettuce.core.dynamic.annotation.Param;


public interface IntegratedHealthDataMapper {
    /**
     * 根据医生id查询医生信息
     */
    SysUser getDoctorInfoByUserId(Long docId);
    /**
     * 根据患者id查询患者信息
     */
    SysUser getPatientInfoByUserId(Long PatId);
    /**
     * 根据 userId 查询患者查询自己医生信息
     */
    DoctorPatientRelation getDoctorRelationByUserId(Long userId);
    /**
     * 根据 userId 查询患者查询自己医生信息
     */
    DoctorPatientRelation getPatientRelationByUserId(Long userId);
//    /**
//     * 医生：根据 docId 查询医生和患者关系
//     */
//    IntegratedHealthData selectDoctorRelationByDocId(Long userId);
    /**
     *  医生：添加自己的患者
     */
    SysUser selectPatientInfo(@Param("name") String name, @Param("phone") String phone);    /**
     *  医生：根据姓名和手机号查询患者是否有账号
     */
    int insertRelation(DoctorPatientRelation doctorRelation);
    /**
     * 根据 userId 查询最新的一条记录
     */
    IntegratedHealthData selectLatestByUserId(Long userId);
    /**
     * 更新设备数据（根据 userId 更新）
     */
    int updateSensorData(IntegratedHealthData sensorData);

    /**
     * 插入设备数据
     */
    int insertSensorData(IntegratedHealthData sensorData);
    /**
     * 根据用户ID删除设备数据
     *
     * @param userId 用户的ID
     * @return 受影响的行数
     */
    int deleteHealthDataByUserId(Long userId);




    /**----------------------------------
     * 根据 userId 查询最新用户基础信息
     */
    UserBasicInfo selectUserBasicInfoByUserId(Long userId);

    /**
     * 更新用户基础信息数据（根据 userId 更新）
     */
    int updateUserBasicInfo(UserBasicInfo userBasicInfo);
    /**
     * 插入用户基础信息数据
     */
    int insertUserBasicInfo(UserBasicInfo userBasicInfo);

}
