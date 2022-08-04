package com.motivity.concurrentpackage;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TraficSignal  implements Runnable
{
    Lock traficlock=new ReentrantLock();
    Condition traficcondition=traficlock.newCondition();

    public void openSignal()
    {

        traficlock.lock();
        traficcondition.signalAll();//Wakes up all waiting threads.
       // traficcondition.signal();//Wakes up one waiting thread.If any threads are waiting on this condition then one is selected for waking up
        traficlock.unlock();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "  waiting fo signal ");
        traficlock.lock();
        try {
            traficcondition.await(10, TimeUnit.MILLISECONDS);
            System.out.println(Thread.currentThread().getName()+"  on moving.... ");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        traficlock.unlock();
    }
}
public class ConditionLockEithTraficEx {
    public static void main(String[] args) throws InterruptedException {

        final int noOfVehicles=5;
        final String vehicles[]={"cars","bikes","vans","buses","ambulance"};
        TraficSignal vehicle=new TraficSignal();
       for (int i=0;i<vehicles.length;++i)
       {
           new Thread(vehicle,vehicles[i]).start();
           Thread.sleep(1000);
           vehicle.openSignal();
       }
    }
}
