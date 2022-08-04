package com.motivity.threadSynchronized;

class  RequestCounter{
    int count;
    public synchronized void incriment()
    {
        count++;
    }
}
public class SynchronizationEx1 {
    public static void main(String[] args) throws InterruptedException {
        RequestCounter requestCounter=new RequestCounter();
       /* requestCounter.incriment();// normal way to call
        requestCounter.incriment();*/
        //if you want to call 2000 times
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1000;++i)
                {
                    requestCounter.incriment();
                }
            }
        });
        Thread thread2=new Thread(new Runnable() {// but sometimes not get output exact that time need to set method as synchronized
            @Override
            public void run() {
                for (int i=0;i<1000;++i)
                {
                    requestCounter.incriment();
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();// join method wait thread until completes
        thread2.join();
        System.out.println("request history  "+requestCounter.count);
    }
}
