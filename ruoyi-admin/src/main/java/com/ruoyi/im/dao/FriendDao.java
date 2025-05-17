package com.ruoyi.im.dao;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.im.pojo.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FriendDao {
    List<SysUser> list(Long id);

    int add(Friend friend);
}
