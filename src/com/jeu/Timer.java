package com.jeu;

// La classe Timer gère un flux indépendant du flux principal qui exécute la méthode run().
public class Timer implements Runnable{

    // VARIABLES
    private final int PAUSE = 3; // temps d'attente entre 2 tours de boucle

    // METHODES
    @Override
    public void run() {
        while (true){
            Main.scene.repaint(); // Appel de la méthode PaintComponent de l'objet scene
            try {Thread.sleep(PAUSE);} // Temps de pause du flux (3ms)
            catch (InterruptedException e) {}
        }
    }
}
