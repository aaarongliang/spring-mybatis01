package com.liangyu.mapper;

import com.liangyu.entity.User;

import java.util.List;

public interface UserMapper {

    public List<User> queryUserList();

    public User getUserByName(String userName);

    int inserUser(User user);

    int updateUser(User user);
}
