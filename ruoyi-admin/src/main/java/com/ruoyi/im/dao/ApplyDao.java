package com.ruoyi.im.dao;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.im.pojo.Apply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyDao {
    int add(Apply apply);

    List<SysUser> getFriends(Long id);
}
