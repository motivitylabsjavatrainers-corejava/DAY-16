package com.motivity.concurrentpackage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class TaskWrite implements Runnable
{
    String wishes;
    TaskWrite(String wishes)
    {
        this.wishes=wishes;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Good "+wishes);
        System.out.println(" task completed ");
    }
}
public class ScheduledExecuterPeriodically {
    public static void main(String[] args) {

        TaskWrite write=new TaskWrite(" morning");
        ScheduledExecutorService scheduledExecuter= Executors.newScheduledThreadPool(5);//schedule methods create tasks with various delays and return a task object that can be used to cancel or check executio
        scheduledExecuter.scheduleAtFixedRate(write,1,5,TimeUnit.MILLISECONDS);//it will run until exception or a ScheduledFuture representing pending completion of the task, and whose get() method will throw an exception upon cancellation

        //scheduledExecuter.shutdown();
    }
}
