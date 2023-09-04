package com.qingmin.bean;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author QingMin Yang
 * @date 2023/9/5 0:01
 */
@Component
public class AForB {

    @Resource
    private BForA b;
}
