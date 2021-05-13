package org.example;

import org.example.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3> Clasa SocialServer </h3>
 * <p> Defineste portul de conectare al serverului. </p>
 * <p> Serverul asteapta conexiuni din partea clientilor. </p>
 * <p> Pentru fiecare client nou conectat se va crea un fir de executie / thread. </p>
 */
public class Server {
    public static final int PORT = 2500;
    private static List<ClientThread> clients = new ArrayList();
    public Server() throws IOException, SocketTimeoutException {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            serverSocket.setSoTimeout(180000);
            while(true) {
                System.out.println("Waiting for client ... ");
                Socket socket = serverSocket.accept();
                new ClientThread(socket, serverSocket).start();
            }
        } catch (SocketTimeoutException exp){
            System.err.println("Connection closed due to innactivity.");
        }

    }

    public static List<ClientThread> getClients() {
        return clients;
    }
}
