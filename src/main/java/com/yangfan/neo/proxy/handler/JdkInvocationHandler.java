package com.yangfan.neo.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkInvocationHandler implements InvocationHandler {
    private Object target;

    public JdkInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("come here");
        method.invoke(target, args);
        System.out.println("go back");
        return null;
    }
}
