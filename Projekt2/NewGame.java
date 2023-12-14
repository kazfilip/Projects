package GUI.Projekt2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame extends JFrame implements ActionListener {
    JButton jButton;
    JTextField widthInput,heightInput;
    public NewGame(){
        this.getContentPane().setBackground(Color.BLACK);

        JLabel width = new JLabel( "Select game width from 10 to 100:");
        width.setForeground(Color.yellow);
        width.setFont(new Font("Bauhaus 93",Font.BOLD,15));
        this.add(width);
        width.setBounds(400,400,300,80);
        widthInput = new JTextField();
        this.add(widthInput);
        widthInput.setBounds(700,400,200,80);
        width.setOpaque(false);
        width.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
        widthInput.setOpaque(false);
        widthInput.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
        widthInput.setForeground(Color.yellow);
        widthInput.setFont(new Font("Bauhaus 93",Font.BOLD,15));


        JLabel height = new JLabel("Select game height from 10 to 100:");
        height.setForeground(Color.yellow);
        height.setFont(new Font("Bauhaus 93",Font.BOLD,15));
        this.add(height);
        height.setBounds(400,500,300,80);
        heightInput = new JTextField();
        this.add(heightInput);
        heightInput.setBounds(700,500,200,80);
        heightInput.setOpaque(false);
        height.setOpaque(false);
        height.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
        heightInput.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
        heightInput.setFont(new Font("Bauhaus 93",Font.BOLD,15));
        heightInput.setForeground(Color.yellow);


        jButton = new JButton("Start Game");
        jButton.setBounds(1200,800,200,80);
        jButton.addActionListener(this);
        jButton.setBackground(Color.black);
        jButton.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
        jButton.setFont(new Font("Bauhaus 93",Font.BOLD,15));
        jButton.setForeground(Color.yellow);
        jButton.setFocusable(false);

        this.add(jButton);
        this.setSize(1500,1000);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton){
            String inputX = widthInput.getText();
            int sizeX = Integer.parseInt(inputX);

            String inputY = heightInput.getText();
            int sizeY = Integer.parseInt(inputY);

            this.dispose();

            JFrame jFrame = new JFrame();
            GamePanel gamePanel = new GamePanel(sizeX,sizeY);
            jFrame.add(gamePanel);
            jFrame.pack();
            jFrame.setVisible(true);
            jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            jFrame.setLocationRelativeTo(null);
            gamePanel.startGameThread();
        }
    }
}
