package com.personnages;

import com.jeu.Main;
import com.objects.Object;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Characters {
    // VARIABLES
    private int weight, height; // Dimensions du personnage
    private int x, y; // Position du personnage
    protected boolean walk; // Vrai quand le personnage marche
    protected boolean toRight; // Vrai quand le personnage est toruné vers la droite
    public int counter; // Compteur des pas du personnage
    protected boolean alive; // vrai si le personnage est vivant

    // CONSTRUCTEUR
    public Characters(int weight, int height, int x, int y) {
        this.weight = weight;
        this.height = height;
        this.x = x;
        this.y = y;
        this.counter = 0;
        this.walk = false;
        this.toRight = true;
        this.alive = true;
    }

    // GETTEURS

    public int getWeight() {return weight;}

    public int getHeight() {return height;}

    public int getX() {return x;}

    public int getY() {return y;}

    public boolean isWalk() {return walk;}

    public boolean isToRight() {return toRight;}

    public int getCounter() {return counter;}

    public boolean isAlive() {return alive;}

    // SETTEURS


    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

    public void setWalk(boolean walk) {this.walk = walk;}

    public void setToRight(boolean toRight) {this.toRight = toRight;}

    public void setCounter(int counter) {this.counter = counter;}

    public void setAlive(boolean alive) {this.alive = alive;}

    // METHODES

    public Image walking(String nom, int frequency){
        String str;
        ImageIcon ico;
        Image img;

        if(!this.walk){
            if(this.toRight){str = "/images/" + nom + "ArretDroite.png";}
            else {str = "/images/" + nom+ "ArretGauche.png";}
        }else {
            this.counter++;
            if (this.counter/frequency == 0){
                if (this.toRight){str = "/images/" + nom + "ArretDroite.png";}
                else {str = "/images/" + nom + "ArretGauche.png";}
            }else {
                if (this.toRight){str = "/images/" + nom + "MarcheDroite.png";}
                else {str = "/images/" + nom + "MarcheGauche.png";}
            }
            if (this.counter == 2 * frequency){this.counter = 0;}
        }
        // Affichage de l'image du personnage
        ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        img = ico.getImage();
        return img;
    }

    // Détection contact à droite de Mario
    protected boolean frontContact(Object object){
        if (this.x + this.weight < object.getX() || this.x + this.weight > object.getX() + 5 || this.y + this.height <= object.getY() ||
                this.y >= object.getY() + object.getHeight()){return false;}
        else {return true;}
    }

    // Détection contact à gauche de Mario
    protected boolean backContact(Object object){
        if (this.x > object.getX() + object.getWeight() || this.x + this.weight < object.getX() + object.getWeight() - 5 || this.y + this.height <= object.getY() ||
                this.y >= object.getY() + object.getHeight()){return false;}
        else {return true;}
    }

    // Détection contact en dessous de Mario
    protected boolean contactBellow(Object object){
        if (this.x + this.weight < object.getX() + 5 || this.x > object.getX() + object.getWeight() - 5 ||
        this.y + this.height < object.getY() || this.y + this.height > object.getY() + 5){return false;}
        else {return true;}
    }

    // Détection contact au-dessus de Mario
    protected boolean contactAbove(Object object){
        if (this.x + this.weight < object.getX() + 5 || this.x > object.getX() + object.getWeight() - 5 ||
        this.y < object.getY() + object.getHeight() || this.y > object.getY() + object.getHeight() + 5){return false;}
        else {return true;}
    }

    public boolean close(Object object){
        if ((this.x > object.getX() - 10 && this.x < object.getX() + object.getWeight() +10) ||
                (this.x + this.weight > object.getX() - 10 && this.x + this.weight < object.getX() + object.getWeight() +10)){return true;}
        else{return false;}
    }

    protected boolean frontContact(Characters character){
        if (this.isToRight()){
            if (this.x + this.weight < character.getX() || this.x + this.weight > character.getX() +5 ||
                this.y + this.height <= character.getY() || this.y >= character.getY() + character.height){return false;}
            else {return true;}
        }else{return false;}
    }

    protected boolean backContact(Characters character){
        if(this.x > character.getX() + character.getWeight() || this.x + this.weight < character.getX() + character.weight - 5 ||
           this.y + this.height <= character.getY() || this.y >= character.getY() + character.getHeight()){return false;}
        else{return true;}
    }

    protected boolean contactBellow (Characters character){
        if(this.x + this.weight < character.getX() || this.x > character.getX() + character.getWeight() ||
           this.y + this.height < character.getY() || this.y + this.height > character.getY()){return false;}
        else{return true;}
    }

    public boolean close(Characters character){
        if((this.x > character.getX() - 10 && this.x < character.getX() + character.getWeight() + 10)
           || (this.x + this.weight > character.getX() - 10 && this.x + this.weight < character.getX() + character.getWeight() + 10)){return true;}
        else{return false;}
    }

    public void trips(){
        if (Main.scene.getXPos() >= 0){this.x = this.x - Main.scene.getDx();}
    }
}
