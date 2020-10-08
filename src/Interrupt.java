import javax.xml.bind.SchemaOutputResolver;
import java.util.concurrent.TimeUnit;

/**
 * @author 重新做人idea基础学习
 * @date 2020-10-08
 */


//千万注意！！！！！：start是启动线程，run只是单纯的调用方法，不会启动线程。

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
