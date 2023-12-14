package Projekt2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Highscore extends JFrame implements ActionListener {
    JButton exit;
    public Highscore() throws IOException {

        this.setSize(1500,1000);

        exit = new JButton("GO TO MENU");
        exit.addActionListener(this);
        exit.setBounds(1200,800,200,80);
        exit.setFocusable(false);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.YELLOW);
        exit.setFont(new Font("Bauhaus 93",Font.BOLD,15));
        exit.setBorder(BorderFactory.createLineBorder(Color.yellow,5));

        this.getContentPane().setBackground(Color.BLACK);
        this.add(exit);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        HighscoreList highscoreList = new HighscoreList();
        highscoreList.setPreferredSize(new Dimension(200,300));
        highscoreList.setBackground(Color.BLACK);
        highscoreList.setLocation(200,200);
        highscoreList.setFont(new Font("Bauhaus 93",Font.BOLD,25));
        highscoreList.setForeground(Color.YELLOW);

        this.add(highscoreList);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==  exit){
            this.dispose();
            SwingUtilities.invokeLater(() -> {
                try {
                    new GameFrame();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }
}
