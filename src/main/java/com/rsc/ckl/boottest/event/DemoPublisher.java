package com.rsc.ckl.boottest.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author chenkuilin
 * @date 2022/7/13
 * @desc
 */

@Component
public class DemoPublisher {

    private final ApplicationContext applicationContext;

    @Autowired
    public DemoPublisher(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void publish(ApplicationEvent applicationEvent) {
        applicationContext.publishEvent(applicationEvent);
    }

}
