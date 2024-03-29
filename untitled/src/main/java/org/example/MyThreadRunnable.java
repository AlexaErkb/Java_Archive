package org.example;

public class MyThreadRunnable implements Runnable{
    private Thread t;
    private final String name;
    private final Object obj;
    public MyThreadRunnable(String name)
    {
        this.name=name;
        obj=new Object();
    }
    @Override
    public void run() {
        printState();
        try {
            t.sleep(2000);
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
    public void start()
    {
        t=new Thread(this,name);
        printState();
        t.start();
    }

    public  void printState()
    {
        System.out.println(this.name + ": " + t.getState());
        //print the current state of the thread
        /*Add some code here*/
    }

    public  void join() {
        try {
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public  void join(int millis) {
        try {
            t.join(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void threadNotify()
    {
        synchronized (obj) {
            obj.notify();
        }
    }
}

