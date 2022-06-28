package com.personnages;

import com.audio.Audio;
import com.jeu.Main;
import com.objects.Coin;
import com.objects.Object;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Mario extends  Characters{

    // VARIABLES
    private Image imgMario;
    private ImageIcon icoMario;
    private boolean jump; // Vrai si mario saute
    private int jumpCounter; // Durée et hauteur du saut
    private int deathCounter;

    // CONSTRUCTEUR
    public Mario(int x, int y){
        super(25, 50,x,y);
        this.icoMario = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/marioArretDroite.png")));
        this.imgMario = this.icoMario.getImage();

        this.jump = false;
        this.jumpCounter = 0;
        this.deathCounter = 0;
    }

    // GETTERS

    public Image getImgMario() {return imgMario;}

    public boolean isJump() {return jump;}
    // SETTERS

    public void setJump(boolean jump) {this.jump = jump;}

    // METHODES


    @Override
    public Image walking(String nom, int frequency) {
        String str;
        ImageIcon ico;
        Image img;

        if(!this.walk || Main.scene.getXPos() <= 0 || Main.scene.getXPos() > 4430){
            if(this.toRight){str = "/images/" + nom + "ArretDroite.png";}
            else {str = "/images/" + nom+ "ArretGauche.png";}
        }else {
            this.counter++;
            if (this.counter/frequency == 0){ // QUotient de la division euclidienne de compteur par frequence
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

    public Image jumping() {
        ImageIcon ico;
        Image img;
        String str;

        this.jumpCounter++;
        // Montée du saut
        if (this.jumpCounter <= 40) {
            if (this.getY() > Main.scene.getCeilingHeight()) {this.setY(this.getY() - 4);}
            else {this.jumpCounter = 41;}
            if (this.isToRight()) {str = "/images/marioSautDroite.png";}
            else {str = "/images/marioSautGauche.png";}
            // Retomber du saut
        } else if (this.getY() + this.getHeight() < Main.scene.getyGround()) {
            this.setY(this.getY() + 1);
            if (this.isToRight()) {str = "/images/marioSautDroite.png";}
            else {str = "/images/marioSautGauche.png";}

            // Saut terminer
        } else {
            if (this.isToRight()) {str = "/images/marioArretDroite.png";}
            else {str = "/images/marioArretGauche.png";}
            this.jump = false;
            this.jumpCounter = 0;
        }
        // Affichage de l'image de mario
        ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        img = ico.getImage();
        return img;
    }

    public void contact (Object object){
        // Contact horizontal
        if ((super.frontContact(object) && this.isToRight()) || (super.backContact(object) && !this.isToRight())){
            Main.scene.setDx(0);
            this.setWalk(false);
        }
        // Contact avec un objet en dessous
        if(super.contactBellow(object) && this.jump){Main.scene.setYGround(object.getY());} // Mario saute sur un objet
        else if(!super.contactBellow(object)){ // Mario tombe sur le sol initial
            Main.scene.setYGround(293); // Altitude du sol initial
            if (!this.jump){this.setY(243);} // Altitude initial de Mario
        }
        // Contact avec un objet au-dessus
        if (super.contactAbove(object)){Main.scene.setCeilingHeight(object.getY() + object.getHeight());} // Le plafond devient le dessous de l'objet
        else if(!super.contactAbove(object) && !this.jump){Main.scene.setCeilingHeight(0);} // Altitude du plafond initial (ciel)
    }

    public boolean contactCoin(Coin coin){
        // Le contact avec une pièce n'a aucune répercussion sur Mario
        if (this.frontContact(coin) || this.backContact(coin) || this.contactBellow(coin) || this.contactAbove(coin)){return true;}
        else{return false;}
    }

    public void contact (Characters character){
        if (super.frontContact(character) || super.backContact(character)){
            this.setWalk(false);
            this.setAlive(false);
        } else if (super.contactBellow(character) && this.isAlive()) {
            character.setWalk(false);
            character.setAlive(false);
        }
    }

    public Image die(){
        String str;
        ImageIcon ico;
        Image img;

        str = "/images/boom.png";
        if (this.deathCounter == 0){Audio.playSound("/audio/boum.wav");}
        if (this.deathCounter == 100){Audio.playSound("/audio/partiePerdue.wav");}
        this.deathCounter++;
        if (this.deathCounter > 100){
            str = "/images/marioMeurt.png";
            this.setY(this.getY() -1);
        }
        ico = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        img = ico.getImage();
        return img;
    }
}
