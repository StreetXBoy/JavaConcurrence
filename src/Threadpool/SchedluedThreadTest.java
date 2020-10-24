package Threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 重新做人idea基础学习
 * @date 2020-10-24
 */

//NewScheduledThreadPool:
//
//底层：创建ScheduledThreadPoolExecutor实例，corePoolSize为传递来的参数，maximumPoolSize为Integer.MAX_VALUE；keepAliveTime为0；unit为：TimeUnit.NANOSECONDS；workQueue为：new DelayedWorkQueue() 一个按超时时间升序排序的队列
//通俗：创建一个固定大小的线程池，线程池内线程存活时间无限制，线程池可以支持定时及周期性任务执行，如果所有线程均处于繁忙状态，对于新任务会进入DelayedWorkQueue队列中，这是一种按照超时时间排序的队列结构
//适用：周期性执行任务的场景

public class SchedluedThreadTest {
    public static void main(String[] args) {
        ScheduledExecutorService pool= Executors.newScheduledThreadPool(10);
        Runnable r1=()-> System.out.println("name : "+Thread.currentThread().getName()+" execute after 3 seconds");
        Runnable r2=()-> System.out.println("name : "+Thread.currentThread().getName()+" execute after 2 seconds per 3 seconds");
        Runnable r3=()-> System.out.println("name : "+Thread.currentThread().getName()+" execute ");
        pool.schedule(r1,3, TimeUnit.SECONDS);
        pool.scheduleAtFixedRate(r2,2,3,TimeUnit.SECONDS);
        for (int i = 0; i <5 ; i++) {
            pool.execute(r3);
        }
    }

}
