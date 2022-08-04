package com.motivity.threadSynchronized;

public class DeadLockExam {
    public static void main(String[] args) {
        final String resource1 = "room 1 ";
        final String resource2 = "room 2";
        Thread t1 = new Thread() {
            public void run() {
                synchronized(resource1) {
                    System.out.println("Thread 1: Locked resource1"+resource1);
                    try {
                        Thread.sleep(200);
                    }
                    catch(Exception e) {}
                    synchronized(resource2) {
                        System.out.println("Thread 1: Locked resource2"+resource2);
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                synchronized(resource1) {
                    System.out.println("Thread 2: Locked resource1"+resource1);
                    try {
                        Thread.sleep(200);
                    } catch(Exception e) {}
                    synchronized(resource2) {
                        System.out.println("Thread 2: Locked resource2"+resource2);
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
