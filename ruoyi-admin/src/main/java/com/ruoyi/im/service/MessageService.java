package com.ruoyi.im.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.im.dao.MessageDao;
import com.ruoyi.im.pojo.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    public AjaxResult list(SysUser user, Long to, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Map> list = messageDao.list(user.getUserId(), to);
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("total", PageInfo.of(list).getTotal());
        return AjaxResult.success(map);
    }

    public AjaxResult add(Message message) {
        message.setType(1);
        message.setTime(new Date());
        messageDao.add(message);
        return AjaxResult.success();
    }



}
