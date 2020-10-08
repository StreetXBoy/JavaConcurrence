package joinProjectTrainning;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author 重新做人idea基础学习
 * @date 2020-10-08
 */
public class FightQueryTasks extends Thread implements FightQuery{

    private  final String from;

    private  final  String to;

    private  final  List<String> flightList=new ArrayList<>();

    public FightQueryTasks(String airline,String from,String to){
        super("["+airline+"]");
        this.from=from;
        this.to=to;
    }

    public FightQueryTasks(String from, String to) {
        this.from = from;
        this.to = to;
    }


    @Override
    public void run(){
        System.out.printf("%s-query from %s to %s \n",getName(),from,to);
        int randTime= ThreadLocalRandom.current().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(randTime);
            this.flightList.add(getName()+" - "+randTime);
            System.out.printf("The fight:%s list query success\n",getName());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<String> get() {
        return this.flightList;
    }
}
