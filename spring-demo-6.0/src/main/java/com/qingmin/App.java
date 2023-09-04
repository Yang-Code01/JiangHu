package com.qingmin;

import com.qingmin.bean.*;
import com.qingmin.config.BeanConfig;
import com.qingmin.fanli.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;


import java.util.Date;

/**
 * Hello world!
 *
 * @author admin
 */

public class App {


    static ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
    public static void main( String[] args ) throws InterruptedException {
//        System.out.println( "Hello World!" );
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Plan plan = (Plan) context.getBean("plan");
//        plan.sayHallo();
//        Student student = context.getBean(Student.class);
//        student.study();
//
//        Object studentName = context.getBean("studentName");

//这个构造方法可以接收多个配置类（更准确的说是多个组件）




//        Student student = context.getBean(Student.class);

//        Student student2 = context.getBean(Student.class);
//        System.out.println(student);
//        System.out.println(student2);

//        AForB a = context.getBean(AForB.class);
//        BForA b = context.getBean(BForA.class);
//        System.out.println(a);
//        System.out.println(b);
        // test();

//
//        planning.sayHallo();

        testAsync();
        tesk();

    }

    private static void test() {
        MediaLine mediaLine = context.getBean(MediaLine.class);
        //System.out.println(mediaLine);
    }

    private static void testAsync() throws InterruptedException {
        SyncAndAsyncTest asyncTest = context.getBean(SyncAndAsyncTest.class);
//        asyncTest.asyncTest(); // 异步执行
//        asyncTest.syncTest(); // 同步执行
        System.out.println(asyncTest.getClass());

    }


    @Scheduled(fixedDelay = 200) // 单位依然是毫秒，这里是每两秒钟打印一次
    public static void tesk() {
        System.out.println("定时任务 ： " + new Date());
    }


}
