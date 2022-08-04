package com.motivity.concurrentpackage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class  MyThreading extends Thread{
   public void run()
    {
        for (int i=0;i<5;++i)
        {
            System.out.println(Thread.currentThread().getName()+" is  "+i);
        }
    }
}
public class ConcurencyEx {
    public static void main(String[] args) {
        MyThreading threading=new MyThreading();
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        executorService.submit(threading);//Submits a Runnable task for execution and returns a Future representing that task. The Future's get method will return null upon successful completion.
        executorService.shutdown();//shutdown in which previously submitted tasks are executed, but no new tasks will be accepted. Invocation has no additional effect if already shut down.


    }
}
