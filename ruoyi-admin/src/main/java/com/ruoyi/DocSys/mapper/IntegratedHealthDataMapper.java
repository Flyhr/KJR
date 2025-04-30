package com.ruoyi.DocSys.mapper;
import com.ruoyi.DocSys.domain.IntegratedHealthData;
import com.ruoyi.DocSys.domain.UserBasicInfo;


public interface IntegratedHealthDataMapper {
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
