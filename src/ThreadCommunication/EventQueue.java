package ThreadCommunication;

import java.util.LinkedList;
import  static  java.lang.Thread.currentThread;

/**
 * @author 重新做人idea基础学习
 * @date 2020-10-11
 */


//学习java 原生通信api 以及 wait和notify关键字！！！！


 //wait 很简单就是等！！！！ notify 就是唤醒因为wait进入阻塞的线程！！！！！   --->释放！！！

public class EventQueue {
    private  final  int max;
    static  class  Event{

    }

    private  final LinkedList<Event>eventQueue=new LinkedList<>();

    private  final  static  int DEFAULT_MAX_EVENT=10;

    public  EventQueue(){
        this.max=DEFAULT_MAX_EVENT;
    }

    public EventQueue(int max){
        this.max=max;
    }



    public  void offer(Event event){
        synchronized (eventQueue){
            if(eventQueue.size()>=max){
                try {
                    System.out.println(currentThread().getName()+"The queue is full!!");
                    eventQueue.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(currentThread().getName()+"the new event is submitted!");
            eventQueue.addLast(event);
            eventQueue.notify();
        }
    }


    public  Event take(){
        synchronized (eventQueue){
            if(eventQueue.isEmpty()){
                try{
                    System.out.println(currentThread().getName()+"the queue is empty!");
                    eventQueue.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            Event event=eventQueue.removeFirst();
            eventQueue.notify();
            System.out.println(currentThread().getName()+"the event "+event+"is handled.  ");
            return event;
        }

    }




}
