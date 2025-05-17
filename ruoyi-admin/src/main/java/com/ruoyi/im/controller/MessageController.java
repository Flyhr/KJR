package com.ruoyi.im.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.im.pojo.Message;
import com.ruoyi.im.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    // 获取聊天消息列表
    @GetMapping("/list")
    public AjaxResult list(SysUser user, Long to, Integer pageNum, Integer pageSize) {
        return messageService.list(user, to, pageNum, pageSize);
    }

    // 发送聊天消息
    @PostMapping("/add")
    public AjaxResult add(SysUser user, @RequestBody Message message) {
        message.setFrom(user.getUserId());
        return messageService.add(message);
    }

}
