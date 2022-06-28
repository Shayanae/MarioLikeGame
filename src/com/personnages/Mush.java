package com.personnages;

import com.jeu.Main;
import com.objects.Object;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Mush extends Characters implements Runnable{
    private Image imgMush;
    private ImageIcon icoMush;
    private final int pause = 15; // temps d'attente en ms entre 2 tours de boucle
    private int dxMush; // pas de déplacement du champignon

    // CONSTRUCTEUR
    public Mush (int x, int y){
        super(27, 30,x, y );
        super.setToRight(true);
        super.setWalk(true);
        this.dxMush = 1;

        this.icoMush = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/champArretDroite.png")));
        this.imgMush = this.icoMush.getImage();

        Thread stopwatchMush = new Thread(this);
        stopwatchMush.start();
    }

    // GETTERS

    public Image getImgMush() {return imgMush;}

    // SETTERS

    // METHODES
    public void move(){ // Déplacement du champignon
        if (super.isToRight()){this.dxMush = 1;}
        else{this.dxMush = -1;}
        super.setX(super.getX() + this.dxMush);
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
            this.dxMush = -1;
        }else if (super.backContact(object) && !this.isToRight()){
            super.setToRight(true);
            this.dxMush = 1;
        }
    }

    public void contact (Characters character){
        if(super.frontContact(character) && this.isToRight()){
            super.setToRight(false);
            this.dxMush = -1;
        } else if (super.backContact(character) && !this.isToRight()) {
            super.setToRight(true);
            this.dxMush = 1;
        }
    }

    public Image die(){
        String str;
        ImageIcon ico;
        Image img;

        if(this.isToRight()){str = "/images/champEcraseDroite.png";}
        else{str = "/images/champEcraseGauche.png";}
        ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        img = ico.getImage();
        return img;
    }
}
