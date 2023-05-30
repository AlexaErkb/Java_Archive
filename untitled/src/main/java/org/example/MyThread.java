package org.example;

public class MyThread extends Thread{
    private final String name;
    private final Object obj;

    public MyThread(String name)
    {
        this.name=name;
        obj=new Object();
        printState();
    }
    @Override
    public void run() {
        printState();
        try {
            Thread.sleep(2000);
            //Make thread sleep for 2000 milliseconds
            /*Add some code here*/
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (obj) {
            try {
                obj.wait();
                //make the thread wait until it is notified
                /*Add some code here*/
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
        printState();
    }

    public  void printState()
    {
        System.out.println(this.name + ": " + this.getState());
        //print the current state of the thread
        /*Add some code here*/
    }

    public void threadNotify()
    {
        synchronized (obj) {
            obj.notify();
        }
    }
}

