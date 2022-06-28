package com.objects;

import com.jeu.Main;

import javax.swing.*;
import java.awt.*;

public class Object {

    // VARIABLE
    private int x,y; // Position de l'objet
    private int weight, height; // Dimensions de l'objet
    protected Image imgObject;
    protected ImageIcon icoObject;

    // CONSTRUCTEUR
    public Object(int x, int y, int weight, int height) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.height = height;
    }

    // GETTEURS

    public int getX() {return x;}

    public int getY() {return y;}

    public int getWeight() {return weight;}

    public int getHeight() {return height;}

    public Image getImgObject() {return imgObject;}

    // SETTEURS


    public void setX(int x) {this.x = x;}

    public void setY(int y) {this.y = y;}

    public void setWeight(int weight) {this.weight = weight;}

    public void setHeight(int height) {this.height = height;}

    // METHODES
    public void trips(){
        if (Main.scene.getXPos() >= 0){
            this.x = this.x - Main.scene.getDx();
        }
    }
}
