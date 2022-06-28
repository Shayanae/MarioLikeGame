package com.display;

public class Score {

    // VARIABLES
    private final int nbrTotalCoins = 10;
    private int nbrCoins;

    // CONSTRUCTEUR
    public Score(){
        this.nbrCoins = 0;
    }

    // GETTERS
    public int getNbrCoins() {return nbrCoins;}

    public int getNbrTotalCoins() {return nbrTotalCoins;}

    // SETTERS

    public void setNbrCoins(int nbrCoins){this.nbrCoins = nbrCoins;}
}
