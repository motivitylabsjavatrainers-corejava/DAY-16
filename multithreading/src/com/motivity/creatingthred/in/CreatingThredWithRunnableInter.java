package com.motivity.creatingthred.in;
class ChildThread implements Runnable
{
    @Override
    public void run() {
        for (int i=0;i<5;++i)
        {
            System.out.println("child  thread printing");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class CreatingThredWithRunnableInter {
    public static void main(String[] args) {
        Thread.currentThread().getName();
        ChildThread child=new ChildThread();
        Thread childThread=new Thread(child);
        childThread.start();
        for (int i=0;i<5;++i)
        {
            System.out.println("main thread printing");
        }
    }
}
