package com.motivity.threadSynchronized;

class Display{
    //public  void mike(String name) throws InterruptedException {  //if not synchronized output will get clumsy
    public synchronized void mike(String name) throws InterruptedException { // this is synchronized method it will get clear out
        for (int i=0;i<10;++i)
        {
            System.out.print("haii this  announcement from  ");
            Thread.sleep(100);
            System.out.println(name);
        }
    }
}
class MyThread extends Thread
{
    Display display;
    String name;
    MyThread(Display display,String name)
    {
        super();
        this.display=display;
        this.name=name;
    }
    @Override
    public void run() {
        try {
            display.mike(name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class SynchronizedExample {
    public static void main(String[] args) {

        Display display=new Display();
        Display display1=new Display();
        MyThread thread1=new MyThread(display,"police");
        MyThread thread2=new MyThread(display1,"railway");
        thread1.start();
        thread2.start();
    }
}
