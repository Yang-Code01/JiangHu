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