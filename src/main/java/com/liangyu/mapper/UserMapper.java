package com.liangyu.mapper;

import com.liangyu.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public List<User> queryUserList();

    public User getUserByName(String userName);

    int inserUser(User user);

    int updateUser(User user);

    int updateUserByNames(List<User> userList);

    List<User> selectUserByNames(List<String> list);

    User selectUserByMap(Map<String, String> map);

    int queryCount();

    List<User> selectUserByPage(Map<String, Object> map);

    int insertList(List<User> userList);
}
