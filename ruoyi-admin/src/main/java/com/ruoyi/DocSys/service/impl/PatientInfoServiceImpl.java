package com.ruoyi.DocSys.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.DocSys.mapper.PatientInfoMapper;
import com.ruoyi.DocSys.domain.PatientInfo;
import com.ruoyi.DocSys.service.IPatientInfoService;

/**
 * 患者信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-31
 */
@Service
public class PatientInfoServiceImpl implements IPatientInfoService 
{
    @Autowired
    private PatientInfoMapper patientInfoMapper;

    /**
     * 查询患者信息
     * 
     * @param patId 患者信息主键
     * @return 患者信息
     */
    @Override
    public PatientInfo selectPatientInfoByPatId(Long patId)
    {
        return patientInfoMapper.selectPatientInfoByPatId(patId);
    }

    /**
     * 查询患者信息列表
     * 
     * @param patientInfo 患者信息
     * @return 患者信息
     */
    @Override
    public List<PatientInfo> selectPatientInfoList(PatientInfo patientInfo)
    {
        return patientInfoMapper.selectPatientInfoList(patientInfo);
    }

    /**
     * 新增患者信息
     * 
     * @param patientInfo 患者信息
     * @return 结果
     */
    @Override
    public int insertPatientInfo(PatientInfo patientInfo)
    {
        patientInfo.setCreateTime(DateUtils.getNowDate());
        return patientInfoMapper.insertPatientInfo(patientInfo);
    }

    /**
     * 修改患者信息
     * 
     * @param patientInfo 患者信息
     * @return 结果
     */
    @Override
    public int updatePatientInfo(PatientInfo patientInfo)
    {
        patientInfo.setUpdateTime(DateUtils.getNowDate());
        return patientInfoMapper.updatePatientInfo(patientInfo);
    }

    /**
     * 批量删除患者信息
     * 
     * @param patIds 需要删除的患者信息主键
     * @return 结果
     */
    @Override
    public int deletePatientInfoByPatIds(Long[] patIds)
    {
        return patientInfoMapper.deletePatientInfoByPatIds(patIds);
    }

    /**
     * 删除患者信息信息
     * 
     * @param patId 患者信息主键
     * @return 结果
     */
    @Override
    public int deletePatientInfoByPatId(Long patId)
    {
        return patientInfoMapper.deletePatientInfoByPatId(patId);
    }
}
