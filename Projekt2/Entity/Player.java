package GUI.Projekt2.Entity;



import GUI.Projekt2.KeyHandler;

import javax.swing.*;
import java.awt.*;


public class Player extends JLabel  {



    int speed = 16;
    String direction = "";
    KeyHandler keyHandelr;
    public int score = 0;

    public Player(KeyHandler keyHandler) {
        this.keyHandelr = keyHandler;
    }



    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.YELLOW);
        g2d.fillOval(1,1,12,12);

    }
}

