package com.qingmin.bean;

import org.springframework.stereotype.Component;

/**
 * @author QingMin Yang
 * @date 2023/9/4 21:12
 */

@Component("planning")
public class Planning {

    private String name;


    public void sayHallo() {
        System.out.println("hello");
    }
}
