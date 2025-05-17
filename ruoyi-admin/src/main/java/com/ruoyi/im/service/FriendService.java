package com.ruoyi.im.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.im.dao.ApplyDao;
import com.ruoyi.im.dao.FriendDao;
import com.ruoyi.im.pojo.Apply;
import com.ruoyi.im.pojo.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    private FriendDao friendDao;
    @Autowired
    private ApplyDao applyDao;

    public AjaxResult list(SysUser user) {
        List<SysUser> list = friendDao.list(user.getUserId());
        return AjaxResult.success(list);
    }

    public AjaxResult add(Apply apply) {
        applyDao.add(apply);
        return AjaxResult.success();
    }

    public AjaxResult getFriends(SysUser user) {
        List<SysUser> list = applyDao.getFriends(user.getUserId());
        return AjaxResult.success(list);
    }

    public AjaxResult agree(Friend friend) {
        friendDao.add(friend);
        Friend friend1 = new Friend();
        friend1.setUid(friend.getFid());
        friend1.setFid(friend.getUid());
        friendDao.add(friend1);
        return AjaxResult.success();
    }

}
