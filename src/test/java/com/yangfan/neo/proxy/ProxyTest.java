package com.yangfan.neo.proxy;

import com.yangfan.neo.Application;
import com.yangfan.neo.proxy.handler.JdkInvocationHandler;
import com.yangfan.neo.proxy.service.JdkProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Proxy;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProxyTest {

    @Autowired
    private JdkProxy register;

    @Test
    public void testProxy() {
        JdkInvocationHandler handler = new JdkInvocationHandler(register);
        JdkProxy jdkProxy = (JdkProxy) Proxy.newProxyInstance(register.getClass().getClassLoader(), register.getClass().getInterfaces(), handler);
        jdkProxy.sayHello("tom");
    }
}
