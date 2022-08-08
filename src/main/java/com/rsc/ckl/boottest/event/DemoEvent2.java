package com.rsc.ckl.boottest.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author chenkuilin
 * @date 2022/7/13
 * @desc
 */


public class DemoEvent2 extends ApplicationEvent {

    private String id;

    private String name;


    public DemoEvent2(Object source, String id, String name) {
        super(source);
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
