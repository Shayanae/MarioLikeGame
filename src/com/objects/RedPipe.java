package com.objects;

import javax.swing.*;
import java.util.Objects;

public class RedPipe extends Object{

    // VARIABLES

    // CONSTRUCTEUR
    public RedPipe(int x, int y){
        super(x,y,43,65);
        super.icoObject = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/tuyauRouge.png")));
        super.imgObject = this.icoObject.getImage();
    }

    // GETTEURS

    // SETTEURS

    // METHODES
}
