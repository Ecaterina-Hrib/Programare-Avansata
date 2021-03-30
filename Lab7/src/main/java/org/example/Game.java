package org.example;
import org.example.classes.Board;
import org.example.classes.Player;
import org.example.classes.Token;

import java.util.ArrayList;
/*
 * <p>Tokenuri pentru a juca pe Boarduri, iar scores pentru un feature viitor cu scoruri</p>
 * <p>am declarat jucatorii si i-am pus pe taba,apoi am generat thredurile </p>
 */
public class Game {
    public Game() throws InterruptedException {
        ArrayList<Token> tokens = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();
        for (int i = 0; i <= 16; i++) {
            tokens.add(new Token(i));
        }
        Board newBoard = new Board(tokens);

        Runnable runnable1 = new Player("Ana", newBoard);
        Runnable runnable2 = new Player("Alin", newBoard);
        while (newBoard.getTokenList().size() > 1) {
            new Thread(runnable1).start();
            new Thread(runnable1).sleep((long) 100.0);
            new Thread(runnable2).start();
        }
        System.out.println();
    }
}