package Threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 重新做人idea基础学习
 * @date 2020-10-24
 */

//newCachedThreadPool：
//
//底层：返回ThreadPoolExecutor实例，corePoolSize为0；maximumPoolSize为Integer.MAX_VALUE；keepAliveTime为60L；unit为TimeUnit.SECONDS；workQueue为SynchronousQueue(同步队列)
//通俗：当有新任务到来，则插入到SynchronousQueue中，由于SynchronousQueue是同步队列，因此会在池中寻找可用线程来执行，若有可以线程则执行，若没有可用线程则创建一个线程来执行该任务；若池中线程空闲时间超过指定大小，则该线程会被销毁。
//适用：执行很多短期异步的小程序或者负载较轻的服务器


public class CachedThread {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i <10 ; i++) {
            final  int ii=i;
            try {
                Thread.sleep(ii);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            pool.execute(()-> System.out.println(Thread.currentThread().getName()+"================>"+ii));
        }
    }
}
