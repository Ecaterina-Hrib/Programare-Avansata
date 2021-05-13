package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; //localhost:2500
        int PORT = 2500;
        System.out.println("Welcome!");
        System.out.println("The commands u should use are the following:");
        System.out.println("1) register x");
        System.out.println("2) login x");
        System.out.println("3) friends a b ... z");
        System.out.println("4) send 'message'");
        System.out.println("5) read");
        System.out.println("6) stop");
        System.out.println("7) exit");
        System.out.println("Your commands: ");
        System.out.println("");

        try (
                Socket socket = new Socket(serverAddress, PORT);

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            while (!socket.isClosed()) {

                BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader serverOutput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("$Chatting>>");
                String request = clientInput.readLine();

                String[] keyboard = request.split(" ");
                String response;

                if (keyboard[0].equals("login") || keyboard[0].equals("register") || keyboard[0].equals("friends") || keyboard[0].equals("send") || keyboard[0].equals("read")||keyboard[0].equals("logout")||keyboard[0].equals("1")||keyboard[0].equals("2")||keyboard[0].equals("3")) {
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                } else if (keyboard[0].equals("stop")) {
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                    socket.close();
                } else if(keyboard[0].equals("exit")){
                    out.println(request);
                    response = serverOutput.readLine();
                    System.out.println(response);
                    socket.close();
                }
            }

        } catch (UnknownHostException exception) {
            System.err.println("No server connected " + exception);
        }
    }}
