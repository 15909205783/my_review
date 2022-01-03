package com.yangfan.neo.mybatis;

import com.yangfan.neo.Application;
import com.yangfan.neo.dao.entity.User;
import com.yangfan.neo.dao.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQuery() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setUserName("小明");
        user.setPassWord("222");
        userMapper.insert(user);

    }
}
