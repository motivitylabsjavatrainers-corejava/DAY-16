package com.motivity.concurrentpackage;

import java.util.concurrent.atomic.AtomicInteger;

class UpdateCounter extends Thread {
    AtomicInteger aiCount;
    UpdateCounter(){
        aiCount = new AtomicInteger();
    }
    public void run() {
        int max = 10;

        for(int i=0;i<max;i++)
            aiCount.addAndGet(1);
    }
}
public class AtomicDemo {
    public static void main(String[] args) throws InterruptedException {
        UpdateCounter c = new UpdateCounter();

        Thread t1 = new Thread(c, "Thread1");
        Thread t2 = new Thread(c, "Thread2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.aiCount);
    }
}
