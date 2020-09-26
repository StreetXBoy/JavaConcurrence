import  java.util.concurrent.*;
/**
 * @author 重新做人idea基础学习
 * @date 2020-9-26
 */
public class TryConcurrency {
    public static void main(String[] args) throws InterruptedException {
        new Thread(){
            @Override
            public void run(){
                try {
                    T1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        T2();
    }

    private  static  void T1() throws InterruptedException {
        while (true){
            System.out.println("Thread1");
            sleep(1);
        }
    }
    private  static  void T2() throws InterruptedException {
        while (true){
            System.out.println("Thread2");
            sleep(1);
        }
    }
    private  static  void sleep(int second) throws InterruptedException {
        TimeUnit.SECONDS.sleep(second);
    }
}
