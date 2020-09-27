import java.util.concurrent.TimeUnit;

public class DaemonThread {
    //Daemon 后台守护线程

//    当非守护线程停止,守护线程就停止
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                System.out.println("守护线程Thread-T1 "+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                System.out.println("用户线程Thread-T2 "+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t2.setDaemon(true);
        t1.setDaemon(false);
        t1.start();
        t2.start();
    }

}
