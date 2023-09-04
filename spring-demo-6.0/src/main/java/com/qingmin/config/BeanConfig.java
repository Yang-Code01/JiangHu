package com.qingmin.config;

import com.qingmin.bean.Plan;
import com.qingmin.fanli.ArtTeacher;
import com.qingmin.fanli.Student;
import com.qingmin.fanli.Teacher;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author QingMin Yang
 * @date 2023/9/4 21:01
 */
//@Import(LBWConfiguration.class)
@Configuration
@ComponentScan("com.qingmin")  //包扫描，这样Spring就会去扫描对应包下所有的类
@EnableAsync // Spring异步任务支持
@EnableScheduling // 定时任务支持
public class BeanConfig {

    // Spring在扫描对应包下所有的类时，
    // 会自动将那些添加了@Component的类注册为Bean，
    // 是不是感觉很方便？只不过这种方式只适用于我们自己编写类的情况，
    // 如果是第三方包提供的类，只能使用前者完成注册，并且这种方式并不是那么的灵活。

    @Bean(name = "student")
    @Lazy()
    @Scope("prototype") // 默认是单例
    @DependsOn("teacher")
    public Student student(Teacher teacher){
        return new Student(teacher);
    }

    @Bean
    public Teacher teacher(){
        return new ArtTeacher();
    }


    @PostConstruct
    public void init(){
        System.out.println("我是初始化方法");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("我是销毁方法");
    }

}
