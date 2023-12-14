package Projekt2;

import Projekt2.Entity.Player;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {
    KeyHandler keyHandler = new KeyHandler();
    Player player = new Player(keyHandler);
    Thread gameThread;
    int FPS = 60;
    GameTable gameTable;
    public GamePanel(int width,int height){
        gameTable = new GameTable(width,height);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        gridBagConstraints.insets = new Insets(10,10,10,10);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;

        this.setVisible(true);
        this.addKeyListener(keyHandler);
        this.add(gameTable,gridBagConstraints);


    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update(){
        gameTable.update();


    }

    @Override
    public void run() {

        double drawInterval = (double) 1000000000 /FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread!=null){
            update();
            repaint();
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
}
