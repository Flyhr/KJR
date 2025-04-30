package com.ruoyi.DocSys.mapper;
import com.ruoyi.DocSys.domain.IntegratedHealthData;
import io.lettuce.core.dynamic.annotation.Param;

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
}
