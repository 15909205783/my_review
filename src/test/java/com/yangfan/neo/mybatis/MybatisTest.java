package com.yangfan.neo.mybatis;

import com.yangfan.neo.Application;
import com.yangfan.neo.dao.entity.User;
import com.yangfan.neo.dao.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.Reader;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MybatisTest {

    static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = MybatisUtil.getSqlsessionFactory();
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQuery() {
        User user = userMapper.selectById(2);
        System.out.println(user);
    }
    @Test
    public void testInsert(){
        User user = new User();
        user.setUserName("小明");
        user.setPassWord("222");
        userMapper.insert(user);

    }

    @Test
    public void testSqlSession(){


        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectById(2);
        System.out.println(user);
    }
}
