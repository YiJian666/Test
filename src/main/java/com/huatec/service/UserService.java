package com.huatec.service;

import com.huatec.domain.User;

import java.util.List;

public interface UserService {
    List<User> userList();

    void saveUser(User user, Long[] roleId);

    User login(String username, String password);
}
