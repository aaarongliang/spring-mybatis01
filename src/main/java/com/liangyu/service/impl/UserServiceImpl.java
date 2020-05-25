package com.liangyu.service.impl;

import com.liangyu.entity.User;
import com.liangyu.mapper.UserMapper;
import com.liangyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service()
@Transactional(propagation= Propagation.REQUIRES_NEW,rollbackFor = {ArithmeticException.class,Exception.class})
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper mapper;
    @Override
    public List<User> queryUserList(){
        List<User> userList = mapper.queryUserList();
        return userList;
    }

    public User getUserByName(String userName){
        return mapper.getUserByName(userName);
    }

    public int insertUser(User user){
        return mapper.inserUser(user);
    }


    public int updateUser(User user){
        int i = mapper.updateUser(user);
        int j = 1/0;
        return i;
    }

    public int updateUserByNames(List<User> userList){
      return mapper.updateUserByNames(userList);
    }

    public List<User> selectUserByNames(List<String> list){
        return mapper.selectUserByNames(list);
    }

    public User selectUserByMap(Map<String, String> map){
        return mapper.selectUserByMap(map);
    }

    public int queryCount(){
        return mapper.queryCount();
    }

    public List<User> selectUserByPage(Map<String, Object> map){
        return mapper.selectUserByPage(map);
    }

    public int insertList(List<User> userList){
        return mapper.insertList(userList);
    }
}
