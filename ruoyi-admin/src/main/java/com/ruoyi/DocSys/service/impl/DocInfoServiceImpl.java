package com.ruoyi.DocSys.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.DocSys.domain.DoctorPatientRelation;
import com.ruoyi.DocSys.mapper.DocInfoMapper;
import com.ruoyi.DocSys.domain.DocInfo;
import com.ruoyi.DocSys.service.IDocInfoService;

/**
 * 医生信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-03-31
 */
@Service
public class DocInfoServiceImpl implements IDocInfoService 
{
    @Autowired
    private DocInfoMapper docInfoMapper;

    /**
     * 查询医生信息
     * 
     * @param userId 医生信息主键
     * @return 医生信息
     */
    @Override
    public DocInfo selectDocInfoByUserId(Long userId)
    {
        return docInfoMapper.selectDocInfoByUserId(userId);
    }

    /**
     * 查询医生信息列表
     * 
     * @param docInfo 医生信息
     * @return 医生信息
     */
    @Override
    public List<DocInfo> selectDocInfoList(DocInfo docInfo)
    {
        return docInfoMapper.selectDocInfoList(docInfo);
    }

    /**
     * 新增医生信息
     * 
     * @param docInfo 医生信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertDocInfo(DocInfo docInfo)
    {
        docInfo.setCreateTime(DateUtils.getNowDate());
        int rows = docInfoMapper.insertDocInfo(docInfo);
        insertDoctorPatientRelation(docInfo);
        return rows;
    }

    /**
     * 修改医生信息
     * 
     * @param docInfo 医生信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateDocInfo(DocInfo docInfo)
    {
        docInfo.setUpdateTime(DateUtils.getNowDate());
        docInfoMapper.deleteDoctorPatientRelationById(docInfo.getUserId());
        insertDoctorPatientRelation(docInfo);
        return docInfoMapper.updateDocInfo(docInfo);
    }

    /**
     * 批量删除医生信息
     * 
     * @param userIds 需要删除的医生信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDocInfoByUserIds(Long[] userIds)
    {
        docInfoMapper.deleteDoctorPatientRelationByIds(userIds);
        return docInfoMapper.deleteDocInfoByUserIds(userIds);
    }

    /**
     * 删除医生信息信息
     * 
     * @param userId 医生信息主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDocInfoByUserId(Long userId)
    {
        docInfoMapper.deleteDoctorPatientRelationById(userId);
        return docInfoMapper.deleteDocInfoByUserId(userId);
    }

    /**
     * 新增医生患者关系信息
     * 
     * @param docInfo 医生信息对象
     */
    public void insertDoctorPatientRelation(DocInfo docInfo)
    {
        List<DoctorPatientRelation> doctorPatientRelationList = docInfo.getDoctorPatientRelationList();
        Long userId = docInfo.getUserId();
        if (StringUtils.isNotNull(doctorPatientRelationList))
        {
            List<DoctorPatientRelation> list = new ArrayList<DoctorPatientRelation>();
            for (DoctorPatientRelation doctorPatientRelation : doctorPatientRelationList)
            {
                doctorPatientRelation.setId(userId);
                list.add(doctorPatientRelation);
            }
            if (list.size() > 0)
            {
                docInfoMapper.batchDoctorPatientRelation(list);
            }
        }
    }
}
