package com.qingmin.component;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author QingMin Yang
 * @date 2023/9/5 23:37
 */
@Component
public class TaskComponent implements ApplicationEventPublisherAware {

    //要发布事件，需要拿到ApplicationEventPublisher，这里我们通过Aware在初始化的时候拿到
    //实际上我们的ApplicationContext就是ApplicationEventPublisher的实现类，这里拿到的就是
    //我们创建的ApplicationContext对象
    ApplicationEventPublisher publisher;

    @Scheduled(fixedRate = 1000)   //一秒一次
    public void task(){
        //直接通过ApplicationEventPublisher的publishEvent方法发布事件
        //这样，所有这个事件的监听器，都会监听到这个事件发生了
        publisher.publishEvent(new TestListener.TestEvent(this));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
}
