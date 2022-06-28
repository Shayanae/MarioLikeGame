package com.personnages;

import com.objects.Object;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Turtle extends Characters implements Runnable{

    private Image imgTurtle;
    private ImageIcon icoTurtle;
    private final int pause = 15; // temps d'attente en ms entre 2 tours de boucle
    private int dxTurtle; // pas de déplacement de la tortue

    // CONSTRUCTEUR
    public Turtle (int x, int y){
        super(27, 30,x, y );
        super.setToRight(true);
        super.setWalk(true);
        this.dxTurtle = 1;

        this.icoTurtle = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/tortueArretGauche.png")));
        this.imgTurtle = this.icoTurtle.getImage();

        Thread stopwatchMush = new Thread(this);
        stopwatchMush.start();
    }

    // GETTERS

    public Image getImgTurtle() {return imgTurtle;}

    // SETTERS

    // METHODES
    public void move(){ // Déplacement de la tortue
        if (super.isToRight()){this.dxTurtle = 1;}
        else{this.dxTurtle = -1;}
        super.setX(super.getX() + this.dxTurtle);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(20);
        } // On attend 20 ms avant d'appeler bouge pour que tous les objets soient complètements
        catch (InterruptedException e) {
        }

        while (true) { // boucle infinie
            if (this.alive) {
                this.move();
                try {
                    Thread.sleep(pause);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public void contact (Object object){
        // Contact horizontal
        if (super.frontContact(object) && this.isToRight()){
            super.setToRight(false);
            this.dxTurtle = -1;
        }else if (super.backContact(object) && !this.isToRight()){
            super.setToRight(true);
            this.dxTurtle = 1;
        }
    }

    public void contact (Characters character){
        if(super.frontContact(character) && this.isToRight()){
            super.setToRight(false);
            this.dxTurtle = -1;
        } else if (super.backContact(character) && !this.isToRight()) {
            super.setToRight(true);
            this.dxTurtle = 1;
        }
    }

    public Image die(){
        String str;
        ImageIcon ico;
        Image img;

        str = "/images/tortueFermee.png";
        ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        img = ico.getImage();
        return img;
    }
}
