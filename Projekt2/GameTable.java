package GUI.Projekt2;



import GUI.Projekt2.Entity.Player;


import javax.swing.*;
import java.awt.*;

import static Projekt2.AbstractTable.table;

public class GameTable extends JTable implements Runnable{
    int startingX = 16;
    int startingY = 16;
    int currentX = 16;
    int currentY = 16;
    int width = 16;
    int height = 16;
    int tableWidth;
    int tableHeight;
    int speed = 3;
    KeyHandler keyHandler = new KeyHandler();
    Player player;
    int playersize = 18;
    int enemyspeed = 1;
    Projekt2.Entity.Enemy enemy;
    int cellSize = 16;
    boolean inBox = true;
    int maxHealth = 5;
    int currentHP;

    String direction = "";
    int enemyStartingX;
    int enemyStartingY;
    int enemyCurrentX;
    int enemyCurrentY;

    String score;
    JLabel scoreShow;
    JLabel heart;
    Thread thread;
    Projekt2.AbstractTable abstractTable;
    JLabel smallPoint;


    public GameTable(int width,int height){
        Projekt2.AbstractTable abstractTable = new Projekt2.AbstractTable(width,height);
        abstractTable.generateMaze();
        this.abstractTable = abstractTable;
        tableWidth = width;
        tableHeight = height;

        player = new Player(keyHandler);
        player.setBounds(startingX,startingY,playersize,playersize);

        enemyStartingX = tableWidth*16/2;
        enemyStartingY = tableHeight*16/2;
        enemyCurrentX = enemyStartingX;
        enemyCurrentY = enemyStartingY;
        enemy = new Projekt2.Entity.Enemy();
        this.add(enemy,BorderLayout.CENTER);
        enemy.setBounds(enemyStartingX,enemyStartingY,playersize,playersize);

        this.addKeyListener(keyHandler);
        this.add(player, BorderLayout.CENTER);
        this.setModel(abstractTable);
        this.setGridColor(Color.BLACK);

        this.setRowHeight(cellSize);
        for (int i=0;i<this.getColumnCount();i++){
            this.getColumnModel().getColumn(i).setPreferredWidth(cellSize);
        }

        scoreShow = new JLabel();
        this.add(scoreShow);
        scoreShow.setFont(new Font("Bauhaus 93",Font.BOLD,15));
        scoreShow.setForeground(Color.YELLOW);
        scoreShow.setBounds(0,0,160,16);
        scoreShow.setOpaque(false);

        for (int i=0;i<maxHealth;i++){
            heart = new JLabel(new ImageIcon("C:\\Users\\Filip\\Downloads\\NicePng_designer-png_2132329.png"));
            this.add(heart);
            heart.setBounds(((tableWidth-1)*16)-(16*i)+5,4,8,8);
        }

        ColorRenderer colorRenderer = new ColorRenderer();
        this.setDefaultRenderer(Object.class,colorRenderer);

        currentHP = maxHealth;
        table[1][1] = 0;

        this.startThread();
        addPoints();

    }
    public void update(){

        if (keyHandler.rightPressed) {
            if (table[currentY/16][currentX/16+1] == 1){
            }
            else {
                currentX += speed;
                direction = "left";
                centerplayer();
            }
        }
        if (keyHandler.leftPressed) {
            if (table[currentY/16][currentX/16-1] == 1){
            }
            else {
                currentX -= speed;
                direction = "left";
                centerplayer();
            }
        }
        if (keyHandler.upPressed) {
            if (table[currentY/16-1][currentX/16] == 1){
            }

            else {
                currentY -= speed;
                direction = "up";
                centerplayer();
            }
        }
        if (keyHandler.downPressed) {
            if (table[currentY/16+1][currentX/16] == 1){
            }
            else {
                currentY += speed;
                direction = "down";
                centerplayer();
            }
        }
        scoreShow.setText("SCORE: " + this.score);
        checkBound();

        pointCollision();
        enemyCollision();

    }
    public void centerplayer() {
        int currentCellX = currentX / width;
        int currentCellY = currentY / height;
        int centerCellX = currentCellX * width + width/2;
        int centerCellY = currentCellY * height + height/2;
        player.setLocation(centerCellX - (playersize / 2), centerCellY - (playersize / 2));
    }

    public void checkBound(){
        if (currentX<16 ){
            currentX = 16;
        }
        if (currentX>(tableHeight-2)*16){
            currentX = (tableHeight-1)*16-16;
        }
        if (currentY<16){
            currentY = 16;
        }
        if (currentY>(tableWidth-2)*16){
            currentY = (tableWidth-1)*16-16;
        }
    }

    public void pointCollision(){
        if (table[currentY/16][currentX/16] == 0){
            player.score +=10;
            score = String.valueOf(player.score);
            System.out.println(player.score);
            table[currentY/16][currentX/16] = 3;

        }
    }

    public void enemyCollision(){
        if (enemy.terrified()){
            System.out.println("cos");
        }else {
            if (player.getX() >= enemy.getX()-8 && player.getX() <= enemy.getX()){
                if (player.getY() >= enemy.getY()-8 && player.getY() <= enemy.getY()){
                    System.out.println("-1HP");
                    currentHP--;
                    for (int i=0;i<currentHP;i++){
                        heart = new JLabel(new ImageIcon("C:\\Users\\Filip\\Downloads\\NicePng_designer-png_2132329.png"));
                        this.add(heart);
                        heart.setBounds(((tableWidth-1)*16)-(16*i)+5,4,8,8);
                    }
                    setStartingPositions();
                }
                if (player.getY() >= enemy.getY() && player.getY() <= enemy.getY()+8){
                    System.out.println("-1HP");
                    currentHP--;
                    for (int i=0;i<currentHP;i++){
                        heart = new JLabel(new ImageIcon("C:\\Users\\Filip\\Downloads\\NicePng_designer-png_2132329.png"));
                        this.add(heart);
                        heart.setBounds(((tableWidth-1)*16)-(16*i)+5,4,8,8);
                    }
                    setStartingPositions();
                }
            }
            if (player.getX() <= enemy.getX()+8 && player.getX() >= enemy.getX()){
                if (player.getY() >= enemy.getY()-8 && player.getY() <= enemy.getY()){
                    System.out.println("-1HP");
                    currentHP--;
                    for (int i=0;i<currentHP;i++){
                        heart = new JLabel(new ImageIcon("C:\\Users\\Filip\\Downloads\\NicePng_designer-png_2132329.png"));
                        this.add(heart);
                        heart.setBounds(((tableWidth-1)*16)-(16*i)+5,4,8,8);
                    }
                    setStartingPositions();
                }
                if (player.getY() >= enemy.getY() && player.getY() <= enemy.getY()+8){
                    System.out.println("-1HP");
                    currentHP--;
                    for (int i=0;i<currentHP;i++){
                        heart = new JLabel(new ImageIcon("C:\\Users\\Filip\\Downloads\\NicePng_designer-png_2132329.png"));
                        this.add(heart);
                        heart.setBounds(((tableWidth-1)*16)-(16*i)+5,4,8,8);
                    }
                    setStartingPositions();
                }
            }

        }
    }
    public void setStartingPositions(){
        player.setLocation(startingX,startingY);
        currentX = startingX;
        currentY = startingY;
        enemy.setLocation(enemyStartingX,enemyStartingY);

        enemyCurrentX = enemyStartingX;
        enemyCurrentY = enemyStartingY;
    }
    public void addPoints(){
        for (int i=0;i<table.length;i++){
            for (int j=0;j<table[i].length;j++){
                if (table[i][j] == 0) {
                    smallPoint = new JLabel(new ImageIcon("C:\\Users\\Filip\\Downloads\\circle-16.png"));
                    smallPoint.setBounds(j * width + 6, i * width + 6, 4, 4);
                    this.add(smallPoint);


                }
            }
        }
    }
    public void startThread(){
        this.thread = new Thread(this);
        thread.start();

    }
    int FPS = 60;
    @Override
    public void run() {

            double drawInterval = (double) 1000000000/FPS;
            double nextDrawTime = System.nanoTime() + drawInterval;

            while(thread!=null){


                enemyCollision();

                try{
                    enemyMove();

                }catch (StackOverflowError e){
                    e.printStackTrace();
                }
                enemy.repaint();

                try {
                    double remainingTime = nextDrawTime - System.nanoTime();
                    remainingTime /= 1000000;

                    if (remainingTime<0){
                        remainingTime = 0;
                    }

                    Thread.sleep((long)remainingTime);

                    nextDrawTime +=drawInterval;

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }



    }
    String destination = "up";
    public void enemyMove(){
        /*

        if (enemyCurrentX<16 ){
            enemyCurrentX = 16;
            int path = (int)(Math.random()*3);
            switch (path) {
                case 0 -> {
                    destination = "down";
                    centerenemy();
                    enemyForward();
                }
                case 1 -> {
                    destination = "right";
                    centerenemy();
                    enemyForward();
                }
                case 2 -> {
                    destination = "left";
                    centerenemy();
                    enemyForward();
                }
            }
            centerenemy();
        }
        else if (enemyCurrentX>(tableHeight-2)*16){
            enemyCurrentX = (tableHeight-1)*16-16;
            int path = (int)(Math.random()*3);
            switch (path) {
                case 0 -> {
                    destination = "down";
                    centerenemy();
                    enemyForward();
                }
                case 1 -> {
                    destination = "right";
                    centerenemy();
                    enemyForward();
                }
                case 2 -> {
                    destination = "left";
                    centerenemy();
                    enemyForward();
                }
            }
            centerenemy();
        }
        else if (enemyCurrentY<16){
            enemyCurrentY = 16;
            int path = (int)(Math.random()*3);
            switch (path) {
                case 0 -> {
                    destination = "down";
                    centerenemy();
                    enemyForward();
                }
                case 1 -> {
                    destination = "right";
                    centerenemy();
                    enemyForward();
                }
                case 2 -> {
                    destination = "left";
                    centerenemy();
                    enemyForward();
                }
            }
            centerenemy();
        }
        else if (enemyCurrentY>(tableWidth-2)*16){
            enemyCurrentY = (tableWidth-1)*16-16;
            int path = (int)(Math.random()*3);
            switch (path) {
                case 0 -> {
                    destination = "down";
                    centerenemy();
                    enemyForward();
                }
                case 1 -> {
                    destination = "right";
                    centerenemy();
                    enemyForward();
                }
                case 2 -> {
                    destination = "left";
                    centerenemy();
                    enemyForward();
                }
            }
            centerenemy();
        }
        else if(destination.equals("up")){

            centerenemy();
            enemyCurrentY -=enemyspeed;
            if (table[enemyCurrentY/16][enemyCurrentX/16] == 0){
                centerenemy();
                if (table[enemyCurrentY/16-1][enemyCurrentX/16] == 1){
                    int path = (int)(Math.random()*3);
                    switch (path) {
                        case 0 -> {
                            destination = "down";
                            centerenemy();
                            enemyForward();
                        }
                        case 1 -> {
                            destination = "right";
                            centerenemy();
                            enemyForward();
                        }
                        case 2 -> {
                            destination = "left";
                            centerenemy();
                            enemyForward();
                        }
                    }
                }
                else {
                    enemyCurrentY -=enemyspeed;
                    centerenemy();

                }

            }
        }
        else if (destination.equals("down")){

            centerenemy();
            enemyCurrentY +=enemyspeed;
            if (table[enemyCurrentY/16][enemyCurrentX/16] == 0){
                centerenemy();
                if (table[enemyCurrentY/16+1][enemyCurrentX/16] == 1){
                    int path = (int)(Math.random()*3);
                    switch (path) {
                        case 0 -> {
                            destination = "up";
                            centerenemy();
                            enemyForward();
                        }
                        case 1 -> {
                            destination = "right";
                            centerenemy();
                            enemyForward();
                        }
                        case 2 -> {
                            destination = "left";
                            centerenemy();
                            enemyForward();
                        }
                    }
                }
                else {
                    enemyCurrentY +=enemyspeed;
                    centerenemy();

                }
            }
        }
        else if (destination.equals("right")){

            centerenemy();
            enemyCurrentX +=enemyspeed;
            if (table[enemyCurrentY/16][enemyCurrentX/16+1] == 0){
                centerenemy();
                if (table[enemyCurrentY/16][enemyCurrentX/16+1] == 1){
                    int path = (int)(Math.random()*3);
                    switch (path) {
                        case 0 -> {
                            destination = "up";
                            centerenemy();
                            enemyForward();
                        }
                        case 1 -> {
                            destination = "down";
                            centerenemy();
                            enemyForward();
                        }
                        case 2 -> {
                            destination = "left";
                            centerenemy();
                            enemyForward();
                        }
                    }
                }
                else {
                    enemyCurrentX +=enemyspeed;
                    centerenemy();

                }
            }
        }
        else if (destination.equals("left")){
            centerenemy();
            enemyCurrentX -=enemyspeed;
            if (table[enemyCurrentY/16][enemyCurrentX/16] == 0){
                centerenemy();
                if (table[enemyCurrentY/16][enemyCurrentX/16-1] == 1){
                    int path = (int)(Math.random()*3);
                    switch (path) {
                        case 0 -> {
                            destination = "up";
                            centerenemy();
                            enemyForward();
                        }
                        case 1 -> {
                            destination = "right";
                            centerenemy();
                            enemyForward();
                        }
                        case 2 -> {
                            destination = "down";
                            centerenemy();
                            enemyForward();
                        }
                    }
                }
                else {
                    enemyCurrentX -=enemyspeed;
                    centerenemy();

                }
            }
        */
    enemyCurrentX = 16;
    enemyCurrentY = 16;
    switch (destination){
        case "up":
            enemyUp();
        case "down":
            enemyDown();
        case "right":
            enemyRight();
        case "left":
            enemyLeft();
    }
    }
    public void enemyUp(){
        enemyCurrentY += speed;
        centerenemy();
        enemyWall();
    }
    public void enemyDown(){
        enemyCurrentY -= speed;
        centerenemy();
        enemyWall();
    }
    public void enemyRight(){
        enemyCurrentX += speed;
        centerenemy();
        enemyWall();
    }
    public void enemyLeft(){
        enemyCurrentX -= speed;
        centerenemy();
        enemyWall();
    }

    public void enemyWall(){
        //na podstawie destination sprawdza nastepna komorke jesli jest sciana zmienia kierunek
        switch (destination){
            case "up":

            case "down":
            case "left":
            case "right":
        }
    }
    public void centerenemy() {
        int currentCellX = enemyCurrentX / width;
        int currentCellY = enemyCurrentY / height;
        int centerCellX = currentCellX * width + width/2;
        int centerCellY = currentCellY * height + height/2;
        enemy.setLocation(centerCellY - (playersize / 2), centerCellX - (playersize / 2));
    }
}
