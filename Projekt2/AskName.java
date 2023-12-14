package Projekt2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static Projekt2.HighscoreList.scores;

public class AskName extends JFrame implements ActionListener {

    JButton jButton;
    JTextField jTextField;
    public AskName(){


        JLabel jLabel = new JLabel("WHAT IS YOUR NAME");
        jLabel.setFont(new Font("Bauhaus 93",Font.BOLD,20));
        jLabel.setForeground(Color.YELLOW);
        jLabel.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
        jLabel.setBounds(200,210,200,80);
        jLabel.setOpaque(false);
        this.add(jLabel);

        jTextField = new JTextField();
        jTextField.setFont(new Font("Bauhaus 93",Font.BOLD,20));
        jTextField.setForeground(Color.YELLOW);
        jTextField.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
        jTextField.setBounds(400,210,200,80);
        jTextField.setOpaque(false);
        this.add(jTextField);

        jButton = new JButton("END GAME");
        jButton.setFont(new Font("Bauhaus 93",Font.BOLD,20));
        jButton.setForeground(Color.YELLOW);
        jButton.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
        jButton.setOpaque(false);
        jButton.setBounds(300,290,200,80);
        jButton.addActionListener(this);
        jButton.setBackground(Color.BLACK);
        this.add(jButton);


        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.BLACK);
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton){
            scores.add(getName());
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
    public String getName(){
        return jTextField.getText();
    }
}
