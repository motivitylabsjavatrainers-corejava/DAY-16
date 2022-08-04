package com.motivity.concurrentpackage;
import java.util.concurrent.CountDownLatch;

class MyTask implements Runnable{

    private CountDownLatch countDownLatch;
    private String name;
    MyTask(String name,CountDownLatch countDownLatch)
    {
        this.name=name;
        this.countDownLatch=countDownLatch;
    }
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"  start "+name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Executing "+name);
        countDownLatch.countDown();
    }
}
public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(1);
        Thread thread1=new Thread(new MyTask("task1",countDownLatch));
        Thread thread2=new Thread(new MyTask("task2",countDownLatch));
        Thread thread3=new Thread(new MyTask("task3",countDownLatch));

        thread1.start();
        thread2.start();
        thread3.start();
        countDownLatch.await();
        System.out.println("all task are executing ..");


    }
}
