package com.yangfan.neo.web;


import com.yangfan.neo.dao.entity.User;
import com.yangfan.neo.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Value("${test}")
    private String param;
    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = userMapper.getAll();
        return users;
    }

    @RequestMapping("/get")
    @Cacheable(value = "user-key")
    public User getUser() {
        User user = new User("aa", "aa123456");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        System.out.println("____________________________");
        System.out.println(param);
        User user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User user) {
        userMapper.insert(user);
    }

//    @RequestMapping(value = "update")
//    public void update(User user) {
//        userMapper.update(user);
//    }
//
//    @RequestMapping(value = "/delete/{id}")
//    public void delete(@PathVariable("id") Long id) {
//        userMapper.delete(id);
//    }

}
