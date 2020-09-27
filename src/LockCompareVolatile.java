import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCompareVolatile {

    //volatile --->
    //1.内存可见性  2.禁止指令重拍
//    某线程对 volatile 变量的修改，对其他线程都是可见的。即获取 volatile 变量的值都是最新的。
//
//    Java 中存在一种原则——先行发生原则（happens-before）。其表示两个事件结果之间的关系：
//    如果一个事件发生在另一个事件之间，其结果必须体现。volatile 的内存可见性就体现了该原则：
//    对于一个 volatile 变量的写操作先行发生于后面对这个变量的读操作。


//    volatile 能保证内存的可见性，但不能保证变量的原子性




//    指令重排：JVM 在编译 Java 代码时或 CPU 在执行 JVM 字节码时，对现有指令顺序进行重新排序，优化程序的运行效率。
//    （在不改变程序执行结果的前提下）
//    指令重排虽说可以优化程序的执行效率，但在多线程问题上会影响结果。那么有什么解决办法呢？
//    答案是内存屏障。内存屏障是一种屏障指令，使 CPU 或编译器对屏障指令之前和之后发出的内存操作执行一个排序的约束。


//    synchronized 关键字可以保证变量原子性和可见性!!!!!!!

    public    int inc=0;
    Lock lock=new ReentrantLock();
    public   void increase(){
        lock.lock();
        try {
            inc++;
        }finally {
            lock.unlock();
        }

    }
    public static void main(String[] args) {
        LockCompareVolatile test=new LockCompareVolatile();
        for (int i = 0; i <10 ; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    test.increase();
                }
            }).start();
        }
        while (Thread.activeCount()>2)
            Thread.yield();
        System.out.println(test.inc);
    }
}
