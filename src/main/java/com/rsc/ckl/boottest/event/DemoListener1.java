package com.rsc.ckl.boottest.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author chenkuilin
 * @date 2022/7/13
 * @desc
 */

@Component
@Slf4j
public class DemoListener1 {


    @EventListener
    public void onApplicationEvent(DemoEvent2 event) {
        System.out.println("DemoListener1 收到了：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("DemoListener1 消息：" + event.getId() + ":" + event.getName());
    }


}
