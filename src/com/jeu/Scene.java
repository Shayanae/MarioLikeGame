package com.jeu;

import com.audio.Audio;
import com.display.Countdown;
import com.display.Score;
import com.objects.Bloc;
import com.objects.Coin;
import com.objects.Object;
import com.objects.RedPipe;
import com.personnages.Mario;
import com.personnages.Mush;
import com.personnages.Turtle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

// La classe Scene est le classe la plus importante de l'application.
// Elle est accessible par toutes les autres clases, contient le "moteur" de l'application.
// Elle gère la partie graphique.
public class Scene extends JPanel {

    // VARIABLES
    private ImageIcon icoScreen;
    private Image imgScreen1;
    private Image imgScreen2;

    private ImageIcon icoCastle1;
    private Image imgCastle1;
    private ImageIcon icoStart;
    private Image imgStart;

    private int xScreen1;
    private int xScreen2;
    private int dx; // Déplacement du fond d'écran
    private int xPos; // Position absolue dans le jeu
    private int yGround; // Hauteur courante du sol
    private int ceilingHeight; // Hauteur courante du plafond
    private boolean ok;
    public Mario mario;

    public RedPipe redPipe1;
    public RedPipe redPipe2;
    public RedPipe redPipe3;
    public RedPipe redPipe4;
    public RedPipe redPipe5;
    public RedPipe redPipe6;
    public RedPipe redPipe7;
    public RedPipe redPipe8;
    public Bloc bloc1;
    public Bloc bloc2;
    public Bloc bloc3;
    public Bloc bloc4;
    public Bloc bloc5;
    public Bloc bloc6;
    public Bloc bloc7;
    public Bloc bloc8;
    public Bloc bloc9;
    public Bloc bloc10;
    public Bloc bloc11;
    public Bloc bloc12;

    public Coin coin1;
    public Coin coin2;
    public Coin coin3;
    public Coin coin4;
    public Coin coin5;
    public Coin coin6;
    public Coin coin7;
    public Coin coin8;
    public Coin coin9;
    public Coin coin10;

    public Mush mush1;
    public Mush mush2;
    public Mush mush3;
    public Mush mush4;
    public Mush mush5;
    public Mush mush6;
    public Mush mush7;
    public Mush mush8;

    public Turtle turtle1;
    public Turtle turtle2;
    public Turtle turtle3;
    public Turtle turtle4;
    public Turtle turtle5;
    public Turtle turtle6;
    public Turtle turtle7;
    public Turtle turtle8;
    public Turtle turtle9;


    private ImageIcon icoFlag;
    private Image imgFlag;
    private ImageIcon icoEndCastle;
    private Image imgEndCastle;

    private ArrayList<Object> objects; // Tableau qui enregistre tous les objets
    private ArrayList<Coin> coins; // Tableau qui enregistre toutes les pièces
    private ArrayList<Mush> mushes; // Tableau qui enregistre tous les champignons
    private ArrayList<Turtle> turtles; // Tableau qui enregistre toutes les tortues

    private Score score;
    private Font police;
    private Countdown countdown;

    // CONSTRUCTEUR
    public Scene() {
        super();
        this.xScreen1 = -50;
        this.xScreen2 = 750;
        this.dx = 0;
        this.xPos = -1;
        this.yGround = 293;
        this.ceilingHeight = 0;
        this.ok = true;
        icoScreen = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/fondEcran.png")));
        this.imgScreen1 = this.icoScreen.getImage();
        this.imgScreen2 = this.icoScreen.getImage();

        this.icoCastle1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/chateau1.png")));
        this.imgCastle1 = this.icoCastle1.getImage();
        this.icoStart = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/depart.png")));
        this.imgStart = this.icoStart.getImage();

        mario = new Mario(300, 245);

        redPipe1 = new RedPipe(600, 230);
        redPipe2 = new RedPipe(1000, 230);
        redPipe3 = new RedPipe(1600, 230);
        redPipe4 = new RedPipe(1900, 230);
        redPipe5 = new RedPipe(2500, 230);
        redPipe6 = new RedPipe(3000, 230);
        redPipe7 = new RedPipe(3800, 230);
        redPipe8 = new RedPipe(4500, 230);

        bloc1 = new Bloc(400, 180);
        bloc2 = new Bloc(1200, 180);
        bloc3 = new Bloc(1270, 170);
        bloc4 = new Bloc(1340, 160);
        bloc5 = new Bloc(2000, 180);
        bloc6 = new Bloc(2600, 160);
        bloc7 = new Bloc(2650, 180);
        bloc8 = new Bloc(3500, 160);
        bloc9 = new Bloc(3550, 140);
        bloc10 = new Bloc(4000, 170);
        bloc11 = new Bloc(4200, 200);
        bloc12 = new Bloc(4300, 210);

        coin1 = new Coin(402, 145);
        coin2 = new Coin(1202, 140);
        coin3 = new Coin(1272, 95);
        coin4 = new Coin(1342, 40);
        coin5 = new Coin(1650, 145);
        coin6 = new Coin(2650, 145);
        coin7 = new Coin(3000, 135);
        coin8 = new Coin(3400, 125);
        coin9 = new Coin(4200, 145);
        coin10 = new Coin(4600, 40);

        mush1 = new Mush(800, 263);
        mush2 = new Mush(1100, 263);
        mush3 = new Mush(2000,263);
        mush4 = new Mush(2500, 263);
        mush5 = new Mush(3200, 263);
        mush6 = new Mush(3500, 263);
        mush7 = new Mush(3700, 263);
        mush8 = new Mush(4100, 263);

        turtle1 = new Turtle(950, 243);
        turtle2 = new Turtle(1500, 243);
        turtle3 = new Turtle(1800, 243);
        turtle4 = new Turtle(2100, 243);
        turtle5 = new Turtle(2400, 243);
        turtle6 = new Turtle(3100, 243);
        turtle7 = new Turtle(3600, 243);
        turtle8 = new Turtle(3900, 243);
        turtle9 = new Turtle(4000, 243);


        this.icoEndCastle = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/chateauFin.png")));
        this.imgEndCastle = this.icoEndCastle.getImage();

        this.icoFlag = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/drapeau.png")));
        this.imgFlag = this.icoFlag.getImage();

        objects = new ArrayList<>();

        this.objects.add(this.redPipe1);
        this.objects.add(this.redPipe2);
        this.objects.add(this.redPipe3);
        this.objects.add(this.redPipe4);
        this.objects.add(this.redPipe5);
        this.objects.add(this.redPipe6);
        this.objects.add(this.redPipe7);
        this.objects.add(this.redPipe8);

        this.objects.add(this.bloc1);
        this.objects.add(this.bloc2);
        this.objects.add(this.bloc3);
        this.objects.add(this.bloc4);
        this.objects.add(this.bloc5);
        this.objects.add(this.bloc6);
        this.objects.add(this.bloc7);
        this.objects.add(this.bloc8);
        this.objects.add(this.bloc9);
        this.objects.add(this.bloc10);
        this.objects.add(this.bloc11);
        this.objects.add(this.bloc12);

        coins = new ArrayList<>();
        this.coins.add(this.coin1);
        this.coins.add(this.coin2);
        this.coins.add(this.coin3);
        this.coins.add(this.coin4);
        this.coins.add(this.coin5);
        this.coins.add(this.coin6);
        this.coins.add(this.coin7);
        this.coins.add(this.coin8);
        this.coins.add(this.coin9);
        this.coins.add(this.coin10);

        mushes = new ArrayList<>();
        this.mushes.add(mush1);
        this.mushes.add(mush2);
        this.mushes.add(mush3);
        this.mushes.add(mush4);
        this.mushes.add(mush5);
        this.mushes.add(mush6);
        this.mushes.add(mush7);
        this.mushes.add(mush8);

        turtles = new ArrayList<>();
        this.turtles.add(turtle1);
        this.turtles.add(turtle2);
        this.turtles.add(turtle3);
        this.turtles.add(turtle4);
        this.turtles.add(turtle5);
        this.turtles.add(turtle6);
        this.turtles.add(turtle7);
        this.turtles.add(turtle8);
        this.turtles.add(turtle9);

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Keyboard());

        score = new Score();
        police = new Font("Arial", Font.PLAIN, 18);
        countdown = new Countdown();

        Thread timerScreen = new Thread(new Timer());
        timerScreen.start();
    }
    // GETTERS

    public int getDx() {return dx;}

    public int getXPos() {return xPos;}

    public int getyGround() {return yGround;}

    public int getCeilingHeight() {return ceilingHeight;}

    // SETTERS

    public void setDx(int dx) {this.dx = dx;}

    public void setXPos(int xPos) {this.xPos = xPos;}

    public void setXScreen1(int xScreen1) {this.xScreen1 = xScreen1;}

    public void setXScreen2(int xScreen2) {this.xScreen2 = xScreen2;}

    public void setYGround(int yGround) {this.yGround = yGround;}

    public void setCeilingHeight(int ceilingHeight) {this.ceilingHeight = ceilingHeight;}

    // METHODES

    public void screenMovements() {
        if (this.xPos >= 0 && this.xPos <= 4430) {
            // Mise à jour des positions des éléments du jeu lors du déplacement de mario
            this.xPos = this.xPos + this.dx;
            this.xScreen1 = this.xScreen1 - this.dx;
            this.xScreen2 = this.xScreen2 - this.dx;
        }
        // Permanence du fond d'écran
        if (this.xScreen1 == -800) {
            this.xScreen1 = 800;
        } else if (this.xScreen2 == -800) {
            this.xScreen2 = 800;
        } else if (this.xScreen1 == 800) {
            this.xScreen1 = -800;
        } else if (this.xScreen2 == 800) {
            this.xScreen2 = -800;
        }
    }

    private boolean gameWin(){
        if (this.countdown.getTimeCounter() > 0 && this.mario.isAlive() && this.score.getNbrCoins()==this.score.getNbrTotalCoins() && this.xPos > 4400){
            if (this.ok){
                Audio.playSound("/audio/partieGagnee.wav");
                this.ok = false;
            }
            return true;
        }else{return false;}
    }

    private boolean gameLost(){
        if (this.countdown.getTimeCounter()<=0 || !this.mario.isAlive()){
            return true;
        }else{return false;}
    }

    public boolean gameEnd(){
        if (this.gameWin() || this.gameLost()){return true;}
        else{return false;}
    }

    public void paintComponent(Graphics g) { // Dessin de toutes les images visibles à l'écran (appel toutes les 3 ms environ)
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        // Détection contact avec les objets
        for (int i = 0; i < this.objects.size(); i++){
            // Mario
            if (this.mario.close(this.objects.get(i))){this.mario.contact(this.objects.get(i));}
            // Champignons
            for (int j = 0; j < this.mushes.size(); j++) {
                if (this.mushes.get(j).close(this.objects.get(i))) {this.mushes.get(j).contact(this.objects.get(i));}
            }
            // Tortue
            for (int j = 0; j < this.turtles.size(); j++) {
                if (this.turtles.get(j).close(this.objects.get(i))) {this.turtles.get(j).contact(this.objects.get(i));}
            }
        }

        // Détection contact avec les pièces
        for (int i = 0; i < this.coins.size(); i++){
            if (this.mario.close(this.coins.get(i))){
                if (this.mario.contactCoin(this.coins.get(i))){
                    this.coins.remove(i);
                    this.score.setNbrCoins(this.score.getNbrCoins() + 1);
                    Audio.playSound("/audio/piece.wav");
                }
            }
        }

        // Détections des contacts des champignons avec les personnages (hors mario)
        for (int i = 0; i < this.mushes.size(); i++){
            // champignons
            for (int j = 0; j < this.mushes.size(); j++){
                if (j != i){
                    if (this.mushes.get(j).close(this.mushes.get(i))){this.mushes.get(j).contact(this.mushes.get(i));}
                }
            }
            // Tortues
            for (int j = 0; j < this.turtles.size(); j++){
                if (this.turtles.get(j).close(this.mushes.get(i))){this.turtles.get(j).contact(this.mushes.get(i));}

            }
        }

        // Détection des contacts des tortues avec les personnages (hors mario)
        for (int i = 0; i < this.turtles.size(); i ++){
            // Champignons
            for (int j = 0; j < this.mushes.size(); j++){
                if (this.mushes.get(j).close(this.turtles.get(i))){this.mushes.get(j).contact(this.turtles.get(i));}
            }
            // Tortues
            for (int j = 0; j < this.turtles.size(); j++){
                if (j != i){
                    if (this.turtles.get(j).close(this.turtles.get(i))){this.turtles.get(j).contact(this.turtles.get(i));}
                }
            }
        }

        // Détection des contacts de mario avec des personnages
        // Champignons
        for (int i = 0; i < this.mushes.size(); i++){
            if (this.mario.close(this.mushes.get(i)) && this.mushes.get(i).isAlive()){
                this.mario.contact(this.mushes.get(i));
                if (!this.mushes.get(i).isAlive()){Audio.playSound("/audio/ecrasePersonnage.wav");}
            }
        }
        // Tortues
        for (int i = 0; i < this.turtles.size(); i++){
            if (this.mario.close(this.turtles.get(i)) && this.turtles.get(i).isAlive()){
                this.mario.contact(this.turtles.get(i));
                if (!this.turtles.get(i).isAlive()){Audio.playSound("/audio/ecrasePersonnage.wav");}
            }
        }

        // Déplacement de tous les objets "fixes" du jeu
        this.screenMovements();
        if (this.xPos >= 0 && this.xPos <= 4430){
            for (int i = 0; i < this.objects.size(); i++){this.objects.get(i).trips();}
            for (int i = 0; i < this.coins.size(); i++){this.coins.get(i).trips();}
            for (int i = 0; i < this.mushes.size(); i++){this.mushes.get(i).trips();}
            for (int i = 0; i < this.turtles.size(); i++){this.turtles.get(i).trips();}
        }

        // Image de fond
        g2.drawImage(this.imgScreen1, this.xScreen1, 0, null);
        g2.drawImage(this.imgScreen2, this.xScreen2, 0, null);
        // Image du château du départ
        g2.drawImage(imgCastle1, 10 - this.xPos, 95, null);
        // Image du panneau de départ
        g2.drawImage(imgStart, 220 - this.xPos, 234, null);
        // Images des objets
        for (int i = 0; i < this.objects.size(); i++){
            g2.drawImage(this.objects.get(i).getImgObject(), this.objects.get(i).getX(), this.objects.get(i).getY(), null);
        }
        // Images des pièces
        for (int i = 0; i < this.coins.size(); i++){
            g2.drawImage(this.coins.get(i).move(), this.coins.get(i).getX(), this.coins.get(i).getY(), null);
        }
        // Image du drapeau d'arrivée
        g2.drawImage(imgFlag, 4650 - this.xPos, 115,null);
        // Image du chateau d'arrivée
        g2.drawImage(imgEndCastle, 5000 - this.xPos, 145, null);
        // Image de mario
        if (this.mario.isAlive()){
            if (this.mario.isJump()){g2.drawImage(this.mario.jumping(), this.mario.getX(), this.mario.getY(), null);}
            else {g2.drawImage(this.mario.walking("mario", 35), this.mario.getX(), this.mario.getY(), null);}
        }else {g2.drawImage(this.mario.die(), this.mario.getX(), this.mario.getY(), null);}


        // Images des champignons
        for (int i = 0; i < this.mushes.size(); i++){
            if(this.mushes.get(i).isAlive()){
                g2.drawImage(this.mushes.get(i).walking("champ", 45), this.mushes.get(i).getX(), this.mushes.get(i).getY(), null);
            }else {
                g2.drawImage(this.mushes.get(i).die(),this.mushes.get(i).getX(), this.mushes.get(i).getY() + 20, null);
            }
        }
        // Images des tortues
        for (int i = 0; i < this.turtles.size(); i++){
            if (this.turtles.get(i).isAlive()){
                g2.drawImage(this.turtles.get(i).walking("tortue", 45), this.turtles.get(i).getX(), this.turtles.get(i).getY(), null);
            }else {
                g2.drawImage(this.turtles.get(i).die(),this.turtles.get(i).getX(), this.turtles.get(i).getY() + 27, null);
            }
        }

        // MIse à jour du score
        g2.setFont(police);
        g2.drawString(this.score.getNbrCoins() + " pièce(s) trouvée(s) sur " + this.score.getNbrTotalCoins(), 450, 25);

        // Mise à jour du temps de jeu restant
        g2.drawString(this.countdown.getStr(), 5, 25);

        // Fin de partie
        if (this.gameEnd()) {
            Font endPolice = new Font("Arial", Font.BOLD, 50);
            g2.setFont(endPolice);
            if (this.gameWin()){g2.drawString("Vous avez gagné !!", 120, 180);}
            else{g2.drawString("Vous avez perdu...", 120, 180);}
        }
    }
}
