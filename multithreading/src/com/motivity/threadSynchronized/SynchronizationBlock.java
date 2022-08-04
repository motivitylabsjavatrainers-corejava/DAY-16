package com.motivity.threadSynchronized;

class Token implements Runnable
{
    int token = 1;
    public void run ()
    {
        synchronized (this)
        {
            Thread t = Thread.currentThread ();
            String name = t.getName ();
            System.out.println ("token  "+token + " is  alloted to " + name);
            token++;
        }
    }
}
public class SynchronizationBlock {
    public static void main(String[] args) {
        Token token=new Token();
        Thread t1= new Thread(token);
        Thread t2= new Thread(token);
        Thread t3 = new Thread(token);
        t1.setName("thread1");
        t2.setName ("thread2");
        t3.setName ("thread3");
        t1.start ();
        t2.start ();
        t3.start ();
    }

}
