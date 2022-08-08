package com.rsc.ckl.boottest.event;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenkuilin
 * @date 2022/7/13
 * @desc
 */

@Component
@Slf4j
public class DemoListener2 implements ApplicationListener<DemoEvent> {


    @SneakyThrows
    @Async
    @Override
    public void onApplicationEvent(DemoEvent event) {
        Thread.sleep(3000);
        System.out.println("DemoListener2 收到了：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("DemoListener2 消息：" + event.getId() + ":" + event.getName());
    }


}
