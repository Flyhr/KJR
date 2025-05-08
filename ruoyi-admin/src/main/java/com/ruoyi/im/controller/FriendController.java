package com.ruoyi.im.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.im.pojo.Apply;
import com.ruoyi.im.pojo.Friend;
import com.ruoyi.im.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;


    // 获取好友列表
    @GetMapping("/list")
    public AjaxResult list(SysUser user) {
        return friendService.list(user);
    }

    // 添加好友申请
    @PostMapping("/add")
    public AjaxResult add(SysUser user, @RequestBody Apply apply) {
        apply.setUid(user.getUserId());
        return friendService.add(apply);
    }

    // 获取好友申请列表
    @GetMapping("/getFriends")
    public AjaxResult getFriends(SysUser user) {
        return friendService.getFriends(user);
    }

    // 同意好友申请
    @PostMapping("/agree")
    public AjaxResult agree(SysUser user, @RequestBody Friend friend) {
        friend.setUid(user.getUserId());
        return friendService.agree(friend);
    }


}
