package com.springboot.dubbo.api.server.impl;

import com.springboot.dubbo.api.server.UserService;
import com.springboot.dubbo.model.entity.SysUser;
import com.springboot.dubbo.model.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public int addSysUser() {
        List<SysUser> list = new ArrayList<>();
        SysUser user1 = new SysUser(1L,"hha");
        SysUser user2 = new SysUser(2L,"yeye");
        list.add(user1);
        list.add(user2);
        return mapper.insertBatch(list);
    }
}
