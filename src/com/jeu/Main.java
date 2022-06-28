package com.jeu;

import javax.swing.*;
// La classe Main gère le flux principal et exécute la méthode main() qui lance l'application
public class Main {
    // Variables
    public static Scene scene;

    public static void main(String[] args) {
        // Création de la fenetre de l'application
        JFrame window = new JFrame("Jeu style Mario");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(700,360);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setAlwaysOnTop(true);

        // Instanciation de l'objet scene
        scene = new Scene();
        window.setContentPane(scene); // On associe la scene à la fenêtre de l'application
        window.setVisible(true);
    }
}
