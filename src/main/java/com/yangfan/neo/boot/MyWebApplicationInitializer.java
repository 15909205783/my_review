package com.yangfan.neo.boot;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//实现java config第一步写个类实现spring接口
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    //web容器会在启动的时候取调动onStartup() ServletContext web上下文对象
    //servlet 3.0 版本以后提出的一个新规范 SPI
    // 如果项目里面有某些类或者某些方法需要在启动的时候被tomcat（web容器）调用的话
    //首先在项目的根目录 META-INF/services目录下建立一个文件
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Load Spring web application configuration
        //spring 容器上下文对象
        //用java注解的方式去初始化spring上下文
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("*.do");
    }
}
