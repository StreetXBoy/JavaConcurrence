package BooleanLock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author 重新做人idea基础学习
 * @date 2020-10-24
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        BooleanlockTest blt=new BooleanlockTest();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()-> {
                try {
                    blt.syncMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            thread.start();
        }
    }
}
