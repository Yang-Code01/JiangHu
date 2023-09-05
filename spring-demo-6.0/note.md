## 任务调度

```text
为了执行某些任务，我们可能需要一些非常规的操作，
比如我们希望使用多线程来处理我们的结果或是执行一些定时任务，
到达指定时间再去执行。
这时我们首先想到的就是创建一个新的线程来处理，
或是使用TimerTask来完成定时任务，
但是我们有了Spring框架之后，就不用这样了，
因为Spring框架为我们提供了更加便捷的方式进行任务调度。

首先我们来看异步任务执行，
需要使用Spring异步任务支持，
我们需要在配置类上添加@EnableAsync注解。
```
```java
@EnableAsync
@Configuration
@ComponentScan("com.test.bean")
public class MainConfiguration {
}
```

```java
@Async // 异步执行方法的注解
public void asyncTest() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"我是异步执行的方法，开始...");
        Thread.sleep(3000);
        System.out.println("我是异步执行的方法，结束！");
        }
```

## 定时任务
```text
定时任务其实就是指定在哪个时候再去执行，
在JavaSE阶段我们使用过TimerTask来执行定时任务。
Spring中的定时任务是全局性质的，当我们的Spring程序启动后，
那么定时任务也就跟着启动了，我们可以在配置类上添加@EnableScheduling注解
```
```java
@EnableScheduling
@Configuration
@ComponentScan("com.test.bean")
public class MainConfiguration {

    @Scheduled(fixedDelay = 200) // 单位依然是毫秒，这里是每两秒钟打印一次
    public static void tesk() {
        System.out.println("定时任务 ： " + new Date());
    }
}
```
我们注意到@Scheduled中有很多参数，
我们需要指定'cron', 'fixedDelay(String)', 
or 'fixedRate(String)'的其中一个，否则无法创建定时任务，他们的区别如下：
- fixedDelay：在上一次定时任务执行完之后，间隔多久继续执行。
- fixedRate：无论上一次定时任务有没有执行完成，两次任务之间的时间间隔。
- cron：如果嫌上面两个不够灵活，你还可以使用cron表达式来指定任务计划。


## 监听器
```java
@Component
public class TestListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println(event.getApplicationContext());   //可以直接通过事件获取到事件相关的东西
    }
}
```

## AOP面向切片
在运行时，动态地将代码切入到类的指定方法、指定位置上。也就是说，我们可以使用AOP来帮助我们在方法执行前或执行之后，做一些额外的操作，实际上，它就是代理！

通过AOP我们可以在保证原有业务不变的情况下，添加额外的动作，比如我们的某些方法执行完成之后，
需要打印日志，那么这个时候，我们就可以使用AOP来帮助我们完成，它可以批量地为这些方法添加动作。
可以说，它相当于将我们原有的方法，在不改变源代码的基础上进行了增强处理。
不改变原有代码，也就是不需要在改动别人的代码，我们就可以动态的添加log实现 查bug

相当于我们的整个业务流程，被直接斩断，并在断掉的位置添加了一个额外的操作，
再连接起来，也就是在一个切点位置插入内容。它的原理实际上就是通过动态代理机制实现


## 使用配置实现AOP
Spring是支持AOP编程的框架之一（实际上它整合了AspectJ框架的一部分），要使用AOP我们需要先导入一个依赖：
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>6.0.10</version>
</dependency>
```
那么，如何使用AOP呢？首先我们要明确，要实现AOP操作，我们需要知道这些内容：
1. 需要切入的类，类的哪个方法需要被切入
2. 切入之后需要执行什么动作
3. 是在方法执行前切入还是在方法执行后切入
4. 如何告诉Spring需要进行切入

