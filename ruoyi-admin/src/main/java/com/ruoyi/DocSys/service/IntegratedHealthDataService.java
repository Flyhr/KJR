package com.ruoyi.DocSys.service;

import com.ruoyi.DocSys.domain.IntegratedHealthData;
import com.ruoyi.DocSys.mapper.IntegratedHealthDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntegratedHealthDataService {

    @Autowired
    private IntegratedHealthDataMapper healthDataMapper;

    public IntegratedHealthData selectLatestByUserId(Long userId) {
        return healthDataMapper.selectLatestByUserId(userId);
    }
}
