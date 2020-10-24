import javax.xml.bind.SchemaOutputResolver;
import java.util.concurrent.TimeUnit;

/**
 * @author 重新做人idea基础学习
 * @date 2020-10-08
 */


//千万注意！！！！！：start是启动线程，run只是单纯的调用方法，不会启动线程。
//interrput 相当于block！！！！阻塞线程

    //isinterred  interrupted 都是判断是否被中断！！！！！但是interrupted会抹去线程标志第二次调用永远返回true！！！


public class Interrupt {
    public static void main(String[] args) {
        Thread thread =new Thread(()->
        {
            try {
                TimeUnit.SECONDS.sleep(10);
            }catch (InterruptedException e){
                System.out.println("Thread was interrputed!!!");
            }
        }
        );
        thread.start();
        thread.interrupt();
    }
}
