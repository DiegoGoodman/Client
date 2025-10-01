package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Scanner myScanner = new Scanner(System.in);  
        System.out.println("Inserisci l'IP del server: ");
        String ipServer = myScanner.nextLine();
        System.out.println("Inserisci la porta del server: ");
        int portaServer = Integer.parseInt(myScanner.nextLine());
        Socket mySocket = new Socket(ipServer, portaServer);

        BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        PrintWriter out = new PrintWriter(mySocket.getOutputStream(), true);

        String stringaDaInviare; 
        do {
        System.out.println("Inserisci la stringa da inviare o digita '!' per terminare: ");
        stringaDaInviare = myScanner.nextLine();
        out.println(stringaDaInviare);
        String stringaClient = in.readLine();
        if (stringaDaInviare.equals("!"))
            System.out.println("Connesione terminata.");
        else
            System.out.println("La stringa ricevuta dal server e': " + stringaClient);
        }while(!stringaDaInviare.equals("!"));
    }
}