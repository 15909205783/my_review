package com.yangfan.neo.config;

import java.util.Properties;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * @Date：2026/5/12
 * @Description:
 * @Author：yangwuhai
 */
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})}
)
public class MYInterceptor implements Interceptor {

    public MYInterceptor() {
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("_______intercept____测试拦截器");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("plugin");
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
