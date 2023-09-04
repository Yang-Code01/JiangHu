package com.qingmin.bean;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author QingMin Yang
 * @date 2023/9/5 0:07
 */
@Component("MediaLinePlanning")
public class MediaLine implements BeanNameAware, BeanClassLoaderAware {

    // 自动执行 下面两个实现方法

    // 实现 BeanNameAware 接口

    @Override
    public void setBeanName(String name) {
        //Bean在加载的时候，容器就会自动调用此方法，将Bean的名称给到我们
        System.out.println("我在加载阶段获得了Bean名字：" + name);
    }

    // BeanClassLoaderAware 接口 可以在 Bean 加载阶段获取当前Bean的类加载器
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("该Bean的类加载器：" + classLoader);
    }
}
