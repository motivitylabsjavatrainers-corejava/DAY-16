package com.motivity.concurrentpackage;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class  Display
{
   ReentrantLock lock=new ReentrantLock();
    public void announcement(String name) throws InterruptedException {
       // lock.lock();
       lock.lock();
        for (int i=0;i<5;++i)
        {
            System.out.print("announcement from ");
            Thread.sleep(2000);
            System.out.println(name);
        }
       lock.unlock();
       // lock.unlock();
    }
}
class Announcement extends  Thread{
     Display display;
     String name;
     Announcement(Display display,String name)
     {
         this.name=name;
         this.display=display;
     }

    @Override
    public void run() {
        try {
            display.announcement(name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class LockingExample {
    public static void main(String[] args) {

        Display display=new Display();
        Announcement announcement=new Announcement(new Display(),"police");
        Announcement announcement2=new Announcement(new Display()," news ");
        announcement.start();
        announcement2.start();

    }
}
