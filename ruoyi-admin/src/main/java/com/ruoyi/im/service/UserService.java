package com.ruoyi.im.service;

import com.ruoyi.DocSys.domain.IntegratedHealthData;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.im.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public SysUser getUserByUser_Id(Long user_id) {
       return userDao.getUserByUser_Id(user_id);
    }


}
