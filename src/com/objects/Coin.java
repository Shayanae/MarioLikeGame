package com.objects;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Coin extends Object implements Runnable{

    // VARIABLES
    private int counter;
    private final int pause = 15; // temps d'attente entre 2 tours de boucle

    // CONSTRUCTEUR
    public Coin(int x, int y){
        super(x,y,30,30);

        super.icoObject = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/piece1.png")));
        super.imgObject = this.icoObject.getImage();
    }

    // GETTERS

    // SETTERS

    // METHODES
    public Image move(){ // Mouvement de la pièce
        String str;
        ImageIcon ico;
        Image img;

        this.counter++;
        if (this.counter/100 == 0){ str = "/images/piece1.png";}
        else{str = "/images/piece2.png";}
        if (this.counter == 200){this.counter = 0;}

        // Affichage de l'image du personnage
        ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        img = ico.getImage();
        return img;
    }

    @Override
    public void run() {
        try{Thread.sleep(20);} // On attend 20 ms avant d'appeler bouge pour que tous les objets soient complètement créés
        catch (InterruptedException e){}

        while (true){ // boucle infinie
            this.move();
            try{Thread.sleep(pause);}
            catch (InterruptedException e){}
        }
    }
}
