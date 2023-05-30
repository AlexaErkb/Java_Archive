package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("The different states of a thread are: ");

        /* Add code here */
        ArrayList<Thread.State> states = new ArrayList<>();
        states.add(Thread.State.NEW);
        states.add(Thread.State.RUNNABLE);
        states.add(Thread.State.BLOCKED);
        states.add(Thread.State.WAITING);
        states.add(Thread.State.TIMED_WAITING);
        states.add(Thread.State.TERMINATED);
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

    }
}
