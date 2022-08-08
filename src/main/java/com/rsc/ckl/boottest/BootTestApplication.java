package com.rsc.ckl.boottest;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
@EnableAsync
public class BootTestApplication {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ConfigurableApplicationContext context = SpringApplication.run(BootTestApplication.class, args);

        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
        singletonObjects.setAccessible(true);

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        Map<String, Object> singletonMap = (Map<String, Object>) singletonObjects.get(beanFactory);

        singletonMap.forEach( (k,v) -> System.out.println( k + "= " + v));

//        context.getMessage("hi",null, Locale.CHINA);

        System.out.println(context.getEnvironment().getProperty("java_home"));
        System.out.println(context.getEnvironment().getProperty("server.port"));

//        //获取类路径下的文件
//        context.getResources("classpath:application.properties");
//        //* 获取所有jar包中的配置文件
//        context.getResources("classpath*:META-INF/spring-factories");

    }

}
