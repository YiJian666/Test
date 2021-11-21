package com.huatec.service;

import com.huatec.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> roleList();

    void saveRole(Role role);
}
