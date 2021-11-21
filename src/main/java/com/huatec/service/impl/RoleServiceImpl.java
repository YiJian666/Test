package com.huatec.service.impl;

import com.huatec.domain.Role;
import com.huatec.mapper.RoleMapper;
import com.huatec.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> roleList() {
        List<Role> roleList = roleMapper.roleList();
        return roleList;
    }

    @Override
    public void saveRole(Role role) {
        roleMapper.saveRole(role);
    }
}
