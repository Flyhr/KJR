package com.ruoyi.DocSys.service;

import java.util.List;
import com.ruoyi.DocSys.domain.DocInfo;

/**
 * 医生信息Service接口
 * 
 * @author ruoyi
 * @date 2025-03-31
 */
public interface IDocInfoService 
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
     * 批量删除医生信息
     * 
     * @param userIds 需要删除的医生信息主键集合
     * @return 结果
     */
    public int deleteDocInfoByUserIds(Long[] userIds);

    /**
     * 删除医生信息信息
     * 
     * @param userId 医生信息主键
     * @return 结果
     */
    public int deleteDocInfoByUserId(Long userId);
}
