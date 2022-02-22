package com.company;
import java.util.Random;

public class Semaphore{
    private static int available;
    //constructors
    Semaphore(int num){
        available=num;
    }
    //methods
    public synchronized void P(Device dev){
        available--;
        if(available<0) {
            try {
                // Thread.sleep(100);
                Thread.sleep((long)(Math.random() * 1000));
                System.out.println(dev.getName()+"("+dev.devicetype+")"+"arrived and waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println(dev.getName()+"("+dev.devicetype+")"+ "arrived");
            try{
                // Thread.sleep(1000);
                Thread.sleep((long)(Math.random() * 1000));
            } catch (InterruptedException ex){}
        }
    }

    public synchronized void V(){
        available++;
        if(available <= 0)
            notify();
    }
}
