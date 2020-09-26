import sun.text.resources.cldr.ii.FormatData_ii;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author 重新做人idea基础学习
 * @date 2020-9-26
 */

//A join B  会一直blocled到 A 完事！！
//注意前面是是create！！！！！！创建没有运行！！！！！
//  正常运行正常结束就会destory！！！！
public class joinUsage {
    public static void main(String[] args) throws InterruptedException {
        List<Thread>threads= IntStream.range(1,3).mapToObj(joinUsage::create).collect(Collectors.toList());
        threads.forEach(Thread::start);
        for (Thread thread:threads){
            thread.join();
        }
        //不join 会乱起来！！！
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"#############"+i);
            TimeUnit.SECONDS.sleep(1);
        }
    }
    private  static  Thread create(int seq){
        return new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"#"+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },String.valueOf(seq));
    }
}
