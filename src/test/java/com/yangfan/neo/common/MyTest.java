package com.yangfan.neo.common;

import com.yangfan.neo.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MyTest {
    @Value("${yangfan.mytest}")
    private boolean isY;

    @Value("${test}")
    private String param;

    @Test
    public void test(){
        System.out.println("--------------------------");
        System.out.println(param);
        if (!isY){
            System.out.println(isY);
        }
    }
}
