package BooleanLock;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @author 重新做人idea基础学习
 * @date 2020-10-24
 */

//自定定义一个锁？？？


    //sychornized 无法控制lock的时间以及终端过程

    //自己实现一个锁!!!!


public interface Lock {
    void lock() throws  InterruptedException;

    void lock(long millions) throws  InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBlockedThreads();
}
