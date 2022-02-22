package com.company;
import java.util.Scanner;
import java.util.*;


public class Main {

    public static void main(String[] args)  throws InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.println("What is the Number of WI-FI Connections?");
        int nconnect = input.nextInt();
        Router nconnections = new Router(nconnect);

        System.out.println("What is the Number of devices Clients want to connect?");
        int ndevices = input.nextInt();
        Device[] device = new Device[ndevices];

        System.out.println("What is the Client's Name And Type?");
        input = new Scanner(System.in); //as input.getline

        for (int i = 0; i < ndevices; i++) {
            String a = input.nextLine();
            String[] data = a.split(" ");
            device[i] = new Device(data[0], nconnections, data[1]);
        }
        /* Starting all the client threads */
        for (int j = 0; j < ndevices; j++) {
            device[j].start();
        }
    }
}
