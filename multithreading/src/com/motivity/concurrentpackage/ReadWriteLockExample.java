package com.motivity.concurrentpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Counte
{
   ReadWriteLock lock=new ReentrantReadWriteLock();

    private  int count=0;

    public void Increment(){

        try {
            lock.writeLock().lock();//Acquires the lock if it is not held by another thread and returns immediately, setting the lock hold count to one.

        count=count+1;}finally {
            lock.writeLock().unlock();//Attempts to release this lock
        }

    }
    public int getCount() {

        try {
            lock.readLock().lock();
            return count;
        }
       finally {
            lock.readLock().unlock();
        }
    }
}
public class ReadWriteLockExample {
    public static void main(String[] args) throws InterruptedException {

        Counte counters=new Counte();
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        Runnable task1=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ "  waiting for counting ");
                for (int i=0;i<1000;++i)
                {
                    counters.Increment();
                }
            }
        };
        Runnable task2=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" getting value of count variable ");

                System.out.println("value of the variable is "+counters.getCount());
            }
        };
        Runnable task3=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" getting value of count variable ");

                System.out.println("value of the variable is "+counters.getCount());
            }
        };

        executorService.submit(task1);
        executorService.awaitTermination(2,TimeUnit.SECONDS);
        executorService.submit(task2);
        executorService.submit(task3);


        executorService.shutdown();


    }
}
