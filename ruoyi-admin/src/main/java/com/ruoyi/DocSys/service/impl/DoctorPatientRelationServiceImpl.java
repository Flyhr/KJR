package com.ruoyi.DocSys.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.DocSys.mapper.DoctorPatientRelationMapper;
import com.ruoyi.DocSys.domain.DoctorPatientRelation;
import com.ruoyi.DocSys.service.IDoctorPatientRelationService;

/**
 * 医生患者关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-31
 */
@Service
public class DoctorPatientRelationServiceImpl implements IDoctorPatientRelationService 
{
    @Autowired
    private DoctorPatientRelationMapper doctorPatientRelationMapper;

    /**
     * 查询医生患者关系
     * 
     * @param id 医生患者关系主键
     * @return 医生患者关系
     */
    @Override
    public DoctorPatientRelation selectDoctorPatientRelationById(Long id)
    {
        return doctorPatientRelationMapper.selectDoctorPatientRelationById(id);
    }

    /**
     * 查询医生患者关系列表
     * 
     * @param doctorPatientRelation 医生患者关系
     * @return 医生患者关系
     */
    @Override
    public List<DoctorPatientRelation> selectDoctorPatientRelationList(DoctorPatientRelation doctorPatientRelation)
    {
        return doctorPatientRelationMapper.selectDoctorPatientRelationList(doctorPatientRelation);
    }

    /**
     * 新增医生患者关系
     * 
     * @param doctorPatientRelation 医生患者关系
     * @return 结果
     */
    @Override
    public int insertDoctorPatientRelation(DoctorPatientRelation doctorPatientRelation)
    {
        doctorPatientRelation.setCreateTime(DateUtils.getNowDate());
        return doctorPatientRelationMapper.insertDoctorPatientRelation(doctorPatientRelation);
    }

    /**
     * 修改医生患者关系
     * 
     * @param doctorPatientRelation 医生患者关系
     * @return 结果
     */
    @Override
    public int updateDoctorPatientRelation(DoctorPatientRelation doctorPatientRelation)
    {
        return doctorPatientRelationMapper.updateDoctorPatientRelation(doctorPatientRelation);
    }

    /**
     * 批量删除医生患者关系
     * 
     * @param ids 需要删除的医生患者关系主键
     * @return 结果
     */
    @Override
    public int deleteDoctorPatientRelationByIds(Long[] ids)
    {
        return doctorPatientRelationMapper.deleteDoctorPatientRelationByIds(ids);
    }

    /**
     * 删除医生患者关系信息
     * 
     * @param id 医生患者关系主键
     * @return 结果
     */
    @Override
    public int deleteDoctorPatientRelationById(Long id)
    {
        return doctorPatientRelationMapper.deleteDoctorPatientRelationById(id);
    }
}
