package com.display;

import com.jeu.Main;

public class Countdown implements Runnable{

    // VARIABLES
    private final int pause = 1000;
    private int timeCounter;
    private String str;

    // CONSTRUCTEUR

    public Countdown(){
        this.timeCounter = 100;
        this.str = "Temps restant : 100";

        Thread countdown = new Thread(this);
        countdown.start();
    }

    // GETTERS


    public int getTimeCounter() {return timeCounter;}

    public String getStr() {return str;}

    // SETTERS

    // METHODES

    @Override
    public void run() {
        while (true){ // boucle infinie
            try{Thread.sleep(pause);}
            catch (InterruptedException e){}
            if (!Main.scene.gameEnd()) {
                this.timeCounter--;
                this.str = "Temps restant: " + this.timeCounter;
            }
        }
    }
}
