package com.ruoyi.DocSys.mapper;

import java.util.List;
import com.ruoyi.DocSys.domain.DocInfo;
import com.ruoyi.DocSys.domain.DoctorPatientRelation;

/**
 * 医生信息Mapper接口
 * 
 * @author ruoyi
 * @date 2025-03-31
 */
public interface DocInfoMapper 
{
    /**
     * 查询医生信息
     * 
     * @param userId 医生信息主键
     * @return 医生信息
     */
    public DocInfo selectDocInfoByUserId(Long userId);

    /**
     * 查询医生信息列表
     * 
     * @param docInfo 医生信息
     * @return 医生信息集合
     */
    public List<DocInfo> selectDocInfoList(DocInfo docInfo);

    /**
     * 新增医生信息
     * 
     * @param docInfo 医生信息
     * @return 结果
     */
    public int insertDocInfo(DocInfo docInfo);

    /**
     * 修改医生信息
     * 
     * @param docInfo 医生信息
     * @return 结果
     */
    public int updateDocInfo(DocInfo docInfo);

    /**
     * 删除医生信息
     * 
     * @param userId 医生信息主键
     * @return 结果
     */
    public int deleteDocInfoByUserId(Long userId);

    /**
     * 批量删除医生信息
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDocInfoByUserIds(Long[] userIds);

    /**
     * 批量删除医生患者关系
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDoctorPatientRelationByIds(Long[] userIds);
    
    /**
     * 批量新增医生患者关系
     * 
     * @param doctorPatientRelationList 医生患者关系列表
     * @return 结果
     */
    public int batchDoctorPatientRelation(List<DoctorPatientRelation> doctorPatientRelationList);
    

    /**
     * 通过医生信息主键删除医生患者关系信息
     * 
     * @param userId 医生信息ID
     * @return 结果
     */
    public int deleteDoctorPatientRelationById(Long userId);
}
