package com.huatec.mapper;

import com.huatec.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> userList();

    User findUserByUsernamePassword(User user);

    void saveUser(User user);


    void saveUserRoleRel(Map<String, Long> params);
}
