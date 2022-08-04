package com.motivity.concurrentpackage;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Counting {
    ReentrantLock lock=new ReentrantLock();
 private  int count=0;

    public void Increment(){
       lock.lock();//Acquires the lock if it is not held by another thread and returns immediately, setting the lock hold count to one.
        count=count+1;
    lock.unlock();//Attempts to release this lock
    }
    public int getCount() {
        return count;
    }
}
public class ReenteredLockExample {
    public static void main(String[] args) throws InterruptedException {
        Counting counter=new Counting();
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        Runnable task1=new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1000;++i)
                {
                    counter.Increment();
                }
            }
        };
        Runnable task2=new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1000;++i)
                {
                    counter.Increment();
                }
            }
        };
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.awaitTermination(3, TimeUnit.MILLISECONDS);
        System.out.println("method invoked "+counter.getCount());
        executorService.shutdown();

    }
}
