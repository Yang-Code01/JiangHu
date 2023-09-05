package com.qingmin.component;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author QingMin Yang
 * @date 2023/9/5 23:29
 */

@Component
public class TestListener implements ApplicationListener<TestListener.TestEvent> {

    // 通过实现 ApplicationListener 接口来实现 监听器
    // ContextRefreshedEvent 监听事件的类型
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        System.out.println(event.getApplicationContext());   //可以直接通过事件获取到事件相关的东西
//    }

    @Override
    public void onApplicationEvent(TestEvent event) {
        System.out.println("发生了一次event 监听: " + event);
    }

    // 自定以event 通过继承 ApplicationEvent
    public static class TestEvent extends ApplicationEvent {

        public TestEvent(Object source) {
            super(source);
        }
    }
}
