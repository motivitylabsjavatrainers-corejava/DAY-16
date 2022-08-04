package com.motivity.concurrentpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
class TaskWriter implements Runnable
{
    String wishes;
    TaskWriter(String wishes)
    {
        this.wishes=wishes;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Good "+wishes);
        System.out.println(" task completed ");
    }
}
public class ScheduledExecuter {
    public static void main(String[] args) {
        TaskWriter writer=new TaskWriter(" morning");
       ScheduledExecutorService scheduledExecuter= Executors.newScheduledThreadPool(1);//schedule methods create tasks with various delays and return a task object that can be used to cancel or check executio
       scheduledExecuter.schedule(writer,5, TimeUnit.MILLISECONDS);//command – the task to execute delay – the time from now to delay execution unit – the time unit of the delay parameter
       scheduledExecuter.shutdown();
    }
}
