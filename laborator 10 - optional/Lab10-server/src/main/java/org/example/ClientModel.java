package org.example;

import java.util.ArrayList;
import java.util.List;

public class ClientModel {
    private String name;
    private int logged;
    public List<String> friends = new ArrayList<>();
    public List<String> messages = new ArrayList<>();

    public ClientModel() {
        this.logged = 0;
    }

    public ClientModel(String name) {
        this.name = name;
        this.logged = 0;
    }

    public int getLogged() {
        return logged;
    }

    public void setLogged(int logged) {
        this.logged = logged;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

