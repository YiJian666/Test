package com.huatec.mapper;

import com.huatec.domain.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> findRoleByUserId(Long userId);

    List<Role> roleList();

    void saveRole(Role role);
}
