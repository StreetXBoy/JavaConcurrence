package BooleanLock;

import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

/**
 * @author 重新做人idea基础学习
 * @date 2020-10-24
 */
public class BooleanLock implements Lock{
    private  Thread currentThread;

    private  boolean locked=false;

    private  final List<Thread>BlockedList=new ArrayList<>();

    @Override
    public  void lock() throws InterruptedException{
        synchronized (this){
            while (locked){
                if(!BlockedList.contains(Thread.currentThread())){
                    BlockedList.add(Thread.currentThread());
                }
                this.wait();
            }
            BlockedList.remove(Thread.currentThread());
            this.locked=true;
            this.currentThread=Thread.currentThread();
        }
    }

    @Override
    public  void lock(long mills) throws InterruptedException, TimeoutException{
        synchronized (this){
            if(mills<=0){
                this.lock();
            }else{
                long remaintime=mills;
                long endtime=System.currentTimeMillis()+remaintime;
                while (locked){
                    if ((remaintime<=0)) {
                        throw new TimeoutException("can not get the lock during "+mills);
                    }
                    if(!BlockedList.contains(Thread.currentThread())) {
                        BlockedList.add(Thread.currentThread());
                    }
                    this.wait(remaintime);
                    remaintime=endtime-System.currentTimeMillis();
                }
                BlockedList.remove(Thread.currentThread());
                this.locked=true;
                this.currentThread=Thread.currentThread();
            }
        }
    }

    @Override
    public  void unlock(){
        synchronized (this){
            if(currentThread==Thread.currentThread()){
                this.locked=false;
                Optional.of(currentThread.getName()+" release the lock ").ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }


    //返回不可修改的视图保持封装性！！！

    @Override
    public  List<Thread> getBlockedThreads(){
        return Collections.unmodifiableList(BlockedList);
    }
}
