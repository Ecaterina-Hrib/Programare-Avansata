package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8100;//the port that is listening

    public Server() throws IOException{
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Astept clientul...");
                Socket socket = serverSocket.accept();
                System.out.println("Clientul cu id-ul " + socket+ " este conectat! ");
                System.out.println("Asignam threadul ");
                new Client(socket).start();



            }
        } catch (IOException e) {
            System.err.println("Ai gresit ceva " + e);
        }

    }


}
