package org.example.classes;

import sun.tools.jstat.Token;

import java.util.ArrayList;
import java.util.List;
/*
 * <p>Tbla de joc cu numarul de tokenuri</p>
 */
public class Board {
    private List<Token> tlist;

    public Board(ArrayList<Token> tokenList) {
        this.tlist = tokenList;
    }

    public ArrayList<Token> getTokenList() {
        return (ArrayList<Token>) tlist;
    }

    public void setTokenList(ArrayList<Token> tokenList) {
        this.tlist = tokenList;
    }
}
