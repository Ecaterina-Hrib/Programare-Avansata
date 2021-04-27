package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {
    private Socket socket = null;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // request server to client
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            // server to client
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            String raspuns = "Comanda X:  " + request + "!";
            out.println(raspuns);
            out.flush();

            if (request.equals("Bye!")) {
                System.out.println("Clientul " + this.socket + " se termina...");
                System.out.println("Stop connection!");
                this.socket.close();
                System.out.println("Conn closed!");
            } else if ((request.equals("Stop"))) {
                socket.shutdownInput();
                socket.close();
                String cmd = "kill $(lsof -t -i:8100)";
                Runtime run = Runtime.getRuntime();
                Process pr = run.exec(cmd);
                System.out.println("Server stopped!");
            }
        } catch (IOException e) {
            System.err.println("Eroare de comunicare " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
