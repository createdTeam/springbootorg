package com.springboot.dubbo.server.controller;

import com.springboot.dubbo.api.server.UserService;
import com.springboot.dubbo.model.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wh
 * @version 1.0
 * @date 2019-9-2 16:08
 */
@Controller
@RequestMapping("user")
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public List<SysUser> list(SysUser user) {
        List<SysUser> list = userService.list(user);
        return list;
    }

    @RequestMapping("/add")
    @ResponseBody
    public int addSysUser(){
        return userService.addSysUser();
    }
}
