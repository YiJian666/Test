package com.huatec.service.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.huatec.domain.Role;
import com.huatec.domain.User;
import com.huatec.mapper.RoleMapper;
import com.huatec.mapper.UserMapper;
import com.huatec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {



    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<User> userList() {
        List<User> userList = userMapper.userList();
        for (User user:userList) {
            Long userId = user.getId();
            List<Role> roleList = roleMapper.findRoleByUserId(userId);
            user.setRoles(roleList);
        }
        return userList;
    }

    @Override
    public void saveUser(User user, Long[] roleIds) {
       userMapper.saveUser(user);
        Long userId = user.getId();
        System.out.println(userId);
        Map<String,Long> params = new HashMap<String,Long>();
        params.put("userId",userId);
        for (Long roleId:roleIds) {
            params.put("roleId",roleId);
            userMapper.saveUserRoleRel(params);
        }

    }
    @Override
    public User login(String username, String password) {
        try{
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            User user1 = userMapper.findUserByUsernamePassword(user);
            return user1;
        }catch(EmptyResultDataAccessException e){
            return null;
        }

    }
}
