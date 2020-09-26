import java.util.stream.IntStream;

/**
 * @author 重新做人idea基础学习
 * @date 2020-9-26
 */
public class YieldThread {
    public static void main(String[] args) {
        //对象映射！！！
        IntStream.range(0,2).mapToObj(YieldThread::create).forEach(Thread::start);
        IntStream.range(3,7).mapToObj(YieldThread::create).forEach(Thread::start);
    }
    private  static  Thread create(int index){
        //理解闭包 直接生成！！！！
        //yield让！！！
        return  new Thread(()->
        {
            if(index==0){
                Thread.yield();
            }
            System.out.println(index);
        });
    }
}
