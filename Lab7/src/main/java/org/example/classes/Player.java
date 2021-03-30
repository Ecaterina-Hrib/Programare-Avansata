package org.example.classes;
import java.util.Random;
import org.example.classes.Token;
/*
* <p>Fiecare player are un nume si apartine unei table de joc</p>
 */
public class Player implements Runnable {
    private String name;
    private Board playBoard;

    public Player(String name, Board playBoard) {
        this.name = name;
        this.playBoard = playBoard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getPlayBoard() {
        return playBoard;
    }

    public void setPlayBoard(Board playBoard) {
        this.playBoard = playBoard;
    }

    @Override
    public void run() {
        try {
            Random rand = new Random();
            Token pickedToken = playBoard.getTokenList().get(rand.nextInt(playBoard.getTokenList().size()));
            playBoard.getTokenList().remove(pickedToken);
            if (playBoard.getTokenList().size() == 0) {
                System.out.println("Ai castigat " + this.name + "! Felicitari!");
            } else {
                System.out.println("Player " + this.name + " cu numarul " + pickedToken.getNumber());
            }
        } catch (Exception e) {
            System.out.println("N-am tokenuri");
        }
    }
}
