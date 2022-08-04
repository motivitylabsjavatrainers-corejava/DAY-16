package com.motivity.practice;

class Counter{
    int count;
}
class IncreageThread implements Runnable
{
    String name;
    Counter counter;
    public IncreageThread(String name, Counter counter) {
        this.name = name;
        this.counter = counter;
        new Thread(this).start();
    }
    @Override
    public void run() {

        System.out.println("thread ");
    }
}
public class SemaphoreExample {
    public static void main(String[] args) {


    }
}
