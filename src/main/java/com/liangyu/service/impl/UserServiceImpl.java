package com.liangyu.service.impl;

import com.liangyu.entity.User;
import com.liangyu.mapper.UserMapper;
import com.liangyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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


    public int updateUser(User user) throws Exception{
        int i = mapper.updateUser(user);
        try{
            int j = 1/0;
        }catch (Exception e){
            throw new Exception();
        }

        return i;
    }
}
