package com.motivity.concurrentpackage;

import java.util.concurrent.CyclicBarrier;
class Task1 implements Runnable
{
    @Override
    public void run() {

    }
}
public class CyclicBarrierExample implements Runnable{
    public static CyclicBarrier cyclicBarrier=new CyclicBarrier(3);

    public static void main(String[] args) {
        CyclicBarrierExample example=new CyclicBarrierExample();
        Thread thread=new Thread(example);
        thread.start();
    }

    @Override
    public void run() {

    }
}
