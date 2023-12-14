package Projekt2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class GameFrame extends JFrame implements ActionListener {
    JButton jButton,jButton2,jButton3;
    public GameFrame() throws IOException {

        jButton = new JButton("New Game");
        jButton.setBounds(600,300,200,80);
        jButton2 = new JButton("Highscores");
        jButton2.setBounds(600,400,200,80);
        jButton3 = new JButton("Exit");
        jButton3.setBounds(600,500,200,80);

        jButton.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);

        this.add(jButton);
        this.add(jButton2);
        this.add(jButton3);

        jButton.setBackground(Color.BLACK);
        jButton2.setBackground(Color.BLACK);
        jButton3.setBackground(Color.BLACK);


        jButton.setFocusable(false);
        jButton.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
        jButton2.setFocusable(false);
        jButton2.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
        jButton3.setFocusable(false);
        jButton3.setBorder(BorderFactory.createLineBorder(Color.yellow,5));



        jButton.setFont(new Font("Bauhaus 93",Font.BOLD,20));
        jButton2.setFont(new Font("Bauhaus 93",Font.BOLD,20));
        jButton3.setFont(new Font("Bauhaus 93",Font.BOLD,20));
        jButton.setForeground(Color.YELLOW);
        jButton2.setForeground(Color.YELLOW);
        jButton3.setForeground(Color.YELLOW);


        this.getContentPane().setBackground(Color.BLACK);
        this.setLayout(null);
        this.setSize(1500,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        shortcut(this);

    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jButton){
            this.dispose();
            NewGame newGame = new NewGame();
            System.out.println("new game");
        }
        if (e.getSource() == jButton2){
            this.dispose();
            try {
                Highscore highscore = new Highscore();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("highscores");
        }
        if (e.getSource() == jButton3){
            this.dispose();
            System.exit(0);
            System.out.println("exit");
        }
    }
    public void shortcut(JFrame jFrame){
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher((KeyEvent e) -> {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (e.isControlDown() && e.isShiftDown() && (e.getKeyCode() == KeyEvent.VK_Q)) {

                    this.dispose();
                    System.exit(0);

                }
            }
            return false;
        });
    }

}
