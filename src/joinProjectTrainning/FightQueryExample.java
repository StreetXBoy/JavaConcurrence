package joinProjectTrainning;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 重新做人idea基础学习
 * @date 2020-10-08
 */


//final 被修饰的变量为常量bai一旦赋值不能修改,被修du改的方法为最终方zhi法不能
//        被重写，被修dao饰的类是最终类，不能被继承
//static 被修饰的变量和方法，为该整个类及其类的对象所共享，一个类或对
//        象修改了被定义的类或方法，其他的也会跟着变量。。这就是说被static修饰的
//        是大家共用的。。
//Collectors.toList()   !!!!  不是直接toList!!!!

public class FightQueryExample {
    private  static List<String> fightCompany= Arrays.asList("CSA","CEA","HNA");

    public static void main(String[] args) {
        List<String> results =search("SH","BJ");
        System.out.println("================result========================");
        results.forEach(System.out::println);
    }



    private  static  List<String>search(String from, String to){
        final List<String>result =new ArrayList<>();
        List<FightQueryTasks> tasks=fightCompany.stream().map(f->createSearchTasks(f,from,to)).collect(Collectors.toList());
        tasks.forEach(Thread::start);


        //join 每一个线程!!!!!
        tasks.forEach(t->
        {
            try {
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });


        tasks.stream().map(FightQuery::get).forEach(result::addAll);

        return  result;

    }
    private  static  FightQueryTasks createSearchTasks(String fight,String from ,String to){
        return  new FightQueryTasks(fight,from,to);
    }
}
