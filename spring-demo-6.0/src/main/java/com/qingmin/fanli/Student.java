package com.qingmin.fanli;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author QingMin Yang
 * @date 2023/9/4 21:23
 */
public class Student {

//    private String name;

    @Resource
    private Teacher teacher;

    // @Resource默认ByName如果找不到则ByType，可以添加到set方法、字段上。
    //@Autowired默认是byType，只会根据类型寻找，可以添加在构造方法、set方法、字段、方法参数上。

    public Student(Teacher teacher) {
    }


    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


//    private final Teacher teacher = new ArtTeacher(); // 写死了。。。
//
    //在以前，如果我们需要制定哪个老师教我们，直接new创建对应的对象就可以了
    public void study(){
        teacher.teach();
    }

//    public void setName(String name) {
//    }


}
