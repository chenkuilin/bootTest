package com.rsc.ckl.boottest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenkuilin
 * @date 2022/8/6
 * @desc
 */
public class TestBeanFactory {

    public static void main(String[] args) {

        //bean 的定义
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(Config.class).setScope("singleton").getBeanDefinition();

        beanFactory.registerBeanDefinition("config",beanDefinition);

        //给beanFactory加上一些常用的后置处理器
        AnnotationConfigUtils.registerAnnotationConfigProcessors(beanFactory);
        //
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class).values().forEach(beanFactoryPostProcessor -> {
            //beanFactory后置处理增强  补充了一些bean的定义
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        });

        //bean的后置处理器 针对Bean的生命周期各个阶段提供扩展
        beanFactory.getBeansOfType(BeanPostProcessor.class).values().forEach(beanFactory::addBeanPostProcessor);

        for (String name : beanFactory.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        //提前准备好所有得到单例  不是懒加载
        beanFactory.preInstantiateSingletons();

        System.out.println(beanFactory.getBean(Bean1.class).getBean2());

    }

    @Configuration
    static class Config{

        @Bean
        public Bean1 bean1(){
            return new Bean1();
        }

        @Bean
        public Bean2 bean2(){
            return new Bean2();
        }
    }
    

    static class Bean1{
        private static final Logger logger = LoggerFactory.getLogger(Bean1.class);

        @Autowired
        Bean2 bean2;

        public Bean1() {
            logger.info("构造 bean1");
        }

        public Bean2 getBean2() {
           return bean2;
        }
    }

    static class Bean2{
        private static final Logger logger = LoggerFactory.getLogger(Bean1.class);

        public Bean2() {
            logger.info("构造 bean2");
        }
    }

}
