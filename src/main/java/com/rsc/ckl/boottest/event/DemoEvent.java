package com.rsc.ckl.boottest.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author chenkuilin
 * @date 2022/7/13
 * @desc
 */

public class DemoEvent extends ApplicationEvent {

    private Long id;

    private String name;

    public DemoEvent(Object source, Long id, String name) {
        super(source);
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
