package Threadpool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 重新做人idea基础学习
 * @date 2020-10-24
 */

//newSingleThreadExecutor:
//
//底层：FinalizableDelegatedExecutorService包装的ThreadPoolExecutor实例，corePoolSize为1；maximumPoolSize为1；keepAliveTime为0L；unit为：TimeUnit.MILLISECONDS；workQueue为：new LinkedBlockingQueue<Runnable>() 无解阻塞队列
//通俗：创建只有一个线程的线程池，且线程的存活时间是无限的；当该线程正繁忙时，对于新任务会进入阻塞队列中(无界的阻塞队列)
//适用：一个任务一个任务执行的场景

public class SingleThreadTest {
    public static void main(String[] args) {
        ExecutorService pool= Executors.newSingleThreadExecutor();
        for (int i = 0; i <10 ; i++) {
            final  int ii=i;
            pool.execute(()-> System.out.println(Thread.currentThread().getName()+"====> "+ii));
        }


    }

}
