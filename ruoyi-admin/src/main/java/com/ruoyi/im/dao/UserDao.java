package com.ruoyi.im.dao;

import com.ruoyi.common.core.domain.entity.SysUser;

public interface UserDao {

    SysUser getUserByUser_Id(Long user_id);
}
