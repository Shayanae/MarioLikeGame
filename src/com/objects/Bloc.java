package com.objects;

import javax.swing.*;
import java.util.Objects;

public class Bloc extends Object{
    // VARIABLES


    // CONSTRUCTEUR
    public Bloc(int x, int y){
        super(x,y,30,30);
        super.icoObject = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/bloc.png")));
        super.imgObject = this.icoObject.getImage();
    }

    // GETTEURS

    // SETTEURS

    // METHODES
}
