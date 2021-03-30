package org.example.classes;

public class Token {
    private int number;
    private boolean isBlank;

    public Token(int number) {
        this.number = number;
        this.isBlank = false;
    }

    public Token() {
        this.isBlank = true;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBlank() {
        return isBlank;
    }

    public void setBlank(boolean blank) {
        this.isBlank = blank;
    }
}

