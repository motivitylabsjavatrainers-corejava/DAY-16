package com.motivity.threadSynchronized;

class SynchronizationExample extends Thread {
    int count;
    @Override
    public void run() {
        count++;
    }
}
public class CountTestSynchronizedex {
    public static void main(String[] args) throws Exception{
        SynchronizationExample example=new SynchronizationExample();
        //for (int i=0;i<1000;++i)
        //  {
       //example.run();//this normal way to calling in this no multi-threading concept so its by default synchronized
       // }
       // System.out.println(example.count);

     Thread thread1=new Thread(example);
     for (int i=0;i<1000;++i)
     {
         thread1.start();
     }
        Thread thread2=new Thread(example);
        for (int i=0;i<1000;++i)
        {
            thread2.start();
        }

        System.out.println(example.count);
    }

}
