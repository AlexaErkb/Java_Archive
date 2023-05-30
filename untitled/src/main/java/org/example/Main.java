package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("The different states of a thread are: ");

        /* Add code here */
        Thread.State[] states = Thread.State.values();
        for(Thread.State state:states)
        {
            System.out.print(state+" ");
        }
        System.out.print("\nLet's get practical:\n");

        MyThreadRunnable t=new MyThreadRunnable("Thread States");
        t.start();
        t.join(500);
        //wait 500 milliseconds for the thread to die
        /*Add code here*/
        t.printState();
        t.join(3000);
        t.printState();
        t.threadNotify();
        //Notify thread to wake up
        /* Add code here */
        t.printState();
        t.join();
        //wait forever for the thread to die
        /* Add code here */
        t.printState();

        System.out.println();
        MyThread t2=new MyThread("Thread States");
        t2.start();
        t2.join(500);
        //wait 500 milliseconds for the thread to die
        /*Add code here*/
        t2.printState();
        t2.join(3000);
        t2.printState();
        t2.threadNotify();
        //Notify thread to wake up
        /* Add code here */
        t2.printState();
        t2.join();
        //wait forever for the thread to die
        /* Add code here */
        t2.printState();

    }
}
