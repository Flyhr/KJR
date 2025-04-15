package com.ruoyi.DocSys.service;

import java.util.List;
import com.ruoyi.DocSys.domain.DoctorPatientRelation;

/**
 * 医生患者关系Service接口
 * 
 * @author ruoyi
 * @date 2025-03-31
 */
public interface IDoctorPatientRelationService 
{
    /**
     * 查询医生患者关系
     * 
     * @param id 医生患者关系主键
     * @return 医生患者关系
     */
    public DoctorPatientRelation selectDoctorPatientRelationById(Long id);

    /**
     * 查询医生患者关系列表
     * 
     * @param doctorPatientRelation 医生患者关系
     * @return 医生患者关系集合
     */
    public List<DoctorPatientRelation> selectDoctorPatientRelationList(DoctorPatientRelation doctorPatientRelation);

    /**
     * 新增医生患者关系
     * 
     * @param doctorPatientRelation 医生患者关系
     * @return 结果
     */
    public int insertDoctorPatientRelation(DoctorPatientRelation doctorPatientRelation);

    /**
     * 修改医生患者关系
     * 
     * @param doctorPatientRelation 医生患者关系
     * @return 结果
     */
    public int updateDoctorPatientRelation(DoctorPatientRelation doctorPatientRelation);

    /**
     * 批量删除医生患者关系
     * 
     * @param ids 需要删除的医生患者关系主键集合
     * @return 结果
     */
    public int deleteDoctorPatientRelationByIds(Long[] ids);

    /**
     * 删除医生患者关系信息
     * 
     * @param id 医生患者关系主键
     * @return 结果
     */
    public int deleteDoctorPatientRelationById(Long id);
}
