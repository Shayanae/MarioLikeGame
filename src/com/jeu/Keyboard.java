package com.jeu;

import com.audio.Audio;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (Main.scene.mario.isAlive()) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // flèche droite
                // Annule le décalage de 1 crée par screenMovement (Scene)
                if (Main.scene.getXPos() == -1) {
                    Main.scene.setXPos(0); // Réinitialisation de setXPos
                    Main.scene.setXScreen1(-50); // Réinitialisation de setXScreen1
                    Main.scene.setXScreen2(750); // Réinitialisation de set XScreen2
                }
                Main.scene.mario.setWalk(true);
                Main.scene.mario.setToRight(true);
                Main.scene.setDx(1); // Déplacement du vond vers la gauche lors de l'appui sur la touche "flèche droite"
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // flèche gauche
                if (Main.scene.getXPos() == 4431) {
                    Main.scene.setXPos(4430);
                    Main.scene.setXScreen1(-50);
                    Main.scene.setXScreen2(750);
                }
                Main.scene.mario.setWalk(true);
                Main.scene.mario.setToRight(false);
                Main.scene.setDx(-1); // Déplacement du fond vers la droite lors de l'appui sur la touche "flèche gauche"
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                Main.scene.mario.setJump(true);
                Audio.playSound("/audio/saut.wav");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.scene.mario.setWalk(false);
        Main.scene.setDx(0); // Remis à 0 de la variable dx de l'objet scene lors du relâchement des touches
    }
}
