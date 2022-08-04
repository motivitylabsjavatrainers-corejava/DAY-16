package com.motivity.concurrentpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Service implements Runnable
{
    Lock lk=new ReentrantLock();
    int count;
    Service(int count)
    {
        this.count=count;
    }
    @Override
    public void run() {
            count++;
            System.out.println(Thread.currentThread().getName()+ "  printing  count is " + count + "  ");
    }
}
public class ExecutiveServicesexample {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
        ExecutorService executorService= Executors.newFixedThreadPool(5);//Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue.

          for (int i=0;i<25;++i)
          {
              executorService.execute(new Service(i));
          }
       // System.out.println("actived "+Thread.activeCount());
          executorService.shutdown();//orderly shutdown in which previously submitted tasks are executed, but no new tasks will be accepted.
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);//wait ExecutorService.awaitTermination()' is ignored
        System.out.println(" service completed ");
    }
}
