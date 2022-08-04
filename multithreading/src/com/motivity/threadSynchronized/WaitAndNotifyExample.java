package com.motivity.threadSynchronized;

class CountTotal extends Thread
{
    int total;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<100 ; i++){
                total += i;
            }
            notify();//notify() wakes up the first thread that called wait() on the same object.
        }
    }
}
public class WaitAndNotifyExample {
    public static void main(String[] args) {
            CountTotal totalthread = new CountTotal();
            totalthread.start();

            synchronized(totalthread){
                try{
                    System.out.println(Thread.currentThread().getName()+"  Waiting for counting to complete...");
                    totalthread.wait();//sleep until some other thread enters the same monitor and calls notify( ).
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println("Total is: " + totalthread.total);
            }
        }
    }

