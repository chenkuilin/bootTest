package com.rsc.ckl.boottest;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.reflect.Field;
import java.util.Map;

@SpringBootApplication
@EnableAsync
public class BootTestApplication02 {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BootTestApplication02.class, args);
        context.close();

    }

}
