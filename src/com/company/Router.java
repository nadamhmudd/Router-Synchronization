package com.company;
import static java.lang.Thread.sleep;
import java.util.Random;

public class Router {

    private boolean[] isconnected;
    public int noccupied;
    public Semaphore connection;

    Router(int x) {
        connection = new Semaphore(x); //Number of available WI-FI Connections
        isconnected = new boolean[x];
    }
    //methods
    public synchronized int occupy(Device ob) throws InterruptedException {
        for(int i=0; i<isconnected.length; i++){
            if(isconnected[i] == false) { //means It's available for being occupied
                noccupied++;
                ob.assignedconnection= i+1;
                System.out.println("Connection " + ob.assignedconnection + ": " + ob.getName() + " occupied");
                isconnected[i] = true;
                sleep((long)(Math.random() * 1000));
                break;
            }
        }
        return ob.assignedconnection;
    }

    public String active() throws InterruptedException {
        sleep((long)(Math.random() * 1000));
        return ("  perform online activity ");
    }

    public synchronized String logout(Device ob) {
        noccupied--;
        isconnected[ob.assignedconnection-1] = false;
        notify();
        return "  Logged out";
    }
}
