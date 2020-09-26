import java.util.concurrent.TimeUnit;

/**
 * @author 重新做人idea基础学习
 * @date 2020-9-26
 */
public class CurrentThread {
    public static void main(String[] args) {
        //注意写法！！！new Thre he start
        Thread thread=new Thread()
        {
            @Override
            public void run(){
                System.out.println("Current");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        String name=Thread.currentThread().getName();
        System.out.println(name);
    }
}
