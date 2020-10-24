package Threadpool;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author 重新做人idea基础学习
 * @date 2020-10-24
 */

//没有new ！！！不是new FixedThrea 注意 ！！！
//底层：返回ThreadPoolExecutor实例，接收参数为所设定线程数量nThread，corePoolSize为nThread，maximumPoolSize为nThread；keepAliveTime为0L(不限时)；unit为：TimeUnit.MILLISECONDS；WorkQueue为：new LinkedBlockingQueue<Runnable>() 无界阻塞队列
//通俗：创建可容纳固定数量线程的池子，每隔线程的存活时间是无限的，当池子满了就不在添加线程了；如果池中的所有线程均在繁忙状态，对于新任务会进入阻塞队列中(无界的阻塞队列)
//适用：执行长期的任务，性能好很多


public class FixedThreadTest {
    public static void main(String[] args) {
        ExecutorService pool=  Executors.newFixedThreadPool(3);
        for (int i = 0; i <10 ; i++) {
            final  int ii=i;
            pool.execute(()-> {
                System.out.println(Thread.currentThread().getName() + "====> " + ii);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }


}
