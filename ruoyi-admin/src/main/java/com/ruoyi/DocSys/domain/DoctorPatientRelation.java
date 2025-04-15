package com.ruoyi.DocSys.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医生患者关系对象 doctor_patient_relation
 * 
 * @author ruoyi
 * @date 2025-03-31
 */
public class DoctorPatientRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 关系ID */
    private Long id;

    /** 医生ID */
    @Excel(name = "医生ID")
    private Long docId;

    /** 患者ID */
    @Excel(name = "患者ID")
    private Long patId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDocId(Long docId) 
    {
        this.docId = docId;
    }

    public Long getDocId() 
    {
        return docId;
    }
    public void setPatId(Long patId) 
    {
        this.patId = patId;
    }

    public Long getPatId() 
    {
        return patId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("docId", getDocId())
            .append("patId", getPatId())
            .append("createTime", getCreateTime())
            .toString();
    }
}
