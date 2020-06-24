package com.springboot.dubbo.api.server.impl;

import com.springboot.dubbo.api.server.UserService;
import com.springboot.dubbo.model.entity.SysUser;
import com.springboot.dubbo.model.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WH
 * @version 1.0
 * @date 2019/9/13 18:42
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    SysUserMapper mapper;


    @Override
    public List<SysUser> list(SysUser sysUser) {
        return mapper.select(sysUser);

    }
}
