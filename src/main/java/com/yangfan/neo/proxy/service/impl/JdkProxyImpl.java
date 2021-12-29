package com.yangfan.neo.proxy.service.impl;

import com.yangfan.neo.proxy.service.JdkProxy;
import org.springframework.stereotype.Service;

@Service
public class JdkProxyImpl implements JdkProxy {
    @Override
    public void sayHello(String toSomeOne) {
        System.out.println("hello:" + toSomeOne);
    }
}
