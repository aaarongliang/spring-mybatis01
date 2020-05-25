package com.liangyu.controller;

import com.liangyu.entity.User;
import com.liangyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    public List<User> queryUserList(){
        return userService.queryUserList();
    }

    public User getUserByName(String userName){
        User user = userService.getUserByName(userName);
        String password=user.getPassword();
        switch(password){
            case "11111": m1();break;
            case "22222":m2();break;
            default: m3();
        }
        return user;
    }

    public int insertUser(User user){
        return userService.insertUser(user);
    }

    public int updateUser(User user) {
        return userService.updateUser(user);
    }

    public int updateUserByNames(List<User> userList){
        return userService.updateUserByNames(userList);
    }

    public List<User> selectUserByNames(List<String> list){
        return userService.selectUserByNames(list);
    }

    public User selectUserByMap(Map<String,String> map){
        return userService.selectUserByMap(map);
    }

    public int queryCount(){
        return userService.queryCount();
    }

    public void m1(){
        System.out.println("m1");
    }

    public void m2(){
        System.out.println("m2");
    }

    public void m3(){
        System.out.println("m3");
    }

    public List<User> selectUserByPage(Map<String, Object> map) {
        return userService.selectUserByPage(map);
    }

    public int insertList(List<User> userList) {
        return userService.insertList(userList);
    }
}
