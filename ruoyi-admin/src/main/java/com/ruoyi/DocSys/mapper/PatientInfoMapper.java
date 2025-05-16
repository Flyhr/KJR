package com.ruoyi.DocSys.mapper;

import java.util.List;
import com.ruoyi.DocSys.domain.PatientInfo;

/**
 * 患者信息Mapper接口
 * 
 * @author ruoyi
 * @date 2025-03-31
 */
public interface PatientInfoMapper 
{
    /**
     * 查询患者信息
     * 
     * @param patId 患者信息主键
     * @return 患者信息
     */
    public PatientInfo selectPatientInfoByPatId(Long patId);

    /**
     * 查询患者信息列表
     * 
     * @param patientInfo 患者信息
     * @return 患者信息集合
     */
    public List<PatientInfo> selectPatientInfoList(PatientInfo patientInfo);

    /**
     * 新增患者信息
     * 
     * @param patientInfo 患者信息
     * @return 结果
     */
    public int insertPatientInfo(PatientInfo patientInfo);

    /**
     * 修改患者信息
     * 
     * @param patientInfo 患者信息
     * @return 结果
     */
    public int updatePatientInfo(PatientInfo patientInfo);

    /**
     * 删除患者信息
     * 
     * @param patId 患者信息主键
     * @return 结果
     */
    public int deletePatientInfoByPatId(Long patId);

    /**
     * 批量删除患者信息
     * 
     * @param patIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePatientInfoByPatIds(Long[] patIds);
}
