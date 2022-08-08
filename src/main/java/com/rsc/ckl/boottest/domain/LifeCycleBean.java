package com.rsc.ckl.boottest.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author chenkuilin
 * @date 2022/8/8
 * @desc
 */

@Component
public class LifeCycleBean {

    public static Logger logger = LoggerFactory.getLogger(LifeCycleBean.class);

    //1.构造方法
    public LifeCycleBean() {
        logger.info("无参构造方法");
    }

    //2.依赖注入方法
    @Autowired
    public void autowired(@Value("${JAVA_HOME}")String home){
        logger.info("JAVA_HOME is {}" , home);
    }

    //3.初始化方法
    @PostConstruct
    public void init(){
        logger.info("初始化方法 ++++++++++++");
    }

    //4.销毁
    @PreDestroy
    public void destroy(){
        logger.info("销毁 ++++++++++++");
    }


}
