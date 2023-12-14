package GUI.Projekt2.Entity;

import javax.swing.*;
import java.awt.*;

public class Enemy extends JLabel {
    public int x,y;
    public int speed;
    public boolean terrified = false;


    public Enemy(){

    }
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.RED);
        g2d.fillOval(1,1,12,12);
    }
    public boolean terrified(){

        return terrified;
    }
}
