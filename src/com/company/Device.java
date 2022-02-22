package com.company;
import java.util.Random;

//thread class
public class Device extends Thread{
    public static Router sharedconnection;
    public int assignedconnection;
    public String devicetype;

    Device(String devicename, Router list, String type){
        super(devicename); //the name of this thread which is the device name
        sharedconnection= list;
        devicetype= type;
    }

    public void run(){
        sharedconnection.connection.P(this);
        try{
            assignedconnection=sharedconnection.occupy(this);
        }catch(InterruptedException e){}
        try{
            System.out.println("Connection " + assignedconnection + ": " + this.getName() + sharedconnection.active());
        } catch(InterruptedException e){ e.printStackTrace();}
        try{
            //sleep(1000);
            Thread.sleep((long)(Math.random() * 1000));
            System.out.println("Connection " + assignedconnection + ": " + this.getName() + sharedconnection.logout(this));
            sharedconnection.connection.V();
        } catch (InterruptedException ex) {}



    }
}

