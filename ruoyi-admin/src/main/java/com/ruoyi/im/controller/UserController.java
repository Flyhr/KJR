package com.ruoyi.im.controller;

import com.ruoyi.DocSys.domain.IntegratedHealthData;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;

import com.ruoyi.im.service.UserService;
import com.ruoyi.im.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserByUserName")
    public AjaxResult getUserByUserId(@RequestParam("user_id") Long user_id){
        SysUser data = userService.getUserByUser_Id(user_id);
        if(data != null){
            return AjaxResult.success(data);
        }
        return AjaxResult.error("暂无数据");
    }




}
