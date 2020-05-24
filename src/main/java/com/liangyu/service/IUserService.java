package com.liangyu.service;

import com.liangyu.entity.User;

import java.util.List;

public interface IUserService {
    List<User> queryUserList();

    User getUserByName(String userName);

    int insertUser(User user);

    int updateUser(User user);

    int updateUserByNames(List<User> userList);

    List<User> selectUserByNames(List<String> list);
}
