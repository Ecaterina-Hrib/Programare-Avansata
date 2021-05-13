package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/*
* <p>Aceasta clasa extinde clasa Thread, pentru a servi concurent mai multi clienti</p>
 */
public class ClientThread extends Thread {
    private Socket socket = null;
    private List<ClientModel> users = new ArrayList<>();
    private int serverStopped = 0;
    private List<ClientThread> clients = new ArrayList();
    private int idClient;
    private ServerSocket serverSocket;

    public ClientThread(Socket socket, ServerSocket serverSocket) {
        this.socket = socket;
        this.serverSocket = serverSocket;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            populateClients();
            while (!socket.isClosed()) {
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                if (serverStopped == 0) {
                    this.clients = Server.getClients();
                    idClient = clients.size();
                    clients.add(this);
                } else if (serverStopped == 1 && clients.size() == 0) {
                    this.socket.close();
                }
                String request = input.readLine();
                String response = null;

                String[] keyboard = null;
                if (request != null) {
                    keyboard = request.split(" ");
                    request = keyboard[0];
                }
                int loginStatus = 0;

                System.out.println("Request from client: " + request);

                if (request == null) {
                    response = "Server stopped";
                    out.println(response);
                    out.flush();
                    serverStopped = 1;
                    this.socket.close();
                    System.exit(1);
                } else if (request.equals("stop")) {
                    response = "Server stopped";
                    out.println(response);
                    out.flush();
                    serverStopped = 1;
                } else if (request.equals("exit")) {
                    users.get(loginStatus).setLogged(0);
                    response = "Disconnected";
                    out.println(response);
                    out.flush();
                    this.socket.close();
                    clients.remove(idClient);
                } else if (request.equals("login")|| request.equals("2")) {
                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).getName().equals(keyboard[1])) {
                            loginStatus = i;
                            idClient = loginStatus;
                        }

                    }
                    if (loginStatus == 0) {
                        response = "This user does not exist.";
                        out.println(response);
                        out.flush();
                    } else if (loginStatus > 0 && users.get(loginStatus).getLogged() == 0) {
                        users.get(loginStatus).setLogged(1);
                        response = "Logged in.";
                        out.println(response);
                        out.flush();
                    } else if (loginStatus > 0 && users.get(loginStatus).getLogged() == 1) {
                        response = "you are already logged in";
                        out.println(response);
                        out.flush();
                    }
                } else if (request.equals("register")||request.equals("1")) {
                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).getName().equals(keyboard[1])) {
                            loginStatus = 1;
                        }
                    }
                    if (loginStatus == 0) {
                        ClientModel userNou = new ClientModel(keyboard[1]);
                        users.add(userNou);
                        out.println("The account " + userNou.getName() + " was created");
                        out.flush();
                    } else {
                        out.println("This user already exists.");
                        out.flush();
                    }
                } else if (request.equals("friends")||request.equals("3")) {
                    int noNewFriends = 0;
                    for (int i = 1; i < keyboard.length; i++) {
                        int okUserExists = 0;
                        for (int j = 0; j < users.size(); j++) {
                            if (users.get(j).getName().equals(keyboard[i])) {
                                okUserExists = j;
                            }
                        }
                        int okFriendExists = 0;
                        for (int j = 0; j < users.get(idClient).friends.size(); j++) {
                            if (users.get(idClient).friends.get(j).equals(keyboard[i])) {
                                okFriendExists = 1;
                            }
                        }
                        if (okFriendExists == 0 && okUserExists > 0) {
                            noNewFriends++;
                            users.get(loginStatus).friends.add(keyboard[i]);
                        }
                    }
                    if (noNewFriends == 0) {

                        out.println("The users are already your friends or they aren't registered.");
                        out.flush();
                    } else {
                        response = "You have " + noNewFriends + " new friends.";
                        out.println(response);
                        out.flush();
                    }
//                    }
                } else if (request.equals("send")) {
                    if (users.get(idClient).friends.size() == 0) {
                        response = "You have 0 friends. Messange cannot be sent.";
                    } else {
                        String text = users.get(idClient).getName() + ":";
                        for (int i = 1; i < keyboard.length; i++) {
                            text = text + " " + keyboard[i];
                        }
                        for (int i = 0; i < users.get(idClient).friends.size(); i++) {
                            int id = 0;
                            for (int j = 0; j < users.size(); j++) {
                                if (users.get(j).getName().equals(users.get(idClient).friends.get(i))) {
                                    id = j;
                                }
                            }
                            users.get(id).messages.add(text);
                            response = "Message sent.";
                        }
                    }
                    out.println(response);
                    out.flush();
                } else if (request.equals("read")) {
                    if (users.get(idClient).messages.size() == 0) {
                        response = "You have 0 new messages.";
                    } else {
                        for (int i = 0; i <= users.get(idClient).messages.size(); i++) {
                            response = users.get(idClient).messages.get(i) + "\n";
                        }
                    }
                    out.println(response);
                    out.flush();
                } else if(request.equals("logout")){
                    response = "Logout!";
                    out.println(response);
                    out.flush();
                }else {
                    response = "Server received an invalid request ... ";
                    out.println(response);
                    out.flush();
                }
            }
        } catch (IOException exception) {
            System.err.println("Astept");
        }
    }

    private void populateClients() {
        ClientModel user = new ClientModel("-");
        users.add(user);
        user = new ClientModel("eca");
        users.add(user);
        user = new ClientModel("Stefan");
        users.add(user);
        user = new ClientModel("carina");
        users.add(user);
        user = new ClientModel("katy");
        users.add(user);

    }

}
