package com.motivity.creatingthred.in;

class MyThread extends Thread {
    public void run()
    {
        for (int i=0;i<5;++i)
        {
            System.out.println("in child thread");
            Thread.currentThread().setName("chlidthred ");
            System.out.println("thread name  " +Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
  }
public class CreatingThreadWithThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread=new MyThread();
        System.out.println("thread name "+ Thread.currentThread().getName());
        thread.start();
        for (int i=0;i<5;++i)
        {
            System.out.println("in main thread");
            Thread.sleep(1000);
        }
    }
}