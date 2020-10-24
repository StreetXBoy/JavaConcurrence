package BooleanLock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author 重新做人idea基础学习
 * @date 2020-10-24
 */
public class BooleanlockTest {
        private  final  Lock lock=new BooleanLock();
        public  void syncMethod() throws InterruptedException {
            lock.lock();
            try {
                int randint= ThreadLocalRandom.current().nextInt(10);
                System.out.println(Thread.currentThread() + "get the lock .");
                TimeUnit.SECONDS.sleep(randint);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
