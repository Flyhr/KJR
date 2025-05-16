package com.ruoyi.DocSys.mapper;
import com.ruoyi.DocSys.domain.IntegratedHealthData;
import io.lettuce.core.dynamic.annotation.Param;

public interface IntegratedHealthDataMapper {
    // 查询最新一条数据（如果数据只保留最新一条或按时间查询）
    IntegratedHealthData selectLatestByUserId(@Param("userId") Long userId);
}
