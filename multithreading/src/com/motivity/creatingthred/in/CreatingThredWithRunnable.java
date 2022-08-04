package com.motivity.creatingthred.in;

class Java implements Runnable
{
    @Override
    public void run() {
        System.out.println("in java thred");
        for(int i=1;i<=5;++i)
        {
            System.out.println("i love java");
            try {
                Thread.sleep(200);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Python implements Runnable
{

    @Override
    public void run() {
        System.out.println("in python thred");
        for(int i=1;i<=5;++i)
        {
            System.out.println("i love Python");
        }
    }
}
class PHP implements Runnable
{
    @Override
    public void run() {
        System.out.println("in PHP thred");
        for(int i=1;i<=5;++i)
        {
            System.out.println("i love PHP");

        }
    }
}

public class CreatingThredWithRunnable {
    public static void main(String[] args) throws InterruptedException {
        pythonThread();
        phpThread();
        Java javaThred=new Java();
        Thread th=new Thread(javaThred);
        th.setName("javaThred");//we can set the thread name with setName() method
        th.start();
    }
    public static void pythonThread()
    {
        Python pythonThread=new Python();
        Thread th=new Thread(pythonThread);
        th.setName("pythonThred");
        System.out.println(th.getName());
        th.start();
    }
    public static void phpThread()
    {
        PHP phpThread= new PHP();
        Thread th=new Thread(phpThread);
        th.setName("PHPThred");
        System.out.println(th.getName());
        th.start();
    }

}
