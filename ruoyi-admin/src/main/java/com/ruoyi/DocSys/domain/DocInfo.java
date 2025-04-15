package com.ruoyi.DocSys.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 医生信息对象 doc_info
 * 
 * @author ruoyi
 * @date 2025-03-31
 */
public class DocInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 医生ID */
    private Long userId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String userName;

    /** 昵称 */
    private String nickName;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phoneNumber;

    /** 登录密码 */
    private String password;

    /** 所属角色 */
    @Excel(name = "所属角色")
    private String roleId;

    /** 所属部门 */
    private Long deptId;

    /** 数据权限 */
    private String dataScope;

    /** 性别 */
    private String sex;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 擅长领域 */
    private String speciality;

    /** 删除标志 */
    private String delFlag;

    /** 用户头像地址 */
    private String avatar;

    /** 最近一次登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最近一次登录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loginDate;

    /** 账号状态 */
    @Excel(name = "账号状态")
    private String status;

    /** 医生患者关系信息 */
    private List<DoctorPatientRelation> doctorPatientRelationList;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setRoleId(String roleId) 
    {
        this.roleId = roleId;
    }

    public String getRoleId() 
    {
        return roleId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setDataScope(String dataScope) 
    {
        this.dataScope = dataScope;
    }

    public String getDataScope() 
    {
        return dataScope;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setSpeciality(String speciality) 
    {
        this.speciality = speciality;
    }

    public String getSpeciality() 
    {
        return speciality;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setLoginDate(Date loginDate) 
    {
        this.loginDate = loginDate;
    }

    public Date getLoginDate() 
    {
        return loginDate;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public List<DoctorPatientRelation> getDoctorPatientRelationList()
    {
        return doctorPatientRelationList;
    }

    public void setDoctorPatientRelationList(List<DoctorPatientRelation> doctorPatientRelationList)
    {
        this.doctorPatientRelationList = doctorPatientRelationList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("nickName", getNickName())
            .append("phoneNumber", getPhoneNumber())
            .append("password", getPassword())
            .append("roleId", getRoleId())
            .append("deptId", getDeptId())
            .append("dataScope", getDataScope())
            .append("sex", getSex())
            .append("email", getEmail())
            .append("speciality", getSpeciality())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .append("delFlag", getDelFlag())
            .append("avatar", getAvatar())
            .append("remark", getRemark())
            .append("loginDate", getLoginDate())
            .append("status", getStatus())
            .append("doctorPatientRelationList", getDoctorPatientRelationList())
            .toString();
    }
}
