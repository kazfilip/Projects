package Projekt2;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class HighscoreList  extends JList<String>{

    public static Vector<String> scores;
    int score;
    String player;
    public HighscoreList() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Filip\\OneDrive\\Pulpit\\plik.txt"));
        player = bufferedReader.readLine();


        String playerScore = player.replaceAll("[^0-9]", "");
        score = Integer.parseInt(playerScore);




        System.out.println(score);
        scores = new Vector<>();
        scores.add(player);
        this.setListData(scores);
        this.setVisible(true);



    }
}
